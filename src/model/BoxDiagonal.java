package model;

import java.util.ArrayList;

/**
 *
 * @author Mélanie DUBREUIL 3APP
 * 
 */

public class BoxDiagonal extends Box {

    public BoxDiagonal(boolean containsFlag, boolean isTrapped, boolean isVisible, int numberOfNeighborTrapped, Board b) {
        super(containsFlag, isTrapped, isVisible, numberOfNeighborTrapped, b);
    }
    
    /**
     * public void revealDiagonal
     * Reveal the diagonal
     */
    public void revealDiagonal(){
        ArrayList<Box> boxes = this.getGame().giveDiagonalBoxes(this);        
        for (Box b : boxes){
            if(b.isTrapped()){
                b.setFlag(true);
            } else {
                this.getGame().setNb_box_discovered(this.getGame().getNb_box_discovered()+1);
                b.setVisible(true); 
            }
        }
        setChanged();
        notifyObservers();
    }
    
    @Override
    public void leftClic(){
        revealDiagonal();
        setChanged();
        notifyObservers();
    }
    
}