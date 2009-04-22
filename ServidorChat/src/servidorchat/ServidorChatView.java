/*
 * ServidorChatView.java
 */
package servidorchat;

import es.random.java.chat.Mensaje;
import es.random.java.chat.Mensaje.Tipo;
import java.awt.EventQueue;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author: $Author$
 * @version: $Rev$
 * @date: $Date$
 * $Id$
 */
/**
 * The application's main frame.
 */
public class ServidorChatView extends FrameView
{

    private ArrayList<Usuario> lista;

    public ServidorChatView(SingleFrameApplication app)
    {
        super(app);

        initComponents();
        lista = new ArrayList<Usuario>();

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
        for (int i = 0; i < busyIcons.length; i++) {
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
    public void showAboutBox()
    {
        if (aboutBox == null) {
            JFrame mainFrame = ServidorChatApp.getApplication().getMainFrame();
            aboutBox = new ServidorChatAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        ServidorChatApp.getApplication().show(aboutBox);
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pestañaLog = new javax.swing.JScrollPane();
        areaTextoLog = new javax.swing.JEditorPane();
        pestañaMensajes = new javax.swing.JScrollPane();
        areaTextoMensajes = new javax.swing.JEditorPane();
        pestañaUsuarios = new javax.swing.JScrollPane();
        arbolUsuarios = new javax.swing.JTree();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu menuFichero = new javax.swing.JMenu();
        javax.swing.JMenuItem elementoMenuSalir = new javax.swing.JMenuItem();
        elementoMenuIniciar = new javax.swing.JMenuItem();
        elementoMenuApagar = new javax.swing.JMenuItem();
        javax.swing.JMenu menuAyuda = new javax.swing.JMenu();
        javax.swing.JMenuItem elementoMenuAcercaDe = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        mainPanel.setName("mainPanel"); // NOI18N

        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        pestañaLog.setName("pestañaLog"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(servidorchat.ServidorChatApp.class).getContext().getResourceMap(ServidorChatView.class);
        areaTextoLog.setContentType(resourceMap.getString("areaTextoLog.contentType")); // NOI18N
        areaTextoLog.setEditable(false);
        areaTextoLog.setName("areaTextoLog"); // NOI18N
        pestañaLog.setViewportView(areaTextoLog);

        jTabbedPane1.addTab(resourceMap.getString("pestañaLog.TabConstraints.tabTitle"), pestañaLog); // NOI18N

        pestañaMensajes.setName("pestañaMensajes"); // NOI18N

        areaTextoMensajes.setContentType(resourceMap.getString("areaTextoMensajes.contentType")); // NOI18N
        areaTextoMensajes.setName("areaTextoMensajes"); // NOI18N
        pestañaMensajes.setViewportView(areaTextoMensajes);

        jTabbedPane1.addTab(resourceMap.getString("pestañaMensajes.TabConstraints.tabTitle"), pestañaMensajes); // NOI18N

        pestañaUsuarios.setName("pestañaUsuarios"); // NOI18N

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Usuarios conectados");
        arbolUsuarios.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        arbolUsuarios.setName("arbolUsuarios"); // NOI18N
        arbolUsuarios.setRootVisible(false);
        pestañaUsuarios.setViewportView(arbolUsuarios);

        jTabbedPane1.addTab(resourceMap.getString("pestañaUsuarios.TabConstraints.tabTitle"), pestañaUsuarios); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName(resourceMap.getString("jTabbedPane1.AccessibleContext.accessibleName")); // NOI18N

        menuBar.setName("menuBar"); // NOI18N

        menuFichero.setText(resourceMap.getString("menuFichero.text")); // NOI18N
        menuFichero.setName("menuFichero"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(servidorchat.ServidorChatApp.class).getContext().getActionMap(ServidorChatView.class, this);
        elementoMenuSalir.setAction(actionMap.get("quit")); // NOI18N
        elementoMenuSalir.setText(resourceMap.getString("elementoMenuSalir.text")); // NOI18N
        elementoMenuSalir.setName("elementoMenuSalir"); // NOI18N
        menuFichero.add(elementoMenuSalir);

        elementoMenuIniciar.setText(resourceMap.getString("elementoMenuIniciar.text")); // NOI18N
        elementoMenuIniciar.setName("elementoMenuIniciar"); // NOI18N
        elementoMenuIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciar(evt);
            }
        });
        menuFichero.add(elementoMenuIniciar);

        elementoMenuApagar.setText(resourceMap.getString("elementoMenuApagar.text")); // NOI18N
        elementoMenuApagar.setName("elementoMenuApagar"); // NOI18N
        menuFichero.add(elementoMenuApagar);

        menuBar.add(menuFichero);

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
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addGap(121, 121, 121)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statusPanelLayout.createSequentialGroup()
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusAnimationLabel)
                        .addContainerGap())))
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
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

    private class Oyente implements Runnable
    {

        public void run()
        {
            try {
                int i = 1;
                ServerSocket s = new ServerSocket(4321);

                while (true) {
                    muestraMensaje(new Mensaje("*servidor*", "Me pongo a la escucha", Tipo.Log));
                    System.out.println("Me pongo a la escucha");
                    Socket incoming = s.accept();
                    System.out.println("Nueva conexion establecida");
                    System.out.println("Spawning " + i);
                    i++;
                    Usuario nuevoUsuario = new Usuario(incoming.getRemoteSocketAddress().toString(), incoming);
                    lista.add(nuevoUsuario);
                    Thread t = new Thread(nuevoUsuario);
                    t.start();
                    // Mandamos al usuario la lista de conectados actual
                    for (Usuario u : lista) {
                        if (!u.equals(nuevoUsuario)) {
                            Mensaje mConectado = new Mensaje(u.nombre, "ya esta conectado", Tipo.UsuarioEntra);
                            nuevoUsuario.enviarMensaje(mConectado);
                        }
                    }

                    // Notificamos la conexion al resto
                    publicar(new Mensaje(nuevoUsuario.nombre, "entra", Tipo.UsuarioEntra));

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void iniciar(java.awt.event.ActionEvent evt)//GEN-FIRST:event_iniciar
    {//GEN-HEADEREND:event_iniciar
        Oyente miOyente = new Oyente();
        Thread t = new Thread(miOyente);
        t.start();
    }//GEN-LAST:event_iniciar

    private void notificarDesconexion(Usuario user)
    {
        System.out.println("Borro al usuario de la lista");
        lista.remove(user);

        // Notificamos la desconexión al resto de usuarios

        Mensaje m = new Mensaje();
        m.setTipo(Tipo.UsuarioSale);
        m.setUsuario(user.nombre);
        m.setContenido("Usuario desconectado");

        publicar(m);


    }

    private void publicar(Mensaje m)
    {
        for (Usuario u : lista) {
            if((m.getTipo() == Tipo.MensajePrivado) && (! m.getUsuario().equals(u.nombre)) ) {
                // me lo salto si es privado y no es para el
            } else {
                System.out.println("Mandando mensaje " + m.getTipo() + " a: " + u.nombre);
                u.enviarMensaje(m);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbolUsuarios;
    private javax.swing.JEditorPane areaTextoLog;
    private javax.swing.JEditorPane areaTextoMensajes;
    private javax.swing.JMenuItem elementoMenuApagar;
    private javax.swing.JMenuItem elementoMenuIniciar;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JScrollPane pestañaLog;
    private javax.swing.JScrollPane pestañaMensajes;
    private javax.swing.JScrollPane pestañaUsuarios;
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

    public class Usuario implements Runnable
    {

        private String nombre;
        private Socket puerto;
        private ObjectOutputStream escritor;
        private ObjectInputStream lector;

        public Usuario(String nombre, Socket puerto)
        {
            this.nombre = nombre;
            this.puerto = puerto;
            inicializarFlujos();
        }

        private void inicializarFlujos()
        {
            try {
                if (puerto != null) {
                    System.out.println("El socket no es nulo");
                    if (puerto.isBound()) {
                        System.out.println("El socket esta asignado a un puerto");
                    }
                    if (puerto.isClosed()) {
                        System.out.println("El socket esta cerrado");
                    } else {
                        System.out.println("El socket no esta cerrado");
                    }
                    if (puerto.isConnected()) {
                        System.out.println("El socket esta conectado");
                    }
                    if (puerto.isInputShutdown()) {
                        System.out.println("El puerto no tiene conexion de entrada");
                    }
                    if (puerto.isOutputShutdown()) {
                        System.out.println("El puerto no tiene conexion de salida");
                    }
                }
                escritor = new ObjectOutputStream(puerto.getOutputStream());
                lector = new ObjectInputStream(puerto.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void enviarMensaje(Mensaje nuevoMensaje)
        {
            try {
                escritor.writeObject(nuevoMensaje);
                escritor.flush();
                muestraMensaje(nuevoMensaje);
            } catch (IOException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void run()
        {
            Mensaje nuevoMensaje = new Mensaje();
            do {
                try {
                    nuevoMensaje = (Mensaje) lector.readObject();
                } catch (SocketException ex) {
                    nuevoMensaje.setTipo(Tipo.Salir);
                } catch (IOException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (nuevoMensaje.getTipo() != Tipo.Salir) {
                    publicar(nuevoMensaje);
                } else {
                    enviarMensaje(nuevoMensaje);
                }
            } while (nuevoMensaje.getTipo() != Tipo.Salir);
            try {
                escritor.close();
                lector.close();
                notificarDesconexion(this);
            } catch (IOException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Muestra un mensaje formateado con HTML en el tab que le corresponda
     *
     * @param m mensaje a mostrar
     */
    public void muestraMensaje(Mensaje m)
    {
        DateFormat df = DateFormat.getDateTimeInstance( DateFormat.MEDIUM, DateFormat.MEDIUM );

        String html = "<small>";
        html += df.format(new Date());
        html += ":</small> ";
        html += "<b>[" + m.getUsuario() + "]</b> ";
        html += m.getContenido();

        if(m.getTipo() == Tipo.Mensaje) {
            mensajeAñadeEnHtml(html, m.getTipo());
        } else {
            logAñadeEnHtml(html, m.getTipo());
        }
    }

    /**
     * Añade un mensaje formateado con html al final del tab de log
     *
     * @param mensaje texto, puede llevar html
     * @param tipo tipo de mensaje
     */
    private void logAñadeEnHtml(final String mensaje, final Tipo tipo)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                areaTextoLog.setText(añadeEnHtml(areaTextoLog.getText(), mensaje, tipo));
            }
        });

    }
    /**
     * Añade un mensaje formateado con html al final del tab de mensajes
     *
     * @param mensaje texto, puede llevar html
     * @param tipo tipo de mensaje
     */
    private void mensajeAñadeEnHtml(final String mensaje, final Tipo tipo)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                areaTextoMensajes.setText(añadeEnHtml(areaTextoMensajes.getText(), mensaje, tipo));
            }
        });

    }

    /**
     * Crea un nuevo contenido html añadiendo el nuevo mensaje antes del body (al final del cuerpo)
     * para que pueda ser colocado machacando el contenido actual de un JEditorPane o similar
     *
     * @param html contenido actual del campo
     * @param mensaje nuevo mensaje a añadir
     * @param tipo dependiendo del tipo le da un color u otro
     * @return
     */
    private String añadeEnHtml(String html, String mensaje, Tipo tipo)
    {
        if ((tipo == Tipo.Acceder) || (tipo == Tipo.UsuarioEntra)) {
            mensaje = "<font color=\"green\">" + mensaje + "</font>";
        } else if ((tipo == Tipo.Salir) || (tipo == Tipo.UsuarioSale)) {
            mensaje = "<font color=\"red\">" + mensaje + "</font>";
        }
        return html.replace("</body>", mensaje + "<br/></body>");
    }
}
