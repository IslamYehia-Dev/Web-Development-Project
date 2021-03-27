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
public class Category {

    public String cat_name;
    public int cat_id;

    public Category() {
        cat_id = 0;
        cat_name = "";
    }

    public Category(int i, String s) {
        cat_id = i;
        cat_name = s;
    }
}
