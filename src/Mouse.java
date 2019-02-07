import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class Mouse {

  Graphics g;

  final private double PROPORTION = 0.3;
  // rectangle object representing the mouse
  private Rectangle mouse;

  // top left corner of the rectangle coordinates
  double x;
  double y;
  // units to go by
  final private double UNIT;

  /**
   * Creates mouse object on canvas
   * @param unit          uniform distance to move the mouse by
   * @param startingX     starting x coordinate, top left corner of cell/unit
   * @param startingY     starting y coordinate, top left corner of cell/unit
   * @param referenceMaze completed maze with sshortest path
   * @param maze          empty maze
   */

  public Mouse(Maze referenceMaze, Maze maze, double unit, double startingX,
    double
    startingY) {
    this.UNIT = unit;
    //this.maze = maze; TODO I will pass in the maze structure?

    // center of unit
    double unitCenterX = startingX + (UNIT / 2.0);
    double unitCenterY = startingY + (UNIT / 2.0);

    // from there get upper left corner of mouse and construct it
    double width = UNIT * PROPORTION; //TODO (*) Proportion?
    double height = UNIT * PROPORTION;
    x = unitCenterX - width / 2.0; //TODO center.x - width/2.0 ?
    y = unitCenterY - height / 2.0;
    mouse = new Rectangle( (int)x, (int)y, (int)width, (int)height );
  }

  //TODO instead of mouse.translate maybe use this generic method?
  //     That way if more features are added to the mouse only this function
  //     would have to be altered when translating the mouse object. 
  //public void translate( int dx, int dy );

  //public exploreMaze()
  

  // not used
  public int move() {
    return 0;
  }

  public void moveRight() {
    mouse.translate((int)UNIT, 0);
  }

  public void moveLeft() {
    mouse.translate((int)-UNIT, 0);
  }

  public void moveUp() {
    mouse.translate(0, (int)-UNIT);
  }

  public void moveDown() {
    mouse.translate( 0, (int)UNIT );
  }

  //TODO paint is a method inherited from JFrame, so this is an ambigupus signiture.
  public void draw(Graphics g) {
    g.setColor(Color.YELLOW);
    g.fillRect( (int)mouse.getX(), (int)mouse.getY(), (int)mouse.getWidth(),
      (int)mouse.getHeight() );
  }
}

