import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
import javax.swing.text.SimpleAttributeSet;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Properties;

class kaydolEkrani extends JFrame implements KeyListener {

    private static int uyeSayisi = uyeSayisi(); //�ye olan ki�i say�s�n� tutar
    private JButton sozlesmeTmm = new JButton("TAMAM");

    kaydolEkrani(){

        super("Kaari - Kaydol");

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JTextField adYaziAlani = new JTextField();
        adYaziAlani.setBounds(685, 125, 180, 30);

        JLabel adEtiketi= new JLabel(new ImageIcon("G�rseller\\Ad.png"));
        adEtiketi.setBounds(490, 125, 180, 30);
        adEtiketi.setForeground(Color.white);

        JTextField soyadYaziAlani = new JTextField();
        soyadYaziAlani.setBounds(685, 200, 180, 30);

        JLabel soyadEtiketi= new JLabel(new ImageIcon("G�rseller\\Soyad.png"));
        soyadEtiketi.setBounds(490, 200, 180, 30);
        soyadEtiketi.setForeground(Color.white);

        JTextField kullaniciAdiYaziAlani = new JTextField();
        kullaniciAdiYaziAlani.setBounds(685, 275, 180, 30);

        JLabel kullaniciAdiEtiketi= new JLabel(new ImageIcon("G�rseller\\Kullan�c�Ad�.png"));
        kullaniciAdiEtiketi.setBounds(490, 275, 180, 30);
        kullaniciAdiEtiketi.setForeground(Color.white);

        JPasswordField sifreAlani1 = new JPasswordField();
        sifreAlani1.setBounds(685, 350, 180, 30);

        JLabel sifreEtiketi1= new JLabel(new ImageIcon("G�rseller\\Sifre.png"));
        sifreEtiketi1.setBounds(490, 350, 180, 30);
        sifreEtiketi1.setForeground(Color.blue);

        JPasswordField sifreAlani2 = new JPasswordField();
        sifreAlani2.setBounds(685, 425, 180, 30);

        JLabel sifreEtiketi2= new JLabel(new ImageIcon("G�rseller\\sifreTekrar.png"));
        sifreEtiketi2.setBounds(490, 425, 180, 30);
        sifreEtiketi2.setForeground(Color.white);

        JTextField mailYaziAlani = new JTextField();
        mailYaziAlani.setBounds(685, 500, 180, 30);

        JLabel mailEtiketi= new JLabel(new ImageIcon("G�rseller\\Mail.png"));
        mailEtiketi.setBounds(490, 500, 180, 30);
        mailEtiketi.setForeground(Color.white);

        Font f = new Font("verdana",Font.PLAIN,10);

        sozlesmeTmm.setBounds(633,600,100,30);
        sozlesmeTmm.setVisible(false);

        JTextPane sozlesmeAlani = new JTextPane();

        SimpleAttributeSet set = new SimpleAttributeSet();
        sozlesmeAlani.setCharacterAttributes(set,true);
        sozlesmeAlani.setEnabled(true);
        sozlesmeAlani.setEditable(false);
        sozlesmeAlani.setAutoscrolls(true);
        sozlesmeAlani.setFont(f);
        sozlesmeAlani.setBounds(383,50,600,600);
        sozlesmeAlani.setVisible(false);

        DefaultCaret caret = (DefaultCaret)sozlesmeAlani.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        try {
            sozlesmeAlani.setText(hizTestiEkrani.metinOkuma("Metin Belgeleri\\sozlesme.txt"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        JLabel sozlesme1 = new JLabel("Kullan�c� s�zle�mesi");
        sozlesme1.setBounds(544, 580, 300, 20);
        sozlesme1 .setForeground(Color.white);

        JLabel sozlesme2 = new JLabel("ni okudum ve kabul ediyorum");
        sozlesme2.setBounds(660, 580, 300, 20);
        sozlesme2.setForeground(Color.white);

        JCheckBox kontrolKutucugu = new JCheckBox("");
        kontrolKutucugu.setBounds(520, 580, 20, 20);

        JButton kaydolTusu = new JButton("KAYDOL");
        kaydolTusu.setBounds(545,620,125,30);

        JButton cikisTusu = new JButton("�IKI�");
        cikisTusu.setBounds(685,620,125,30);

        JLabel arkaplan = new JLabel(new ImageIcon("G�rseller\\Arkaplan2.jpg"));
        arkaplan.setBounds(-250, -215,1866 , 1198);

        setVisible(true);

        panel.add(sozlesmeTmm);
        panel.add(sozlesmeAlani);
        panel.add(adYaziAlani);
        panel.add(soyadYaziAlani);
        panel.add(kullaniciAdiYaziAlani);
        panel.add(sifreAlani1);
        panel.add(sifreAlani2);
        panel.add(mailYaziAlani);

        panel.add(adEtiketi);
        panel.add(soyadEtiketi);
        panel.add(kullaniciAdiEtiketi);
        panel.add(sifreEtiketi1);
        panel.add(sifreEtiketi2);
        panel.add(mailEtiketi);
        panel.add(kaydolTusu);
        panel.add(cikisTusu);
        panel.add(sozlesme1);
        panel.add(sozlesme2);
        panel.add(kontrolKutucugu);
        panel.add(arkaplan);

        //S�zle�me yaz�s�n�n i�levi
        sozlesme1.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {

            }
            public void mousePressed(MouseEvent e) {
                sozlesmeAlani.setVisible(true);
                sozlesmeTmm.setVisible(true);

                adYaziAlani.setEnabled(false);
                soyadYaziAlani.setEnabled(false);
                kullaniciAdiYaziAlani.setEnabled(false);
                sifreAlani1.setEnabled(false);
                sifreAlani2.setEnabled(false);
                mailYaziAlani.setEnabled(false);
                kontrolKutucugu.setEnabled(false);
                kaydolTusu.setEnabled(false);
                cikisTusu.setEnabled(false);
            }
            public void mouseReleased(MouseEvent e) {

            }
            public void mouseEntered(MouseEvent e) {
                sozlesme1.setForeground(Color.blue);
            }
            public void mouseExited(MouseEvent e) {
                sozlesme1.setForeground(Color.white);
            }
        });

        //S�zle�me a��ld���nda beliren tu�un i�levi
        sozlesmeTmm.addActionListener(e -> {
            sozlesmeAlani.setVisible(false);
            sozlesmeTmm.setVisible(false);

            adYaziAlani.setEnabled(true);
            soyadYaziAlani.setEnabled(true);
            kullaniciAdiYaziAlani.setEnabled(true);
            sifreAlani1.setEnabled(true);
            sifreAlani2.setEnabled(true);
            mailYaziAlani.setEnabled(true);
            kontrolKutucugu.setEnabled(true);
            kaydolTusu.setEnabled(true);
            cikisTusu.setEnabled(true);
        });

        //KetListener'in dinleyece�i yerler
        sozlesmeTmm.addKeyListener(this);
        sozlesmeAlani.addKeyListener(this);
        panel.addKeyListener(this);

        //Kaydol tu�una bas�ld���nda gerekli kontrolleri yap�p, kay�d� ger�ekle�tiren i�lev
        kaydolTusu.addActionListener(e -> {

            //Yaz� alanlar�n�n bo� olup olmad���n� kontrol eder
            if (adYaziAlani.getText().equals("")||soyadYaziAlani.getText().equals("")||kullaniciAdiYaziAlani.getText().equals("")||sifreAlani1.getText().equals("")||sifreAlani2.getText().equals("")||mailYaziAlani.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"L�tfen bilgileriniz eksiksiz doldurunuz!");

            //Kullan�c� ad�n�n 6 karakterden k���k olup olmad���n� kontrol eder
            }else if(kullaniciAdiYaziAlani.getText().length()<6){
                JOptionPane.showMessageDialog(null, "Kullan�c� ad� �ok k�sa!");
                kullaniciAdiYaziAlani.setText("");

            //Kullan�c� ad�n�n 6 karakterden k���k olup olmad���n� kontrol eder
            }else if(sifreAlani1.getText().length()<6){
                JOptionPane.showMessageDialog(null, "�ifre �ok k�sa!");
                sifreAlani1.setText("");sifreAlani2.setText("");

            //S�zle�me kutucu�unun i�aretlenip i�aretlenmedi�ini kontrol eder
            }else if (!(kontrolKutucugu.isSelected())) {
                JOptionPane.showMessageDialog(null,"S�zle�meyi kabul etmeden ge�emezsiniz!\nS�zle�me kutucu�unu i�aretlemeyi unutmay�n!");

            //Girilen kullan�c� ad�n�n daha �nce kullan�l�p kullan�lmad���n� kontrol eder
            }else if (!(kullaniciAdiKontrol(kullaniciAdiYaziAlani.getText()))) {
                JOptionPane.showMessageDialog(null, "Bu kullan�c� ismi daha �nce kullan�lm��!");

            //Mail adresinin daha �nce kullan�l�p kullan�lmad���n� kontrol eder
            }else if ((sifremiUnuttum.mailKontrol(mailYaziAlani.getText())).contains("kaari")) {
                JOptionPane.showMessageDialog(null, "Bu mail adresi daha �nce kullan�lm��!");
                mailYaziAlani.setText("");
            }else{
                try {

                    FileWriter ad = new FileWriter("Kay�t Defteri\\Ad.txt", true);
                    FileWriter soyad = new FileWriter("Kay�t Defteri\\Soyad.txt", true);
                    FileWriter kullanici = new FileWriter("Kay�t Defteri\\Kullan�c�Ad�.txt", true);
                    FileWriter sifre = new FileWriter("Kay�t Defteri\\Sifre1.txt", true);
                    FileWriter mail1 = new FileWriter("Kay�t Defteri\\Mail.txt", true);

                    PrintWriter pw = new PrintWriter(ad);

                    //Girilen iki �ifrenin denkli�ini kontro eder
                    if (sifreAlani1.getText().equals(sifreAlani2.getText())) {

                        uyeSayisi++;

                        pw.write(((uyeSayisi) + "kaari_" + adYaziAlani.getText()).trim());
                        pw.println("");
                        pw.close();

                        pw = new PrintWriter(soyad);
                        pw.write(((uyeSayisi) + "kaari_" + soyadYaziAlani.getText()).trim());
                        pw.println("");
                        pw.close();

                        pw = new PrintWriter(kullanici);
                        pw.write(((uyeSayisi) + "kaari_" + kullaniciAdiYaziAlani.getText()).trim());
                        pw.println("");
                        pw.close();

                        pw = new PrintWriter(sifre);
                        pw.write(((uyeSayisi) + "kaari_" + sifreAlani1.getText()).trim());
                        pw.println("");
                        pw.close();

                        pw = new PrintWriter(mail1);
                        pw.write(((uyeSayisi) + "kaari_" + mailYaziAlani.getText()).trim());
                        pw.println("");
                        pw.close();

                        JOptionPane.showMessageDialog(null, "Kayd�n�z ba�ar�yla tamamland�!");

                        //Mail g�nderme methodunu �a��rd�m�z yer
                        mailGonderme(mailYaziAlani.getText(),
                                "Kaari - H�zl� Okuma Program�",
                                "Say�n, " + (adYaziAlani.getText() + soyadYaziAlani.getText()) + "\n"
                                        + "Kaari h�zl� okuma program�n� tercih etti�iniz i�in te�ekk�rler...\n"
                                        + "Kullan�c� Ad� : " + kullaniciAdiYaziAlani.getText() + "\n"
                                        + "�ifre         : " + sifreAlani1.getText());

                        adYaziAlani.setText("");soyadYaziAlani.setText("");kullaniciAdiYaziAlani.setText("");
                        sifreAlani1.setText("");sifreAlani2.setText("");mailYaziAlani.setText(""); kaydolTusu.setSelected(false);

                    }else {
                        JOptionPane.showMessageDialog(null, "�ifreler uyu�muyor!");
                    }

                }catch (IOException ignored) {}

            }

        });

        //Giri� ekran�na geri d�nme i�levi
        cikisTusu.addActionListener(e -> {
            try {
                new girisEkrani();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            setVisible(false);
        });

    }

    //Kullan�c� ad�n�n �nceden dosyada yaz�l�
    //olup olmad���n� kontrol eden method
    private static boolean kullaniciAdiKontrol(String s){
        try {
            File dosya = new File("Kay�t Defteri\\Kullan�c�Ad�.txt");
            BufferedReader reader = new BufferedReader(new FileReader(dosya));
            String satir = reader.readLine();
            while (satir!=null) {
                if(satir.equalsIgnoreCase(s)) {
                    return false;
                }
                satir = reader.readLine();
            }
        }catch(IOException ignored){
        }
        return true;
    }

    //Dosyaya bilgi kaydederken ili�kilendirme yapmak i�in,
    //kay�t numaralar� ile kaydediyoruz,
    //kay�t numaras�n� d�nd�ren method
     static String kayitNumarasi(String s){
        String sonuc = "";
        for (int i = 0; i < s.length(); i++) {
            sonuc = sonuc + s.charAt(i);
            if (sonuc.contains("kaari_")){
                sonuc = "";
                for (int j = 0; j < i-5; j++) {
                    sonuc = sonuc + s.charAt(j);
                }
                return sonuc;

            }
        }
        return sonuc;
    }

    //G�ncel �ye say�s�n� tutmak i�in kullan�lan method
    private static int uyeSayisi(){
        try {
            File dosya = new File("Kay�t Defteri\\Ad.txt");
            BufferedReader reader = new BufferedReader(new FileReader(dosya));
            String satir = reader.readLine();
            while (satir!=null) {
                uyeSayisi = Integer.parseInt(kayitNumarasi(satir));
                satir = reader.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return uyeSayisi;
    }

    //Mail g�ndermek i�in yazd���m�z method
    static void mailGonderme(String gonderilecekMailAdresi, String mesajBasl�g�, String mesajIcerik) {

        try {
            String from = "*************@gmail.com";
            String pass = "**********";
            String[] to = {gonderilecekMailAdresi};
            String host = "smtp.gmail.com";
            Properties props = System.getProperties();
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.user", from);
            props.put("mail.smtp.password", pass);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            Session session = Session.getDefaultInstance(props, null);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }
            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }
            message.setSubject(mesajBasl�g�);
            message.setText(mesajIcerik);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Uygulanan KeyListener'in methodlar�
    public void keyTyped(KeyEvent e)
    {

    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            sozlesmeTmm.doClick();
        }
    }
    public void keyReleased(KeyEvent e) {

    }
}