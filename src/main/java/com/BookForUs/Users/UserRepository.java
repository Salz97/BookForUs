package com.BookForUs.Users;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT p FROM User p WHERE p.email = :email AND p.password = :password")
    User findUser(@Param("email") String email,
                  @Param("password") String password);
}
