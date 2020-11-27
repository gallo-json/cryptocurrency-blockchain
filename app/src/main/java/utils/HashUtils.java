package blockchain.utils;

import java.math.BigInteger;  
import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {  
        // Static getInstance method is called with hashing SHA  
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
        return encodedhash;
    } 
    
    public static String toHexString(byte[] hash) { 
	    StringBuilder hexString = new StringBuilder(2 * hash.length);
	    for (int i = 0; i < hash.length; i++) {
	        String hex = Integer.toHexString(0xff & hash[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }
	    return hexString.toString();
	} 
	
	public static byte[] toByteArray(String hexString) {
		byte[] val = new byte[hexString.length() / 2];
		for (int i = 0; i < val.length; i++) {
		   int index = i * 2;
		   int j = Integer.parseInt(hexString.substring(index, index + 2), 16);
		   val[i] = (byte) j;
		}

		return val;
	}
}