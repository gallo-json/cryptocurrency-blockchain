import java.util.Date;

public class Transaction {
    private int amount;
    private String sender;
    private String reciever;
    private Date date = new Date();

    public Transaction(int amount, String sender, String reciever) {
        this.amount = amount; 
        this.sender = sender;
        this.reciever = reciever;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }
    
    public int getAmount() {
        return amount;
    }

    public String getSender() {
        return sender;
    }

    public String getReciever() {
        return reciever;
    }

    public String getTimeStamp() {
        return date.toString();
    }
}