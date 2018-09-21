/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

/**
 *
 * @author julian
 */
public class Cercle {
    
    int radi;
    
    public Cercle() {
        this.radi = 0;
    }
    
    public Cercle(int radiConstructor) {
        this.radi = radiConstructor;
    }
    
    public int getRadi() {
        return this.radi;
    }
    
    public void setRadi(int radiSetter) {
        this.radi = radiSetter;
    }
    
    // aquest mètode i les crides podrien estar en una altra classe
    public static void main(String [] args) {
        Cercle cercle = new Cercle(10);
        System.out.println(cercle.getRadi());
        cercle.setRadi(5);
        System.out.println(cercle.getRadi());
    }
}
