/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricty.billing.system;

/**
 *
 * @author dell
 */
import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
public class login extends JFrame implements ActionListener{
      JButton Login, cancel, signup;
    JTextField username, password;
    Choice logginin;
    login(){
        super("Login Page");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
          
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(240, 20, 100, 20);
        add(lblusername);
        
        username = new JTextField();
        username.setBounds(340, 20, 120, 20);
        add(username);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(240, 60, 100, 20);
        add(lblpassword);
        
        password = new JPasswordField();
        password.setBounds(340, 60, 120, 20);
        add(password);
        
        JLabel loggininas = new JLabel("Loggin in as");
        loggininas.setBounds(240, 100, 100, 20);
        add(loggininas);
        logginin=new Choice();
        logginin.add("Admin");
        logginin.add("Customer");
        logginin.setBounds(340,100,120, 20);
        add(logginin);
        //login Button
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2=i1.getImage().getScaledInstance(15, 15,Image.SCALE_DEFAULT);
        Login=new JButton("Login",new ImageIcon(i2));
        Login.setBounds(265,160,90,20);
         Login.addActionListener(this);
        add(Login);
        //cancle button
        ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i4=i3.getImage().getScaledInstance(15, 15,Image.SCALE_DEFAULT);
         cancel=new JButton("Cancel",new ImageIcon(i4));
       cancel.setBounds(365,160,100,20);
        cancel.addActionListener(this);
        add(cancel);
        //signup Button
        ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i6=i5.getImage().getScaledInstance(15, 15,Image.SCALE_DEFAULT);
         signup=new JButton("Signup",new ImageIcon(i6));
        signup.setBounds(300,200,100,20);
         signup.addActionListener(this);
        add(signup);
        // Image
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i8=i7.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        JLabel img=new JLabel(i9);
        img.setBounds(0,0,250,250);
        add(img);
        
        
      
        
        setSize(500,300);
        setLocation(400,200);
        setVisible(true);
        
    }
      public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Login){
            String susername=username.getText();
            String spassword=password.getText();
            String user=logginin.getSelectedItem();
            try{
                ConnectionDB c=new ConnectionDB();
                String query="select * from login where username='"+susername+"'and password='"+spassword+"'and user='"+user+"'";
                ResultSet rs=c.s.executeQuery(query);
               if(rs.next()){
                   String meter=rs.getString("meter_no");
                   setVisible(false);
                   new Project(user,meter);
               }else{
                   
                   JOptionPane.showMessageDialog(null, "Invalid Login !");
                   username.setText("");
                   password.setText("");
               }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
        else if(ae.getSource()==signup){
            setVisible(false);
            new Signup();
        }
    }
    public static void main(String []args){
        new login();
    }

    
}

