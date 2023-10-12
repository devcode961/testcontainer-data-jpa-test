package com.example.demo.testcontainerdatajpatest;

import com.example.demo.testcontainerdatajpatest.entities.Book;
import com.example.demo.testcontainerdatajpatest.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(showSql = false)
@Testcontainers
@ActiveProfiles("test-container-flyway")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // use real database
public class BookRepositoryTest {

    /*
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer("postgres:15-alpine")
            .withDatabaseName("mydb")
            .withUsername("mkyong")
            .withPassword("password");

    @BeforeAll
     static void startContainer() {
        postgreSQLContainer.start();
    }

    @AfterAll
    static void stopContainer() {
        postgreSQLContainer.stop();
    }
*/
    @Autowired
    private BookRepository bookRepository; // @Autowired

    @BeforeEach
    void setUp() {
        bookRepository.deleteAll();
    }

    @Test
    void testShouldGetAll() {
        // given
        Book book = Book.builder()
                .title("Java 11")
                .price(new BigDecimal("19.99"))
                .publishDate(LocalDate.of(2019, 11, 11))
                .build();
        bookRepository.save(book);

        // when
        List<Book> books = bookRepository.findAll();

        // then
        assertThat(books).hasSize(1);
    }


}
