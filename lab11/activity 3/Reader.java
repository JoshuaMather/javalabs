import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Reader implements Runnable {
    private BlockingQueue bq;

    public Reader(BlockingQueue q){
        bq =  q;
    }

    public void run() {
        while (true){
            try{
                String s=(String) bq.take();
                System.out.println("Reader: "+s);
            }
            catch(InterruptedException ie){
                System.out.println(ie);

            }
        }
    }

    public static void main (String args[]){
        BlockingQueue<String> cq = new LinkedBlockingQueue<String>();
        //Thread feed1 = new Thread (new Feed(cq));
        Thread feed1 = new Thread (new Feed(cq));
        feed1.start();
        Thread feed2 = new Thread (new Feed(cq));
        feed2.start();
        Thread feed3 = new Thread (new Feed(cq));
        feed3.start();

        Thread reader1 = new Thread (new Reader(cq));
        reader1.start();

    }
}
