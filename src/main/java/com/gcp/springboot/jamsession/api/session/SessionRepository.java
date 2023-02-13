package com.gcp.springboot.jamsession.api.session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface SessionRepository extends JpaRepository<Session, Long> {
}
