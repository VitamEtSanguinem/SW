package book;

import book.model.Book;
import com.google.inject.persist.Transactional;
import jpa.GenericJpaDao;

import javax.persistence.NoResultException;
import java.util.Optional;

public class BookDao extends GenericJpaDao<Book> {
    @Transactional
    Optional<Book> findByIsbn13(String isbn13){
        try {
            return Optional.of(entityManager.createQuery("SELECT b from Book b WHERE b.isbn13=isbn13", Book.class)
            .setParameter("isbn13", isbn13)
            .getSingleResult()); }
        catch (NoResultException exception){
            return Optional.empty();
        }

    }
}
