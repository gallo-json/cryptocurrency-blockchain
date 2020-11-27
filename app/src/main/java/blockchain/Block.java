package blockchain;

import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.json.*;

public class Block {
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private byte[] previousHash;
    private byte[] hash;
    private int nonce = 0;

    public Block(Transaction transaction, byte[] previousHash) {
        transactions.add(transaction);
        this.previousHash = previousHash;
        try {
            this.hash = calculateHash();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
    }

    public Block(ArrayList<Transaction> t, byte[] previousHash) {
        transactions.addAll(t);
        this.previousHash = previousHash;
        try {
            this.hash = calculateHash();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
    }

    public byte[] calculateHash() throws NoSuchAlgorithmException {
        String stringToHash = Hash.toHexString(previousHash) + nonce;
        for (Transaction t : transactions) stringToHash += (t.getAmount() + t.getSender() + t.getReciever() + t.getTimeStamp());
        return Hash.getSHA(stringToHash);
    }

    public void mineBlock(int difficulty) {
        String zeros = String.join("", Collections.nCopies(difficulty, "0"));
        
        while(!((Hash.toHexString(hash).substring(0, difficulty)).equals(zeros))) {
            try {
                nonce++;
                hash = calculateHash();
            } catch (NoSuchAlgorithmException e) {
                System.out.println(e);
            }
        }

        System.out.println("Block mined: " + hash);
    } 

    public boolean hasValidTransactions() {
        for (Transaction t : transactions) {
            try {
                return t.isValid();
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public void setPreviousHash(byte[] previousHash) {
        this.previousHash = previousHash;
    }

    public void setHash(byte[] hash) {
        this.hash = hash;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    public byte[] getHash() {
        return hash;
    }

    public void printAsString() {
        System.out.println("BLOCK");
        for (Transaction t : transactions) {
            System.out.println("\tTRANSACTION");
            System.out.println("\t\tAmount: " + t.getAmount());
            System.out.println("\t\tSender: " + t.getSender());
            System.out.println("\t\tReciever: " + t.getReciever());
            System.out.println("\t\tTime stamp: " + t.getTimeStamp());
        }

        System.out.println("\tPrevious hash: " + Hash.toHexString(previousHash));
        System.out.println("\tHash: " + Hash.toHexString(hash));
        System.out.println("\tNonce: " + nonce + "\n");
    }

    public JsonObject getJSON() {
        JsonObject obj = Json.createObjectBuilder().build();

        for (Transaction t : transactions) {
            obj = JsonUtils.append(obj, "amount", Integer.toString(t.getAmount()));
            obj = JsonUtils.append(obj, "sender", t.getSender());
            obj = JsonUtils.append(obj, "receiver", t.getReciever());
            obj = JsonUtils.append(obj, "time stamp", t.getTimeStamp());
        }

        obj = JsonUtils.append(obj, "previous hash", Hash.toHexString(previousHash));
        obj = JsonUtils.append(obj, "hash", Hash.toHexString(hash));
        obj = JsonUtils.append(obj, "nonce", Integer.toString(nonce));

        return obj;
    }
}