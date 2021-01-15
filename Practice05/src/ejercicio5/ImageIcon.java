package ejercicio5;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class ImageIcon extends MIDlet implements CommandListener {
    private Display	d;
    private Form	f;
    private Image	i;
    private ImageItem	ii;
    private Command	c; 
    
    public ImageIcon( ) {
        d = Display.getDisplay(this);
	f = new Form ("ImageItem");
	try {
            ii = new ImageItem("", Image.createImage("resources/java.png"), ImageItem.LAYOUT_CENTER, "Logo de Java");
            f.append(ii);
	} catch (java.io.IOException e) {
            f.append(" Error al leer el archivo java.png: " + e); 
	}
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
	} else d.setCurrent(new Alert("", "Otro comando...", null, AlertType.ERROR));
    } 
}
