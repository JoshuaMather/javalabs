import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Palindrome{
    private List<Character> palindrome;

    public Palindrome(char[] characters){
        // this.palindrome = new ArrayList<Character>();
        this.palindrome = new Stack<Character>();
        for(char character: characters){
            Character ch = character;
            this.palindrome.add(ch);
        }
        
    }


    public String toString(){
        String s = "";
        for(Character c: this.palindrome){
            s = s + c;
        }
        return s;
    }


    public boolean lengthIsEven(){
        if(this.palindrome.size()%2==0){
            return true;
        }
        return false;
    }


    public List<Character> firstHalf(){
        int mid = (this.palindrome.size()/2);
        List<Character> fh = this.palindrome.subList(0, mid);
        return fh;
    }


    public List<Character> lastHalf(){
        int mid = (this.palindrome.size()/2);
        List<Character> lh = this.palindrome.subList(mid, this.palindrome.size());
        return lh;
    }


    public boolean check(){
        Stack<Character> pStack = new Stack<Character>();
        List<Character> fh = firstHalf();
        fh.forEach(c ->
        {
            pStack.push(c);
        });

        List<Character> lh = lastHalf();
        for(Character c: lh){
            Character checkC = pStack.pop();
            if(checkC != c){
                return false;
            }
        }
        return true;

    }

    public static void main(String args[]){
        char[] charArray = {'a', 'n', 'n', 'a'};
        Palindrome p = new Palindrome(charArray);

        // System.out.print(p.toString());
        // System.out.println(p.lengthIsEven());
        // System.out.println(p.firstHalf());
        // System.out.println(p.lastHalf());

        System.out.println(p.check());
    }
}