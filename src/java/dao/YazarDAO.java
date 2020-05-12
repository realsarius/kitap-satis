/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Yazar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author pc
 */
public class YazarDAO extends DBConnection {

    public List<Yazar> findAll() {
        List<Yazar> yazarList = new ArrayList<>();
        DBConnection connector = new DBConnection();
        Connection connection = connector.connect();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from kitapsatis.yazar");
            while (rs.next()) {
                Yazar t = new Yazar();
                t.setYazar_id(rs.getInt("yazar_id"));
                t.setYazar_adi(rs.getString("yazar_adi"));
                t.setYazar_info(rs.getString("yazar_info"));

                yazarList.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("SQL ERROR!");
        }
        return yazarList;
    }

    public void insert(Yazar yazar) {

        DBConnection connector = new DBConnection();
        Connection connection = connector.connect();
        PreparedStatement myst = null;

        try {

            String sql = "insert into kitapsatis.yazar (yazar_id, yazar_adi, yazar_info) values (?, ?, ?)";

            myst = connection.prepareStatement(sql);

            myst.setInt(1, yazar.getYazar_id());
            myst.setString(2, yazar.getYazar_adi());
            myst.setString(3, yazar.getYazar_info());


            myst.execute();

        } catch (SQLException ex) {
            System.out.println("SQL ERROR!");
        }

    }

    public void delete(Yazar yaz) {
        DBConnection connector = new DBConnection();
        Connection connection = connector.connect();

        try {

            Statement st = connection.createStatement();
            st.executeUpdate("delete from kitapsatis.yazar where yazar_id=" + yaz.getYazar_id());

        } catch (SQLException ex) {
            System.out.println("SQL ERROR!");
        }
    }

    public void update(Yazar yazar) {
        DBConnection connector = new DBConnection();
        Connection connection = connector.connect();

        try {

            Statement st = connection.createStatement();
            String sql = "UPDATE `kitapsatis`.`yazar` SET `yazar_adi` = ?, `yazar_info` = ? WHERE (`yazar_id` = ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, yazar.getYazar_adi());
            statement.setString(2, yazar.getYazar_info());
            statement.setInt(3, yazar.getYazar_id());

            statement.executeQuery();

        } catch (SQLException ex) {
            System.out.println("SQL ERROR!");
        }
    }

    
}
