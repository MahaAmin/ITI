
package buttoncountapplet;

/**
 *
 * @author maha
 */

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonCountApplet extends Applet{
    int x;
    
    public void init(){
        x = 0;
        Button increment = new Button("INCREMENT");
        Button decrement = new Button("DECREMENT");
        increment.addActionListener(new IncrementButtonListener());
        decrement.addActionListener(new DecrementButtonListener());
        add(increment);
        add(decrement);
    }
    
    public void paint(Graphics g){
        g.drawString("Click Count is: " + x, getWidth()/2, getHeight()/7);
    }
    
    class IncrementButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            x++;
            repaint();
        }
    }
    
    class DecrementButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            x--;
            repaint();
        }
    }
    
}
