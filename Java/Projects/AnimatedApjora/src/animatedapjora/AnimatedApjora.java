package animatedapjora;

/**
 *
 * @author maha
 */

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class AnimatedApjora extends Applet implements Runnable{
    Thread th;
    private Color c = Color.ORANGE;
    public void init()
    {
        th = new Thread(this);
        th.start();
    }
    
    public void run()
    {
        while(true)
        {
            repaint();
            if(c == Color.LIGHT_GRAY)
                c = Color.ORANGE;
            else if(c == Color.ORANGE)
                c = Color.LIGHT_GRAY;
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
    
    public void paint(Graphics g)
    {
        g.drawLine(163,38, 121, 258);
        g.drawLine(415, 38, 455, 258);
        g.drawLine(275, 290, 252, 388);
        g.drawLine(293, 290, 317, 388);
        g.drawRect(163, 388, 243, 22);
        g.drawOval(235,91,108,159);
        g.drawOval(145, 127, 49, 73);
        g.drawOval(379,127,50,74);
        g.drawOval(163,14,252,50);
        g.drawArc(121,228,334,62,0,-180);
        g.setColor(c);
        g.fillOval(235,91,108,159);
        g.fillOval(145, 127, 49, 73);
        g.fillOval(379,127,50,74);
        g.fillOval(163,14,252,50);
    }
}
