package com.gcp.springboot.jamsession.api.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
