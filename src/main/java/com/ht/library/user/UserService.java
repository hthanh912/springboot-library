package com.ht.library.user;

import com.ht.library.user.dto.UserDetailDTO;
import com.ht.library.user.dto.UserPatchRequest;

import java.io.IOException;

public interface UserService {
  UserDetailDTO getUser(String username);
  UserDetailDTO updateUser(String username, UserPatchRequest userPatchRequest) throws IOException;
}
