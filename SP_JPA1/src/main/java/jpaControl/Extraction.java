/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControl;

import entity.Customer;
import facade.Facade;
import facade.FacadeInterface;
import java.util.Collection;

/**
 *
 * @author Sanox
 */
public class Extraction {

    public static void main(String[] args) {
        
        FacadeInterface f = new Facade("SP_JPA1");
        
        Customer c = f.findCustomer(1L);
        System.out.println("*************");
        System.out.println("findCustomer - Name: " + c.getName() + ", Email: " + c.getEmail());
        
        Collection<Customer> allCustomers = f.getAllCustomers();
        System.out.println("*************");
        for (Customer customer : allCustomers) {
            System.out.println("getAllCustomers - Name: " + customer.getName());
        }
    }

}
