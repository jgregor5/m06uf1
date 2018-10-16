/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solucio.act3;

/**
 *
 * @author julian
 */
public class SoftwareItem {
    
    private int id, version;
    private String name;
    private double price;

    public SoftwareItem() {        
    }
    
    public SoftwareItem(int id, int version, String name, double price) {
        this.id = id;
        this.version = version;
        this.name = name;
        this.price = price;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "SoftwareItem " + this.id + ": version=" + this.version + " price=" + this.price + " name=" + this.name;
    }
}
