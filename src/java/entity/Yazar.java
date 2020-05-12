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
public class Yazar extends DBConnection{
    private int yazar_id;
    private String yazar_adi;
    private String yazar_info;

    public Yazar() {
    }

    
    public Yazar(int yazar_id, String yazar_adi, String yazar_info) {
        this.yazar_id = yazar_id;
        this.yazar_adi = yazar_adi;
        this.yazar_info = yazar_info;
    }
    

    public int getYazar_id() {
        return yazar_id;
    }

    public void setYazar_id(int yazar_id) {
        this.yazar_id = yazar_id;
    }

    public String getYazar_adi() {
        return yazar_adi;
    }

    public void setYazar_adi(String yazar_adi) {
        this.yazar_adi = yazar_adi;
    }

    public String getYazar_info() {
        return yazar_info;
    }

    public void setYazar_info(String yazar_info) {
        this.yazar_info = yazar_info;
    }

    @Override
    public String toString() {
        return "Yazar{" + "yazar_id=" + yazar_id + ", yazar_adi=" + yazar_adi + ", yazar_info=" + yazar_info + '}';
    }
    
    
    
    
}
