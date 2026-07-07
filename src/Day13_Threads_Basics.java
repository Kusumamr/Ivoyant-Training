class Counter{
    int count=0;

    synchronized void increment(){
        count++;
    }
}
class NumberThread extends Thread{
    String threadName;

    NumberThread(String ThreadName){
        this.threadName=ThreadName;
    }

    @Override
    public void run(){
        for(int i=1;i<=5;i++) {
            System.out.println(threadName + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
class CounterThread extends Thread{
    Counter counter;

    CounterThread(Counter counter){
        this.counter=counter;
    }

    @Override
    public void run(){
        for (int i=1;i<=1000;i++){
            counter.increment();
        }
    }
}
public class Day13_Threads_Basics {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Printing number using 3 threads");

        NumberThread t1=new NumberThread("Thread 1");
        NumberThread t2=new NumberThread("Thread 2");
        NumberThread t3=new NumberThread("Thread 3 ");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Race condition with synchronization : ");

        Counter counter=new Counter();

        CounterThread c1=new CounterThread(counter);
        CounterThread c2=new CounterThread(counter);

        c1.start();
        c2.start();

        c1.join();
        c2.join();

        System.out.println("The value of counter is " + counter.count);


    }
}
