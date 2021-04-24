package hu.elte.madtycoon.ui.menuitems;

import hu.elte.madtycoon.core.Resources;

import javax.swing.*;
import java.awt.*;

public class Credits extends JFrame {
    private final JPanel panel;
    private  final JLabel label1;
    private final JLabel label2;
    private final JButton exit;
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public Credits() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.decode("#7d6d4b"));

        label1 = new JLabel("<html><br><br><br><br>Credits<br> </html>");
        label1.setOpaque(false);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setForeground(Color.decode("#1c1710"));
        label1.setFont(Resources.Instance.sansPro);

        label2 = new JLabel(Resources.Instance.creatorCredits);
        label2.setOpaque(false);
        label2.setForeground(Color.decode("#1c1710"));
        label2.setFont(Resources.Instance.sansPro);


        exit = new JButton();
        exit.setMargin(new Insets(200, 300, 0, 0));
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        exit.addActionListener(a -> {
           this.dispose();
        });

        exit.setIcon(new ImageIcon(Resources.Instance.gameExitButton));

        this.setPreferredSize(screenSize);
        this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(Resources.Instance.shopBackGroundImageFull, 0, 0, this);
            }
        });

        panel.add(label1);
        panel.add(label2);
        panel.add(exit);
        panel.setOpaque(false);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setAlignmentY(Component.CENTER_ALIGNMENT);

        this.add(panel, BorderLayout.PAGE_END);
        this.pack();
        this.setVisible(true);

    }
}
