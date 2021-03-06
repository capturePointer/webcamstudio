/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SourceControlTransitions.java
 *
 * Created on 23-Apr-2012, 11:28:40 AM
 */
package webcamstudio.components;

import webcamstudio.streams.SourceChannel;
import webcamstudio.streams.Stream;

/**
 *
 * @author patrick
 */
public class SourceControlChannels extends javax.swing.JPanel {
    Stream source = null;
    /** Creates new form SourceControlTransitions
     * @param source */
    @SuppressWarnings("unchecked") 
    public SourceControlChannels(Stream source) {
        initComponents();
        this.source=source;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnApplyAllCh = new javax.swing.JButton();
        btnApplyAllChSet = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnApplyAllChPos = new javax.swing.JButton();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio/Languages"); // NOI18N
        setName(bundle.getString("CHANNELS_CTRL")); // NOI18N
        setPreferredSize(new java.awt.Dimension(400, 112));
        setLayout(new java.awt.CardLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setName("jPanel1"); // NOI18N

        btnApplyAllCh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/chan-app4.png"))); // NOI18N
        btnApplyAllCh.setText("Copy State & Settings");
        btnApplyAllCh.setToolTipText("Apply Current Stream Playing State , Settings & Content to all Channels.");
        btnApplyAllCh.setName("btnApplyAllCh"); // NOI18N
        btnApplyAllCh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyAllChActionPerformed(evt);
            }
        });

        btnApplyAllChSet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/chan-app3.png"))); // NOI18N
        btnApplyAllChSet.setText("Copy Only Settings");
        btnApplyAllChSet.setToolTipText("Apply Current Stream Settings & Content except the Playing State to all Channels.");
        btnApplyAllChSet.setName("btnApplyAllChSet"); // NOI18N
        btnApplyAllChSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyAllChSetActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Copy Current Stream Settings in All Channels");
        jLabel1.setName("jLabel1"); // NOI18N

        btnApplyAllChPos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/chan-app5.png"))); // NOI18N
        btnApplyAllChPos.setText("Copy Only Style & Position");
        btnApplyAllChPos.setToolTipText("Apply Current Stream Settings except the Text Content & Playing State to all Channels.");
        btnApplyAllChPos.setName("btnApplyAllChPos"); // NOI18N
        btnApplyAllChPos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyAllChPosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnApplyAllCh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnApplyAllChSet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnApplyAllChPos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnApplyAllCh, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnApplyAllChSet, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnApplyAllChPos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnApplyAllChActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyAllChActionPerformed
        SourceChannel sch = null;
        for (int i=0; i < source.getChannels().size(); i++){
            String scName = source.getChannels().get(i).getName();
            sch=SourceChannel.getChannel(scName, source);
            source.removeChannelAt(i);
            source.addChannelAt(sch,i);
        }
        ResourceMonitorLabel label = new ResourceMonitorLabel(System.currentTimeMillis()+10000, source.getName() + " Playing State, Settings & Content Applied to all Channels.");
        ResourceMonitor.getInstance().addMessage(label);
    }//GEN-LAST:event_btnApplyAllChActionPerformed

    private void btnApplyAllChSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyAllChSetActionPerformed
        SourceChannel sch = null;
        String selChName = ChannelPanel.getSelectedChannel();
        for (int i=0; i < source.getChannels().size(); i++){
            String scName = source.getChannels().get(i).getName();
            boolean isPlay = source.getChannels().get(i).getIsPlaying();
            if (!selChName.equals(scName)) {
                sch=SourceChannel.getChannelIgnorePlay(scName, source);
                sch.setIsPlaying(isPlay);
                source.removeChannelAt(i);
                source.addChannelAt(sch,i);
            }
        }
        ResourceMonitorLabel label = new ResourceMonitorLabel(System.currentTimeMillis()+10000, source.getName() + " only Settings & Content Applied to all Channels.");
        ResourceMonitor.getInstance().addMessage(label);
    }//GEN-LAST:event_btnApplyAllChSetActionPerformed

    private void btnApplyAllChPosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyAllChPosActionPerformed
        SourceChannel sch = null;
        for (int i=0; i < source.getChannels().size(); i++){
            String scName = source.getChannels().get(i).getName();
            int oTime = source.getChannels().get(i).getDuration();
            String oCont = source.getChannels().get(i).getText();
            boolean isPlay = source.getChannels().get(i).getIsPlaying();
            sch=SourceChannel.getChannelIgnoreContent(scName, source);
            sch.setText(oCont);
            sch.setDuration(oTime);
            sch.setIsPlaying(isPlay);
            source.removeChannelAt(i);
            source.addChannelAt(sch,i);
        }
        ResourceMonitorLabel label = new ResourceMonitorLabel(System.currentTimeMillis()+10000, source.getName() + " only Settings Applied to all Channels.");
        ResourceMonitor.getInstance().addMessage(label);
    }//GEN-LAST:event_btnApplyAllChPosActionPerformed
    
    @SuppressWarnings("deprecation")     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApplyAllCh;
    private javax.swing.JButton btnApplyAllChPos;
    private javax.swing.JButton btnApplyAllChSet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
