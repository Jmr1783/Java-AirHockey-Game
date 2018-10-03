import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;













public class Game
  extends JPanel
{
  Ball ball = new Ball(this);
  Racquet racquet = new Racquet(this);
  AIRacquet AIracquet = new AIRacquet(this);
  double speed = 1.0D;
  double speedball = 1.0D;
  double r1 = 1.0D;
  double r2 = 1.0D;
  int s1;
  int s2;
  double x = 247.0D;
  double y = 403.0D;
  static int sx = 307;
  static int sy = 430;
  
  final Image image = requestImage();
  
  volatile boolean mLeftPressed;
  volatile boolean mRightPressed;
  volatile boolean mUpPressed;
  volatile boolean mDownPressed;
  
  private double getScore()
  {
    return speedball;
  }
  
  public int getScore1() {
    return s1;
  }
  

  public int getScore2() { return s2; }
  
  public int getrally() { return ball.rally; }
  



  public Game()
  {
    addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode())
        {
        case 37: 
          mLeftPressed = true;
          break;
        
        case 39: 
          mRightPressed = true;
          break;
        
        case 68: 
          mUpPressed = true;
          break;
        
        case 65: 
          mDownPressed = true;
          break;
        case 81: 
          System.exit(0);
        }
        
      }
      
      public void keyReleased(KeyEvent e)
      {
        switch (e.getKeyCode()) {
        case 37: 
          mLeftPressed = false;
          break;
        case 39: 
          mRightPressed = false;
          break;
        case 68: 
          mUpPressed = false;
          break;
        case 65: 
          mDownPressed = false;
          break;
        case 81: 
          System.exit(0);
        
        }
        
      }
    });
    Thread KeyPressedMonitor = new Thread()
    {
      public void run() {
        for (;;) {
          if (mLeftPressed) {
            racquet.xa = (-(r1 + speedball));
          }
          if (mRightPressed) {
            racquet.xa = (r1 + speedball);
          }
          if (mUpPressed) {
            AIracquet.xa = (r1 + speedball);
          }
          if (mDownPressed) {
            AIracquet.xa = (-(r1 + speedball));
          }
        }
      }
    };
    KeyPressedMonitor.start();
    
    Sound.Music.play();
    setFocusable(true);
  }
  



  private void move()
  {
    ball.move();
    racquet.move();
    AIracquet.move();
  }
  

  private Image requestImage()
  {
    Image image = null;
    try {
      URL url = ClassLoader.getSystemResource("back.jpg");
      
      image = ImageIO.read(url);
    }
    catch (IOException localIOException) {}
    










    return image;
  }
  
  public void paint(Graphics g)
  {
    super.paint(g);
    Graphics2D g2d = (Graphics2D)g;
    
    g.drawImage(image, 0, 0, null);
    
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
      RenderingHints.VALUE_ANTIALIAS_ON);
    
    ball.paint(g2d);
    g2d.setColor(Color.RED);
    racquet.paint(g2d);
    g2d.setColor(Color.BLUE);
    AIracquet.paint(g2d);
    g2d.setColor(Color.GRAY);
    
    g2d.rotate(1.5707963267948966D, x + 10.0D, 60.0D);
    g2d.setFont(new Font("Verdana", 1, 20));
    g2d.drawString(String.valueOf("Rally:"), (int)x + 10, 60);
    g2d.rotate(-1.5707963267948966D, x + 10.0D, 60.0D);
    
    g2d.rotate(1.5707963267948966D, x + 10.0D, 140.0D);
    g2d.setFont(new Font("Verdana", 1, 25));
    g2d.drawString(String.valueOf((int)getScore()), (int)x + 10, 140);
    
    g2d.rotate(-1.5707963267948966D, x + 10.0D, 140.0D);
    
    g2d.setColor(Color.BLUE);
    g2d.drawString(String.valueOf(getScore1()), (int)x + 10, 30);
    g2d.setColor(Color.RED);
    g2d.drawString(String.valueOf(getScore2()), (int)x + 10, (int)y - 40);
  }
  










  public void gameOver()
  {
    String[] buttons = { "Restart", "End Program" };
    int returnValue = JOptionPane.showOptionDialog(null, "What would you like to do?", "Game Over", 
      -1, 3, null, buttons, buttons[0]);
    System.out.println(returnValue);
    if (returnValue == 0) restart();
    if (returnValue == 1) { System.exit(128);
    }
  }
  
  public void reset()
  {
    if ((getScore1() == 5) || (getScore2() == 5)) gameOver();
    ball.x = 100.0D;
    ball.y = 100.0D;
    ball.xa = 1.0D;
    ball.ya = 1.0D;
    speedball = 1.0D;
    r1 = 1.0D;
    r2 = 1.0D;
    racquet.x = 99.0D;
    AIracquet.x = 99.0D;
    racquet.xa = 0.0D;
    AIracquet.xa = 0.0D;
    mLeftPressed = false;
    mRightPressed = false;
    mUpPressed = false;
    mDownPressed = false;
  }
  
  public void restart() {
    s1 = 0;
    s2 = 0;
    ball.x = 100.0D;
    ball.y = 100.0D;
    ball.xa = 1.0D;
    ball.ya = 1.0D;
    speedball = 1.0D;
    r1 = 1.0D;
    r2 = 1.0D;
    racquet.x = 99.0D;
    AIracquet.x = 99.0D;
    racquet.xa = 0.0D;
    AIracquet.xa = 0.0D;
    mLeftPressed = false;
    mRightPressed = false;
    mUpPressed = false;
    mDownPressed = false;
  }
  
  public static void main(String[] args)
    throws InterruptedException
  {
    JFrame frame = new JFrame("Air Hockey by Joe+Dylan");
    Game game = new Game();
    frame.add(game);
    frame.setSize(sx, sy);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(3);
    for (;;)
    {
      game.move();
      game.repaint();
      Thread.sleep(7L);
    }
  }
}
