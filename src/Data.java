import java.util.Date;

public class Data {
    private int amount;
    private String sender;
    private String reciever;
    private Date date;

    public Data(int amount, String sender, String reciever, Date date) {
        this.amount = amount; 
        this.sender = sender;
        this.reciever = reciever;
        this.date = date;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void getSender(String sender) {
        this.sender = sender;
    }

    public void getReciever(String reciever) {
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