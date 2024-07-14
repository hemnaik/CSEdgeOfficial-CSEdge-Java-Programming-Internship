import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.Border;

class quiz_dashboard extends JFrame implements ActionListener
{
    ImageIcon w=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\welcome.jpg");
    ImageIcon a=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\anroid.jpg");
    ImageIcon s=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\start.jpg");
    ImageIcon p=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\php.jpg");
    ImageIcon c2=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\c.jpg");
    ImageIcon cplus=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\cplus.jpg");
    ImageIcon ds=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\ds.jpg");
    ImageIcon score=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\score.jpg");
    ImageIcon mem=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\admin.jpg");
    ImageIcon edit1=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\edit.jpg");
    ImageIcon re=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\reset.jpg");
    ImageIcon lo=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\logout.jpg");
    ImageIcon i1=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\scoreboard.jpg");
    ImageIcon i2=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\about.jpg");
    ImageIcon i3=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\carrental\\instruction.jpg");


    Font f=new Font("Sans serif",Font.PLAIN,20);
    Font f1=new Font("Sans serif",Font.PLAIN,15);
    JLabel l=new JLabel(w,SwingConstants.HORIZONTAL);

    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel android1=new JPanel();
    JPanel z=new JPanel();
    JPanel php1=new JPanel();
    JPanel c1=new JPanel();
    JPanel cplus1=new JPanel();JPanel ds1=new JPanel();
    Border blackline = BorderFactory.createLineBorder(Color.black);

    JLabel a1=new JLabel(a,SwingConstants.HORIZONTAL);
    JLabel pp1=new JLabel(p,SwingConstants.HORIZONTAL);
    JLabel c11=new JLabel(c2,SwingConstants.HORIZONTAL); JLabel ds11=new JLabel(ds,SwingConstants.HORIZONTAL);
    JLabel cplus11=new JLabel(cplus,SwingConstants.HORIZONTAL);

    JLabel l3=new JLabel();
    JLabel l4=new JLabel();
    JLabel l5=new JLabel();
    JLabel l6=new JLabel();

    JButton b=new JButton("Start",s);
    JButton b1=new JButton("Start",s);
    JLabel l7=new JLabel();
    JLabel l8=new JLabel();

    JButton b2=new JButton("Start",s);
    JLabel l9=new JLabel();
    JLabel l10=new JLabel();

    JButton b3=new JButton("Start",s);
    JLabel l11=new JLabel();
    JLabel l12=new JLabel();
    JButton b4=new JButton("Start",s);

    JButton resetp=new JButton("Reset Password",re);
    JButton logout=new JButton("Logout",lo);
    JButton view=new JButton("View Members",mem);
    JButton viewscore=new JButton("View Score",score);
    JButton edit=new JButton("Edit Details",edit1);
    JButton about=new JButton("About Us",i2);

    public String name;
    public int android,c,php,java,DS,password;

    //scoreboard//
    JLabel s1=new JLabel("Score Board",i1,SwingConstants.HORIZONTAL);
    JLabel s2=new JLabel(a,SwingConstants.HORIZONTAL);JLabel s3=new JLabel(c2,SwingConstants.HORIZONTAL);
    JLabel s4=new JLabel(p,SwingConstants.HORIZONTAL);JLabel s5=new JLabel(ds,SwingConstants.HORIZONTAL);
    JLabel s6=new JLabel(cplus,SwingConstants.HORIZONTAL);
    JLabel s22=new JLabel("0/15");JLabel s33=new JLabel("0/15");JLabel s44=new JLabel("0/15");JLabel s55=new JLabel("0/15");JLabel s66=new JLabel("0/15");

    //instruction board//
    JPanel h=new JPanel();
    JLabel h1=new JLabel("Instructions",i3,SwingConstants.HORIZONTAL);
    JLabel h2=new JLabel("1) Excellent - For score 10 to 15");
    JLabel h3=new JLabel("2) Good - For score 5 to 10");
    JLabel h4=new JLabel("3) Improve - For score 1 to 4");
    JLabel h5=new JLabel("4) Pending - If not attended");

    JProgressBar pb1=new JProgressBar(); JProgressBar pb2=new JProgressBar();JProgressBar pb3=new JProgressBar();
    JProgressBar pb4=new JProgressBar();JProgressBar pb5=new JProgressBar();

    Color xc=Color.decode("#dbe6f0");

