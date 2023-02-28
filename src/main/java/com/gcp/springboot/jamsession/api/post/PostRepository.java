package com.gcp.springboot.jamsession.api.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface PostRepository extends JpaRepository<Post, Long> {
}
