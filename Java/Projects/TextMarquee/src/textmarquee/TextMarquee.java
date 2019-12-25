
package textmarquee;

/**
 *
 * @author maha
 */

import java.applet.Applet;
import java.awt.Graphics;

public class TextMarquee extends Applet implements Runnable{
    
    private String text;
    private int x,y,flag;
    Thread th;
    
    public void init()
    {
        text = "JAVA WORLD";
        x = 0;
        y = 100;
        flag = 1;
        
        th = new Thread(this);
        th.start();
    }
    
    public void run()
    {
        while(true)
        {
            x += 10;
            if((x - 20) > getWidth())
                x = getWidth() - x - 20;
            repaint();
            try
            {
                th.sleep(500);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            
        }
    }
    
    public void paint(Graphics g)
    {
        g.drawString(text, x, y);
    }
    
}
