package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
public class BookRepository implements ProjectRepository<Book> {
    private final Logger logger = Logger.getLogger(BookRepository.class);
    private ApplicationContext context;
//    private final List<Book> repo = new ArrayList<>();
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public BookRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> retrieveAll() {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books", (ResultSet rs, int rowNum) ->{
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setAuthor(rs.getString("author"));
            book.setTitle(rs.getString("title"));
            book.setSize(rs.getInt("size"));
            return book;
        });
        return new ArrayList<>(books);
    }

    @Override
    public void store(Book book) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("author", book.getAuthor());
        parameterSource.addValue("title", book.getTitle());
        parameterSource.addValue("size", book.getSize());
        jdbcTemplate.update("INSERT INTO books(author, title, size) VALUES(:author, :title, :size)", parameterSource);
        logger.info("store new book: " + book);
    }

    @Override
    public boolean removeItemById(Integer bookIdToRemove) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", bookIdToRemove);
        jdbcTemplate.update("DELETE FROM books WHERE id = :id", parameterSource);
        logger.info("book " + bookIdToRemove.toString() + " deleted");
        return true;
    }

    @Override
    public boolean removeItemByRegex(String bookRegexToRemove) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("regex", bookRegexToRemove);
        Pattern pattern = Pattern.compile(bookRegexToRemove);
        for (Book book : retrieveAll()) {
           Matcher authorMatcher = pattern.matcher(book.getAuthor());
           Matcher titleMatcher = pattern.matcher(book.getTitle());
           Matcher sizeMatcher = pattern.matcher(book.getSize().toString());
           if(authorMatcher.find()){
               jdbcTemplate.update("DELETE FROM books WHERE author REGEXP :regex", parameterSource);
           } else if (titleMatcher.find()) {
               jdbcTemplate.update("DELETE FROM books WHERE title REGEXP :regex", parameterSource);
           } else if (sizeMatcher.find()) {
               jdbcTemplate.update("DELETE FROM books WHERE size REGEXP :regex", parameterSource);
           } else {
               logger.info("book not found");
           }
        }
        logger.info("book deleted by #" + bookRegexToRemove + "# deleted");
        return true;
    }
    @Override
    public boolean removeItemBySize(Integer bookSize) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("size", bookSize);
        jdbcTemplate.update("DELETE FROM books WHERE size = :size", parameterSource);
        logger.info("book " + bookSize.toString() + " deleted");
        return true;
    }
}
