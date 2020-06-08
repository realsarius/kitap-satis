/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import util.DBConnection;

/**
 *
 * @author pc
 */
public class Category extends DBConnection {
    private int categoryId;
    private String categoryAdi;

    public Category() {
    }

    public Category(int categoryId, String name) {
        this.categoryId = categoryId;
        this.categoryAdi = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryAdi() {
        return categoryAdi;
    }

    public void setCategoryAdi(String categoryAdi) {
        this.categoryAdi = categoryAdi;
    }

    @Override
    public String toString() {
        return "Category{" + "categoryId=" + categoryId + ", categoryAdi=" + categoryAdi + '}';
    }


    
    
}
