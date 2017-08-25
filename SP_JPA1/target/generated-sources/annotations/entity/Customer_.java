package entity;

import entity.CustomerOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-25T14:32:14")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> Email;
    public static volatile SingularAttribute<Customer, String> name;
    public static volatile ListAttribute<Customer, CustomerOrder> orders;
    public static volatile SingularAttribute<Customer, Long> id;

}