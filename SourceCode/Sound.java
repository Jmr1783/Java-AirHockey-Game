import java.applet.AudioClip;

public class Sound
{
  public static final AudioClip P1 = java.applet.Applet.newAudioClip(Sound.class.getResource("Hit.wav"));
  public static final AudioClip Goal = java.applet.Applet.newAudioClip(Sound.class.getResource("Horn.wav"));
  public static final AudioClip P2 = java.applet.Applet.newAudioClip(Sound.class.getResource("Hit2.wav"));
  public static final AudioClip Music = java.applet.Applet.newAudioClip(Sound.class.getResource("Mr.wav"));
  public static final AudioClip wall1 = java.applet.Applet.newAudioClip(Sound.class.getResource("Wall1.wav"));
  
  public Sound() {}
}
