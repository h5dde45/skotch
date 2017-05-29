package ru.project.dao.interfaces;

import ru.project.entities.Author;
import ru.project.entities.Book;
import ru.project.entities.Genre;

import java.util.List;

public interface BookDao {

    List<Book> getBooks();
    List<Book> getBooks(Author author);
    List<Book> getBooks(Genre genre);
}
