package isp.lab5.exercise1;


import java.util.ArrayList;


public class Exercise1 {

   public static void main(String[] args) {
        Card c1 = new Card("12345","0000");
        Account a1 = new Account();

        Bank bank = new Bank();
        bank.addAccount(a1);

        ATM atm = new ATM(bank);

        atm.insertCard(c1,"0000");

        atm.withdraw(900);

    }
}
