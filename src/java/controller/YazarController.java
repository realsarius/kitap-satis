/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.YazarDAO;
import entity.Yazar;
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
public class YazarController implements Serializable{
    
    private List<Yazar> yazarList;
    private YazarDAO yazarDao;
    
    private Yazar yazar;
    
    public void updateForm(Yazar yaz){
        this.yazar = yaz; 
    }
    public String deleteConfirm(Yazar yaz){
    this.yazar=yaz;
    return "/admin/yazar_confirm_delete";
    
    }
    
    public String delete(){
        
        this.getYazarDao().delete(this.yazar);
          this.yazar=new Yazar();
          
        return "/admin/Yazar";
    }
    
    public void update(){
        this.getYazarDao().update(this.yazar);
        this.yazar=new Yazar();
    }
    
    public void create(){
        this.getYazarDao().insert(this.yazar);
        this.yazar=new Yazar();
    }

    public List<Yazar> getYazarList() {
        this.yazarList = this.getYazarDao().findAll();
        return yazarList;
    }

    public void setYazarList(List<Yazar> yazarList) {
        this.yazarList = yazarList;
    }

    public YazarDAO getYazarDao() {
        if(this.yazarDao == null){
            this.yazarDao = new YazarDAO();
        }
        return yazarDao;
    }

    public void setYazarDao(YazarDAO yazarDao) {
        this.yazarDao = yazarDao;
    }

    public Yazar getYazar() {
        if(this.yazar == null){
            this.yazar = new Yazar();
        }
        return yazar;
    }

    public void setYazar(Yazar yazar) {
        this.yazar = yazar;
    }
    
     
    
}
