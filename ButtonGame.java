import java.awt.*; 
import java.awt.event.*;
import javax.swing.*; 
import java.util.*;

public class ButtonGame
{
  public static void main (String[] args)
  {
    
    TwoButtons demo  = new TwoButtons ("Click a Button");
    
    demo.setSize(600, 550);     
    demo.setVisible(true); 
    
  }
}
class TwoButtons extends JFrame implements ActionListener
{
  JLabel label1;
  JButton button1;
  JButton button2;
  JButton button3;
  JLabel label2;
  int ctr = 0;
  
  // constructor for TwoButtons
  public TwoButtons(String title)                           
  {
    super( title );
    
    label1 = new JLabel ("Test your Luck");
    button1 = new JButton("Button #1");
    button2 = new JButton("Button #2");
    button3 = new JButton ("Button #3");
    label2 = new JLabel ("How far can you go?");
    
    button1.setActionCommand("1");   // set the  command 
    button2.setActionCommand("2"); // set the  command 
    button3.setActionCommand ("3");
    
    // register the frame
    // as the listener for all Buttons.
    button1.addActionListener(this);
    button2.addActionListener(this);
    button3.addActionListener(this);
    
    setLayout(new FlowLayout()); 
    add (label1);
    add(button1);                      
    add(button2);
    add(button3);   
    add(label2);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  }
  
  public void actionPerformed(ActionEvent evt) //acts like a loop. for every action, it will respond
  {
    Random randNum = new Random();
    float red = randNum.nextFloat();
    float green = randNum.nextFloat();
    float blue = randNum.nextFloat();
    
    Color randomColor = new Color(red, green, blue);
    
    int someInt = Math.abs(randNum.nextInt())%3;   // someInt gets a number from 0 to 2
    
    if (someInt == 0 || someInt == 1)
    {
      ctr++;
      label1.setText("Keep going!");
      getContentPane().setBackground (randomColor);
      label2.setText("Winning Streak: " + ctr);
    }   //make it count clicks and change colours randomly
    
    else
    {
      label2.setText ("You Lose");
      ctr =0;
    }
  }
}
