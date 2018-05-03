import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class sifremiUnuttum extends JFrame implements KeyListener{

    private static  String p1 = "Kayit Defteri\\Sifre1.txt";
    private static  String p2 = "Kayit Defteri\\Sifre2.txt";

    private JButton onayTusu = new JButton("Onayla");

    private static JTextField kullaniciAdi = new JTextField();
    private static File sifreler1 = new File(p1);
    private static File sifreler2 = new File(p2);

    private static String rastgeleSifre = "" + ((int)(Math.random()*10)) + "" + ((int)(Math.random()*10)) + "" + ((int)(Math.random()*10)) + "" + ((int)(Math.random()*10)) + "" + ((int)(Math.random()*10)) + "" + ((int)(Math.random()*10)) + "" + ((int)(Math.random()*10)) + "" + ((int)(Math.random()*10));

    sifremiUnuttum(){

        setSize(600,500);
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        //Panelin ekran�n merkezinde ��kmas�n� sa�layan kod
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, (dim.height/2-this.getSize().height/2)+28);

        Font f = new Font("verdana",Font.BOLD,16);

        JLabel aciklamaE1 = new JLabel("Mail adresinizi ve kullan�c� ad�n�z� giriniz. Mail adresinize ");
        aciklamaE1.setBounds(10,50,580,30);
        aciklamaE1.setHorizontalAlignment(SwingConstants.CENTER);
        aciklamaE1.setFont(f);

        JLabel aciklamaE2 = new JLabel("g�nderilen ge�ici �ifreyi kullanarak\n�ifrenizi yenileyebilirsiniz.");
        aciklamaE2.setBounds(10,80,580,30);
        aciklamaE2.setHorizontalAlignment(SwingConstants.CENTER);
        aciklamaE2.setFont(f);

        JLabel mailE = new JLabel("Mail Adresiniz :");
        mailE.setBounds(50,140,150,50);
        mailE.setFont(f);

        JLabel kullaniciAdiE = new JLabel("Kullan�c� Ad�n�z :");
        kullaniciAdiE.setBounds(50,210,150,50);
        kullaniciAdiE.setFont(f);

        JTextField mailYaziAlani = new JTextField();
        mailYaziAlani.setBounds(250,150,250,30);
        mailYaziAlani.setFont(f);

        kullaniciAdi.setBounds(250,220,250,30);
        kullaniciAdi.setFont(f);

        onayTusu.setBounds( 150,300,100,40);

        JButton cikisTusu = new JButton("��k��");
        cikisTusu.setBounds( 350,300,100,40);

        JLabel arkaplan = new JLabel(new ImageIcon("G�rseller\\Arkaplan2.jpg"));
        arkaplan.setBounds(-250, -215,1866 , 1198);

        setVisible(true);

        panel.add(mailYaziAlani);
        panel.add(kullaniciAdi);
        panel.add(mailE);
        panel.add(kullaniciAdiE);
        panel.add(aciklamaE1);
        panel.add(aciklamaE2);
        panel.add(onayTusu);
        panel.add(cikisTusu);
        panel.add(arkaplan);

        cikisTusu.addActionListener(e -> setVisible(false));

        onayTusu.addActionListener(e -> {

            String kullaniciAdiKayip1 = kullaniciAdiKontrol(kullaniciAdi.getText()).trim();
            String mailKayip1 = mailKontrol(mailYaziAlani.getText()).trim();

            //Mail adresinin olup olmad��� kontrol edilir
            if (mailKayip1.equals("")){
                JOptionPane.showMessageDialog(null,"Mail bulunamad�!");
                kullaniciAdi.setText(""); mailYaziAlani.setText("");

            //Kullan�c� ad�n�n olup olmad��� kontrol edilir
            }else if (kullaniciAdiKayip1.equals("")){
                JOptionPane.showMessageDialog(null,"Kullan�c� ad� bulunamad�!");
                kullaniciAdi.setText(""); mailYaziAlani.setText("");

            //Mail il kullan�c� ad�n�n denkli�i kontrol edilir
            }else if ((esitlikKontrol(kullaniciAdiKayip1,mailKayip1).equals(""))){
                JOptionPane.showMessageDialog(null,"Mail adres ile kullan�c� ad� uyu�muyor!");
                    kullaniciAdi.setText(""); mailYaziAlani.setText("");
            }else {

                kaydolEkrani.mailGonderme(mailYaziAlani.getText(),"Kaari - H�zl� Okuma Ekran�",("Ge�ici �ifreniz: "
                                          + rastgeleSifre + "\nBu �ifre ile �ifre de�i�tir b�l�m�nden �ifrenizi de�i�tirin."));

                String kayitNumarasiStr = kullaniciAdiKontrol(kullaniciAdi.getText());

                sifreDegistirme(kayitNumarasiStr + rastgeleSifre);

                sifreler1 = new File(p2);
                sifreler2 = new File(p1);

                sifreDegistirme(kayitNumarasiStr + rastgeleSifre);

                JOptionPane.showMessageDialog(null,"islem basariyla tamamlandi!");

                kullaniciAdi.setText(""); mailYaziAlani.setText("");

            }

        });

        //Sifremi unuttum paneli a��kken giris ekran�na dokunulursa
        //Kullan�c� ad� yaz� alan�ndaki yaz� aynen kal�yor
        //Bunu engellemek i�in, giris ekran� arkaplana dokunulunca
        //Yaz� alan�n� s�f�rlayan kod
        if (isVisible()){
            girisEkrani.arkaplan.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    kullaniciAdi.setText(""); mailYaziAlani.setText("");
                }
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    kullaniciAdi.setText(""); mailYaziAlani.setText("");
                }
            });
        }

        mailYaziAlani.addKeyListener(this);
        kullaniciAdi.addKeyListener(this);

    }

    //Kulan�c� ad�n� kontrol edip, mevcut ise kay�t numaras�n� d�nd�ren method
    static String kullaniciAdiKontrol(String kullaniciAdi){
        try {
            File dosya = new File("Kayit Defteri\\KullaniciAdi.txt");
            BufferedReader reader = new BufferedReader(new FileReader(dosya));
            String satir = reader.readLine();
            while (satir != null) {
                if (satir.contains(kullaniciAdi)) {
                    return kayitNumarasiBulma(satir);
                }
                satir = reader.readLine();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    //Mail adresinin mevcut olup olmad���n� kontrol eden method
    static String mailKontrol(String mail){
        try {
            File dosya = new File("Kay�t Defteri\\Mail.txt");
            BufferedReader reader = new BufferedReader(new FileReader(dosya));
            String satir = reader.readLine();
            while (satir != null) {
                if (satir.contains(mail)) {
                    return kayitNumarasiBulma(satir);
                }
                satir = reader.readLine();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    //Kay�t numaras�na g�re �ifre d�nd�ren method
    static String sifreBulma(String kayitNumarasi){
        try {
            File dosya = new File("Kay�t Defteri\\Sifre1.txt");
            BufferedReader reader = new BufferedReader(new FileReader(dosya));
            String satir = reader.readLine();
            while (satir!=null) {
                if(satir.contains(kayitNumarasi)){
                   return satir;
                }
                satir = reader.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    //Kay�t numaras� d�nd�ren method
    static String kayitNumarasiBulma(String s){
     StringBuilder snc = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            snc.append(s.charAt(i));
            if (snc.toString().contains("kaari_")){
                return snc.toString();
            }
        }
         return snc.toString();
    }

    //�ifre de�i�tirmek i�in kullan�lan method. Burada iki �ifre dosyas� kullan�yoruz.
    //Bir de�i�iklik olaca�� zaman de�i�tirip, ikinci dosyaya yaz�yoruz
    //sonra tekrar ilk dosyaya yaz�p, de�i�tirme i�lemini tamaml�yoruz.
    private static void sifreDegistirme(String s){
        try {
            FileWriter fw2 = new FileWriter(sifreler2);
            PrintWriter pw = new PrintWriter(fw2);

            BufferedReader reader = new BufferedReader(new FileReader(sifreler1));

            String satir = reader.readLine();
            while (satir!=null) {
                if (!(satir.contains(kullaniciAdiKontrol(kullaniciAdi.getText())))){
                    pw.write(satir + "\n");
                }else{
                    pw.write(s + "\n");
                }
                satir = reader.readLine();
            }
            pw.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Girilen iki stringin e�itli�ini kontrol eder, mevcut equals
    //methodunda bir sorun oldu�u i�in yazd�k
    private String esitlikKontrol(String str1, String str2){
        String snc1 = "";
        String snc2 = "";
        for (int i = 0; i < str1.length()-1; i++) {
           snc1 += str1.charAt(i);
           snc2 += str2.charAt(i);
           if (snc1.equals(snc2)){
               return snc1;
           }
        }
        return "";
    }

    public void keyTyped(KeyEvent e) {

    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            onayTusu.doClick();
        }
    }
    public void keyReleased(KeyEvent e) {

    }

}
