public class Transfer implements Runnable{
    private final Wallet from;
    private final Wallet to;
    private final int summ;
    private String isTransfer;
    @Override
    public void run() {
        if (summ < 0){
            this.isTransfer = "Error";
            return;
        }
        int s = from.moneyTransfer(-summ);
        if (s == -summ){
            to.moneyTransfer(summ);
            this.isTransfer="Yes";
            return;
        }
        this.isTransfer = "Error";
    }
    public Transfer (Wallet from, Wallet to, int summ ) {
        this.from = from;
        this.to = to;
        this.summ = summ;
        this.isTransfer = "Not start";
    }

    public String getIsTransfer(){
        return isTransfer;
    }


}
