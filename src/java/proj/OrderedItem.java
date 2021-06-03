/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;

/**
 *
 * @author eslam
 */
public class OrderedItem {

    public int quantity;
    public double price;
    public String name;
    public String catName;
    public int item_ID ;
    public   OrderedItem()
    {
    quantity=0 ;
    price=0 ;
    name="";
    catName="";
    item_ID=-1;
    }
    public   OrderedItem(int qu , double pr , String na , String cna,int id )
    {
    quantity=qu ;
    price=pr ;
    name=na;
    catName=cna;
    item_ID =id ;
    }
}
