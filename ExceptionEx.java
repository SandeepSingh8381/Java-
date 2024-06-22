class ExceptionEx
{
public static void main(String args[])
{
int a=10,b=10,c,d;
try
{
c=a/(a-b);
System.out.println(c);
}
catch(Exception e)
{
System.out.println("Sherrr! Cheetah hi khb de");
}
d=a/(a+b);
System.out.println(d);
}
}