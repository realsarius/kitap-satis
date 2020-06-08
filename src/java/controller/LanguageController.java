/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LanguageDAO;
import entity.Language;
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

public class LanguageController implements Serializable {

    private List<Language> languageList;
    private LanguageDAO languageDao;

    private Language language;

    public void updateForm(Language lan) {
        this.language = lan;
    }

    public String deleteConfirm(Language lan) {
        this.language = lan;
        return "/admin/language_confirm_delete";

    }

    public String delete() {

        this.getLanguageDao().delete(this.language);
        this.language = new Language();

        return "/admin/Language";
    }

    public void update() {
        this.getLanguageDao().update(this.language);
        this.language = new Language();
    }

    public void create() {
        this.getLanguageDao().insert(this.language);
        this.language = new Language();
    }

    public List<Language> getLanguageList() {
        this.languageList = this.getLanguageDao().findAll();
        return languageList;
    }

    public void setLanguageList(List<Language> languageList) {
        this.languageList = languageList;
    }

    public LanguageDAO getLanguageDao() {
        if (this.languageDao == null) {
            this.languageDao = new LanguageDAO();
        }
        return languageDao;
    }

    public void setLanguageDao(LanguageDAO languageDao) {
        this.languageDao = languageDao;
    }

    public Language getLanguage() {
        if (this.language == null) {
            this.language = new Language();
        }
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

}
