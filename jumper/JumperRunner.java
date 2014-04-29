import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Actor;

public class JumperRunner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        world.add(new Bug());
        world.add(new Rock());
        world.add(new Actor());
        Jumper j = new Jumper();
        world.add(j);
        world.show();
    }
}
