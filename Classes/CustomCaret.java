package Classes;

import java.awt.*;
import javax.swing.text.*;

public class CustomCaret extends DefaultCaret {
    
    private Color color;

    public CustomCaret(Color color) {
        this.color = color;
    }

    protected synchronized void damage(Rectangle r) {
        if (r == null) {
            return;
        }
        x = r.x;
        y = r.y;
        height = r.height;
        if (width <= 0) {
            width = getComponent().getWidth();
        }
        repaint();
    }

    public void paint(Graphics g) {
        if (isVisible()) {
            try {
                JTextComponent component = getComponent();
                Rectangle r = component.modelToView(getDot());
                g.setColor(color);
                g.fillRect(r.x, r.y, 2, r.height);
            } catch (BadLocationException e) {
             
            }
        }
    }

}
