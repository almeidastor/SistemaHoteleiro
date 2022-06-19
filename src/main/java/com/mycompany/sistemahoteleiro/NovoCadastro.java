package com.mycompany.sistemahoteleiro;


import static java.awt.SystemColor.text;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import static java.time.Instant.now;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author almeidastor
 */
public class NovoCadastro extends javax.swing.JFrame {
    /**
     * Creates new form NovoCadastro
     */
    public NovoCadastro() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(741, 600);
        this.setResizable(false);
        this.setTitle("Sistema Hoteleiro");
        
    }
      
    public void Calculate(){
        
       //Calculando numero de dias
       DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
       Date entrada = null;
       Date saida = null;
       
       try{
           entrada = dateFormat.parse(dateFormat.format(txtEntrada.getDate()));
           saida = dateFormat.parse(dateFormat.format(txtEntrada1.getDate()));
       } catch (Exception e){
           e.printStackTrace();
       }
       
        long diff = saida.getTime()- entrada.getTime();
        long hours = diff/(60*60*1000);
        long days = hours/24;
        if(days == 0 ){
            days ++;
        } if(days < 0){
            JOptionPane.showMessageDialog(null, "Data de Saída não pode ser inferior a Data de Entrada");
        }
        
        // Calculando Plano
              
  	float pnormal = 0;
	float pvegetariano = 0;
        float pdiversos = 0;
        float pinternos = 0;
      

    
     String plnormal = (String) cmbNormal.getSelectedItem();
	String plvegetariano = (String) cmbVegetariana.getSelectedItem();
	 String pldiversos = (String) cmbDiversos.getSelectedItem();
       String plinternos = (String) cmbInternos.getSelectedItem();
     
     //Plano Normal
        if (plnormal ==""){
            pnormal = 0;
       cmbVegetariana.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
       cmbInternos.setSelectedIndex(0);
        }
        if (plnormal =="Normal(Sem Toalhas)"){
            pnormal = 109;
       cmbVegetariana.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
       cmbInternos.setSelectedIndex(0);
        }
        if (plnormal =="Normal(com toalhas)"){
            pnormal = 118;
       cmbVegetariana.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
       cmbInternos.setSelectedIndex(0);
        }
        if (plnormal =="Com uso de Multimidia"){
            pnormal = 121;
       cmbVegetariana.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
       cmbInternos.setSelectedIndex(0);
        }
        if(plnormal =="Com uso da multimidia, internet e toalhas..(MT)"){
            pnormal = 125;
       cmbVegetariana.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
       cmbInternos.setSelectedIndex(0);
        }                                        
                                                    
       
     //Plano Vegetariano  
       
       
       if (plvegetariano ==""){
            pvegetariano = 0; 
       cmbNormal.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
       cmbInternos.setSelectedIndex(0);
            
        }
        if (plvegetariano =="Normal(Sem Toalhas)"){
            pvegetariano = 138; 
       cmbNormal.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
       cmbInternos.setSelectedIndex(0);
        }
        if (plvegetariano =="Normal(com toalhas)"){
            pvegetariano = 145;  
       cmbNormal.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
       cmbInternos.setSelectedIndex(0);
        }
        if (plvegetariano =="Com uso de Multimidia"){
            pvegetariano = 140;
       cmbNormal.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
       cmbInternos.setSelectedIndex(0);
        }
        if (plvegetariano =="Com uso de Internet"){
            pvegetariano = 140;   
       cmbNormal.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
       cmbInternos.setSelectedIndex(0);
        }
        if (plvegetariano =="Com uso da Multimidia e Internet"){
            pvegetariano = 145;  
       cmbNormal.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
       cmbInternos.setSelectedIndex(0);
        }
        if (plvegetariano =="Com uso da multimidia, internet e toalhas..(MT)"){
            pvegetariano = 150;    
       cmbNormal.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
       cmbInternos.setSelectedIndex(0);
        }
         
      
       //Plano Diversos  
        if (pldiversos ==""){
            pdiversos = 0;
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbInternos.setSelectedIndex(0);
        }
        if (pldiversos =="Econtros Externos sem refeição"){
            pdiversos = 16;
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbInternos.setSelectedIndex(0);
        }
        if (pldiversos =="Encontros externos com refeição"){
            pdiversos = 43;   
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbInternos.setSelectedIndex(0);
        }
        if (pldiversos =="Encontros externos só com o uso do auditório"){
            pdiversos = 26; 
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbInternos.setSelectedIndex(0);
        }
        if (pldiversos =="Encontros externos com o auditório e refeição"){
            pdiversos = 53; 
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbInternos.setSelectedIndex(0);
        }
        if (pldiversos =="Diaria dos bispos-Encontro Latino americano. Completo"){
            pdiversos = 139;
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbInternos.setSelectedIndex(0);
        }
        if (pldiversos =="Diaria dos empresarios"){
            pdiversos = 190;
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbInternos.setSelectedIndex(0);
        }
        if (pldiversos =="Retiro das irmãs franciscanas de bonlanden"){
            pdiversos = 103;
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbInternos.setSelectedIndex(0);
        }
        if (pldiversos =="yoga- formação. Prof Kalidas(sem toalha e quarto duplo)"){
            pdiversos = 119; 
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbInternos.setSelectedIndex(0);
        }
        if (pldiversos =="yoga- formação. Prof Kalidas(sem toalha e quarto individual)"){
            pdiversos = 134;
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbInternos.setSelectedIndex(0);
        }
        if (pldiversos =="Especial. Instituto ecosocia(Formação...)"){
            pdiversos = 207; 
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbInternos.setSelectedIndex(0);
        }                                          

            
        //Planos Internos
        
        if (plinternos ==""){
            pinternos = 0;
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
        }
        if (plinternos =="café da manha,cafezinho,almoço,lanche da tarde e auditório"){
            pinternos = 99;
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
        }
        if (plinternos =="Interno com multimidia"){
            pinternos = 102; 
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
        }
        if (plinternos =="Dieta normal(Sem toalhas)"){
            pinternos = 109;
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);  
        }
        if (plinternos =="Dieta normal(Com toalhas)"){
            pinternos = 118;    
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
        }
        if (plinternos =="Dieta Vegetariana(Sem toalhas)"){
            pinternos = 138;
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
        }
        if (plinternos =="Dieta Vegetariana(Com toalhas)"){
            pinternos = 145;  
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
        }
        if (plinternos =="Diaria dos Bispos- Encontro latino americano.(Completo)"){
            pinternos = 139;
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
        }
        if (plinternos =="Dieta dos Empresários"){
            pinternos = 290; 
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
        }
        if (plinternos =="Almoço individual (Comum) 23,00"){
            pinternos = 28; 
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
        }
        if (plinternos =="Almoço individual (Aniversarios)30,00"){
            pinternos = 30;
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
        }
        if (plinternos =="Café da Manhã"){
            pinternos = 25;
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
        }
        if (plinternos =="Jantar"){
            pinternos = 26;
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
        }
        if (plinternos =="Cafezinho M e lanche da tarde 9,00 + 11,00"){
            pinternos = 25; 
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
        }
        if (plinternos =="espaço livre(Casa da Juventude)"){
            pinternos = 16;
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
        }
        if (plinternos =="Dormir"){
            pinternos = 67; 
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);  
        }
        if (plinternos =="Uso do auditório ou Sala Yoga por externos"){
            pinternos = 26;
       cmbNormal.setSelectedIndex(0);
       cmbVegetariana.setSelectedIndex(0);
       cmbDiversos.setSelectedIndex(0);
        }
        
        float valor = ((pnormal + pvegetariano + pinternos + pdiversos)* Integer.parseInt(txtNPessoas.getText())*days);
        txtValor.setText(String.valueOf(valor));
                                
    }
    
    public void Limpar(){
    txtEntrada.setDate(new Date());
    txtEntrada1.setDate(new Date());
    txtResponsavel.setText(null);
    txtGrupo.setText(null);
    txtTelefone.setText(null);
    txtEmail.setText(null);
    cmbCategoria.setSelectedItem(null);
    cmbOrientador.setText(null);
    txtNPessoas.setText("1");
    txtNQuartos.setText(null);
    jTextArea1.setText(null);
    txtValor.setText(null);
    cbVista.setSelected(false);
    cbTransferencia.setSelected(false);
    cbCheque.setSelected(false);
    cbCredito.setSelected(false);
    cbReserva.setSelected(false);
    if(cmbNormal.getSelectedItem()!=""){
        cmbNormal.setSelectedIndex(0);
    }
    if(cmbVegetariana.getSelectedItem()!=""){
        cmbVegetariana.setSelectedIndex(0);
    }
    if(cmbDiversos.getSelectedItem()!=""){
        cmbDiversos.setSelectedIndex(0);
    }
    if(cmbInternos.getSelectedItem()!=""){
        cmbInternos.setSelectedIndex(0);
    }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pCheckin = new javax.swing.JPanel();
        lblEntrada = new javax.swing.JLabel();
        btnBusca1 = new javax.swing.JButton();
        txtEntrada = new org.jdesktop.swingx.JXDatePicker();
        lblResponsavel = new javax.swing.JLabel();
        txtResponsavel = new javax.swing.JTextField();
        btnBuscaResp = new javax.swing.JButton();
        lblGrupo = new javax.swing.JLabel();
        txtGrupo = new javax.swing.JTextField();
        btnBuscaGrup = new javax.swing.JButton();
        lblTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        lblOrientador = new javax.swing.JLabel();
        cmbOrientador = new javax.swing.JTextField();
        lblNPessoas = new javax.swing.JLabel();
        txtNPessoas = new javax.swing.JTextField();
        lblNQuartos = new javax.swing.JLabel();
        txtNQuartos = new javax.swing.JTextField();
        pNormal = new javax.swing.JPanel();
        cmbNormal = new javax.swing.JComboBox<>();
        pVegetariana = new javax.swing.JPanel();
        cmbVegetariana = new javax.swing.JComboBox<>();
        pDiversos = new javax.swing.JPanel();
        cmbDiversos = new javax.swing.JComboBox<>();
        pInternos = new javax.swing.JPanel();
        cmbInternos = new javax.swing.JComboBox<>();
        pObservacoes = new javax.swing.JPanel();
        txtObservacoes = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        pCheckout = new javax.swing.JPanel();
        lblSaida1 = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        lblPagamento = new javax.swing.JLabel();
        cbVista = new javax.swing.JCheckBox();
        cbTransferencia = new javax.swing.JCheckBox();
        cbCheque = new javax.swing.JCheckBox();
        cbCredito = new javax.swing.JCheckBox();
        cbReserva = new javax.swing.JCheckBox();
        txtEntrada1 = new org.jdesktop.swingx.JXDatePicker();
        txtID = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEnviar = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(741, 650));

        pCheckin.setBackground(new java.awt.Color(255, 255, 255));
        pCheckin.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pCheckin.setMinimumSize(new java.awt.Dimension(310, 44));
        pCheckin.setName(""); // NOI18N
        pCheckin.setPreferredSize(new java.awt.Dimension(310, 45));
        pCheckin.setLayout(null);

        lblEntrada.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEntrada.setText("Data de Entrada:");
        lblEntrada.setAlignmentY(0.0F);
        pCheckin.add(lblEntrada);
        lblEntrada.setBounds(5, 10, 94, 27);

        btnBusca1.setText("🔎");
        btnBusca1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBusca1.setBorderPainted(false);
        btnBusca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusca1ActionPerformed(evt);
            }
        });
        pCheckin.add(btnBusca1);
        btnBusca1.setBounds(263, 10, 43, 27);

        txtEntrada.setDate((new Date()));
        txtEntrada.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEntrada.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
        txtEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEntradaActionPerformed(evt);
            }
        });
        pCheckin.add(txtEntrada);
        txtEntrada.setBounds(105, 10, 150, 27);

        lblResponsavel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblResponsavel.setText("Responsável:");
        lblResponsavel.setAlignmentY(0.0F);

        txtResponsavel.setAlignmentX(0.0F);
        txtResponsavel.setAlignmentY(0.0F);
        txtResponsavel.setAutoscrolls(false);

        btnBuscaResp.setText("🔎");
        btnBuscaResp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscaResp.setBorderPainted(false);
        btnBuscaResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaRespActionPerformed(evt);
            }
        });

        lblGrupo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblGrupo.setText("<html><body>Identificação do</br> Grupo:</body></html>");
        lblGrupo.setAlignmentY(0.0F);

        txtGrupo.setAlignmentX(0.0F);
        txtGrupo.setAlignmentY(0.0F);
        txtGrupo.setAutoscrolls(false);

        btnBuscaGrup.setText("🔎");
        btnBuscaGrup.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscaGrup.setBorderPainted(false);
        btnBuscaGrup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaGrupActionPerformed(evt);
            }
        });

        lblTelefone.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTelefone.setText("Telefone:");
        lblTelefone.setAlignmentY(0.0F);

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblEmail.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEmail.setText("E-mail:");
        lblEmail.setAlignmentY(0.0F);

        txtEmail.setAlignmentX(0.0F);
        txtEmail.setAlignmentY(0.0F);
        txtEmail.setAutoscrolls(false);

        lblCategoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCategoria.setText("Categoria:");
        lblCategoria.setAlignmentY(0.0F);

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trabalho", "Lazer", "Estudo", "Retiro", "Seminário", "Outros" }));
        cmbCategoria.setSelectedIndex(-1);
        cmbCategoria.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                cmbCategoriaComponentShown(evt);
            }
        });
        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });

        lblOrientador.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblOrientador.setText("<html><body>Orientador/</br> Conferencista:</body></html>");
        lblOrientador.setAlignmentY(0.0F);

        cmbOrientador.setAlignmentX(0.0F);
        cmbOrientador.setAlignmentY(0.0F);
        cmbOrientador.setAutoscrolls(false);

        lblNPessoas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNPessoas.setText("Nº de Pessoas:");
        lblNPessoas.setAlignmentY(0.0F);

        txtNPessoas.setText("1");
        txtNPessoas.setAlignmentX(0.0F);
        txtNPessoas.setAlignmentY(0.0F);
        txtNPessoas.setAutoscrolls(false);
        txtNPessoas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNPessoasFocusLost(evt);
            }
        });
        txtNPessoas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtNPessoasMouseExited(evt);
            }
        });
        txtNPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNPessoasActionPerformed(evt);
            }
        });
        txtNPessoas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNPessoasKeyPressed(evt);
            }
        });

        lblNQuartos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNQuartos.setText("Nº de Quartos:");
        lblNQuartos.setAlignmentY(0.0F);

        txtNQuartos.setAlignmentX(0.0F);
        txtNQuartos.setAlignmentY(0.0F);
        txtNQuartos.setAutoscrolls(false);
        txtNQuartos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNQuartosActionPerformed(evt);
            }
        });

        pNormal.setBackground(new java.awt.Color(255, 255, 255));
        pNormal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Diária Integral Normal", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        pNormal.setToolTipText("");
        pNormal.setMinimumSize(new java.awt.Dimension(310, 44));
        pNormal.setName(""); // NOI18N
        pNormal.setPreferredSize(new java.awt.Dimension(310, 45));
        pNormal.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                none(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        pNormal.setLayout(null);

        cmbNormal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Normal(Sem Toalhas)", "Normal(com toalhas)", "Com uso de Multimidia", "Com uso da multimidia, internet e toalhas..(MT)" }));
        cmbNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNormalActionPerformed(evt);
            }
        });
        pNormal.add(cmbNormal);
        cmbNormal.setBounds(10, 18, 320, 27);

        pVegetariana.setBackground(new java.awt.Color(255, 255, 255));
        pVegetariana.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Diária Integral Vegetariana", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        pVegetariana.setToolTipText("");
        pVegetariana.setMinimumSize(new java.awt.Dimension(310, 44));
        pVegetariana.setName(""); // NOI18N
        pVegetariana.setPreferredSize(new java.awt.Dimension(310, 45));
        pVegetariana.setLayout(null);

        cmbVegetariana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Normal(Sem Toalhas)", "Normal(com toalhas)", "Com uso de Multimidia", "Com uso de Internet", "Com uso da Multimidia e Internet", "Com uso da multimidia, internet e toalhas..(MT)" }));
        cmbVegetariana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVegetarianaActionPerformed(evt);
            }
        });
        pVegetariana.add(cmbVegetariana);
        cmbVegetariana.setBounds(10, 18, 320, 27);

        pDiversos.setBackground(new java.awt.Color(255, 255, 255));
        pDiversos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Encontros Diversos", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        pDiversos.setToolTipText("");
        pDiversos.setMinimumSize(new java.awt.Dimension(310, 44));
        pDiversos.setName(""); // NOI18N
        pDiversos.setPreferredSize(new java.awt.Dimension(310, 45));
        pDiversos.setLayout(null);

        cmbDiversos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Econtros Externos sem refeição", "Encontros externos com refeição", "Encontros externos só com o uso do auditório", "Encontros externos com o auditório e refeição", "Diaria dos bispos-Encontro Latino americano. Completo", "Diaria dos empresarios", "Retiro das irmãs franciscanas de bonlanden", "yoga- formação. Prof Kalidas(sem toalha e quarto duplo)", "yoga- formação. Prof Kalidas(sem toalha e quarto individual)", "Especial. Instituto ecosocia(Formação...)" }));
        cmbDiversos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDiversosActionPerformed(evt);
            }
        });
        pDiversos.add(cmbDiversos);
        cmbDiversos.setBounds(10, 18, 320, 27);

        pInternos.setBackground(new java.awt.Color(255, 255, 255));
        pInternos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Encontros Internos com", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        pInternos.setToolTipText("");
        pInternos.setMinimumSize(new java.awt.Dimension(310, 44));
        pInternos.setName(""); // NOI18N
        pInternos.setPreferredSize(new java.awt.Dimension(310, 45));
        pInternos.setLayout(null);

        cmbInternos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "café da manha,cafezinho,almoço,lanche da tarde e auditório", "Interno com multimidia", "Dieta normal(Sem toalhas)", "Dieta normal(Com toalhas)", "Dieta Vegetariana(Sem toalhas)", "Dieta Vegetariana(Com toalhas)", "Diaria dos Bispos- Encontro latino americano.(Completo)", "Dieta dos Empresários", "Almoço individual (Comum) 23,00", "Almoço individual (Aniversarios)30,00", "Café da Manhã", "Jantar", "Cafezinho M e lanche da tarde 9,00 + 11,00", "espaço livre(Casa da Juventude)", "Dormir", "Uso do auditório ou Sala Yoga por externos" }));
        cmbInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbInternosActionPerformed(evt);
            }
        });
        pInternos.add(cmbInternos);
        cmbInternos.setBounds(10, 18, 320, 27);

        pObservacoes.setBackground(new java.awt.Color(255, 255, 255));
        pObservacoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observações", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        pObservacoes.setToolTipText("");
        pObservacoes.setMinimumSize(new java.awt.Dimension(310, 44));
        pObservacoes.setName(""); // NOI18N
        pObservacoes.setPreferredSize(new java.awt.Dimension(310, 45));
        pObservacoes.setLayout(null);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        txtObservacoes.setViewportView(jTextArea1);

        pObservacoes.add(txtObservacoes);
        txtObservacoes.setBounds(10, 20, 660, 50);

        pCheckout.setBackground(new java.awt.Color(255, 255, 255));
        pCheckout.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Saída", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        pCheckout.setToolTipText("");
        pCheckout.setMinimumSize(new java.awt.Dimension(310, 44));
        pCheckout.setName(""); // NOI18N
        pCheckout.setPreferredSize(new java.awt.Dimension(310, 45));
        pCheckout.setLayout(null);

        lblSaida1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSaida1.setText("Data de Saída:");
        lblSaida1.setAlignmentY(0.0F);
        pCheckout.add(lblSaida1);
        lblSaida1.setBounds(9, 17, 90, 27);

        lblValor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblValor.setText("Valor:");
        lblValor.setAlignmentY(0.0F);
        pCheckout.add(lblValor);
        lblValor.setBounds(60, 70, 40, 27);

        txtValor.setText("00.0");
        txtValor.setAlignmentX(0.0F);
        txtValor.setAlignmentY(0.0F);
        txtValor.setAutoscrolls(false);
        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });
        pCheckout.add(txtValor);
        txtValor.setBounds(100, 70, 120, 27);

        lblPagamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPagamento.setText("Pagamento:");
        lblPagamento.setAlignmentX(0.5F);
        lblPagamento.setAlignmentY(0.0F);
        pCheckout.add(lblPagamento);
        lblPagamento.setBounds(289, 17, 90, 27);

        cbVista.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbVista.setText("Vista");
        cbVista.setOpaque(false);
        cbVista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVistaActionPerformed(evt);
            }
        });
        pCheckout.add(cbVista);
        cbVista.setBounds(398, 17, 60, 27);

        cbTransferencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbTransferencia.setText("Transferência");
        cbTransferencia.setOpaque(false);
        cbTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTransferenciaActionPerformed(evt);
            }
        });
        pCheckout.add(cbTransferencia);
        cbTransferencia.setBounds(479, 17, 110, 27);

        cbCheque.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbCheque.setText("Cheque");
        cbCheque.setOpaque(false);
        cbCheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbChequeActionPerformed(evt);
            }
        });
        pCheckout.add(cbCheque);
        cbCheque.setBounds(398, 47, 70, 27);

        cbCredito.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbCredito.setText("Crédito");
        cbCredito.setOpaque(false);
        cbCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCreditoActionPerformed(evt);
            }
        });
        pCheckout.add(cbCredito);
        cbCredito.setBounds(479, 47, 110, 27);

        cbReserva.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbReserva.setText("Reserva 50%");
        cbReserva.setOpaque(false);
        cbReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbReservaActionPerformed(evt);
            }
        });
        pCheckout.add(cbReserva);
        cbReserva.setBounds(398, 84, 120, 27);

        txtEntrada1.setDate((new Date()));
        txtEntrada1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEntrada1.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
        txtEntrada1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEntrada1ActionPerformed(evt);
            }
        });
        pCheckout.add(txtEntrada1);
        txtEntrada1.setBounds(100, 17, 150, 27);

        txtID.setText(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(System.currentTimeMillis())));
        txtID.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                txtIDComponentShown(evt);
            }
        });
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAlterar.setForeground(new java.awt.Color(0, 0, 255));
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 0, 0));
        btnExcluir.setText("Excluir");

        btnEnviar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblResponsavel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(btnBuscaResp, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(pCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(lblNPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(txtNPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(lblNQuartos, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNQuartos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(pNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pVegetariana, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pDiversos, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pInternos, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblOrientador, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTelefone, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cmbCategoria, 0, 168, Short.MAX_VALUE)
                                    .addComponent(cmbOrientador, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                    .addComponent(txtEmail)
                                    .addComponent(txtGrupo, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscaGrup, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblBackground)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscaResp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNQuartos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNQuartos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addComponent(pNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscaGrup, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblOrientador, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbOrientador, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pVegetariana, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(pDiversos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(pInternos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void none(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_none
        // TODO add your handling code here:
    }//GEN-LAST:event_none

    private void cbVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbVistaActionPerformed

    private void cbTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTransferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTransferenciaActionPerformed

    private void cbChequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbChequeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbChequeActionPerformed

    private void cbCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCreditoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCreditoActionPerformed

    private void cbReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbReservaActionPerformed

    private void btnBusca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusca1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBusca1ActionPerformed

    private void btnBuscaGrupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaGrupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscaGrupActionPerformed

    private void btnBuscaRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaRespActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscaRespActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
      Limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoriaActionPerformed

    private void cmbCategoriaComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_cmbCategoriaComponentShown

    }//GEN-LAST:event_cmbCategoriaComponentShown

    private void txtEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEntradaActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_txtEntradaActionPerformed

    private void txtEntrada1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEntrada1ActionPerformed
     Calculate(); 
        
    }//GEN-LAST:event_txtEntrada1ActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtIDComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_txtIDComponentShown
      
    }//GEN-LAST:event_txtIDComponentShown

    private void cmbNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNormalActionPerformed
     Calculate();
    }//GEN-LAST:event_cmbNormalActionPerformed

    private void cmbVegetarianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVegetarianaActionPerformed
     Calculate();
    }//GEN-LAST:event_cmbVegetarianaActionPerformed

    private void cmbDiversosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDiversosActionPerformed
     Calculate();
    }//GEN-LAST:event_cmbDiversosActionPerformed

    private void cmbInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbInternosActionPerformed
     Calculate();
    }//GEN-LAST:event_cmbInternosActionPerformed

    private void txtNPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNPessoasActionPerformed

    }//GEN-LAST:event_txtNPessoasActionPerformed

    private void txtNPessoasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNPessoasFocusLost
     
    }//GEN-LAST:event_txtNPessoasFocusLost

    private void txtNPessoasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNPessoasKeyPressed
       float pessoasn = Integer.parseInt(txtNPessoas.getText());
       String pessoasn1 = txtNPessoas.getText();
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
           if(pessoasn < 1){
              JOptionPane.showMessageDialog(null, "O número de pessoas não deve ser inferior a 1");
              txtNPessoas.setText("1");
              Calculate();
           } 
        }
    }//GEN-LAST:event_txtNPessoasKeyPressed

    private void txtNPessoasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNPessoasMouseExited

    }//GEN-LAST:event_txtNPessoasMouseExited

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed

    private void txtNQuartosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNQuartosActionPerformed

        
       
    }//GEN-LAST:event_txtNQuartosActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
    
        
        try {
            String idClient = txtID.getText();
            Date dtCheckin = txtEntrada.getDate();
            Date dtCheckout = txtEntrada1.getDate();
            
            String responsavel = txtResponsavel.getText();
            String grupo = txtGrupo.getText();
            String telefone = txtTelefone.getText();
            String email = txtEmail.getText();
            String categoria = (String) cmbCategoria.getSelectedItem();
            String orientador = cmbOrientador.getText();
            String numpessoas = txtNPessoas.getText();
            String numquartos = txtNQuartos.getText();
            String diNormal = (String) cmbNormal.getSelectedItem();
            String diVegetariana = (String) cmbVegetariana.getSelectedItem();
            String enDiversos = (String) cmbDiversos.getSelectedItem();
            String enInternos = (String) cmbInternos.getSelectedItem();
            String obs = jTextArea1.getText();
            String val = txtValor.getText();
            boolean chkVista = cbVista.isSelected();
            boolean chkTransf = cbTransferencia.isSelected();
            boolean chkCheque = cbCheque.isSelected();
            boolean chkCredito = cbCredito.isSelected();
            boolean chkReserva = cbReserva.isSelected();
            
            java.sql.Date datedate = new java.sql.Date (dtCheckin.getTime());
            java.sql.Date datedate1 = new java.sql.Date (dtCheckin.getTime());
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sistemahoteleiro","root","");
            PreparedStatement ps = conn.prepareStatement("insert into cadastro(id_cliente, dt_checkin, dt_checkout, responsavel, id_grupo, telefone, email, categoria, orientador, n_pessoas, n_quartos, pnormal, pvegetariano, pdiversos, pinternos, observacoes, valor, ckbvista, ckbtransferencia, ckbcheque, ckbcredito, ckb50)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, idClient);
            ps.setDate(2, datedate);
            ps.setDate(3, datedate1);
         
            ps.setString(4,responsavel);
            ps.setString(5,grupo);
            ps.setString(6,telefone);
            ps.setString(7,email);
            ps.setString(8,categoria);
            ps.setString(9,orientador);
            ps.setString(10,numpessoas);
            ps.setString(11,numquartos);
            ps.setString(12,diNormal);
            ps.setString(13,diVegetariana);
            ps.setString(14,enDiversos);
            ps.setString(15,enInternos);
            ps.setString(16,obs);
            ps.setString(17,val);
            ps.setBoolean(18,chkVista);
            ps.setBoolean(19,chkTransf);
            ps.setBoolean(20,chkCheque);
            ps.setBoolean(21,chkCredito);
            ps.setBoolean(22,chkReserva);

            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this,"Cadastro adicionado com sucesso!!!");
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(NovoCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }//GEN-LAST:event_btnEnviarActionPerformed
        
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
            java.util.logging.Logger.getLogger(NovoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovoCadastro().setVisible(true);       
            }
        });
    }
    
    
    
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBusca1;
    private javax.swing.JButton btnBuscaGrup;
    private javax.swing.JButton btnBuscaResp;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JCheckBox cbCheque;
    private javax.swing.JCheckBox cbCredito;
    private javax.swing.JCheckBox cbReserva;
    private javax.swing.JCheckBox cbTransferencia;
    private javax.swing.JCheckBox cbVista;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbDiversos;
    private javax.swing.JComboBox<String> cmbInternos;
    private javax.swing.JComboBox<String> cmbNormal;
    private javax.swing.JTextField cmbOrientador;
    private javax.swing.JComboBox<String> cmbVegetariana;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEntrada;
    private javax.swing.JLabel lblGrupo;
    private javax.swing.JLabel lblNPessoas;
    private javax.swing.JLabel lblNQuartos;
    private javax.swing.JLabel lblOrientador;
    private javax.swing.JLabel lblPagamento;
    private javax.swing.JLabel lblResponsavel;
    private javax.swing.JLabel lblSaida1;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblValor;
    private javax.swing.JPanel pCheckin;
    private javax.swing.JPanel pCheckout;
    private javax.swing.JPanel pDiversos;
    private javax.swing.JPanel pInternos;
    private javax.swing.JPanel pNormal;
    private javax.swing.JPanel pObservacoes;
    private javax.swing.JPanel pVegetariana;
    private javax.swing.JTextField txtEmail;
    private org.jdesktop.swingx.JXDatePicker txtEntrada;
    private org.jdesktop.swingx.JXDatePicker txtEntrada1;
    private javax.swing.JTextField txtGrupo;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNPessoas;
    private javax.swing.JTextField txtNQuartos;
    private javax.swing.JScrollPane txtObservacoes;
    private javax.swing.JTextField txtResponsavel;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
