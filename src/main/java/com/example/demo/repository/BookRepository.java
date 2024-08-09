package com.example.demo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class BookRepository {
    @PersistenceContext
 private final EntityManager em;


//  @Autowired
//  public BookRepository(EntityManager em) {
//      this.em = em;
//  }

    
    public Book insertBook(Book book) {
       
            
            em.persist(book);
            em.close();
            return book;
    
           
        
    }


    public Book selectBookById(UUID id) {
        try {
            em.getTransaction().begin();
           Book book= em.find(Book.class, id);
            em.getTransaction().commit();
            return book;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }


    public Object selectAllBooks() {
        
            em.getTransaction().begin();
            // Use JPQL to select all Book entities
            List<Book> books = em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
            em.close();
            return books; 
        }    


    public List<?> selectBookByTitle(String title) {
        
            em.getTransaction().begin();
            // Use JPQL with LIKE for partial matching
            String jpql = "SELECT b FROM Book b WHERE b.title LIKE :title";
            List<Book> books = em.createQuery(jpql, Book.class)
                                 .setParameter("title", "%" + title + "%")
                                 .getResultList();
            em.close();
            return books;
    }

    public Book deleteBookById(UUID id) {
        Book b1 = em.find(Book.class,id);
        em.remove(b1);
        return b1;
    }

    public Book updateBookById(Book book) {
       
            em.getTransaction().begin();
            // Find the existing book by ID
            Book b1 = em.find(Book.class, book.getId());
                b1.setTitle(book.getTitle());
                b1.setDescription(book.getDescription());
                b1.setAuthor(book.getAuthor());
                b1.setPublicationYear(book.getPublicationYear());
                em.merge(b1);
                em.getTransaction().commit();
                em.close();
            return b1;
        
            
        }
    }

