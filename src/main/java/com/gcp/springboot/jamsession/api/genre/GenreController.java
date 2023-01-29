package com.gcp.springboot.jamsession.api.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GenreController {

    @Autowired
    private GenreService genreService;

    @RequestMapping("/genres")
    public List<Genre> getGenres() {
        return genreService.getGenres();
    }

    @RequestMapping("/genre/{genreId}")
    public Optional<Genre> getGenre(@PathVariable long genreId) {
        return genreService.getGenreById(genreId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/genre")
    public void createGenre(@RequestBody Genre genre) {
        genreService.createGenre(genre);
    }

    @DeleteMapping("/genre/{genreId}")
    public void deleteGenre(@PathVariable long genreId) {
        genreService.deleteGenre(genreId);
    }
}
