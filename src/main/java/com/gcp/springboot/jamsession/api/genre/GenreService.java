package com.gcp.springboot.jamsession.api.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> getGenres() {
        List<Genre> genres = new ArrayList<>();
        genreRepository.findAll()
                .forEach(genres::add);
        return genres;
    }

    public Optional<Genre> getGenreById(Long genre_id) {
        return genreRepository.findById(genre_id);
    }

    public void createGenre(Genre genre) {
        genreRepository.save(genre);
    }

    public void deleteGenre(long genre_id) {
        genreRepository.deleteById(genre_id);
    }
}
