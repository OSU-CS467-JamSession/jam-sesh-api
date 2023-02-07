package com.gcp.springboot.jamsession.api.user;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findByExperienceGreaterThanEqual(Integer experience);
    public List<User> findByInstrumentsId(Long id);
    public List<User> findByGenresId(Long id);
    public List<User> findByLocationZipcode(Integer zipcode);
}
