package com.ht.library.user;

import com.ht.library.book.dto.BookResponse;
import com.ht.library.user.dto.UserDetailResponse;
import com.ht.library.user.dto.UserPatchRequest;

import java.io.IOException;
import java.util.List;

public interface UserService {
  UserDetailResponse getUser(String username);
  UserDetailResponse updateUser(String username, UserPatchRequest userPatchRequest) throws IOException;
  List<BookResponse> getUserFavoriteBooks(String username);
  List<BookResponse> getUserReading(String username, ReadingStatus[] readingStatuses);
}
