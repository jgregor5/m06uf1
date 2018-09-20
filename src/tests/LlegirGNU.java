/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author julian
 */
public class LlegirGNU {
    
    public static void main(String[] args) throws IOException {
        
        open1();
        System.out.println("open1 finalizado");
        open2();
        System.out.println("open2 finalizado");
    }

    // tratamos el error
    public static void open1() {
        
        try {
            
            FileInputStream fis = new FileInputStream("C:\\gnu-unicode.txt");        
            fis.close();
            
        } catch (IOException exception) {
            System.out.println("error en open1");
        }
        
    }
    
    // ignoramos el error
    public static void open2() throws IOException {
        
        FileInputStream fis = new FileInputStream("C:\\gnu-unicode.txt");        
        fis.close();
    }
}
