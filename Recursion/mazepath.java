import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        System.out.println(getMazePaths(0,0,n-1,m-1));

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
       if(sr==dr&&sc==dc)
       {
           ArrayList<String> l=new ArrayList<>();
           l.add("");
           return l;
       }
       
        ArrayList<String> rec=null;
        ArrayList<String> res=new ArrayList<>();
        if(sc+1<=dc)
        {
            rec=getMazePaths(sr,sc+1,dr,dc);
            for(String val:rec)
            {
                res.add("h"+val);
            }
        }
        if(sr+1<=dr)
        {
            rec=getMazePaths(sr+1,sc,dr,dc);
            for(String val:rec)
            {
                res.add("v"+val);
            }
        }
        return res;
    }

}