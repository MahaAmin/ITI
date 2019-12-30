package drawmultiplelinesapplet;

/**
 *
 * @author maha
 */
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.awt.event.MouseListener;
import java.awt.Point;
import java.awt.event.MouseMotionListener;

public class DrawMultipleLinesApplet extends Applet {

    Vector<Line> lines;
    Line newLine;

    public void init() {
        lines = new Vector();
        newLine = new Line();

        setFocusable(true);
        requestFocusInWindow();

        addMouseListener(new PressMouseListener());
        addMouseMotionListener(new DragMouseListener());
    }

    public void paint(Graphics g) {
        int n = lines.size();
        System.out.println(n);
        //System.out.println(lines);
        for (int i = 0; i < n; i++) {
            g.drawLine(lines.elementAt(i).p1.x, lines.elementAt(i).p1.y, lines.elementAt(i).p2.x, lines.elementAt(i).p2.y);
        }
    }

    class DragMouseListener implements MouseMotionListener {

        public void mouseMoved(MouseEvent e) {

        }

        public void mouseDragged(MouseEvent e) {
            newLine.p2.x = e.getX();
            newLine.p2.y = e.getY();
            repaint();
        }
    }

    class PressMouseListener implements MouseListener {

        public void mousePressed(MouseEvent e) {
            newLine.p1 = e.getPoint();
        }

        public void mouseReleased(MouseEvent e) {
            newLine.p2 = e.getPoint();
            Line tmpLine = new Line(newLine.p1.x, newLine.p1.y, newLine.p2.x, newLine.p2.y);
            lines.add(tmpLine);
            repaint();
        }

        public void mouseClicked(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }
    }

}

class Line {

    Point p1;
    Point p2;

    public Line() {
        p1 = new Point();
        p2 = new Point();

        p1.x = p1.y = 0;
        p2.x = p2.y = 0;
    }

    public Line(Point p1, Point p2) {
        p1 = new Point();
        p2 = new Point();

        this.p1 = p1;
        this.p2 = p2;
    }

    public Line(int x1, int y1, int x2, int y2) {
        p1 = new Point();
        p2 = new Point();

        this.p1.x = x1;
        this.p1.y = y1;

        this.p2.x = x2;
        this.p2.y = y2;
    }

}
