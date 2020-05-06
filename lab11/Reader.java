import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.io.DataInputStream;

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
        // while (true){
        //     try{
        //         String s=bq.take();
        //         System.out.println("Reader: "+s);
        //     }catch(InterruptedException e){
        //         System.out.println(e);
        //     }
        // }


        while(true){		
			listenSocket = new	ServerSocket(port);	
			connection = listenSocket.accept();	
			connected =	true;		
			inStream =	connection.getInputStream();		
			inDataStream =	new	DataInputStream(inStream);	
			outStream =	connection.getOutputStream	();		
			outDataStream =	new	DataOutputStream(outStream);	
			while(connected){	
                    //create list, add to list, use list size
					first =	inDataStream.readInt();		
					second = inDataStream.readInt();		
					outDataStream.writeInt(first+second);	
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
