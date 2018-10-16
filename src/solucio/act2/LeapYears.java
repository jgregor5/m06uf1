package solucio.act2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author julian
 */
public class LeapYears {
    
    private String filename;
    
    public LeapYears(String filename) {
        this.filename = filename;
    }
    
    public int writeNext() throws IOException {
                
        int year = getLastLeap();
        
        int nextYear;        
        if (year == 0) {
            nextYear = 1904;
        }
        else {
           nextYear = calculateNextLeap(year); 
        }
        
        writeFile(nextYear);
        return nextYear;
    }
    
    public int getLastLeap() throws IOException {
        return readFile(true, 0, -1, false);
    }
    
    public int countLeaps() throws IOException {
        return readFile(false, 0, -1, false);
    }
        
    public void showAllLeaps() throws IOException {
        readFile(false, 0, -1, true);
    }
    
    public void showLeap(int position) throws IOException {
        readFile(false, position, position + 1, true);
    }
    
    public void showLeaps(int from, int to) throws IOException {
        readFile(false, from, to, true);
    }
    
    // PRIVATE METHODS
    
    private int calculateNextLeap(int year) {        
        
        int nextLeap = year + 4;
        if (nextLeap % 100 == 0) {
            if (nextLeap % 400 != 0) {
                nextLeap += 4;
            }
        }        
        return nextLeap;
    }
    
    private void writeFile(int year) throws IOException {
        
        FileOutputStream fos = new FileOutputStream(this.filename, true);
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeInt(year);
        dos.close();
        fos.close();
    }
    
    private int readFile(boolean getYearOrCount, int from, int to, boolean print) throws IOException {
        
        File f = new File(this.filename);
        if (!f.exists()) {
            return 0;
        }
        
        FileInputStream fis = new FileInputStream(this.filename);
        DataInputStream dis = new DataInputStream(fis);
        
        int count = 0, year = 0;
        boolean end = false;
        while (!end) {
            try {
                year = dis.readInt();
                if (print) {
                    if (count >= from && (count < to || to == -1)) {
                        System.out.println(count + ": " + year);
                    }
                }
                
                count ++;

            } catch (EOFException ex) {
                end = true;
            }
        }
        
        dis.close();
        fis.close();
        
        return getYearOrCount? year : count;
    }    
}
