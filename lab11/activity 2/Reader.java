
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
        //Thread feed1 = new Thread (new Feed(cq));
        Thread feed1 = new Thread (new Feed(cq));
        feed1.start();
        Thread feed2 = new Thread (new Feed(cq));
        feed2.start();


        Thread reader1 = new Thread (new Reader(cq));
        reader1.start();

    }
}
