package com.ht.library.configs;

import com.ht.library.author.Author;
import com.ht.library.author.dto.AuthorDetailResponse;
import com.ht.library.book.Book;
import com.ht.library.book.dto.BookResponse;
import com.ht.library.configs.cloudinary.CloudinaryConfig;
import com.ht.library.quotes.Quote;
import com.ht.library.quotes.dto.QuoteResponse;
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
        .addMappings(mapper -> mapper.map(user -> CloudinaryConfig.getImageUrl(user.getAvatarUrl()), UserResponse::setAvatarUrl));

    modelMapper.typeMap(User.class, UserDetailResponse.class)
            .addMappings(mapper -> {
              mapper.using(CloudinaryConfig.convertPublicIdToUrl);
              mapper.map(User::getAvatarUrl, UserDetailResponse::setAvatarUrl);
            });

    modelMapper.typeMap(Book.class, BookResponse.class)
      .addMappings(
          mapper -> mapper.map(book -> book.getAuthor().getName(), BookResponse::setAuthor)
      );

    modelMapper.typeMap(Author.class, AuthorDetailResponse.class)
        .addMappings(mapper -> {
          mapper.using(CloudinaryConfig.convertPublicIdToUrl);
          mapper.map(Author::getPhotoUrl, AuthorDetailResponse::setPhotoUrl);
        });

    modelMapper.typeMap(Quote.class, QuoteResponse.class)
      .addMappings(
          mapper -> mapper.map(quote -> quote.getBook().getTitle(), QuoteResponse::setBookTitle))
      .addMappings(
          mapper -> mapper.map(quote -> quote.getBook().getId(), QuoteResponse::setBookId))
      .addMappings(
          mapper -> mapper.map(quote -> quote.getBook().getAuthor(), QuoteResponse::setAuthor)
      );

    return modelMapper;
  }
}
