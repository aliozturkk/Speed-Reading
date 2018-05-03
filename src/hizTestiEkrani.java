import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

class hizTestiEkrani extends JFrame {

    private static JButton gizliTus = new JButton();
    private static long baslangic;
    private long bitis;
    private long gecenSure;

    private int[] kelimeSayilari = {348,408,253,225,116,151,190,244,132,173,221,224,147,238,219,296,470,210,241,431,166,150,353,397,253,385,299,208,315,279};

    private static int syc = 0 ;

    private static int a = 1;

    private int n = 0;

    hizTestiEkrani() throws IOException, BadLocationException {

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);
        panel.setFocusable(true);
        panel.requestFocusInWindow();

        panel.addKeyListener(null);

        addKeyBindings(panel);

        String[] metinler = new String[30];
        for (int i = 0,j=1; i < 30; i++,j++) {
            metinler[i] = metinOkuma("Metin Belgeleri\\metin"+j+".txt");
        }

        JTextPane metinOkumaAlani   = new JTextPane(); metinOkumaAlani.setEnabled(false);
        JLabel talimatMetni               = new JLabel(new ImageIcon( "Görseller\\talimatKutucugu.jpg"));
        JLabel arkaplan             = new JLabel(new ImageIcon( "Görseller\\Arkaplan.jpg"));
        JButton geriTusu               = new JButton(new ImageIcon("Görseller\\kapiIkonu.png")); geriTusu.setContentAreaFilled(false); geriTusu.setBorderPainted(false); geriTusu.setToolTipText("Buradan ana menüye dönebilirsiniz");

        Font f = new Font("verdana",Font.BOLD,14);

        SimpleAttributeSet set = new SimpleAttributeSet();
        metinOkumaAlani.setCharacterAttributes(set,true);
        metinOkumaAlani.setEnabled(true);
        metinOkumaAlani.setEditable(false);
        metinOkumaAlani.setAutoscrolls(true);
        metinOkumaAlani.setFont(f);

        JButton[] mtnTus = new JButton[30];
        for (int i = 0; i < 30 ; i++) {
            mtnTus[i] = new JButton(new ImageIcon("Görseller\\metin"+(i+1)+".jpg"));
            mtnTus[i].setRolloverIcon(new ImageIcon("Görseller\\metin"+(i+1)+"a.jpg"));
            mtnTus[i].setContentAreaFilled(false);
            mtnTus[i].setBorderPainted(false);
        }

        int x1 = 0;
        for (int i = 0; i < 15; i++) {
            mtnTus[i].setBounds(20, 15 + x1, 90, 30);
            x1 = x1 + 49;
        }
        int x2 = 0;
        for (int i = 15; i < 30; i++) {
            mtnTus[i].setBounds(1255, 15 + x2, 90, 30);
            x2 = x2 + 49;
        }

        talimatMetni.setVisible(false);
        metinOkumaAlani.setVisible(false);

        setVisible(true);

        geriTusu.setBounds(            1284,  732,  32,   32);
        talimatMetni.setBounds(           300,   180,  750,  400);
        arkaplan.setBounds(         -250,  -215, 1866, 1198);
        metinOkumaAlani.setBounds(  300,   0,    766,  768);

        for (int i = 0; i < 30; i++) {
            panel.add(mtnTus[i]);
        }

        panel.add(gizliTus);
        panel.add(metinOkumaAlani);
        panel.add(geriTusu);
        panel.add(talimatMetni);
        panel.add(arkaplan);

