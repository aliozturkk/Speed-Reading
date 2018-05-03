import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

class dikkatTesti2 extends JFrame implements KeyListener{

    private static int yaziPuntosu = 12;
    private static int tusBelirlemeSayaci;
    private static int gecisSuresi = 1000;
    private Timer z;

    private JButton gizliTus = new JButton();
    private JButton geriTusu = new JButton(new ImageIcon("Görseller\\kapiIkonu.png"));
    private JButton[] seviyeTuslari = new JButton[10];
    private JLabel[] goruntulenecekYazilar = new JLabel[19];

    dikkatTesti2() throws IOException {

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        ArrayList<String> s = kelimeler("Metin Belgeleri\\kelimeler.txt");

        Font[] f = new Font[7];
        for (int i = 0; i < 7; i++, yaziPuntosu++) {
            f[i] = new Font("verdana",Font.BOLD, yaziPuntosu);
        }

        JLabel arkaplan = new JLabel(new ImageIcon("Görseller\\Arkaplan5.jpg"));
        arkaplan.setBounds(-250,-215,1866,1198);

        JLabel durdurmaTalimati = new JLabel("Space(boþluk) tuþuna basarak durdurabilirsiniz");
        durdurmaTalimati.setBounds(533,2,300,10);

        gizliTus.setBounds(-2,-2,1,1);

        geriTusu.setContentAreaFilled(false); geriTusu.setBorderPainted(false);
        geriTusu.setToolTipText("Buradan ana menüye dönebilirsiniz");
        geriTusu.setBounds(1330,  732,  32,   32);


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

        for (int i = 0; i < 19; i++) {
            goruntulenecekYazilar[i] = new JLabel();
        }

        gizliTus.addKeyListener(this);

        goruntulenecekYazilar[0].setBounds(325, 70,  150, 40);
        goruntulenecekYazilar[1].setBounds(450, 125, 150, 40);
        goruntulenecekYazilar[2].setBounds(720, 450, 150, 40);
        goruntulenecekYazilar[3].setBounds(900, 500, 150, 40);
        goruntulenecekYazilar[4].setBounds(450, 250, 150, 40);
        goruntulenecekYazilar[5].setBounds(500, 580, 150, 40);
        goruntulenecekYazilar[6].setBounds(700, 350, 150, 40);
        goruntulenecekYazilar[7].setBounds(800, 180, 150, 40);
        goruntulenecekYazilar[8].setBounds(350, 470, 150, 40);
        goruntulenecekYazilar[9].setBounds(600, 200, 150, 40);
        goruntulenecekYazilar[10].setBounds(212, 783, 150, 40);
        goruntulenecekYazilar[11].setBounds(700, 70,  150, 40);
        goruntulenecekYazilar[12].setBounds(900, 680, 150, 40);
        goruntulenecekYazilar[13].setBounds(500, 400, 150, 40);
        goruntulenecekYazilar[14].setBounds(325, 650, 150, 40);
        goruntulenecekYazilar[15].setBounds(850, 50, 150, 40);
        goruntulenecekYazilar[16].setBounds(500, 500, 150, 40);
        goruntulenecekYazilar[17].setBounds(700, 600, 150, 40);
        goruntulenecekYazilar[18].setBounds(870, 325, 150, 40);

        for (int i = 0,j = 0; i < 19; i++,j++) {
            if (!(j < 7)){
                j = 0;
            }
            goruntulenecekYazilar[i].setFont(f[j]);
            goruntulenecekYazilar[i].setVisible(false);
            int rastgeleSayi = (int) (Math.random() * 1001);
            goruntulenecekYazilar[i].setText(s.get(rastgeleSayi));
        }

        setVisible(true);

        for (int i = 0; i < 19; i++) {
            panel.add(goruntulenecekYazilar[i]);
        }
        panel.add(gizliTus);
        panel.add(durdurmaTalimati);
        panel.add(geriTusu);
        panel.add(arkaplan);

        ActionListener is1 = e -> {
            int rst = (int)(Math.random()*19);
            goruntulenecekYazilar[rst].setVisible(true);
            for (int i = 0; i < 19; i++) {
                if (rst == i){
                    continue;
                }
                goruntulenecekYazilar[i].setVisible(false);
            }
        };
        z = new Timer(gecisSuresi,is1);

        //Tuþlara göre hýzýn belirlendiði bölüm
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            seviyeTuslari[i].addActionListener(e -> {
                if (finalI == 0){
                    tusBelirlemeSayaci = 0;
                    gecisSuresi = 900;
                }else if (finalI == 1){
                    tusBelirlemeSayaci = 1;
                    gecisSuresi = 800;
                }else if (finalI == 2){
                    tusBelirlemeSayaci = 2;
                    gecisSuresi = 700;
                }else if (finalI == 3){
                    tusBelirlemeSayaci = 3;
                    gecisSuresi = 600;
                }else if (finalI == 4){
                    tusBelirlemeSayaci = 4;
                    gecisSuresi = 500;
                }else if (finalI == 5){
                    tusBelirlemeSayaci = 5;
                    gecisSuresi = 400;
                }else if (finalI == 6){
                    tusBelirlemeSayaci = 6;
                    gecisSuresi = 300;
                }else if (finalI == 7){
                    tusBelirlemeSayaci = 7;
                    gecisSuresi = 200;
                }else if (finalI == 8){
                    tusBelirlemeSayaci = 8;
                    gecisSuresi = 100;
                }else{
                    tusBelirlemeSayaci = 9;
                    gecisSuresi = 50;
                }
                z.setDelay(gecisSuresi);
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

        //Keylistener'a entegre ettiðimiz gizli tuþ,
        //bunun ile keylistener da oluþabilcek karmaþayý giderdik
        //bunu yapabilmek için de eylem baþladýðýnda tüm tuþlarý
        //eylemsiz hale getirdik
        gizliTus.addActionListener(e -> {
            z.stop();
            for (int i = 0; i < 19; i++) {
                goruntulenecekYazilar[i].setVisible(false);
            }
            for (int j = 0; j < 10; j++) {
                seviyeTuslari[j].setEnabled(true);
                seviyeTuslari[j].setVisible(true);
            }
            geriTusu.setEnabled(true);
            geriTusu.setVisible(true);
        });

    }

    //Dosya okuyup bir stringe yazan method
    private String metinOkuma(String s) throws IOException {
        File fr = new File(s);
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(fr),  "ISO-8859-9"));
        String satir;
        String metin = "";
        while((satir = br.readLine()) != null){
            metin = metin + satir + "\n";
        }
        return metin;
    }

    //metinOkuma methodunu kullanarak dosyadan metin okuyup, kelime kelime
    //bir diziye kaydeden method
    private ArrayList<String> kelimeler(String s) throws IOException {
        String metin = metinOkuma(s);
        String klm = "";
        ArrayList<String> dizi = new ArrayList<>();
        for (int j = 0, i = 0; j < metin.length()-1 ; j++) {
            klm = klm + metin.charAt(j);
            String bosluk = metin.charAt(j) + "";
            if (bosluk.equals(" ")) {
                dizi.add(i,klm);
                klm = "";
                i++;
            }
        }
        return dizi;
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