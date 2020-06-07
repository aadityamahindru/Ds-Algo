import java.util.*;
class Abc{
    public static void main(String args[]){
        String str="abc";
        ArrayList<String> arr=permutation(str);
        for(String s : arr){
            System.out.println(s);
        }
    }
    public static ArrayList<String> permutation(String str){
        if(str.length()==0){
            ArrayList<String> s=new ArrayList<>();
            s.add("");
            return s;
        }
        char ch=str.charAt(0);
         ArrayList<String> res=new ArrayList<>();
        ArrayList<String> recRes=permutation(str.substring(1));
         for (String val : recRes) { 
            for (int i = 0; i <= val.length(); i++) { 
                res.add(val.substring(0, i) + ch + val.substring(i)); 
            } 
        } 
        return res;
    }
}