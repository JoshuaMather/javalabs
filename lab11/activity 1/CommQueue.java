import java.util.Queue;
import java.util.LinkedList;

public class CommQueue {
    private Queue<String> q;

    private boolean transfer = true;

    public CommQueue(){
        q = new LinkedList<>();
    }


    public synchronized void add(String s) {
        while (!transfer) {
            try {
                //System.out.println(Thread.currentThread()+"producer waiting");
                wait();
            }
            catch (InterruptedException e)  {
                System.out.println(e);
            }
        }
        q.add(s);
        transfer = false;
        notifyAll();
    }

    public synchronized String remove() {

        while (transfer) {
            try {
                //System.out.println(Thread.currentThread()+"consumer waiting");
                wait();
            }
            catch (InterruptedException e)  {
                System.out.println(e);
            }
        }
        transfer = true;
        notifyAll();
        return (String) q.remove();
    }
}
