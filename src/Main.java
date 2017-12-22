import java.util.Random;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        int numWallets = 6;
        int maxBalance = 10000;
        int numTransfers = 1000000;
        final Random random = new Random();
        Vector<Wallet> wallets = new Vector<>();
        Vector<Transfer> transfers = new Vector<>();

        for (int i=0; i<numWallets; i++){
            wallets.add(new Wallet(random.nextInt(maxBalance)));
        }
        for (int i=0; i<numTransfers; i++){
            int summ = random.nextInt(maxBalance*2);
            int from = random.nextInt(numWallets);
            int to = random.nextInt(numWallets);
            Transfer t = new Transfer(wallets.get(from), wallets.get(to), summ);
            t.run();
            transfers.add(t);
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex){
            System.out.println("sleep error");
            return;
        }
        for (Transfer t : transfers){
            if(t.getIsTransfer().equals("Not start")){
                System.out.println("Где то закралась ошибка");
                //такого не случалось
            }
        }
    }
}
