package gui.components;

import javax.swing.*;
import java.awt.*;
/** this class organizes the different components of the interface. */
public class CustomPanel extends JPanel {
    public CustomPanel(){
        //set the layout
        setLayout(new BorderLayout());

        //the original dimensions
        setPreferredSize(new Dimension(1333,1000));

        //messing with the scrolling panel.
        OptionPanel op = new OptionPanel();

        //adding in the display section of the interface
        DisplayPanel dp = new DisplayPanel();

        //places the two halves of opposite sides.
        add(dp, BorderLayout.EAST);
        add(op, BorderLayout.WEST);

    }
}
