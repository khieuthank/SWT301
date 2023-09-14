/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author toden
 */
public class AccountDAO extends DAO {

    public AccountDAO() {
        super();
    }
    
    
    @Override
    public Account findAccByEmail(String email){
        String sql = "select * from Account where email = ?";
        Account acc = new Account();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String accName = rs.getString(2);
                String password = rs.getString(3);
                String cusName = rs.getString(4);
                String phone = rs.getString(5);
                String address = rs.getString(6);
                int roleId = rs.getInt(8);
                acc = new Account(id, accName, password, cusName, phone, address, email, roleId);
                return acc;
            }
        } catch (Exception e) {
            status = "Error at findAccByEmail " + e.getMessage();
        }
        return null;
    }
    @Override
    public Account findAccByID(String ID){
        String sql = "select * from Account where account_id = ?";
        Account acc = new Account();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String accName = rs.getString(2);
                String password = rs.getString(3);
                String cusName = rs.getString(4);
                String phone = rs.getString(5);
                String address = rs.getString(6);
                String email = rs.getString(7);
                int roleId = rs.getInt(8);
                acc = new Account(id, accName, password, cusName, phone, address, email, roleId);
                return acc;
            }
        } catch (Exception e) {
            status = "Error at findAccByEmail " + e.getMessage();
        }
        return null;
    }
    
    @Override
    public Account addAcc(String account, String password, String customer, String phone, String address, String email){
        String sql = "insert into Account(account_name, password, customer_name, phone, address, email) values (?,?,?,?,?,?)";
        if(findAccByEmail(email)!=null&&findAccByEmail(email).getAccountId()>0){
            return null;
        }
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, account);
            ps.setString(2, password);
            ps.setNString(3, customer);
            ps.setString(4, phone);
            ps.setString(5, address);
            ps.setString(6, email);
            ps.executeUpdate();
            return findAccByEmail(email);
        }
        catch(Exception e){
            status = "Error at addAcc " + e.getMessage();
        }
        return null;
    }

    @Override
    public Account getOneAcc(int id){
         String sql = "Select * from Account where account_id = ?";
         Account acc = new Account();
         try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt(1);
                String name = rs.getString(2);
                String pass = rs.getString(3);
                String customerName = rs.getString(4);;
                String phone = rs.getString(5);
                String address = rs.getString(6);
                String email = rs.getString(7);
                int roleId = rs.getInt(8);

                acc = new Account(Id, name, pass, customerName, phone, address, email, roleId);
            }
        } catch (Exception e) {
            status = "Error at getOneAcc " + e.getMessage();
        }
         return acc;
    }
    
    @Override
    public List<Account> getAllAccount() {
        String sql = "Select * From Account";
        List<Account> AccList = new ArrayList<Account>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt(1);
                String name = rs.getString(2);
                String pass = rs.getString(3);
                String customerName = rs.getString(4);;
                String phone = rs.getString(5);
                String address = rs.getString(6);
                String email = rs.getString(7);
                int roleId = rs.getInt(8);

                AccList.add(new Account(Id, name, pass, customerName, phone, address, email, roleId));
            }
        } catch (Exception e) {
            status = "Error at read Category " + e.getMessage();
        }
        return AccList;
    }
    
    @Override
    public int cusAccountExist(String email, String p) {
        String sql = "select a.account_id, a.email, a.password FROM Account as a "
                + "WHERE a.email = ? AND a.password = ?";
        int id = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,email);
            ps.setString(2,p);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            status = "Error at read Category " + e.getMessage();
        }
        return id;
    }

    @Override
    public Account findAccByName(String name, String p){
        String sql = "select * from Account where account_name = ? and password = ?";
        Account acc = new Account();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,p);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt(1);
                String Name = rs.getString(2);
                String pass = rs.getString(3);
                String customerName = rs.getString(4);;
                String phone = rs.getString(5);
                String address = rs.getString(6);
                String email = rs.getString(7);
                int roleId = rs.getInt(8);
                acc = new Account(Id, Name, pass, customerName, phone, address, email, roleId);
            }
        } catch (Exception e) {
            status = "Error at read Category " + e.getMessage();
        }
        return acc;
    }
    public static void main(String[] args) {
        DAO a = new AccountDAO();
        System.out.println(a.findAccByID("5"));
    }
}
