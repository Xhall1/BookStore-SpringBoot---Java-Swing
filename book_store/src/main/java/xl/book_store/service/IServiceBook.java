package xl.book_store.service;

import xl.book_store.model.Book;

import java.util.List;

public interface IServiceBook {
    public List<Book> listBooks();

    public Book searchIdBook(Integer idBook);

    public void saveBook(Book book);

    public void deleteBook(Book book);
}
