import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class gozTesti1 extends JFrame implements KeyListener{

    private JLabel arkaplan = new JLabel(new ImageIcon("Görseller\\Arkaplan4.jpg"));
    private JButton[] seviyeTuslari = new JButton[12];
    private JLabel[] donguResimleri = new JLabel[18];

    private Timer z;
    private int a = 1, b = 0;
    private int karelerDonguSayisi = 0;
    private int buyumeHizi = 1250;

    private JButton gizliTus = new JButton();

    gozTesti1(){

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        arkaplan.setBounds(-250,-215,1866,1198);

        JLabel etiket = new JLabel(new ImageIcon("Görseller\\ab1.jpg"));
        etiket.setBounds(0,368,500,200);

        JLabel durdurmaTalimati = new JLabel("Space(boþluk) tuþuna basarak durdurabilirsiniz");
        durdurmaTalimati.setBounds(10,2,300,15);

        JButton geriTusu = new JButton(new ImageIcon("Görseller\\kapiIkonu.png"));
        geriTusu.setContentAreaFilled(false); geriTusu.setBorderPainted(false);
        geriTusu.setToolTipText("Buradan ana menüye dönebilirsiniz");
        geriTusu.setBounds(1330,  732,  32,   32);

        gizliTus.setBounds(-2,-2,1,1);

        for (int i = 0,j=0,k=0; i < 10 ; i++,j+=75) {
            seviyeTuslari[i] = new JButton(new ImageIcon("Görseller\\seviyeTusu"+(i+1)+".png"));
            seviyeTuslari[i].setContentAreaFilled(false);
            seviyeTuslari[i].setBorderPainted(false);

            panel.add(seviyeTuslari[i]);
            if (i<5) {
                seviyeTuslari[i].setBounds(75, 175+j, 150, 40);
            }else{
                seviyeTuslari[i].setBounds(1150,175+k,150,40);
                k+=75;
            }
            seviyeTuslari[i].setRolloverIcon(new ImageIcon("Görseller\\seviyeTusuRV"+(i+1)+".png"));
        }

        for (int i = 0; i < 18; i++) {
            donguResimleri[i] = new JLabel(new ImageIcon("Görseller\\kareler"+(i+1)+".jpg"));
            donguResimleri[i].setBounds(-250,-215,1866,1198);
            panel.add(donguResimleri[i]);
            donguResimleri[i].setVisible(false);
        }

        for (int i = 0; i < 10 ; i++) {
            panel.add(panel.add(seviyeTuslari[i]));
        }

        panel.add(durdurmaTalimati);
        panel.add(gizliTus);
        panel.add(geriTusu);
        panel.add(arkaplan);

        setVisible(true);

        gizliTus.addKeyListener(this);

        //Döngüyü oluþturduðumuz zamanlayýcý ve onun eylemi
        z = new Timer(1000, e -> {
            if (a<18) {
                donguResimleri[a].setVisible(true);
                donguResimleri[b].setVisible(false);
                a++;
                b++;
            }else{
                karelerDonguSayisi++;
                a = 1;
                b = 0;
            }
            if (karelerDonguSayisi == 5){
                ((Timer) e.getSource()).stop();
                arkaplan.setVisible(true);
                for (int j = 0; j < 10; j++) {
                    seviyeTuslari[j].setEnabled(true);
                    seviyeTuslari[j].setVisible(true);
                }
                geriTusu.setEnabled(true);
                geriTusu.setVisible(true);
                donguResimleri[17].setVisible(false);

            }
        });

        //Tuþ seçimine göre hýz ayarý yapan bölüm
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            seviyeTuslari[i].addActionListener(e -> {
                for (int i1 = 0; i1 < 10; i1++) {
                    seviyeTuslari[i1].setVisible(false);
                }
                donguResimleri[0].setVisible(true);
                arkaplan.setVisible(false);
                if (finalI == 0){
                    buyumeHizi = 1050;
                }else if (finalI == 1){
                    buyumeHizi = 950;
                }else if (finalI == 2){
                    buyumeHizi = 850;
                }else if (finalI == 3){
                    buyumeHizi = 750;
                }else if (finalI == 4){
                    buyumeHizi = 650;
                }else if (finalI == 5){
                    buyumeHizi = 550;
                }else if (finalI == 6){
                    buyumeHizi = 450;
                }else if (finalI == 7){
                    buyumeHizi = 350;
                }else if (finalI == 8){
                    buyumeHizi = 250;
                }else{
                    buyumeHizi = 150;
                }
                z.setDelay(buyumeHizi);
                z.start();

                for (int j = 0; j < 10; j++) {
                    seviyeTuslari[j].setEnabled(false);
                    seviyeTuslari[j].setVisible(false);
                }
                geriTusu.setEnabled(false);
                geriTusu.setVisible(false);

            });
        }

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

        //Space tuþuna basýldýðýnda durdumayý saðlayan gizli tuþ
        //Keylisteneri gizli bir tuþa entegre ederek karýþýklýðý
        //gidermeyi amaçladýk
        gizliTus.addActionListener(e -> {
            z.stop();
            arkaplan.setVisible(true);
            for (int i = 0; i < 18; i++) {
                donguResimleri[i].setVisible(false);
            }
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