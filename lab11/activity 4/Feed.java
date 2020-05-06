
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Feed{

    public static void main (String[] args){
        String headlines[] =
        { "First headline",
          "Second headline",
          "Third headline",
          "Fourth headline",
          "Fifth headline"
        };
        // declare a "general" socket and a server socket
        Socket connection;
        ServerSocket listenSocket;

        // declare low level and high level objects for input
        InputStream inStream;
        DataInputStream inDataStream;

        // declare low level and high level objects for output
        OutputStream outStream;
        DataOutputStream outDataStream;

        // declare other variables
        String client;
        int first, second, sum;
        boolean connected;

        while(true){
            try{
                listenSocket = new ServerSocket(8888);
                System.out.println("Listening on port 8888");
                // listen for a connection from the client
                connection = listenSocket.accept();
                System.out.println("Connection established");
                connected = true;

                // create an input stream from the client
                inStream = connection.getInputStream();
                inDataStream = new DataInputStream(inStream);

                // create an output stream to the client
                outStream = connection.getOutputStream ();
                outDataStream = new DataOutputStream(outStream);

                // wait for a string from the client
                while(connected){
                    client = inDataStream.readUTF();
                    if (client.equals("HEADLINES")){
                        outDataStream.writeInt(headlines.length);
                        System.out.println("FEED SERVER. Number of headlines:" + headlines.length);

                        for (String hl : headlines) {
                            outDataStream.writeUTF(hl);
                            System.out.println("Server:" + hl);

                        }
                    }
                }

            }
            catch (IOException e) {
                connected = false;
            }

        }
    }
}
