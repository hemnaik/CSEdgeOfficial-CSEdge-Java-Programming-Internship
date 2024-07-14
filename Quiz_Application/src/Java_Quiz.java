import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;


class Java_Quiz extends JFrame implements ItemListener , ActionListener{

    int re = 0;
    int gr = 0;

    int slovw=0;
    int changeq = 0;

    ImageIcon score=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\score.jpg");
    ImageIcon next=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\next.jpg");
    ImageIcon quiz=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\quiz.jpg");
    ImageIcon icon=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\note.jpg");
    ImageIcon info=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\info.jpg");

    // font for small test for Java
    Font f1 = new Font("Sans-serif",Font.BOLD,40);
    Font f3 = new Font("Arial",Font.PLAIN,15);

    Font f2 = new Font("Arial",Font.PLAIN,22);

    JLabel error = new JLabel("You Must have to select one Option",info,SwingConstants.HORIZONTAL);

    String ques[] = {"1. Who invented Java Programming?" , "2 . Java is Which language ? " ,
            "3. Which statement is true about Java?" , "4. Which component is used to compile, debug and execute the java programs?",
            "5. Which one of the following is not a Java feature?" , "6. Which of these cannot be used for a variable name in Java?",
            "7. What is the extension of java code files?" , "8. Which of the following is not an OOPS concept in Java?",
            "9.  Which exception is thrown when java is out of memory?", "10. Which of these are selection statements in Java?",
            "11.  Which of these keywords is used to define interfaces in Java?","12. Which of these keywords are used for the block to be examined for exceptions?",
            "13.  Which one of the following is not an access modifier?","14. What is the numerical range of a char data type in Java?",
            "15. Which one of the following is an access modifier?"

    };

    String r11[] = {"  Guido van Rossum" , "  OOP Language " , "  Java is a code dependent programming language" , "  JDK",
            "  Object-oriented" , "  identifier" , "  .txt" ,"   Inheritance", "  MemoryError" , "  if()" , "  Inf", "  try",
            "   Protected","  0 to 256","  Protected"
    };


    String r22[] = {"  James Gosling" , "  POP Language " , "  Java is a platform-dependent programming language" , "  JVM",
            "  Use of pointers" , "  keyword" , "  .class" , "  Compilation", "  MemoryOutOfBoundsException", "  break", "  in","  check",
            "  void","  -128 to 127","  keyword"
    };


    String r33[] = {"  JDennis Ritchie" , "  Simple Language " , "  Java is a platform-independent programming language" , "  JRE",
            "  Portable", "  identifier" , "  .java" , "  Encapsulation", "  OutOfMemoryError", "  for()", "  interface", "  throw",
            "  public","   0 to 65535","  void"
    };



    JLabel t=new JLabel("Green Box Indicates score for Right Answer and Red Box indicates score for Wrong Answer",icon,SwingConstants.HORIZONTAL);
    JTextField L1 = new JTextField(ques[0]);
    JLabel L2 = new JLabel(" Quiz For Java Programing",quiz,SwingConstants.LEFT);
    JLabel L3 = new JLabel(" Score will be updated here = ",score,SwingConstants.HORIZONTAL);

    JTextField red = new JTextField("0");
    JTextField green= new JTextField("0");

    JRadioButton r1 = new JRadioButton(r11[0]);
    JRadioButton r2 = new JRadioButton(r22[0]);
    JRadioButton r3 = new JRadioButton(r33[0]);
    ButtonGroup g1 = new ButtonGroup();

    JButton btn = new JButton("Next",next);

    int password;
    Java_Quiz(int password)
    {

        this.password=password;
        error.setVisible(false);
        this.setTitle("Quiz Application");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1360,700);
        this.setVisible(true);

        green.setEditable(false);
        red.setEditable(false);
        green.setFocusable(false);
        red.setFocusable(false);
        L2.setBounds(30,30,600,50);
        L2.setFont(f1);
        add(L2);

        L1.setBounds(0,120,1360,40);
        L1.setFont(f2);
        L1.setBackground(Color.yellow);
        add(L1);
        L1.setEditable(false);

        r1.setBounds(10,190,600,30);
        r1.setFont(f2);
        add(r1);

        r2.setBounds(10,240,600,30);
        r2.setFont(f2);
        add(r2);

