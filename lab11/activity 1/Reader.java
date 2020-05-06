
public class Reader implements Runnable {

    CommQueue readerQ;

    public Reader(CommQueue q){
        readerQ =  q;
    }

    public void run() {
        while (true){
            String s=readerQ.remove();
            System.out.println("Reader: "+s);
        }
    }

    public static void main (String args[]){
        CommQueue cq = new CommQueue();
        Thread feed = new Thread (new Feed(cq));
        feed.start();

        Thread reader = new Thread (new Reader(cq));
        reader.start();

    }
}
