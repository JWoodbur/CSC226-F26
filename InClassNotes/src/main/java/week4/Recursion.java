package week4;


public class Recursion {
    public int fib(int n){
        if (n <= 1){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
    public static Integer countHi(String value, String word){
        int valueLength = value.length();
        int wordLength = word.length();
        if (value == null || valueLength < wordLength){
            return 0;
        }
        if (value.substring(0, wordLength).equals(word)){
            return countHi(value.substring(1), word) + 1;
        }
        return countHi(value.substring(1), word);
    }
    public static <T> void iterativePrinter(LLNode<T> node){
        while(node !=null){
            if(node.getInfo()!=null){
                System.out.println(node.getInfo());
            }
            node=node.getNext();
        }
    }
    public static <T> void recursivePrinter(LLNode<T> node){
        if(node == null){
            return;
        }
        if(node.getInfo()!=null){
            System.out.println(node.getInfo());
        }
        recursivePrinter(node.getNext());
       
    }

    public static <T> int recursiveCounter(LLNode<T> node, int counter){
        if(node == null){
            return counter;
        }
        if(node.getInfo()!=null){
            counter++;
        }
        return recursiveCounter(node.getNext(), counter);
        
    }

}
