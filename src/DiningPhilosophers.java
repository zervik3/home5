public class DiningPhilosophers {
    public static void main(String[] args) {
        int numPhilosophers = 5;
        int mealsToEat = 3;
        Philosopher[] philosophers = new Philosopher[numPhilosophers];
        Fork[] forks = new Fork[numPhilosophers];

        // Инициализация вилок
        for (int i = 0; i < numPhilosophers; i++) {
            forks[i] = new Fork();
        }

        // Инициализация философов
        for (int i = 0; i < numPhilosophers; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % numPhilosophers];

            // Избежание взаимоблокировки: последний философ берет сначала правую вилку
            if (i == numPhilosophers - 1) {
                philosophers[i] = new Philosopher(i, rightFork, leftFork, mealsToEat);
            } else {
                philosophers[i] = new Philosopher(i, leftFork, rightFork, mealsToEat);
            }

            philosophers[i].start();
        }

        // Ожидание завершения всех потоков
        for (Philosopher philosopher : philosophers) {
            try {
                philosopher.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
