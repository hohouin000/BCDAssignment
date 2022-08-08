/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 *
 * @author rainy
 */
public class KeyPairAccess {
    
    private static final String _DIRECTORY = "KeyStore";
    private static final String _FILE_PUBLICKEY = "PUBLICKEY";
    private static final String _FILE_PRIVATEKEY = "PRIVATEKEY";

    //read the keypair from the specified file

    /**
     * getPublicKey
     */
    public static PublicKey getPublicKey(String keyPairDir) throws Exception
    {
        String path = String.join("/", _DIRECTORY, keyPairDir);
        path = String.join("/", path, _FILE_PUBLICKEY);
        byte[] keyBytes = Files.readAllBytes(Paths.get(path));
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        return KeyFactory.getInstance("RSA").generatePublic(spec);
    }

    /**
     * getPrivateKey
     */
    public static PrivateKey getPrivateKey(String keyPairDir) throws Exception
    {
        String path = String.join("/", _DIRECTORY, keyPairDir);
        path = String.join("/", path, _FILE_PRIVATEKEY);
        byte[] keyBytes = Files.readAllBytes(Paths.get(path));
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        return KeyFactory.getInstance("RSA").generatePrivate(spec);
    }
}
