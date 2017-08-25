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

/**
 *
 * @author Sanox
 */
public interface FacadeInterface {
    
    public Customer createCustomer(String name, String Email);
    public Customer findCustomer(Long ID);
    public Collection<Customer> getAllCustomers();
    public CustomerOrder createOrder(Customer cos);
    public CustomerOrder findOrder(Long id);
    public ItemType createItemType(String description, String name, double price);
    public OrderLine createOrderLine();
    public double findTotalPriceOfOrder();
    
    
    
}
