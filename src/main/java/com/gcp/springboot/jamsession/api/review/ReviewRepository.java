package com.gcp.springboot.jamsession.api.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
