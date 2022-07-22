package Thread;

public class SynchronizedObjectLock implements Runnable{
    static SynchronizedObjectLock instance = new SynchronizedObjectLock();
    //两把锁
    Object lock1 = new Object();
    Object lock2 = new Object();
    @Override
    public void run() {
        synchronized (lock1){
            System.out.println("lock1锁，我是线程" + Thread.currentThread().getName());
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("lock1锁" + Thread.currentThread().getName() + "结束");
        }
        synchronized (lock2){
            System.out.println("lock2锁，我是线程" + Thread.currentThread().getName());
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("lock2锁" + Thread.currentThread().getName() + "结束");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
    }
    
}
