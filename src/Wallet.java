public class Wallet {

    private int balance;
    public Wallet(){
        this.balance = 0;
    }
    Wallet(int balance){
        this.balance = balance;
    }
    public synchronized int moneyTransfer(int transferSum) {
        if (this.balance < -transferSum && transferSum < 0){
            return 0;
        } else {
            balance = balance+transferSum;
        }
        return transferSum;
    }
    public int getBalance(){
        return balance;
    }
}
