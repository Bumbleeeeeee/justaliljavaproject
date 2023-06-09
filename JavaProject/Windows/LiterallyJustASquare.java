import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

public class LiterallyJustASquare extends JPanel{
    
    public LiterallyJustASquare(){
        this.setBounds(0,0,GameRunner.screenWidth,GameRunner.screenHeight + 13);
        this.setOpaque(false);
        this.setVisible(true);
    }

        public void paint(Graphics g){
  
        super.paintComponent(g);

        System.out.println(g + "\n + yippers");
        Graphics2D g2 = (Graphics2D) g;
    
        Rectangle rect = new Rectangle(0,0,GameRunner.screenHeight, GameRunner.screenWidth);
        Color color = new Color(0, 120, 220, 120); //126 
    
        g2.setPaint(color);
        g2.fill(rect);
      }
    
    
      public void clearWelcomeRectangle(){
        
        Graphics g = this.getGraphics();
        g.clearRect(0, 0, getWidth(), getHeight());

        this.setVisible(false);
      }
        
}
