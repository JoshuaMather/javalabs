public class Feed implements Runnable {
    CommQueue readerQ;

    public Feed(CommQueue q){
        readerQ =  q;
    }

    public void run() {
        String headlines[] =
        { "First headline",
          "Second headline",
          "Third headline",
          "Fourth headline",
          "Fifth headline"
        };

        for (String hl : headlines) {
            readerQ.add(hl);
            try{
                Thread.sleep(0);
            }
            catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
