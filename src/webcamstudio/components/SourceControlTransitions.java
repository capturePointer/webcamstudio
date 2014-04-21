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

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import webcamstudio.channels.MasterChannels;
import webcamstudio.channels.transitions.Transition;
import webcamstudio.streams.SourceChannel;
import webcamstudio.streams.Stream;

/**
 *
 * @author patrick
 */
public class SourceControlTransitions extends javax.swing.JPanel {
    Stream source = null;
    ArrayList<Stream> streamS = MasterChannels.getInstance().getStreams();
    /** Creates new form SourceControlTransitions
     * @param source */
    @SuppressWarnings("unchecked") 
    public SourceControlTransitions(Stream source) {
        initComponents();
        this.source=source;
        
        DefaultListModel start = new DefaultListModel();
        for (String s : Transition.getStartTransitions()){
            start.addElement(s);
        }
        DefaultListModel end = new DefaultListModel();
        for (String s : Transition.getEndTransitions()){
            end.addElement(s);
        }
        lstStartTransitions.setModel(start);
        lstEndTransitions.setModel(end);
        
        for (Transition t : source.getStartTransitions()){
            lstStartTransitions.setSelectedValue(t.getClass().getSimpleName(), true);
        }
        for (Transition t : source.getEndTransitions()){
            lstEndTransitions.setSelectedValue(t.getClass().getSimpleName(), true);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstStartTransitions = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnApplyTransToAll = new javax.swing.JButton();
        btnResetTrans = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jScrollPane2 = new javax.swing.JScrollPane();
        lstEndTransitions = new javax.swing.JList();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio/Languages"); // NOI18N
        setName(bundle.getString("TRANSITIONS")); // NOI18N
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("STARTING"))); // NOI18N
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        lstStartTransitions.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstStartTransitions.setName("lstStartTransitions"); // NOI18N
        lstStartTransitions.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstStartTransitionsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstStartTransitions);

        add(jScrollPane1);
        jScrollPane1.getAccessibleContext().setAccessibleName(bundle.getString("STARTING")); // NOI18N

        jPanel1.setMinimumSize(new java.awt.Dimension(28, 28));
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(28, 28));
        jPanel1.setLayout(new java.awt.GridLayout(4, 0));

        filler1.setName("filler1"); // NOI18N
        jPanel1.add(filler1);

        btnApplyTransToAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/view-refresh.png"))); // NOI18N
        btnApplyTransToAll.setToolTipText("Apply Selected Transition To all Channels");
        btnApplyTransToAll.setMaximumSize(new java.awt.Dimension(28, 28));
        btnApplyTransToAll.setMinimumSize(new java.awt.Dimension(28, 28));
        btnApplyTransToAll.setName("btnApplyTransToAll"); // NOI18N
        btnApplyTransToAll.setPreferredSize(new java.awt.Dimension(28, 28));
        btnApplyTransToAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyTransToAllActionPerformed(evt);
            }
        });
        jPanel1.add(btnApplyTransToAll);

        btnResetTrans.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/button-small-clear.png"))); // NOI18N
        btnResetTrans.setToolTipText("Clear Selections");
        btnResetTrans.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnResetTrans.setMaximumSize(new java.awt.Dimension(28, 28));
        btnResetTrans.setMinimumSize(new java.awt.Dimension(28, 28));
        btnResetTrans.setName("btnResetTrans"); // NOI18N
        btnResetTrans.setPreferredSize(new java.awt.Dimension(28, 28));
        btnResetTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetTransActionPerformed(evt);
            }
        });
        jPanel1.add(btnResetTrans);

        filler3.setName("filler3"); // NOI18N
        jPanel1.add(filler3);

        add(jPanel1);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("ENDING"))); // NOI18N
        jScrollPane2.setName("jScrollPane2"); // NOI18N

        lstEndTransitions.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstEndTransitions.setName("lstEndTransitions"); // NOI18N
        lstEndTransitions.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstEndTransitionsValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstEndTransitions);

        add(jScrollPane2);
        jScrollPane2.getAccessibleContext().setAccessibleName(bundle.getString("ENDING")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents
    @SuppressWarnings("deprecation")
    private void lstStartTransitionsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstStartTransitionsValueChanged
        Object[] list = lstStartTransitions.getSelectedValues();
        source.getStartTransitions().clear();
        for (Object t : list){
            source.addStartTransition(Transition.getInstance(source, t.toString()));
        }
    }//GEN-LAST:event_lstStartTransitionsValueChanged
    @SuppressWarnings("deprecation")
    private void lstEndTransitionsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstEndTransitionsValueChanged
        Object[] list = lstEndTransitions.getSelectedValues();
        source.getEndTransitions().clear();
        for (Object t : list){
            source.addEndTransition(Transition.getInstance(source, t.toString()));
        }        
    }//GEN-LAST:event_lstEndTransitionsValueChanged

    private void btnResetTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetTransActionPerformed
        source.getStartTransitions().clear();
        source.getEndTransitions().clear();
        lstEndTransitions.clearSelection();
        lstStartTransitions.clearSelection();
    }//GEN-LAST:event_btnResetTransActionPerformed
    @SuppressWarnings("deprecation")
    private void btnApplyTransToAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyTransToAllActionPerformed
        for (Stream s : streamS){
            Object[] sList = lstStartTransitions.getSelectedValues();
            s.getStartTransitions().clear();
            for (SourceChannel sc : s.getChannels()){
                    sc.startTransitions.clear();
                }
            for (Object t : sList){
                Transition sT = Transition.getInstance(s, t.toString());
                s.addStartTransition(sT);
                for (SourceChannel sc : s.getChannels()){
                    sc.startTransitions.add(sT);
                }
            }
            Object[] eList = lstEndTransitions.getSelectedValues();
            s.getEndTransitions().clear();
            for (SourceChannel sc : s.getChannels()){
                    sc.endTransitions.clear();
                }
            for (Object t : eList){
                Transition eT = Transition.getInstance(s, t.toString());
                s.addEndTransition(eT);
                for (SourceChannel sc : s.getChannels()){
                    sc.endTransitions.add(eT);
                }
            }
        }
        ResourceMonitorLabel label = new ResourceMonitorLabel(System.currentTimeMillis()+10000, "Selected Transitions Applied to All Channels");
        ResourceMonitor.getInstance().addMessage(label);
    }//GEN-LAST:event_btnApplyTransToAllActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApplyTransToAll;
    private javax.swing.JButton btnResetTrans;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lstEndTransitions;
    private javax.swing.JList lstStartTransitions;
    // End of variables declaration//GEN-END:variables
}
