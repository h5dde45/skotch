package ru.project.objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.project.dao.interfaces.BookDao;
import ru.project.entities.Author;
import ru.project.entities.Book;

import java.util.List;

@Component
@Scope("singleton")
public class LibraryFacade {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private SearchCriteria searchCriteria;

    private List<Book> books;

    public List<Book> getBooks() {
        if(books==null){
            books=bookDao.getBooks();
        }
        return books;
    }

    public void searchBooksByGenre(){
        books=bookDao.getBooks(searchCriteria.getGenre());
    }
    public void  searchBooksByText(){
        switch (searchCriteria.getSearchType()){
            case AUTHOR:
                books=bookDao.getBooks(new Author(searchCriteria.getText()));
                break;
            case TITLE:
                books=bookDao.getBooks(searchCriteria.getText());
        }
    }
}
