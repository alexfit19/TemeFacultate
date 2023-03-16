package isp.lab5.exercise5;
import java.util.Scanner;

public interface Herbivorous {
    Scanner myObj = new Scanner(System.in);
    int changeToRunSuccesfully = myObj.nextInt();
    int limit = myObj.nextInt();
    public void runSuccesfully();
    public void runFailed();
    public int getChancesToRunSuccesfully();
}
