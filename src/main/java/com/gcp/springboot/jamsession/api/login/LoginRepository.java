package com.gcp.springboot.jamsession.api.login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface LoginRepository extends JpaRepository<Login, Long> {
}
