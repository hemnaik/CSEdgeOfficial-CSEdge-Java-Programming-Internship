import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
class login_system extends JFrame implements  ActionListener
{
    Font f=new Font("sans-serif",Font.BOLD,17);
    Font f1=new Font("Sans serif",Font.BOLD,12);


    ImageIcon m=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\login.jpg");
    ImageIcon user=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\username.jpg");
    ImageIcon pass=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\password.jpg");
    ImageIcon login=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\login.jpg");
    ImageIcon type=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\type.jpg");
    ImageIcon reset=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\refresh.jpg");
    ImageIcon re=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\regsiter.jpg");


    JLabel m1=new JLabel(m,SwingConstants.HORIZONTAL);
    JLabel user1=new JLabel(user,SwingConstants.HORIZONTAL);
    JLabel pass1=new JLabel(pass,SwingConstants.HORIZONTAL);
    JLabel type1=new JLabel(type, SwingConstants.HORIZONTAL);
    JComboBox c=new JComboBox();
    JTextField t1=new JTextField();
    JPasswordField t2=new JPasswordField();
    JButton login1=new JButton("Login",login);
    JButton reset1=new JButton("Reset",reset);
    JButton register=new JButton("Register",re);
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();

    login_system()
    {
        this.setTitle("LOGIN PANEL");
        this.setLayout(null);
        this.setSize(400,260);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        p1.setBounds(0,0,150,260);
        p2.setBounds(151,0,250,260);
        p1.setBackground(Color.white);
        p2.setBackground(Color.lightGray);
        p1.setLayout(null);
        p2.setLayout(null);
        this.add(p1);
        this.add(p2);
        p1.add(m1);
        p1.add(register);
        p2.add(user1);
        p2.add(t1);
        p2.add(pass1);
        p2.add(t2);
        p2.add(type1);
        p2.add(c);
        p2.add(login1);
        p2.add(reset1);
        t1.setFont(f);t2.setFont(f);c.setFont(f);register.setFont(f1);


        m1.setBounds(20,30,100,100);
        register.setBounds(10,170,120,30);

        user1.setBounds(10,20,30,30);
        t1.setBounds(50,20,120,30);
        pass1.setBounds(10,70,30,30);
        t2.setBounds(50,70,120,30);
        type1.setBounds(10,120,30,30);
        c.setBounds(50,120,120,30);
        login1.setBounds(10,170,100,30);
        reset1.setBounds(120,170,100,30);
        c.addItem("User");
        c.addItem("Admin");
        login1.addActionListener(this);
        reset1.addActionListener(this);
        register.addActionListener(this);

    }
    public void actionPerformed(ActionEvent k)
    {
        if (k.getActionCommand() == "Login")
        {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection obj = DriverManager.getConnection("jdbc:mysql://localhost:3306/Quiz", "root", "hemnaik9000123@");
                boolean flag=false;
                String username=t1.getText().toString();
                int password=Integer.parseInt(t2.getText().toString());
                String select="SELECT username,password FROM quiz_user";
                Statement s=obj.prepareStatement(select);
                ResultSet rs=s.executeQuery(select);
                while(rs.next())
                {
                    if(username.equals(rs.getString(1))&&password==rs.getInt(2))
                    {
                        flag=true;
                        break;
                    }
                }
                if(flag==true)
                {
                    JOptionPane.showMessageDialog(this,"Login Successful","Information",JOptionPane.INFORMATION_MESSAGE);
                    quiz_dashboard q=new quiz_dashboard(password);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Login Unsuccessful","Information",JOptionPane.WARNING_MESSAGE);
                }

                rs.close();
                obj.close();
            }
            catch (Exception m)
            {
                JOptionPane.showMessageDialog(this,"Error Exists","Warning",JOptionPane.WARNING_MESSAGE);
            }
        }
        if (k.getActionCommand() == "Register")
        {
            user_registration j=new user_registration();
        }

        if (k.getActionCommand() == "Reset")
        {
            t1.setText(null);
            t2.setText(null);
            repaint();
        }

    }
}


