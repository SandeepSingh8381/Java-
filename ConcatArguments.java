public class ConcatArguments
{
public static void main(String args[])
{
StringBuilder concatenated =new StringBuilder();
for (String arg:args)
{
concatenated.append(arg).append(" ");
}
System.out.println("Concatenated arguments:" +concatenated.toString().trim());
}
}