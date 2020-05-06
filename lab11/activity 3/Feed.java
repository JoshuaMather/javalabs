import java.util.concurrent.BlockingQueue;

public class Feed implements Runnable {
    private BlockingQueue bq;

    public Feed(BlockingQueue q){
        bq =  q;
    }

    public void run() {
        String headlines[] =
        { "First headline",
          "Second headline",
          "Third headline",
          "Fourth headline",
          "Fifth headline"
        };
        for (String hl : headlines) {
            try{
                bq.put(hl);
                System.out.println("Feed: "+hl);
            }
            catch(InterruptedException ie){
                System.out.println(ie);
            }
            try{
                Thread.sleep(0);
            }
            catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
