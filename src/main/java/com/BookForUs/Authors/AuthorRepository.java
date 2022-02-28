package com.BookForUs.Authors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    @Query(value = "SELECT author_id FROM author WHERE author_name = :authorName",
    nativeQuery = true)
    int findAuthorIdByName(@Param("authorName") String authorname);

}
