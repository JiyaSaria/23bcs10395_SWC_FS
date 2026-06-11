class PiggyBank{
    int balance = 0;
    synchronized void add(){
        balance++;
    }
}
class A extends Thread{
    PiggyBank bank;
    A(PiggyBank bank){
        this.bank = bank;
    }
    @Override
    public void run(){
        for(int i = 0; i< 2000; i++){
            bank.add();
        }
    }
}
public class PiggyBank{
    public static void main(String[] args) throws InterruptedException{
        PiggyBank obj = new PiggyBank();
        A a = new A(obj);
        A b = new A(obj);
        A c = new A(obj);
        A d = new A(obj);
        A e = new A(obj);
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();

        b.join();
        c.join();
        d.join();
        e.join();
        System.out.print(obj.balance);
    }
}
