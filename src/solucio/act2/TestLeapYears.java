package solucio.act2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author julian
 */
public class TestLeapYears {
    
    public static void main(String[] args) throws IOException {
        
        LeapYears ly = new LeapYears("data/traspas.dat");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean end = false;
        
        System.out.println("write a command (? for help)");
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
                    System.out.println("add|print|print N|print N1 N2|count|exit");
                    break;
                case "add":
                    System.out.println(ly.writeNext());
                    break;
                case "printall":
                    ly.showAllLeaps();
                    break;
                case "print":
                    if (parts.length == 1) {
                        ly.showAllLeaps();
                    }
                    try {
                        if (parts.length == 2) {
                            int position = Integer.parseInt(parts[1]);
                            ly.showLeap(position);
                        }
                        if (parts.length == 3) {
                            int from = Integer.parseInt(parts[1]);
                            int to = Integer.parseInt(parts[2]);
                            ly.showLeaps(from, to + 1);
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("error: not a number");
                    }                    
                    break;                    
                case "count":
                    System.out.println(ly.countLeaps());
                    break;
                case "exit":
                    end = true;
                    break;
                default:
                    System.out.println("what? (? for help)");
                    break;
            }
        }
    }
}
