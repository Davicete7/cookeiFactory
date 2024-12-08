/**
 * version 1.0
 * contacto --> https://www.linkedin.com/in/david-sanchez-1366b1253/
 * @author David Sánchez
 */

//Paquete al que pertenece la clase
package ServerInterface;



//Importes
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Server.Repostero;
import Server.Empaquetador;
import Server.Cafeteria;
import Server.Horno;



//CLASE
public class PanelSCM extends javax.swing.JFrame implements Runnable{

    //Atributos

    //Guardamos las posiciones del mouse en la pantalla
    private int xMouse;
    private int yMouse;
    private List<Repostero> listaReposteros;
    private List<Horno> listaHorno;
    private List<Empaquetador> listaEmpaquetadores;
    private Cafeteria cafeteria;
    
    
    public PanelSCM(List<Repostero> _listaReposteros, List<Horno> _listaHorno, List<Empaquetador> _listaEmpaquetadores, Cafeteria _cafeteria) {
        initComponents();
        Image icono = Toolkit.getDefaultToolkit().getImage(PanelSCM.class.getResource("/Fototeca/iconoAplicacion.png"));
        setIconImage(icono);
        
        //Centramos la ventana en la pantalla del usuario que ejecute la aplicacion
        setLocationRelativeTo(null); 
        
        
        //Asignamos los atributos
        this.listaReposteros = _listaReposteros;
        this.listaHorno = _listaHorno;
        this.listaEmpaquetadores = _listaEmpaquetadores;
        this.cafeteria = _cafeteria;
        
        
        //Para que cuando vuelva de minimizarse se coloque bien
        this.addWindowStateListener(e -> {
            if (e.getNewState() == JFrame.NORMAL) {
                setLocationRelativeTo(null); // Centra la ventana en la pantalla
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroung = new javax.swing.JPanel();
        separadorHeader = new javax.swing.JSeparator();
        separadorMenu = new javax.swing.JSeparator();
        header = new javax.swing.JPanel();
        labelCerrar = new javax.swing.JLabel();
        iconoCookienFactory = new javax.swing.JLabel();
        panelSCM = new javax.swing.JLabel();
        iconoMinimizado = new javax.swing.JLabel();
        lableCafeteria = new javax.swing.JLabel();
        respostero1 = new javax.swing.JLabel();
        respostero2 = new javax.swing.JLabel();
        respostero3 = new javax.swing.JLabel();
        respostero4 = new javax.swing.JLabel();
        respostero5 = new javax.swing.JLabel();
        horno1 = new javax.swing.JLabel();
        horno2 = new javax.swing.JLabel();
        horno3 = new javax.swing.JLabel();
        empaquetador1 = new javax.swing.JLabel();
        empaquetador2 = new javax.swing.JLabel();
        empaquetador3 = new javax.swing.JLabel();
        menuDerecha = new javax.swing.JPanel();
        almacen = new javax.swing.JLabel();
        logoMedioGrande = new javax.swing.JLabel();
        textoRepostero1 = new javax.swing.JTextField();
        textoRepostero2 = new javax.swing.JTextField();
        textoRepostero3 = new javax.swing.JTextField();
        textoRepostero4 = new javax.swing.JTextField();
        textoRepostero5 = new javax.swing.JTextField();
        textoCafeteria = new javax.swing.JTextField();
        textoColaCafeteria = new javax.swing.JTextField();
        imagenCafeteria = new javax.swing.JLabel();
        imagenCartelCafeteria = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        backgroung.setBackground(new java.awt.Color(204, 204, 204));
        backgroung.setForeground(new java.awt.Color(0, 0, 0));
        backgroung.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        separadorHeader.setBorder(null);
        separadorHeader.setName(""); // NOI18N
        backgroung.add(separadorHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 58, 1390, 10));

        separadorMenu.setOrientation(javax.swing.SwingConstants.VERTICAL);
        separadorMenu.setBorder(null);
        separadorMenu.setName(""); // NOI18N
        backgroung.add(separadorMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1118, 60, 20, 630));

        header.setBackground(new java.awt.Color(64, 166, 38));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        labelCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fototeca/IconoCerrar.png"))); // NOI18N
        labelCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelCerrarMouseExited(evt);
            }
        });

        iconoCookienFactory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fototeca/logoCookeiFactorySinFondo.png"))); // NOI18N

        panelSCM.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        panelSCM.setForeground(new java.awt.Color(0, 0, 0));
        panelSCM.setText("Panel SCM");

        iconoMinimizado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fototeca/iconoMinimizado.PNG"))); // NOI18N
        iconoMinimizado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconoMinimizado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconoMinimizadoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                iconoMinimizadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                iconoMinimizadoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(iconoCookienFactory)
                .addGap(455, 455, 455)
                .addComponent(panelSCM, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 495, Short.MAX_VALUE)
                .addComponent(iconoMinimizado, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCerrar)
                .addGap(411, 411, 411))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconoCookienFactory, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addComponent(labelCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelSCM)))
                .addContainerGap())
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(iconoMinimizado, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        backgroung.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1800, 60));

        lableCafeteria.setBackground(new java.awt.Color(0, 0, 0));
        lableCafeteria.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lableCafeteria.setForeground(new java.awt.Color(0, 0, 0));
        lableCafeteria.setText("Cafeteria");
        backgroung.add(lableCafeteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 30));

        respostero1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        respostero1.setForeground(new java.awt.Color(0, 0, 0));
        respostero1.setText("Repostero 1");
        backgroung.add(respostero1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 130, 40));

        respostero2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        respostero2.setForeground(new java.awt.Color(0, 0, 0));
        respostero2.setText("Repostero 2");
        backgroung.add(respostero2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 130, 40));

        respostero3.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        respostero3.setForeground(new java.awt.Color(0, 0, 0));
        respostero3.setText("Repostero 3");
        backgroung.add(respostero3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 130, 40));

        respostero4.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        respostero4.setForeground(new java.awt.Color(0, 0, 0));
        respostero4.setText("Repostero 4");
        backgroung.add(respostero4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, 130, 40));

        respostero5.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        respostero5.setForeground(new java.awt.Color(0, 0, 0));
        respostero5.setText("Repostero 5");
        backgroung.add(respostero5, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 150, 130, 40));

        horno1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        horno1.setForeground(new java.awt.Color(0, 0, 0));
        horno1.setText("Horno 1");
        backgroung.add(horno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 80, 40));

        horno2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        horno2.setForeground(new java.awt.Color(0, 0, 0));
        horno2.setText("Horno 2");
        backgroung.add(horno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 80, 40));

        horno3.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        horno3.setForeground(new java.awt.Color(0, 0, 0));
        horno3.setText("Horno 3");
        backgroung.add(horno3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 270, 80, 40));

        empaquetador1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        empaquetador1.setForeground(new java.awt.Color(0, 0, 0));
        empaquetador1.setText("Empaquetador 1");
        backgroung.add(empaquetador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 170, 40));

        empaquetador2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        empaquetador2.setForeground(new java.awt.Color(0, 0, 0));
        empaquetador2.setText("Empaquetador 2");
        backgroung.add(empaquetador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 480, 170, 40));

        empaquetador3.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        empaquetador3.setForeground(new java.awt.Color(0, 0, 0));
        empaquetador3.setText("Empaquetador 3");
        backgroung.add(empaquetador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 480, 170, 40));

        menuDerecha.setBackground(new java.awt.Color(64, 166, 38));

        almacen.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        almacen.setForeground(new java.awt.Color(0, 0, 0));
        almacen.setText("Almacen");

        logoMedioGrande.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fototeca/fotoTamañoMedioCookeiFactorySinFondo.png"))); // NOI18N

        javax.swing.GroupLayout menuDerechaLayout = new javax.swing.GroupLayout(menuDerecha);
        menuDerecha.setLayout(menuDerechaLayout);
        menuDerechaLayout.setHorizontalGroup(
            menuDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuDerechaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(almacen, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addGroup(menuDerechaLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(logoMedioGrande, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        menuDerechaLayout.setVerticalGroup(
            menuDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuDerechaLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(almacen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 296, Short.MAX_VALUE)
                .addComponent(logoMedioGrande, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        backgroung.add(menuDerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 60, 270, 630));

        textoRepostero1.setEditable(false);
        textoRepostero1.setBackground(new java.awt.Color(238, 212, 130));
        textoRepostero1.setForeground(new java.awt.Color(0, 0, 0));
        textoRepostero1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textoRepostero1.setFocusable(false);
        textoRepostero1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoRepostero1ActionPerformed(evt);
            }
        });
        backgroung.add(textoRepostero1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 120, -1));

        textoRepostero2.setEditable(false);
        textoRepostero2.setBackground(new java.awt.Color(238, 212, 130));
        textoRepostero2.setForeground(new java.awt.Color(0, 0, 0));
        textoRepostero2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textoRepostero2.setFocusable(false);
        textoRepostero2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoRepostero2ActionPerformed(evt);
            }
        });
        backgroung.add(textoRepostero2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 120, -1));

        textoRepostero3.setEditable(false);
        textoRepostero3.setBackground(new java.awt.Color(238, 212, 130));
        textoRepostero3.setForeground(new java.awt.Color(0, 0, 0));
        textoRepostero3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textoRepostero3.setFocusable(false);
        textoRepostero3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoRepostero3ActionPerformed(evt);
            }
        });
        backgroung.add(textoRepostero3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 120, -1));

        textoRepostero4.setEditable(false);
        textoRepostero4.setBackground(new java.awt.Color(238, 212, 130));
        textoRepostero4.setForeground(new java.awt.Color(0, 0, 0));
        textoRepostero4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textoRepostero4.setFocusable(false);
        textoRepostero4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoRepostero4ActionPerformed(evt);
            }
        });
        backgroung.add(textoRepostero4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, 120, -1));

        textoRepostero5.setEditable(false);
        textoRepostero5.setBackground(new java.awt.Color(238, 212, 130));
        textoRepostero5.setForeground(new java.awt.Color(0, 0, 0));
        textoRepostero5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textoRepostero5.setFocusable(false);
        textoRepostero5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoRepostero5ActionPerformed(evt);
            }
        });
        backgroung.add(textoRepostero5, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 190, 120, -1));

        textoCafeteria.setEditable(false);
        textoCafeteria.setBackground(new java.awt.Color(238, 212, 130));
        textoCafeteria.setForeground(new java.awt.Color(0, 0, 0));
        textoCafeteria.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textoCafeteria.setFocusable(false);
        textoCafeteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoCafeteriaActionPerformed(evt);
            }
        });
        backgroung.add(textoCafeteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 120, -1));

        textoColaCafeteria.setEditable(false);
        textoColaCafeteria.setBackground(new java.awt.Color(238, 212, 130));
        textoColaCafeteria.setForeground(new java.awt.Color(0, 0, 0));
        textoColaCafeteria.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textoColaCafeteria.setFocusable(false);
        textoColaCafeteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoColaCafeteriaActionPerformed(evt);
            }
        });
        backgroung.add(textoColaCafeteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 750, -1));

        imagenCafeteria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fototeca/cafeteria.PNG"))); // NOI18N
        backgroung.add(imagenCafeteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 50));

        imagenCartelCafeteria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fototeca/cartelCafeteria.PNG"))); // NOI18N
        backgroung.add(imagenCartelCafeteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 60, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroung, javax.swing.GroupLayout.PREFERRED_SIZE, 1387, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void labelCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_labelCerrarMouseClicked

    private void labelCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCerrarMouseEntered
        labelCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fototeca/IconoCerrar2.png")));
    }//GEN-LAST:event_labelCerrarMouseEntered

    private void labelCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCerrarMouseExited
        labelCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fototeca/IconoCerrar.png")));
    }//GEN-LAST:event_labelCerrarMouseExited

    private void textoRepostero1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoRepostero1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoRepostero1ActionPerformed

    private void textoRepostero2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoRepostero2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoRepostero2ActionPerformed

    private void textoRepostero3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoRepostero3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoRepostero3ActionPerformed

    private void textoRepostero4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoRepostero4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoRepostero4ActionPerformed

    private void textoRepostero5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoRepostero5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoRepostero5ActionPerformed

    private void textoColaCafeteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoColaCafeteriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoColaCafeteriaActionPerformed

    private void textoCafeteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoCafeteriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoCafeteriaActionPerformed

    private void iconoMinimizadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconoMinimizadoMouseClicked
        Point startLocation = this.getLocation();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int taskbarHeight = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration()).bottom;

        Point endLocation = new Point(
                (int) screenSize.getWidth() / 2,
                (int) screenSize.getHeight() - taskbarHeight
        );

        Timer timer = new Timer(10, null);
        timer.addActionListener(new ActionListener() {
            double progress = 0;
            final double step = 0.05;

            @Override
            public void actionPerformed(ActionEvent evt) {
                progress += step;
                if (progress >= 1.0) {
                    timer.stop();
                    setExtendedState(JFrame.ICONIFIED);
                } else {
                    int x = (int) (startLocation.x + progress * (endLocation.x - startLocation.x));
                    int y = (int) (startLocation.y + progress * (endLocation.y - startLocation.y));
                    setLocation(x, y);
                }
            }
        });
        timer.start();
    }//GEN-LAST:event_iconoMinimizadoMouseClicked

    private void iconoMinimizadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconoMinimizadoMouseEntered
        iconoMinimizado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fototeca/iconoMinimizado2.png")));
    }//GEN-LAST:event_iconoMinimizadoMouseEntered

    private void iconoMinimizadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconoMinimizadoMouseExited
        iconoMinimizado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fototeca/iconoMinimizado.png")));
    }//GEN-LAST:event_iconoMinimizadoMouseExited

    //METODOS CREADOS A MANO
    public JTextField getTextosReposteros(int identificadorTexto)
    {
            switch (identificadorTexto) 
            {
                case 0:
                    return textoRepostero1;
                case 1:
                    return textoRepostero2;
                case 2:
                    return textoRepostero3;
                case 3:
                    return textoRepostero4;
                case 4:
                    return textoRepostero5;
            }
            
            //Si no entra en ningun case, no devolvemos anda porque no han seleccionado el indice bien
            return null;
    }
    public JTextField getTextoCafeteria(){return textoCafeteria;}
    public JTextField getTextoColaCafeteria(){return textoColaCafeteria;}
    
    
    
    public void ponerColorTextoReposteros(int identificador, String accion)
    {
        if (accion.equals("PRODUCIENDO")) {getTextosReposteros(identificador).setForeground(Color.black);} 
        else if (accion.equals("DEPOSITANDO")) {getTextosReposteros(identificador).setForeground(Color.magenta);} 
        else if (accion.equals("DESCANSANDO")) {getTextosReposteros(identificador).setForeground(Color.white);} 
        else if (accion.equals("BLOQUEADO")) {getTextosReposteros(identificador).setForeground(Color.red);} 
        else if (accion.equals("CAFETERÍA")) {getTextosReposteros(identificador).setForeground(Color.blue);}
    }
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
            java.util.logging.Logger.getLogger(PanelSCM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelSCM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelSCM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelSCM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel almacen;
    private javax.swing.JPanel backgroung;
    private javax.swing.JLabel empaquetador1;
    private javax.swing.JLabel empaquetador2;
    private javax.swing.JLabel empaquetador3;
    private javax.swing.JPanel header;
    private javax.swing.JLabel horno1;
    private javax.swing.JLabel horno2;
    private javax.swing.JLabel horno3;
    private javax.swing.JLabel iconoCookienFactory;
    private javax.swing.JLabel iconoMinimizado;
    private javax.swing.JLabel imagenCafeteria;
    private javax.swing.JLabel imagenCartelCafeteria;
    private javax.swing.JLabel labelCerrar;
    private javax.swing.JLabel lableCafeteria;
    private javax.swing.JLabel logoMedioGrande;
    private javax.swing.JPanel menuDerecha;
    private javax.swing.JLabel panelSCM;
    private javax.swing.JLabel respostero1;
    private javax.swing.JLabel respostero2;
    private javax.swing.JLabel respostero3;
    private javax.swing.JLabel respostero4;
    private javax.swing.JLabel respostero5;
    private javax.swing.JSeparator separadorHeader;
    private javax.swing.JSeparator separadorMenu;
    private javax.swing.JTextField textoCafeteria;
    private javax.swing.JTextField textoColaCafeteria;
    private javax.swing.JTextField textoRepostero1;
    private javax.swing.JTextField textoRepostero2;
    private javax.swing.JTextField textoRepostero3;
    private javax.swing.JTextField textoRepostero4;
    private javax.swing.JTextField textoRepostero5;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() 
    {
        //No queremos que el hilo pare nunca de ejecutarse
        while(true)
        {
            try
            {
                //Checkeo de estado para los reposteros
                for (int identificador = 0; identificador < listaReposteros.size(); identificador++)
                {
                    String accion = listaReposteros.get(identificador).getAccion();

                    //Primero cambio el color del texto
                    ponerColorTextoReposteros(identificador, accion);
                    //Luego cambio el texto
                    getTextosReposteros(identificador).setText(accion);
                }

                //Checkeo la cafeteria
                textoCafeteria.setText(cafeteria.getReposteroAtendido());
                textoColaCafeteria.setText(cafeteria.getColaReposterosCafeteria());

                //Generamos un breve retardo para no colapsar memoria con comprobaciones
                Thread.sleep(100);
            }
            catch (InterruptedException error)
            {
                System.out.println("Se ha producido un error mientras se ejecutaba el hilo de la interfaz de PanelSCM --> " + error);
            }
        }
    }
}
