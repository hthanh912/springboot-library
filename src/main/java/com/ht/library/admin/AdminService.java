package com.ht.library.admin;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ht.library.author.Author;
import com.ht.library.author.AuthorService;
import com.ht.library.award.Award;
import com.ht.library.award.AwardService;
import com.ht.library.book.*;
import com.ht.library.award.Designation;
import com.ht.library.configs.cloudinary.CloudinaryConfig;
import com.ht.library.configs.cloudinary.FileUpload;
import com.ht.library.genre.Genre;
import com.ht.library.genre.GenreService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static com.ht.library.utils.CommonUtils.convertToIntegerArray;
import static com.ht.library.utils.CommonUtils.removeRedundantSpaces;
import static com.ht.library.utils.DateTimeUtils.parseToLocalDateTime;
import static com.ht.library.utils.DateTimeUtils.timestampToLocalDateTime;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final GenreService genreService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BookAwardService bookAwardService;
    private final AwardService awardService;
    private final FileUpload fileUpload;

    Gson gson = new Gson();

    @Transactional
    public void importJLData() {
        String booksJLFilePath = "src/main/resources/jldata/book_best_001_002.jl";
        String authorJLFilePath = "src/main/resources/jldata/author_best_001_002.jl";

        // Read and import Authors
        readAndImportAuthorsData(authorJLFilePath);

        // Read and import Books & Award
        readAndImportBooksData(booksJLFilePath);
    }

    private void readAndImportBooksData(String filePath) {
        Gson gson = new Gson();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                JsonObject jsonObject = gson.fromJson(line, JsonObject.class);
                Book book = new Book();

                JsonElement id = jsonObject.get("id");
                JsonElement goodreadUrl = jsonObject.get("goodreadUrl");
                JsonElement title = jsonObject.get("title");
                JsonElement titleComplete = jsonObject.get("titleComplete");
                JsonElement description = jsonObject.get("description");
                JsonElement imageUrl = jsonObject.get("imageUrl");
                JsonElement genres = jsonObject.get("genres");
                JsonElement asin = jsonObject.get("asin");
                JsonElement isbn = jsonObject.get("isbn");
                JsonElement isbn13 = jsonObject.get("isbn13");
                JsonElement publisher = jsonObject.get("publisher");
                JsonElement series = jsonObject.get("series");
                JsonElement author = jsonObject.get("author");
                JsonElement publishDate = jsonObject.get("publishDate");
                JsonElement characters = jsonObject.get("characters");
                JsonElement places = jsonObject.get("places");
                JsonElement ratingHistogram = jsonObject.get("ratingHistogram");
                JsonElement averageRating = jsonObject.get("avgRating");
                JsonElement ratingsCount = jsonObject.get("ratingsCount");
                JsonElement reviewsCount = jsonObject.get("reviewsCount");
                JsonElement numPages = jsonObject.get("numPages");
                JsonElement language = jsonObject.get("language");
                JsonElement awards = jsonObject.get("awards");

                if (id != null) {
                    book.setId(id.getAsInt());
                }

                if (goodreadUrl != null) {
                    book.setGoodreadUrl(goodreadUrl.getAsString());
                }

                if (title != null) {
                    book.setTitle(title.getAsString());
                }

                if (titleComplete != null) {
                    book.setTitleComplete(titleComplete.getAsString());
                }

                if (description != null) {
                    book.setDescription(description.getAsString());
                }

                if (imageUrl != null && id != null) {
                    book.setImageUrl(imageUrl.getAsString());
                    new Thread(() -> {
                        try {
                            fileUpload.uploadFile(
                                    imageUrl.getAsString(),
                                    id.getAsString(),
                                    CloudinaryConfig.FOLDER.books.toString(),
                                    null);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }).start();
                }

                if (genres != null) {
                    for (JsonElement element :genres.getAsJsonArray()) {
                        Optional<Genre> genre = genreService.findByName(element.getAsString());
                        if (genre.isPresent()) {
                             book.getGenres().add(genre.get());
                        } else {
                            book.getGenres().add(insertGenre(element.getAsString()));
                        }
                    }
                }

                if (asin != null) {
                    book.setAsin(asin.getAsString());
                }

                if (isbn != null) {
                    book.setIsbn(isbn.getAsString());
                }

                if (isbn13 != null) {
                    book.setIsbn13(isbn13.getAsString());
                }

                if (publisher != null) {
                    book.setPublisher(publisher.getAsString());
                }

                if (series != null) {
                    List<String> list = new ArrayList<>();
                    for (JsonElement object: series.getAsJsonArray()) {
                        list.add(object.getAsString());
                    }
                    book.setSeries(list);
                }

                if (author != null) {
                    for (JsonElement object: author.getAsJsonArray()) {
                        Optional<Author> a = authorService.getAuthorEntityById(object.getAsInt());
                        if (a.isPresent()) {
                            book.getAuthors().add(a.get());
                            a.get().getBooks().add(book);
                        }
                    }
                }

                if (publishDate != null) {
                    book.setPublishDate(parseToLocalDateTime(publishDate.getAsString()));
                }

                if (characters != null) {
                    List<String> list = new ArrayList<>();
                    for (JsonElement object: characters.getAsJsonArray()) {
                        list.add(object.getAsString());
                    }
                    book.setCharacters(list);
                }

                if (places != null) {
                    List<String> list = new ArrayList<>();
                    for (JsonElement object: places.getAsJsonArray()) {
                        list.add(object.getAsString());
                    }
                    book.setPlaces(list);
                }

                if (ratingHistogram != null) {
                    book.setRatingHistogram(convertToIntegerArray(ratingHistogram.toString()));
                }

                if (averageRating != null) {
                    book.setAverageRating(averageRating.getAsFloat());
                }

                if (ratingsCount != null) {
                    book.setRatingsCount(ratingsCount.getAsInt());
                }

                if (reviewsCount != null) {
                    book.setReviewsCount(reviewsCount.getAsInt());
                }

                if (numPages != null) {
                    book.setNumPages(numPages.getAsInt());
                }

                if (language != null) {
                    book.setLanguage(language.getAsString());
                }

                var insertedBook = bookService.insertBook(book);

                if (awards != null) {
                    for (JsonElement object: awards.getAsJsonArray()) {

                        var awardId = object.getAsJsonObject().get("id") != null ?
                                object.getAsJsonObject().get("id").getAsInt() : null;

                        var awardName = object.getAsJsonObject().get("name") != null ?
                                object.getAsJsonObject().get("name").getAsString() : null;

                        var awardedAt = !object.getAsJsonObject().get("awardedAt").isJsonNull() ?
                                timestampToLocalDateTime(object.getAsJsonObject().get("awardedAt").getAsString()) : null;

                        var category = !object.getAsJsonObject().get("category").isJsonNull() ?
                                !object.getAsJsonObject().get("category").getAsString().isEmpty()
                                        ? object.getAsJsonObject().get("category").getAsString() : null
                                : null;

                        var designation = object.getAsJsonObject().get("designation") != null ?
                                Designation.valueOf(object.getAsJsonObject().get("designation").getAsString()) : null;

                        Optional<Award> award = awardService.getAwardById(awardId);

                        BookAward bookAward;
                        if (award.isEmpty()) {
                            var insertedAward = awardService.insertAward(new Award(awardId, awardName));
                            bookAward = new BookAward(insertedBook, insertedAward, designation, awardedAt, category);
                        } else {
                            bookAward = new BookAward(insertedBook, award.get(), designation, awardedAt, category);
                        }

                        bookAwardService.insertBookAward(bookAward);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readAndImportAuthorsData(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                JsonObject jsonObject = gson.fromJson(line, JsonObject.class);
                Author author = new Author();

                JsonElement id = jsonObject.get("id");
                JsonElement name = jsonObject.get("name");
                JsonElement birthDate = jsonObject.get("birthDate");
                JsonElement deathDate = jsonObject.get("deathDate");
                JsonElement avgRating = jsonObject.get("avgRating");
                JsonElement reviewsCount = jsonObject.get("reviewsCount");
                JsonElement ratingsCount = jsonObject.get("ratingsCount");
                JsonElement about = jsonObject.get("about");
                JsonElement imageUrl = jsonObject.get("imageUrl");
                JsonElement genres = jsonObject.get("genres");
                JsonElement influences = jsonObject.get("influences");

                if (id != null) {
                    author.setId(id.getAsInt());
                }

                if (name != null) {
                    author.setName(name.getAsString());
                }

                if (birthDate != null) {
                    author.setBirthDate(parseToLocalDateTime(birthDate.getAsString()));
                }

                if (deathDate != null) {
                    author.setDeathDate(parseToLocalDateTime(deathDate.getAsString()));
                }

                if (avgRating != null) {
                    author.setAvgRating(avgRating.getAsFloat());
                }

                if (reviewsCount != null) {
                    author.setReviewsCount(reviewsCount.getAsInt());
                }

                if (ratingsCount != null) {
                    author.setRatingsCount(ratingsCount.getAsInt());
                }

                if (about != null) {
                    author.setAbout(about.getAsString());
                }

                if (imageUrl != null && id != null) {
                    new Thread(() -> {
                        try {
                            fileUpload.uploadFile(imageUrl.getAsString(), id.getAsString(), CloudinaryConfig.FOLDER.authors.toString(), null);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }).start();
                }

                if (genres != null) {
                    for (JsonElement element :genres.getAsJsonArray()) {
                        Optional<Genre> genre = genreService.findByName(element.getAsString());
                        if (genre.isPresent()) {
                            author.getGenres().add(genre.get());
                        } else {
                            author.getGenres().add(insertGenre(element.getAsString()));
                        }
                    }
                }

                if (influences != null) {
                    for (JsonElement element :influences.getAsJsonArray()) {
                        Optional<Author> influence = authorService.getAuthorEntityById(element.getAsInt());
                        influence.ifPresent(i -> {
                            author.getInfluences().add(i);
                        });
                    }
                }

                authorService.insertAuthor(author);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Genre insertGenre(String genreName) {
        String genreId = removeRedundantSpaces(genreName).toLowerCase().replaceAll("[^a-z0-9]+", "_");
        Genre genre = Genre.builder().id(genreId).name(genreName).build();
        return genreService.insertGenre(genre);
    }

}
