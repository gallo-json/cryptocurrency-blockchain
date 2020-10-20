import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Base64;
import java.security.spec.ECGenParameterSpec;

public class Key {
    public static void generateKeys() {
        try {
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp256k1");
            KeyPairGenerator g = KeyPairGenerator.getInstance("EC");
            g.initialize(ecSpec, new SecureRandom());
            KeyPair keypair = g.generateKeyPair();
            PublicKey publicKey = keypair.getPublic();
            PrivateKey privateKey = keypair.getPrivate(); 

            String pub = Base64.getEncoder().encodeToString(publicKey.getEncoded());
            String priv = Base64.getEncoder().encodeToString(privateKey.getEncoded());

            System.out.println(pub);
            System.out.println(priv);
        } catch (Exception e) {
            System.out.println(e);
        } 

    }
}