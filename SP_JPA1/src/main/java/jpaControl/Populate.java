/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControl;

import entity.Customer;
import facade.Facade;
import facade.FacadeInterface;

/**
 *
 * @author Sanox
 */
public class Populate {
    
    
    public static void main(String[] args) {
        
           FacadeInterface f = new Facade("SP_JPA1");
           
           f.createCustomer("John", "123@fakeEmail.com");
           f.createCustomer("Bort", "456@fakeEmail.com");
           f.createCustomer("Cloud", "789@fakeEmail.com");
           
           Customer cos = f.findCustomer(1L);
           f.createOrder(cos);
        
    }
    
}
