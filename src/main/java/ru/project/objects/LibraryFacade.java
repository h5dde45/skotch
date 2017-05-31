package ru.project.objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.dao.interfaces.BookDao;
import ru.project.entities.Book;

import java.util.List;

@Component
public class LibraryFacade {
    private BookDao bookDao;

    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
        books=bookDao.getBooks();
    }
}
