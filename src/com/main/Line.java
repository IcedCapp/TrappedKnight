
package com.main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Line {
    
    private Point start, end;
    private Color color;
    
    public Line(Point start, Point end, Color color){
        this.start = start;
        this.end = end;
        this.color = color;
    }
    
    public void render(Graphics2D g){
        g.setColor(color);
        g.setStroke(new BasicStroke(0.3f));
        g.drawLine(start.x, start.y, end.x, end.y);
    }
}
