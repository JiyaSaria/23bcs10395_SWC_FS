class timer extends Thread{
    public void run(){
        for(int i = 10; i>= 1; i--){
            System.out.println(i);
            Thread.sleep(1000);
        }
    }
}
class Blast extends Thread{
    Thread timer;
    public Blast(Thread timer){
        this.timer = timer;
    }
    public void run(){
        timer.join();
        System.out.println("Blast");
    }
}
public class CountdownTimer{
    public static void main(String[] args){
           timer A = new timer();
           Blast B  = new Blast(A);
           A.start();
           B.start();
    }
}
