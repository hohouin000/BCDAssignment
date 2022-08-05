package crypto;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class KeyPairGen {

	//testing
	public String algorithm = "RSA";
	
	private KeyPairGenerator keygen;
	private KeyPair keyPair;
	
	public KeyPairGen() {
		try {
			keygen = KeyPairGenerator.getInstance(algorithm);
			keygen.initialize(1024);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * create
	 */
	public static void create(String folderName)
	{
		KeyPairGen myKeyMaker = new KeyPairGen();
		//generate keyPair
		myKeyMaker.keyPair = myKeyMaker.keygen.generateKeyPair();
		//get public key
		PublicKey pubKey = myKeyMaker.keyPair.getPublic();
		//get private key
		PrivateKey prvKey = myKeyMaker.keyPair.getPrivate();
		
		//view
//		System.out.println( "Public key: "+  
//				Base64.getEncoder().encodeToString(pubKey.getEncoded()));
//		System.out.println( "Private key: "+  
//				Base64.getEncoder().encodeToString(prvKey.getEncoded()));
		
		//put in file
		put(prvKey.getEncoded(),"KeyPair/"+folderName+"/PublicKey");
		put(prvKey.getEncoded(),"KeyPair/"+folderName+"/PrivateKey");
		
	}
	
	/**
	 * put the key in a specified file path
	 */
	public static void put( byte[] keyBytes, String path )
	{
		File f = new File(path );
		f.getParentFile().mkdirs();
		try {
			Files.write(Paths.get(path), keyBytes, StandardOpenOption.CREATE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
