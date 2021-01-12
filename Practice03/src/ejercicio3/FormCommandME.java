package ejercicio3;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
public class FormCommandME extends MIDlet implements CommandListener {
    private Display	d;
    private Form	f;
    private Command	c; 
    public FormCommandME(  ) {
        d = Display.getDisplay(this);
        f = new Form ("Form & Command");
        f.append("Hola MIDlet\n");
        c = new Command("Salir", Command.EXIT, 3);
        f.addCommand(c);
        f.setCommandListener(this);
    }
    protected void startApp(  ) {
        d.setCurrent(f);
    }
    protected void pauseApp(  ) {    }
    protected void destroyApp(boolean b) {    }
    public void commandAction(Command co, Displayable di) {
        if (co == c) {
            destroyApp(true);
            notifyDestroyed();
        } else d.setCurrent(new Alert("", "Otro comando...", null, AlertType.ERROR));
    } 
}