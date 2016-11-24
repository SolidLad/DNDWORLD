package io;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Question {
    private Map<Component, Point> components;
    private Map<String, Point> textLocations;
    private FontMetrics metrics;
    public Question(FontMetrics fm){
        components = new HashMap<>();
        textLocations = new HashMap<>();
        metrics = fm;
    }
    private Question(FontMetrics fm, Map<Component, Point> comps, Map<String, Point> strings){
        components = comps;
        textLocations = strings;
        metrics = fm;
    }
    public Map<Component, Point> getComponents(){
        return components;
    }
    public void setComponents(Map<Component, Point> components) {
        this.components = components;
    }

    public Map<String, Point> getTextLocations() {
        return textLocations;
    }

    public Question readQuestion(int i) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader("res\\text\\questions.txt"));
        String full = "", line, num;
        if (i<100){
            num = "0"+String.valueOf(i);
            if (i<10)
                num = "00" + String.valueOf(i);
        }
        else num = String.valueOf(i);
        boolean found = false;
        while ((line = br.readLine()) != null){
            if (line.contains("Q"+num)){
                full += line.substring(0,line.indexOf("Q"+num));
                found = true;
            }
            if (found){
                full += line;
            }
            if (line.contains("E"+num)){
                full += line.substring(0,line.indexOf("E"+num));
                break;
            }
        }
        full = full.replaceAll("\\n","");
        full = full.substring(full.indexOf('{')+1,full.lastIndexOf('}'));
        String[] pieces = full.split(",");
        int totalHeight = 0;
        for (String str :
                pieces) {
            String key = str.substring(0,4);
            if (isText(key)) {
                String value = str.substring(4).trim();
                addComponent(totalHeight, key, value);
                totalHeight += metrics.getHeight();
            }
            else {
                if (key.equals("TFLD")){
                    addComponent(totalHeight,key, null);
                    totalHeight = (int)new JTextField().getPreferredSize().getHeight();
                }
                if (key.equals("RBTN")){
                    addComponent(totalHeight,key, null);
                    totalHeight = (int)new JRadioButton().getPreferredSize().getHeight();
                }
            }

        }
        return new Question(metrics,components,textLocations);
    }

    private boolean isText(String key) {
        return key.equals("TEXT") || key.equals("RBTX");
    }

    private void addComponent(int y, String key, String value){
        if (key.equals("TEXT")) {
                textLocations.put(value, new Point(5,y+5));
        }
        if (key.equals("TFLD")) {
                components.put(new JTextField(), new Point(5,y+5));
        }
        if (key.equals("RBTX"))  {
                textLocations.put(value, new Point(5,y+5));
        }
        if (key.equals("RBTN")) {
                components.put(new JRadioButton(), new Point(5,y+5));
        }
    }
}
