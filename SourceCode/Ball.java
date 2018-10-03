import java.applet.AudioClip;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JOptionPane;

public class Ball
{
  private static final int DIAMETER = 20;
  double x = 0.0D;
  double y = 40.0D;
  double xa = 1.0D;
  double ya = 1.0D;
  int status;
  int rally;
  private Game game;
  
  public Ball(Game game) {
    this.game = game;
  }
  

  void move()
  {
    status = 0;
    boolean changeDirection = true;
    if (x + xa < 0.0D) {
      Sound.wall1.play();
      xa = game.speedball;

    }
    else if (x + xa > game.x - 20.0D) {
      Sound.wall1.play();
      xa = (-game.speedball);

    }
    else if (y + ya < 0.0D) {
      ya = game.speedball;

    }
    else if (y + ya > game.getHeight() - 20)
    {
      game.s1 += 1;
      JOptionPane.showMessageDialog(game, "BLAH wins ");
      game.reset();

    }
    else if (y + ya <= 5.0D)
    {
      game.s2 += 1;
      JOptionPane.showMessageDialog(game, "BLAH BLAH wins ");
      game.reset();


    }
    else if ((collision()) || (AIcollision()))
    {

      if (status == 1) {
        Sound.P1.play();
        y = (game.racquet.getTopY() - 20);
        ya = (-game.speedball);
        game.r1 = game.speedball;
        rally();
      }
      else if (status == 2) {
        Sound.P2.play();
        y = (game.AIracquet.getTopY() + 20);
        ya = game.speedball;
        game.r2 = 1.0D;
        rally();
      }
      
      game.speedball += 0.0D;
    }
    else
    {
      changeDirection = true;
    }
    if (changeDirection)
    {
      x += xa; }
    y += ya;
  }
  
  public void rally() {
    if (rally == 5) { rally = 0;game.speedball += 1.0D; } else { rally += 1;
    } }
  
  private boolean collision() { status = 1;
    
    return game.racquet.getBounds().intersects(getBounds());
  }
  
  private boolean AIcollision() { status = 2;
    
    return game.AIracquet.getBounds().intersects(getBounds());
  }
  
  public void paint(Graphics2D g) {
    g.fillOval((int)x, (int)y, 20, 20);
  }
  
  public Rectangle getBounds() {
    return new Rectangle((int)x, (int)y, 20, 20);
  }
}
