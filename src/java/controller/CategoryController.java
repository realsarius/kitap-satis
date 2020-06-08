/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoryDAO;
import entity.Category;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author pc
 */
@ManagedBean
@SessionScoped
public class CategoryController implements Serializable{
    
    private List<Category> categoryList;
    private CategoryDAO categoryDao;
    
    private Category category;
    
    public void updateForm(Category cat){
        this.category = cat; 
    }
    public String deleteConfirm(Category cat){
    this.category=cat;
    return "/admin/category_confirm_delete";
    
    }
    
    public String delete(){
        
        this.getCategoryDao().delete(this.category);
          this.category=new Category();
          
        return "/admin/Category";
    }
    
    public void update(){
        this.getCategoryDao().update(this.category);
        this.category=new Category();
    }
    
    public void create(){
        this.getCategoryDao().insert(this.category);
        this.category=new Category();
    }

    public List<Category> getCategoryList() {
        this.categoryList = this.getCategoryDao().findAll();
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public CategoryDAO getCategoryDao() {
        if(this.categoryDao == null){
            this.categoryDao = new CategoryDAO();
        }
        return categoryDao;
    }

    public void setCategoryDao(CategoryDAO categoryDao) {
        this.categoryDao = categoryDao;
    }

    public Category getCategory() {
        if(this.category == null){
            this.category = new Category();
        }
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
     
    
}
