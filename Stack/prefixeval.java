// Question
//  1. You are given a prefix expression.
// 2. You are required to evaluate it and print it's value.
// 3. You are required to convert it to infix and print it.
// 4. You are required to convert it to postfix and print it.

// Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.

                               
// Input Format
// Input is managed for you
// Output Format
// value, a number
// infix
// prefix

// Constraints
// 1. Expression is a valid prefix expression
// 2. The only operators used are +, -, *, /
// 3. All operands are single digit numbers.

// Sample Input
// -+2/*6483

// Sample Output
// 2
// ((2+((6*4)/8))-3)
// 264*8/+3-

import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    conversion(exp);
 }
  public static void conversion(String exp)
 {
     Stack<String> infix=new Stack<>();
     Stack<String> postfix=new Stack<>();
     Stack<Integer> val=new Stack<>();
     for(int i=exp.length()-1;i>=0;i--)
     {
         char ch=exp.charAt(i);
         if(ch>='0'&&ch<='9'){
             infix.push(ch+"");
             postfix.push(ch+"");
             val.push(ch-'0');
         }else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
             int vOp1=val.pop();
             int vOp2=val.pop();
             int ans=solve(vOp1,vOp2,ch);
             val.push(ans);
             
             String iOp1=infix.pop();
             String iOp2=infix.pop();
             infix.push('('+iOp1+ch+iOp2+')');
             
             String pOp1=postfix.pop();
             String pOp2=postfix.pop();
             postfix.push(pOp1+pOp2+ch);
         }
     }
     System.out.println(val.peek());
     System.out.println(infix.peek());
     System.out.println(postfix.peek());
 }
 public static int solve(int num1,int num2,char ch)
 {
     if(ch=='+'){
         return num1+num2;
     }else if(ch=='-'){
         return num1-num2;
     }else if(ch=='*'){
         return num1*num2;
     }else{
         return num1/num2;
     }
 }
}