import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import java.awt.Color;

public class Jumper extends Actor {
    
    public Jumper(){
        setColor(Color.RED);
    }

    public Jumper(Color c){
        setColor(c);
    }

    public void act(){
        if(canJump())
            jump();
        else
            turn();
    }

    public void turn(){
        setDirection(getDirection() + Location.HALF_RIGHT); 
    }

    //jumps if the space 2 blocks away is valid
    //else, turns
    public void jump(){
        Grid<Actor> gr = getGrid();
        if(gr == null)
            return;
        Location loc = getLocation();
        Location front = loc.getAdjacentLocation(getDirection());
        Location next = front.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            turn(); 
    }

    //Jumper jumps as long as the location 2 squares away is not a rock
    public boolean canJump(){
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location front = loc.getAdjacentLocation(getDirection());
        Location next = front.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return !(neighbor instanceof Rock);
    }

    
}
