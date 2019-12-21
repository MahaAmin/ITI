/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloapplet;

/**
 *
 * @author maha
 */


import java.applet.Applet;
import java.awt.Graphics;

public class HelloApplet extends Applet{

    /**
     * @param args the command line arguments
     */
    public void paint(Graphics g){
        g.drawString("Hello Applt", 50, 100);
    }
    
}
