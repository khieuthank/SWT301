/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author toden
 */
public class CategoryDAO extends DAO {

    public CategoryDAO() {
        super();
    }

    @Override
    public List<Category> getAllCate() {
        String sql = "select * from Category";
        List<Category> CateList = new ArrayList<Category>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt(1);
                String name = rs.getString(2);

                CateList.add(new Category(Id, name));
            }
        } catch (Exception e) {
            status = "Error at read Category " + e.getMessage();
        }
        return CateList;
    }

    @Override
    public void addCategory(String categoryName) {
        String sql = "INSERT INTO Category (category_name) VALUES (?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, categoryName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CategoryDAO a = new CategoryDAO();
        a.addCategory("noel");
    }

}
