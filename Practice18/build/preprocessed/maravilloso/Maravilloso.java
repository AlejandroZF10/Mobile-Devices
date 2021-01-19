package maravilloso;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;

public class Maravilloso extends MIDlet implements CommandListener {
    Form f;
    Command cs, cc;
    Display d;
    StringItem s, s1, str, str1, str2, str3;
    TextField tf, tf1;
    String n, palabra;

    public void startApp() {
        cs = new Command("Salir", Command.EXIT, 1);
        cc = new Command("Maravilloso", Command.OK, 1);
        d = Display.getDisplay(this);
        f = new Form("Numero Maravilloso");
        s = new StringItem("", "Numero natural");
        tf = new TextField("", "", 256, TextField.NUMERIC);
        s1 = new StringItem("", "Palabra");
        tf1 = new TextField("", "", 256, TextField.ANY);
        str = new StringItem("", "");
        str1 = new StringItem("", "");
        str2 = new StringItem("", "");
        str3 = new StringItem("", "");
        f.addCommand(cs);
        f.addCommand(cc);
        f.append(s);
        f.append(tf);
        f.append(s1);
        f.append(tf1);
        f.append(str);
        f.append(str1);
        f.append(str2);
        f.append(str3);
        f.setCommandListener(this);
        d.setCurrent(f);
    }
    
    public void pauseApp() {}
    
    public void destroyApp(boolean unconditional) {}

    public String getMaravilloso(int n, String s) {
        s += n + ", ";
        if (n == 1) {
            s = s + "\nEs un nùmero maravilloso";
            return s;
        }
        if (n % 2 == 0)
            return this.getMaravilloso(n / 2, s);
        return this.getMaravilloso(n * 3 + 1, s);
    }

    public String getPrimo(int n, String s) {
        int contador = 2;
        int bandera = 1;
        while (contador != n) {
            if (n % contador == 0)
                bandera = 0;
            contador++;
        }
        if (bandera == 0)
            return s = "\n No es primo";
        else
            return s = "\n Es primo";
    }

    public String fibonacci(int n, String s) {
        int numero = 100;
        int f = 0;
        int t1 = 1;
        int t2;
        int bandera = 0;

        for (int i = 1; i <= numero; i++) {
            t2 = f;
            f = t1 + f;
            t1 = t2;

            if (t1 == n) 
                bandera = 1;
        }
        if (bandera == 1) 
            return s = "\n Es Fibonacci";
         else 
            return s = "\n No es Fibonacci";
    }

    public String palindromo(String palindromo, String s) {
        int bandera = 1;
        int tamaño = palindromo.length();

        for (int i = 0; i < tamaño / 2; i++) {
            if (palindromo.charAt(i) != palindromo.charAt(tamaño - 1 - i))
                bandera = 0;
        }
        if (bandera == 1) 
            return s = "\n Es palindromo";
        else
            return s = "\n No es palindromo";     
    }
    
    public void commandAction(Command c, Displayable d) {
        if (c == cc) {
            String respuesta;
            String primo;
            String fibonacci;
            String palindromo;
            n = tf.getString();
            palabra = tf1.getString();
            int n1 = Integer.parseInt(n);
            System.out.println(n1);
            respuesta = this.getMaravilloso(n1, "");
            primo = this.getPrimo(n1, "");
            fibonacci = this.fibonacci(n1, "");
            palindromo = this.palindromo(palabra, "");
            System.out.println(fibonacci);
            str.setText(respuesta);
            str1.setText(primo);
            str2.setText(fibonacci);
            str3.setText(palindromo);
            f.append(str);
            f.append(str1);
            f.append(str2);
            f.append(str3);
        }
    }
}