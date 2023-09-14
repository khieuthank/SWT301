/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author toden
 */
public class Cart {
    private int AccountId;
    private String ProductName;
    private int ProductId;
    private String Image;
    private int Ammount;
    private double Price;
    private String description;

    public Cart() {
    }

    public Cart(int AccountId, String ProductName, int ProductId, String Image, int Ammount, double Price, String description) {
        this.AccountId = AccountId;
        this.ProductName = ProductName;
        this.ProductId = ProductId;
        this.Image = Image;
        this.Ammount = Ammount;
        this.Price = Price;
        this.description = description;
    }

    public int getAccountId() {
        return AccountId;
    }

    public void setAccountId(int AccountId) {
        this.AccountId = AccountId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public int getAmmount() {
        return Ammount;
    }

    public void setAmmount(int Ammount) {
        this.Ammount = Ammount;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    

    
    
    
}
