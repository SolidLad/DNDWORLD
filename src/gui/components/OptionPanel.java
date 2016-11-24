package gui.components;

import io.Question;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/** this class handles the input section of the interface */
public class OptionPanel extends JPanel{
    //a JTextArea to be referenced later.

    public OptionPanel(){
        this(1333,1000);
    }

    public OptionPanel(int w, int h){
        this(new Dimension(w,h));
    }

    public OptionPanel(Dimension dimension){
        int height, width;
        //get the height and width of the passed in dimension
        height = (int)dimension.getHeight();
        width = (int)dimension.getWidth();

        //then make room for the option panel
        width = (int) (width * .20);

        //and set the preferred size;
        setPreferredSize(new Dimension(width,height));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //test string
        try {
            drawQuestion(new Question(g2d.getFontMetrics()).readQuestion(1), g2d);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void drawTextAtPoint(Graphics2D g2d, String str, Point p){
        ArrayList<String> list = wrapString(str, g2d.getFontMetrics());
        str = "";
        if (list.size()>1){
            for (String string : list) {
                str += string + "\n";
            }
        }
        else str = list.get(0);
        g2d.drawString(str, (int)p.getX(),(int)p.getY());
    }
    public void drawText(Graphics2D g2d, String ... a){
        //declare variables
        int height = g2d.getFontMetrics().getHeight(), wraps;

        //define variables
        wraps = 0;
        FontMetrics fm = g2d.getFontMetrics();

        //iterate through each string given
        for (int i = 0; i < a.length; i++) {

            //turn it into individual lines
            String[] lines = wrapString(a[i],fm).toArray(new String[0]);
            for (int j = 0; j < lines.length; j++) {
                //if its not taller than the page...
                if (height + ( i + j + wraps  * height ) < getHeight()) {
                    //draw it at fontheight + fontheight*(string index + line index + number of wraps)
                    g2d.drawString(lines[j].trim(), 5, height + i * height + j * height + wraps * height);
                }
                else System.out.println("Line was not finished due to lack of space.");
            }
        }
    }
    private ArrayList<String> wrapString(String str, FontMetrics fm){
        String temp = "";
        ArrayList<String> strs = new ArrayList<>();
        char[] arr = str.toCharArray();
        for (char c : arr) {
            temp += c;
            if ((fm.stringWidth(temp) > (getWidth()-20))||c=='\n') {
                strs.add(temp);
                temp = "";
            }
        }
        if (strs.isEmpty()){
            strs.add(temp);
        }
        else strs.add(temp);
        return strs;
    }
    public void drawQuestion(Question q, Graphics2D g2d){
        for (String key : q.getTextLocations().keySet()){
            // FIXME: 11/24/2016 passes null to key. Problem with question writing?
            drawTextAtPoint(g2d, key ,q.getTextLocations().get(key));
        }
    }
}
