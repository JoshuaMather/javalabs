import java.io.InputStream;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class Reader{

// declare low level and high level objects for input
private static InputStream inStream;
private static DataInputStream inDataStream;
// declare low level and high level objects for output
private static OutputStream outStream ;
private static DataOutputStream outDataStream;
// declare a socket
private static Socket connection;

    public static void main (String args[]){
        try {
            // attempt to create a connection to the server
            connection = new Socket("localhost", 8888);
            System.out.println("Connection established");

            // create an input stream from the server
            inStream = connection.getInputStream();
            inDataStream = new DataInputStream(inStream);

            // create an output stream to the server
            outStream = connection.getOutputStream();
            outDataStream = new DataOutputStream(outStream);

            // send the host IP to the server
            outDataStream.writeUTF("HEADLINES");

            int n = inDataStream.readInt();
            for (int i=n; i>0; i--){
                String s = inDataStream.readUTF();
                System.out.println("READER CLIENT: "+s);
            }

        }
        catch(UnknownHostException e){
            System.out.println("Unknown host");
        }
        catch(IOException ie){
            System.out.println("Network Exception");
        }
    }
}
