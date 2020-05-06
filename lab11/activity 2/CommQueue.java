import java.util.Queue;
import java.util.LinkedList;

public class CommQueue {
    private Queue<String> q;
    private int MAX=3;


    public CommQueue(){
        q = new LinkedList<>();
    }

    public int size(){
        return q.size();
    }


    public synchronized void add(String s) {
        while (size()==MAX) {
            try {
                System.out.println(Thread.currentThread()+"producer waiting");
                wait();
            }
            catch (InterruptedException e)  {
                System.out.println(e);
            }
        }
        q.add(s);
        System.out.println("Into the queue: "+s);
        notifyAll();
    }

    public synchronized String remove() {

        while (size()==0) {
            try {
                System.out.println(Thread.currentThread()+"consumer waiting");
                wait();
            }
            catch (InterruptedException e)  {
                System.out.println(e);
            }
        }
        notifyAll();
        return (String) q.remove();
    }
}
