package blockchain;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.*;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SigningKeys {
    private static final String SPEC = "secp256k1";
    private static final String ALGO = "SHA256withECDSA";

    public KeyPair generate() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, UnsupportedEncodingException, SignatureException{
        ECGenParameterSpec ecSpec = new ECGenParameterSpec(SPEC);
        KeyPairGenerator g = KeyPairGenerator.getInstance("EC");
        g.initialize(ecSpec, new SecureRandom());
        KeyPair keypair = g.generateKeyPair();
        PublicKey publicKey = keypair.getPublic();
        PrivateKey privateKey = keypair.getPrivate();

        System.out.println("Public: " + Base64.getEncoder().encodeToString(publicKey.getEncoded()));
        System.out.println("Private: " + Base64.getEncoder().encodeToString(privateKey.getEncoded()));

        return keypair;
    }

    public String[] sign(String message, KeyPair keyPair) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, UnsupportedEncodingException, SignatureException {
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        //...... sign
        Signature ecdsaSign = Signature.getInstance(ALGO);
        ecdsaSign.initSign(privateKey);
        ecdsaSign.update(message.getBytes("UTF-8"));
        byte[] signature = ecdsaSign.sign();
        String pub = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        String sig = Base64.getEncoder().encodeToString(signature);
        System.out.println("Signature: " + sig);

        String[] obj = {pub, sig, message, ALGO};

        return obj;
    }

    public boolean received(String[] obj) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, UnsupportedEncodingException, SignatureException {
        Signature ecdsaVerify = Signature.getInstance(obj[3]);
        KeyFactory kf = KeyFactory.getInstance("EC");

        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(obj[0]));

        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

        ecdsaVerify.initVerify(publicKey);
        ecdsaVerify.update(obj[2].getBytes("UTF-8"));
        boolean result = ecdsaVerify.verify(Base64.getDecoder().decode(obj[1]));

        return result;
    }

    public String toString(PrivateKey key) {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }
    
    public String toString(PublicKey key) {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }
}