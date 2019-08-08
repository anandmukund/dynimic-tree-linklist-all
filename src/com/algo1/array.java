package com.algo1;

import java.io.*;  
import java.lang.*;  
class array  
{  
 DataInputStream get=new DataInputStream(System.in);  
 int n,i,top=0,f=0;  
 char a[];  
 String str;  
 void getdata()  
 {  
 try  
  {  
  a=new char[30];  
  System.out.println("Enter the string");  
  str=get.readLine();  
  n=str.length();  
 }  
 catch(Exception e)  
 {  
  System.out.println(e.getMessage());  
 }  
 }  
 void push(char c)  
 {  
  a[top]=c;  
  top++;  
 }  
 char pop()  
 {  
  char h;  
 if(top!=0)  
  {  
  top--;  
  h=a[top];  
  return h;  
  }  
 else  
 return 0;  
 }  
 int stempty()  
 {  
  if(top==0)  
  return 1;  
  else  
  return 0;  
 }  
 void operation()  
 {  
 char d,t;  
 for(i=0;i<n;i++)  
  {  
  d=str.charAt(i);  
  switch(d)  
    {  
    case '(':  
        {  
         push(d);  
         break;  
        }  
    case '{':  
        {  
         push(d);  
         break;  
        }  
    case '[':  
        {  
         push(d);  
         break;  
        }  
    case ')':  
        {  
         t=pop();  
         if(t!='(')  
         f=1;  
         break;  
        }  
    case '}':  
        {  
         t=pop();  
         if(t!='{')  
         f=1;  
         break;  
        }  
    case ']':  
        {  
         t=pop();  
         if(t!='[')  
         f=1;  
         break;  
        }  
    }  
    }  
 if(f==0&&top==0)  
 {  
  System.out.println("Valid Expression");  
 }  
 else  
  System.out.println("Invalid expression");  
 }  
 public static void main(String arg[])  
 {  
  array obj=new array();  
  obj.getdata();  
  obj.operation();   
 }  
}  

class validexp  
{  
 public static void main(String arg[])  
 {  
  array obj=new array();  
  obj.getdata();  
  obj.operation();   
 }  
}  