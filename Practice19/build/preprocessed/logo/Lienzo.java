/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logo;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

/**
 *
 * @author corsair
 */
public class Lienzo extends Canvas{
 
    public void paint(Graphics g){
        
        int val = 17;
        g.setColor(255,255,255);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(0,0,0);
        //g.drawLine(20,30,80,120);
        g.drawRect(0,30,getWidth(),getWidth());
        g.drawArc(0,30,getWidth(),getWidth(), 0, 360);
        
        g.drawRect(35,65,170,170);
        g.drawArc(35,65,170,170, 0, 360);
        
       
        g.drawRect(60,90,120,120);
        g.drawArc(60,90,120,120, 0, 360);
        
        //g.setColor(178,34,34);
        //g.drawRect(60,90,val,val);
        
        g.drawRect(77,107,85,85);
        g.drawArc(77,107,85,85, 0, 360);
        //g.fillRect(40, 400, 25, 25);
        g.setColor(0, 69, 162);
        g.drawString("Logo de la ciencia "+getWidth(),0,0,Graphics.TOP|Graphics.LEFT);
    }
}
