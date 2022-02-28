package com.BookForUs.Books;

import com.BookForUs.Authors.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Books,Integer> {
    @Query(value = "SELECT * FROM books WHERE author =:authorName",nativeQuery = true)
    List<Books>findAllBooksByAuthor(@Param("authorName")Author author);
}
