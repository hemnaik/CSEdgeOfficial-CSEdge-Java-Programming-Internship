import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class Php_Quiz extends JFrame implements ItemListener, ActionListener {

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

        String ques[] = {"1. Full form of PHP" , "2. Php is Which type of language" ,
                "3. Which method is used to check string length in Php?" , "4. How many types of array are supported in Php?",
                "5. Which one of the following is not a array function?" , "6. Which of these is not a file opening mode in Php?",
                "7. What is the extension of Php sourcecode files?" , "8. Which of the following is not concept of Php?",
                "9. What is mysqli_connect() in Php? ", "10. Which of following is not the database function in Php?",
                "11. Which of the following is not a math function in Php?","12. Which of following keyword is used to break execution in Php?",
                "13.  Which of the following is used to start session?","14. What is the cookie in Php?",
                "15. Which of the following is more secure in Php?"

        };

        String r11[] = {" Paid Home Page" , " Markup Language " , " strcmp()" , " 4",
                " array_merge()" , "  a+" , "  .java" ," Database Connectivity", " function for establishing session" , " fopen()" , " pow()", " break",
                " session_destroy()"," Response to request received on server"," get method"
        };


        String r22[] = {" Professional Home Page" , " Scripting Language " , " strtolower()" , " 3",
                " ceil()" , " g+" , " .class" , " Graphics & Animation", " used to close connection of database", " mysqli_query()", " round()"," void",
                " session_start()"," Collection of huge data"," post method"
        };


        String r33[] = {" PHP:HyperText Preprocessor" , " Programming Language " , " strlen()" , " 5",
                " in_array", " r" , " .php" , " File Management & Session handling", " function used to connect with database", " mysqli_select_db()", " strrev()", " struct",
                " $_SESSION[] super global variable"," Small data stored on Client's device"," request method"
        };



        JLabel t=new JLabel("Green Box Indicates score for Right Answer and Red Box indicates score for Wrong Answer",icon,SwingConstants.HORIZONTAL);
        JTextField L1 = new JTextField(ques[0]);
        JLabel L2 = new JLabel(" Quiz For Php Programing",quiz,SwingConstants.LEFT);
        JLabel L3 = new JLabel(" Score will be updated here = ",score,SwingConstants.HORIZONTAL);

        JTextField red = new JTextField("0");
        JTextField green= new JTextField("0");

        JRadioButton r1 = new JRadioButton(r11[0]);
        JRadioButton r2 = new JRadioButton(r22[0]);
        JRadioButton r3 = new JRadioButton(r33[0]);
        ButtonGroup g1 = new ButtonGroup();

        JButton btn = new JButton("Next",next);

         int password;
        Php_Quiz(int password)
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
            if(r1.isSelected() || r2.isSelected() || r3.isSelected())
            {
                changeq++;
                if(changeq==15)
                {
                    btn.setEnabled(false);

                    try
                    {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection obj= DriverManager.getConnection("jdbc:mysql://localhost:3306/Quiz","root","hemnaik9000123@");

                        String update="UPDATE quiz_user SET php=? WHERE password=?";
                        PreparedStatement ps = obj.prepareStatement(update);
                        ps.setInt(1,this.gr);
                        ps.setInt(2,this.password);
                        ps.executeUpdate();
                        ps.close();
                        obj.close();
                        JOptionPane.showMessageDialog(this,"Your Score is "+gr+"/15","Information",JOptionPane.INFORMATION_MESSAGE);
                        this.setVisible(false);
                    }
                    catch(Exception k)
                    {
                        System.out.println(k);
                    }

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
                slovw=0;

                error.setVisible(false);
            }
            else
            {
                error.setVisible(true);
            }


        }

        public void itemStateChanged(ItemEvent e)
        {
            if(slovw==0)
            {
                slovw=1;
                if(changeq==0)
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
                        red.setText("  "+Integer.toString(re));
                    }
                }

                if(changeq==1)
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
                        r2.setBackground(Color.green);
                        r1.setBackground(Color.red);
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
                        r2.setBackground(Color.green);
                        r1.setBackground(Color.red);
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


