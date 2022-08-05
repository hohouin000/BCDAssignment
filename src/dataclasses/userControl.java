/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataclasses;

import crypto.Crypto;
import crypto.Symmetric;
import ds.PredefinedCharsSecretKey;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rainy
 */
public class userControl {
    private static final String _FILE_LISTUSER = "datafolders/Users.txt";

    private static final String _ALGORITHM = "RSA";
    private static final String _DIRECTORY = "KeyStore";
    private static final String _FILE_PUBLICKEY = "PUBLICKEY";
    private static final String _FILE_PRIVATEKEY = "PRIVATEKEY";
    
    public static void addnew(User u){
        Crypto crypto = new Symmetric("AES");
        String key = null;
        if (u != null) {
            try {
                key = crypto.encrypt(u.getUser_email(), PredefinedCharsSecretKey.create());
                u.setKey(key);
                u.setKeyPairDirectory(key.replace("/", ""));
                String userRecords = u.toString()+ System.lineSeparator();
                
                if (key != null) {
                    Files.write(
                            Paths.get(_FILE_LISTUSER ), 
                            userRecords.getBytes(), 
                            StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                   
                    
                    userControl.generateKeyPair(u, u.getKeyPairDirectory());
                }
        
            }  catch (Exception ex) {
                Logger.getLogger(userControl.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
    }
    
    //update
    public static boolean update(User u){
        Crypto crypto = new Symmetric("AES");
        String key = null;
        if (u != null) {
            try {
                String oldKeyPairDirectory = u.getKeyPairDirectory();
                key = crypto.encrypt(u.getUser_email(), PredefinedCharsSecretKey.create());
                u.setKey(key);
                u.setKeyPairDirectory(key.replace("/", ""));
                String userRecords =u.toString()+ System.lineSeparator();
                
                File sourceFile = new File(String.join("/", _DIRECTORY, oldKeyPairDirectory));
                File destFile = new File(String.join("/", _DIRECTORY, u.getKeyPairDirectory()));
                
                if (key != null) {
                    if (sourceFile.renameTo(destFile)) {
                        return u.update();
                    }else{
                        System.out.println("public and private keystore update fail");
                        return false;
                    }
                }
        
            }  catch (Exception ex) {
                Logger.getLogger(userControl.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
        return false;
    }
    
    //delete
    public static boolean delete(User u){
        
        try {
            Files.walk(Paths.get(String.join("/", _DIRECTORY, u.getKeyPairDirectory())))
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
            u.delete();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(userControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    
    //generateKeypair
    public static boolean generateKeyPair(User u, String keyPairDir) {

        File _directory = new File(_DIRECTORY);
        _directory.mkdir();
        
        if (_directory.exists()) {

            if (u != null) {
                //String keyPairDir = p.getKeyPairDirectory();
                String keyFileName = String.join("/", _DIRECTORY, keyPairDir);
                boolean isCreated = new File(keyFileName).mkdirs();

                try {
                    if (isCreated) {
                        KeyPairGenerator keygen = KeyPairGenerator.getInstance(_ALGORITHM);
                        keygen.initialize(1024);
                        KeyPair keyPair = keygen.generateKeyPair();
                        PublicKey pubk = keyPair.getPublic();
                        put(pubk.getEncoded(), String.join("/", keyFileName, _FILE_PUBLICKEY));
                        PrivateKey privk = keyPair.getPrivate();
                        put(privk.getEncoded(), String.join("/", keyFileName, _FILE_PRIVATEKEY));
                    }else{
                        System.out.println("INFO: KeyPair directoryalready exist.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        } else {
            System.out.println(_directory.mkdir() ? "KeyStore created." : "KeyStore is not created.");
        }

        return false;
    }

    private static void put(byte[] keyBytes, String loc) {
        try {
            Files.write(Paths.get(loc), keyBytes, StandardOpenOption.CREATE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
