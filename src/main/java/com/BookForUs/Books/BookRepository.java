package com.BookForUs.Books;

import com.BookForUs.Authors.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Books,Integer> {
    @Query(value = "SELECT * FROM books WHERE author =:authorID",nativeQuery = true)
    List<Books>findAllBooksByAuthor(@Param("authorID")int author);

    @Query("SELECT p FROM Book p WHERE p.title =:title")
    Books findBookByName(@Param("title")String title);

    @Query(value="SELECT * FROM books WHERE theme=:theTheme ",nativeQuery = true)
    List<Books>findSimilarBooksWithTheme(@Param("theTheme") int theme);

    @Query(value="SELECT theme FROM books WHERE title =:title",nativeQuery = true)
    int findBookTheme(@Param("title")String title);
}
