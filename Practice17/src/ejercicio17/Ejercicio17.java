package ejercicio17;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class Ejercicio17 extends MIDlet {
    Display d;
    Pantalla p;
    
    public Ejercicio17() {
	d = Display.getDisplay(this);
	p = new Pantalla();
    }
    protected void destroyApp(boolean b) throws MIDletStateChangeException{ }
    protected void pauseApp() { }
    protected void startApp() throws MIDletStateChangeException {
    	d.setCurrent(p);
    }
}