        r3.setBounds(10,290,600,30);
        r3.setFont(f2);
        add(r3);
        g1.add(r1);
        g1.add(r2);
        g1.add(r3);

         t.setBounds(10,500,700,40);
         t.setFont(f3);
         add(t);

        r1.addItemListener(this);
        r2.addItemListener(this);
        r3.addItemListener(this);

        L3.setBounds(30,600,400,30);
        L3.setFont(f2);
        add(L3);

        // adding for show the score
        red.setBounds(450,580,50,50);
        red.setForeground(Color.red);

        red.setFont(f1);
        add(red);

        green.setBounds(520,580,50,50);
        green.setForeground(Color.green);

        green.setFont(f1);
        add(green);

        // set next Button
        btn.setBounds(590,580,150,50);
        btn.setFont(f2);
        add(btn);

        btn.addActionListener(this);

        // set for show error
        error.setBounds(800,580,500,40);
        error.setFont(f2);
        error.setForeground(Color.red);
        add(error);

    }

    public void actionPerformed(ActionEvent e)
    {
        if(r1.isSelected() || r2.isSelected() || r3.isSelected()) {
            changeq++;
            if (changeq == 15) {
                btn.setEnabled(false);

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection obj = DriverManager.getConnection("jdbc:mysql://localhost:3306/Quiz", "root", "hemnaik9000123@");

                    String update = "UPDATE quiz_user SET java=? WHERE password=?";
                    PreparedStatement ps = obj.prepareStatement(update);
                    ps.setInt(1, this.gr);
                    ps.setInt(2, this.password);
                    ps.executeUpdate();
                    ps.close();
                    obj.close();
                    JOptionPane.showMessageDialog(this, "Your Score is " + gr + "/15", "Information", JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                } catch (Exception k) {
                    System.out.println(k);
                }

                g1.clearSelection();
                r1.setBackground(null);
                r2.setBackground(null);
                r3.setBackground(null);
                r1.setEnabled(true);
                r2.setEnabled(true);
                r3.setEnabled(true);

                L1.setText(ques[changeq]);
                r1.setText(r11[changeq]);
                r2.setText(r22[changeq]);
                r3.setText(r33[changeq]);
                slovw = 0;

                error.setVisible(false);
            } else {
                error.setVisible(true);
            }

        }
    }

    public void itemStateChanged(ItemEvent e)
    {
        if(slovw==0)
        {
            slovw=1;
            if(changeq==0)
            {
                if(r2.isSelected())
                {


                    r2.setBackground(Color.green);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    gr++;
                    green.setText(" "+Integer.toString(gr));
                }
                else
                {
                    r1.setBackground(Color.red);
                    r2.setBackground(Color.green);
                    r3.setBackground(Color.red);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    re++;
                    red.setText("  "+Integer.toString(re));
                }
            }

            if(changeq==1)
            {
                if(r1.isSelected())
                {

                    r1.setBackground(Color.green);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    gr++;
                    green.setText(" "+Integer.toString(gr));
                }
                else
                {
                    r1.setBackground(Color.green);
                    r2.setBackground(Color.red);
                    r3.setBackground(Color.red);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    re++;
                    red.setText(" "+Integer.toString(re));
                }
            }

            if(changeq==2)
            {
                if(r3.isSelected())
                {
                    r3.setBackground(Color.green);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    gr++;
                    green.setText(" "+Integer.toString(gr));
                }
                else
                {
                    r1.setBackground(Color.red);
                    r2.setBackground(Color.red);
                    r3.setBackground(Color.green);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    re++;
                    red.setText(" "+Integer.toString(re));
                }
            }

            if(changeq==3)
            {
                if(r1.isSelected())
                {

                    r1.setBackground(Color.green);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    gr++;
                    green.setText(" "+Integer.toString(gr));
                }
                else
                {
                    r1.setBackground(Color.green);
                    r2.setBackground(Color.red);
                    r3.setBackground(Color.red);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    re++;
                    red.setText(" "+Integer.toString(re));
                }
            }

            if(changeq==4)
            {
                if(r2.isSelected())
                {
                    r2.setBackground(Color.green);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    gr++;
                    green.setText(" "+Integer.toString(gr));
                }
                else
                {
                    r1.setBackground(Color.red);
                    r2.setBackground(Color.green);
                    r3.setBackground(Color.red);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    re++;
                    red.setText(" "+Integer.toString(re));
                }
            }

            if(changeq==5)
            {
                if(r2.isSelected())
                {
                    r2.setBackground(Color.green);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    gr++;
                    green.setText(" "+Integer.toString(gr));
                }
                else
                {
                    r1.setBackground(Color.red);
                    r2.setBackground(Color.green);
                    r3.setBackground(Color.red);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    re++;
                    red.setText(" "+Integer.toString(re));
                }
            }

            if(changeq==6)
            {
                if(r3.isSelected())
                {
                    r3.setBackground(Color.green);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    gr++;
                    green.setText(" "+Integer.toString(gr));
                }
                else
                {
                    r1.setBackground(Color.red);
                    r2.setBackground(Color.red);
                    r3.setBackground(Color.green);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    re++;
                    red.setText(" "+Integer.toString(re));
                }
            }

            if(changeq==7)
            {
                if(r2.isSelected())
                {
                    r2.setBackground(Color.green);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    gr++;
                    green.setText(" "+Integer.toString(gr));
                }
                else
                {
                    r1.setBackground(Color.red);
                    r2.setBackground(Color.green);
                    r3.setBackground(Color.red);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    re++;
                    red.setText(" "+Integer.toString(re));
                }
            }

            if(changeq==8)
            {
                if(r3.isSelected())
                {
                    r3.setBackground(Color.green);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    gr++;
                    green.setText(" "+Integer.toString(gr));
                }
                else
                {
                    r1.setBackground(Color.red);
                    r2.setBackground(Color.red);
                    r3.setBackground(Color.green);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    re++;
                    red.setText(" "+Integer.toString(re));
                }
            }

            if(changeq==9)
            {
                if(r1.isSelected())
                {
                    r1.setBackground(Color.green);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    gr++;
                    green.setText(" "+Integer.toString(gr));
                }
                else
                {
                    r1.setBackground(Color.green);
                    r2.setBackground(Color.red);
                    r3.setBackground(Color.red);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    re++;
                    red.setText(" "+Integer.toString(re));
                }
            }
            if(changeq==10)
            {
                if(r3.isSelected())
                {
                    r3.setBackground(Color.green);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    gr++;
                    green.setText(" "+Integer.toString(gr));
                }
                else
                {
                    r1.setBackground(Color.red);
                    r2.setBackground(Color.red);
                    r3.setBackground(Color.green);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    re++;
                    red.setText(" "+Integer.toString(re));
                }
            }

            if(changeq==11)
            {
                if(r1.isSelected())
                {
                    r1.setBackground(Color.green);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    gr++;
                    green.setText(" "+Integer.toString(gr));
                }
                else
                {
                    r1.setBackground(Color.green);
                    r2.setBackground(Color.red);
                    r3.setBackground(Color.red);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    re++;
                    red.setText(" "+Integer.toString(re));
                }
            }

            if(changeq==12)
            {
                if(r2.isSelected())
                {
                    r2.setBackground(Color.green);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    gr++;
                    green.setText(" "+Integer.toString(gr));
                }
                else
                {
                    r1.setBackground(Color.red);
                    r2.setBackground(Color.green);
                    r3.setBackground(Color.red);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    re++;
                    red.setText(" "+Integer.toString(re));
                }
            }

            if(changeq==13)
            {
                if(r3.isSelected())
                {
                    r3.setBackground(Color.green);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    gr++;
                    green.setText(" "+Integer.toString(gr));
                }
                else
                {
                    r1.setBackground(Color.red);
                    r2.setBackground(Color.red);
                    r3.setBackground(Color.green);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    re++;
                    red.setText(" "+Integer.toString(re));
                }
            }

            if(changeq==14)
            {
                if(r1.isSelected())
                {

                    r1.setBackground(Color.green);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    gr++;
                    green.setText(" "+Integer.toString(gr));
                }
                else
                {
                    r1.setBackground(Color.green);
                    r2.setBackground(Color.red);
                    r3.setBackground(Color.red);
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                    r3.setEnabled(false);
                    re++;
                    red.setText(" "+Integer.toString(re));
                }
            }


        }
    }
}
