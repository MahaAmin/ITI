
package movingtextusingkeyboardapplet;

/**
 *
 * @author maha
 */

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovingTextUsingKeyboardApplet extends Applet{
    String text;
    int x,y;
    
    public void init(){
        setFocusable(true);
        requestFocusInWindow();
        text = "JAVA";
        x = getWidth()/2;
        y = getHeight()/2;
        addKeyListener(new pressArrowListener());
    }
    
    public void paint(Graphics g){
        g.drawString(text, x, y);
    }
    
    class pressArrowListener implements KeyListener{
        public void keyPressed(KeyEvent e){
            
                
            switch(e.getKeyCode()){
                case KeyEvent.VK_DOWN:
                    //System.out.println(e.getKeyCode());
                    y += 10;
                    repaint();
                    break;
                case KeyEvent.VK_UP:
                    System.out.println(e.getKeyCode());
                    y -= 10;
                    repaint();
                    break;
                case KeyEvent.VK_RIGHT:
                    System.out.println(e.getKeyCode());
                    x += 10;
                    repaint();
                    break;
                case KeyEvent.VK_LEFT:
                    System.out.println(e.getKeyCode());
                    x -= 10;
                    repaint();
                    break;
            }
        }
        
        public void keyReleased(KeyEvent e){
            
        }
        
        public void keyTyped(KeyEvent e){
            
        }
    }
}
