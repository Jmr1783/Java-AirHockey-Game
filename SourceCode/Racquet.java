import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Racquet
{
  private static final int Y = 345;
  private static final int WITH = 50;
  private static final int HEIGHT = 20;
  double x = 98.0D;
  double xa = 0.0D;
  private Game game;
  
  public Racquet(Game game) {
    this.game = game;
  }
  
  public void move() {
    if ((x + xa > 0.0D) && (x + xa < game.x - 50.0D))
      x += xa;
    xa = 0.0D;
  }
  
  public void paint(Graphics2D g) {
    g.fillRect((int)x, 345, 50, 20);
  }
  
  public Rectangle getBounds() {
    return new Rectangle((int)x, 345, 50, 20);
  }
  
  public int getTopY() {
    return 325;
  }
}
