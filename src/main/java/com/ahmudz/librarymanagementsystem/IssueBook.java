/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ahmudz.librarymanagementsystem;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * ahmudz
 */
public class IssueBook extends javax.swing.JFrame {

    public IssueBook() {
        initComponents();
        setTitle("Issue Books");

        if (StateManager.role.equals("student")) {
            studentComboBox.setVisible(false);
            studentLabel.setVisible(false);
        }

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        List<Book> books = BookManager.getBooks();

        LocalDate now = LocalDate.now();
        issueDateTextField.setText(now.format(DateTimeFormatter.ISO_DATE));

        model.addElement("-- Select Book --");

        for (int i = 0; i < books.size(); i++) {
            model.addElement(books.get(i));
        }

        selectBookComboBox.setModel(model);

        DatabaseConnection con = new DatabaseConnection();

        ResultSet resultSet = con.executeQuery("SELECT DISTINCT NAME FROM students;");

        try {

            while (resultSet.next()) {
                studentComboBox.addItem(resultSet.getString("name"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        isuueStatus = new javax.swing.JPanel();
        selectBookComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnEnter = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        inputAmount = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        issueStatusLabel = new javax.swing.JLabel();
        issueDateLabel = new javax.swing.JLabel();
        issueDateTextField = new javax.swing.JTextField();
        studentLabel = new javax.swing.JLabel();
        studentComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        isuueStatus.setBackground(new java.awt.Color(3, 87, 98));

        selectBookComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectBookComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select Book");

        btnEnter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEnter.setText("Enter");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Amount");

        inputAmount.setText("0");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("max...01");

        exit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        issueStatusLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        issueStatusLabel.setForeground(new java.awt.Color(255, 255, 255));
        issueStatusLabel.setText("Status");

        issueDateLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        issueDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        issueDateLabel.setText("Issue Date");

        issueDateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueDateTextFieldActionPerformed(evt);
            }
        });

        studentLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        studentLabel.setForeground(new java.awt.Color(255, 255, 255));
        studentLabel.setText("Student");

        studentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout isuueStatusLayout = new javax.swing.GroupLayout(isuueStatus);
        isuueStatus.setLayout(isuueStatusLayout);
        isuueStatusLayout.setHorizontalGroup(
            isuueStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(isuueStatusLayout.createSequentialGroup()
                .addGroup(isuueStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(isuueStatusLayout.createSequentialGroup()
                        .addGroup(isuueStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(isuueStatusLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(isuueStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addGroup(isuueStatusLayout.createSequentialGroup()
                                        .addComponent(btnBack)
                                        .addGap(18, 18, 18))
                                    .addComponent(jLabel2))
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, isuueStatusLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(isuueStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(studentLabel)
                                    .addComponent(issueDateLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(isuueStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(issueStatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectBookComboBox, 0, 170, Short.MAX_VALUE)
                            .addComponent(inputAmount)
                            .addComponent(issueDateTextField)
                            .addComponent(studentComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, isuueStatusLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnEnter)
                        .addGap(59, 59, 59)))
                .addGroup(isuueStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exit)
                    .addGroup(isuueStatusLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        isuueStatusLayout.setVerticalGroup(
            isuueStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(isuueStatusLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(isuueStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(selectBookComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(isuueStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inputAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(isuueStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(issueDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(issueDateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(isuueStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnEnter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(issueStatusLabel)
                .addGap(30, 30, 30)
                .addGroup(isuueStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exit)
                    .addComponent(btnBack))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(isuueStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(isuueStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void studentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentComboBoxActionPerformed

    }//GEN-LAST:event_studentComboBoxActionPerformed

    private void issueDateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueDateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_issueDateTextFieldActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MainWindow mWin = new MainWindow();
        this.setVisible(false);
        mWin.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed

        String book = selectBookComboBox.getSelectedItem().toString();
        if (book.equals("-- Select Book --")) {
            JOptionPane.showMessageDialog(this, "No Book slected");
            return;
        }

        boolean isValid = true;

        String loginId = StateManager.loginId;
        String bookId = book.split(" - ")[0];
        String amount = inputAmount.getText();
        int amountNum = Integer.parseInt(amount);
        String date = issueDateTextField.getText();
        String s_name = (String) studentComboBox.getSelectedItem();

        if (amountNum <= 0) {
            JOptionPane.showMessageDialog(this, "Amount Empty");
            return;
        }

        if (amountNum > 1) {
            JOptionPane.showMessageDialog(this, "Max amount Limit 1");
            return;
        }

        if (!isValid) {
            issueStatusLabel.setText("Invalid input.");
            issueStatusLabel.setForeground(Color.red);
        } else {
            try {
                // StateManager.addIssueBook(id, book, amount);

                DatabaseConnection con = new DatabaseConnection();

                ResultSet rsltSet = con.executeQuery("Select id from students where name = ?", s_name);
                rsltSet.next();

                int s_id = StateManager.role.equals("student") ? Integer.parseInt(StateManager.loginId) : rsltSet.getInt("id");

                con.execute("INSERT INTO borrowed_books(book_id, student_id, amount, borrowed_at) VALUES (?, ?, ?, ?)", bookId, s_id, amountNum, date);
                
                // It's done in the database side using trigger
                // con.execute("UPDATE books SET stock = stock-1 WHERE id = ?", bookId);

                selectBookComboBox.setSelectedIndex(0);
                inputAmount.setText("0");
                issueStatusLabel.setText("Book issued successfully .");
                issueStatusLabel.setForeground(Color.white);
            } catch (SQLException ex) {
                Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnEnterActionPerformed

    private void selectBookComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectBookComboBoxActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_selectBookComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton exit;
    private javax.swing.JTextField inputAmount;
    private javax.swing.JLabel issueDateLabel;
    private javax.swing.JTextField issueDateTextField;
    private javax.swing.JLabel issueStatusLabel;
    private javax.swing.JPanel isuueStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox<String> selectBookComboBox;
    private javax.swing.JComboBox<String> studentComboBox;
    private javax.swing.JLabel studentLabel;
    // End of variables declaration//GEN-END:variables
}
