package drawsinglelineapplet;

/**
 *
 * @author maha
 */

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawSingleLineApplet extends Applet{
    int x1,y1,x2,y2;
    
    public void init(){
        addMouseListener(new PressMouseListener());
        addMouseMotionListener(new DragMouseListener());
    }
    
    
    public void paint(Graphics g){
        g.drawLine(x1, y1, x2, y2);
    }
    
    class DragMouseListener implements MouseMotionListener{
        public void mouseMoved(MouseEvent e){
            
        }
        
        public void mouseDragged(MouseEvent e){
            x2 = e.getX();
            y2 = e.getY();
            repaint();
        }
    }
    
    class PressMouseListener implements MouseListener{
        public void mousePressed(MouseEvent e){
            x1 = e.getX();
            y1 = e.getY();
        }
        
        public void mouseReleased(MouseEvent e){
            
        }
        
        public void mouseClicked(MouseEvent e){
            
        }
        
        public void mouseEntered(MouseEvent e){
            
        }
        
        public void mouseExited(MouseEvent e){
            
        }
    }
    
}
