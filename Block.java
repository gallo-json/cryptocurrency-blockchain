import java.security.NoSuchAlgorithmException;  

public class Block {
    public static void main(String args[]) {  
        try { 
            String s1 = "cock";  
            System.out.println("\n" + s1 + " : " + Hash.toHexString(Hash.getSHA(s1)));  
        } 
        // For specifying wrong message digest algorithms  
        catch (NoSuchAlgorithmException e) {  
            System.out.println("Exception thrown for incorrect algorithm: " + e);  
        }  
    }  
    
}