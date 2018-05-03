import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

class sifreDegistir extends JFrame implements KeyListener{

    private static JTextField kullaniciAdi = new JTextField();

    private static String p1 = "Kayit Defteri\\Sifre1.txt";
    private static String p2 = "Kayit Defteri\\Sifre2.txt";

    private static File sifreler1 = new File(p1);
    private static File sifreler2 = new File(p2);

    private static String kayitSirasi;
    private JButton onayTusu = new JButton("Onayla");

    sifreDegistir() {

        setSize(600, 500);
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, (dim.height / 2 - this.getSize().height / 2)+25);

        Font f = new Font("verdana", Font.BOLD, 17);

        JTextField kullaniciAdi = new JTextField();
        kullaniciAdi.setBounds(300, 50, 250, 30);
        kullaniciAdi.setFont(f);

        JPasswordField mevcutSifre = new JPasswordField();
        mevcutSifre.setBounds(300, 100, 250, 30);
        mevcutSifre.setFont(f);

        JPasswordField yeniSifre1 = new JPasswordField();
        yeniSifre1.setBounds(300, 150, 250, 30);
        yeniSifre1.setFont(f);

        JPasswordField yeniSifre2 = new JPasswordField();
        yeniSifre2.setBounds(300, 200, 250, 30);
        yeniSifre2.setFont(f);

        JLabel kullaniciAdiE = new JLabel("Kullanýcý Adý                 :");
        kullaniciAdiE.setBounds(50,50,250,30);
        kullaniciAdiE.setFont(f);

        JLabel mevcutSifreE = new JLabel("Mevcut Þifre                 :");
        mevcutSifreE.setBounds(50,100,250,30);
        mevcutSifreE.setFont(f);

        JLabel yeniSifre1E = new JLabel("Yeni Þifre                     :");
        yeniSifre1E.setBounds(50,150,250,30);
        yeniSifre1E.setFont(f);

        JLabel yeniSifre2E = new JLabel("Yeni Þifre (Tekrar)       :");
        yeniSifre2E.setBounds(50,200,250,30);
        yeniSifre2E.setFont(f);

        onayTusu.setBounds(125, 300, 100, 40);

        JButton cikisTusu = new JButton("Çýkýþ");
        cikisTusu.setBounds(350, 300, 100, 40);

        JLabel arkaplan = new JLabel(new ImageIcon("Görseller\\Arkaplan2.jpg"));
        arkaplan.setBounds(-250, -215,1866 , 1198);

        setVisible(true);

        panel.add(kullaniciAdiE);
        panel.add(mevcutSifreE);
        panel.add(yeniSifre1E);
        panel.add(yeniSifre2E);
        panel.add(mevcutSifre);
        panel.add(yeniSifre1);
        panel.add(yeniSifre2);
        panel.add(kullaniciAdi);
        panel.add(mevcutSifre);
        panel.add(onayTusu);
        panel.add(cikisTusu);
        panel.add(arkaplan);

        kullaniciAdi.addKeyListener(this);
        mevcutSifre.addKeyListener(this);
        yeniSifre1.addKeyListener(this);
        yeniSifre2.addKeyListener(this);
        arkaplan.addKeyListener(this);

        cikisTusu.addActionListener(e -> setVisible(false));

