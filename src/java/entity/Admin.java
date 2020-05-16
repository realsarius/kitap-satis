/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author tehad
 */
public class Admin {
    
    private int admin_id;
    private String admin_email;
    private String admin_sifre;

    public Admin() {
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public String getAdmin_sifre() {
        return admin_sifre;
    }

    public void setAdmin_sifre(String admin_sifre) {
        this.admin_sifre = admin_sifre;
    }


    
    

    
}
