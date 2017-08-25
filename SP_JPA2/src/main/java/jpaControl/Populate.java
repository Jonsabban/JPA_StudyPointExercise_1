package jpaControl;

import entity.Book;
import entity.EBook;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Populate {
    
    public static void main(String[] args) {
        
        CRUD crud = new CRUD("SP_JPA2");
        
        
        Book b = new Book();
        b.setAuthor("HC Andersen");
        b.setTitle("How to wear hats");
        b.setPrice(10);
        crud.createBook(b);
        
        crud.createEBook(1, 200, "Link");
        
    }
    
    
    
}
