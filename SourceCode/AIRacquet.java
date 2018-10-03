import java.awt.Graphics2D;
import java.awt.Rectangle;

public class AIRacquet
{
  private static final int Y = 20;
  private static final int WITH = 50;
  private static final int HEIGHT = 20;
  double x = 99.0D;
  double xa = 0.0D;
  
  private Game game;
  
  public AIRacquet(Game game)
  {
    this.game = game;
  }
  
  public void move() {
    if ((x + xa > 0.0D) && (x + xa < game.x - 50.0D)) { x += xa;xa = 0.0D;
    }
  }
  
  public void paint(Graphics2D g) { g.fillRect((int)x, 20, 50, 20); }
  
  public Rectangle getBounds()
  {
    return new Rectangle((int)x, 20, 50, 20);
  }
  
  public int getTopY() {
    return 40;
  }
}
