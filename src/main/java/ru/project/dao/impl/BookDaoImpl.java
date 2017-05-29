package ru.project.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.project.dao.interfaces.BookDao;
import ru.project.entities.Author;
import ru.project.entities.Book;
import ru.project.entities.Genre;

import java.util.List;

@Component
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    private ProjectionList bookProjection;

    public BookDaoImpl() {
        bookProjection = Projections.projectionList();
        bookProjection.add(Projections.property("id"), "id");
        bookProjection.add(Projections.property("name"), "name");
        bookProjection.add(Projections.property("image"), "image");
        bookProjection.add(Projections.property("descr"), "descr");
        bookProjection.add(Projections.property("author"), "author");
        bookProjection.add(Projections.property("genre"), "genre");

    }

    @Transactional
    @Override
    public List<Book> getBooks() {

        List<Book> books = createBookList(createBookCriteria());

        return books;
    }

    @Override
    public List<Book> getBooks(Author author) {
        List<Book> books=createBookList(createBookCriteria()
                .add(Restrictions.ilike("author.name",author.getName(),MatchMode.ANYWHERE)));
        return books;
    }

    @Override
    public List<Book> getBooks(Genre genre) {
        List<Book> books=createBookList(createBookCriteria()
                .add(Restrictions.ilike("genre.name",genre.getName(),MatchMode.ANYWHERE)));
        return books;
    }

    private DetachedCriteria createBookCriteria() {
        DetachedCriteria bookListCriteria = DetachedCriteria.forClass(Book.class, "b");
        createAliases(bookListCriteria);
        return bookListCriteria;
    }

    private void createAliases(DetachedCriteria criteria) {
        criteria.createAlias("b.author", "author");
        criteria.createAlias("b.genre", "genre");
    }

    private List<Book> createBookList(DetachedCriteria bookListCriteria) {
        Criteria criteria = bookListCriteria.getExecutableCriteria(sessionFactory.getCurrentSession());
        criteria.addOrder(Order.asc("b.name"))
                .setProjection(bookProjection)
                .setResultTransformer(Transformers.aliasToBean(Book.class));
        return criteria.list();
    }
}
