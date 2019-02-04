
package com.main;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class LineHandler {
    
    private ArrayList<Line> lines;
    
    public LineHandler(){
        lines = new ArrayList<>();
    }
    
    public void addLine(Line l){
        lines.add(l); 
    }
    
    public void render(Graphics2D g){
        AffineTransform save = g.getTransform();
        
        g.translate(Main.WIDTH/2, Main.HEIGHT/2);
        g.scale(10, 10);
        for(Line line : lines){
            line.render(g);
        }
        
        g.setTransform(save);
    }
}
