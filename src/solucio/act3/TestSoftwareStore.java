/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solucio.act3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 *
 * @author julian
 */
public class TestSoftwareStore {

    public static void main(String[] args) throws IOException {
        
        SoftwareStore ss = new SoftwareStore("data/softstore.dat");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean end = false;
        
        int lastId = 0;
        
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
                    System.out.println("add|update N|print|find ID|find TEXT|exit");
                    break;
                case "add":
                    try {
                        System.out.print("id> ");
                        int id = Integer.parseInt(br.readLine());
                        System.out.print("name> ");
                        String name = br.readLine();
                        System.out.print("version> ");
                        int version = Integer.parseInt(br.readLine());
                        System.out.print("price> ");
                        double price = Double.parseDouble(br.readLine());
                        
                        boolean ok = ss.add(new SoftwareItem(id, version, name, price));
                        System.out.println(ok? "added" : "failure");
                        
                    } catch (NumberFormatException ex) {
                        System.out.println("error: wrong format");
                    }
                    break;
                case "update":
                    SoftwareItem si = ss.find(lastId);
                    if (si == null) {
                        System.out.println("error: first, find an item");
                    }
                    else {
                        System.out.println(si);
                        try {
                            System.out.print("new version> ");
                            int version = Integer.parseInt(br.readLine());
                            System.out.print("new price> ");
                            double price = Double.parseDouble(br.readLine());
                            
                            si.setVersion(version);
                            si.setPrice(price);
                            
                            boolean ok = ss.update(si);
                            System.out.println(ok? "updated" : "failure");
                            
                        } catch (NumberFormatException ex) {
                            System.out.println("error: wrong format");
                        }
                    }
                    
                    break;
                case "print": 
                    List<SoftwareItem> list = ss.findAll();
                    for (SoftwareItem item: list) {
                        System.out.println(item);
                    }
                    break;
                                  
                case "find":
                    Integer findId = null;
                    if (parts.length == 1) {
                        System.out.println("what? (? for help)");
                        continue;
                    }
                    
                    try { 
                        findId = Integer.parseInt(line.substring(5));
                        si = ss.find(findId);
                        if (si != null) {
                            System.out.println(si);
                            lastId = findId;
                        }
                        else {
                            System.out.println("not found");
                        }
                        
                    } catch (NumberFormatException ex) {
                        list = ss.find(line.substring(5));
                        if (list.isEmpty()) {
                            System.out.println("nothing found");
                        }
                        else {
                            for (SoftwareItem item: list) {
                                System.out.println(item);
                            }                            
                            if (list.size() == 1) {
                                lastId = list.get(0).getId();
                            }
                        }
                    }
                    
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
