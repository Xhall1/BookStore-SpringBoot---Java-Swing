package xl.book_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xl.book_store.model.Book;

public interface RepositoryBook extends JpaRepository<Book, Integer> {
}
