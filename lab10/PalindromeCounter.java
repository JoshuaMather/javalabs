import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.HashMap;

// /mnt/c/Program\ Files/Java/jdk-11.0.6/bin/javac.exe PalindromeCounter.java
// /mnt/c/Program\ Files/Java/jdk-11.0.6/bin/java.exe PalindromeCounter

public class PalindromeCounter{

    public static boolean isPalindrome(String s) {
        if (s.length() < 2) return true;
          if (s.charAt(0) != s.charAt(s.length()-1)) return false;
          return isPalindrome(s.substring(1, s.length()-1));
    }

    public static void read(){
        //HashSet h = new HashSet<>();
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        try(
            BufferedReader br = new BufferedReader(new FileReader("sampletext.txt"))
        ){
            String line = br.readLine();
            while(line != null){
                //System.out.println(line);
                //h.add(line);

                // if(hm.containsKey(line)){
                //     //System.out.println(hm.get(line));
                //     hm.put(line, hm.get(line) + 1);
                // }else{
                //     hm.put(line, Integer.valueOf(1));
                // }

                if(hm.containsKey(line) && isPalindrome(line)){
                    hm.put(line, hm.get(line)+1);
                }else if(isPalindrome(line)){
                    hm.put(line, Integer.valueOf(1));
                }
                //hm.merge(line, 1, Integer::sum);


                line = br.readLine();
            }
            System.out.println(hm);
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public static void main(String args[]){
        read();
    }
    
}