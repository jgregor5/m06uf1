/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author julian
 */
public class WritePot2 {
    
    private String name;
    
    public WritePot2(String filename) {        
        this.name = filename;
    }
    
    public boolean write() throws IOException {
        
        FileOutputStream fos = new FileOutputStream(this.name);
        DataOutputStream dos = new DataOutputStream(fos);
        
        long num = 1L;
        for (int i=0; i<64; i++) {
            dos.writeLong(num);
            num *= 2;
        }
        
        dos.close();
        fos.close();
        
        return true;
    }
}
