package ds;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

public class DigitalSignature {


	private Signature sig;

	/**
	 * Testing section (KeyPair)
	 */
//	private KeyPairGenerator keygen;
//	private KeyPair keyPair;
//	{
//		try {
//			keygen = KeyPairGenerator.getInstance("RSA");
//			keyPair = keygen.generateKeyPair();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	//==========================================================================
	
	public DigitalSignature() {
		super();
		try {
			sig = Signature.getInstance( "SHA256WithRSA" );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * sign()
     * @param data
     * @param prvKey
	 */
	public String sign(String data, PrivateKey prvKey) throws Exception
	{
		sig.initSign( prvKey );
		sig.update(data.getBytes());
		return Base64.getEncoder().encodeToString(sig.sign());
	}
	
	/**
	 * verify()
	 */
	public boolean verify(String data, String signature, PublicKey pubKey) throws Exception
	{
		sig.initVerify(pubKey);
		sig.update(data.getBytes());
		return sig.verify( Base64.getDecoder().decode(signature));
	}

}
