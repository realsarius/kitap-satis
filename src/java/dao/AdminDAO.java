/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.DBConnection;

/**
 *
 * @author tehad
 */
public class AdminDAO {
    
    public void insert(Admin admin) {

        DBConnection connector = new DBConnection();
        Connection connection = connector.connect();
        PreparedStatement myst = null;

        try {

            String sql = "insert into kitapsatis.adminler (admin_id, admin_email, admin_sifre) values (?, ?, ?)";

            myst = connection.prepareStatement(sql);

            myst.setInt(1, admin.getAdmin_id());
            myst.setString(2, admin.getAdmin_email());
            myst.setString(3, admin.getAdmin_sifre());


            myst.execute();

        } catch (SQLException ex) {
            System.out.println("SQL ERROR!");
        }

    }
    
}
