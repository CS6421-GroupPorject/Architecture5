package simulator;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ControlPanel extends javax.swing.JFrame {
    
    boolean running;
    URL UrlON = getClass().getResource("ON.jpg");   
    URL UrlOFF = getClass().getResource("OFF.jpg"); 
    ImageIcon iconON = new ImageIcon(UrlON);
    ImageIcon iconOFF = new ImageIcon(UrlOFF);
    String strSwitches;
    String strCardReader;
    //String sInst = "";
    private RomLoader mBootLoader;
    public static int[] a= new int[10];
    public static int counter=0; 
    public static int counterInputNum = 1;
    
    
    // These Registers variables are instantited from Register Class
    // and used as Instruction Register, OPCODE register and ADDR register
    // other Registers (General Purpose Registers, Index Registers) are created on the GUI
    Register IR, OPCODE, ADDR, PC, CC,COUNT;
    
    // This variables are instantited from File class
    // and used to store Register File and Index Register File
    File XF, RF, I, T;
    
    public static Memory MEMORY;
    ALU ALU;
    
    
    Instruction instructionThread = new Instruction(this); // thread for running a program
    Instruction programInstructionThread = new Instruction(this);
    Instruction singleInstructionThread = new Instruction(this); // thread for running a single instruction
    
    /**
     * instructions running type
     * 1 - without pause
     * 2 - pause between instructions
     * 3 - pause between micro steps
     * 4 - pause for some time (Haven't implement yet)
     * 5 - single instruction mode
     */
    int runType;
               
    public ControlPanel() {
        
        initComponents();
        
        
        lblONOFF.setIcon(iconOFF);
        OPCODE = new Register("OPCODE", 6, false);
        ADDR = new Register("ADDR", 8, false);
        IR = new Register("IR", 20, false);
        PC = new Register("PC", 13, false);
        CC = new Register("CC", 4, false);
        COUNT = new Register("COUNT", 5, false);

        MEMORY = new Memory();
        ALU = new ALU();
        XF =  new File();
        RF = new File();
        I = new File();
        T = new File();
        mBootLoader=new RomLoader(this);
    
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jFrame3 = new javax.swing.JFrame();
        jFrame4 = new javax.swing.JFrame();
        jFrame5 = new javax.swing.JFrame();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        btnIPL = new javax.swing.JToggleButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        GPR0 = new simulator.Register("R0", 20, true);
        GPR1 = new simulator.Register("R1", 20, true);
        GPR2 = new simulator.Register("R2", 20, true);
        GPR3 = new simulator.Register("R3", 20, true);
        IX1 = new simulator.Register("IX1", 13, true);
        IX2 = new simulator.Register("IX2", 13, true);
        IX3 = new simulator.Register("IX3", 13, true);
        MBR = new simulator.Register("MBR", 20, true);
        MAR = new simulator.Register("MAR", 20, true);
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jRadioButton15 = new javax.swing.JRadioButton();
        jRadioButton16 = new javax.swing.JRadioButton();
        jRadioButton17 = new javax.swing.JRadioButton();
        jRadioButton18 = new javax.swing.JRadioButton();
        jRadioButton19 = new javax.swing.JRadioButton();
        jRadioButton20 = new javax.swing.JRadioButton();
        btnSingleStep = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnDeposit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtMemoryAddr = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMemoryValue = new javax.swing.JTextField();
        lblONOFF = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jMessages = new javax.swing.JTextArea();
        label = new javax.swing.JLabel();
        lblOpcode = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblPC = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblCC = new javax.swing.JLabel();
        btnClr = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        btnStepRun = new javax.swing.JButton();
        btnMicroRun = new javax.swing.JButton();
        KEYBORD = new simulator.Input();
        PRINTER = new simulator.Output();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame4Layout = new javax.swing.GroupLayout(jFrame4.getContentPane());
        jFrame4.getContentPane().setLayout(jFrame4Layout);
        jFrame4Layout.setHorizontalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame4Layout.setVerticalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame5Layout = new javax.swing.GroupLayout(jFrame5.getContentPane());
        jFrame5.getContentPane().setLayout(jFrame5Layout);
        jFrame5Layout.setHorizontalGroup(
            jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame5Layout.setVerticalGroup(
            jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnIPL.setText("IPL");
        btnIPL.setToolTipText("");
        btnIPL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIPLActionPerformed(evt);
            }
        });

        GPR0.setBackground(java.awt.Color.lightGray);
        GPR0.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        GPR0.setToolTipText("");
        GPR0.setBitLength(20);
        GPR0.setOpaque(false);
        GPR0.setRegName("R0");

        GPR1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        GPR1.setRegName("R1");

        GPR2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        GPR2.setRegName("R2");

        GPR3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        GPR3.setRegName("R3");

        IX1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        IX1.setRegName("IX1");

        IX2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        IX2.setRegName("IX2");

        IX3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        IX3.setRegName("IX3");

        MBR.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        MBR.setRegName("MBR");

        MAR.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        MAR.setRegName("MAR");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setToolTipText("");
        jPanel1.setName("aa"); // NOI18N

        jRadioButton1.setText("1");
        jRadioButton1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jRadioButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jRadioButton2.setText("2");
        jRadioButton2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jRadioButton3.setText("3");
        jRadioButton3.setToolTipText("");
        jRadioButton3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jRadioButton4.setText("4");
        jRadioButton4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jRadioButton5.setText("5");
        jRadioButton5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jRadioButton6.setText("6");
        jRadioButton6.setToolTipText("");
        jRadioButton6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jRadioButton7.setText("7");
        jRadioButton7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jRadioButton8.setText("8");
        jRadioButton8.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jRadioButton9.setText("9");
        jRadioButton9.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jRadioButton10.setText("10");
        jRadioButton10.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jRadioButton11.setText("11");
        jRadioButton11.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jRadioButton12.setText("12");
        jRadioButton12.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jRadioButton13.setText("13");
        jRadioButton13.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jRadioButton14.setText("14");
        jRadioButton14.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jRadioButton15.setText("15");
        jRadioButton15.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jRadioButton16.setText("16");
        jRadioButton16.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jRadioButton17.setText("17");
        jRadioButton17.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jRadioButton18.setText("18");
        jRadioButton18.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jRadioButton19.setText("19");
        jRadioButton19.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jRadioButton20.setText("20");
        jRadioButton20.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        btnSingleStep.setText("Run Single Step");
        btnSingleStep.setToolTipText("Click here to run this instruction by micro steps");
        btnSingleStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSingleStepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14)
                        .addComponent(jRadioButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnSingleStep, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton9)
                    .addComponent(jRadioButton10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRadioButton11)
                    .addComponent(jRadioButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton13)
                    .addComponent(jRadioButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton16)
                    .addComponent(jRadioButton17)
                    .addComponent(jRadioButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton19)
                    .addComponent(jRadioButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(btnSingleStep))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnDeposit.setText("Deposit on Memory");
        btnDeposit.setToolTipText("");
        btnDeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositActionPerformed(evt);
            }
        });

        jLabel1.setText(" Address");

        jLabel2.setText("Value");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtMemoryAddr, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtMemoryValue, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMemoryAddr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMemoryValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeposit)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jMessages.setEditable(false);
        jMessages.setColumns(10);
        jMessages.setRows(5);
        jScrollPane1.setViewportView(jMessages);

        label.setBackground(new java.awt.Color(130, 125, 204));
        label.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        label.setText("FIELD ENGINEER'S CONSOLE");

        lblOpcode.setText("000000");

        jLabel13.setText("OPCODE:");

        jLabel14.setText("PC:");

        lblPC.setText("000000");

        jLabel15.setText("CC:");

        lblCC.setText("000000");

        btnClr.setText("Clear");
        btnClr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblOpcode))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPC))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCC)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClr))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnClr)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lblOpcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPC, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCC, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(103, 103, 103))))
        );

        label1.setBackground(new java.awt.Color(130, 125, 204));
        label1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        label1.setText("REGISTERS");

        label2.setBackground(new java.awt.Color(130, 125, 204));
        label2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        label2.setText("Press IPL to run");

        btnStepRun.setText("<html>Test Instructions <br>\nStep by Step </html>"); // NOI18N
        btnStepRun.setToolTipText("Click here to run one instruction each time");
        btnStepRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStepRunActionPerformed(evt);
            }
        });

        btnMicroRun.setText("<html>Test Instructions <br> In Micro Step </html>");
        btnMicroRun.setToolTipText("Click here to run one micro step each time ");
        btnMicroRun.setActionCommand("microRun");
        btnMicroRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMicroRunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(MAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(GPR0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GPR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GPR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GPR3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IX2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IX3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PRINTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(MBR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(254, 254, 254)
                                .addComponent(label1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(KEYBORD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIPL, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblONOFF, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStepRun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(btnMicroRun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnIPL, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnMicroRun, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnStepRun, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(lblONOFF, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(label1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(GPR0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(GPR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8)
                                        .addComponent(GPR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(GPR3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(IX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)
                                        .addComponent(IX2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(IX3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MBR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(KEYBORD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PRINTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(391, 391, 391))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This action when btnDeposit button clicked is used to store values directly into MEMORY(address accept 0-511,or bigger than 1024)
     * This makes easier to test
     * TextBoxes take address and value as decimal
     * Function converts these values to binary string and pads with 0s to until to word size (20 bit)
     * Then, these values is set in the MEMORY.
     */
   private void btnDepositActionPerformed(java.awt.event.ActionEvent evt) {                                           

        String sVal, sAddr;       
        sVal = Long.toBinaryString(Integer.parseInt(txtMemoryValue.getText()));
        sVal = String.format("%0" + (20-sVal.length())+ "d", 0) + sVal;
        
      	// put invalidate warning on ControlPanel for the Only-BootLoader-Access Mem address
        int sAddrNum=Integer.parseInt(txtMemoryAddr.getText());
        if (sAddrNum<512||sAddrNum>=1024) {
			
        	sAddr = Long.toBinaryString(Integer.parseInt(txtMemoryAddr.getText()));
        	sAddr = String.format("%0" + (20-sAddr.length())+ "d", 0) + sAddr;
        	
        	MEMORY.setDirect(sVal,sAddr);
        	txtMemoryAddr.setText("");
        	txtMemoryValue.setText("");
		}
        else {
        	jMessages.append("Invalid address reserved for BIOS,choose a smaller one!\n");
		      
		}
     
    }                                          

//    /**
//     * start executing  from the first instructions read from the file
//     * @param pfileName
//     * @throws java.lang.InterruptedException
//     */
//    public void executeFile(String pfileName) throws InterruptedException {
//    	jMessages.append("Boot Completed! Loaded "+ getmBootLoader().getInstructCount()+" instructions from file "+pfileName+"\n");
//    	for (int i = 0; i <getmBootLoader().getInstructCount() && running ; i++) {
//            String sAddr;
//            sAddr = Long.toBinaryString(512+i);
//            sAddr = String.format("%0" + (20-sAddr.length())+ "d", 0) + sAddr;
//            
//            getMAR().set(sAddr);
//            getMBR().set(MEMORY.get(getMAR().get()));
//            strSwitches=MEMORY.get(getMAR().get());
//            executeOneInst();
//            
//            // wait until the thread in executeOneInst() is finished or pause
//            while(!instructionThread.isFinished && instructionThread.isRunning) {    
//                Thread.sleep(10);
//            }
//            
//        }
//    	stopRunning("Program running Completed!");
//    }
    
    /**
     * stop the process from running state
     * @param stop runing reason to be displayed
     */
    public void stopRunning(String msg) {
    	
    	this.running = false;
        lblONOFF.setIcon(iconOFF);
        jMessages.append("Stop running:"+msg+"\n");
        btnStepRun.setText("<html>Test Instructions <br> Step by Step </html>");
        btnMicroRun.setText("<html>Test Instructions <br> in Micro Step </html>");
    }
    
    
    /**
     * start booting from virtual card(file specified)
     * @param start runing details to be displayed
     */
    public void startRunning(String msg){
    	this.running = true;
    	lblONOFF.setIcon(iconON); 
    	jMessages.append("Booting from:"+msg+"\n");
    	
    }
    
     /**
     * This action when btnIPL button is clicked starts the Simulator
     * The rest of the function is left for the later phases.
     */
    private void btnIPLActionPerformed(java.awt.event.ActionEvent evt) {                                       
        
        String sVal, sData;
        strCardReader= "program1.txt";
        runType = 1;    // run without pause
        sVal = Long.toBinaryString(5);
        sVal = String.format("%0" + (20-sVal.length())+ "d", 0) + sVal;
        sData = Long.toBinaryString(150);
        sData = String.format("%0" + (20-sData.length())+ "d", 0) + sData;
        MEMORY.setDirect(sVal, sData);
        
        sVal = Long.toBinaryString(100);
        sVal = String.format("%0" + (20-sVal.length())+ "d", 0) + sVal;
        sData = Long.toBinaryString(151);
        sData = String.format("%0" + (20-sData.length())+ "d", 0) + sData;
        MEMORY.setDirect(sVal, sData);
        
        sVal = Long.toBinaryString(0);
        sVal = String.format("%0" + (20-sVal.length())+ "d", 0) + sVal;
        sData = Long.toBinaryString(200);
        sData = String.format("%0" + (20-sData.length())+ "d", 0) + sData;
        MEMORY.setDirect(sVal, sData);
        
        sVal = Long.toBinaryString(528);
        sVal = String.format("%0" + (20-sVal.length())+ "d", 0) + sVal;
        sData = Long.toBinaryString(201);
        sData = String.format("%0" + (20-sData.length())+ "d", 0) + sData;
        MEMORY.setDirect(sVal, sData);
        
        sVal = Long.toBinaryString(545);
        sVal = String.format("%0" + (20-sVal.length())+ "d", 0) + sVal;
        sData = Long.toBinaryString(202);
        sData = String.format("%0" + (20-sData.length())+ "d", 0) + sData;
        MEMORY.setDirect(sVal, sData);
        
        sVal = Long.toBinaryString(535);
        sVal = String.format("%0" + (20-sVal.length())+ "d", 0) + sVal;
        sData = Long.toBinaryString(203);
        sData = String.format("%0" + (20-sData.length())+ "d", 0) + sData;
        MEMORY.setDirect(sVal, sData);
        
        
        IX3.set(Long.toBinaryString(511));
        
        if (this.running) {
          //stop running the bootloader if it's reading file,or stop the processor if it's executing instructions
            getmBootLoader().stopRunning("Turn off by user.");
            
        }
        else {
        	try {                        
			getmBootLoader().readCard(strCardReader);
				
			} catch (Exception e) {
				stopRunning("wrong instruction error:"+e.toString());
			}
        }
    }                                      


    /**
     * This action when btnSingleStep button is clicked runs the instruction which 
     * is set by switches (radio button
     * After switch values are read, Instruction Register is set with this instruction to be executed
     * Then, instruction is decoded, and related function is called.
     */    
    private void btnSingleStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSingleStepActionPerformed
        
               
        runType = 5; // single instruction mode
        if (!singleInstructionThread.isStarted) {
            singleInstructionThread = new Instruction(this);
            strSwitches = GetSwitchValues();
            singleInstructionThread.start();

            //  wait until the thread in executeOneInst() is finished or pause
//            while(!instructionThread.isFinished && instructionThread.isRunning) {    
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
        }
        else {
            if (!singleInstructionThread.isRunning) {
                singleInstructionThread.resume();
                singleInstructionThread.isRunning = true;
            }
            else {
                jMessages.append("Error: Cannot continue!\nThread is running already");
            }
        }
        
     // lblPC.setText(String.format("%s", Integer.parseInt(PC.get(),2)));
    }//GEN-LAST:event_btnSingleStepActionPerformed

    /**
     * This action when Auto Run button is clicked starts the Simulator in test mode
     * It will run one instruction each time when clicking this button
     */
    private void btnStepRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStepRunActionPerformed
        
        runType = 2;
        if (!instructionThread.isStarted) {
            String sVal, sData;
            strCardReader= "program2.txt";
            
            sVal = Long.toBinaryString(33);
            sVal = String.format("%0" + (20-sVal.length())+ "d", 0) + sVal;
            sData = Long.toBinaryString(55);
            sData = String.format("%0" + (20-sData.length())+ "d", 0) + sData;

            MEMORY.setDirect(sVal, sData);
            
             sVal = Long.toBinaryString(176);
            sVal = String.format("%0" + (20-sVal.length())+ "d", 0) + sVal;
            sData = Long.toBinaryString(158);
            sData = String.format("%0" + (20-sData.length())+ "d", 0) + sData;

            MEMORY.setDirect(sVal, sData);
            
             sVal = Long.toBinaryString(45);
            sVal = String.format("%0" + (20-sVal.length())+ "d", 0) + sVal;
            sData = Long.toBinaryString(176);
            sData = String.format("%0" + (20-sData.length())+ "d", 0) + sData;

            MEMORY.setDirect(sVal, sData);
            
            IX1.set(Long.toBinaryString(264));

    //        sVal = Long.toBinaryString(40);
    //        sVal = String.format("%0" + (20-sVal.length())+ "d", 0) + sVal;
    //        sData = Long.toBinaryString();
    //        sData = String.format("%0" + (20-sVal.length())+ "d", 0) + sVal;
          //  IX1.set(Long.toBinaryString(314));
            
                    try {

                            getmBootLoader().readCard(strCardReader);

                            } catch (Exception e) {
                                    stopRunning("wrong instruction error:"+e.toString());
                            }
            
        }
        else {
            if (!instructionThread.isRunning) {
                instructionThread.resume();
                instructionThread.isRunning = true;
            }
            else {
                jMessages.append("Error: Cannot continue! Thread is running already\n");
            }
        }
    }//GEN-LAST:event_btnStepRunActionPerformed

    /**
     * This action when Auto Run button is clicked starts the Simulator in test mode
     * It will run one micro step each time when clicking this button
     */
    private void btnMicroRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMicroRunActionPerformed
        
        runType = 3;    
        if (!instructionThread.isStarted) {
            String sVal, sData;
            strCardReader= "program2.txt";
            
            sVal = Long.toBinaryString(5);
            sVal = String.format("%0" + (20-sVal.length())+ "d", 0) + sVal;
            sData = Long.toBinaryString(100);
            sData = String.format("%0" + (20-sData.length())+ "d", 0) + sData;

            MEMORY.setDirect(sVal, sData);

    //        sVal = Long.toBinaryString(40);
    //        sVal = String.format("%0" + (20-sVal.length())+ "d", 0) + sVal;
    //        sData = Long.toBinaryString();
    //        sData = String.format("%0" + (20-sVal.length())+ "d", 0) + sVal;
            IX1.set(Long.toBinaryString(314));
            
                    try {

                            getmBootLoader().readCard(strCardReader);

                            } catch (Exception e) {
                                    stopRunning("wrong instruction error:"+e.toString());
                            }
            
        }
        else {
            if (!instructionThread.isRunning) {
                instructionThread.resume();
                instructionThread.isRunning = true;
            }
            else {
                jMessages.append("Error: Cannot continue! Thread is running already\n");
            }
        }
    }//GEN-LAST:event_btnMicroRunActionPerformed

    private void btnClrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClrActionPerformed
      jMessages.setText("");
    }//GEN-LAST:event_btnClrActionPerformed
     
    
//    private void executeOneInst(){
//        
//        instructionThread = new Instruction(this);
//        instructionThread.isRunning = true;
//        
//        if(runType != 5){
//            instructionThread.setInstructionNum(getmBootLoader().getInstructCount());
//        }
//        
//        /* set the value of parameters in instructionThread */
//        
//        instructionThread.setXF(XF);
//        instructionThread.setRF(RF);
//        instructionThread.setI(I);
//        instructionThread.setT(T);
//        instructionThread.setMEMORY(MEMORY);
//        instructionThread.setALU(ALU);
//        instructionThread.setIR(IR);
//        instructionThread.setOPCODE(OPCODE);
//        instructionThread.setADDR(ADDR);
//        instructionThread.setCC(CC);
//        instructionThread.setPC(PC);
//        instructionThread.setMAR(getMAR());
//        instructionThread.setMBR(getMBR());
//        instructionThread.setIX1(getIX1());
//        instructionThread.setIX2(getIX2());
//        instructionThread.setIX3(getIX3());
//        instructionThread.setGPR0(getGPR0());
//        instructionThread.setGPR1(getGPR1());
//        instructionThread.setGPR2(getGPR2());       
//        instructionThread.setGPR3(getGPR3());
//        instructionThread.setStrSwitches(strSwitches);
//            
//        instructionThread.start();
//            
//    }
    
      
    /**
     * This function gets the the input by reading radio button values
     * @return all values in a binary string
     */
    public String GetSwitchValues() {
        
        strSwitches = "";
        
        strSwitches += jRadioButton1.isSelected() ? "1" : "0";
        strSwitches += jRadioButton2.isSelected() ? "1" : "0";
        strSwitches += jRadioButton3.isSelected() ? "1" : "0";
        strSwitches += jRadioButton4.isSelected() ? "1" : "0";
        strSwitches += jRadioButton5.isSelected() ? "1" : "0";
        strSwitches += jRadioButton6.isSelected() ? "1" : "0";
        strSwitches += jRadioButton7.isSelected() ? "1" : "0";
        strSwitches += jRadioButton8.isSelected() ? "1" : "0";
        strSwitches += jRadioButton9.isSelected() ? "1" : "0";
        strSwitches += jRadioButton10.isSelected() ? "1" : "0";
        strSwitches += jRadioButton11.isSelected() ? "1" : "0";
        strSwitches += jRadioButton12.isSelected() ? "1" : "0";
        strSwitches += jRadioButton13.isSelected() ? "1" : "0";
        strSwitches += jRadioButton14.isSelected() ? "1" : "0";
        strSwitches += jRadioButton15.isSelected() ? "1" : "0";
        strSwitches += jRadioButton16.isSelected() ? "1" : "0";
        strSwitches += jRadioButton17.isSelected() ? "1" : "0";
        strSwitches += jRadioButton18.isSelected() ? "1" : "0";
        strSwitches += jRadioButton19.isSelected() ? "1" : "0";
        strSwitches += jRadioButton20.isSelected() ? "1" : "0";
        
        return strSwitches;
    }
     
 
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
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
       /* Create and display the form */
     //   SwingUtilities.invokeLater(new Runnable() {
               
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControlPanel().setVisible(true);
            }
        });
        
    }
    
  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private simulator.Register GPR0;
    private simulator.Register GPR1;
    private simulator.Register GPR2;
    private simulator.Register GPR3;
    private simulator.Register IX1;
    private simulator.Register IX2;
    private simulator.Register IX3;
    private simulator.Input KEYBORD;
    private simulator.Register MAR;
    private simulator.Register MBR;
    private simulator.Output PRINTER;
    private javax.swing.JButton btnClr;
    private javax.swing.JButton btnDeposit;
    private javax.swing.JToggleButton btnIPL;
    public static javax.swing.JButton btnMicroRun;
    public static javax.swing.JButton btnSingleStep;
    public static javax.swing.JButton btnStepRun;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JFrame jFrame4;
    private javax.swing.JFrame jFrame5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JTextArea jMessages;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton15;
    private javax.swing.JRadioButton jRadioButton16;
    private javax.swing.JRadioButton jRadioButton17;
    private javax.swing.JRadioButton jRadioButton18;
    private javax.swing.JRadioButton jRadioButton19;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton20;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    public static javax.swing.JLabel lblCC;
    private javax.swing.JLabel lblONOFF;
    private javax.swing.JLabel lblOpcode;
    public static javax.swing.JLabel lblPC;
    private javax.swing.JTextField txtMemoryAddr;
    private javax.swing.JTextField txtMemoryValue;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the lblOpcode
     */
    public javax.swing.JLabel getLblOpcode() {
        return lblOpcode;
    }

    /**
     * @param lblOpcode the lblOpcode to set
     */
    public void setLblOpcode(javax.swing.JLabel lblOpcode) {
        this.lblOpcode = lblOpcode;
    }

    /**
     * @return the mBootLoader
     */
    public RomLoader getmBootLoader() {
        return mBootLoader;
    }

    /**
     * @param mBootLoader the mBootLoader to set
     */
    public void setmBootLoader(RomLoader mBootLoader) {
        this.mBootLoader = mBootLoader;
    }

    /**
     * @return the GPR0
     */
    public simulator.Register getGPR0() {
        return GPR0;
    }

    /**
     * @param GPR0 the GPR0 to set
     */
    public void setGPR0(simulator.Register GPR0) {
        this.GPR0 = GPR0;
    }

    /**
     * @return the GPR1
     */
    public simulator.Register getGPR1() {
        return GPR1;
    }

    /**
     * @param GPR1 the GPR1 to set
     */
    public void setGPR1(simulator.Register GPR1) {
        this.GPR1 = GPR1;
    }

    /**
     * @return the GPR2
     */
    public simulator.Register getGPR2() {
        return GPR2;
    }

    /**
     * @param GPR2 the GPR2 to set
     */
    public void setGPR2(simulator.Register GPR2) {
        this.GPR2 = GPR2;
    }

    /**
     * @return the GPR3
     */
    public simulator.Register getGPR3() {
        return GPR3;
    }

    /**
     * @param GPR3 the GPR3 to set
     */
    public void setGPR3(simulator.Register GPR3) {
        this.GPR3 = GPR3;
    }

    /**
     * @return the IX1
     */
    public simulator.Register getIX1() {
        return IX1;
    }

    /**
     * @param IX1 the IX1 to set
     */
    public void setIX1(simulator.Register IX1) {
        this.IX1 = IX1;
    }

    /**
     * @return the IX2
     */
    public simulator.Register getIX2() {
        return IX2;
    }

    /**
     * @param IX2 the IX2 to set
     */
    public void setIX2(simulator.Register IX2) {
        this.IX2 = IX2;
    }

    /**
     * @return the IX3
     */
    public simulator.Register getIX3() {
        return IX3;
    }

    /**
     * @param IX3 the IX3 to set
     */
    public void setIX3(simulator.Register IX3) {
        this.IX3 = IX3;
    }

    /**
     * @return the MAR
     */
    public simulator.Register getMAR() {
        return MAR;
    }

    /**
     * @param MAR the MAR to set
     */
    public void setMAR(simulator.Register MAR) {
        this.MAR = MAR;
    }

    /**
     * @return the MBR
     */
    public simulator.Register getMBR() {
        return MBR;
    }

    /**
     * @param MBR the MBR to set
     */
    public void setMBR(simulator.Register MBR) {
        this.MBR = MBR;
    }
    
     /**
     * @return the KEYBORD
     */
    public simulator.Input getKEYBORD() {
        return KEYBORD;
    }

    /**
     * @param KEYBORD the KEYBORD to set
     */
    public void setKEYBORD(simulator.Input KEYBORD) {
        this.KEYBORD = KEYBORD;
    }
    
    /**
     * @return the PRINTER
     */
    public simulator.Output getPRINTER() {
        return PRINTER;
    }

    /**
     * @param PRINTER the PRINTER to set
     */
    public void setPRINTER(simulator.Output PRINTER) {
        this.PRINTER = PRINTER;
    }
}
