// Database Access layer in Java is given the name of the repo.
// A simple repository provides all the basic methods required to
// find, create and delete entries in the database.

package com.gcp.springboot.jamsession.api.user;

import org.springframework.data.repository.CrudRepository;
// Extend CrudRepository and create an interface of it.
// In the params, you have to pass the name of the Java class that you want
// to extend and type of the primary key being passed (<School, Long>).
public interface UserRepository extends CrudRepository<User, Long> {
}
