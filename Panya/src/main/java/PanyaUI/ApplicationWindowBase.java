/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PanyaUI;
/**
 *
 * @author dqh
 */
public class ApplicationWindowBase extends javax.swing.JFrame {
    /**
     *
     */
    private static final long serialVersionUID = -9159851544442388312L;

    /** Creates new form ApplicationWindowBase */
    public ApplicationWindowBase() {
        initComponents();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        menuPanel = new javax.swing.JPanel();
        imagePanel = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        titlePanel = new javax.swing.JPanel();
        menuIconLabel = new javax.swing.JLabel();
        menuListPanel = new javax.swing.JPanel();
        recipeLabel = new javax.swing.JLabel();
        storageLabel = new javax.swing.JLabel();
        manageLabel = new javax.swing.JLabel();
        homeLabel = new javax.swing.JLabel();
        topHeaderPanel = new javax.swing.JPanel();
        topHeaderLabel = new javax.swing.JLabel();
        menuIconLabel2 = new javax.swing.JLabel();
        outerContentPanel = new javax.swing.JPanel();
        contentHeaderPanel = new javax.swing.JPanel();
        contentHeaderLabel = new javax.swing.JLabel();
        bottomHeaderPanel = new javax.swing.JPanel();
        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.white);
        setMinimumSize(new java.awt.Dimension(900, 600));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        menuPanel.setMinimumSize(new java.awt.Dimension(300, 600));
        menuPanel.setName(""); // NOI18N
        menuPanel.setPreferredSize(new java.awt.Dimension(300, 600));
        menuPanel.setLayout(new java.awt.GridBagLayout());

        imagePanel.setBackground(new java.awt.Color(33, 150, 243));
        imagePanel.setMinimumSize(new java.awt.Dimension(300, 150));
        imagePanel.setPreferredSize(new java.awt.Dimension(300, 150));

