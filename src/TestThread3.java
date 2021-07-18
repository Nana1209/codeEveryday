/**
 * 买火车票
 */
public class TestThread3 implements Runnable{
    //票数
    private static int ticketNums=10;
    @Override
    public void run() {

        while(ticketNums>=0){
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了"+ticketNums--+"票");
        }
    }

    public static void main(String[] args) {
        TestThread3 t3=new TestThread3();
        new Thread(t3,"nana").start();
        new Thread(t3,"xinyu").start();
        new Thread(t3,"黄牛").start();
    }
}
