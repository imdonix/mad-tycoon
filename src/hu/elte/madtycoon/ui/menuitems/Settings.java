package hu.elte.madtycoon.ui.menuitems;

import hu.elte.madtycoon.core.Resources;
import hu.elte.madtycoon.core.Sounds;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Settings extends JFrame {
    private final JPanel mainPanel;
    private final JPanel musicPanel;
    private final JLabel titleLabel;
    private final JLabel musicLabel;
    private final JButton musicButton;
    private final JButton exit;
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private int i,j;

    public Settings() {
        i = 0;
        j = 0;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.decode("#7d6d4b"));

        musicPanel = new JPanel();
        musicPanel.setLayout(new BoxLayout(musicPanel, BoxLayout.X_AXIS));
        musicPanel.setBorder(new EmptyBorder(100,0,50,0));
        musicPanel.setBackground(Color.decode("#7d6d4b"));

        titleLabel = new JLabel("<html><br><br><br><br>Settings<br><br><br></html>");
        titleLabel.setOpaque(false);
        titleLabel.setForeground(Color.decode("#1c1710"));
        titleLabel.setFont(Resources.Instance.chBell);

        musicLabel = new JLabel();
        musicLabel.setOpaque(false);
        musicLabel.setText("Music :");
        musicLabel.setForeground(Color.decode("#1c1710"));
        musicLabel.setFont(Resources.Instance.sansPro);

        musicButton = new JButton();
        musicButton.setMargin(new Insets(0, 100, 0, 0));
        musicButton.setOpaque(false);
        musicButton.setContentAreaFilled(false);
        musicButton.setBorderPainted(false);
        musicButton.addActionListener(a -> {
            j++;
            musicSetting();
        });

        exit = new JButton();
        exit.setMargin(new Insets(200, 0, 0, 0));
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        exit.addActionListener(a -> {
            this.dispose();
        });

        if(Sounds.getMusic()) {
            musicButton.setIcon(new ImageIcon(Resources.Instance.closeButton));
        } else {
            musicButton.setIcon(new ImageIcon(Resources.Instance.openButton));
        }
        exit.setIcon(new ImageIcon(Resources.Instance.gameExitButton));

        this.setPreferredSize(screenSize);
        this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(Resources.Instance.shopBackGroundImageFull, 0, 0, this);
            }
        });

        mainPanel.add(titleLabel);
        musicPanel.add(musicLabel);
        musicPanel.add(musicButton);
        mainPanel.add(musicPanel);
        mainPanel.add(exit);
        mainPanel.setOpaque(false);
        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        this.add(mainPanel, BorderLayout.PAGE_END);
        this.pack();
        this.setVisible(true);

    }

    public void musicSetting() {
        if (j % 2 == 1) {
            Sounds.setMusic(false);
            musicButton.setIcon(new ImageIcon(Resources.Instance.openButton));
        } else {
            Sounds.setMusic(true);
            musicButton.setIcon(new ImageIcon(Resources.Instance.closeButton));
        }
    }
}
