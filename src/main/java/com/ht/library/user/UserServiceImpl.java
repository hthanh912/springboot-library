package com.ht.library.user;

import com.ht.library.configs.cloudinary.FileUpload;
import com.ht.library.user.dto.UserDetailDTO;
import com.ht.library.user.dto.UserPatchRequest;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

  private final UserRepository repository;
  private final FileUpload fileUpload;
  private final ModelMapper mapper;

  @Override
  public UserDetailDTO getUser(String username) {
    User user = repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    return mapper.map(user, UserDetailDTO.class);
  }

  @Override
  public UserDetailDTO updateUser(String username, UserPatchRequest userDto) throws IOException {
    User user = repository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    System.out.println(userDto.getFirstName());

    if (userDto.getFirstName() != null) {
      System.out.println(userDto.getFirstName());
      user.setFirstName(userDto.getFirstName());
    }
    if (userDto.getLastName() != null) {
      user.setLastName(userDto.getLastName());
    }
    if (userDto.getAvatar() != null) {
      String imageURL = fileUpload.uploadFile(userDto.getAvatar(), "users");
      user.setAvatarUrl(imageURL);
    }
    return mapper.map(repository.save(user), UserDetailDTO.class);
  }

}
