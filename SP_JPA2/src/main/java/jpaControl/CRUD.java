/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControl;

import entity.Book;
import entity.EBook;
import entity.PaperBook;
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

    
    public EBook findEBook(int isbn) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(EBook.class, isbn);
        } finally {
            em.close();
        }
    }

    public EBook editEBook(EBook ebook) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            ebook = em.merge(ebook);
            em.getTransaction().commit();
            return ebook;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroyEBook(int isbn) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Book book = null;
            book = em.getReference(Book.class, isbn);
            book.getIsbn();
            em.remove(book);
            em.getTransaction().commit();
        } finally {
            em.close();

        }
    }
    
     public void createPBook(int isbn, int instock, double shippingweight) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            PaperBook pbook = new PaperBook();
            pbook.setInStock(instock);
            pbook.setShippingWeight(shippingweight);
            Book b = findBook(isbn);
            if (b != null) {
                pbook.setIsbn(b.getIsbn());
                em.persist(pbook);
                em.getTransaction().commit();
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Book findPBook(int isbn) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(PaperBook.class, isbn);
        } finally {
            em.close();
        }
    }

    public Book editPBook(PaperBook book) {
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

    public void destroyPBook(int isbn) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Book book = null;
            book = em.getReference(PaperBook.class, isbn);
            book.getIsbn();
            em.remove(book);
            em.getTransaction().commit();
        } finally {
            em.close();

        }
    }
}
