/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluetoothledarduino;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;
import javax.bluetooth.UUID;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
/**
 * @author lizbe
 */
public class BluetoothArduinoMidlet extends MIDlet implements DiscoveryListener, Runnable, CommandListener {
    private Form    form;
    private Display display;
    private List    bluetoothAgents;
    private Command commandPrender = new Command("Prender",      Command.CANCEL, 2);
    private Command commandConectar = new Command("Conectar",    Command.SCREEN, 2);
    private Command commandApagar = new Command("Apagar",Command.SCREEN, 2);

    private Vector  vdi = new Vector();
    private Vector  vda = new Vector();
    private int     id [] = new int[20];
    private int []  attrSet;
    private UUID[]  uuid = {new UUID("F0E0D0C0B0A000908070605040302010", false)};
    private int     dis;
    private InputStream is;
    private OutputStream os;
    private Thread  t;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    //</editor-fold>//GEN-END:|fields|0|
    /**
     * The BluetoothArduinoMidlet constructor.
     */
    public BluetoothArduinoMidlet() {
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    /**
     * Returns a display instance.
     *
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }
    
    public void startApp() {
        try {
            display = Display.getDisplay(this);
            bluetoothAgents = new List("Clientes bluetooth:", Choice.EXCLUSIVE);
            bluetoothAgents.addCommand(commandConectar);
            //bluetoothAgents.addCommand(commandApagar);
            //bluetoothAgents.addCommand(commandPrender);
            bluetoothAgents.setCommandListener(this);
            display.setCurrent(bluetoothAgents);
            LocalDevice dispositivoLocal = LocalDevice.getLocalDevice();
            if (!dispositivoLocal.setDiscoverable(DiscoveryAgent.GIAC)) { }
            DiscoveryAgent agenteDeBusqueda = dispositivoLocal.getDiscoveryAgent();
            agenteDeBusqueda.startInquiry(DiscoveryAgent.GIAC, this);
            while (vdi.size() == 0) { }
            for (int i = 0; i < vdi.size(); i++) {
                try {
                    id[i] = agenteDeBusqueda.searchServices(attrSet, uuid, ((RemoteDevice) vdi.elementAt(i)), this);
                    bluetoothAgents.append(((RemoteDevice) vdi.elementAt(i)).getFriendlyName(true), null);
                } catch (Exception e) { }
            }
            while (vdi.size()==0 || vda.size()==0) { }
            display.setCurrent(bluetoothAgents);
        } catch (Exception e) { }    
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
    }

    /**
     * Called to signal the MIDlet to terminate.
     *
     * @param unconditional if true, then the MIDlet has to be unconditionally
     * terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
        notifyDestroyed();
    }
    public void deviceDiscovered(RemoteDevice rd, DeviceClass dc) {
        vdi.addElement(rd);
    }
    public void inquiryCompleted(int ic) {
        this.dis = ic;
    }
    public void serviceSearchCompleted(int transID, int respCode) {    }
    public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
        for (int i = 0; i < servRecord.length; i++)
            vda.addElement(servRecord[i]);
    }
    public void run() {
        try {
            form = new Form("Cliente: Conectado al servidor");
            form.addCommand(commandApagar);
            form.addCommand(commandPrender);
            form.setCommandListener(this);
            display = Display.getDisplay(this);
            display.setCurrent(form);
            //String direccion = ((ServiceRecord) vda.elementAt(bluetoothAgents.getSelectedIndex())).getConnectionURL(((ServiceRecord) vda.elementAt(bluetoothAgents.getSelectedIndex())).NOAUTHENTICATE_NOENCRYPT, false);
            StreamConnection conn = (StreamConnection) Connector.open("btspp://"+((RemoteDevice) vdi.elementAt(bluetoothAgents.getSelectedIndex())).getBluetoothAddress()+";authenticate=false;encrypt=false;master=false",Connector.READ_WRITE);
            is = conn.openInputStream();
            os = conn.openOutputStream();
            while (conn != null) {//btspp://0018E425C27B:1;authenticate=false;encrypt=false;master=false
                byte buffer[] = new byte[40];
                is.read(buffer);
                form.insert(1, new StringItem("Cliente:", new String(buffer)));
                display = Display.getDisplay(this);
                display.setCurrent(form);
            }
        } catch (Exception e) {
            e.printStackTrace();
            form.append("Error : "+e);
        }
    }
    public void commandAction(Command c, Displayable d) {
        String label = c.getLabel();
        if (label.equals("Conectar")) {
            t = new Thread(this);
            t.start();
        } else if (label.equals("Prender")) {
            try {
                os.write("a".getBytes());
            } catch (Exception e) {
                form.append("Error: " + e);
            }
        } else if (label.equals("Apagar")) {
            try {
                os.write("b".getBytes());
            } catch (Exception e) {
                form.append("Error: " + e);
            }
        }
    }

    
}
