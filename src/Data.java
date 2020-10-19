import java.time.Date;

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

    public String getTimeStamp() {
        return date;
    }
}