import java.util.concurrent.BlockingQueue;

public class Feed implements Runnable {
    //CommQueue readerQ;
    BlockingQueue<String> bq;


    // public Feed(CommQueue q){
    //     readerQ =  q;
    // }

    public Feed(BlockingQueue q){
        bq =  q;
    }

    public synchronized void run() {
        String headlines[] =
        { "First headline",
          "Second headline",
          "Third headline",
          "Fourth headline",
          "Fifth headline"
        };

        for (String hl : headlines) {
            bq.add(hl);
            System.out.println("Feed: "+hl+" into queue");

            try{
                Thread.sleep(0);
            }
            catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
