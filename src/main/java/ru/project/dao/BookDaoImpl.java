package ru.project.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.project.entities.Author;
import ru.project.entities.Book;
import ru.project.entities.Genre;

import java.util.List;

@Component
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    private List<Book> books;

    @Transactional
    @Override
    public List<Book> getBooks() {
        books = (List<Book>) sessionFactory.getCurrentSession()
                .createCriteria(Book.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();

        return books;
    }

    @Override
    public List<Book> getBooks(Author author) {
        return null;
    }

    @Override
    public List<Book> getBooks(Genre genre) {
        return null;
    }
}
