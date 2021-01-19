package logo;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class Logo extends MIDlet implements CommandListener{
    
    Command c;
    Display d;
    Lienzo l;
    
    public Logo(){
        
        c = new Command("Salir",Command.EXIT,2);
        d = Display.getDisplay(this);
        l = new Lienzo();
        l.addCommand(c);
        l.setCommandListener(this);
    }
    
    public void startApp() {
        d.setCurrent(l);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command co, Display di){
        
        if(co == c){
            destroyApp(false);
            notifyDestroyed();
        }
    }

    public void commandAction(Command c, Displayable d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
