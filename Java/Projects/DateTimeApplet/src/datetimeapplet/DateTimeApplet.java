
package datetimeapplet;

/**
 *
 * @author maha
 */

import java.applet.Applet;
import java.awt.Graphics;
import java.time.LocalDate;
import java.time.LocalTime;

public class DateTimeApplet extends Applet implements Runnable{
    Thread th;
    public void init(){
        th = new Thread(this);
        th.start();
        
    }
    
    public void paint(Graphics g)
    {
        LocalDate date = java.time.LocalDate.now();
        LocalTime time = java.time.LocalTime.now();
        g.drawString(date.toString()+" "+time.toString(), 50, 100);
    }
    
    public void run(){
        while(true)
        {
            repaint();
            try
            {
                Thread.sleep(1000);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
