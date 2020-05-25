// 1. You are given a string exp representing an expression.
// 2. You are required to check if the expression is balanced i.e. closing brackets and opening brackets match up well.

// e.g.
// [(a + b) + {(c + d) * (e / f)}] -> true
// [(a + b) + {(c + d) * (e / f)]} -> false
// [(a + b) + {(c + d) * (e / f)} -> false
// ([(a + b) + {(c + d) * (e / f)}] -> false

// Sample Input
// [(a + b) + {(c + d) * (e / f)}]
// Sample Output
// true


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(db(str));
    }
    public static boolean db(String exp)
    {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<exp.length();i++)
        {
            char ch=exp.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                st.push(ch);
            }else if(ch==')'){
                if(st.size()==0||st.peek()!='('){
                    return false;
                }else{
                    st.pop();
                }
                
            }else if(ch=='}'){
                if(st.size()==0||st.peek()!='{'){
                    return false;
                }else{
                    st.pop();
                }
                
            }else if(ch==']'){
                if(st.size()==0||st.peek()!='['){
                    return false;
                }else{
                    st.pop();
                }
            }
        }
        return st.size()==0;
    }
}