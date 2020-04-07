import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
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
        if(sc>dc||sr>dr)
        {
            ArrayList<String> l1=new ArrayList<>();
            return l1;
        }
        ArrayList<String> ref=null;
        ArrayList<String> res=new ArrayList<>();
        for(int i=1;i<=dc;i++)
        {
            ref=getMazePaths(sr,sc+i,dr,dc);
            for(String val:ref)
            {
                res.add("h"+i+val);
            }
        }
        for(int i=1;i<=dr;i++)
        {
            ref=getMazePaths(sr+i,sc,dr,dc);
            for(String val:ref)
            {
                res.add("v"+i+val);
            }
        }
        for(int i=1;i<=dc&&i<=dr;i++)
        {
            ref=getMazePaths(sr+i,sc+i,dr,dc);
            for(String val:ref)
            {
                res.add("d"+i+val);
            }
        }
        return res;
    }

}