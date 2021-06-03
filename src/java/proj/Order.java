/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eslam
 */
public class Order {
    public int billNO;
    public String date;
    public String uname;
    public double total ;
    public List<OrderedItem> orderItems;
    public int orderState ;
    public Order()
    {
    billNO=-1;
    date="";
    uname="";
    total=0;
    orderItems=new ArrayList<>();
    orderState = 0 ;
    
    }
    public Order(int b , String d , String u , double t, List<OrderedItem> oi , int os)
    {
    billNO=b;
    date=d;
    uname=u;
    total=t;
    orderItems=oi;
    orderState = os ;
    
    }
}
