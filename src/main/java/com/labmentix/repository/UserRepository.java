package com.labmentix.repository;

import com.labmentix.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

   // @Query(value = "select * from User where username=:uname and password=:pwd",nativeQuery = true)
    User findByUsernameAndPassword(String username,String password);

    Optional<User> findByUsername(String username);

    Optional<User> getUserByEmail(String email);
}
