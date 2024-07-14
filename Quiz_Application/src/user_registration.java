import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

class user_registration extends JFrame implements ActionListener
{
    Font f=new Font("Sans serif",Font.PLAIN,20);

    ImageIcon i1=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\name.jpg");
    ImageIcon i2=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\registration.jpg");
    ImageIcon i3=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\contact.jpg");
    ImageIcon i4=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\female.jpg");
    ImageIcon i6=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\male.jpg");
    ImageIcon i7=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\others.jpg");
    ImageIcon i8=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\gender.jpg");
    ImageIcon i9=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\username.jpg");
    ImageIcon i10=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\male.jpg");
    ImageIcon i5=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\password.jpg");
    ImageIcon i11=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\email.jpg");
    ImageIcon i12=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\confirm.jpg");
    ImageIcon i13=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\register.jpg");
    ImageIcon i14=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\close.jpg");
    ImageIcon i15=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\refresh.jpg");

    JLabel l=new JLabel("Registration Form",i2,SwingConstants.HORIZONTAL);
    JLabel name=new JLabel("Enter Name",i1,SwingConstants.HORIZONTAL);
    JLabel gender=new JLabel("Select Gender",i8,SwingConstants.LEFT);
    JLabel contact=new JLabel("Enter Contact",i3,SwingConstants.HORIZONTAL);
    JLabel username=new JLabel("Enter Username",i9,SwingConstants.LEFT);
    JLabel password=new JLabel("Create password",i5,SwingConstants.HORIZONTAL);
    JLabel email=new JLabel("Enter Email",i11,SwingConstants.HORIZONTAL);
    JLabel c_password=new JLabel("Confirm Password",i12,SwingConstants.HORIZONTAL);

    JTextField t1=new JTextField();JTextField t2=new JTextField();
    JTextField t3=new JTextField();JPasswordField t4=new JPasswordField();
    JPasswordField t5=new JPasswordField();JTextField t6=new JTextField();

    ButtonGroup g=new ButtonGroup();
    JRadioButton male=new JRadioButton("Male",i6);
    JRadioButton female=new JRadioButton("Female",i4);
    JRadioButton others=new JRadioButton("Others",i7);
    JButton register=new JButton("Register",i13);
    JButton reset=new JButton("Reset",i15);
    JButton close=new JButton("Close",i14);

    user_registration()
    {
        this.setResizable(false);
        this.setLayout(null);
        this.setBounds(0,0,700,700);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("QUIZ APPLICATION/REGISTRATION PANEL");

        l.setFont(f);name.setFont(f);gender.setFont(f);contact.setFont(f);close.setFont(f);
        male.setFont(f);female.setFont(f);t5.setFont(f);t6.setFont(f);register.setFont(f);
        username.setFont(f);password.setFont(f);c_password.setFont(f);t3.setFont(f);reset.setFont(f);
        t1.setFont(f);others.setFont(f);t2.setFont(f);t4.setFont(f);email.setFont(f);

        l.setBounds(200,20,250,50);
        //name
        name.setBounds(70,100,170,30);
        t1.setBounds(260,100,150,30);
        //contact
        contact.setBounds(70,160,180,30);
        t2.setBounds(270,160,150,30);
        //gender
        gender.setBounds(70,220,180,30);
        male.setBounds(260,220,100,30);
        female.setBounds(370,220,110,30);
        others.setBounds(490,220,120,30);
        //username
        username.setBounds(70,280,200,30);
        t3.setBounds(280,280,150,30);
        //password
        password.setBounds(70,340,200,30);
        t4.setBounds(280,340,150,30);
        //confirm password
        c_password.setBounds(70,400,230,30);
        t5.setBounds(310,400,150,30);
        //email
        email.setBounds(70,460,200,30);
        t6.setBounds(280,460,150,30);
        //register
        register.setBounds(70,530,150,30);
        reset.setBounds(230,530,150,30);
        close.setBounds(390,530,150,30);


        gender.add(male);gender.add(female);gender.add(others);this.add(t3);this.add(username);
        this.add(l);this.add(t1);this.add(name);this.add(t2);this.add(contact);this.add(close);this.add(reset);
        this.add(gender);this.add(male);this.add(female);this.add(others);this.add(t4);this.add(password);
        this.add(t5);this.add(c_password);this.add(t6);this.add(email);this.add(register);
        register.addActionListener(this);close.addActionListener(this);reset.addActionListener(this);
    }
    public void actionPerformed(ActionEvent k)
    {
        if(k.getSource()==register)
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection obj=DriverManager.getConnection("jdbc:mysql://localhost:3306/Quiz","root","hemnaik9000123@");
                boolean flag=false;
                String name=t1.getText().toString();
                long contact=Long.parseLong(t2.getText().toString());
                String gender=" ";
                if(male.isSelected()==true)
                {
                    gender="male";
                }
                if(female.isSelected()==true)
                {
                    gender="female";
                }if(others.isSelected()==true)
            {
                gender="others";
            }
                String email=t6.getText().toString();
                String username=t3.getText().toString();
                int password=Integer.parseInt(t4.getText().toString());
                int c_password=Integer.parseInt(t5.getText().toString());
                if(password==c_password)
                {
                    JOptionPane.showMessageDialog(this,"Password Match Successfully","Information",JOptionPane.OK_CANCEL_OPTION);


                    String select="SELECT username,password FROM quiz_user";
                    Statement s1=obj.prepareStatement(select);
                    ResultSet rs=s1.executeQuery(select);
                    while(rs.next())
                    {
                        if(username.equals(rs.getString(1))&&password==rs.getInt(2)) {
                            flag = true;
                            break;
                        }
                    }
                    rs.close();

                    if(flag==true) {
                        JOptionPane.showMessageDialog(this, "User Already Exists", "Information", JOptionPane.OK_CANCEL_OPTION);

                    }
                    else
                    {
                        String insert = "INSERT INTO quiz_user(name,gender,contact,username,password,android,c,php,java,DS,email) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement s = obj.prepareStatement(insert);
                        s.setString(1, name);
                        s.setString(2, gender);
                        s.setLong(3, contact);
                        s.setString(4, username);
                        s.setInt(5, password);
                        s.setInt(6, 0);
                        s.setInt(7, 0);
                        s.setInt(8, 0);
                        s.setInt(9, 0);
                        s.setInt(10, 0);
                        s.setString(11, email);
                        s.executeUpdate();
                        s.close();
                        obj.close();
                        JOptionPane.showMessageDialog(this, "User Added Successfully", "Information", JOptionPane.OK_CANCEL_OPTION);

                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Password Match Not Found","Information",JOptionPane.OK_CANCEL_OPTION);
                }
            }
            catch(Exception k1)
            {
                JOptionPane.showMessageDialog(this,"Error Exists","Warning",JOptionPane.WARNING_MESSAGE);

            }
        }
        if(k.getSource()==close)
        {
            this.setVisible(false);
        }
        if(k.getSource()==reset)
        {
            t1.setText(null);t2.setText(null);g.clearSelection();t3.setText(null);
            t4.setText(null);t5.setText(null);t6.setText(null);
        }
    }
}
