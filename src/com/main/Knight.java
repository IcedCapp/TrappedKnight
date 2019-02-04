
package com.main;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;

public class Knight {
    
    private LineHandler lineHandler;
    private HashSet<Point> visited;
    private Point pos;
    
    public Knight(LineHandler lineHandler){
        this.lineHandler = lineHandler;
        
        pos = new Point(0, 0);
        visited = new HashSet<Point>();
        visited.add(pos);
    }
    
    public ArrayList<Point> getMoves(){
        ArrayList<Point> out = new ArrayList<>();
        for(int i : new int[]{1,-1}){
            for(int j : new int[]{2,-2}){
                out.add(new Point(pos.x+i, pos.y+j));
                out.add(new Point(pos.x+j, pos.y+i));
            }
        }
        return out;
    }
    
    public void filterDone(ArrayList<Point> moves){
        for(int i = moves.size()-1; i>=0; i--){
            if(visited.contains(moves.get(i))){ moves.remove(i); }
        }
    }
    
    public void move(){
        ArrayList<Point> moves = getMoves();
        filterDone(moves);
        Point best = null;
        if(moves.isEmpty()){
            /*moves = getMoves();
            best = moves.get(0);
            Score bestScore = ScoreGenerator.getScore(best);
            for(int i = 1; i < moves.size(); i++){
                Score next = ScoreGenerator.getScore(moves.get(i));
                if(ScoreGenerator.getMax(bestScore, next)==next){
                    best = moves.get(i);
                    bestScore = next;
                }
            }*/
        }
        else{
            best = moves.get(0);
            Score bestScore = ScoreGenerator.getScore(best);
            for(int i = 1; i < moves.size(); i++){
                Score next = ScoreGenerator.getScore(moves.get(i));
                if(ScoreGenerator.getMin(bestScore, next)==next){
                    best = moves.get(i);
                    bestScore = next;
                }
            }
        }
        
        if(best == null){ return; }
        
        Point offs = new Point(best.x-pos.x, best.y-pos.y);
        
        lineHandler.addLine(new Line(pos, best, 
                new Color(0f, (offs.x+3+(offs.x>0?-1:0))/4f, (offs.y+3+(offs.y>0?-1:0))/4f)));
        pos = best;
        visited.add(pos);
    }
}
