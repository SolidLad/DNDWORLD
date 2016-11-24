package gui.components;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.Random;

/** this class handles the display part of the interface. */
public class DisplayPanel extends JPanel {
    public DisplayPanel(){
        this(1333,1000);
    }
    public DisplayPanel(int w, int h){
        this(new Dimension(w,h));
    }
    public DisplayPanel(Dimension dimension){
        int height, width;
        height = (int)dimension.getHeight();
        width = (int)dimension.getWidth();
        width =  width - (int)(width * .20);
        setPreferredSize(new Dimension(width,height));
        setBorder(new BevelBorder(BevelBorder.LOWERED));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

    }
}
