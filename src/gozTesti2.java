import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class gozTesti2 extends JFrame implements KeyListener{

    private static int x = 310,y = 32,genislik = 32,uzunluk = 32;
    private JButton[] seviyeTuslari = new JButton[12];
    private Timer z;
    private int kaymaHizi = 100;
    private int sayac1 = 0, donguMiktari = 0;
    private int tusBelirlemeSayaci;

    private JButton gizliTus = new JButton();

    gozTesti2(){

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel kare = new JLabel(new ImageIcon("Görseller\\kare.png"));
        kare.setBounds(x,y,genislik,uzunluk);

        JLabel arkaplan1 = new JLabel(new ImageIcon("Görseller\\Arkaplan6.jpg"));
        arkaplan1.setBounds(-250,-215,1866,1198);

        JLabel arkaplan2 = new JLabel(new ImageIcon("Görseller\\Arkaplan5.jpg"));
        arkaplan2.setBounds(-250,-215,1866,1198);

        JButton geriTusu = new JButton(new ImageIcon("Görseller\\kapiIkonu.png"));
        geriTusu.setContentAreaFilled(false); geriTusu.setBorderPainted(false);
        geriTusu.setToolTipText("Buradan ana menüye dönebilirsiniz");
        geriTusu.setBounds(1330,  732,  32,   32);

        JLabel durdurmaTalimati = new JLabel("Space(boþluk) tuþuna basarak durdurabilirsiniz");
        durdurmaTalimati.setBounds(533,2,300,10);

        for (int i = 0,j=0,k=0; i < 10 ; i++,j+=75) {
            seviyeTuslari[i] = new JButton(new ImageIcon("Görseller\\seviyeTusu"+(i+1)+".png"));
            seviyeTuslari[i].setBorderPainted(false); seviyeTuslari[i].setContentAreaFilled(false);
            panel.add(seviyeTuslari[i]);
            if (i<5) {
                seviyeTuslari[i].setBounds(75, 175+j, 150, 40);
            }else{
                seviyeTuslari[i].setBounds(1150,175+k,150,40);
                k+=75;
            }
            seviyeTuslari[i].setRolloverIcon(new ImageIcon("Görseller\\seviyeTusuRV"+(i+1)+".png"));
        }

        gizliTus.setBounds(-2,-2,1,1);

        panel.add(durdurmaTalimati);
        panel.add(gizliTus);
        panel.add(kare);kare.setVisible(false);
        panel.add(geriTusu);
        panel.add(arkaplan2);arkaplan2.setVisible(false);
        panel.add(arkaplan1);

        setVisible(true);

        gizliTus.addKeyListener(this);

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

        z = new Timer(kaymaHizi, e -> {
            if (x == 310) {
                sayac1++;
                x = 1030;
                kare.setBounds(x, y, genislik, uzunluk);
                repaint();
            }else{
                sayac1++;
                x = 310;
                kare.setBounds(x, y, genislik, uzunluk);
                repaint();
            }
            if (sayac1%2==0){
                y += 16;
                kare.setBounds(x, y, genislik, uzunluk);
                repaint();
            }
            if (y == 736){
                donguMiktari++;
                y = 32;
                kare.setBounds(x, y, genislik, uzunluk);
                repaint();
            }
            if (donguMiktari == 11){
                ((Timer) e.getSource()).stop();
                arkaplan1.setVisible(true);
                arkaplan2.setVisible(false);
                kare.setVisible(false);
                for (int j = 0; j < 10; j++) {
                    seviyeTuslari[j].setVisible(true);
                }
                x = 310; y = 32;
                repaint();
            }
        });

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            seviyeTuslari[i].addActionListener(e -> {
                if (finalI == 0){
                    tusBelirlemeSayaci = 0;
                }else if (finalI == 1){
                    tusBelirlemeSayaci = 1;
                }else if (finalI == 2){
                    tusBelirlemeSayaci = 2;
                }else if (finalI == 3){
                    tusBelirlemeSayaci = 3;
                }else if (finalI == 4){
                    tusBelirlemeSayaci = 4;
                }else if (finalI == 5){
                    tusBelirlemeSayaci = 5;
                }else if (finalI == 6){
                    tusBelirlemeSayaci = 6;
                }else if (finalI == 7){
                    tusBelirlemeSayaci = 7;
                }else if (finalI == 8){
                    tusBelirlemeSayaci = 8;
                }else{
                    tusBelirlemeSayaci = 9;
                }
                arkaplan1.setVisible(false);
                arkaplan2.setVisible(true);
                for (int j = 0; j < 10; j++) {
                    seviyeTuslari[j].setVisible(false);
                }
                kare.setVisible(true);
                x = 310; y = 32; genislik = 32; uzunluk = 32;
                if (tusBelirlemeSayaci == 0){
                    kaymaHizi = 1050;}else if (tusBelirlemeSayaci == 1){
                    kaymaHizi = 950;}
                else if (tusBelirlemeSayaci == 2){
                    kaymaHizi = 850;}else if (tusBelirlemeSayaci == 3){
                    kaymaHizi = 750;}
                else if (tusBelirlemeSayaci == 4){
                    kaymaHizi = 650;}else if (tusBelirlemeSayaci == 5){
                    kaymaHizi = 550;}
                else if (tusBelirlemeSayaci == 6){
                    kaymaHizi = 450;}else if (tusBelirlemeSayaci == 7){
                    kaymaHizi = 350;}
                else if (tusBelirlemeSayaci == 8){
                    kaymaHizi = 250;}else{
                    kaymaHizi = 150;}
                z.setDelay(kaymaHizi);
                z.start();
                for (int j = 0; j < 10; j++) {
                    seviyeTuslari[j].setEnabled(false);
                    seviyeTuslari[j].setVisible(false);
                }
                geriTusu.setEnabled(false);
                geriTusu.setVisible(false);
                repaint();

            });
        }

        gizliTus.addActionListener(e -> {
            z.stop();
            arkaplan1.setVisible(true);
            kare.setVisible(false);
            for (int j = 0; j < 10; j++) {
                seviyeTuslari[j].setEnabled(true);
                seviyeTuslari[j].setVisible(true);
            }
            geriTusu.setEnabled(true);
            geriTusu.setVisible(true);
        });

    }

    public void keyTyped(KeyEvent e) {

    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_SPACE){
            gizliTus.doClick();
        }
    }
    public void keyReleased(KeyEvent e) {

    }

}