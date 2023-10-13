/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricty.billing.system;

/**
 *
 * @author dell
 */
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class BillDetails extends JFrame {

    BillDetails(String meter) {
        setSize(700, 650);
        setLocation(400, 50);

        getContentPane().setBackground(new Color(151, 162, 209));

        
        JTable table = new JTable();
        
        
        try {
            ConnectionDB c = new ConnectionDB();
            String query = "select * from bill where meter_no='" + meter + "'";
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBackground(new Color(151, 162, 209));
        sp.setForeground(new Color(151, 162, 209));
        sp.setBounds(0, 0, 700, 650);
        add(sp);
  
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new BillDetails("");
    }
}
