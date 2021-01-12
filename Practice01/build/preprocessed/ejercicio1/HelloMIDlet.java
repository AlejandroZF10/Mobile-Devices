package ejercicio1;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class HelloMIDlet extends MIDlet implements CommandListener {
    private final Display	d;
    private final Form	f;
    private final Command	c;
    private Alert	a;
    
    public HelloMIDlet(  ) {
	d = Display.getDisplay(this);
	f = new Form ("Hola MIDlet");
	f.append("Hola MIDlet!\n");
	c = new Command("Salir", Command.EXIT, 3);
	f.addCommand(c);
	f.setCommandListener(this);
    }
    
    public void startApp() {
        d.setCurrent(f);
    }
    
    public void pauseApp() { }
    
    public void destroyApp(boolean unconditional) { }
    
    public void commandAction(Command co, Displayable di) {
	if (co == c) {
            destroyApp(true);
            notifyDestroyed();
	} 
        else 
            d.setCurrent(new Alert("", "Otro comando...", null, AlertType.ERROR));	
    }
}