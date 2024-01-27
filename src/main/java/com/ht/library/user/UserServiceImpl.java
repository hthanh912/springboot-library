package com.ht.library.user;

import com.cloudinary.Transformation;
import com.ht.library.book.dto.BookResponse;
import com.ht.library.configs.cloudinary.FileUpload;
import com.ht.library.exception.ResourceNotFoundException;
import com.ht.library.user.dto.UserDetailResponse;
import com.ht.library.user.dto.UserPatchRequest;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

  private final UserRepository repository;
  private final FileUpload fileUpload;
  private final ModelMapper mapper;

  @Override
  public UserDetailResponse getUser(String username) {
    User user = repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    return mapper.map(user, UserDetailResponse.class);
  }

  @Override
  public UserDetailResponse updateUser(String username, UserPatchRequest userDto) throws IOException {
    User user = repository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    if (userDto.getFirstName() != null) {
      user.setFirstName(userDto.getFirstName());
    }
    if (userDto.getLastName() != null) {
      user.setLastName(userDto.getLastName());
    }
    if (userDto.getAvatar() != null) {
      String imageURL = fileUpload.uploadFile(userDto.getAvatar(), user.getUsername(), "users",
          Map.of("transformation",
              new Transformation().width(500).height(500).crop("fill").fetchFormat("auto"))
      );
      user.setAvatarUrl(imageURL);
    }
    return mapper.map(repository.save(user), UserDetailResponse.class);
  }

  @Override
  public List<BookResponse> getUserFavoriteBooks(String username) {
    User user = repository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User not found."));
    return user.getUserBooks().stream()
            .filter(UserBook::isFavorite)
            .map(userBook -> mapper.map(userBook.getBook(), BookResponse.class))
            .toList();
  }

  @Override
  public List<BookResponse> getUserReading(String username, ReadingStatus[] readingStatuses) {
    User user = repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    return user.getUserBooks().stream()
            .filter(userBook -> readingStatuses.length == 0
                    ? userBook.getReadingStatus() != null
                    : Arrays.stream(readingStatuses).toList().contains(userBook.getReadingStatus())
            )
            .map(userBook -> mapper.map(userBook.getBook(), BookResponse.class))
            .toList();
  }
}
