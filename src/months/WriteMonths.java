package months;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormatSymbols;

/**
 *
 * @author julian
 */
public class WriteMonths {
    
    private String filename;
    
    public WriteMonths(String filename) {
        this.filename = filename;
    }
    
    public String[] read() throws IOException {
        
        FileInputStream fis = new FileInputStream(this.filename);
        DataInputStream dis = new DataInputStream(fis);
        
        String[] months = new String[12];
        for (int i = 0; i < 12; i ++) {

            byte[] read32Bytes = new byte[32];
            dis.readFully(read32Bytes);
            
            months[i] = new String(read32Bytes);
        }
        
        dis.close();
        fis.close();
        
        return months;
    }
    
    public void write() throws IOException {
        
        FileOutputStream fos = new FileOutputStream(this.filename);
        DataOutputStream dos = new DataOutputStream(fos);
        
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        
        for (int i = 0; i < months.length; i ++) {
            
            byte[] writeBytes = months[i].getBytes();
            byte[] write32Bytes = new byte[32];
            
            for (int j = 0; j < writeBytes.length; j ++) {
                write32Bytes[j] = writeBytes[j];
            }
            
            dos.write(write32Bytes);
        }
        
        dos.close();
        fos.close();
    }
}
