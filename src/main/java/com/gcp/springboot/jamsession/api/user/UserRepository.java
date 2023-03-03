package com.gcp.springboot.jamsession.api.user;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findByExperienceGreaterThanEqual(Integer experience);
    public List<User> findByInstrumentsId(Long id);
    public List<User> findByGenresId(Long id);
    public List<User> findByLocationZipcode(Integer zipcode);
    public User findByEmail(@Param("email") String email);
}
