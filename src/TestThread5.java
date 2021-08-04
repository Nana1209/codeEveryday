import java.util.concurrent.atomic.AtomicInteger;

public class TestThread5{

    public static void main(String[] args) {
        ConCurrentInt cint=new ConCurrentInt();
        new Thread1(cint).start();
        new Thread2(cint).start();
        new Thread3(cint).start();
    }
}
class ConCurrentInt{
    AtomicInteger aint=new AtomicInteger(0);
    public synchronized void firstPrint(){
        if(aint.get()==0){
            System.out.println("first"+Thread.currentThread().getName());
            aint.getAndIncrement();
            this.notifyAll();
        }
    }
    public synchronized void secondPrint(){
        if(aint.get()!=1){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            System.out.println("second"+Thread.currentThread().getName());
            aint.getAndIncrement();
            this.notifyAll();

    }
    public synchronized void tirdPrint(){
        if(aint.get()!=2){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("tird"+Thread.currentThread().getName());

    }

}
class Thread1 extends Thread{
    ConCurrentInt cint;
    public Thread1(ConCurrentInt cint){
        this.cint=cint;
    }
    @Override
    public void run() {
        cint.firstPrint();
    }
}
class Thread2 extends Thread{
    ConCurrentInt cint;
    public Thread2(ConCurrentInt cint){
        this.cint=cint;
    }
    @Override
    public void run() {
        cint.secondPrint();
    }
}
class Thread3 extends Thread{
    ConCurrentInt cint;
    public Thread3(ConCurrentInt cint){
        this.cint=cint;
    }
    @Override
    public void run() {
        cint.tirdPrint();
    }
}