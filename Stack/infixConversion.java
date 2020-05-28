// Question
//  1. You are given an infix expression.
// 2. You are required to convert it to postfix and print it.
// 3. You are required to convert it to prefix and print it.
                               
// Input Format
// Input is managed for you
// Output Format
// postfix
// prefix
// Constraints
// 1. Expression is balanced
// 2. The only operators used are +, -, *, /
// 3. Opening and closing brackets - () - are used to impact precedence of operations
// 4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
// 5. In two operators of equal precedence give preference to the one on left.
// 6. All operands are single digit numbers.
// Sample Input
// 2 + 6 * 4 / 8 - 3
// Sample Output
// 264*8/+3-
// -+2/*6483
import java.io.*;
import java.util.*;

public class Main{
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    conversion(exp);
 }
 public static void conversion(String exp){
     Stack<String> prefix=new Stack<>();
     Stack<String> postfix=new Stack<>();
     Stack<Character> op=new Stack<>();
     for(int i=0;i<exp.length();i++)
     {
         char ch=exp.charAt(i);
         if((ch>='0'&&ch<='9')||(ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')){
             prefix.push(ch+"");
             postfix.push(ch+"");
         }else if(ch=='('){
             op.push(ch);
         }else if(ch==')'){
             while(op.peek()!='(')
             {
                 char optr=op.pop();
                 //prefix
                 String preOp2=prefix.pop();
                 String preOp1=prefix.pop();
                 prefix.push(optr+preOp1+preOp2);
                 
                 //postfix
                 String postOp2=postfix.pop();
                 String postOp1=postfix.pop();
                 postfix.push(postOp1+postOp2+optr);
             }
             op.pop();
         }else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
             while(op.size()>0&&op.peek()!='('&&pred(op.peek())>=pred(ch))
             {
                 char optr=op.pop();
                 String preOp2=prefix.pop();
                 String preOp1=prefix.pop();
                 prefix.push(optr+preOp1+preOp2);
                 
                 String postOp2=postfix.pop();
                 String postOp1=postfix.pop();
                 postfix.push(postOp1+postOp2+optr);
             }
             op.push(ch);
         }
     }
     while(op.size()>0)
     {
         char optr=op.pop();
         String preOp2=prefix.pop();
         String preOp1=prefix.pop();
         prefix.push(optr+preOp1+preOp2);
                 
         String postOp2=postfix.pop();
         String postOp1=postfix.pop();
         postfix.push(postOp1+postOp2+optr);
     }
     System.out.println(postfix.peek());
     System.out.println(prefix.peek());
 }
 public static int pred(char ch)
 {
     if(ch=='+'||ch=='-'){
         return 1;
     }else{
         return 2;
     }
 }
}