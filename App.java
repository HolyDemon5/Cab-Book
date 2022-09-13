import java.util.Scanner;
import java.lang.Math;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
class User
{
    public String fname=new String();
    public String lname=new String();
    public String eid=new String();
    public String phn=new String();
    public String uid=new String();
    public String pswd=new String();
    public String val=new String();
    public double px,py;
    public double dx,dy;
    public int count;
    public double fare;
    public double money=0;
    Cab c1 = new Cab(); 
    Location l1 = new Location(); Location l2 = new Location(); Location l3 = new Location();
    public void newusr()
    {
        JFrame nuf = new JFrame("Cab@BITS");
        JPanel nup1 = new JPanel();
        nup1.setLayout(new GridBagLayout());
        JPanel nup2 = new JPanel();
        nup2.setLayout(new FlowLayout());
        JLabel nul1 = new JLabel("Enter your First Name:",SwingConstants.CENTER); 
        JTextField nut1 = new JTextField(10);
        JLabel nul2 = new JLabel("Enter your Last Name:",SwingConstants.CENTER);
        JTextField nut2 = new JTextField(10); 
        JLabel nul3 = new JLabel("Enter your email-ID:",SwingConstants.CENTER); 
        JTextField nut3 = new JTextField(10);
        JLabel nul4 = new JLabel("Enter your Phone No:",SwingConstants.CENTER);
        JTextField nut4 = new JTextField(10);
        JLabel nul5 = new JLabel("Username:",SwingConstants.CENTER);
        JTextField nut5 = new JTextField(10);
        JLabel nul6 = new JLabel("Password:",SwingConstants.CENTER);
        JPasswordField nupf = new JPasswordField(10); 
        JButton nub = new JButton("Submit"); JLabel msg = new JLabel();
        nub.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent le) 
            { 
            	fname = nut1.getText();
                lname = nut2.getText();
				eid = nut3.getText();
				phn = nut4.getText();
                uid = nut5.getText();
                pswd = nupf.getText(); 
                count=0; int counter = 0; 
                String line="";
                String uc[];
                int ctr=0;
             /*   try 
                {
                    BufferedReader br = new BufferedReader(new FileReader("/Users/abhignu/Documents/BITS/OOPP/userdb.txt"));
                    try 
                    {
                        while((line = br.readLine()) != null)
                        {
                            uc=line.split(" ");
                            if(uid.equals(uc[0]))
                            {  
                                ctr=1;
                                msg.setText("Username already exists");
                                break;
                            }   
                        }
                        br.close();
                    } 
                    catch (IOException e) 
                    {
                        e.printStackTrace();
                    }
                }
                catch (FileNotFoundException e) 
                {
                    e.printStackTrace();
                }
                if(ctr==0)
                {*/
                    try 
                    {  
                        BufferedWriter out = new BufferedWriter( 
                        new FileWriter("userdb.txt",true));
                        BufferedWriter in = new BufferedWriter( 
                        new FileWriter("usercredentials.txt",true)); 
                        BufferedWriter ac = new BufferedWriter( 
                        new FileWriter("availbal.txt",true));  
                        in.write(fname);
                        in.write(" ");
                        in.write(lname);
                        in.write(" ");
                        in.write(eid);
                        in.write(" ");
                        in.write(phn);
                        in.write(" ");
                        in.write(uid);
                        in.write(" ");
                        in.write(pswd);
                        in.write("\n");
                        in.close();
                        out.write(uid);
                        out.write(" ");
                        out.write(pswd);
                        out.write("\n"); 
                        out.close(); 
                        ac.write("0");
                        ac.write("\n"); 
                        ac.close();
                    } 
                    catch (IOException e) 
                    { 
                        System.out.println("exception occoured" + e); 
                    }    
                    exstusr();
                //}
            } 
        });
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        nup1.add(nul1, gbc);
        gbc.gridy++;
        nup1.add(nul2, gbc);
        gbc.gridy++;
        nup1.add(nul3, gbc);
        gbc.gridy++;
        nup1.add(nul4, gbc);
        gbc.gridy++;
        nup1.add(nul5, gbc);
        gbc.gridy++;
        nup1.add(nul6, gbc);
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx++;
        gbc.gridy = 0;
        nup1.add(nut1, gbc);
        gbc.gridy++;
        nup1.add(nut2, gbc);
        gbc.gridy++;
        nup1.add(nut3, gbc);
        gbc.gridy++;
        nup1.add(nut4, gbc);
        gbc.gridy++;
        nup1.add(nut5, gbc);
        gbc.gridy++;
        nup1.add(nupf, gbc);
        nup2.add(nub); nup2.add(msg);
        nuf.add(nup1,"North");nuf.add(nup2,"Center"); 
        nuf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nuf.setSize(1920,1080);
        nuf.setVisible(true);
    }
    public void exstusr()
    {
        JFrame euf = new JFrame();
        JPanel eup1 = new JPanel();
        eup1.setLayout(new GridBagLayout());
        JPanel eup2 = new JPanel();
        eup2.setLayout(new FlowLayout());
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        JLabel eul = new JLabel(); eul.setFont(font1);
        JLabel eul1 = new JLabel("Username:",SwingConstants.CENTER); eul1.setFont(font1);
        JTextField eut1 = new JTextField(10); 
        JLabel eul2 = new JLabel("Password:",SwingConstants.CENTER); eul2.setFont(font1);
        JPasswordField eupf = new JPasswordField(10);
        JButton eub = new JButton("Login");
        eub.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent le) 
            { 
            	count=0; int counter = 0;
                String line="";
                String s1 = eut1.getText(); String s2 = eupf.getText();
                String search=s1+" "+s2;
                try 
                {
                    BufferedReader br = new BufferedReader(new FileReader("/Users/abhignu/Documents/BITS/OOPP/userdb.txt"));
                    try 
                    {
                        while((line = br.readLine()) != null)
                        {
                            count++;
                            if(line.equals(search))
                            {  
                                counter=1;
                                HomePage();
                                break;
                            }   
                        }
                        if(count==0)
                            eul.setText("Incorrect Username or Password");
                        br.close();
                    } 
                    catch (IOException e) 
                    {
                        e.printStackTrace();
                    }
                }
                catch (FileNotFoundException e) 
                {
                    e.printStackTrace();
                }
            }
        });
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        eup1.add(eul1, gbc);

        gbc.gridy++;
        eup1.add(eul2, gbc);
         
        gbc.gridy++;
        eup1.add(eul, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx++;
        gbc.gridy = 0;
        eup1.add(eut1, gbc);

        gbc.gridy++;
        eup1.add(eupf, gbc);
        eup2.add(eub); euf.add(eup1,"North"); euf.add(eup2,"Center");
        euf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        euf.setSize(1920,1080);
        euf.setVisible(true);
    }
    public void HomePage()
    {
    	l1.cod(17.5425,78.5740); l1.setlocname("Mess 1,BPHC");
    	l2.cod(17.5718,78.5576); l2.setlocname("Alankrita Resorts");
        l3.cod(17.5780,78.6019); l3.setlocname("Leonia Holistic Destination");
        c1.setdriverlocation(17.5718,78.5576);
        int i=1; String line; val="0"; String st="";
                try 
                {
                    BufferedReader br = new BufferedReader(new FileReader("/Users/abhignu/Documents/BITS/OOPP/availbal.txt"));
                    BufferedReader reader = new BufferedReader(new FileReader("/Users/abhignu/Documents/BITS/OOPP/usercredentials.txt"));
                    try 
                    {
                        while((line = br.readLine()) != null)
                        {
                            if(i++==count)
                            {  
                                val=line;
                                st = reader.readLine();
                                break;
                            }   
                        }
                        br.close();
                    } 
                    catch (IOException e) 
                    {
                        e.printStackTrace();
                    }
                }
                catch (FileNotFoundException e) 
                {
                    e.printStackTrace();
                }
                money=Double.parseDouble(val);
                String info[] = st.split(" ");
                fname=info[0]; lname=info[1]; eid=info[2]; phn=info[3];
    	JFrame hpf = new JFrame("Cab@BITS");
        JTabbedPane jtp =  new JTabbedPane();
        Font font1 = new Font("SansSerif", Font.BOLD, 30);
        Font font2 = new Font("SansSerif", Font.BOLD, 20);
        JPanel hp = new JPanel(); hp.setLayout(new GridLayout(3,3));
        JPanel wp = new JPanel(); wp.setLayout(new FlowLayout());
        JPanel pp = new JPanel(); pp.setLayout(new GridBagLayout());
        jtp.addTab("Home", hp); 
        jtp.addTab("Digital Wallet", wp); 
        jtp.addTab("Profile", pp);
        JLabel hpl1 = new JLabel("Enter your Pickup Location"); hpl1.setFont(font1);
        String sites[] = {l1.locname,l2.locname,l3.locname};
        JComboBox cb1 = new JComboBox(sites); JComboBox cb2 = new JComboBox(sites);
        cb1.setFont(font2); cb2.setFont(font2);
        JButton cbb1 = new JButton("Select"); JButton cbb2 = new JButton("Select"); 
        cbb1.setFont(font1); cbb2.setFont(font1);
        cbb1.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent le) 
            {   
                for(int k=0;k<sites.length;k++)
                {
                    if((cb1.getItemAt(cb1.getSelectedIndex())).equals(sites[k]))
                    { 
                        switch(k)
                        {
                            case 1:
                                px=l1.x; py=l1.y;
                                break;
                            case 2:
                                px=l2.x; py=l2.y;
                                break;
                            default:
                                px=l3.x; py=l3.y;
                                break;
                        }   
                        break; 
                    } 
                }
            }    
        });
        JLabel hpl2 = new JLabel("Enter your Drop Location"); hpl2.setFont(font1);
        cbb2.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent le) 
            {   
                for(int k=0;k<sites.length;k++)
                {
                    if((cb2.getItemAt(cb2.getSelectedIndex())).equals(sites[k]))
                    { 
                        switch(k)
                        {
                            case 1:
                                dx=l1.x; dy=l1.y;
                                break;
                            case 2:
                                dx=l2.x; dy=l2.y;
                                break;
                            default:
                                dx=l3.x; dy=l3.y;
                                break;
                        }   
                        break; 
                    } 
                }
            }    
        });
        JLabel wpl1 = new JLabel("Balance: ");
        JLabel wpl2 = new JLabel("₹"+String.valueOf(money));
        JButton adm = new JButton("Add Money");
        JTextField wpt1 = new JTextField(5);
        JButton bac = new JButton("Avail a Cab"); bac.setFont(font1);
        JButton cf = new JButton("Estimate Fare"); cf.setFont(font1);
        JLabel hpl3 = new JLabel(); hpl3.setFont(font1); 
        JLabel ppl1 = new JLabel("First Name: ",SwingConstants.LEFT); JLabel ppl2 = new JLabel(fname,SwingConstants.CENTER); ppl1.setFont(font1); ppl2.setFont(font1);
        JLabel ppl3 = new JLabel("Last Name: ",SwingConstants.LEFT); JLabel ppl4 = new JLabel(lname,SwingConstants.CENTER); ppl3.setFont(font1); ppl4.setFont(font1);
        JLabel ppl5 = new JLabel("Email-ID: ",SwingConstants.LEFT); JLabel ppl6 = new JLabel(eid,SwingConstants.CENTER); ppl5.setFont(font1); ppl6.setFont(font1);
        JLabel ppl7 = new JLabel("Phone No: ",SwingConstants.LEFT); JLabel ppl8 = new JLabel(phn,SwingConstants.CENTER); ppl7.setFont(font1); ppl8.setFont(font1);
        fare=c1.fare(px,py,dx,dy);
        bac.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent le) 
            {   
                if(money<300)
                {
                    hpl3.setText("Error, Balance<₹300");
                }
                else
                {
                    try
                    {
                        c1.FindDriverDetails(String.valueOf(2));
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error found");
                    }
                    /*money=money-fare;
                    String val2=String.valueOf(money);
                    String newtext=""; String line="";
                    int a=1;
                    try 
                    {   
                        BufferedReader reader = new BufferedReader(new FileReader("/Users/abhignu/Documents/BITS/OOPP/availbal.txt"));
                        try 
                        {
                            String oldtext = "";
                        while((line = reader.readLine()) != null)
                        {       
                                if(a==count)
                                {  
                                 line =line.replaceAll(val,val2);
                                }
                                oldtext += line + "\r\n";
                                a++;
                        }
                        reader.close();  
                        FileWriter writer = new FileWriter("/Users/abhignu/Documents/BITS/OOPP/availbal.txt");
                        writer.write(oldtext);writer.close();       
                        } 
                        catch (IOException e) 
                        {
                            e.printStackTrace();
                        }
                    }
                    catch (FileNotFoundException e) 
                    {
                        e.printStackTrace();
                    }*/
                    c1.journey(px,py,c1.cx,c1.cy,dx,dy);
                }   
            }    
        });
        cf.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent le) 
            {   
                hpl3.setText("₹"+String.valueOf(fare));
            }    
        });
        adm.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent le) 
            { 
                String line="";
                money=0;
                money=money+Double.parseDouble(wpt1.getText());
                String val2=String.valueOf(money);
                String newtext="";
                 int a=1;
                try 
                {   
                    BufferedReader reader = new BufferedReader(new FileReader("/Users/abhignu/Documents/BITS/OOPP/availbal.txt"));
                    try 
                    {
                              String oldtext = "";
                while((line = reader.readLine()) != null)
                    {       
                            if(a==count)
                            {  
                             line =line.replaceAll(val,val2);
                            }
                            oldtext += line + "\r\n";
                            a++;
                    }
                    reader.close();  
                    FileWriter writer = new FileWriter("/Users/abhignu/Documents/BITS/OOPP/availbal.txt");
                    writer.write(oldtext);writer.close();       
                    } 
                    catch (IOException e) 
                    {
                        e.printStackTrace();
                    }
                }
                catch (FileNotFoundException e) 
                {
                    e.printStackTrace();
                }
                wpl2.setText("₹"+String.valueOf(money));
            } 
        });
        hp.add(hpl1); hp.add(cb1); hp.add(cbb1);
        hp.add(hpl2); hp.add(cb2); hp.add(cbb2);
        hp.add(cf); hp.add(bac); hp.add(hpl3);  
        wp.add(wpl1); wp.add(wpl2); wp.add(wpt1); wp.add(adm);
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        pp.add(ppl1, gc);

        gc.gridy++;
        pp.add(ppl3, gc);
         
        gc.gridy++;
        pp.add(ppl5, gc);
         
        gc.gridy++;
        pp.add(ppl7, gc);

        gc.anchor = GridBagConstraints.EAST;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx++;
        gc.gridy = 0;
        pp.add(ppl2, gc);

        gc.gridy++;
        pp.add(ppl4, gc);

        gc.gridy++;
        pp.add(ppl6, gc);

        gc.gridy++;
        pp.add(ppl8, gc);

        gc.anchor = GridBagConstraints.WEST;
        gc.fill = GridBagConstraints.NONE;
        hpf.add(jtp);
        hpf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hpf.setSize(1920,1080);
        hpf.setVisible(true);
    }
    public void RandomDrivers()
    {
        l1.cod(17.5425,78.5740); l1.setlocname("Mess 1,BPHC");
        l2.cod(17.5718,78.5576); l2.setlocname("Alankrita Resorts");
        l3.cod(17.5780,78.6019); l3.setlocname("Leonia Holistic Destination");
        int m=(int)(Math.random()*2)+1;
        for(int n=0;n<5;n++)
        {
            switch(m)
            {
                case 1:
                    c1.setdriverlocation(l1.x,l1.y);
                    break;
                case 2:
                    c1.setdriverlocation(l2.x,l2.y);
                    break;
                default:
                    c1.setdriverlocation(l3.x,l3.y);
                    break;
            }
        } 

    }
}
class Cab
{
	public String drn = new String();
	public double drr;
    public String cno = new String();
    public String drp = new String();
    public String drid = new String();
    public double cx,cy;
    public void setdriverlocation(double x, double y)
    {
    	cx=x;cy=y;
    }
    public void FindDriverDetails(String drid) throws IOException
    {
        File f1=new File("dd.txt"); 
        String[] words=null; String[] data=null; 
        FileReader fr = new FileReader(f1);  
        BufferedReader br = new BufferedReader(fr); 
        String s;     
        int count=0; 
        while((s=br.readLine())!=null)  
        {
            words=s.split(" ");  
            for (String word : words) 
            {
                if (word.equals(drid))   
                { 
                    data=s.split(" ");
                    count++;    
                }
            }
        }
        if(count!=0)  
        {
            drn=data[1];
            drr=Double.parseDouble(data[3]);
            drp=data[2];
            cno=data[4];
        }
        else
        {
            System.out.println("The given word is not present in the file");
        }
        fr.close();
    }
    public void journey(double lat1, double lon1, double lat2, double lon2, double lat3, double lon3)
    {
        JFrame at = new JFrame("Cab@BITS");
        JPanel dd = new JPanel();
        dd.setLayout(new GridLayout(6,2));
        JLabel ddl1 = new JLabel("Driver's Name: "); JLabel ddl2 = new JLabel(drn);
        JLabel ddl3 = new JLabel("Driver's Rating: "); JLabel ddl4 = new JLabel(String.valueOf(drr));
        JLabel ddl5 = new JLabel("Driver's Phone No: "); JLabel ddl6 = new JLabel(drp);
        JLabel ddl7 = new JLabel("Vehicle Rgstrn No: "); JLabel ddl8 = new JLabel(cno);
        JLabel ddl9 = new JLabel(); 
        if ((lat1 == lat2) && (lon1 == lon2)) 
    	{

			ddl9.setText("Your cab is here and waiting for you...");
		}
		else 
		{
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515* 1.609344;
			int art = (int)((dist/22.7)*60); 
			ddl9.setText("Your cab has been booked and will arrive in " + art + " minutes");
		}

        double alpha = lon1 - lon3;
        double d = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat3)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat3)) * Math.cos(Math.toRadians(alpha));
        d = Math.acos(d);
        d = Math.toDegrees(d);
        d = d * 60 * 1.1515* 1.609344;
        double cf = (20+(d*10));
        int jrt = (int)((d/22.7)*60); 
        JLabel jl1 = new JLabel("You will reach your destination in "+jrt+"minutes"); 
        JLabel jl2 = new JLabel("Your Fare is ₹"+(int)cf);
        dd.add(ddl1); dd.add(ddl2);
        dd.add(ddl3); dd.add(ddl4);
        dd.add(ddl5); dd.add(ddl6);
        dd.add(ddl7); dd.add(ddl8);
        dd.add(ddl9); dd.add(jl2);
        dd.add(jl1);
        at.add(dd);
        at.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        at.setSize(1920,1080);
        at.setVisible(true);
	}
    public double fare(double lt1, double ln1, double lt2, double ln2)
    {
        double alpha = ln1 - ln2;
        double d = Math.sin(Math.toRadians(lt1)) * Math.sin(Math.toRadians(lt2)) + Math.cos(Math.toRadians(lt1)) * Math.cos(Math.toRadians(lt2)) * Math.cos(Math.toRadians(alpha));
        d = Math.acos(d);
        d = Math.toDegrees(d);
        d = d * 60 * 1.1515* 1.609344;
        return (20+(d*10));
    }
}
class Location
{
	public double x,y;
    public String locname = new String();

    public void cod(double a,double b)
    {
        x=a;
        y=b;
    }
    public void setlocname(String l)
    {
        locname=l;
    }
}
public class App
{
    public static void main(String args[])
    {
    	JFrame frame = new JFrame("Cab@BITS");
        frame.setLayout(new FlowLayout()); 
        JLabel label1 = new JLabel("Welcome to Cab@BITS   ");
        JLabel label2 = new JLabel("Are you a first time user?");
        frame.add(label1); frame.add(label2);
        JButton yesButton = new JButton("Yes");
        yesButton.addActionListener(new 
            ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    User u1 = new User();
                    u1.newusr();
                }   
            });
        JButton noButton = new JButton("No");
        noButton.addActionListener(new 
            ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                  	User u1 = new User();
                    u1.exstusr();
                }
            });
        frame.add(yesButton); frame.add(noButton); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);
        frame.setVisible(true);
    }
}

