import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Reader implements Runnable {

    //CommQueue readerQ;
    BlockingQueue<String> bq;

    // public Reader(CommQueue q){
    //     readerQ =  q;
    // }

    public Reader(BlockingQueue q){
        bq =  q;
    }

    public synchronized void run() {
        while (true){
            try{
                String s=bq.take();
                System.out.println("Reader: "+s);
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }

    public static void main (String args[]){
        //CommQueue cq = new CommQueue();
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>();
        Thread feed = new Thread (new Feed(blockingQueue));
        Thread feed2 = new Thread (new Feed(blockingQueue));
        feed.start();
        feed2.start();

        Thread reader = new Thread (new Reader(blockingQueue));
        reader.start();

    }
}
