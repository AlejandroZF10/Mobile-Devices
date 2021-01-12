package ejercicio2;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class HelloMIDlet extends MIDlet implements CommandListener{
    private Display	d;
    private Command	c;
    private Canvas	ca;
    
    public HelloMIDlet() {
        d  = Display.getDisplay(this);
        ca = new Canvas() {
            private int w;
            private int h;
            public void paint(Graphics g) {
                w = getWidth();
                h = getHeight();
                g.setColor(0, 0, 0);
                g.fillRect(0, 0, w, h);
                g.setColor(255, 255, 255);
                g.setStrokeStyle(Graphics.SOLID);
                g.drawString("Hola MIDlet", w/2, h/2, (Graphics.BASELINE|Graphics.HCENTER));
            }
        };
        c = new Command("Salir", Command.EXIT, 3);
        ca.addCommand(c);
        ca.setCommandListener(this);
    }
    protected void startApp() {
        d.setCurrent(ca);
    }
    
    public void pauseApp() { }
    
    public void destroyApp(boolean unconditional) { }
    
    public void commandAction(Command co, Displayable di) {
        if (co == c) {
            destroyApp(true);
            notifyDestroyed();
        } else d.setCurrent(new Alert("", "Otro comando...", null, AlertType.ERROR));
    }
}