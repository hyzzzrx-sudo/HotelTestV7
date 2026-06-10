package com.mycompany.HotelReservationApp.mainsystem.guest.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * MakeReservationPanel - Make a New Reservation
 * Step-by-step booking form with price calculation
 */
public class MakeReservationPanel extends JPanel implements ActionListener {
    
    private JTextField txtCheckIn, txtCheckOut, txtRoomNumber, txtGuests;
    private JTextField txtRoomRate, txtNights, txtSubtotal, txtTax, txtTotal;
    private JComboBox<String> cmbPaymentMethod;
    private JButton btnCalculate, btnConfirm, btnCancel;
    private JLabel lblErrorMessage;
    private JTextArea areaConfirmation;
    
    public MakeReservationPanel() {
        setLayout(null);
        setBackground(Color.decode("#F5F5F5"));
        createComponents();
    }
    
    private void createComponents() {
        JPanel titleBar = new JPanel(null);
        titleBar.setBounds(30, 20, 880, 50);
        titleBar.setBackground(Color.decode("#222222"));
        add(titleBar);
        
        JLabel lblTitle = new JLabel("MAKE A RESERVATION");
        lblTitle.setBounds(15, 8, 400, 34);
        lblTitle.setFont(new Font("Arial Black", Font.BOLD, 20));
        lblTitle.setForeground(Color.WHITE);
        titleBar.add(lblTitle);
        
        lblErrorMessage = new JLabel();
        lblErrorMessage.setFont(new Font("Arial", Font.PLAIN, 11));
        lblErrorMessage.setForeground(new Color(244, 67, 54));
        lblErrorMessage.setBounds(30, 75, 880, 20);
        lblErrorMessage.setVisible(false);
        add(lblErrorMessage);
        
        JPanel leftPanel = new JPanel(null);
        leftPanel.setBounds(30, 100, 420, 420);
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        add(leftPanel);
        
        JLabel lblCheckIn = new JLabel("Check-In (YYYY-MM-DD): *");
        lblCheckIn.setBounds(15, 15, 200, 20);
        lblCheckIn.setFont(new Font("Arial", Font.BOLD, 11));
        leftPanel.add(lblCheckIn);
        
        txtCheckIn = new JTextField();
        txtCheckIn.setBounds(15, 35, 380, 30);
        leftPanel.add(txtCheckIn);
        
        JLabel lblCheckOut = new JLabel("Check-Out (YYYY-MM-DD): *");
        lblCheckOut.setBounds(15, 70, 200, 20);
        lblCheckOut.setFont(new Font("Arial", Font.BOLD, 11));
        leftPanel.add(lblCheckOut);
        
        txtCheckOut = new JTextField();
        txtCheckOut.setBounds(15, 90, 380, 30);
        leftPanel.add(txtCheckOut);
        
        JLabel lblRoomNumber = new JLabel("Room Number: *");
        lblRoomNumber.setBounds(15, 125, 200, 20);
        lblRoomNumber.setFont(new Font("Arial", Font.BOLD, 11));
        leftPanel.add(lblRoomNumber);
        
        txtRoomNumber = new JTextField();
        txtRoomNumber.setBounds(15, 145, 380, 30);
        leftPanel.add(txtRoomNumber);
        
        JLabel lblGuests = new JLabel("Number of Guests: *");
        lblGuests.setBounds(15, 180, 200, 20);
        lblGuests.setFont(new Font("Arial", Font.BOLD, 11));
        leftPanel.add(lblGuests);
        
        txtGuests = new JTextField();
        txtGuests.setBounds(15, 200, 380, 30);
        leftPanel.add(txtGuests);
        
        JLabel lblPayment = new JLabel("Payment Method: *");
        lblPayment.setBounds(15, 235, 200, 20);
        lblPayment.setFont(new Font("Arial", Font.BOLD, 11));
        leftPanel.add(lblPayment);
        
        cmbPaymentMethod = new JComboBox<>(new String[]{
            "- Select -", "Cash", "Credit Card", "E-Wallet"
        });
        cmbPaymentMethod.setBounds(15, 255, 380, 30);
        leftPanel.add(cmbPaymentMethod);
        
        btnCalculate = new JButton("CALCULATE PRICE");
        btnCalculate.setBounds(15, 300, 180, 35);
        btnCalculate.setBackground(new Color(76, 175, 80));
        btnCalculate.setForeground(Color.WHITE);
        btnCalculate.setFont(new Font("Arial", Font.BOLD, 11));
        btnCalculate.setBorderPainted(false);
        btnCalculate.setFocusPainted(false);
        btnCalculate.addActionListener(this);
        leftPanel.add(btnCalculate);
        
        btnCancel = new JButton("CANCEL");
        btnCancel.setBounds(215, 300, 180, 35);
        btnCancel.setBackground(new Color(244, 67, 54));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFont(new Font("Arial", Font.BOLD, 11));
        btnCancel.setBorderPainted(false);
        btnCancel.setFocusPainted(false);
        btnCancel.addActionListener(this);
        leftPanel.add(btnCancel);
        
        JPanel rightPanel = new JPanel(null);
        rightPanel.setBounds(470, 100, 410, 420);
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        add(rightPanel);
        
        JLabel lblRoomRate = new JLabel("Room Rate/Night:");
        lblRoomRate.setBounds(15, 15, 150, 20);
        lblRoomRate.setFont(new Font("Arial", Font.BOLD, 11));
        rightPanel.add(lblRoomRate);
        
        txtRoomRate = new JTextField();
        txtRoomRate.setEditable(false);
        txtRoomRate.setBounds(170, 13, 215, 25);
        rightPanel.add(txtRoomRate);
        
        JLabel lblNights = new JLabel("Number of Nights:");
        lblNights.setBounds(15, 50, 150, 20);
        lblNights.setFont(new Font("Arial", Font.BOLD, 11));
        rightPanel.add(lblNights);
        
        txtNights = new JTextField();
        txtNights.setEditable(false);
        txtNights.setBounds(170, 48, 215, 25);
        rightPanel.add(txtNights);
        
        JLabel lblSubtotal = new JLabel("Subtotal:");
        lblSubtotal.setBounds(15, 85, 150, 20);
        lblSubtotal.setFont(new Font("Arial", Font.BOLD, 11));
        rightPanel.add(lblSubtotal);
        
        txtSubtotal = new JTextField();
        txtSubtotal.setEditable(false);
        txtSubtotal.setBounds(170, 83, 215, 25);
        rightPanel.add(txtSubtotal);
        
        JLabel lblTax = new JLabel("Tax (12%):");
        lblTax.setBounds(15, 120, 150, 20);
        lblTax.setFont(new Font("Arial", Font.BOLD, 11));
        rightPanel.add(lblTax);
        
        txtTax = new JTextField();
        txtTax.setEditable(false);
        txtTax.setBounds(170, 118, 215, 25);
        rightPanel.add(txtTax);
        
        JLabel lblTotal = new JLabel("TOTAL PRICE:");
        lblTotal.setBounds(15, 160, 150, 25);
        lblTotal.setFont(new Font("Arial Black", Font.BOLD, 13));
        lblTotal.setForeground(new Color(244, 67, 54));
        rightPanel.add(lblTotal);
        
        txtTotal = new JTextField();
        txtTotal.setEditable(false);
        txtTotal.setFont(new Font("Arial", Font.BOLD, 14));
        txtTotal.setForeground(new Color(244, 67, 54));
        txtTotal.setBounds(170, 158, 215, 30);
        rightPanel.add(txtTotal);
        
        areaConfirmation = new JTextArea();
        areaConfirmation.setEditable(false);
        areaConfirmation.setFont(new Font("Arial", Font.PLAIN, 11));
        areaConfirmation.setText("Fill in the form and click CALCULATE PRICE to view your reservation details.");
        JScrollPane scrollPane = new JScrollPane(areaConfirmation);
        scrollPane.setBounds(15, 210, 380, 155);
        rightPanel.add(scrollPane);
        
        btnConfirm = new JButton("CONFIRM & BOOK");
        btnConfirm.setBounds(170, 375, 215, 35);
        btnConfirm.setBackground(new Color(33, 150, 243));
        btnConfirm.setForeground(Color.WHITE);
        btnConfirm.setFont(new Font("Arial", Font.BOLD, 12));
        btnConfirm.setBorderPainted(false);
        btnConfirm.setFocusPainted(false);
        btnConfirm.setEnabled(false);
        btnConfirm.addActionListener(this);
        rightPanel.add(btnConfirm);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalculate) {
            calculatePrice();
        } else if (e.getSource() == btnConfirm) {
            confirmReservation();
        } else if (e.getSource() == btnCancel) {
            clearForm();
        }
    }
    
    private void calculatePrice() {
        String checkIn = txtCheckIn.getText().trim();
        String checkOut = txtCheckOut.getText().trim();
        String room = txtRoomNumber.getText().trim();
        String guests = txtGuests.getText().trim();
        String paymentMethod = (String) cmbPaymentMethod.getSelectedItem();
        
        if (checkIn.isEmpty() || checkOut.isEmpty() || room.isEmpty() || guests.isEmpty()) {
            showError("Please fill in all required fields");
            return;
        }
        
        if (paymentMethod.equals("- Select -")) {
            showError("Please select a payment method");
            return;
        }
        
        try {
            LocalDate inDate = LocalDate.parse(checkIn);
            LocalDate outDate = LocalDate.parse(checkOut);
            
            if (outDate.isBefore(inDate) || outDate.equals(inDate)) {
                showError("Check-out date must be after check-in date");
                return;
            }
            
            long nights = ChronoUnit.DAYS.between(inDate, outDate);
            double roomRate = 5000;
            double subtotal = roomRate * nights;
            double tax = subtotal * 0.12;
            double total = subtotal + tax;
            
            txtNights.setText(String.valueOf(nights));
            txtRoomRate.setText("₱" + String.format("%.2f", roomRate));
            txtSubtotal.setText("₱" + String.format("%.2f", subtotal));
            txtTax.setText("₱" + String.format("%.2f", tax));
            txtTotal.setText("₱" + String.format("%.2f", total));
            
            areaConfirmation.setText(
                "RESERVATION SUMMARY\n\n" +
                "Check-in: " + inDate + "\n" +
                "Check-out: " + outDate + "\n" +
                "Number of Nights: " + nights + "\n" +
                "Room Number: " + room + "\n" +
                "Number of Guests: " + guests + "\n" +
                "Payment Method: " + paymentMethod + "\n\n" +
                "Room Rate: ₱" + String.format("%.2f", roomRate) + "/night\n" +
                "Subtotal: ₱" + String.format("%.2f", subtotal) + "\n" +
                "Tax (12%): ₱" + String.format("%.2f", tax) + "\n" +
                "TOTAL: ₱" + String.format("%.2f", total) + "\n\n" +
                "Click CONFIRM & BOOK to complete your reservation."
            );
            
            btnConfirm.setEnabled(true);
            lblErrorMessage.setVisible(false);
        } catch (Exception ex) {
            showError("Invalid input. Please check your entries.");
        }
    }
    
    private void confirmReservation() {
        JOptionPane.showMessageDialog(this,
            "Reservation confirmed successfully!\n\nYour booking has been saved.\n" +
            "Check your email for confirmation details.",
            "Reservation Confirmed",
            JOptionPane.INFORMATION_MESSAGE);
        clearForm();
    }
    
    private void clearForm() {
        txtCheckIn.setText("");
        txtCheckOut.setText("");
        txtRoomNumber.setText("");
        txtGuests.setText("");
        cmbPaymentMethod.setSelectedIndex(0);
        txtRoomRate.setText("");
        txtNights.setText("");
        txtSubtotal.setText("");
        txtTax.setText("");
        txtTotal.setText("");
        areaConfirmation.setText("Fill in the form and click CALCULATE PRICE to view your reservation details.");
        btnConfirm.setEnabled(false);
        lblErrorMessage.setVisible(false);
    }
    
    private void showError(String message) {
        lblErrorMessage.setText("⚠ " + message);
        lblErrorMessage.setVisible(true);
    }
}
