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
public class User {
    public int id ;
    public  String password ;
    public String uname ;
    public String email;
    public boolean type;
    public String birthday ;
    public String job;
    public double credit_Limit;
    public String address;
    public User()
    {
    id =0;
    password ="";
    uname="";
    email="";
    type=false;
    birthday="";
    job="";
    credit_Limit =0;
    address="";
    }
    public User(int i , String p ,String u ,String e,boolean t ,String b,String j, double crl,String ad)
    {
    id =i;
    password =p;
    uname=u;
    email=e;
    type=t;
    birthday=b;
    job=j;
    credit_Limit =crl;
    address=ad;
    }
}
