package client;

import server.InterfaceServer;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;


public class ChatView extends javax.swing.JFrame implements Runnable{
    private ChatClient client;
    private InterfaceServer server;
    private DefaultListModel<String> model = new DefaultListModel<>();
    private Vector<String> listClients;
    private String name;
    private GroupLayout groupLayout;
    
    //constructeur
    public ChatView(String name,String autorization,InterfaceServer server) {
        initComponents();
        
        this.server = server;
        this.name = name;
        
        if(autorization.equals("Administrator")){
            System.out.print(autorization);
            listConnect1571020150.setComponentPopupMenu(jPopupMenu1);
        }
        
        this.setLocationRelativeTo(null);
        this.setTitle("Chat (" + name + ")");
        
        groupLayout = new GroupLayout(jPanel1571020150);
        jPanel1571020150.setLayout(new GridLayout(100,1));
        jPanel1571020150.setBorder(new EmptyBorder(5, 10, 10, 10));
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {    
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(new JFrame(), 
                    "Are you sure you want to close this chat ?", "Close chat?", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    try {
                        server.removeClient1571020150(name);
                    } catch (RemoteException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    System.exit(0);
                }else{
                   
                }
            }
        });
        
        inputMsg1571020150.setForeground(Color.GRAY);
        inputMsg1571020150.setText("Enter your Message ...");
        inputMsg1571020150.addFocusListener(new FocusListener() {
        @Override
         public void focusGained(FocusEvent e) {
            if (inputMsg1571020150.getText().equals("Enter your Message ...")) {
                inputMsg1571020150.setText("");
                inputMsg1571020150.setForeground(Color.BLACK);
            }
        }
        @Override
         public void focusLost(FocusEvent e) {
            if (inputMsg1571020150.getText().isEmpty()) {
                inputMsg1571020150.setForeground(Color.GRAY);
                inputMsg1571020150.setText("Enter your Message ...");
            }
        }
        });
        
        listClients = new Vector<>();
        listConnect1571020150.setListData(listClients);
        
        try{
            client = new ChatClient(name,server,inputMsg1571020150,listMessage1571020150,jPanel1571020150);
        } catch (RemoteException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
        Timer minuteur = new Timer();
        TimerTask tache = new TimerTask() {
            @Override
            public void run() {
                try {
                    int[] indices = listConnect1571020150.getSelectedIndices();
                    model.clear();
                    listClients = server.getListClientByName1571020150(name);
                    int i=0;
                    while(i<listClients.size()){
                        model.addElement(listClients.get(i));
                        i++;
                    }
                    listConnect1571020150.setModel(model);
                    listConnect1571020150.setSelectedIndices(indices);
                } catch (RemoteException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        };
        minuteur.schedule(tache,0,20000);
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        listConnect1571020150 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        inputMsg1571020150 = new javax.swing.JTextArea();
        btnSend1571020150 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listMessage1571020150 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScroll1571020150 = new javax.swing.JScrollPane();
        jPanel1571020150 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sendFile1571020150 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jMenuItem1.setText("Remove Users");
        jMenuItem1.setActionCommand("");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Block Users");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        jMenuItem3.setText("Reactive Users");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        listConnect1571020150.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        listConnect1571020150.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listConnect1571020150.setToolTipText("");
        jScrollPane1.setViewportView(listConnect1571020150);

        inputMsg1571020150.setColumns(20);
        inputMsg1571020150.setRows(5);
        inputMsg1571020150.setToolTipText("Enter your Message ...");
        inputMsg1571020150.setMargin(new java.awt.Insets(6, 0, 0, 16));
        jScrollPane2.setViewportView(inputMsg1571020150);
        inputMsg1571020150.getAccessibleContext().setAccessibleName("Enter your Message ...");

        btnSend1571020150.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSend1571020150.setText("Gửi");
        btnSend1571020150.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSend1571020150.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSend1571020150ActionPerformed(evt);
            }
        });

        listMessage1571020150.setEditable(false);
        listMessage1571020150.setColumns(20);
        listMessage1571020150.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        listMessage1571020150.setRows(5);
        listMessage1571020150.setRequestFocusEnabled(false);
        jScrollPane3.setViewportView(listMessage1571020150);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel2.setText("Clients đã kết nối");

