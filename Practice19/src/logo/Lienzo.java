package logo;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

public class Lienzo extends Canvas{
 
    public void paint(Graphics g){
        
        int val = 17;
        g.setColor(255,255,255);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(0,0,0);
        g.drawRect(0,30,getWidth(),getWidth());
        g.drawArc(0,30,getWidth(),getWidth(), 0, 360);
        
        g.drawRect(35,65,170,170);
        g.drawArc(35,65,170,170, 0, 360);
        
       
        g.drawRect(60,90,120,120);
        g.drawArc(60,90,120,120, 0, 360);
        
        g.drawRect(77,107,85,85);
        g.drawArc(77,107,85,85, 0, 360);
        g.setColor(0, 69, 162);
        g.drawString("Logo de la ciencia "+getWidth(),0,0,Graphics.TOP|Graphics.LEFT);
    }
}
