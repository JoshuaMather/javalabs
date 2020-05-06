import java.util.concurrent.BlockingQueue;
import java.io.DataOutputStream;

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

        // for (String hl : headlines) {
        //     bq.add(hl);
        //     System.out.println("Feed: "+hl+" into queue");

        //     try{
        //         Thread.sleep(0);
        //     }
        //     catch (InterruptedException e){
        //         System.out.println(e);
        //     }
        // }

        connection = new Socket("localhost",	8888);	
        inStream = connection.getInputStream();	
        inDataStream = new DataInputStream(inStream);	
        outStream = connection.getOutputStream();	
        outDataStream =	new	DataOutputStream(outStream);	
        outDataStream.writeInt(Integer.parseInt(args[0]));	
        outDataStream.writeInt(Integer.parseInt(args[1]));	
        int	result = inDataStream.readInt();	
        System.out.println("Server	result:	"+result);	
    }
}
