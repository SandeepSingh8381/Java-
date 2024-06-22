import java.util.Scanner;
class Matrix8
{
public static void main(String args[])
{
int a[][]=new int[3][3];
int i,j;
Scanner sc=new Scanner(System.in);
System.out.println("Enter 9 numbers\n");
for(i=0;i<3;i++)
{
for(j=0;j<3;j++)
{
a[i][j]=sc.nextInt();
}
}
System.out.println("Array elements are \n");
for(i=0;i<3;i++)
{
for(j=0;j<3;j++)
{
if((i+j)%2!=0)
{
System.out.print(a[i][j]+"\t");
}
else{

System.out.print("\t");
}
}
System.out.println();
}
}
}
