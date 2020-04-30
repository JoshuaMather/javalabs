import java.util.Queue;
import java.util.LinkedList;


public class CommQueue {
    private Queue<String> q;
    private boolean b = false;
    

    CommQueue(){
        q = new LinkedList<String>();
    }


    public synchronized void add(String s){
        if(q.size() == 2){
            b = true;
        }
        while(b){
            try{
                wait();
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
        this.q.add(s);
        b = true;
        notifyAll();
    }

    public synchronized String remove(){
        if(q.size() == 0){
            b = false;
        }
        while(!b){
            try{
                wait();
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
        b = false;
        notifyAll();
        return this.q.remove();    
    }



}