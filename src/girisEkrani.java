import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class girisEkrani extends JFrame{

    private JButton girisTusu = new JButton(new ImageIcon("Görseller\\girisTusu.png"));
    private JPasswordField sifreAlani = new JPasswordField("");
    static JLabel arkaplan = new JLabel(new ImageIcon("Görseller\\Arkaplan1.jpg"));

    girisEkrani() throws IOException {

        super("Kaari - Hýzlý Okuma Programý");

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JTextField kullaniciAdiAlani = new JTextField("");
        kullaniciAdiAlani.setBounds(685,500,180,30);

        JLabel kullaniciAdiEtiketi = new JLabel(new ImageIcon("Görseller\\KullanýcýAdý.png"));
        kullaniciAdiEtiketi.setBounds(490,500,180,30);
        kullaniciAdiEtiketi.setForeground(Color.WHITE);

        JLabel sifreEtiketi = new JLabel(new ImageIcon("Görseller\\Sifre.png"));
        sifreEtiketi.setBounds(490,550,180,30);
        sifreEtiketi.setForeground(Color.WHITE);

        JButton cikisTusu = new JButton(new ImageIcon("Görseller\\cikisTusu.png"));
        cikisTusu.setBounds(685,620,125,30);
        cikisTusu.setRolloverIcon(new ImageIcon("Görseller\\cikisTusuRV.png"));
        cikisTusu.setContentAreaFilled(false);
        cikisTusu.setBorderPainted(false);

        JLabel sifremiUnuttumEtiketi = new JLabel("Þifremi unuttum!");
        sifremiUnuttumEtiketi.setBounds(1060,735,100,20);
        sifremiUnuttumEtiketi.setForeground(Color.WHITE);

        JLabel sifreDegistirEtiketi = new JLabel("Þifre deðiþtir!");
        sifreDegistirEtiketi.setBounds(1190,735,100,20);
        sifreDegistirEtiketi.setForeground(Color.WHITE);

        JLabel kaydolEtiketi = new JLabel("Kaydol!");
        kaydolEtiketi.setBounds(1300,735,100,20);
        kaydolEtiketi.setForeground(Color.WHITE);

        arkaplan.setBounds(-250,-215,1866,1198);

        sifreAlani.setBounds(685,550,180,30);

        girisTusu.setBounds(545,620,125,30);
        girisTusu.setContentAreaFilled(false);
        girisTusu.setBorderPainted(false);
        girisTusu.setRolloverIcon(new ImageIcon("Görseller\\girisTusuRV.png"));

        setVisible(true);

        panel.add(sifreDegistirEtiketi);
        panel.add(kullaniciAdiEtiketi);
        panel.add(sifreEtiketi);
        panel.add(kullaniciAdiAlani);
        panel.add(sifreAlani);
        panel.add(girisTusu);
        panel.add(cikisTusu);
        panel.add(sifremiUnuttumEtiketi);
        panel.add(kaydolEtiketi);
        panel.add(arkaplan);

        //Yazdýðýmýz methodlar üzerinden kayýt defterindeki sifre ve kullanýcý adýný kontrol ediyor
        girisTusu.addActionListener(e -> {

            String kullaniciAdiKayitNo = sifremiUnuttum.kullaniciAdiKontrol(kullaniciAdiAlani.getText());
            String kayitliSifre = sifremiUnuttum.sifreBulma(kullaniciAdiKayitNo);

            if(kayitliSifre.contains(sifreAlani.getText())){
                girisTusu.setEnabled(false);
                cikisTusu.setEnabled(false);
                kaydolEtiketi.setEnabled(false);
                sifremiUnuttumEtiketi.setEnabled(false);
                setVisible(false);
                new menuEkrani();
            }
            else {
                JOptionPane.showMessageDialog(null, "Kullanýcý Adý ve ya Þifre Yanlýþ!");
            }

        });

        //Enter tuþuna basýnca da giriþ saðlamak için
        sifreAlani.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {

                                      }
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()== KeyEvent.VK_ENTER){
                    girisTusu.doClick();
                }
            }
            public void keyReleased(KeyEvent e) {

                                      }
        });

        //Programý kapatmak için
        cikisTusu.addActionListener(e -> System.exit(0));

        //Týklandýðýnda kaydolEkraný'ný açar
        kaydolEtiketi.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setVisible(false);
                new kaydolEkrani();
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                kaydolEtiketi.setForeground(Color.blue);
            }
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                kaydolEtiketi.setForeground(Color.WHITE);
            }
        });

        //Þifremi unuttum sýnýfýný açar ve geçici þifreyi mail adresine gönderir
        sifremiUnuttumEtiketi.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new sifremiUnuttum();
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                sifremiUnuttumEtiketi.setForeground(Color.blue);
            }
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                sifremiUnuttumEtiketi.setForeground(Color.WHITE);
            }
        });

        //Þifre deðiþtirme sýnýfýný açar ve þifre deðiþtrir
        sifreDegistirEtiketi.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new sifreDegistir();
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                sifreDegistirEtiketi.setForeground(Color.blue);
            }
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                sifreDegistirEtiketi.setForeground(Color.WHITE);
            }
        });

    }

}