package com.ht.library.user;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
  Optional<User> getUser(String username);
  Optional<User> getUserById(UUID id);
}
