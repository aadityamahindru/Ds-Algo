import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printKPC(str, "");
        System.out.println();

    }
    public static String[] val = {
        ".;",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tu",
        "vwx",
        "yz"
    };
    public static void printKPC(String str, String asf) {
        if(str.length()==0)
        {
            System.out.println(asf);
            return;
        }
        char ch1=str.charAt(0);
        String roq=str.substring(1);
        int n1=Integer.parseInt(ch1+"");
        String s1=val[n1];
        for(int i=0;i<s1.length();i++)
        {
            printKPC(roq,asf+s1.charAt(i));
        }
        

    }

}