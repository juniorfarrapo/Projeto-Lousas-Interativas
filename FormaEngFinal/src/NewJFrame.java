

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import java.awt.AWTException;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class NewJFrame extends javax.swing.JFrame {

    public static Camera camera = new Camera(); //cria-se um objeto da classe Camera
    public static Calibracao calibrado = new Calibracao(); //cria-se um objeto da classe Calibracao
    public static RodaCamera loopCamera = new RodaCamera(); //cria-se um objeto da classe RodaCamera
    public static Webcam webcam; //cria-se uma variável do tipo webcam que está pronta para receber a webcam escolhida pelo usuário
    
    public NewJFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        textCalibrar = new javax.swing.JLabel();
        botaoCalibrar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        textVisualizacao = new javax.swing.JLabel();
        botaoVisualizacao = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        textLimiar = new javax.swing.JLabel();
        limiar = new javax.swing.JSlider();
        textLuz = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        textStatusFixo = new javax.swing.JLabel();
        textStatusCalibracao = new javax.swing.JLabel();
        textStatusGeral = new javax.swing.JLabel();
        textStatusCamera = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        botaoIniciaPrograma = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();
        navegar = new javax.swing.JRadioButton();
        pintar = new javax.swing.JRadioButton();
        barraDeMenu = new javax.swing.JMenuBar();
        menuCameras = new javax.swing.JMenu();
        opcaoCamera0 = new javax.swing.JMenuItem();
        opcaoCamera1 = new javax.swing.JMenuItem();
        opcaoCamera2 = new javax.swing.JMenuItem();
        opcaoCamera3 = new javax.swing.JMenuItem();
        menuSobre = new javax.swing.JMenu();
        opcaoManual = new javax.swing.JMenuItem();
        opcaoSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Projeto Lousas Interativas UFC-SOBRAL CNPQ/VALE S.A.");
        setMaximumSize(new java.awt.Dimension(310, 540));
        setMinimumSize(new java.awt.Dimension(310, 540));
        setName("Projeto Lousas Interativas UFC-SOBRAL CNPQ/VALE S.A."); // NOI18N
        setPreferredSize(new java.awt.Dimension(310, 540));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        painelPrincipal.setMaximumSize(new java.awt.Dimension(700, 500));

        textCalibrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textCalibrar.setText("Calibrar");

        botaoCalibrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoCalibrar.setText("Iniciar");
        botaoCalibrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCalibrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textCalibrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(botaoCalibrar)
                .addGap(76, 76, 76))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textCalibrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoCalibrar)
                .addContainerGap())
        );

        textVisualizacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textVisualizacao.setText("Visualização");

        botaoVisualizacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoVisualizacao.setText("Visualizar Câmera");
        botaoVisualizacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoVisualizacaoMouseClicked(evt);
            }
        });
        botaoVisualizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVisualizacaoActionPerformed(evt);
            }
        });

        textLimiar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textLimiar.setText("Limiar");

        limiar.setMaximum(254);
        limiar.setMinimum(1);
        limiar.setPaintLabels(true);
        limiar.setValue(180);
        limiar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        textLuz.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textLuz.setText("-Luz                                               +Luz");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(limiar, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textLuz, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textLimiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textLimiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(limiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(textLuz))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textVisualizacao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoVisualizacao)
                .addGap(66, 66, 66))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textVisualizacao)
                .addGap(18, 18, 18)
                .addComponent(botaoVisualizacao)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        textStatusFixo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textStatusFixo.setText("Status:");

        textStatusCalibracao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textStatusCalibracao.setForeground(new java.awt.Color(255, 0, 0));
        textStatusCalibracao.setText("Aguardando Calibração");

        textStatusGeral.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textStatusGeral.setForeground(new java.awt.Color(255, 0, 0));
        textStatusGeral.setText("Lousa não iniciada");

        textStatusCamera.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textStatusCamera.setForeground(new java.awt.Color(255, 0, 0));
        textStatusCamera.setText("Escolha uma câmera");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(textStatusFixo))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textStatusCamera, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textStatusCalibracao)
                            .addComponent(textStatusGeral))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(textStatusFixo)
                .addGap(1, 1, 1)
                .addComponent(textStatusCamera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textStatusCalibracao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textStatusGeral)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        botaoIniciaPrograma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoIniciaPrograma.setText("Aguardando Calibração");
        botaoIniciaPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoIniciaProgramaActionPerformed(evt);
            }
        });

        botaoSair.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoSair.setText("Sair");
        botaoSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoSairMouseClicked(evt);
            }
        });

        navegar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        navegar.setSelected(true);
        navegar.setText("Navegar");
        navegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navegarActionPerformed(evt);
            }
        });

        pintar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pintar.setText("Pintar");
        pintar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pintarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoSair)
                .addGap(96, 96, 96))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(navegar)
                        .addGap(68, 68, 68)
                        .addComponent(pintar))
                    .addComponent(botaoIniciaPrograma))
                .addGap(0, 37, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoIniciaPrograma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoSair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(navegar)
                    .addComponent(pintar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuCameras.setText("Câmeras");

        opcaoCamera0.setText("Nenhuma Webcam");
        opcaoCamera0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                opcaoCamera0MousePressed(evt);
            }
        });
        menuCameras.add(opcaoCamera0);

        opcaoCamera1.setText("Nenhuma Webcam");
        opcaoCamera1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                opcaoCamera1MousePressed(evt);
            }
        });
        menuCameras.add(opcaoCamera1);

        opcaoCamera2.setText("Nenhuma Webcam");
        opcaoCamera2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                opcaoCamera2MousePressed(evt);
            }
        });
        opcaoCamera2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcaoCamera2ActionPerformed(evt);
            }
        });
        menuCameras.add(opcaoCamera2);

        opcaoCamera3.setText("Nenhuma Webcam");
        opcaoCamera3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                opcaoCamera3MousePressed(evt);
            }
        });
        menuCameras.add(opcaoCamera3);

        barraDeMenu.add(menuCameras);

        menuSobre.setText("Ajuda");
        menuSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSobreMouseClicked(evt);
            }
        });

        opcaoManual.setText("Manual");
        opcaoManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcaoManualActionPerformed(evt);
            }
        });
        menuSobre.add(opcaoManual);

        opcaoSobre.setText("Sobre");
        opcaoSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcaoSobreActionPerformed(evt);
            }
        });
        menuSobre.add(opcaoSobre);

        barraDeMenu.add(menuSobre);

        setJMenuBar(barraDeMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Projeto Lousas Interativas V0.3 ALPHA UFC-SOBRAL CNPQ/VALE S.A.");
        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    Thread threadCalibrando = new Thread(calibrado); //cria-se uma thread para a calibração recebendo o objeto calibrado
    Thread threadWebcam = new Thread(loopCamera); //cria-se uma thread para a execução da câmera recebendo o objeto loopCamera
    
    public static boolean testCalibrado = false,testCamera = false,testCamera0 = false,testCamera1 = false,testCamera2 = false,testCamera3 = false,testVisualizacao = false;
    
    public static WebcamPanel exibicao;
    public static JFrame frameVisualizacao = new JFrame("Visualização");
    private void opcaoCamera2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcaoCamera2ActionPerformed
        
    }//GEN-LAST:event_opcaoCamera2ActionPerformed

    //evento que ocorre quando é escolhida a câmera 0
    private void opcaoCamera0MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcaoCamera0MousePressed
        try {
            // TODO add your handling code here:
            if(testCamera0){
                webcam = Camera.webcam0; //webcam recebe o objeto da webcam 0 conectada ao pc 
                camera.criarCamera(); //cria-se a câmera
                Camera.webcam0 = null;
                Camera.webcam1 = null;
                Camera.webcam2 = null;
                Camera.webcam3 = null;
                testCamera = true;
                exibicao = new WebcamPanel(webcam);
                frameVisualizacao.add(exibicao);
                frameVisualizacao.pack();
                frameVisualizacao.setLocationRelativeTo(null);
                frameVisualizacao.setVisible(true);
                frameVisualizacao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                testCamera0 = false;
                textStatusCamera.setForeground(Color.green);
                textStatusCamera.setText("Câmera escolhida!");
            }
            else{
                textStatusCamera.setForeground(Color.red);
                textStatusCamera.setText("Câmera não encontrada!");
            }

            
        } catch (IOException | InterruptedException | AWTException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_opcaoCamera0MousePressed
    
    //evento que ocorre quando é escolhida a câmera 1
    private void opcaoCamera1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcaoCamera1MousePressed
        try {
            // TODO add your handling code here:
            if(testCamera1){
                webcam = Camera.webcam1; //webcam recebe o objeto da webcam 1 conectada ao pc
                camera.criarCamera(); //cria-se a câmera
                Camera.webcam0 = null;
                Camera.webcam1 = null;
                Camera.webcam2 = null;
                Camera.webcam3 = null;
                testCamera = true;
                exibicao = new WebcamPanel(webcam);
                frameVisualizacao.add(exibicao);
                frameVisualizacao.pack();
                frameVisualizacao.setLocationRelativeTo(null);
                frameVisualizacao.setVisible(true);
                frameVisualizacao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                testCamera1 = false;
                textStatusCamera.setForeground(Color.green);
                textStatusCamera.setText("Câmera escolhida!");
            }
            else{
                textStatusCamera.setForeground(Color.red);
                textStatusCamera.setText("Câmera não encontrada!");
            }

                        
        } catch (IOException | InterruptedException | AWTException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_opcaoCamera1MousePressed

        //evento que ocorre quando é escolhida a câmera 2
    private void opcaoCamera2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcaoCamera2MousePressed
        try {
            // TODO add your handling code here:
            if(testCamera2){
                webcam = Camera.webcam2; //webcam recebe o objeto da webcam 3 conectada ao pc
                camera.criarCamera(); //cria-se a câmera
                Camera.webcam0 = null;
                Camera.webcam1 = null;
                Camera.webcam2 = null;
                Camera.webcam3 = null;
                testCamera = true;
                exibicao = new WebcamPanel(webcam);
                frameVisualizacao.add(exibicao);
                frameVisualizacao.pack();
                frameVisualizacao.setLocationRelativeTo(null);
                frameVisualizacao.setVisible(true);
                frameVisualizacao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                testCamera2 = false;
                textStatusCamera.setForeground(Color.green);
                textStatusCamera.setText("Câmera escolhida!");
            }
            else{
                textStatusCamera.setForeground(Color.red);
                textStatusCamera.setText("Câmera não encontrada!");
            }

                        
        } catch (IOException | InterruptedException | AWTException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_opcaoCamera2MousePressed

        //evento que ocorre quando é escolhida a câmera 3
    private void opcaoCamera3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcaoCamera3MousePressed
        try {
            // TODO add your handling code here:
            if(testCamera3){
                webcam = Camera.webcam3; //webcam recebe o objeto da webcam 3 conectada ao pc
                camera.criarCamera(); //cria-se a câmera
                Camera.webcam0 = null;
                Camera.webcam1 = null;
                Camera.webcam2 = null;
                Camera.webcam3 = null;
                testCamera = true;
                exibicao = new WebcamPanel(webcam);
                frameVisualizacao.add(exibicao);
                frameVisualizacao.pack();
                frameVisualizacao.setLocationRelativeTo(null);
                frameVisualizacao.setVisible(true);
                frameVisualizacao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                testCamera3 = false;
                textStatusCamera.setForeground(Color.green);
                textStatusCamera.setText("Câmera escolhida!");
            }
            else{
                textStatusCamera.setForeground(Color.red);
                textStatusCamera.setText("Câmera não encontrada!");
            }
            
        } catch (IOException | InterruptedException | AWTException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_opcaoCamera3MousePressed

//GEN-FIRST:event_jButton1ActionPerformed
//GEN-LAST:event_jButton1ActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void menuSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSobreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_menuSobreMouseClicked

    private void opcaoSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcaoSobreActionPerformed
        // TODO add your handling code here:
        JFrame frameSobre = new JFrame("Sobre");
        JLabel labelImagemFundo = new JLabel();
        getContentPane().add(labelImagemFundo);
        labelImagemFundo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("recursos/Creditos.png")));
        frameSobre.add(labelImagemFundo);
        frameSobre.pack();
        frameSobre.setLocationRelativeTo(null);
        frameSobre.setVisible(true);
        frameSobre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_opcaoSobreActionPerformed

    private void opcaoManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcaoManualActionPerformed
        // TODO add your handling code here:
        JFrame frameManual = new JFrame("Manual");
        JLabel labelImagemFundo = new JLabel();
        getContentPane().add(labelImagemFundo);
        labelImagemFundo.setText("Em breve!                          \n\n");
        frameManual.add(labelImagemFundo);
        frameManual.pack();
        frameManual.setLocationRelativeTo(null);
        frameManual.setVisible(true);
        frameManual.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_opcaoManualActionPerformed

    private void pintarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pintarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pintarActionPerformed

    private void navegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navegarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_navegarActionPerformed

    private void botaoVisualizacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoVisualizacaoMouseClicked
        // TODO add your handling code here:
        frameVisualizacao.add(exibicao);
        frameVisualizacao.pack();
        frameVisualizacao.setLocationRelativeTo(null);
        frameVisualizacao.setVisible(true);
        frameVisualizacao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_botaoVisualizacaoMouseClicked

    //evento que ocorre quando clica no botão sair
    private void botaoSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoSairMouseClicked
        System.exit(0);//fecha o programa
    }//GEN-LAST:event_botaoSairMouseClicked

    //evento que ocorre quando clica no botão calibrar
    private void botaoCalibrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCalibrarActionPerformed
        if(testCamera){
            threadCalibrando.start();//inicia calibração quando clicado no botao
            testCalibrado = true;
        }
        else{
            textStatusCamera.setForeground(Color.red);
            textStatusCamera.setText("Escolha uma câmera!");

        }
    }//GEN-LAST:event_botaoCalibrarActionPerformed

    //evento que ocorre quando clica para iniciar a usar a lousa após a calibração, deve-se primeiro calibrar para depois clicar nesse botão
    private void botaoIniciaProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoIniciaProgramaActionPerformed
        if(testCalibrado){
            textStatusGeral.setForeground(Color.green);
            textStatusGeral.setText("Lousa Funcionando!");
            botaoIniciaPrograma.setText("Iniciado..."); //muda o nome do botão após ter sido clicado
            threadWebcam.start(); //inicia a webcam para o funcionamento
            testCamera = false;
            textStatusCamera.setVisible(false);
            textStatusCalibracao.setVisible(false);
        }
        else{
            textStatusCalibracao.setForeground(Color.red);
            textStatusCalibracao.setText("Calibre a lousa!");
        }
        testCalibrado = false;
    }//GEN-LAST:event_botaoIniciaProgramaActionPerformed

    private void botaoVisualizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVisualizacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoVisualizacaoActionPerformed

 
    /**
     * @param args the command line arguments
     */
    //main do Projeto, tudo começa aqui
    public static void main(String args[]) throws IOException, InterruptedException, AWTException{
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                } //deixa com design do windows 7
                   
                new NewJFrame().setVisible(true); //exibe a janela para o usuário
                camera.opcaoCamera(); //verifica as webcams conectadas ao pc
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraDeMenu;
    private javax.swing.JButton botaoCalibrar;
    public static javax.swing.JButton botaoIniciaPrograma;
    private javax.swing.JButton botaoSair;
    private javax.swing.JButton botaoVisualizacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    public static javax.swing.JSlider limiar;
    public static javax.swing.JMenu menuCameras;
    private javax.swing.JMenu menuSobre;
    public static javax.swing.JRadioButton navegar;
    public static javax.swing.JMenuItem opcaoCamera0;
    public static javax.swing.JMenuItem opcaoCamera1;
    public static javax.swing.JMenuItem opcaoCamera2;
    public static javax.swing.JMenuItem opcaoCamera3;
    private javax.swing.JMenuItem opcaoManual;
    private javax.swing.JMenuItem opcaoSobre;
    private javax.swing.JPanel painelPrincipal;
    public static javax.swing.JRadioButton pintar;
    private javax.swing.JLabel textCalibrar;
    private javax.swing.JLabel textLimiar;
    private javax.swing.JLabel textLuz;
    public static javax.swing.JLabel textStatusCalibracao;
    public static javax.swing.JLabel textStatusCamera;
    private javax.swing.JLabel textStatusFixo;
    public static javax.swing.JLabel textStatusGeral;
    private javax.swing.JLabel textVisualizacao;
    // End of variables declaration//GEN-END:variables
}
