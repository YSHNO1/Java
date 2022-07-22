package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitExample {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void before(){
        lock.lock();
        try{
            System.out.println("before");
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
    public void after(){
        lock.lock();
        try{
            condition.await();
            System.out.println("after");
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AwaitExample example = new AwaitExample();
        executorService.execute(() -> example.after());
        executorService.execute(() -> example.before());
    }
}