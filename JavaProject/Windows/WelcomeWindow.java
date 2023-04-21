import javax.swing.JButton;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.*;
import java.awt.Component;
import java.awt.event.ActionListener;

public class WelcomeWindow extends JPanel{
  
  JButton button1A;
  JButton button1B;
    JButton button2B0;
    JButton button2B1;
    JButton button2B2;
    JButton button2B3;

    LiterallyJustASquare square;


  //as the name implies this manages the welcome window, currently unworking :sob: 
  public WelcomeWindow(){

    WindowPane pane = (WindowPane)holder.window.getContentPane();
    square = (LiterallyJustASquare)pane.getComponent(0);
    
    this.setLayout(null);
    this.setBounds(0,0,GameRunner.screenWidth, GameRunner.screenHeight);
    
    //this.setBackground(Color.BLUE);
    this.setOpaque(false);

    this.setDoubleBuffered(true);
    
    button1A = new JButton("2 Player!");
    button1B = new JButton("VS Computer!");

    button2B0 = new JButton("vs a literal baby [Internal: 0]");
    button2B1 = new JButton("vs Computer lvl1 [Internal: 1]");
    button2B2 = new JButton("vs Computer lvl2 [Internal: 2]");
    button2B3 = new JButton("vs Computer lvl3 [Internal: 3]");

    button1A.setBounds(48,96,144,96); button1B.setBounds(192,96,144,96);

    button2B0.setBounds(0,0,240,96); button2B1.setBounds(48,96,240,96); button2B2.setBounds(96,192,240,96); button2B3.setBounds(144,288,240,96);
    
    button1A.setVisible(true); button1B.setVisible(true);

    button2B0.setVisible(false); button2B1.setVisible(false); button2B2.setVisible(false); button2B3.setVisible(false);


    this.add(button1A);
    this.add(button1B);
    
    this.add(button2B0);
    this.add(button2B1);
    this.add(button2B2);
    this.add(button2B3);


    this.setVisible(true);
    
    //
    
    button1A.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e){
        
        JButton sourceButton = (JButton) e.getSource();
        MainWindow win = (MainWindow)SwingUtilities.getWindowAncestor(sourceButton);
        WindowPane pane = (WindowPane)win.getContentPane();
        
        WelcomeWindow welcome = (WelcomeWindow)pane.getComponent(0);
        LiterallyJustASquare square = (LiterallyJustASquare)pane.getComponent(1);

        welcome.setVisible(false);
        square.clearWelcomeRectangle();

        holder.gRun.start();
      }
    });

    //

    button1B.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e){
        //holder.gRun.computer = new ComputerPlayer(holder.board, 2, false);
        //holder.gRun.vsComputer = true;

        button2B0.setVisible(true); button2B1.setVisible(true); button2B2.setVisible(true); button2B3.setVisible(true);
        button1A.setVisible(false); button1B.setVisible(false);
      }
    });
    ////////SUB1B////////

      button2B0.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e){
          holder.gRun.computer = new ComputerPlayer(holder.board, 0, false);
          holder.gRun.vsComputer = true;

          //Exits introframe
          JButton sourceButton = (JButton) e.getSource();
          MainWindow win = (MainWindow)SwingUtilities.getWindowAncestor(sourceButton);
          WindowPane pane = (WindowPane)win.getContentPane();
        
          WelcomeWindow welcome = (WelcomeWindow)pane.getComponent(0);
          LiterallyJustASquare square = (LiterallyJustASquare)pane.getComponent(1);

          welcome.setVisible(false);
          square.clearWelcomeRectangle();

          holder.gRun.start();
        }
      });
      //
      button2B1.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e){
          holder.gRun.computer = new ComputerPlayer(holder.board, 1, false);
          holder.gRun.vsComputer = true;

          //Exits introframe
          JButton sourceButton = (JButton) e.getSource();
          MainWindow win = (MainWindow)SwingUtilities.getWindowAncestor(sourceButton);
          WindowPane pane = (WindowPane)win.getContentPane();
        
          WelcomeWindow welcome = (WelcomeWindow)pane.getComponent(0);
          LiterallyJustASquare square = (LiterallyJustASquare)pane.getComponent(1);

          welcome.setVisible(false);
          square.clearWelcomeRectangle();

          holder.gRun.start();
        }
      });
      //   
      button2B2.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e){
          holder.gRun.computer = new ComputerPlayer(holder.board, 2, false);
          holder.gRun.vsComputer = true;

          //Exits introframe
          JButton sourceButton = (JButton) e.getSource();
          MainWindow win = (MainWindow)SwingUtilities.getWindowAncestor(sourceButton);
          WindowPane pane = (WindowPane)win.getContentPane();
        
          WelcomeWindow welcome = (WelcomeWindow)pane.getComponent(0);
          LiterallyJustASquare square = (LiterallyJustASquare)pane.getComponent(1);

          welcome.setVisible(false);
          square.clearWelcomeRectangle();

          holder.gRun.start();
        }
      });
      // 
      button2B3.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e){
          holder.gRun.computer = new ComputerPlayer(holder.board, 3, false);
          holder.gRun.vsComputer = true;

          //Exits introframe
          JButton sourceButton = (JButton) e.getSource();
          MainWindow win = (MainWindow)SwingUtilities.getWindowAncestor(sourceButton);
          WindowPane pane = (WindowPane)win.getContentPane();
        
          WelcomeWindow welcome = (WelcomeWindow)pane.getComponent(0);
          LiterallyJustASquare square = (LiterallyJustASquare)pane.getComponent(1);

          welcome.setVisible(false);
          square.clearWelcomeRectangle();

          holder.gRun.start();
        }
      });



  }
}