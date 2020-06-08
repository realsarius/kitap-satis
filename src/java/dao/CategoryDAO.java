package dao;

import entity.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class CategoryDAO extends DBConnection {

    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();
        DBConnection connector = new DBConnection();
        Connection connection = connector.connect();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from kitapsatis.category");
            while (rs.next()) {
                Category t = new Category();
                t.setCategoryId(rs.getInt("category_id"));
                t.setCategoryAdi(rs.getString("category_adi"));

                categoryList.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("SQL ERROR!");
        }
        return categoryList;
    }

    public void insert(Category category) {

        DBConnection connector = new DBConnection();
        Connection connection = connector.connect();
        PreparedStatement myst = null;

        try {

            String sql = "insert into kitapsatis.category (category_id, category_adi) values (?, ?)";

            myst = connection.prepareStatement(sql);

            myst.setInt(1, category.getCategoryId());
            myst.setString(2, category.getCategoryAdi());

            myst.execute();

        } catch (SQLException ex) {
            System.out.println("SQL ERROR!");
        }

    }

    public void delete(Category kit) {
        DBConnection connector = new DBConnection();
        Connection connection = connector.connect();

        try {

            Statement st = connection.createStatement();
            st.executeUpdate("delete from kitapsatis.category where category_id=" + kit.getCategoryId());

        } catch (SQLException ex) {
            System.out.println("SQL ERROR!");
        }
    }

    public void update(Category category) {
        DBConnection connector = new DBConnection();
        Connection connection = connector.connect();

        try {

            Statement st = connection.createStatement();
            String sql = "UPDATE `kitapsatis`.`category` SET `category_adi` = ? WHERE (`category_id` = ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(2, category.getCategoryAdi());
            statement.setInt(1, category.getCategoryId());

            statement.executeQuery();

        } catch (SQLException ex) {
            System.out.println("SQL ERROR!");
        }
    }

}
