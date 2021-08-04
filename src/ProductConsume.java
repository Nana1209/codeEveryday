import java.util.Deque;
import java.util.LinkedList;

public class ProductConsume {
    public static void main(String[] args) {
        Deque<Integer> queue=new LinkedList<>();
        Thread productor=new Productor1(queue);
        Thread consumer=new Consumer1(queue);
        productor.start();
        consumer.start();

    }
}
class Productor1 extends Thread{
    private Deque<Integer> queue;
    public Productor1(Deque<Integer> queue){
        this.queue=queue;
    }
    @Override
    public void run() {
        product();
    }

    private void product() {
        while (true){
            synchronized (queue){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(queue.size()==10){
                    try {
                        queue.wait();
                        System.out.println("productor wait");
                    } catch (InterruptedException e) {
                        queue.notify();;
                    }
                }
                queue.offer(1);
                System.out.println("product 1");
                queue.notifyAll();
            }
        }
    }
}
class Consumer1 extends Thread{
    private Deque<Integer> queue;
    public Consumer1(Deque<Integer> queue){
        this.queue=queue;
    }
    public void consumer(){
        while (true){
            synchronized (queue){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(queue.size()==0){
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        queue.notify();
                    }
                    System.out.println("consumer wait");
                }
                queue.poll();
                System.out.println("consume 1");
                queue.notifyAll();
            }

        }
    }

    @Override
    public void run() {
        consumer();
    }
}