package com.example.canvas;

import android.content.*;
import android.graphics.*;
import android.view.View;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
public class Lienzo extends View{
    Paint p;
    int x, y;
    public Lienzo(Context c){
        super(c);
    }
    protected void onDraw(Canvas c){
        super.onDraw(c); // Canvas pinta atributos
        float radios=20;
        final RectF oval=new RectF();

        p = new Paint(); // Paint asigna atributos
        x = c.getWidth(); // También: getMeasuredWidth() o getRight(), x=480
        y = c.getHeight(); // También: getMeasuredHeight() o getBottom(), y=762
        /*
        oval.set(x - radios, y-radios,x+radios,y+radios);
        Path mypath = new Path();
        int angle = (int)(180/Math.PI*Math.atan2(y))
        mypath.arcTo(oval,angle, -(float)sweepAngle,true);

         */
        p.setColor(Color.WHITE); // Fondo blanco
        c.drawPaint(p);
        p.setColor(Color.BLACK); // Texto negro
        p.setTextSize(20);
        c.drawText("x0=" + x/2 + ", y0=" + y/2, x/2 + 20, y/2-20, p);
        p.setColor(Color.rgb(0, 0, 255)); // Ejes azules
        c.drawLine(x/2, 0, x/2, y, p);
        c.drawLine(0, y/2, x, y/2, p);
        p.setTextAlign(Align.RIGHT);
        p.setTypeface(Typeface.SERIF);
        c.drawText("Eje X", x-5, y/2-10, p);
        p.setTextAlign(Align.CENTER);
        p.setTypeface(Typeface.DEFAULT_BOLD);
        c.drawText("Eje Y", x/2+30, 20, p);
        p.setColor(Color.argb(150, 0, 230, 209));
        c.drawCircle(x/2-270, y/2+400, 100, p);

        p.setColor(Color.argb(150, 230, 100, 0));
        c.drawRect( (x/4)+100,(y/4)+50,200,300,p);

        p.setColor(Color.argb(150, 52, 230, 0));
        c.drawRoundRect((x/4)+480,(y/4)+50,930,300,80,80,p);

        p.setColor(Color.argb(150, 230, 0, 206));
        c.drawCircle(x/2+295, y/2+400, 100, p);

        p.setColor(Color.WHITE);
        c.drawCircle(x/2+250, y/2+400, 100, p);

        //c.drawArc((x/4)+100,(y/4)+50,50,100,0,270,true,p);
        //c.drawArc(RectF ovalo, float iniAngulo, float angulo, boolean usarCentro, Paint pincel);
        //c.drawArc();

        p.setTextAlign(Align.LEFT);
        //p.setTextAlign(Align.valueOf(String s));
        p.setTypeface(Typeface.DEFAULT);
        p.setTypeface(Typeface.SANS_SERIF);
        p.setTypeface(Typeface.MONOSPACE);
    }
}