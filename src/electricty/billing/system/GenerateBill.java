/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricty.billing.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author dell
 */
public class GenerateBill extends JFrame implements ActionListener {

    Choice cmonth;
    String meter;
    JTextArea area;
    JButton bill;

    GenerateBill(String meter) {
        this.meter = meter;
        setSize(500, 700);
        setLocation(450, 20);

        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setBackground(new Color(151, 162, 209));

        JLabel heading = new JLabel("Generate Bill");

        JLabel meternumber = new JLabel(meter);

        cmonth = new Choice();
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");

        area = new JTextArea(50, 15);
        area.setText("\n-----------------------------CLICK ON THE----------------------------\n\t Generate Bill Button To Get\n\t The Bill Of Selected Month");
        area.setFont(new Font("Senserif", Font.ITALIC, 18));
        area.setBackground(new Color(198, 207, 247));
        JScrollPane pane = new JScrollPane(area);

        bill = new JButton("GENERATE BILL");
        bill.addActionListener(this);

        panel.add(heading);
        panel.add(meternumber);
        panel.add(cmonth);
        add(panel, "North");
        add(pane, "Center");
        add(bill, "South");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            ConnectionDB c = new ConnectionDB();

            String month = cmonth.getSelectedItem();

            area.setText("\n\tRELIANCE POWER LIMITED\n             Electricty Bill Generated For The Month Of \n\t           " + month + ", 2022\n\n\n");

            ResultSet rs = c.s.executeQuery("select * from customer where meter_no= '" + meter + "'");

            if (rs.next()) {
                area.append("\n--------------------------------------------------------------------------------------------------------------");
                area.append("\n    Customer Name: " + rs.getString("name"));
                area.append("\n    Meter Number : " + rs.getString("meter_no"));
                area.append("\n    Address : " + rs.getString("address"));
                area.append("\n    City  : " + rs.getString("city"));
                area.append("\n    State : " + rs.getString("state"));
                area.append("\n    Email : " + rs.getString("email"));
                area.append("\n    Phone : " + rs.getString("phone"));
                area.append("\n--------------------------------------------------------------------------------");
                area.append("\n");
            }

            rs = c.s.executeQuery("select * from meter_info where meter_no = '" + meter + "'");

            if (rs.next()) {
                area.append("\n    Meter Location: " + rs.getString("meter_location"));
                area.append("\n    Meter Type :   " + rs.getString("meter_type"));
                area.append("\n    Phase Code :  " + rs.getString("phase_code"));
                area.append("\n    Bill Type :  " + rs.getString("bill_type"));
                area.append("\n    Days :    " + rs.getString("days"));
                area.append("\n----------------------------------------------------------------------------------------------------------");
                area.append("\n");
            }

            rs = c.s.executeQuery("select * from tax");

            if (rs.next()) {
                area.append("\n");
                area.append("\n    Cost Per Unit: " + rs.getString("cost_per_unit"));
                area.append("\n    Meter Rent:    " + rs.getString("cost_per_unit"));
                area.append("\n    Service Charge: " + rs.getString("service_charge"));
                area.append("\n    Service Tax:    " + rs.getString("service_charge"));
                area.append("\n    Swacch Bharat Cess:  " + rs.getString("swacch_bharat_cess"));
                area.append("\n    Fixed Tax: " + rs.getString("fixed_tax"));
                area.append("\n--------------------------------------------------------------------------------------------------------------");
                area.append("\n");
            }

            rs = c.s.executeQuery("select * from bill where meter_no = '" + meter + "' and month='" + month + "'");

            if (rs.next()) {
                area.append("\n");
                area.append("\n    Current Month: " + rs.getString("month"));
                area.append("\n    Units Consumed:  " + rs.getString("units"));
                area.append("\n    Total Charges:   " + rs.getString("totalbill"));
                area.append("\n-----------------------------------------------------------------------------------------------------------------------------------------");
                area.append("\n    Total Payable: " + rs.getString("totalbill"));
                area.append("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new GenerateBill("");
    }
}
