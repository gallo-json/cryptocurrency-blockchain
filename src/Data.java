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