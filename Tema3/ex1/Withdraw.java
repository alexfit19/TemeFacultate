package isp.lab5.exercise1;

public class Withdraw extends Transaction {
    private int amount;

    public Withdraw(int amount, Account account) {
        super(account);
        this.amount = amount;

    }

    public int getAmount() {
        return amount;
    }

    public String execute(){
        if(account.getBalance()>amount){
            account.setBalance(account.getBalance()-amount);
            System.out.println("Transaction executed");
        }
        return "EXECUTED!";
    }
}
