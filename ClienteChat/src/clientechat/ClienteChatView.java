/*
 * ClienteChatView.java
 */
package clientechat;

import es.random.java.chat.Mensaje;
import es.random.java.chat.Mensaje.Tipo;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Point;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.Position;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

/**
 * The application's main frame.
 */
public class ClienteChatView extends FrameView {

    private String usuario = System.getProperty("user.name");
    private boolean conectado = false;
    private ObjectInputStream lector;
    private ObjectOutputStream escritor;
    private Socket puerto;

    public ClienteChatView(SingleFrameApplication app) {
        super(app);

        initComponents();
        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {

            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String) (evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer) (evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });

    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = ClienteChatApp.getApplication().getMainFrame();
            aboutBox = new ClienteChatAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        ClienteChatApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        panelInferior = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        panelSuperior = new javax.swing.JSplitPane();
        panelUsuarios = new javax.swing.JScrollPane();
        arbolUsuarios = new javax.swing.JTree();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTextoMensajes = new javax.swing.JEditorPane();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu menuArchivo = new javax.swing.JMenu();
        javax.swing.JMenuItem elementoMenuSalir = new javax.swing.JMenuItem();
        elementoMenuConectar = new javax.swing.JMenuItem();
        elementoMenuDesconectar = new javax.swing.JMenuItem();
        javax.swing.JMenu menuAyuda = new javax.swing.JMenu();
        javax.swing.JMenuItem elementoMenuAcercaDe = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        menuUsuariosConectados = new javax.swing.JPopupMenu();
        opcionEnviarPrivado = new javax.swing.JMenuItem();
        dialogPrivado = new javax.swing.JDialog();
        jSplitPane1 = new javax.swing.JSplitPane();
        jSplitPane3 = new javax.swing.JSplitPane();
        labelDestinatario = new javax.swing.JLabel();
        inputMensaje = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        botonEnviar = new javax.swing.JButton();

        mainPanel.setName("mainPanel"); // NOI18N

        jSplitPane2.setDividerLocation(300);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane2.setName("jSplitPane2"); // NOI18N

        panelInferior.setMaximumSize(new java.awt.Dimension(32767, 30));
        panelInferior.setMinimumSize(new java.awt.Dimension(0, 30));
        panelInferior.setName("panelInferior"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(clientechat.ClienteChatApp.class).getContext().getResourceMap(ClienteChatView.class);
        jTextField1.setText(resourceMap.getString("jTextField1.text")); // NOI18N
        jTextField1.setName("jTextField1"); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
            .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
            .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
        );

        jSplitPane2.setRightComponent(panelInferior);

        panelSuperior.setName("panelSuperior"); // NOI18N

