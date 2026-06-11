class Search extends Thread{
    String text;
    String word;
    int start;
    int end;
    Search( String text,
    String word,
    int start,
    int end){
        this.text = text;
        this.word  = word;
        this.start = start;
        this.end = end;
    }
    public void run(){
        String part = text.substring(start, end);
        if(part.contains(word)){
            System.out.println(
                    getName() + "found" + word ;
            )
        }
        else{
            System.out.println(
                    getName() + "did not found" + word;
            )
        }
    }
}
public class MultiThreadTextSearch{
    public static void main(String[] args){
       String text = "";
       String word = "Java";

       int len = text.length();
       int part = len/3;
       Search A = new Seach(text,word,0,part);
       Search B = new Search(text,word, part, part + part);
       Search C = new Search(text, word, part + part, len);

       A.start();
       B.start();
       C.start();
    }
}
