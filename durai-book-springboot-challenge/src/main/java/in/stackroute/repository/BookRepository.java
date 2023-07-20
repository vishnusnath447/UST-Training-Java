package in.stackroute.repository;

import in.stackroute.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    public List<Book> findAllByLanguage(String language);
}
