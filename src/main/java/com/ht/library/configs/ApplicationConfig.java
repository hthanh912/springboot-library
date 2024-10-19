package com.ht.library.configs;

import com.ht.library.book.Book;
import com.ht.library.book.dto.BookDetailResponse;
import com.ht.library.book.dto.BookResponse;
import com.ht.library.book.dto.BookView;
import com.ht.library.configs.cloudinary.CloudinaryConfig;
import com.ht.library.user.User;
import com.ht.library.user.UserRepository;
import com.ht.library.user.dto.UserDetailResponse;
import com.ht.library.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

  private final UserRepository repository;

  @Bean
  public UserDetailsService userDetailsService() {
    return username -> repository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }

  @Bean
  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userDetailsService());
    authenticationProvider.setPasswordEncoder(passwordEncoder());
    return authenticationProvider;
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)
      throws Exception {
    return configuration.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();

    modelMapper.getConfiguration()
        .setMatchingStrategy(MatchingStrategies.STRICT);

    modelMapper.typeMap(User.class, UserResponse.class)
        .addMappings(mapper -> {
          mapper.using(CloudinaryConfig.convertPublicIdToUrl(CloudinaryConfig.SMALL_WIDTH));
          mapper.map(User::getAvatarUrl, UserResponse::setAvatarUrl);
        });

    modelMapper.typeMap(User.class, UserDetailResponse.class)
        .addMappings(mapper -> {
          mapper.using(CloudinaryConfig.convertPublicIdToUrl(CloudinaryConfig.MEDIUM_WIDTH));
          mapper.map(User::getAvatarUrl, UserDetailResponse::setAvatarUrl);
        });

    modelMapper.typeMap(Book.class, BookResponse.class)
        .addMappings(mapper -> {
          mapper.using(CloudinaryConfig.convertPublicIdToUrl(CloudinaryConfig.SMALL_WIDTH));
          mapper.map(Book::getCoverUrl, BookResponse::setCoverUrl);
        });

    modelMapper.typeMap(BookView.class, BookResponse.class)
        .addMappings(mapper -> {
          mapper.using(CloudinaryConfig.convertPublicIdToUrl(CloudinaryConfig.SMALL_WIDTH));
          mapper.map(BookView::getCoverUrl, BookResponse::setCoverUrl);
        });

    modelMapper.typeMap(BookView.class, BookDetailResponse.class)
        .addMappings(mapper -> {
          mapper.using(CloudinaryConfig.convertPublicIdToUrl(CloudinaryConfig.MEDIUM_WIDTH));
          mapper.map(BookView::getCoverUrl, BookDetailResponse::setCoverUrl);
        });

    modelMapper.typeMap(Book.class, BookDetailResponse.class)
        .addMappings(mapper -> {
          mapper.using(CloudinaryConfig.convertPublicIdToUrl(CloudinaryConfig.MEDIUM_WIDTH));
          mapper.map(Book::getCoverUrl, BookDetailResponse::setCoverUrl);
        });

    return modelMapper;
  }
}
