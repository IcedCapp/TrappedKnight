
package com.main;

import java.awt.Graphics2D;

public class Level {
    
    private LineHandler lineHandler;
    private Knight knight;
    
    public Level(){
        lineHandler = new LineHandler();
        knight = new Knight(lineHandler);
    }
    
    int temp = 0;
    public void update(){
        temp++;
        if(temp >= 0){
            temp = 0;
            knight.move();
        }
    }
    
    public void render(Graphics2D g){
        lineHandler.render(g);
    }
}
