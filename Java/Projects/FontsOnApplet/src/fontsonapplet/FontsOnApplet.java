/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontsonapplet;

/**
 *
 * @author maha
 */

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Font;


public class FontsOnApplet extends Applet {
    GraphicsEnvironment myGraphEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
    Font [] listofFonts = myGraphEnv.getAllFonts();
    
    public void paint(Graphics g){
        int x,y;
        x = 0;
        y=0;
        for(Font font : listofFonts){
            g.setFont(new Font(font.getFontName(), Font.PLAIN, 15));
            g.drawString(font.getFontName(), x, y);
            y+=30;
        }
    }
//    
//
//}
    
}
