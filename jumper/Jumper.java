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
