public class Philosopher extends Thread {
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;
    private final int mealsToEat;

    public Philosopher(int id, Fork leftFork, Fork rightFork, int mealsToEat) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.mealsToEat = mealsToEat;
    }

    private void think() {
        System.out.println("Философ " + id + " размышляет.");
        try {
            Thread.sleep((long) (Math.random() * 100)); // симуляция размышлений
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void eat() {
        System.out.println("Философ " + id + " ест.");
        try {
            Thread.sleep((long) (Math.random() * 100)); // симуляция еды
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < mealsToEat; i++) {
            think();

            // Взять вилки
            leftFork.pickUp();
            rightFork.pickUp();

            eat();

            // Положить вилки
            leftFork.putDown();
            rightFork.putDown();
        }
    }
}