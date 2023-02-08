package com.gcp.springboot.jamsession.api.genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
