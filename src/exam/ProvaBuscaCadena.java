package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author julian
 */
public class ProvaBuscaCadena {
    
    public static void main(String[] args) throws IOException {
        
        BuscaCadena ss = new BuscaCadena("data/search.txt");
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean end = false;
        
        System.out.println("enter a string (? for help)");
        while (!end) {
            System.out.print("> ");
            String line = br.readLine();
            if (line == null) {
                continue;
            }
            
            String[] parts = line.split(" ");            
            if (parts.length == 0) {
                continue;
            }
            
            switch (parts[0]) {
                case "?":
                    System.out.println("STRING|exit");
                    break;    
                case "":
                case "exit":
                    end = true;
                    break;
                default:
                    long position = 0;
                    boolean search = true;
                    while (search) {
                        position = ss.busca(position, line);
                        if (position == -1) {
                            search = false;
                        }
                        else {
                            System.out.println(position);
                            position += line.length();
                        }
                    }
                    break;
            }
        }
    }
}
