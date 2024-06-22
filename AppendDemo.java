public class AppendDemo
{
public static void main(String args[])
{
StringBuffer sb1=new StringBuffer("Java");
StringBuffer sb2=new StringBuffer("Hello");
StringBuffer sb3= sb1.append("Technology");
StringBuffer sb4= sb2.append(1234);
System.out.println(sb3);
System.out.println(sb4);
}
}