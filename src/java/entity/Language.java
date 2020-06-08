/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class Language {
    private int languageId;
    private String languageAdi;
    

    public Language() {
    }

    public Language(int languageId, String languageAdi) {
        this.languageId = languageId;
        this.languageAdi = languageAdi;
        
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getLanguageAdi() {
        return languageAdi;
    }

    public void setLanguageAdi(String languageAdi) {
        this.languageAdi = languageAdi;
    }




    
}
