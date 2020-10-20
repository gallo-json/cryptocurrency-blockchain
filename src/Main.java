import java.util.Date;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Blockchain pepegaCoin = new Blockchain();
        pepegaCoin.addBlock(new Data(10, "Jose", "Tarek", new Date()));
        pepegaCoin.addBlock(new Data(2, "Tarek", "Sergei", new Date()));
        pepegaCoin.printAsString();
        System.out.println(pepegaCoin.isChainValid());
    }
}