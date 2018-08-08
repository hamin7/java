import becker.robots.*;
public class RobotAction{

public static void main(String[] args) {
City mountain = new City();

new Wall(mountain, 3, 2, Direction.WEST); 
new Wall(mountain, 2, 3, Direction.WEST); 
new Wall(mountain, 1, 3, Direction.WEST);

new Wall(mountain, 1, 3, Direction.EAST); 
new Wall(mountain, 2, 4, Direction.EAST); 
new Wall(mountain, 3, 4, Direction.EAST);

new Wall(mountain, 3, 2, Direction.NORTH); 
new Wall(mountain, 1, 3, Direction.NORTH); 
new Wall(mountain, 2, 4, Direction.NORTH);

new Thing(mountain, 3, 1);

Robot karel = new Robot(mountain, 3, 0, Direction.EAST); 

karel.move();

karel.pickThing();

karel.turnLeft();

karel.move();

karel.turnLeft();
karel.turnLeft();
karel.turnLeft();

karel.move();

karel.turnLeft();

karel.move();
karel.move();

karel.turnLeft();
karel.turnLeft();
karel.turnLeft();

karel.move();

karel.putThing();

karel.move();

karel.turnLeft();
karel.turnLeft();
karel.turnLeft();

karel.move();

karel.turnLeft();

karel.move();

karel.turnLeft();
karel.turnLeft();
karel.turnLeft();

karel.move();
karel.move();

karel.turnLeft();
} }