    quiz_dashboard(int password)
    {

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection x = DriverManager.getConnection("jdbc:mysql://localhost:3306/Quiz", "root", "password");

            this.password=password;
            String select = "SELECT name,android,c,php,java,DS FROM quiz_user WHERE password=" + '"' + password + '"';
            Statement s = x.prepareStatement(select);
            ResultSet rs = s.executeQuery(select);
            while (rs.next())
            {
                this.name=rs.getString(1).toString();
                this.android = rs.getInt(2);
                this.c = rs.getInt(3);
                this.php = rs.getInt(4);
                this.java = rs.getInt(5);
                this.DS = rs.getInt(6);
                break;
            }
        }
        catch (Exception k)
        {
            System.out.println(k);
        }


        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(1400,540);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("QUIZ APPLICATION/DASHBOARD");

        p1.setLayout(null);
        p1.setVisible(true);
        p1.setBounds(0,0,200,520);
        p1.setBackground(Color.lightGray);

        viewscore.setBounds(20,50,150,30);view.setBounds(20,120,150,30);resetp.setBounds(20,190,150,30);
        logout.setBounds(20,260,150,30);edit.setBounds(20,330,150,30);about.setBounds(20,400,150,30);

        p1.add(view);
        p1.add(logout);
        p1.add(resetp);
        p1.add(viewscore);p1.add(edit);p1.add(about);

        p2.setLayout(null);
        p2.setVisible(true);
        p2.setBounds(202,0,1200,520);
        l3.setFont(f1);b.setFont(f1);l4.setFont(f1);
        l5.setFont(f1);b1.setFont(f1);l6.setFont(f1);
        l7.setFont(f1);b2.setFont(f1);l8.setFont(f1);
        l9.setFont(f1);b3.setFont(f1);l10.setFont(f1);
        l11.setFont(f1);b4.setFont(f1);l12.setFont(f1);




        //android_panel//
        l3.setBounds(50,50,110,20); l4.setBounds(50,70,100,20);b.setBounds(40,100,120,35);
        android1.add(a1);android1.add(l3);android1.add(l4);android1.add(b);
        a1.setBounds(80,20,30,30);
        android1.setLayout(null);
        android1.setBorder(blackline);
        android1.setVisible(true);
        android1.setBounds(50,80,200,150);
        l3.setText("Android Quiz");
        l4.setText("Questions = 15");

        //php_panel//
        l5.setBounds(50,50,110,20);l6.setBounds(50,70,100,20);b1.setBounds(40,100,120,35);
        php1.add(pp1);php1.add(l5);php1.add(l6);php1.add(b1);
        pp1.setBounds(80,20,30,30);
        php1.setLayout(null);
        php1.setBorder(blackline);
        php1.setVisible(true);
        php1.setBounds(270,80,200,150);
        l5.setText("Php Quiz");
        l6.setText("Questions = 15");

        //c_panel//
        l7.setBounds(50,50,120,20);l8.setBounds(50,70,100,20);b2.setBounds(40,100,120,35);
        c1.add(c11);c1.add(l7);c1.add(l8);c1.add(b2);
        c11.setBounds(80,20,30,30);
        c1.setLayout(null);
        c1.setBorder(blackline);
        c1.setVisible(true);
        c1.setBounds(490,80,200,150);
        l7.setText("C Programming");
        l8.setText("Questions = 15");

        //cplus/java_panel//
        l9.setBounds(50,50,120,20);l10.setBounds(50,70,100,20);b3.setBounds(40,100,120,35);
        cplus1.add(cplus11);cplus1.add(l10);cplus1.add(l9);cplus1.add(b3);
        cplus11.setBounds(80,20,30,30);
        cplus1.setLayout(null);
        cplus1.setBorder(blackline);
        cplus1.setVisible(true);
        cplus1.setBounds(710,80,200,150);
        l9.setText("Java Proramming");
        l10.setText("Questions = 15");

        //ds_panel//
        l11.setBounds(50,50,120,20);l12.setBounds(50,70,100,20);b4.setBounds(40,100,120,35);
        ds1.add(ds11);ds1.add(l12);ds1.add(l11);ds1.add(b4);
        ds11.setBounds(80,20,30,30);
        ds1.setLayout(null);
        ds1.setBorder(blackline);
        ds1.setVisible(true);
        ds1.setBounds(930,80,200,150);
        l11.setText("Data Structure");
        l12.setText("Questions = 15");


        l.setBounds(10,20,300,40);
        l.setFont(f);
        l.setText("Welcome "+this.name);
        p2.add(l);
        p2.add(android1);
        p2.add(php1);
        p2.add(c1);
        p2.add(cplus1);
        p2.add(ds1);
        this.add(p1);
        this.add(p2);
        p2.add(h);

        viewscore.addActionListener(this);
        logout.addActionListener(this);
        b1.addActionListener(this);b2.addActionListener(this);b3.addActionListener(this);b4.addActionListener(this);b.addActionListener(this);

        //instruction board//
        h.setBounds(870,260,300,210);
        h.setLayout(null);
        h.setBorder(blackline);
        h.setVisible(true);
        h.setBackground(xc);

