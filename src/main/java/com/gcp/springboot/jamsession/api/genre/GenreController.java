package com.gcp.springboot.jamsession.api.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public class GenreController {

    @Autowired
    private GenreService genreService;
}
