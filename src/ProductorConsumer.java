public class ProductorConsumer {
    public static void main(String[] args) {
        SynContainer container=new SynContainer();
        Productor p=new Productor(container);
        Consumer c=new Consumer(container);
        p.start();
        c.start();
    }
}
//生产者
class Productor extends Thread{
    SynContainer container;
    public Productor(SynContainer container){
        this.container=container;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++) {
            try {
                Chicken chicken=new Chicken(i);
                container.push(chicken);
                System.out.println("生产了"+i+"只鸡");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
//消费者
class Consumer extends Thread{
    SynContainer container;
    public Consumer(SynContainer container){
        this.container=container;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++) {

            int id= 0;
            try {
                id = container.pop().getId();
                System.out.println("消费了"+id+"只鸡");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
//产品
class Chicken{
    private int id;//产品编号

    public Chicken(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
//缓冲区
class SynContainer{
    //容器大小
    private Chicken[] chickens=new Chicken[10];
    private static int count=0;
    //生产者生产产品
    public  synchronized void push(Chicken chicken) throws InterruptedException {
        //容器满了，需要等待消费者消费
        while(count==10){
            //通知消费者消费，生产者等待
            this.wait();
        }
        //没满，生产产品
        chickens[count]=chicken;
        count++;
        //通知消费者消费
        this.notifyAll();
    }
    //消费者消费产品
    public synchronized Chicken pop() throws InterruptedException {
        while (count==0){
            this.wait();
        }
        count--;
        Chicken chicken=chickens[count];
        this.notifyAll();
        return chicken;
    }
}