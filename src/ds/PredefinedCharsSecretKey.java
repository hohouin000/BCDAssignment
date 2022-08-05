/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds;

import java.security.Key;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author rainy
 */
public class PredefinedCharsSecretKey {
    /**
	 * symmetric algorithm
	 */
	private static final String SYMM_ALGORITHM = "AES";
	
	/**
	 * predefined chars (secret)
	 */
	private static final String SECRET_CHARS = "transparent supply chain model";

	public static Key create()
	{
		int keysize = 16;
		return new SecretKeySpec( Arrays.copyOf(SECRET_CHARS.getBytes(), keysize), SYMM_ALGORITHM );
	}
}
