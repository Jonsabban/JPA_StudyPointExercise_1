/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Customer;
import entity.ItemType;
import entity.CustomerOrder;
import entity.OrderLine;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Sanox
 */
public class Facade implements FacadeInterface {

    private EntityManagerFactory emf;

    public Facade(String DB) {
        this.emf = Persistence.createEntityManagerFactory(DB);
    }

    @Override
    public Customer createCustomer(String name, String Email) {

        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();    // Start the transaction
            Customer c = new Customer();
            c.setName(name);
            c.setEmail(Email);
            em.persist(c);                 //Insert object

            em.getTransaction().commit();  //Commit the query
            return c;

        } finally {
            em.close();                    //close the transaction
        }

    }

    @Override
    public Customer findCustomer(Long ID) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Customer c = em.find(Customer.class, ID);

            em.getTransaction().commit();
            return c;

        } finally {
            em.close();
        }

    }

    @Override
    public Collection<Customer> getAllCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT c FROM Customer c");

            Collection<Customer> customers = query.getResultList();

            em.getTransaction().commit();
            return customers;

        } finally {
            em.close();
        }
    }

    @Override
    public CustomerOrder createOrder(Customer cos) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            CustomerOrder o = new CustomerOrder();
            o.setCustomer(cos);
            em.persist(o);

            em.getTransaction().commit();
            return o;

        } finally {
            em.close();
        }
    }

    @Override
    public CustomerOrder findOrder(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            CustomerOrder co = em.find(CustomerOrder.class, id);
            em.getTransaction().commit();
            return co;
        } finally {
            em.close();
        }
    }

    @Override
    public ItemType createItemType(String description, String name, double price) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            ItemType item = new ItemType();
            item.setDescription(description);
            item.setName(name);
            item.setPrice(price);
            em.persist(item);

            em.getTransaction().commit();
            return item;

        } finally {
            em.close();
        }
    }

    @Override
    public OrderLine createOrderLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double findTotalPriceOfOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
