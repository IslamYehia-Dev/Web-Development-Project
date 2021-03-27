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
public class Product {
    
    public int id ;
    public String name ;
    public int quantity ;
    public double price ;
    public String cat_id ;
    public int cat_no;
    public int orderedQuantity=1;
    public String img ;
    public Product()
    {
    id = 0 ;
    name = "";
    quantity=0;
    price=0;
    cat_id="";
    img="";
    }
    public Product(int i , String n , int q , double p , String cid , String im)
    {
    id = i ;
    name =n;
    quantity=q;
    price=p;
    cat_id=cid;
    img=im;
    }    
    
}
