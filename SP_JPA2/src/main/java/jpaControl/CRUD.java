/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControl;

import entity.Book;
import entity.EBook;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sanox
 */
public class CRUD {

    private EntityManagerFactory emf;

    public CRUD(String DB) {
        this.emf = Persistence.createEntityManagerFactory(DB);
    }

    public void createBook(Book book) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Book findBook(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Book.class, id);
        } finally {
            em.close();
        }
    }

    public Book editBook(Book book) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            book = em.merge(book);
            em.getTransaction().commit();
            return book;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroyBook(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Book book = null;
            book = em.getReference(Book.class, id);
            book.getIsbn();
            em.remove(book);
            em.getTransaction().commit();
        } finally {
            em.close();

        }
    }

    public void createEBook(int isbn, double Size, String URL) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            EBook eb = new EBook();
            eb.setMBSize(Size);
            eb.setURL(URL);
            Book b = findBook(isbn);
            if (b != null) {
                eb.setIsbn(b.getIsbn());
                em.persist(eb);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }

    }
}