        h1.setBounds(20,20,220,20);h2.setBounds(20,60,220,20);h3.setBounds(20,100,220,20);h4.setBounds(20,140,220,20);h5.setBounds(20,180,220,20);
        h.add(h2);h.add(h1);h.add(h3);h.add(h4);h.add(h5);h1.setFont(f);h2.setFont(f1);h3.setFont(f1);h4.setFont(f1);h5.setFont(f1);
    }
    public void actionPerformed(ActionEvent k1)
    {
        if(k1.getActionCommand()=="Logout")
        {
            this.setVisible(false);
        }
        if(k1.getActionCommand()=="View Score")
        {

            pb1.setValue(0);
            z.setBounds(50,260,800,210);
            z.setLayout(null);
            z.setBorder(blackline);
            z.setVisible(true);
            s1.setBounds(300,10,200,30);s1.setFont(f);

            s2.setBounds(10,50,40,30);s22.setFont(f1);
            s3.setBounds(370,50,40,30);s33.setFont(f1);
            s4.setBounds(10,110,40,30);s44.setFont(f1);
            s5.setBounds(370,110,40,30);s55.setFont(f1);
            s6.setBounds(10,170,40,30);s66.setFont(f1);

            s22.setBounds(50,50,100,30);s33.setBounds(410,50,100,30);
            s44.setBounds(50,110,100,30);s55.setBounds(410,110,100,30);
            s66.setBounds(50,170,100,30);


            z.add(s1);z.add(s2);z.add(s3);z.add(s4);z.add(s5);z.add(s6);z.add(s22);z.add(s33);z.add(s44);z.add(s55);z.add(s66);
            z.add(pb1);z.add(pb2);z.add(pb3);z.add(pb4);z.add(pb5);
            p2.add(z);

            //android//
            pb1.setStringPainted(true);
            if(this.android>10)
            {
                pb1.setString("Excellent");
            }
            else if(this.android>5&&this.android<=10)
            {
                pb1.setString("Good");
            }
            else if(this.android>=1&&this.android<=5)
            {
                pb1.setString("Improve");
            }
            else
            {
                pb1.setString("Pending");
            }
            pb1.setBounds(150,50,120,30);

            //c//
            pb2.setStringPainted(true);
            if(this.c>10)
            {
                pb2.setString("Excellent");
            }
            else if(this.c>5&&this.c<=10)
            {
                pb2.setString("Good");
            }
            else if(this.c>=1&&this.c<=5)
            {
                pb2.setString("Improve");
            }
            else
            {
                pb2.setString("Pending");
            }
            pb2.setBounds(500,50,120,30);


            //php//
            pb3.setStringPainted(true);
            if(this.php>10)
            {
                pb3.setString("Excellent");
            }
            else if(this.php>5&&this.php<=10)
            {
                pb3.setString("Good");
            }
            else if(this.php>=1&&this.php<=5)
            {
                pb3.setString("Improve");
            }
            else
            {
                pb3.setString("Pending");
            }
            pb3.setBounds(150,110,120,30);



            //ds//
            pb4.setStringPainted(true);
            if(this.DS>10)
            {
                pb4.setString("Excellent");
            }
            else if(this.DS>5&&this.DS<=10)
            {
                pb4.setString("Good");
            }
            else if(this.DS>=1&&this.DS<=5)
            {
                pb4.setString("Improve");
            }
            else
            {
                pb4.setString("Pending");
            }
            pb4.setBounds(500,110,120,30);


            //java//
            pb5.setStringPainted(true);
            if(this.java>10)
            {
                pb5.setString("Excellent");
            }
            else if(this.java>5&&this.java<=10)
            {
                pb5.setString("Good");
            }
            else if(this.java>=1&&this.java<=5)
            {
                pb5.setString("Improve");
            }
            else
            {
                pb5.setString("Pending");
            }
            pb5.setBounds(150,170,120,30);


            s22.setText("Score="+this.android+"/15");s33.setText("Score="+this.c+"/15");s44.setText("Score="+this.php+"/15");s55.setText("Score="+this.DS+"/15");
            s66.setText("Score="+this.java+"/15");


            repaint();
        }
        if(k1.getSource()==b)
        {
            Android_Quiz g=new Android_Quiz(this.password);
        }
        if(k1.getSource()==b2)
        {
            C_Quiz g=new C_Quiz(this.password);
        }
        if(k1.getSource()==b1)
        {
            Php_Quiz g=new Php_Quiz(this.password);
        }
        if(k1.getSource()==b4)
        {
            DS_Quiz g=new DS_Quiz(this.password);
        }
        if(k1.getSource()==b3)
        {
            Java_Quiz g=new Java_Quiz(this.password);
        }


    }
}

