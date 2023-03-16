package isp.lab5.exercise1;

public class ATM {
    private Bank bank;
    private Card card;

    public ATM(Bank bank) {
        this.bank = bank;
    }

    public void insertCard(Card c, String pin){
        if(card!=null){
            if(c.getCardId().equals(pin)){
                System.out.println("Card accepted.");
                card = c;
            }else{
                System.out.println("Pin is not valid.");
            }
        }else{
            System.out.println("Card already inserted.");
        }
    }

    public void removeCard(){
        card = null;
    }

    public void withdraw(int amount){
        if(card!=null){
            Account acc = bank.getAccountByCardId(card.getCardId());
            Withdraw tw = new Withdraw(amount, acc);
            bank.executeTransaction(tw);

        }else{
            System.out.println("No card present.");
        }
    }
}