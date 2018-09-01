/**
 * 
 */
package com.blp.unicorn.utils;

/**
 * @author Jake
 *
 */
public class IDAssigner {
    
    private int baseID;
    
    /**
     * assigns an id to object
     * @param baseID
     */
    public IDAssigner(int baseID){
        this.baseID = baseID;
    }
    
    /**
     * returns next id
     * @return
     */
    public int next(){
        return baseID++;
    }
    
    /**
     * gets current id
     * @return
     */
    public int getCurrentID(){
        return baseID;
    }

}