        geriTusu.addActionListener(e -> new menuEkrani());
        geriTusu.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                geriTusu.setBackground(Color.white);
                geriTusu.setContentAreaFilled(true);
            }
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                geriTusu.setBackground(Color.white);
                geriTusu.setContentAreaFilled(false);
            }
        });

        gizliTus.addActionListener((ActionEvent e) -> {
            if(talimatMetni.isVisible()){
                baslangic = System.currentTimeMillis();
                talimatMetni.setVisible(false);
                metinOkumaAlani.setVisible(true);
            }else if(metinOkumaAlani.isVisible()){
                bitis = System.currentTimeMillis();
                metinOkumaAlani.setVisible(false);
                syc++;
                for (int j = 0; j < 30; j++) {
                    mtnTus[j].setEnabled(true);
                }
                geriTusu.setEnabled(true);
                gecenSure = bitis - baslangic;
                int seconds = (int) gecenSure / 1000;

                int[] sonuc = new int[30];

                try {
                    for (int i = 0; i < 30; i++) {
                        sonuc[i] = (kelimeSayilari[i] / seconds) * 60;
                    }
                    JOptionPane.showMessageDialog(null,
                            "Tebrikler okuma hýzýnýz: " + sonuc[n],
                            "Kaari - Hýzlý Okuma Programý",
                            JOptionPane.INFORMATION_MESSAGE,
                            new ImageIcon("Görseller\\saat.png"));
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,
                            "Ooo, çok hýzýlýsýn ama bu kadar olmaz!",
                            "Kaari - Hýzlý Okuma Programý",
                            JOptionPane.INFORMATION_MESSAGE,
                            new ImageIcon("Görseller\\kelle.png"));
                }
            }
        });

        for (int i = 0 ; i < 30 ; i++) {
            int finalI = i;
            int finalI1 = i;
            mtnTus[i].addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {
                    switch (finalI1) {
                        case 0:
                            n = 0;
                            break;
                        case 1:
                            n = 1;
                            break;
                        case 2:
                            n = 2;
                            break;
                        case 3:
                            n = 3;
                            break;
                        case 4:
                            n = 4;
                            break;
                        case 5:
                            n = 5;
                            break;
                        case 6:
                            n = 6;
                            break;
                        case 7:
                            n = 7;
                            break;
                        case 8:
                            n = 8;
                            break;
                        case 9:
                            n = 9;
                            break;
                        case 10:
                            n = 10;
                            break;
                        case 11:
                            n = 11;
                            break;
                        case 12:
                            n = 12;
                            break;
                        case 13:
                            n = 13;
                            break;
                        case 14:
                            n = 14;
                            break;
                        case 15:
                            n = 15;
                            break;
                        case 16:
                            n = 16;
                            break;
                        case 17:
                            n = 17;
                            break;
                        case 18:
                            n = 18;
                            break;
                        case 19:
                            n = 19;
                            break;
                        case 20:
                            n = 20;
                            break;
                        case 21:
                            n = 21;
                            break;
                        case 22:
                            n = 22;
                            break;
                        case 23:
                            n = 23;
                            break;
                        case 24:
                            n = 24;
                            break;
                        case 25:
                            n = 25;
                            break;
                        case 26:
                            n = 26;
                            break;
                        case 27:
                            n = 27;
                            break;
                        case 28:
                            n = 28;
                            break;
                        case 29:
                            n = 29;
                            break;
                    }
                }
                public void mousePressed(MouseEvent e) {
                    a = finalI+1;
                    String metin = null;
                    try {
                        metin = metinOkuma("Metin Belgeleri\\metin"+a+".txt");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    for (int j = 0; j < 30 ; j++) {
                       metinOkumaAlani.setText(metin);
                    }
                    talimatMetni.setVisible(true);
                    for (int j = 0; j < 30; j++) {
                        mtnTus[j].setEnabled(false);
                        geriTusu.setEnabled(false);
                    }
                }
                public void mouseReleased(MouseEvent e) {
                }
                public void mouseEntered(MouseEvent e) {
                }
                public void mouseExited(MouseEvent e) {
                }
            });
        }

    }

    private static void addKeyBindings(JComponent jc) {
        jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false),"");
        jc.getActionMap().put("", new AbstractAction() {
            public void actionPerformed(ActionEvent ae) {
                syc++;
                gizliTus.doClick();
            }
        });
    }

    static String metinOkuma(String s) throws IOException {
        File fr = new File(s);
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(fr)));
        String satir;
        StringBuilder metin = new StringBuilder();
        while((satir = br.readLine()) != null){
            metin.append(satir).append("\n");
        }
        return metin.toString();
    }


}