package hu.elte.madtycoon.ui;

import hu.elte.madtycoon.core.Resources;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static java.lang.Math.round;

public class HUD extends JPanel
{

    private IEngine engine;
    private final JButton buildingMenu;
    private final JButton decorationMenu;
    private final JButton roadMenu;
    private final JButton stats;
    private final JButton employeeMenu;
    private final JButton moneyIcon;
    private JLabel moneyLabel;
    private JLabel happinessLabel;
    private JLabel timeLabel;
    private final JButton happiness;
    private final JButton time;
    private final JButton playPause;
    private final JButton fast;
    private final JButton exit;
    private final JButton options;
    private final JButton happinessArrow;
    private int i,j;
    private final float[] variations = new float[]{1,2.5F,5};
    private int prevHappyness = 0;

    public HUD(IEngine engine)
    {
        super();
        setPreferredSize(new Dimension(1920,110));

        this.engine = engine;
        i = 0;
        j = 0;


        buildingMenu = new JButton();
        buildingMenu.setOpaque(false);
        buildingMenu.setContentAreaFilled(false);
        buildingMenu.setBorderPainted(false);
        buildingMenu.addActionListener(e -> buildButtons());
        buildingMenu.setMargin(new Insets(25, 60, 0, 0));
        buildingMenu.setIcon(new ImageIcon(Resources.Instance.gameHouseBuildButton));

        decorationMenu = new JButton();
        decorationMenu.setOpaque(false);
        decorationMenu.setContentAreaFilled(false);
        decorationMenu.setBorderPainted(false);
        decorationMenu.addActionListener(e -> decorButtons());
        decorationMenu.setMargin(new Insets(25, 25, 0, 0));
        decorationMenu.setIcon(new ImageIcon(Resources.Instance.gameDecorBuildButton));

        roadMenu = new JButton();
        roadMenu.setOpaque(false);
        roadMenu.setContentAreaFilled(false);
        roadMenu.setBorderPainted(false);
        roadMenu.addActionListener(e -> System.out.println("Road"));
        roadMenu.setMargin(new Insets(25, 25, 0, 0));
        roadMenu.setIcon(new ImageIcon(Resources.Instance.gameRoadBuildButton));

        stats = new JButton();
        stats.setOpaque(false);
        stats.setContentAreaFilled(false);
        stats.setBorderPainted(false);
        stats.addActionListener(e -> new PopWindow());
        stats.setMargin(new Insets(25, 25, 0, 0));
        stats.setIcon(new ImageIcon(Resources.Instance.gameStatisticsButton));

        employeeMenu = new JButton();
        employeeMenu.setOpaque(false);
        employeeMenu.setContentAreaFilled(false);
        employeeMenu.setBorderPainted(false);
        employeeMenu.addActionListener(e -> new PopWindow());
        employeeMenu.setMargin(new Insets(25, 25, 0, 0));
        employeeMenu.setIcon(new ImageIcon(Resources.Instance.gameEmployeeButton));

        moneyIcon = new JButton();
        moneyIcon.setOpaque(false);
        moneyIcon.setContentAreaFilled(false);
        moneyIcon.setBorderPainted(false);
        //exit.addActionListener(e -> System.exit(0));
        moneyIcon.setMargin(new Insets(25, 90, 0, 0));
        moneyIcon.setIcon(new ImageIcon(Resources.Instance.gameMoneyIcon));

        moneyLabel = new JLabel();
        moneyLabel.setBorder(new EmptyBorder(30,0,0,0));
        moneyLabel.setForeground(Color.decode("#475425"));
        moneyLabel.setMaximumSize(new Dimension(100,50));
        moneyLabel.setPreferredSize(new Dimension(100,50));

        happiness = new JButton();
        happiness.setOpaque(false);
        happiness.setContentAreaFilled(false);
        happiness.setBorderPainted(false);
        //exit.addActionListener(e -> System.exit(0));
        happiness.setMargin(new Insets(25, 200, 0, 0));
        happiness.setIcon(new ImageIcon(Resources.Instance.gameSanityIcon));

        happinessLabel = new JLabel();
        happinessLabel.setBorder(new EmptyBorder(30,0,0,0));
        happinessLabel.setForeground(Color.decode("#475425"));
        happinessLabel.setMaximumSize(new Dimension(50,50));
        happinessLabel.setPreferredSize(new Dimension(50,50));

        happinessArrow = new JButton();
        happinessArrow.setOpaque(false);
        happinessArrow.setContentAreaFilled(false);
        happinessArrow.setBorderPainted(false);
        //exit.addActionListener(e -> System.exit(0));
        happinessArrow.setMargin(new Insets(25, 0, 0, 0));
        happinessArrow.setIcon(new ImageIcon(Resources.Instance.gameHappyArrowEmpty));


        time = new JButton();
        time.setOpaque(false);
        time.setContentAreaFilled(false);
        time.setBorderPainted(false);
        //exit.addActionListener(e -> System.exit(0));
        time.setMargin(new Insets(25, 100 , 0, 0));
        time.setIcon(new ImageIcon(Resources.Instance.gameTimeIcon));

        timeLabel = new JLabel();
        timeLabel.setBorder(new EmptyBorder(30,0,0,0));
        timeLabel.setForeground(Color.decode("#475425"));
        timeLabel.setMaximumSize(new Dimension(110,50));
        timeLabel.setPreferredSize(new Dimension(110,50));

        playPause = new JButton();
        playPause.setOpaque(false);
        playPause.setContentAreaFilled(false);
        playPause.setBorderPainted(false);
        playPause.addActionListener(e -> j++);
        playPause.setMargin(new Insets(25, 100, 0, 0));
        playPause.setIcon(new ImageIcon(Resources.Instance.gamePauseButton));

        fast = new JButton();
        fast.setOpaque(false);
        fast.setContentAreaFilled(false);
        fast.setBorderPainted(false);
        fast.addActionListener(e -> i++);
        fast.setMargin(new Insets(25, 0, 0, 0));
        fast.setIcon(new ImageIcon(Resources.Instance.gameSpeedButton));

        options = new JButton();
        options.setOpaque(false);
        options.setContentAreaFilled(false);
        options.setBorderPainted(false);
        //exit.addActionListener(e -> System.exit(0));
        options.setMargin(new Insets(25, 0, 0, 0));
        options.setIcon(new ImageIcon(Resources.Instance.gameSettingsButton));

        exit = new JButton();
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        exit.addActionListener(e -> System.exit(0));
        exit.setMargin(new Insets(25, 0, 0, 0));
        exit.setIcon(new ImageIcon(Resources.Instance.gameExitButton));

        add(buildingMenu);
        add(decorationMenu);
        add(roadMenu);
        add(stats);
        add(employeeMenu);
        add(moneyIcon);
        add(moneyLabel);
        add(happiness);
        add(happinessLabel);
        add(happinessArrow);
        add(time);
        add(timeLabel);
        add(playPause);
        add(fast);
        add(options);
        add(exit);

        try {
            Font ch_bell = Font.createFont(Font.TRUETYPE_FONT, new File("res/font/christmas_bell.otf")).deriveFont(46f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(ch_bell);
            moneyLabel.setFont(ch_bell);
            happinessLabel.setFont(ch_bell);
            timeLabel.setFont(ch_bell);
        } catch (IOException e) {
            e.printStackTrace();
        } catch(FontFormatException e) {
            e.printStackTrace();
        }
    }

    public void updateGUI()
    {
        //TODO draw game status via IEngine

        int money = engine.getMoney();
        moneyLabel.setText(String.valueOf(money));

        int happinessValue = round(engine.getOverallHappiness()*100);
        happinessLabel.setText(String.valueOf(happinessValue));
        if(prevHappyness>=happinessValue){
            happinessArrow.setIcon(new ImageIcon(Resources.Instance.gameHappyArrowUp));
        }else if (prevHappyness<happinessValue){
            happinessArrow.setIcon(new ImageIcon(Resources.Instance.gameHappyArrowDown));
        }else{
            happinessArrow.setIcon(new ImageIcon(Resources.Instance.gameHappyArrowEmpty));
        }
        prevHappyness = happinessValue;

        int gameTime = engine.getTime();
        int hours = gameTime / 60;
        int minutes = gameTime % 60;
        if(hours < 10 && minutes < 10) {
            timeLabel.setText("0" + hours + ":" + "0" + minutes);
        } else if(hours < 10 && minutes >= 10) {
            timeLabel.setText("0" + hours + ":" + minutes);
        } else if(hours >= 10 && minutes < 10) {
            timeLabel.setText(hours + ":" + "0" + minutes);
        } else if(hours >= 10 && minutes >= 10) {
            timeLabel.setText(hours + ":" + minutes);
        }

        engine.setTimeScale(variations[i%3]);
        if(i % 3 == 0) {
            fast.setIcon(new ImageIcon(Resources.Instance.gameSpeedButton));
        } else if(i %3 == 1) {
            fast.setIcon(new ImageIcon(Resources.Instance.gameSpeedButton2X));
        } else if(i % 3 == 2) {
            fast.setIcon(new ImageIcon(Resources.Instance.gameSpeedButton5X));
        }

        if(j % 2 == 0) {
            engine.setTimeScale(variations[i%3]);
            playPause.setIcon(new ImageIcon(Resources.Instance.gamePlayButton));
        } else if(j % 2 == 1) {
            engine.setTimeScale(0);
            playPause.setIcon(new ImageIcon(Resources.Instance.gamePauseButton));
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(Resources.Instance.gameHudImage, 0, 0, this);
    }

    private void buildButtons(){
        buildingMenu.removeActionListener(buildingMenu.getActionListeners()[0]);
        buildingMenu.setIcon(new ImageIcon(Resources.Instance.shopCoinFlipBuyButton));
        buildingMenu.addActionListener(e-> System.out.println("Coin build"));

        decorationMenu.removeActionListener(decorationMenu.getActionListeners()[0]);
        decorationMenu.setIcon(new ImageIcon(Resources.Instance.sthBuyButton));
        decorationMenu.addActionListener(e-> System.out.println("STH else build"));

        roadMenu.removeActionListener(roadMenu.getActionListeners()[0]);
        roadMenu.setIcon(new ImageIcon(Resources.Instance.sthBuyButton));
        roadMenu.addActionListener(e-> System.out.println("Sth else build"));

        stats.removeActionListener(stats.getActionListeners()[0]);
        stats.setIcon(new ImageIcon(Resources.Instance.sthBuyButton));
        stats.addActionListener(e-> System.out.println("Sth else build"));

        employeeMenu.removeActionListener(employeeMenu.getActionListeners()[0]);
        employeeMenu.setIcon(new ImageIcon(Resources.Instance.shopBackButton));
        employeeMenu.addActionListener(e -> resetButtons());
    }

    private void resetButtons(){
        buildingMenu.removeActionListener(buildingMenu.getActionListeners()[0]);
        buildingMenu.setIcon(new ImageIcon(Resources.Instance.gameHouseBuildButton));
        buildingMenu.addActionListener(e -> buildButtons());

        decorationMenu.removeActionListener(decorationMenu.getActionListeners()[0]);
        decorationMenu.setIcon(new ImageIcon(Resources.Instance.gameDecorBuildButton));
        decorationMenu.addActionListener(e-> decorButtons());

        roadMenu.removeActionListener(roadMenu.getActionListeners()[0]);
        roadMenu.setIcon(new ImageIcon(Resources.Instance.gameRoadBuildButton));
        roadMenu.addActionListener(e -> System.out.println("Road"));

        stats.removeActionListener(stats.getActionListeners()[0]);
        stats.setIcon(new ImageIcon(Resources.Instance.gameStatisticsButton));
        stats.addActionListener(e -> new PopWindow());

        employeeMenu.removeActionListener(employeeMenu.getActionListeners()[0]);
        employeeMenu.setIcon(new ImageIcon(Resources.Instance.gameEmployeeButton));
        employeeMenu.addActionListener(e -> new PopWindow());
    }

    private void decorButtons(){
        buildingMenu.removeActionListener(buildingMenu.getActionListeners()[0]);
        buildingMenu.setIcon(new ImageIcon(Resources.Instance.bushBuyButton));
        buildingMenu.addActionListener(e-> System.out.println("Bush build"));

        decorationMenu.removeActionListener(decorationMenu.getActionListeners()[0]);
        decorationMenu.setIcon(new ImageIcon(Resources.Instance.flowerBuyButton));
        decorationMenu.addActionListener(e-> System.out.println("Flower build"));

        roadMenu.removeActionListener(roadMenu.getActionListeners()[0]);
        roadMenu.setIcon(new ImageIcon(Resources.Instance.stickBuyButton));
        roadMenu.addActionListener(e-> System.out.println("Stick build"));

        stats.removeActionListener(stats.getActionListeners()[0]);
        stats.setIcon(new ImageIcon(Resources.Instance.firePitBuyButton));
        stats.addActionListener(e-> System.out.println("Firepit build"));

        employeeMenu.removeActionListener(employeeMenu.getActionListeners()[0]);
        employeeMenu.setIcon(new ImageIcon(Resources.Instance.shopBackButton));
        employeeMenu.addActionListener(e -> resetButtons());
    }
}
