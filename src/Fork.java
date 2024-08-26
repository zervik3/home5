import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {
    private final Lock lock = new ReentrantLock();

    public void pickUp() {
        lock.lock();
    }

    public void putDown() {
        lock.unlock();
    }
}

