import java.util.Date;

public class Transaction {
    private int amount;
    private String sender;
    private String reciever;
    private Date date;

    public Transaction(int amount, String sender, String reciever, Date date) {
        this.amount = amount; 
        this.sender = sender;
        this.reciever = reciever;
        this.date = date;
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