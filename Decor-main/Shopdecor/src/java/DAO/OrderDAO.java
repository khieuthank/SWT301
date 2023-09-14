/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Cart;
import Model.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author toden
 */
public class OrderDAO extends DAO {

    public OrderDAO() {
        super();
    }

    @Override
    public boolean addOrder(int aid, List<Cart> carts) {
        double total = 0;
        for (Cart c : carts) {
            total += c.getPrice() * c.getAmmount();
        }
        String sql = "insert into [Order]values (?,?,?)";
        Date date = new Date();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(date.getTime()));
            ps.setInt(2, aid);
            ps.setDouble(3, total);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            status = "Error at addOrder " + e.getMessage();
        }
        return false;
    }

    @Override
    public List<Order> getListOrder() {
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT [order_id], [order_date], [account_id], [total] FROM [dbo].[Order]";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                Date orderDate = rs.getDate("order_date");
                int accountId = rs.getInt("account_id");
                double total = rs.getDouble("total");

                Order order = new Order();
                order.setOrderId(orderId);
                order.setOrderDate((java.sql.Date) orderDate);
                order.setCustomerId(accountId);
                order.setTotal(total);

                orderList.add(order);
            }
            rs.close();
            return orderList;
        } catch (Exception e) {
            status = "Error at getListOrder: " + e.getMessage();
            System.out.println(status);
        }

        return null;
    }

    @Override
    public int getNewestOrderId() {
        String sql = "select top 1 * from Order order by order_id desc";
        int id = 1;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            status = "Error at getNewestOrderId " + e.getMessage();
            System.out.println(status);
        }
        return id;
    }

    @Override
    public boolean addOrderDetail(List<Cart> carts) {
        String sql = "insert into OrderDetail values (?,?,?,?)";
        for (Cart c : carts) {
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, getNewestOrderId());
                ps.setInt(2, c.getProductId());
                ps.setInt(3, c.getAmmount());
                ps.setDouble(4, c.getPrice() * c.getAmmount());
                ps.executeUpdate();
                return true;
            } catch (Exception e) {
                status = "Error at addOrderDetail " + e.getMessage();
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addOrderDetail(Cart c) {
        String sql = "insert into [OrderDetail] values (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, getNewestOrderId());
            ps.setInt(2, c.getProductId());
            ps.setInt(3, c.getAmmount());
            ps.setDouble(4, c.getPrice() * c.getAmmount());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            status = "Error at addOrderDetail " + e.getMessage();

        }
        return false;
    }

    public static void main(String[] args) {
        DAO d = new OrderDAO();
        System.out.println(d.getListOrder());
    }
}
