package isp.lab5.exercise1;
import java.util.ArrayList;
import java.util.Scanner;


public class Bank extends Account{
    ArrayList<Account> list = new ArrayList<>();
    private String owner;
    private int balance;
    private Card card;
    private final Account a = new Account();
    private String Id;

    public Bank() {
        super();
    }


    public void addAccount(Account a){
        list.add(a);
    }

    public void executeTransaction(Transaction t){
        t.execute();
    }

    @Override
    public String toString(){
        return Id;
    }

    public Account getAccountByCardId(String id){
        Scanner newId = new Scanner(System.in);
        Id = newId.toString();
        if(Id == null ? id == null : Id.equals(id))
            System.out.println(a);
        return null;
    }
}