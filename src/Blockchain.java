import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Blockchain {
    private ArrayList<Block> blockchain = new ArrayList<Block>();
    private ArrayList<Transaction> pendingTransactions = new ArrayList<Transaction>();
    private static final int miningReward = 100;
    private static final int difficulty = 7;

    public Blockchain() {
        byte[] genesisHash = new byte[0];
        // Genesis block
        blockchain.add(new Block(new Transaction(0, "Genesis", "Genesis"), genesisHash));
    }

    public Block getBlock(int i) {
        return blockchain.get(i);
    }
    
    private Block getLatestBlock() {
        return blockchain.get(blockchain.size() - 1);
    }

    public void addBlock(Transaction transaction) {
        Block newBlock = new Block(transaction, getLatestBlock().getHash());
        newBlock.mineBlock(difficulty);
        blockchain.add(newBlock);
        
    }

    public void addBlock(ArrayList<Transaction> transactions) {
        Block newBlock = new Block(transactions, getLatestBlock().getHash());
        newBlock.mineBlock(difficulty);
        blockchain.add(newBlock);
        
    }

    public void minePendingTransactions(String minerAddress) {
        Transaction reward = new Transaction(miningReward, "System", minerAddress);
        pendingTransactions.add(reward);

        addBlock(pendingTransactions);
        pendingTransactions.clear();
    }

    public void addTransaction(Transaction transaction) throws Exception {
        if (transaction.getSender().length() == 0 || transaction.getReciever().length() == 0) {
            throw new Exception("Transaction must have a to and from address");
        }
        if (!transaction.isValid()) {
            throw new Exception("Cannot add invalid transaction to block.");
        }
        pendingTransactions.add(transaction);
    }

    public int getBalance(String address) {
        int balance = 0;

        for (Block block : blockchain) {
            for (Transaction t : block.getTransactions()) {
                if (t.getSender().equals(address)) balance -= t.getAmount();
                if (t.getReciever().equals(address)) balance += t.getAmount();
            }
        }
        return balance;
    }

    public boolean isChainValid() {
        for (int i = 1; i < blockchain.size(); i++) {
            Block currentBlock = blockchain.get(i);
            Block previousBlock = blockchain.get(i - 1);
            
            try {
                if (!Arrays.equals(currentBlock.getHash(), currentBlock.calculateHash())) return false;

                if (!Arrays.equals(previousBlock.getHash(), previousBlock.calculateHash())) return false;
            } catch (NoSuchAlgorithmException e) {
                System.out.println(e);
                return false;
            }

            if (!currentBlock.hasValidTransactions()) {
                System.out.println("Corrupted tranactions!");
                return false;
            }
        }
        return true;
    }

    public void printAsString() {
        for (Block block : blockchain) {
            block.printAsString();
        }
    }

    public void clearTransactions() {
        blockchain.clear();
    }
}