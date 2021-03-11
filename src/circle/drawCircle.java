//DPJ5531 Final Project
//Student Name  : Ong Sin Yin
//Student ID    : 1181203333
//Class Section : TT3V

package circle;

import javax.swing.*;
import java.awt.*;

//Class which is a panel to draw the graphics
public class drawCircle extends JPanel
{
    int w;

    public drawCircle(int w)
    {
        this.w = w;
        setOpaque(false); //Set false to non-transparent
        setVisible(true);
        setSize(w,w);
    }

    //Paint the circle
    public void paintComponent(Graphics c)
    {
        super.paintComponent(c);
        setSize(w, w);
        c.setColor(Color.BLACK);
        c.drawOval(0, 0, w, w);
    }
}
