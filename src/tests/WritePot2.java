/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.io.IOException;

/**
 *
 * @author julian
 */
public class WritePot2 {
    
    public WritePot2(String filename) {        
        
    }
    
    public boolean write() throws IOException {
        return false;
    }
    
    public static void main(String[] args) {
        
        try {
            boolean wrote = new WritePot2("data/pot2.dat").write();
            System.out.println(wrote? "wrote it" : "could not write it");
            
        } catch (IOException e) {
            System.out.println("failed to write it");
            e.printStackTrace();
        }
    }
}
