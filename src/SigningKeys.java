import java.security.*;
import java.util.Base64;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SigningKeys {
    private static final String SPEC = "secp256k1";
    private static final String ALGO = "SHA256withECDSA";
    private PublicKey publicKey;
    private PrivateKey privateKey;
    private String pub;
    private String sig;
    private String message;

    public SigningKeys() {
        try {
            ECGenParameterSpec ecSpec = new ECGenParameterSpec(SPEC);
            KeyPairGenerator g = KeyPairGenerator.getInstance("EC");
            g.initialize(ecSpec, new SecureRandom());
            KeyPair keypair = g.generateKeyPair();
            publicKey = keypair.getPublic();
            privateKey = keypair.getPrivate(); 
        } catch (Exception e) {
            System.out.println(e);
        } 
    }

    public String sign(String message) {
        try{
            this.message = message;
            //...... sign
            Signature ecdsaSign = Signature.getInstance(ALGO);
            ecdsaSign.initSign(privateKey);
            ecdsaSign.update(message.getBytes("UTF-8"));
            byte[] signature = ecdsaSign.sign();
            pub = Base64.getEncoder().encodeToString(publicKey.getEncoded());
            sig = Base64.getEncoder().encodeToString(signature);
            System.out.println(sig);
            System.out.println(pub);
            return sig;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } 
    }

    public boolean recieved() {
        try {
            Signature ecdsaVerify = Signature.getInstance(ALGO);
            KeyFactory kf = KeyFactory.getInstance("EC");

            EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(pub));

            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

            ecdsaVerify.initVerify(publicKey);
            ecdsaVerify.update(message.getBytes("UTF-8"));
            boolean result = ecdsaVerify.verify(Base64.getDecoder().decode(sig));

            return result;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } 
    }

    public String getPublicKeyString() {
        return pub;
    }
}