package dao;

import entity.Language;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class LanguageDAO extends DBConnection {

    public List<Language> findAll() {
        List<Language> languageList = new ArrayList<>();
        DBConnection connector = new DBConnection();
        Connection connection = connector.connect();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from kitapsatis.language");
            while (rs.next()) {
                Language t = new Language();
                t.setLanguageId(rs.getInt("language_id"));
                t.setLanguageAdi(rs.getString("language_adi"));
                languageList.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("SQL ERROR!");
        }
        return languageList;
    }

    public void insert(Language language) {

        DBConnection connector = new DBConnection();
        Connection connection = connector.connect();
        PreparedStatement myst = null;

        try {

            String sql = "insert into kitapsatis.language (language_id, language_adi) values (?, ?)";

            myst = connection.prepareStatement(sql);

            myst.setInt(1, language.getLanguageId());
            myst.setString(2, language.getLanguageAdi());

            myst.execute();

        } catch (SQLException ex) {
            System.out.println("SQL ERROR!");
        }

    }

    public void delete(Language kit) {
        DBConnection connector = new DBConnection();
        Connection connection = connector.connect();

        try {

            Statement st = connection.createStatement();
            st.executeUpdate("delete from kitapsatis.language where language_id=" + kit.getLanguageId());

        } catch (SQLException ex) {
            System.out.println("SQL ERROR!");
        }
    }

    public void update(Language language) {
        DBConnection connector = new DBConnection();
        Connection connection = connector.connect();

        try {

            Statement st = connection.createStatement();
            String sql = "UPDATE `kitapsatis`.`language` SET `language_adi` = ? WHERE (`language_id` = ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(2, language.getLanguageAdi());
            statement.setInt(1, language.getLanguageId());

            statement.executeQuery();

        } catch (SQLException ex) {
            System.out.println("SQL ERROR!");
        }
    }

}
