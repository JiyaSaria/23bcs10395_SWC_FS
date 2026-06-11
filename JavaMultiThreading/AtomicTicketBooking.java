import java.util.concurrent.atomic.AtomicInteger;

class User extends Thread {

    AtomicInteger seats;

    User(AtomicInteger seats) {
        this.seats = seats;
    }

    @Override
    public void run() {

        while (true) {

            int currentSeats = seats.get();

            if (currentSeats <= 0) {
                System.out.println(
                        getName() +
                        " : No seats available"
                );
                return;
            }

            if (seats.compareAndSet(
                    currentSeats,
                    currentSeats - 1)) {

                System.out.println(
                        getName() +
                        " booked seat. Remaining = "
                        + (currentSeats - 1)
                );

                return;
            }
        }
    }
}

public class AtomicTicketBooking {

    public static void main(String[] args)
            throws InterruptedException {

        AtomicInteger seats =
                new AtomicInteger(10);

        User[] users = new User[100];

        for (int i = 0; i < 100; i++) {

            users[i] = new User(seats);

            users[i].start();
        }

        for (int i = 0; i < 100; i++) {
            users[i].join();
        }

        System.out.println(
                "\nFinal Seats = "
                + seats.get()
        );
    }
}
