package DataStructure.Recursion;

public class PrintNum {
    public void printNum(int n){
        if(n==1){
            System.out.println(n);
        }
        else{
            System.out.println(n);
            printNum(n-1);
        }
    }

    public static void main(String[] args) {
        PrintNum printNum = new PrintNum();
        printNum.printNum(5);
    }
}
