package isp.lab5.exercise5;
import java.util.Scanner;

public interface Carnivorous {
    Scanner myObj = new Scanner(System.in);
    int changeToHuntSuccesfully = myObj.nextInt();
    int average = myObj.nextInt();
    void huntSuccesfully();
    void huntFailed();
    int getChancesToHuntSuccesfully();
}
