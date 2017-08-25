package entity;

import entity.CustomerOrder;
import entity.ItemType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-25T14:32:14")
@StaticMetamodel(OrderLine.class)
public class OrderLine_ { 

    public static volatile SingularAttribute<OrderLine, ItemType> item;
    public static volatile SingularAttribute<OrderLine, Integer> Quantity;
    public static volatile SingularAttribute<OrderLine, Long> id;
    public static volatile SingularAttribute<OrderLine, CustomerOrder> order;

}