class Chef1 extends Thread {

    Object knife;
    Object board;

    Chef1(Object knife, Object board) {
        this.knife = knife;
        this.board = board;
    }

    @Override
    public void run() {

        synchronized (knife) {

            System.out.println("Chef1 got Knife");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Chef1 waiting for Board");

            synchronized (board) {
                System.out.println("Chef1 cooking");
            }
        }
    }
}

class Chef2 extends Thread {

    Object knife;
    Object board;

    Chef2(Object knife, Object board) {
        this.knife = knife;
        this.board = board;
    }

    @Override
    public void run() {

        synchronized (board) {

            System.out.println("Chef2 got Board");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Chef2 waiting for Knife");

            synchronized (knife) {
                System.out.println("Chef2 cooking");
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Object knife = new Object();
        Object board = new Object();

        Chef1 c1 = new Chef1(knife, board);
        Chef2 c2 = new Chef2(knife, board);

        c1.start();
        c2.start();
    }
}