        panelUsuarios.setName("panelUsuarios"); // NOI18N

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Usuarios conectados");
        arbolUsuarios.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        arbolUsuarios.setName("arbolUsuarios"); // NOI18N
        arbolUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                arbolUsuariosMouseReleased(evt);
            }
        });
        panelUsuarios.setViewportView(arbolUsuarios);

        panelSuperior.setLeftComponent(panelUsuarios);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        areaTextoMensajes.setContentType(resourceMap.getString("areaTextoMensajes.contentType")); // NOI18N
        areaTextoMensajes.setText(resourceMap.getString("areaTextoMensajes.text")); // NOI18N
        areaTextoMensajes.setName("areaTextoMensajes"); // NOI18N
        jScrollPane1.setViewportView(areaTextoMensajes);

        panelSuperior.setRightComponent(jScrollPane1);

        jSplitPane2.setLeftComponent(panelSuperior);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
        );

        menuBar.setName("menuBar"); // NOI18N

        menuArchivo.setText(resourceMap.getString("menuArchivo.text")); // NOI18N
        menuArchivo.setName("menuArchivo"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(clientechat.ClienteChatApp.class).getContext().getActionMap(ClienteChatView.class, this);
        elementoMenuSalir.setAction(actionMap.get("quit")); // NOI18N
        elementoMenuSalir.setText(resourceMap.getString("elementoMenuSalir.text")); // NOI18N
        elementoMenuSalir.setName("elementoMenuSalir"); // NOI18N
        menuArchivo.add(elementoMenuSalir);

        elementoMenuConectar.setText(resourceMap.getString("elementoMenuConectar.text")); // NOI18N
        elementoMenuConectar.setName("elementoMenuConectar"); // NOI18N
        elementoMenuConectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                elementoMenuConectarMouseReleased(evt);
            }
        });
        menuArchivo.add(elementoMenuConectar);

        elementoMenuDesconectar.setText(resourceMap.getString("elementoMenuDesconectar.text")); // NOI18N
        elementoMenuDesconectar.setName("elementoMenuDesconectar"); // NOI18N
        elementoMenuDesconectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                elementoMenuDesconectarMouseReleased(evt);
            }
        });
        menuArchivo.add(elementoMenuDesconectar);

        menuBar.add(menuArchivo);

        menuAyuda.setText(resourceMap.getString("menuAyuda.text")); // NOI18N
        menuAyuda.setName("menuAyuda"); // NOI18N

        elementoMenuAcercaDe.setAction(actionMap.get("showAboutBox")); // NOI18N
        elementoMenuAcercaDe.setText(resourceMap.getString("elementoMenuAcercaDe.text")); // NOI18N
        elementoMenuAcercaDe.setName("elementoMenuAcercaDe"); // NOI18N
        menuAyuda.add(elementoMenuAcercaDe);

        menuBar.add(menuAyuda);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        menuUsuariosConectados.setName("menuUsuariosConectados"); // NOI18N

        opcionEnviarPrivado.setLabel(resourceMap.getString("opcionEnviarPrivado.label")); // NOI18N
        opcionEnviarPrivado.setName("opcionEnviarPrivado"); // NOI18N
        opcionEnviarPrivado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                opcionEnviarPrivadoMouseReleased(evt);
            }
        });
        menuUsuariosConectados.add(opcionEnviarPrivado);

        dialogPrivado.setName("dialogPrivado"); // NOI18N

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setName("jSplitPane1"); // NOI18N

        jSplitPane3.setName("jSplitPane3"); // NOI18N

        labelDestinatario.setText(resourceMap.getString("labelDestinatario.text")); // NOI18N
        labelDestinatario.setName("labelDestinatario"); // NOI18N
        jSplitPane3.setLeftComponent(labelDestinatario);

        inputMensaje.setText(resourceMap.getString("inputMensaje.text")); // NOI18N
        inputMensaje.setName("inputMensaje"); // NOI18N
        jSplitPane3.setRightComponent(inputMensaje);

        jSplitPane1.setLeftComponent(jSplitPane3);

        jPanel1.setName("jPanel1"); // NOI18N

        botonEnviar.setText(resourceMap.getString("botonEnviar.text")); // NOI18N
        botonEnviar.setName("botonEnviar"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addComponent(botonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonEnviar)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanel1);

        javax.swing.GroupLayout dialogPrivadoLayout = new javax.swing.GroupLayout(dialogPrivado.getContentPane());
        dialogPrivado.getContentPane().setLayout(dialogPrivadoLayout);
        dialogPrivadoLayout.setHorizontalGroup(
            dialogPrivadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(dialogPrivadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dialogPrivadoLayout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(77, Short.MAX_VALUE)))
        );
        dialogPrivadoLayout.setVerticalGroup(
            dialogPrivadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(dialogPrivadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dialogPrivadoLayout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(133, Short.MAX_VALUE)))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextField1KeyReleased
    {//GEN-HEADEREND:event_jTextField1KeyReleased
        if (conectado) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                Mensaje nuevoMensaje = new Mensaje(usuario, this.jTextField1.getText(), Tipo.Mensaje);
                try {
                    escritor.writeObject(nuevoMensaje);
                    escritor.flush();
                    jTextField1.setText("");
                    jTextField1.requestFocus();
                } catch (IOException ex) {
                    Logger.getLogger(ClienteChatView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            areaTextoMensajes.setText(mensajesAñadeMensajeEnHtml( "No está conectado al servidor...\r\n",Tipo.Salir));


        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private String mensajesAñadeMensajeEnHtml(String mensaje, Tipo tipo) {
        if((tipo == Tipo.Acceder) || (tipo == Tipo.UsuarioEntra)) {
            mensaje = "<font color=\"green\">" + mensaje + "</font>";
        } else if( (tipo == Tipo.MensajePrivado) ) {
            mensaje = "<i><font color=\"blue\">" + mensaje + "</font></i>";
        } else if( (tipo == Tipo.Salir) || (tipo == Tipo.UsuarioSale) ) {
            mensaje = "<font color=\"red\">" + mensaje + "</font>";
        }
        return areaTextoMensajes.getText().replace("</body>", mensaje + "<br/></body>");
    }

    private void elementoMenuConectarMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_elementoMenuConectarMouseReleased
    {//GEN-HEADEREND:event_elementoMenuConectarMouseReleased
        try {
            puerto = new Socket("localhost", 4321);
            lector = new ObjectInputStream(puerto.getInputStream());
            escritor = new ObjectOutputStream(puerto.getOutputStream());
            Oyente miOyente = new Oyente(lector);
            miOyente.start();
            escritor.writeObject(new Mensaje(usuario, "", Tipo.Acceder));
            escritor.flush();
            conectado = true;
            
        } catch (IOException ex) {
            Logger.getLogger(ClienteChatView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_elementoMenuConectarMouseReleased

    private void elementoMenuDesconectarMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_elementoMenuDesconectarMouseReleased
    {//GEN-HEADEREND:event_elementoMenuDesconectarMouseReleased
        try {
            escritor.writeObject(new Mensaje(usuario, "", Tipo.Salir));

            EventQueue.invokeLater(new Runnable() {

                public void run() {
                    DefaultMutableTreeNode top = (DefaultMutableTreeNode) arbolUsuarios.getModel().getRoot();
                    top.removeAllChildren();

                    DefaultTreeModel modelo = ((DefaultTreeModel) arbolUsuarios.getModel());
                    modelo.nodeStructureChanged(top);
                    arbolUsuarios.validate();

                    mensajeRecibido("","Desconectado del servidor", Tipo.Salir);

                }
            });
        } catch (IOException ex) {
            Logger.getLogger(ClienteChatView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_elementoMenuDesconectarMouseReleased

    private void opcionEnviarPrivadoMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_opcionEnviarPrivadoMouseReleased
    {//GEN-HEADEREND:event_opcionEnviarPrivadoMouseReleased
        final DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) (arbolUsuarios.getSelectionPath().getLastPathComponent());

        if(nodo != null) {
            String mPrivado = JOptionPane.showInputDialog(mainPanel, "Para " + nodo + ":");

            if(! mPrivado.equals(null)) {
                try {
                    escritor.writeObject(new Mensaje(nodo.toString(), "Privado de " + usuario + ":: " + mPrivado, Tipo.MensajePrivado));
                } catch (IOException ex) {
                    Logger.getLogger(ClienteChatView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //arbolUsuarios.getRowForLocation();

        //Point punto = opcionEnviarPrivado.getPopupLocation(evt);

    }//GEN-LAST:event_opcionEnviarPrivadoMouseReleased

    private void arbolUsuariosMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_arbolUsuariosMouseReleased
    {//GEN-HEADEREND:event_arbolUsuariosMouseReleased
         Point p = evt.getPoint();

        TreePath path = arbolUsuarios.getClosestPathForLocation(p.x, p.y);
        if(path != null) {
            // Nos aseguremos de que quede seleccionado el usuario sobre el que estamos
            arbolUsuarios.setSelectionPath(path);
            //DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) (path.getLastPathComponent());

            // Mostramos el menu contextual
            menuUsuariosConectados.show(arbolUsuarios, p.x, p.y);
        }

    }//GEN-LAST:event_arbolUsuariosMouseReleased

    public void mensajeRecibido(String nombre, String mensaje, Tipo tipo) {
        mensajeRecibido( new Mensaje(nombre,mensaje,tipo) );
    }

    public void mensajeRecibido(Mensaje mensaje) {

        final String nombre = mensaje.getUsuario();
        final String contenido = mensaje.getContenido();
        final Tipo tipo = mensaje.getTipo();

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                //areaTextoMensajes.append("<html><b>" + nombre + ":</b> " + contenido + "\r\n");
                areaTextoMensajes.setText(mensajesAñadeMensajeEnHtml("<b>" + nombre + ":</b> " + contenido, tipo));
                if (tipo == Tipo.UsuarioEntra) {
                    DefaultMutableTreeNode top = (DefaultMutableTreeNode) arbolUsuarios.getModel().getRoot();
                    DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(nombre);
                    nodo.setAllowsChildren(false);
                    top.add(nodo);


                    // Indicamos que ha habido cambios en el arbol para que se entere
                    ((DefaultTreeModel) arbolUsuarios.getModel()).nodeStructureChanged(top);

                    // Abrimos el arbol para que se vea bien que ha entrado un usuario
                    TreePath tp = new TreePath(top.getPath());
                    arbolUsuarios.expandPath(tp);

                    arbolUsuarios.validate();
                } else if (tipo == Tipo.UsuarioSale) {
                    DefaultMutableTreeNode top = (DefaultMutableTreeNode) arbolUsuarios.getModel().getRoot();
                    TreePath path = arbolUsuarios.getNextMatch(nombre, 0, Position.Bias.Forward);
                    MutableTreeNode node = (MutableTreeNode) path.getLastPathComponent();
                    // arbolUsuarios
                    DefaultTreeModel modelo = ((DefaultTreeModel) arbolUsuarios.getModel());
                    modelo.removeNodeFromParent(node);
                    modelo.nodeStructureChanged(top);
                    arbolUsuarios.validate();

//                                    arbolUsuarios.remove(menuBar);
                }

            }
        });
    }

    class Oyente extends Thread {

        ObjectInputStream lector;

        public Oyente(ObjectInputStream lector) {
            this.lector = lector;
        }

        public void run() {
            Mensaje m = null;
            do {
                try {
                    m = (Mensaje) lector.readObject();
                } catch (IOException ex) {
                    Logger.getLogger(ClienteChatView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ClienteChatView.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (m != null) {
                    mensajeRecibido(m);


                }
            } while (m.getTipo() != Tipo.Salir);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbolUsuarios;
    private javax.swing.JEditorPane areaTextoMensajes;
    private javax.swing.JButton botonEnviar;
    private javax.swing.JDialog dialogPrivado;
    private javax.swing.JMenuItem elementoMenuConectar;
    private javax.swing.JMenuItem elementoMenuDesconectar;
    private javax.swing.JTextField inputMensaje;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelDestinatario;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPopupMenu menuUsuariosConectados;
    private javax.swing.JMenuItem opcionEnviarPrivado;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JSplitPane panelSuperior;
    private javax.swing.JScrollPane panelUsuarios;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables
    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;
    private JDialog aboutBox;
}
