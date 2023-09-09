package com.ht.library.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

  @Query("SELECT u FROM User u WHERE u.username = :username")
  public Optional<User> findByUsername(@Param("username") String username);

}