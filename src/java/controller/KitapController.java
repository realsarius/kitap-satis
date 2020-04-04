/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.KitapDAO;
import entity.Kitap;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author realsarius
 */

@ManagedBean
@SessionScoped

public class KitapController implements Serializable{
    
    private List<Kitap> kitapList;
    private KitapDAO kitapDao;
    
    private Kitap kitap;
    
    public String updateForm(Kitap kit){
        this.kitap = kit;
        
        return "index";
    }
    
    public String delete(Kitap kit){
        this.getKitapDao().delete(kit);
        
        return "index";
    }
    
    public String update(){
        this.getKitapDao().update(this.kitap);
        return "index";
    }
    
    public String create(){
        this.getKitapDao().insert(this.kitap);
        return "index";
    }

    /*public KitapController() {
        
        this.klist = new ArrayList<>();
        kdao = new KitapDAO();
    }*/

    public List<Kitap> getKitapList() {
        this.kitapList = this.getKitapDao().findAll();
        return kitapList;
    }

    public void setKitapList(List<Kitap> kitapList) {
        this.kitapList = kitapList;
    }

    public KitapDAO getKitapDao() {
        if(this.kitapDao == null){
            this.kitapDao = new KitapDAO();
        }
        return kitapDao;
    }

    public void setKitapDao(KitapDAO kitapDao) {
        this.kitapDao = kitapDao;
    }
   
    
    
    /*public List<Kitap> getKlist() {
        this.kitapList = this.getKdao().findAll();
        return kitapList;
    }

    public void setKlist(List<Kitap> klist) {
        this.kitapList = kitapList;
    }

    public KitapDAO getKdao() {
        if(this.kitapDao == null){
            this.kitapDao = new KitapDAO();
        }
        return kitapDao;
    }

    public void setKdao(KitapDAO kdao) {
        this.kitapDao = kitapDao;
    }*/

    public Kitap getKitap() {
        if(this.kitap == null){
            this.kitap = new Kitap();
        }
        return kitap;
    }

    public void setKitap(Kitap kitap) {
        this.kitap = kitap;
    }
    
    
}
