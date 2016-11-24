package gui.components;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/** this class aims to provide a base for other components to rest. It also handles automatically resizing components. */
public class CustomFrame extends JFrame{
    private Dimension last;
    public CustomFrame(){
        addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window is in the process of being closed.
             * The close operation can be overridden at this point.
             *
             * @param e
             */
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }

        });
//        addComponentListener(new ComponentListener() {
//            @Override
//            public void componentResized(ComponentEvent e) {
//                Dimension d = getSize();
//                resizeComponents(d);
//            }
//
//            @Override
//            public void componentMoved(ComponentEvent e) {
//
//            }
//
//            @Override
//            public void componentShown(ComponentEvent e) {
//
//            }
//
//            @Override
//            public void componentHidden(ComponentEvent e) {
//
//            }
//        });
        add(new CustomPanel());
        pack();
        Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(
                (int)resolution.getWidth()/2-getWidth()/2,
                0);
        setVisible(true);
        last = getSize();
    }


    public void resizeComponents(Dimension dim){
        int changeX = (int)last.getWidth() - (int)dim.getWidth();
        int changeY = (int)last.getHeight() - (int)dim.getHeight();

        // TODO: 11/23/2016 actually change component sizes.

        last = getSize();

    }


}