        jPanel1571020150.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1571020150Layout = new javax.swing.GroupLayout(jPanel1571020150);
        jPanel1571020150.setLayout(jPanel1571020150Layout);
        jPanel1571020150Layout.setHorizontalGroup(
            jPanel1571020150Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1571020150Layout.setVerticalGroup(
            jPanel1571020150Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 113, Short.MAX_VALUE)
        );

        jScroll1571020150.setViewportView(jPanel1571020150);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("File đã gửi");

        sendFile1571020150.setText("Gửi file");
        sendFile1571020150.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendFile1571020150ActionPerformed(evt);
            }
        });

        jButton2.setText("Tạo nhóm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                            .addGap(57, 57, 57))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(12, 12, 12)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScroll1571020150)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
                        .addGap(39, 39, 39)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane1)
                    .addComponent(btnSend1571020150, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sendFile1571020150)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScroll1571020150, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(sendFile1571020150, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSend1571020150, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSend1571020150ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSend1571020150ActionPerformed
        if(!inputMsg1571020150.getText().equals("")){
            if(!inputMsg1571020150.getText().equals("Enter you Message ...")){
                client.sendMessage1571020150(listConnect1571020150.getSelectedValuesList());
                inputMsg1571020150.setText("");
            }else{
            JOptionPane.showMessageDialog(this,"Please insert something to set your message","Alert",JOptionPane.WARNING_MESSAGE);
        }
        }else{
            JOptionPane.showMessageDialog(this,"Please insert something to send your message","Alert",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSend1571020150ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            server.removeClient1571020150(listConnect1571020150.getSelectedValuesList());
        } catch (RemoteException ex) {
            System.out.println("Error: " + ex.getMessage());
        } 
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            server.blockClient1571020150(listConnect1571020150.getSelectedValuesList());
        } catch (RemoteException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    //action sur le popup menu "activer clients"
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            server.reactiveClient1571020150(listConnect1571020150.getSelectedValuesList());
        } catch (RemoteException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void sendFile1571020150ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendFile1571020150ActionPerformed
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            String[] extension = file.getName().split("\\.");
            System.out.println(extension.length);
            if(extension[extension.length - 1].equals("txt")||
                extension[extension.length - 1].equals("java")||
                extension[extension.length - 1].equals("php")||
                extension[extension.length - 1].equals("c")||
                extension[extension.length - 1].equals("cpp")||
                extension[extension.length - 1].equals("xml")||
                extension[extension.length - 1].equals("exe")||
                extension[extension.length - 1].equals("png")||
                extension[extension.length - 1].equals("jpg")||
                extension[extension.length - 1].equals("jpeg")||
                extension[extension.length - 1].equals("pdf")||
                extension[extension.length - 1].equals("jar")||
                extension[extension.length - 1].equals("rar")||
                extension[extension.length - 1].equals("zip")
            ){
                try {
                    ArrayList<Integer> inc;
                    try (FileInputStream in = new FileInputStream(file)) {
                        inc = new ArrayList<>();
                        int c=0;
                        while((c=in.read()) != -1) {
                            inc.add(c);
                        }
                        in.close();
                    }
                    server.broadcastMessage1571020150(inc, listClients,file.getName());
                } catch (FileNotFoundException ex) {
                    System.out.println("Error: " + ex.getMessage());
                } catch (RemoteException ex) {
                    System.out.println("Error: " + ex.getMessage());
                } catch (IOException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }

                JLabel jfile = new JLabel(file.getName() + " Uploaded ...");
                jPanel1571020150.add(jfile);
                jPanel1571020150.repaint();
                jPanel1571020150.revalidate();
            }else{
                JOptionPane.showMessageDialog(this,"You can only upload file have an extension like: xml,exe,jpg,png,jpeg,pdf,c,cpp,jar,java,txt,php ","Alert",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_sendFile1571020150ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend1571020150;
    private javax.swing.JTextArea inputMsg1571020150;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1571020150;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScroll1571020150;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listConnect1571020150;
    private javax.swing.JTextArea listMessage1571020150;
    private javax.swing.JButton sendFile1571020150;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {
            model.clear();
            listClients = server.getListClientByName1571020150(name);
            int i=0;
            while(i<listClients.size()){
                model.addElement(listClients.get(i));
                i++;
            }
            listConnect1571020150.setModel(model);
        } catch (RemoteException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}