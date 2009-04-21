/*
 * ClienteChatView.java
 */
package clientechat;

import es.random.java.chat.Mensaje;
import es.random.java.chat.Mensaje.Tipo;
import java.awt.EventQueue;
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

/**
 * The application's main frame.
 */
public class ClienteChatView extends FrameView
{

    private String usuario = System.getProperty("user.name");
    private boolean conectado = false;
    private ObjectInputStream lector;
    private ObjectOutputStream escritor;
    private Socket puerto;

    public ClienteChatView(SingleFrameApplication app)
    {
        super(app);

        initComponents();
        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++)
        {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener()
        {

            public void propertyChange(java.beans.PropertyChangeEvent evt)
            {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName))
                {
                    if (!busyIconTimer.isRunning())
                    {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName))
                {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName))
                {
                    String text = (String) (evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName))
                {
                    int value = (Integer) (evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });

    }

    @Action
    public void showAboutBox()
    {
        if (aboutBox == null)
        {
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
        areaTextoMensajes = new javax.swing.JTextArea();
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

        arbolUsuarios.setName("arbolUsuarios"); // NOI18N
        panelUsuarios.setViewportView(arbolUsuarios);

        panelSuperior.setLeftComponent(panelUsuarios);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        areaTextoMensajes.setColumns(20);
        areaTextoMensajes.setRows(5);
        areaTextoMensajes.setName("areaTextoMensajes"); // NOI18N
        jScrollPane1.setViewportView(areaTextoMensajes);

        panelSuperior.setRightComponent(jScrollPane1);

        jSplitPane2.setLeftComponent(panelSuperior);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
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

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextField1KeyReleased
    {//GEN-HEADEREND:event_jTextField1KeyReleased
        if (conectado)
        {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            {
                Mensaje nuevoMensaje = new Mensaje(usuario, this.jTextField1.getText(), Tipo.Mensaje);
                try
                {
                    escritor.writeObject(nuevoMensaje);
                    escritor.flush();
                    jTextField1.setText("");
                    jTextField1.requestFocus();
                } catch (IOException ex)
                {
                    Logger.getLogger(ClienteChatView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else
        {
            areaTextoMensajes.append("No está conectado al servidor...\r\n");
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void elementoMenuConectarMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_elementoMenuConectarMouseReleased
    {//GEN-HEADEREND:event_elementoMenuConectarMouseReleased
        try
        {
            puerto = new Socket("localhost", 4321);
            lector = new ObjectInputStream(puerto.getInputStream());
            escritor = new ObjectOutputStream(puerto.getOutputStream());
            Oyente miOyente = new Oyente(lector);
            miOyente.start();
            escritor.writeObject(new Mensaje(usuario, "", Tipo.Acceder));
            escritor.flush();
            conectado = true;
        } catch (IOException ex)
        {
            Logger.getLogger(ClienteChatView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_elementoMenuConectarMouseReleased

    class Oyente extends Thread
    {

        ObjectInputStream lector;

        public Oyente(ObjectInputStream lector)
        {
            this.lector = lector;
        }

        public void run()
        {
            Mensaje m = null;
            do
            {
                try
                {
                    m = (Mensaje) lector.readObject();
                } catch (IOException ex)
                {
                    Logger.getLogger(ClienteChatView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex)
                {
                    Logger.getLogger(ClienteChatView.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (m != null)
                {
                    if (m.getTipo() != Tipo.Salir)
                    {
                        final String nombre = m.getUsuario();
                        final String contenido = m.getContenido();
                        EventQueue.invokeLater(new Runnable()
                        {

                            public void run()
                            {
                                areaTextoMensajes.append(nombre + ": " + contenido + "\r\n");
                            }
                        });

                    }
                }
            } while (m.getTipo() != Tipo.Salir);
        }

}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbolUsuarios;
    private javax.swing.JTextArea areaTextoMensajes;
    private javax.swing.JMenuItem elementoMenuConectar;
    private javax.swing.JMenuItem elementoMenuDesconectar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
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

private final Icon[]

busyIcons = new Icon[15];
    private int

busyIconIndex = 0;

    private JDialog aboutBox;

}
