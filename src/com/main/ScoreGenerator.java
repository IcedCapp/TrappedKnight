
package com.main;

import java.awt.Point;

public class ScoreGenerator {
    
    public static Score getScore(Point pos){
        int x = pos.x, y = pos.y;
        int ring = Math.max(Math.abs(x), Math.abs(y));
        int q1 = x>=0 && -x<y && y<=x ? y : ring+1;        
        int q2 = y>=0 && -y<=x && x<y ? -x : ring+1;
        int q3 = x<=0 && x<=y && y<-x ? -y : ring+1;
        int q4 = y<=0 && y<x && x<=-y ? x : ring+1;
        return new Score(new int[]{ring, q1, q2, q3, q4});
    }
    
    public static Score getMin(Score s1, Score s2){
        for(int i = 0; i < 5; i++){
            if(s1.getVal(i) < s2.getVal(i)){ return s1; }
            if(s2.getVal(i) < s1.getVal(i)){ return s2; }
        }
        return s1;
    }
    
    public static Score getMax(Score s1, Score s2){
        for(int i = 0; i < 5; i++){
            if(s1.getVal(i) > s2.getVal(i)){ return s1; }
            if(s2.getVal(i) > s1.getVal(i)){ return s2; }
        }
        return s1;
    }
}