        imageLabel.setText("image");

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
                imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(imageLabel,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE));
        imagePanelLayout.setVerticalGroup(
                imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(imageLabel,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(imagePanel, gridBagConstraints);

        titlePanel.setBackground(new java.awt.Color(0, 105, 192));
        titlePanel.setMinimumSize(new java.awt.Dimension(300, 50));
        titlePanel.setPreferredSize(new java.awt.Dimension(300, 50));
        titlePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuIconLabel.setForeground(java.awt.Color.white);
        menuIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/twotone_menu_white_18dp.png"))); // NOI18N
        titlePanel.add(menuIconLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, -1, 50));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        menuPanel.add(titlePanel, gridBagConstraints);

        menuListPanel.setBackground(new java.awt.Color(110, 198, 255));
        menuListPanel.setMinimumSize(new java.awt.Dimension(300, 400));
        menuListPanel.setPreferredSize(new java.awt.Dimension(300, 400));
        menuListPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        recipeLabel.setFont(new java.awt.Font("Noto Sans", 0, 17)); // NOI18N
        recipeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        recipeLabel.setText("RECIPE");
        recipeLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuListPanel.add(recipeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 300, 70));

        storageLabel.setBackground(new java.awt.Color(33, 150, 243));
        storageLabel.setFont(new java.awt.Font("Noto Sans", 1, 17)); // NOI18N
        storageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        storageLabel.setText("STORAGE");
        storageLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        storageLabel.setOpaque(true);
        menuListPanel.add(storageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 300, 70));

        manageLabel.setBackground(new java.awt.Color(33, 150, 243));
        manageLabel.setFont(new java.awt.Font("Noto Sans", 0, 17)); // NOI18N
        manageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        manageLabel.setText("MANAGE");
        manageLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        manageLabel.setOpaque(true);
        menuListPanel.add(manageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 300, 70));

        homeLabel.setFont(new java.awt.Font("Noto Sans", 0, 17)); // NOI18N
        homeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homeLabel.setText("HOME");
        homeLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuListPanel.add(homeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 70));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        menuPanel.add(menuListPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(menuPanel, gridBagConstraints);

        topHeaderPanel.setBackground(new java.awt.Color(0, 105, 192));
        topHeaderPanel.setMinimumSize(new java.awt.Dimension(600, 50));
        topHeaderPanel.setPreferredSize(new java.awt.Dimension(600, 50));
        topHeaderPanel.setLayout(new java.awt.GridBagLayout());

        topHeaderLabel.setFont(topHeaderLabel.getFont());
        topHeaderLabel.setForeground(java.awt.Color.white);
        topHeaderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        topHeaderLabel.setText("Title");
        topHeaderLabel.setMaximumSize(new java.awt.Dimension(32767, 32767));
        topHeaderLabel.setMinimumSize(new java.awt.Dimension(564, 50));
        topHeaderLabel.setPreferredSize(new java.awt.Dimension(564, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.1;
        topHeaderPanel.add(topHeaderLabel, gridBagConstraints);

        menuIconLabel2
                .setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/twotone_menu_white_18dp.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        topHeaderPanel.add(menuIconLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(topHeaderPanel, gridBagConstraints);

        outerContentPanel.setMinimumSize(new java.awt.Dimension(600, 600));
        outerContentPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        outerContentPanel.setLayout(new java.awt.GridBagLayout());

        contentHeaderPanel.setBackground(new java.awt.Color(33, 150, 243));
        contentHeaderPanel.setMinimumSize(new java.awt.Dimension(600, 100));
        contentHeaderPanel.setPreferredSize(new java.awt.Dimension(600, 100));

        contentHeaderLabel.setText("Function description");

        javax.swing.GroupLayout contentHeaderPanelLayout = new javax.swing.GroupLayout(contentHeaderPanel);
        contentHeaderPanel.setLayout(contentHeaderPanelLayout);
        contentHeaderPanelLayout.setHorizontalGroup(
                contentHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(contentHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE));
        contentHeaderPanelLayout.setVerticalGroup(
                contentHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(contentHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        outerContentPanel.add(contentHeaderPanel, gridBagConstraints);

        bottomHeaderPanel.setBackground(new java.awt.Color(110, 198, 255));
        bottomHeaderPanel.setMinimumSize(new java.awt.Dimension(600, 50));
        bottomHeaderPanel.setPreferredSize(new java.awt.Dimension(600, 50));

        javax.swing.GroupLayout bottomHeaderPanelLayout = new javax.swing.GroupLayout(bottomHeaderPanel);
        bottomHeaderPanel.setLayout(bottomHeaderPanelLayout);
        bottomHeaderPanelLayout.setHorizontalGroup(bottomHeaderPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 600, Short.MAX_VALUE));
        bottomHeaderPanelLayout.setVerticalGroup(bottomHeaderPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 50, Short.MAX_VALUE));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        outerContentPanel.add(bottomHeaderPanel, gridBagConstraints);

        contentPanel.setBackground(java.awt.Color.white);
        contentPanel.setMinimumSize(new java.awt.Dimension(600, 400));
        contentPanel.setPreferredSize(new java.awt.Dimension(600, 400));

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(contentPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 600, Short.MAX_VALUE));
        contentPanelLayout.setVerticalGroup(contentPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 450, Short.MAX_VALUE));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        outerContentPanel.add(contentPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(outerContentPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ApplicationWindowBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApplicationWindowBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApplicationWindowBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApplicationWindowBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApplicationWindowBase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JPanel bottomHeaderPanel;
    javax.swing.JLabel contentHeaderLabel;
    javax.swing.JPanel contentHeaderPanel;
    javax.swing.JPanel contentPanel;
    javax.swing.JLabel homeLabel;
    javax.swing.JLabel imageLabel;
    javax.swing.JPanel imagePanel;
    javax.swing.JLabel manageLabel;
    javax.swing.JLabel menuIconLabel;
    javax.swing.JLabel menuIconLabel2;
    javax.swing.JPanel menuListPanel;
    javax.swing.JPanel menuPanel;
    javax.swing.JPanel outerContentPanel;
    javax.swing.JLabel recipeLabel;
    javax.swing.JLabel storageLabel;
    javax.swing.JPanel titlePanel;
    javax.swing.JLabel topHeaderLabel;
    javax.swing.JPanel topHeaderPanel;
    // End of variables declaration//GEN-END:variables

}
