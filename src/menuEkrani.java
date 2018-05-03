import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

class menuEkrani extends JFrame {

    private JLabel hizTestiEtiketi     = new JLabel(new ImageIcon("Görseller\\acýklama1.jpg"));
    private JLabel gozTestiEtiketi1    = new JLabel(new ImageIcon("Görseller\\acýklama2.jpg"));
    private JLabel gozTestiEtiketi2    = new JLabel(new ImageIcon("Görseller\\acýklama3.jpg"));
    private JLabel dikkatTestiEtiketi1 = new JLabel(new ImageIcon("Görseller\\acýklama4.jpg"));
    private JLabel dikkatTestiEtiketi2 = new JLabel(new ImageIcon("Görseller\\acýklama5.jpg"));
    private JLabel hizliOkumaEtiketi   = new JLabel(new ImageIcon("Görseller\\acýklama6.jpg"));

    menuEkrani(){

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JButton hizTestiTusu = new JButton("Hýz Testi", new ImageIcon("Görseller\\t1.jpg"));
        hizTestiTusu.setContentAreaFilled(false);
        hizTestiTusu.setBorderPainted(false);

        JButton hizliOkumaTusu = new JButton("Hýzlý Okuma", new ImageIcon("Görseller\\t6.jpg"));
        hizliOkumaTusu.setContentAreaFilled(false);
        hizliOkumaTusu.setBorderPainted(false);

        JButton gozTestiTusu1 = new JButton("Göz Alýþtýrmasý - 1", new ImageIcon("Görseller\\t2.jpg"));
        gozTestiTusu1.setContentAreaFilled(false);
        gozTestiTusu1.setBorderPainted(false);

        JButton gozTestiTusu2 = new JButton("Göz Alýþtýrmasý - 1", new ImageIcon("Görseller\\t3.jpg"));
        gozTestiTusu2.setContentAreaFilled(false);
        gozTestiTusu2.setBorderPainted(false);

        JButton dikkatTestiTusu1 = new JButton("Dikkat Alýþtýrmasý - 1", new ImageIcon("Görseller\\t4.jpg"));
        dikkatTestiTusu1.setContentAreaFilled(false);
        dikkatTestiTusu1.setBorderPainted(false);

        JButton dikkatTestiTusu2 = new JButton("Dikkat Alýþtýrmasý - 2", new ImageIcon("Görseller\\t5.jpg"));
        dikkatTestiTusu2.setContentAreaFilled(false);
        dikkatTestiTusu2.setBorderPainted(false);

        JButton cikisTusu = new JButton(new ImageIcon("Görseller\\kapiIkonu.png"));
        cikisTusu.setToolTipText("Buradan programý sonlandýrabilirsiniz.");
        cikisTusu.setContentAreaFilled(false);
        cikisTusu.setBorderPainted(false);

        JLabel arkaplan = new JLabel(new ImageIcon("Görseller\\Arkaplan.jpg"));

        hizTestiEtiketi.setVisible(false);
        gozTestiEtiketi1.setVisible(false);
        gozTestiEtiketi2.setVisible(false);
        dikkatTestiEtiketi1.setVisible(false);
        dikkatTestiEtiketi2.setVisible(false);
        hizliOkumaEtiketi.setVisible(false);

        setVisible(true);

        hizTestiTusu.setBounds(         123,  75, 150, 50);
        hizTestiEtiketi.setBounds(      123, 130, 150,248);

        gozTestiTusu1.setBounds(        318,  75, 150, 50);
        gozTestiEtiketi1.setBounds(     318, 130, 150,270);

        gozTestiTusu2.setBounds(        513,  75,  150, 50);
        gozTestiEtiketi2.setBounds(     513,  130, 150, 270);

        dikkatTestiTusu1.setBounds(     708,  75,  150, 50);
        dikkatTestiEtiketi1.setBounds(  708,  130, 150, 330);

        dikkatTestiTusu2.setBounds(     903,  75,  150, 50);
        dikkatTestiEtiketi2.setBounds(  903,  130, 150, 320);

        hizliOkumaTusu.setBounds(       1103,  75,  150, 50);
        hizliOkumaEtiketi.setBounds(    1103,  130, 150, 240);

        cikisTusu.setBounds(1326,730,32,32);

        arkaplan.setBounds(-250, -215,1866 , 1198);

        panel.add(cikisTusu);
        panel.add(hizTestiTusu);
        panel.add(hizliOkumaTusu);
        panel.add(gozTestiTusu1);
        panel.add(gozTestiTusu2);
        panel.add(dikkatTestiTusu1);
        panel.add(dikkatTestiTusu2);

        panel.add(hizTestiEtiketi);
        panel.add(gozTestiEtiketi1);
        panel.add(gozTestiEtiketi2);
        panel.add(dikkatTestiEtiketi1);
        panel.add(dikkatTestiEtiketi2);
        panel.add(hizliOkumaEtiketi);

        panel.add(arkaplan);
        repaint();

        cikisTusu.addActionListener(e -> System.exit(0));
        cikisTusu.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                cikisTusu.setBackground(Color.white);
                cikisTusu.setContentAreaFilled(true);
            }
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                cikisTusu.setContentAreaFilled(false);
            }
        });

        hizTestiTusu.setRolloverIcon(new ImageIcon("Görseller\\t11.jpg"));
        gozTestiTusu1.setRolloverIcon(new ImageIcon("Görseller\\t22.jpg"));
        gozTestiTusu2.setRolloverIcon(new ImageIcon("Görseller\\t33.jpg"));
        dikkatTestiTusu1.setRolloverIcon(new ImageIcon("Görseller\\t44.jpg"));
        dikkatTestiTusu2.setRolloverIcon(new ImageIcon("Görseller\\t55.jpg"));
        hizliOkumaTusu.setRolloverIcon(new ImageIcon("Görseller\\t66.jpg"));


        hizTestiTusu.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                try {
                    new hizTestiEkrani();

                } catch (IOException | BadLocationException e1) {
                    e1.printStackTrace();
                }
                setVisible(false);
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                hizTestiEtiketi.setVisible(true);
                repaint();
            }
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                hizTestiEtiketi.setVisible(false);
                repaint();
            }
        });

        gozTestiTusu1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                new gozTesti1();
                setVisible(false);
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                gozTestiEtiketi1.setVisible(true);
                repaint();
            }
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                gozTestiEtiketi1.setVisible(false);
                repaint();
            }
        });

        gozTestiTusu2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                new gozTesti2();
                setVisible(false);
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                gozTestiEtiketi2.setVisible(true);
                repaint();
            }
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                gozTestiEtiketi2.setVisible(false);
                repaint();
            }
        });

        dikkatTestiTusu1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                try {
                    new dikkatTesti1();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                setVisible(false);
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                dikkatTestiEtiketi1.setVisible(true);
                repaint();
            }
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                dikkatTestiEtiketi1.setVisible(false);
                repaint();
            }
        });

        dikkatTestiTusu2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                try {
                    new dikkatTesti2();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                setVisible(false);
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                dikkatTestiEtiketi2.setVisible(true);
                repaint();
            }
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                dikkatTestiEtiketi2.setVisible(false);
                repaint();
            }
        });

        hizliOkumaTusu.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                try {
                    new hizliOkumaEkrani();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                setVisible(false);
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                hizliOkumaEtiketi.setVisible(true);
                repaint();
            }
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                hizliOkumaEtiketi.setVisible(false);
                repaint();
            }
        });


    }

}