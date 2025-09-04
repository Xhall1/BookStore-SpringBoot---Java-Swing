package xl.book_store.service;

import org.springframework.beans.factory.annotation.Autowired;
import xl.book_store.model.Book;
import xl.book_store.repository.RepositoryBook;

import java.util.List;

public class ServiceBook implements IServiceBook{

    @Autowired
    private RepositoryBook repositoryBook;

    @Override
    public List<Book> listBooks() {
        return repositoryBook.findAll();
    }

    @Override
    public Book searchIdBook(Integer idBook) {
        Book book = repositoryBook.findById(idBook).orElse(null);
        return book;
    }

    @Override
    public void saveBook(Book book) {
        repositoryBook.save(book);
    }

    @Override
    public void deleteBook(Book book) {
        repositoryBook.delete(book);
    }
}
