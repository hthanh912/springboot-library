package com.ht.library.admin;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ht.library.author.Author;
import com.ht.library.author.AuthorService;
import com.ht.library.genre.Genre;
import com.ht.library.genre.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.ht.library.utils.CommonUtils.removeRedundantSpaces;
import static com.ht.library.utils.DateTimeUtils.parseToLocalDateTime;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final GenreService genreService;
    private final AuthorService authorService;

    public void importJLData() {
        String booksJLFilePath = "src/main/resources/jldata/book_mistery_001_001.jl";
        String authorJLFilePath = "src/main/resources/jldata/author_mistery_001_001.jl";

        // Read and import Genres
        readAndImportGenresData(booksJLFilePath);
        readAndImportGenresData(authorJLFilePath);

        // Read and import Authors
        readAndImportAuthorsData(authorJLFilePath);

        // Read and import Books
        readAndImportBooksData(booksJLFilePath);

    }

    private void readAndImportBooksData(String filePath) {
        Gson gson = new Gson();

    }

    private void readAndImportAuthorsData(String filePath) {
        Gson gson = new Gson();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                JsonObject jsonObject = gson.fromJson(line, JsonObject.class);
                Author author = new Author();

                JsonElement id = jsonObject.get("id");
                JsonElement goodreadUrl = jsonObject.get("goodreadUrl");
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

                if (goodreadUrl != null) {
                    author.setGoodreadUrl(goodreadUrl.getAsString());
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

                if (imageUrl != null) {
                    author.setImageUrl(imageUrl.getAsString());
                }

                if (genres != null) {
                    List<Genre> listGenre = new ArrayList<>();
                    for (JsonElement element :genres.getAsJsonArray()) {
                        Optional<Genre> genre = genreService.findByName(element.getAsString());
                        genre.ifPresent(listGenre::add);
                    }
                    author.setGenres(listGenre);
                }

                if (influences != null) {
                    List<Author> listAuthor = new ArrayList<>();
                    for (JsonElement element :influences.getAsJsonArray()) {
                        Optional<Author> influence = authorService.getAuthorEntityById(element.getAsInt());
                        influence.ifPresent(listAuthor::add);
                    }
                    author.setInfluences(listAuthor);
                }

                authorService.insertAuthor(author);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readAndImportGenresData(String filePath) {
        Gson gson = new Gson();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Read and import genre
                JsonObject jsonObject = gson.fromJson(line, JsonObject.class);
                if (jsonObject.get("genres") != null) {
                    for (JsonElement genreJson : jsonObject.get("genres").getAsJsonArray()) {
                        String genreName = genreJson.getAsString();
                        String genreId = removeRedundantSpaces(genreName).toLowerCase().replaceAll("[^a-z0-9]+", "_");

                        if (!genreService.isGenreExistById(genreId)) {
                            Genre genre = Genre.builder().id(genreId).name(genreName).build();
                            genreService.insertGenre(genre);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