        onayTusu.addActionListener(e -> {

            if (kullaniciAdi.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Kullanýcý adýný boþ býrakamazsýnýz!");
                kullaniciAdi.setText("");
            }else if (mevcutSifre.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Mevcut þifre alanýný boþ býrakamazsýnýz!");
                mevcutSifre.setText("");
            }else if (yeniSifre1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Yeni þifre alanýný boþ býrakamazsýnýz!");
                yeniSifre1.setText("");
            }else if (Integer.parseInt(yeniSifre1.getText())<6){
                JOptionPane.showMessageDialog(null,"Þifreniz 6 haneden küçük olamaz!");
                yeniSifre1.setText("");
            }else if (Integer.parseInt(yeniSifre2.getText())<6){
                JOptionPane.showMessageDialog(null,"Þifreniz 6 haneden küçük olamaz!");
                yeniSifre2.setText("");
            }else if (yeniSifre2.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Yeni þifre(tekrar) alanýný boþ býrakamazsýnýz!");
                yeniSifre2.setText("");

                //Kullanýcý adýnýn mevcut olup olmadýðýný kontrole eden þart
            }else if (((sifremiUnuttum.kullaniciAdiKontrol(kullaniciAdi.getText()))).equals("")){
                JOptionPane.showMessageDialog(null,"Kullanýcý adý bulunamadý!");

            //Mevcut þifre ile kullanýcý adýnýn eþleþmesini kontrol eden þart
            }else if ((sifremiUnuttum.sifreBulma( sifremiUnuttum.kullaniciAdiKontrol(kullaniciAdi.getText()))).equals("")){
                JOptionPane.showMessageDialog(null,"Mevcut þifre ve kullanýcý adý eþleþmiyor!");

            //Ýlk þifre ile ikinci þifrenin denkliðini kontrol eden þart
            }else if (!(yeniSifre1.getText().equals(yeniSifre2.getText()))){
                JOptionPane.showMessageDialog(null,"Ýkinci þifre ile ilk þifre uyuþmuyor!");

            /*Bütün þartlar saðlandýktan sonra birinci dosyadaki þifreyi deðiþtirir,
              sonra ikinci dosyaya yazar ve en son hali tekrar birinci dosyaya kopyalar*/
            }else{

                kayitSirasi = sifremiUnuttum.kullaniciAdiKontrol(kullaniciAdi.getText());

                String kayýtNumarasýStr = sifremiUnuttum.kullaniciAdiKontrol(kullaniciAdi.getText());

                sifreDegistirme(kayýtNumarasýStr+yeniSifre2.getText(), kayitSirasi);

                sifreler1 = new File(p2);
                sifreler2 = new File(p1);

                sifreDegistirme(kayýtNumarasýStr+yeniSifre2.getText(), kayitSirasi);

                JOptionPane.showMessageDialog(null,"Ýþlem baþarýyla tamamlandý!");

                kullaniciAdi.setText(""); mevcutSifre.setText(""); yeniSifre1.setText(""); yeniSifre2.setText("");

            }

        });

        //Sifremi unuttum paneli açýkken giris ekranýna dokunulursa
        //Kullanýcý adý yazý alanýndaki yazý aynen kalýyor
        //Bunu engellemek için, giris ekraný arkaplana dokunulunca
        //Yazý alanýný sýfýrlayan kod
        if (isVisible()){
            girisEkrani.arkaplan.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    kullaniciAdi.setText(""); mevcutSifre.setText(""); yeniSifre1.setText(""); yeniSifre2.setText("");
                }
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    kullaniciAdi.setText(""); mevcutSifre.setText(""); yeniSifre1.setText(""); yeniSifre2.setText("");
                }
            });
        }

    }

    //Kayýt numarýsýna göre yer belirleyip, þifre deðiþtiren method
    private static void sifreDegistirme(String yeniSifre,String kayitSirasi){
        try {
            FileWriter fw2 = new FileWriter(sifreler2);
            PrintWriter pw = new PrintWriter(fw2);

            BufferedReader reader = new BufferedReader(new FileReader(sifreler1));

            String satir = reader.readLine();
            while (satir!=null) {
                if (!(satir.contains(kayitSirasi))){
                    pw.write(satir + "\n");
                }else{
                    pw.write(yeniSifre + "\n");
                }
                satir = reader.readLine();
            }
            pw.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void keyTyped(KeyEvent e) {

    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            onayTusu.doClick();
        }
    }
    public void keyReleased(KeyEvent e) {

    }

}