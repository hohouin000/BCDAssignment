/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataclasses;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rainy
 */
public class User {

    private String user_ID, user_email, password, user_category, user_company_name, user_company_phone, keyPairDirectory, key;

    private final static String datapath = "datafolders/Users.txt";

    @Override
    public String toString() {
        return key + "|" +user_ID + "|" + user_email + "|" + password + "|" + user_category + "|" + user_company_name + "|" + user_company_phone+ "|" +keyPairDirectory;
    }

    public User() {
    }

    public User(String user_ID, String user_email, String password, String user_category, String user_company_name, String user_company_phone, String keyPairDirectory, String key) {
        this.user_ID = user_ID;
        this.user_email = user_email;
        this.password = password;
        this.user_category = user_category;
        this.user_company_name = user_company_name;
        this.user_company_phone = user_company_phone;
        this.keyPairDirectory = keyPairDirectory;
        this.key = key;
    }

    

    public String getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_category() {
        return user_category;
    }

    public void setUser_category(String user_category) {
        this.user_category = user_category;
    }

    public String getUser_company_name() {
        return user_company_name;
    }

    public void setUser_company_name(String user_company_name) {
        this.user_company_name = user_company_name;
    }

    public String getUser_company_phone() {
        return user_company_phone;
    }

    public void setUser_company_phone(String user_company_phone) {
        this.user_company_phone = user_company_phone;
    }

    public String getKeyPairDirectory() {
        return keyPairDirectory;
    }

    public void setKeyPairDirectory(String keyPairDirectory) {
        this.keyPairDirectory = keyPairDirectory;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    

    public static List<String> getAll() {
        try {
            return Files.readAllLines(Paths.get(datapath));
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }

    public boolean update() {
        List<String> data = getAll();
        String id = this.user_ID;
        int a = 0;

        for (a = 0; a < data.size(); a++) {
            String[] split = data.get(a).split("[|]");
            if (id.equals(split[1])) {
                break;
            }
        }
        try {
            data.set(a, this.toString());
        } catch (Exception e) {
            return false;
        }
        String info = "";
        for (int i = 0; i < data.size(); i++) {
            info += data.get(i) + System.lineSeparator();
        }
        return rewriteFile(info);
    }
    public boolean delete() {
        List<String> data = getAll();
        String id = this.user_ID;
        int a = 0;

        for (a = 0; a < data.size(); a++) {
            String[] split = data.get(a).split("[|]");
            if (id.equals(split[1])) {
                break;
            }
        }
        try {
            data.remove(a);
        } catch (Exception e) {
            return false;
        }
        String info = "";
        for (int i = 0; i < data.size(); i++) {
            info += data.get(i) + System.lineSeparator();
        }
        return rewriteFile(info);
    }

    protected static boolean rewriteFile(String data) {
        boolean status = true;
        try {
            Files.write(Paths.get(datapath), data.getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
        } catch (IOException ex) {
            status = false;
        }
        return status;
    }

    public static User Login(String email, String pWord) {
        List<String> data = getAll();

        for (String string : data) {
            String[] split = string.split("[|]");
            if (split[2].replace(" ", "").equals(email) && split[3].replace(" ", "").equals(pWord)) {
                
                String key=split[0];
                String user_ID = split[1];
                String user_email = split[2];
                String password = split[3];
                String user_category = split[4];
                String user_company_name = split[5];
                String user_company_phone = split[6];
                String keyPairDirectory = split[7];

                return new User(user_ID, user_email, password, user_category, user_company_name, user_company_phone,keyPairDirectory,key);
            }
        }

        return null;

    }
    
    public static User getUsesrByID(String Id) {
        List<String> data = getAll();

        for (String string : data) {
            String[] split = string.split("[|]");
            if (split[1].equals(Id)) {
                String key=split[0];
                String user_ID = split[1];
                String user_email = split[2];
                String password = split[3];
                String user_category = split[4];
                String user_company_name = split[5];
                String user_company_phone = split[6];
                String keyPairDirectory = split[7];

                return new User(user_ID, user_email, password, user_category, user_company_name, user_company_phone,keyPairDirectory,key);
            }
        }

        return null;

    }
    
    public static ArrayList<User> getAllUsers() {
        ArrayList<User> temp = new ArrayList<>();
        List<String> data = getAll();

        for (String string : data) {
            String[] split = string.split("[|]");
            String key=split[0];
            String user_ID = split[1];
            String user_email = split[2];
            String password = split[3];
            String user_category = split[4];
            String user_company_name = split[5];
            String user_company_phone = split[6];
            String keyPairDirectory = split[7];

             

           temp.add(new User(user_ID, user_email, password, user_category, user_company_name, user_company_phone,keyPairDirectory,key));
            
        }

        return temp;

    }

}
