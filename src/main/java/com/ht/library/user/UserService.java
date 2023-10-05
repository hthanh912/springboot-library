package com.ht.library.user;

import com.ht.library.user.dto.UserDetailResponse;
import com.ht.library.user.dto.UserPatchRequest;

import java.io.IOException;

public interface UserService {
  UserDetailResponse getUser(String username);
  UserDetailResponse updateUser(String username, UserPatchRequest userPatchRequest) throws IOException;
}
