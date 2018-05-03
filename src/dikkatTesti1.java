
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

class dikkatTesti1 extends JFrame {

    private JButton dogrulamaTusu = new JButton(new ImageIcon("Görseller\\dogrulamaTusu.png"));
    private JTextField yaziAlani = new JTextField();
    private ArrayList<String> kelimeListesi = new ArrayList<>();
    private ArrayList<String> sayiListesi = new ArrayList<>();
    private static String goruntulenenDeger = "";
    private static int secenekBelirlemeSayaci = 0;
    private static int secenekBelirlemeSayaci2 = 0;
    private static int hataBelirlemeSayaci = 0;
    private static int gorunmeSuresi = 1000;
    private static int rastgeleIndis = (int) (Math.random() * 1001);
    private Timer z;
    private Font f = new Font("verdana",Font.BOLD,20);
    private static int skor;

    dikkatTesti1() throws IOException {

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        kelimeListesi   = kelimeler("Metin Belgeleri\\kelimeler.txt");
        sayiListesi     = kelimeler("Metin Belgeleri\\sayilar.txt");

        if (secenekBelirlemeSayaci == 1){
            goruntulenenDeger = kelimeListesi.get(rastgeleIndis);
        }else {
            goruntulenenDeger = sayiListesi.get(rastgeleIndis);
        }

        JLabel arkaplan = new JLabel(new ImageIcon("Görseller\\Arkaplan3.jpg"));
        arkaplan.setBounds(-250,-215,1866,1198);

        JButton geriTusu = new JButton(new ImageIcon("Görseller\\kapiIkonu.png"));
        geriTusu.setContentAreaFilled(false); geriTusu.setBorderPainted(false);
        geriTusu.setToolTipText("Buradan ana menüye dönebilirsiniz");
        geriTusu.setBounds(1330,  732,  32,   32);

        JButton kelimeSecenegi = new JButton(new ImageIcon("Görseller\\kelimeTusu.png"));
        kelimeSecenegi.setBounds(470,255,200,40);
        kelimeSecenegi.setContentAreaFilled(false);
        kelimeSecenegi.setBorderPainted(false);
        kelimeSecenegi.setRolloverIcon(new ImageIcon("Görseller\\kelimeTusuRV.png"));

        JButton sayiSecenegi = new JButton(new ImageIcon("Görseller\\sayiTusu.png"));
        sayiSecenegi.setBounds(690,255,200,40);
        sayiSecenegi.setContentAreaFilled(false);
        sayiSecenegi.setBorderPainted(false);
        sayiSecenegi.setRolloverIcon(new ImageIcon("Görseller\\sayiTusuRV.png"));

        JLabel sayilar = new JLabel(sayiListesi.get(rastgeleIndis));
        sayilar.setBounds(583,360, 200, 40);
        sayilar.setHorizontalAlignment(SwingConstants.CENTER);
        sayilar.setFont(f);

        JLabel puanYazi = new JLabel(new ImageIcon("Görseller\\puanEtiketi.png"));
        puanYazi.setBounds(1250,20,100,40);
        JLabel puanYazi2 = new JLabel(new ImageIcon("Görseller\\puanArkaplan.png"));
        puanYazi2.setBounds(1250,60,100,40);

        JLabel puan = new JLabel();
        puan.setBounds(1250,60,100,40);
        puan.setFont(f);
        puan.setHorizontalAlignment(SwingConstants.CENTER);

        JButton durdurTusu = new JButton(new ImageIcon("Görseller\\durdurTusu.png"));
        durdurTusu.setBounds(683,528,200,40);
        durdurTusu.setContentAreaFilled(false);
        durdurTusu.setBorderPainted(false);
        durdurTusu.setRolloverIcon(new ImageIcon("Görseller\\durdurTusuRV.png"));

        JButton[] seviyeTuslari = new JButton[6];
        for (int i = 0,j = 0,k = 0; i < 6; i++) {
            seviyeTuslari[i] = new JButton(new ImageIcon("Görseller\\seviyeTusu"+(i+1)+".png"));
            seviyeTuslari[i].setRolloverIcon(new ImageIcon("Görseller\\seviyeTusuRV"+(i+1)+".png"));
            seviyeTuslari[i].setContentAreaFilled(false);
            seviyeTuslari[i].setBorderPainted(false);
            if (i<3){
                seviyeTuslari[i].setBounds(100,315+j,150,40);
                j+=50;
            }else{
                seviyeTuslari[i].setBounds(1100,315+k,150,40);
                k+=50;
            }
        }

        dogrulamaTusu.setBounds(433,528, 300, 40);
        dogrulamaTusu.setRolloverIcon(new ImageIcon("Görseller\\dogrulamaTusuRV.png"));
        dogrulamaTusu.setContentAreaFilled(false);
        dogrulamaTusu.setBorderPainted(false);

        yaziAlani.setBounds(557,475,250,40);
        yaziAlani.setHorizontalAlignment(getWidth()/2);
        yaziAlani.setFont(f);
        yaziAlani.selectAll();

        for (int i = 0; i < 6; i++) {
            panel.add(seviyeTuslari[i]);
        }

        panel.add(puanYazi);
        panel.add(kelimeSecenegi);
        panel.add(puan);
        panel.add(puanYazi2);
        panel.add(sayiSecenegi);
        panel.add(dogrulamaTusu);
        panel.add(durdurTusu);
        panel.add(yaziAlani);
        panel.add(sayilar);
        panel.add(geriTusu);
        panel.add(arkaplan);

        sayilar.setVisible(false);

        setVisible(true);

        //Etiketlerin görünüp kaybolmasýný saðlayan eylem
        ActionListener is = new ActionListener() {
            private int sayac = 0;
            public void actionPerformed(ActionEvent e) {
                if (!sayilar.isVisible()) {
                    sayilar.setVisible(true);
                } else {
                    sayilar.setVisible(false);
                }
                sayac++;
                if (sayac%2==0) {
                    ((Timer) e.getSource()).stop();
                }
            }
        };

        //Mevcut iþi belirli zaman aralýklarý ile yapan zamanlayýcý
        z = new Timer(gorunmeSuresi, is);

        //Kelime tuþu: Basþladýðýnda gösterilecek deðerin dizisini seçip, sonucu ekranda gösterir.
        kelimeSecenegi.addActionListener(e -> {
            secenekBelirlemeSayaci = 1;
            rastgeleIndis = (int) (Math.random() * 30000);
            goruntulenenDeger = kelimeListesi.get(rastgeleIndis);
            sayilar.setText(goruntulenenDeger);
            yaziAlani.setText(null);
            z = new Timer(gorunmeSuresi, is);
            z.start();
            repaint();
        });

        //Sayý tuþu: Baþladýðýnda gösterilecek deðerin dizisini seçip, sonucu ekranda gösterir.
        sayiSecenegi.addActionListener(e -> {
            secenekBelirlemeSayaci = 2;
            rastgeleIndis = (int) (Math.random() * 500000);
            goruntulenenDeger = sayiListesi.get(rastgeleIndis);
            sayilar.setText(goruntulenenDeger);
            yaziAlani.setText(null);
            z = new Timer(gorunmeSuresi, is);
            z.start();
            repaint();
        });

        //Doðrulama tuþu: Yazýlan deðerin doðruluðunu tetkik edip, süreci devam ettirir.
        dogrulamaTusu.addActionListener(e -> {
            String yazilanGirdi;

            if (secenekBelirlemeSayaci == 1){
                goruntulenenDeger = kelimeListesi.get(rastgeleIndis);
            }else {
                goruntulenenDeger = sayiListesi.get(rastgeleIndis);
            }

            if (secenekBelirlemeSayaci == 1 ){
                hataBelirlemeSayaci = 0;
                yazilanGirdi = yaziAlani.getText() + " ";
                if (yazilanGirdi.contains(goruntulenenDeger)){
                    skor += goruntulenenDeger.length()-1;
                    puan.setText(skor +""); puan.repaint(); puan.setVisible(true);
                    rastgeleIndis = (int) (Math.random() * 30000);
                    goruntulenenDeger = kelimeListesi.get(rastgeleIndis);
                    sayilar.setText(goruntulenenDeger);
                    yaziAlani.setText(null);
                    z = new Timer(gorunmeSuresi, is);
                    z.start();
                    repaint();
                }else{
                    hataBelirlemeSayaci++;
                    skor -= goruntulenenDeger.length()-1;
                    puan.setText(skor +""); puan.repaint(); puan.setVisible(true);
                    goruntulenenDeger = kelimeListesi.get(rastgeleIndis);
                    sayilar.setText(goruntulenenDeger);
                    yaziAlani.setText(null);
                    z = new Timer(gorunmeSuresi, is);
                    z.start();
                    repaint();
                    if (hataBelirlemeSayaci==2 || skor < 0){
                        durdurTusu.doClick();
                        JOptionPane.showMessageDialog(null,"Kaybettin!Ama üzülme baþtan baþlayabilir :D ");
                    }
                }


            }else{
                hataBelirlemeSayaci = 0;
                yazilanGirdi = yaziAlani.getText() + " ";
                if (yazilanGirdi.equals(goruntulenenDeger)){
                    skor += goruntulenenDeger.length()-1;
                    puan.setText(skor +""); puan.repaint(); puan.setVisible(true);
                    rastgeleIndis = (int) (Math.random() * 500000);
                    goruntulenenDeger = sayiListesi.get(rastgeleIndis);
                    sayilar.setText(goruntulenenDeger);
                    yaziAlani.setText(null);
                    z = new Timer(gorunmeSuresi, is);
                    z.start();
                    repaint();
                }else{
                    hataBelirlemeSayaci++;
                    skor -= goruntulenenDeger.length()-1;
                    puan.setText(skor +""); puan.repaint(); puan.setVisible(true);
                    goruntulenenDeger = sayiListesi.get(rastgeleIndis);
                    sayilar.setText(goruntulenenDeger);
                    yaziAlani.setText(null);
                    z = new Timer(gorunmeSuresi, is);
                    z.start();
                    repaint();
                    if (hataBelirlemeSayaci==2 || skor < 0){
                        durdurTusu.doClick();
                        JOptionPane.showMessageDialog(null,"Kaybettin!Ama üzülme baþtan baþlayabilir :D ");
                    }
                }

            }

        });

        //Kullanýcýnýn, durdurmak istediði zaman kullanmasý gereken tuþ
        durdurTusu.addActionListener(e ->{
            z.stop();
            yaziAlani.setText(null);
            sayilar.setVisible(false);
            rastgeleIndis = (int) (Math.random() * 1001);
            if (secenekBelirlemeSayaci == 1){
                goruntulenenDeger = kelimeListesi.get(rastgeleIndis);
            }else {
                goruntulenenDeger = sayiListesi.get(rastgeleIndis);
            }
            skor = 0;  puan.setText(skor +""); puan.repaint(); puan.setVisible(false);
        });

        yaziAlani.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    dogrulamaTusu.doClick();
                }
            }
        });

        //Ana men?ye d?nmek i?in kullan?lan tu?
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

        for (int i = 0; i <6 ; i++) {
            if (i == 0){
                secenekBelirlemeSayaci2 = 0;
            }else if (i == 1){
                secenekBelirlemeSayaci2 = 1;
            }else if (i == 2){
                secenekBelirlemeSayaci2 = 2;
            }else if (i == 3){
                secenekBelirlemeSayaci2 = 3;
            }else if (i == 4){
                secenekBelirlemeSayaci2 = 4;
            }else if (i == 5){
                secenekBelirlemeSayaci2 = 5;
            }

            int finalI1 = i;
            seviyeTuslari[i].addActionListener(e -> {
                if (finalI1 == 0){
                    gorunmeSuresi = 650;
                    z.setDelay(gorunmeSuresi);
                }else if (finalI1 == 1){
                    gorunmeSuresi = 550;
                    z.setDelay(gorunmeSuresi);
                }else if (finalI1 == 2){
                    gorunmeSuresi = 450;
                    z.setDelay(gorunmeSuresi);
                }else if (finalI1 == 3){
                    gorunmeSuresi = 350;
                    z.setDelay(gorunmeSuresi);
                }else if (finalI1 == 4){
                    gorunmeSuresi = 250;
                    z.setDelay(gorunmeSuresi);
                }else if (finalI1 == 5){
                    gorunmeSuresi = 150;
                    z.setDelay(gorunmeSuresi);
                }
            });
        }
    }

    //Dosyadan metin okuma methodu
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

    //Dosyadan metin okuyup bir dizi listesine kelime kelime yazan method
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

}