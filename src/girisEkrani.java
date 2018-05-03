import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class girisEkrani extends JFrame{

    private JButton girisTusu = new JButton(new ImageIcon("G�rseller\\girisTusu.png"));
    private JPasswordField sifreAlani = new JPasswordField("");
    static JLabel arkaplan = new JLabel(new ImageIcon("G�rseller\\Arkaplan1.jpg"));

    girisEkrani() throws IOException {

        super("Kaari - H�zl� Okuma Program�");

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JTextField kullaniciAdiAlani = new JTextField("");
        kullaniciAdiAlani.setBounds(685,500,180,30);

        JLabel kullaniciAdiEtiketi = new JLabel(new ImageIcon("G�rseller\\Kullan�c�Ad�.png"));
        kullaniciAdiEtiketi.setBounds(490,500,180,30);
        kullaniciAdiEtiketi.setForeground(Color.WHITE);

        JLabel sifreEtiketi = new JLabel(new ImageIcon("G�rseller\\Sifre.png"));
        sifreEtiketi.setBounds(490,550,180,30);
        sifreEtiketi.setForeground(Color.WHITE);

        JButton cikisTusu = new JButton(new ImageIcon("G�rseller\\cikisTusu.png"));
        cikisTusu.setBounds(685,620,125,30);
        cikisTusu.setRolloverIcon(new ImageIcon("G�rseller\\cikisTusuRV.png"));
        cikisTusu.setContentAreaFilled(false);
        cikisTusu.setBorderPainted(false);

        JLabel sifremiUnuttumEtiketi = new JLabel("�ifremi unuttum!");
        sifremiUnuttumEtiketi.setBounds(1060,735,100,20);
        sifremiUnuttumEtiketi.setForeground(Color.WHITE);

        JLabel sifreDegistirEtiketi = new JLabel("�ifre de�i�tir!");
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
        girisTusu.setRolloverIcon(new ImageIcon("G�rseller\\girisTusuRV.png"));

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

        //Yazd���m�z methodlar �zerinden kay�t defterindeki sifre ve kullan�c� ad�n� kontrol ediyor
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
                JOptionPane.showMessageDialog(null, "Kullan�c� Ad� ve ya �ifre Yanl��!");
            }

        });

        //Enter tu�una bas�nca da giri� sa�lamak i�in
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

        //Program� kapatmak i�in
        cikisTusu.addActionListener(e -> System.exit(0));

        //T�kland���nda kaydolEkran�'n� a�ar
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

        //�ifremi unuttum s�n�f�n� a�ar ve ge�ici �ifreyi mail adresine g�nderir
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

        //�ifre de�i�tirme s�n�f�n� a�ar ve �ifre de�i�trir
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