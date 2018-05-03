import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

class hizliOkumaEkrani extends JFrame {

    private JButton birKelime = new JButton(new ImageIcon("Görseller\\birkelime.png"));
    private JButton ikiKelime = new JButton(new ImageIcon("Görseller\\ikikelime.png"));
    private JButton ucKelime = new JButton(new ImageIcon("Görseller\\uckelime.png"));

    private JButton[] seviyeTuslari = new JButton[9];

    private int hiz1 = 450, hiz2 = 300, hiz3 = 150;

    private int a = 0;
    private Timer z1,z2,z3;
    private File file = null;
    private static String metinYolu = "Metin Belgeleri\\metin5.txt";
    private ArrayList<String> kelimeler = kelimeler(metinYolu);

    hizliOkumaEkrani() throws IOException {

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        birKelime.setRolloverIcon(new ImageIcon("Görseller\\birkelimeRV.png"));
        birKelime.setBounds(428,490,150,40);
        birKelime.setBorderPainted(false);
        birKelime.setContentAreaFilled(false);

        ikiKelime.setRolloverIcon(new ImageIcon("Görseller\\ikikelimeRV.png"));
        ikiKelime.setBounds(608,490,150,40);
        ikiKelime.setBorderPainted(false);
        ikiKelime.setContentAreaFilled(false);

        ucKelime.setRolloverIcon(new ImageIcon("Görseller\\uckelimeRV.png"));
        ucKelime.setBounds(788,490,150,40);
        ucKelime.setBorderPainted(false);
        ucKelime.setContentAreaFilled(false);

        Font f = new Font("verdana",Font.BOLD,16);

        JLabel arkaplan = new JLabel(new ImageIcon("Görseller\\Arkaplan3.jpg"));
        arkaplan.setBounds(-250,-215,1866,1198);

        JLabel kelimeEtiket1 = new JLabel("");
        kelimeEtiket1.setFont(f);
        kelimeEtiket1.repaint();

        JLabel kelimeEtiket2 = new JLabel("");
        kelimeEtiket2.setFont(f);
        kelimeEtiket2.repaint();

        JLabel kelimeEtiket3 = new JLabel("");
        kelimeEtiket3.setFont(f);
        kelimeEtiket3.repaint();

        JButton durdurmaTusu = new JButton(new ImageIcon("Görseller\\durdurTusu.png"));
        durdurmaTusu.setRolloverIcon(new ImageIcon("Görseller\\durdurTusuRV.png"));
        durdurmaTusu.setBounds(608,250,150 ,40);
        durdurmaTusu.setContentAreaFilled(false);
        durdurmaTusu.setBorderPainted(false);

        JButton geriTusu = new JButton(new ImageIcon("Görseller\\kapiIkonu.png"));
        geriTusu.setContentAreaFilled(false); geriTusu.setBorderPainted(false);
        geriTusu.setToolTipText("Buradan ana menüye dönebilirsiniz");
        geriTusu.setBounds(1330,  732,  32,   32);

        JButton metinEkle = new JButton(new ImageIcon("Görseller\\metinEkleTusu.png"));
        metinEkle.setBounds(1175, 700, 150, 40);
        metinEkle.setRolloverIcon(new ImageIcon("Görseller\\metinEkleTusuRV.png"));
        metinEkle.setContentAreaFilled(false);
        metinEkle.setBorderPainted(false);

        for (int i = 0; i < 9 ; i++) {
            seviyeTuslari[i] = new JButton();
            seviyeTuslari[i].setContentAreaFilled(false);
            seviyeTuslari[i].setBorderPainted(false);
            panel.add(seviyeTuslari[i]);
        }

        seviyeTuslari[0].setBounds(428,530,150,40);
        seviyeTuslari[0].setIcon(new ImageIcon("Görseller\\seviyeTusu1.png"));
        seviyeTuslari[0].setRolloverIcon(new ImageIcon("Görseller\\seviyeTusuRV1.png"));
        seviyeTuslari[1].setBounds(428,570,150,40);
        seviyeTuslari[1].setIcon(new ImageIcon("Görseller\\seviyeTusu2.png"));
        seviyeTuslari[1].setRolloverIcon(new ImageIcon("Görseller\\seviyeTusuRV2.png"));
        seviyeTuslari[2].setBounds(428,610,150,40);
        seviyeTuslari[2].setIcon(new ImageIcon("Görseller\\seviyeTusu3.png"));
        seviyeTuslari[2].setRolloverIcon(new ImageIcon("Görseller\\seviyeTusuRV3.png"));

        seviyeTuslari[3].setBounds(608,530,150,40);
        seviyeTuslari[3].setIcon(new ImageIcon("Görseller\\seviyeTusu1.png"));
        seviyeTuslari[3].setRolloverIcon(new ImageIcon("Görseller\\seviyeTusuRV1.png"));
        seviyeTuslari[4].setBounds(608,570,150,40);
        seviyeTuslari[4].setIcon(new ImageIcon("Görseller\\seviyeTusu2.png"));
        seviyeTuslari[4].setRolloverIcon(new ImageIcon("Görseller\\seviyeTusuRV2.png"));
        seviyeTuslari[5].setBounds(608,610,150,40);
        seviyeTuslari[5].setIcon(new ImageIcon("Görseller\\seviyeTusu3.png"));
        seviyeTuslari[5].setRolloverIcon(new ImageIcon("Görseller\\seviyeTusuRV3.png"));

        seviyeTuslari[6].setBounds(788,530,150,40);
        seviyeTuslari[6].setIcon(new ImageIcon("Görseller\\seviyeTusu1.png"));
        seviyeTuslari[6].setRolloverIcon(new ImageIcon("Görseller\\seviyeTusuRV1.png"));
        seviyeTuslari[7].setBounds(788,570,150,40);
        seviyeTuslari[7].setIcon(new ImageIcon("Görseller\\seviyeTusu2.png"));
        seviyeTuslari[7].setRolloverIcon(new ImageIcon("Görseller\\seviyeTusuRV2.png"));
        seviyeTuslari[8].setBounds(788,610,150,40);
        seviyeTuslari[8].setIcon(new ImageIcon("Görseller\\seviyeTusu3.png"));
        seviyeTuslari[8].setRolloverIcon(new ImageIcon("Görseller\\seviyeTusuRV3.png"));

        panel.add(durdurmaTusu);
        panel.add(metinEkle);
        panel.add(birKelime);
        panel.add(ikiKelime);
        panel.add(ucKelime);
        panel.add(kelimeEtiket1);
        panel.add(kelimeEtiket2);
        panel.add(kelimeEtiket3);
        panel.add(arkaplan);
        panel.add(geriTusu);
        panel.add(arkaplan);

        setVisible(true);

        kelimeEtiket1.repaint();
        kelimeEtiket2.repaint();
        kelimeEtiket3.repaint();

        //Metinden okunan kelimeleri ekranda tek tek gösteren eylem
        birKelime.addActionListener(e -> {
            ikiKelime.setEnabled(false);
            ucKelime.setEnabled(false);
            for (int i = 3; i <9; i++) {
                seviyeTuslari[i].setEnabled(false);
            }

            kelimeEtiket1.setBounds(618,368,150,30);
            kelimeEtiket2.setBounds(0,0,0,0);
            kelimeEtiket3.setBounds(0,0,0,0);
            a = 0;
            z1 = new Timer(hiz1, e12 -> {
                kelimeEtiket1.setText(kelimeler.get(a));
                a++;
                if (a == kelimeler.size()){
                    ((Timer) e12.getSource()).stop();
                    JOptionPane.showMessageDialog(null,("Okunan kelime sayisi: " + kelimeler.size()) );
                    kelimeEtiket1.setBounds(0,0,0,0);
                    kelimeEtiket2.setBounds(0,0,0,0);
                    kelimeEtiket3.setBounds(0,0,0,0);

                    ikiKelime.setEnabled(true);
                    ucKelime.setEnabled(true);
                    for (int i = 3; i <9; i++) {
                        
                        seviyeTuslari[i].setEnabled(true);
                    }
                }
                repaint();
            });
            z1.start();
        });

        //Metinden okunan kelimeleri ekranda iki kelime olarak gösteren eylem
        ikiKelime.addActionListener(e -> {
            birKelime.setEnabled(false);
            ucKelime.setEnabled(false);
            for (int i = 0; i <9; i++) {
                if (i == 3){
                    i = 6;
                }
                seviyeTuslari[i].setEnabled(false);
            }

            kelimeEtiket1.setBounds(533,368,150,30);
            kelimeEtiket2.setBounds(800,368,150,30);
            kelimeEtiket3.setBounds(0,0,0,0);
            a = 0;
            z2 = new Timer(hiz1, e14 -> {
                kelimeEtiket1.setText(kelimeler.get(a));
                a++;
                if (a == kelimeler.size()){
                    ((Timer) e14.getSource()).stop();
                    JOptionPane.showMessageDialog(null,("Okunan kelime sayisi: " + kelimeler.size()));
                    kelimeEtiket1.setBounds(0,0,0,0);
                    kelimeEtiket2.setBounds(0,0,0,0);
                    kelimeEtiket3.setBounds(0,0,0,0);

                    birKelime.setEnabled(true);
                    ucKelime.setEnabled(true);
                    for (int i = 0; i <9; i++) {
                        if (i == 3){
                            i = 6;
                        }
                        seviyeTuslari[i].setEnabled(true);
                    }
                }
                kelimeEtiket2.setText(kelimeler.get(a));
                a++;
                if (a == kelimeler.size()){
                    ((Timer) e14.getSource()).stop();
                    JOptionPane.showMessageDialog(null,("Okunan kelime sayisi: " + kelimeler.size()));
                    kelimeEtiket1.setBounds(0,0,0,0);
                    kelimeEtiket2.setBounds(0,0,0,0);
                    kelimeEtiket3.setBounds(0,0,0,0);
                    birKelime.setEnabled(true);
                    ucKelime.setEnabled(true);
                    for (int i = 0; i <9; i++) {
                        if (i == 3){
                            i = 6;
                        }
                        seviyeTuslari[i].setEnabled(true);
                    }
                }
                repaint();
            });
            z2.start();
        });

        //Metinden okunan kelimeleri ekranda üç kelime olarak gösteren eylem
        ucKelime.addActionListener(e -> {
            birKelime.setEnabled(false);
            ikiKelime.setEnabled(false);
            for (int i = 0; i <6; i++) {
                seviyeTuslari[i].setEnabled(false);
            }
            kelimeEtiket1.setBounds(463,368,150,30);
            kelimeEtiket2.setBounds(623,368,150,30);
            kelimeEtiket3.setBounds(803,368,150,30);
            a = 0;
            z3 = new Timer(hiz1, e13 -> {
                kelimeEtiket1.setText(kelimeler.get(a));
                a++;
                if (a == kelimeler.size()){
                    ((Timer) e13.getSource()).stop();
                    JOptionPane.showMessageDialog(null,("Okunan kelime sayisi: " + kelimeler.size()));
                    kelimeEtiket1.setBounds(0,0,0,0);
                    kelimeEtiket2.setBounds(0,0,0,0);
                    kelimeEtiket3.setBounds(0,0,0,0);
                    birKelime.setEnabled(true);
                    ikiKelime.setEnabled(true);
                    for (int i = 0; i <6; i++) {
                        seviyeTuslari[i].setEnabled(true);
                    }
                }
                kelimeEtiket2.setText(kelimeler.get(a));
                a++;
                if (a == kelimeler.size()){
                    ((Timer) e13.getSource()).stop();
                    JOptionPane.showMessageDialog(null,("Okunan kelime sayisi: " + kelimeler.size()));
                    kelimeEtiket1.setBounds(0,0,0,0);
                    kelimeEtiket2.setBounds(0,0,0,0);
                    kelimeEtiket3.setBounds(0,0,0,0);
                    birKelime.setEnabled(true);
                    ikiKelime.setEnabled(true);
                    for (int i = 0; i <6; i++) {
                        seviyeTuslari[i].setEnabled(true);
                    }
                }
                kelimeEtiket3.setText(kelimeler.get(a));
                a++;
                if (a == kelimeler.size()){
                    ((Timer) e13.getSource()).stop();
                    JOptionPane.showMessageDialog(null,("Okunan kelime sayisi: " + kelimeler.size()));
                    kelimeEtiket1.setBounds(0,0,0,0);
                    kelimeEtiket2.setBounds(0,0,0,0);
                    kelimeEtiket3.setBounds(0,0,0,0);
                    kelimeEtiket1.setText("");
                    kelimeEtiket2.setText("");
                    kelimeEtiket3.setText("");

                    birKelime.setEnabled(true);
                    ikiKelime.setEnabled(true);
                    for (int i = 0; i <9; i++) {
                        seviyeTuslari[i].setEnabled(true);
                    }
                }
                repaint();
            });
            z3.start();
        });

        seviyeTuslari[0].addActionListener(e -> z1.setDelay(hiz1));
        seviyeTuslari[1].addActionListener(e -> z1.setDelay(hiz2));
        seviyeTuslari[2].addActionListener(e -> z1.setDelay(hiz3));

        seviyeTuslari[3].addActionListener(e -> z2.setDelay(hiz1));
        seviyeTuslari[4].addActionListener(e -> z2.setDelay(hiz2));
        seviyeTuslari[5].addActionListener(e -> z2.setDelay(hiz3));

        seviyeTuslari[6].addActionListener(e -> z3.setDelay(hiz1));
        seviyeTuslari[7].addActionListener(e -> z3.setDelay(hiz2));
        seviyeTuslari[8].addActionListener(e -> z3.setDelay(hiz3));

        //Dosya seçme butonunun eylemi
        metinEkle.addActionListener(e -> {
            JFileChooser fileChooser=new JFileChooser();
            fileChooser.showOpenDialog(fileChooser);
            file=fileChooser.getSelectedFile();
            metinYolu = file.getAbsolutePath();
            try {
                kelimeler = kelimeler(metinYolu);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

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

        durdurmaTusu.addActionListener(e -> {
            kelimeEtiket1.setBounds(0,0,0,0);
            kelimeEtiket2.setBounds(0,0,0,0);
            kelimeEtiket3.setBounds(0,0,0,0);

            kelimeEtiket1.setText("");
            kelimeEtiket2.setText("");
            kelimeEtiket3.setText("");

            birKelime.setEnabled(true);
            ikiKelime.setEnabled(true);
            ucKelime.setEnabled(true);

            for (int i = 0; i <9 ; i++) {
                seviyeTuslari[i].setEnabled(true);
            }
        });

    }

    private String metinOkuma(String s) throws IOException {
        File fr = new File(s);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fr),  "ISO-8859-9"));
        String satir;
        StringBuilder metin = new StringBuilder();
        while((satir = br.readLine()) != null){
            metin.append(satir).append("\n");
        }
        return metin.toString();
    }

    private ArrayList<String> kelimeler(String s) throws IOException {
        String metin = metinOkuma(s);
        StringBuilder klm = new StringBuilder();
        ArrayList<String> dizi = new ArrayList<>();
        for (int j = 0, i = 0; j < metin.length()-1 ; j++) {
            klm.append(metin.charAt(j));
            String bosluk = metin.charAt(j) + "";
            if (bosluk.equals(" ")) {
                dizi.add(i, klm.toString());
                klm = new StringBuilder();
                i++;
            }
        }
        return dizi;
    }

}