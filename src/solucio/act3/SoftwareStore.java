package solucio.act3;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julian
 */
public class SoftwareStore {
    
    // storage order: ID + NAME + VERSION + PRICE
    
    public static final int NAME_LENGTH = 32;
    public static final int INT_LENGTH = 4;
    public static final int DOUBLE_LENGTH = 8;
    public static final int ITEM_LENGTH = NAME_LENGTH + INT_LENGTH + INT_LENGTH + DOUBLE_LENGTH;
    
    private String filename;
    
    public SoftwareStore(String filename) {
        this.filename = filename;
    }
    
    public boolean add(SoftwareItem si) throws IOException {
        
        if (find(si.getId()) != null) {
            return false;
        }
                
        RandomAccessFile raf = new RandomAccessFile(this.filename, "rw");
        raf.seek(raf.length()); // to end
        
        raf.writeInt(si.getId());
        raf.write(getNameBytes(si.getName()));
        raf.writeInt(si.getVersion());
        raf.writeDouble(si.getPrice());
        
        raf.close();
        
        return true;
    }
    
    public List<SoftwareItem> findAll() throws IOException {
        return find(null, null);
    }
    
    public SoftwareItem find(int id) throws IOException {      
        
        List<SoftwareItem> items = find(id, null);
        return items.isEmpty()? null : items.get(0);
    }
     
    public List<SoftwareItem> find(String name) throws IOException {  
        
        return find(null, name);
    }
    
    public boolean update(SoftwareItem si) throws IOException {
        
        RandomAccessFile raf = new RandomAccessFile(this.filename, "rw"); 
        
        boolean found = false, end = false;
        while (!(found || end)) {
            try {
                int foundId = raf.readInt();
                if (foundId == si.getId()) {
                    raf.write(getNameBytes(si.getName()));
                    raf.writeInt(si.getVersion());
                    raf.writeDouble(si.getPrice());
                    found = true;
                }
                else {
                    raf.skipBytes(ITEM_LENGTH - INT_LENGTH);
                }
                
            } catch (EOFException ex) {
                end = true;
            }
        }
        
        raf.close();
        
        return found;
    }
    
    // PRIVATE METHODS
        
    private List<SoftwareItem> find(Integer id, String name) throws IOException {        
        
        List<SoftwareItem> items = new ArrayList<>();
        
        File f = new File(this.filename);
        if (!f.exists()) {
            return items;
        }
        
        RandomAccessFile raf = new RandomAccessFile(this.filename, "r"); 
        raf.seek(0); // needed?
        
        boolean end = false;
        while (!end) {
            try {
                // read the item
                int foundId = raf.readInt();
                byte[] nameBytes = new byte[NAME_LENGTH];
                raf.readFully(nameBytes);
                String foundName = new String(cleanNameBytes(nameBytes));
                int foundVersion = raf.readInt();
                double foundPrice = raf.readDouble();
                
                boolean found = false;
                if (id == null && name == null) { // search all
                    found = true;
                }
                else if (id != null && foundId == id) { // search id
                    found = true;
                    end = true;
                }
                else if (name != null && foundName.contains(name)) { // search name
                    found = true;
                }
                
                if (found) {
                    SoftwareItem si = new SoftwareItem();
                    si.setId(foundId);
                    si.setName(foundName);
                    si.setVersion(foundVersion);
                    si.setPrice(foundPrice);
                    items.add(si);
                }

            } catch (EOFException ex) {
                end = true;
            }            
        }
        
        raf.close();
        
        return items;
    }

    private byte[] cleanNameBytes(byte[] b) {
        
        int position = 0;
        while (b[position] != 0) {
            position ++;
        }
        
        byte[] result = new byte[position];
        for (int i=0; i<position; i++) {
            result[i] = b[i];
        }
        
        return result;
    }
    
    private byte[] getNameBytes(String s) throws IOException {
        
        byte[] input = s.getBytes();
        if (input.length > NAME_LENGTH) {
            throw new IOException("name is too long");
        }
        
        int position = 0;
        byte[] result = new byte[NAME_LENGTH];
        for (byte b: input) {
            result[position ++] = b;
        }
        return result;
    }    
}
