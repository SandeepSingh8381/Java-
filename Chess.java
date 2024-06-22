import java.applet.*;
import java.awt.*;
import java.awt.Color;
/*<applet code="Chess.class"width="400"height="400"></applet>*/
public class Chess extends Applet
{
int x=0,y=0;
public void paint(Graphics g)
{
for(int i=1;i<=8;i++)
{
for(int j=1;j<=8;j++)
{
if((i+j)%2==0)
{
g.setColor(Color.white);
}
else
{
g.setColor(Color.black);
}
g.fillRect(x,y,50,50);
x=x+50;
}
x=0;
y=y+50;
}
}
}