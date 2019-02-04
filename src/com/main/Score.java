
package com.main;

public class Score {
    
    private int[] vals;
    
    public Score(int[] vals){
        this.vals = vals;
    }
    
    public int getVal(int index){ return vals[index]; }
}
