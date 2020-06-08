package dao;

import entity.Language;
import entity.Kitap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class KitapDAO extends DBConnection {

    public List<Kitap> findAll() {
        List<Kitap> kitapList = new ArrayList<>();
        DBConnection connector = new DBConnection();
        Connection connection = connector.connect();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from kitapsatis.kitaplar");
            while (rs.next()) {
                Kitap t = new Kitap();
                t.setKitapId(rs.getInt("kitap_id"));
                t.setKitapAdi(rs.getString("kitap_adi"));
                t.setKitapYazari(rs.getString("kitap_yazari"));
                t.setKitapSayfaSayisi(rs.getInt("kitap_sayfa_sayisi"));
                t.setKitapCikisTarihi(rs.getString("kitap_cikis_tarihi"));
                t.setKitapEklenmeTarihi(rs.getString("kitap_eklenme_tarihi"));
                t.setKitapStokSayisi(rs.getInt("kitap_stok_sayisi"));
                kitapList.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("SQL ERROR!");
        }
        return kitapList;
    }

    public void insert(Kitap kitap) {

        DBConnection connector = new DBConnection();
        Connection connection = connector.connect();
        PreparedStatement myst = null;

        try {

            String sql = "insert into kitapsatis.kitaplar (kitap_id, kitap_adi, kitap_yazari, kitap_sayfa_sayisi, kitap_cikis_tarihi, kitap_eklenme_tarihi, kitap_stok_sayisi, language_id) values (?, ?, ?, ? ,?, ?, ?, ?)";

            myst = connection.prepareStatement(sql);

            myst.setInt(1, kitap.getKitapId());
            myst.setString(2, kitap.getKitapAdi());
            myst.setString(3, kitap.getKitapYazari());
            myst.setInt(4, kitap.getKitapSayfaSayisi());
            myst.setString(5, kitap.getKitapCikisTarihi());
            myst.setString(6, kitap.getKitapEklenmeTarihi());
            myst.setInt(7, kitap.getKitapStokSayisi());
            myst.setInt(8, kitap.getLanguageId());

            myst.execute();

        } catch (SQLException ex) {
            System.out.println("SQL ERROR!");
        }

    }

    public void delete(Kitap kit) {
        DBConnection connector = new DBConnection();
        Connection connection = connector.connect();

        try {

            Statement st = connection.createStatement();
            st.executeUpdate("delete from kitapsatis.kitaplar where kitap_id=" + kit.getKitapId());

        } catch (SQLException ex) {
            System.out.println("SQL ERROR!");
        }
    }

    public void update(Kitap kitap) {
        DBConnection connector = new DBConnection();
        Connection connection = connector.connect();

        try {

            Statement st = connection.createStatement();
            String sql = "UPDATE `kitapsatis`.`kitaplar` SET `kitap_adi` = ?, `kitap_yazari` = ?, `kitap_sayfa_sayisi` = ?, `kitap_cikis_tarihi` = ?, `kitap_eklenme_tarihi` = ?, `kitap_stok_sayisi` = ? WHERE (`kitap_id` = ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, kitap.getKitapAdi());
            statement.setString(2, kitap.getKitapYazari());
            statement.setInt(3, kitap.getKitapSayfaSayisi());
            statement.setString(4, kitap.getKitapCikisTarihi());
            statement.setString(5, kitap.getKitapEklenmeTarihi());
            statement.setInt(6, kitap.getKitapStokSayisi());
            statement.setInt(7, kitap.getKitapId());

            statement.executeQuery();

        } catch (SQLException ex) {
            System.out.println("SQL ERROR!");
        }
    }

}
