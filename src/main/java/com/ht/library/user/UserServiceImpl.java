package com.ht.library.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

  private final UserRepository repository;

  @Override
  public Optional<User> getUser(String username) {
    return repository.findByUsername(username);
  }

  @Override
  public Optional<User> getUserById(UUID id) {
    return repository.findById(id);
  }
}
