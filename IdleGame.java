//SIMPLE IDLE GAME MADE IN 3 HOURS

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.text.DecimalFormat;

public class IdleGame {

    private static double money = 100;
    private static int investedInLoans = 0;
    private static int investedInBonds = 0;
    private static int investedInETFs = 0;
    private static int currentETFsValue = 0;
    private static int loans = 0;
    private static int bonds = 0;
    private static int ETFs = 0;
    private static int ETFPrice = 0;
    private static double assets = money;
    private static double dividend = 1;
    private static int seconds = 0;
    private static int ETFChange = 0;
    private static int color = 0;
    private static int economicCycle = 0;
    private static double bondsRate = 0.1;
    private static double loansRate = 0.01;
    private static int minETFRate = 60;
    private static int maxETFRate = 100;
    private static int economicStatus = 0;
    private static final String[] economicStatusName = {"Expansion", "Peak", "Contraction", "Trough"};

    static DecimalFormat df = new DecimalFormat("0.00");
    static DecimalFormat dfd = new DecimalFormat("0.0000");

    static Random random = new Random();

    public static void main(String[] args) {

        // create frame
        JFrame frame = new JFrame("Idle Game");
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); - fullscreen
        frame.setSize(800,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setBackground(Color.WHITE);

        // create money label
        String euro = "\u20ac";

        JLabel moneyLabel = new JLabel("Money: " + euro + money  + "       ");
        JLabel loansLabel = new JLabel("Invested: " + euro + investedInLoans + "       ");
        JLabel loansNoLabel = new JLabel("Amount of loans: " + loans + "   ");
        JLabel bondsLabel = new JLabel("Invested: " + euro + investedInBonds + "       ");
        JLabel bondsNoLabel = new JLabel("Amount of bonds: " + bonds + "   ");
        JLabel ETFsLabel = new JLabel("Invested: " + euro + investedInETFs + "       ");
        JLabel ETFsNoLabel = new JLabel("Amount of ETFs: " + ETFs + "   ");
        JLabel assetsLabel = new JLabel("Assets: " + euro + assets + "        ");
        JLabel ETFPriceLabel = new JLabel("ETF price: " + euro + ETFPrice + "       ");
        JLabel bondPriceLabel = new JLabel("Bond price: " + euro + "1000       ");
        JLabel loanPriceLabel = new JLabel("Loan price: " + euro + "10       ");
        JLabel currentETFsValueLabel = new JLabel("Current value: " + euro + currentETFsValue + "       ");
        JLabel economicStatusLabel = new JLabel("Current status of the economy: " + economicStatusName[economicStatus]);
        String roundedBonds1 = df.format(bondsRate);
        String roundedLoans1 = df.format(loansRate);
        String roundedETF = dfd.format(dividend);
        JLabel loanRateLabel = new JLabel("Loan interest: " + euro + roundedLoans1 + "   ");
        JLabel bondRateLabel = new JLabel("Bond dividends: " + euro + roundedBonds1 + "   ");
        JLabel ETFRateLabel = new JLabel("ETF dividends: " + euro + roundedETF + "   ");

        ETFPrice = random.nextInt(minETFRate, maxETFRate);

        JButton settingsButton = new JButton();
        settingsButton.setFocusable(false);
        settingsButton.setText("Settings");


        JButton buyLoansButton = new JButton("Buy max " + (int) money / 10 + " loans");
        buyLoansButton.setFocusable(false);
        buyLoansButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int bought = (int) (money / 10);
                loans += bought;
                money -= bought * 10;
                investedInLoans += bought * 10;
                assets = loans * 10 + bonds * 1000 + ETFs * ETFPrice + money;
                String rounded1 = df.format(assets);
                assetsLabel.setText("Assets: " + euro + rounded1 + "       ");
                String rounded = df.format(money);
                moneyLabel.setText("Money: " + euro + rounded + "       ");
                loansLabel.setText("Invested: " + euro + investedInLoans + "       ");
                loansNoLabel.setText("Amount of loans: " + loans + "   ");
                buyLoansButton.setEnabled(!(money < 10));
            }
        });

        JButton buyBondsButton = new JButton("Buy max " + (int) money / 1000 + " bonds");
        buyBondsButton.setFocusable(false);
        buyBondsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int bought =(int) (money / 1000);
                bonds += bought;
                money -= bought * 1000;
                investedInBonds += bought * 1000;
                assets = loans * 10 + bonds * 1000 + ETFs * ETFPrice + money;
                String rounded1 = df.format(assets);
                assetsLabel.setText("Assets: " + euro + rounded1 + "       ");
                String rounded = df.format(money);
                moneyLabel.setText("Money: " + euro + rounded + "       ");
                bondsLabel.setText("Invested: " + euro + investedInBonds + "       ");
                bondsNoLabel.setText("Amount of bonds: " + bonds + "   ");
                buyBondsButton.setEnabled(!(money < 1000));
            }
        });

        JButton buyETFsButton = new JButton("Buy max " + (int) money / ETFPrice + " ETFs");
        buyETFsButton.setFocusable(false);
        buyETFsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int bought = (int) (money / ETFPrice);
                ETFs += bought;
                money -= bought * ETFPrice;
                investedInETFs += bought * ETFPrice;
                assets = loans * 10 + bonds * 1000 + ETFs * ETFPrice + money;
                currentETFsValue = ETFs * ETFPrice;
                String rounded1 = df.format(assets);
                assetsLabel.setText("Assets: " + euro + rounded1 + "       ");
                String rounded = df.format(money);
                moneyLabel.setText("Money: " + euro + rounded + "       ");
                ETFsLabel.setText("Invested: " + euro + investedInETFs + "       ");
                currentETFsValueLabel.setText("Current value: " + euro + currentETFsValue + "       ");
                ETFsNoLabel.setText("Amount of ETFs: " + ETFs + "   ");
                buyETFsButton.setEnabled(!(money < ETFPrice));
            }
        });

        JButton earnButton = new JButton("Earn " + euro + "1");
        earnButton.setFocusable(false);
        earnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                money += 1;
                assets = loans * 10 + bonds * 1000 + ETFs * ETFPrice + money;
                String rounded1 = df.format(assets);
                assetsLabel.setText("Assets: " + euro + rounded1 + "       ");
                String rounded = df.format(money);
                moneyLabel.setText("Money: " + euro + rounded + "       ");
                buyLoansButton.setEnabled(!(money < 10));
                buyBondsButton.setEnabled(!(money < 1000));
                buyETFsButton.setEnabled(!(money < ETFPrice));
            }
        });

        Timer timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(seconds == 10) {
                    if(ETFChange == 2) {
                        ETFPrice = random.nextInt(minETFRate, maxETFRate);
                        ETFChange = 0;
                    }
                    if(economicCycle == 20) {
                        if(economicStatus == 0) {
                            economicStatus = random.nextInt(0,2);
                            int tmp = random.nextInt(0,420);
                            if(tmp == 0 || tmp == 69) {
                                economicStatus = 3;
                            }
                        }
                        else if(economicStatus == 1) {
                            economicStatus = random.nextInt(1,3);
                            int tmp = random.nextInt(0,69);
                            if(tmp == 0) {
                                economicStatus = 3;
                            }
                        }
                        else if(economicStatus == 2) {
                            economicStatus = random.nextInt(0,3);
                            if(economicStatus == 1) {
                                economicStatus = 0;
                            }
                        }
                        else {
                            economicStatus = random.nextInt(0,4);
                            if(economicStatus == 1) {
                                economicStatus = 0;
                            }
                            else if(economicStatus == 2) {
                                economicStatus = 3;
                            }
                        }

                        economicStatusLabel.setText("Current status of the economy: " + economicStatusName[economicStatus]);
                        economicCycle = 0;

                        if(economicStatus == 0) {
                            bondsRate -= 0.1;
                            loansRate += 0.01;
                            minETFRate += random.nextInt(20,50);
                            maxETFRate += random.nextInt(40,80);
                        }
                        else if(economicStatus == 1) {
                            bondsRate -= 0.15;
                            loansRate += 0.02;
                            minETFRate += random.nextInt(40,70);
                            maxETFRate += random.nextInt(60,120);
                        }
                        else if(economicStatus == 2) {
                            bondsRate += 0.1;
                            loansRate -= 0.015;
                            minETFRate -= random.nextInt(40,80);
                            maxETFRate -= random.nextInt(80,120);
                        }
                        else {
                            bondsRate += 0.15;
                            loansRate -= 0.005;
                            minETFRate -= random.nextInt(50,90);
                            maxETFRate -= random.nextInt(110,170);
                        }
                    }

                    if(minETFRate < 10 || maxETFRate < 10) {
                        minETFRate = 20;
                        maxETFRate = 60;
                    }

                    if(maxETFRate <= minETFRate) {
                        maxETFRate = minETFRate + random.nextInt(20,60);
                    }

                    if(loansRate <= 0) {
                        loansRate = 0.01;
                    }

                    if(bondsRate <= 0) {
                        bondsRate = 0.03;
                    }

                    dividend = (double) ETFPrice / 89;
                    money = money + loans * loansRate + bonds * bondsRate + ETFs * dividend;
                    assets = loans * 10 + bonds * 1000 + ETFs * ETFPrice + money;
                    currentETFsValue = ETFs * ETFPrice;

                    String rounded1 = df.format(assets);
                    assetsLabel.setText("Assets: " + euro + rounded1 + "       ");
                    String rounded2 = df.format(money);
                    moneyLabel.setText("Money: " + euro + rounded2 + "       ");
                    ETFsLabel.setText("Invested: " + euro + investedInETFs + "       ");
                    ETFsNoLabel.setText("Amount of ETFs: " + ETFs + "   ");
                    bondsLabel.setText("Invested: " + euro + investedInBonds + "       ");
                    bondsNoLabel.setText("Amount of bonds: " + bonds + "   ");
                    loansLabel.setText("Invested: " + euro + investedInLoans + "       ");
                    loansNoLabel.setText("Amount of loans: " + loans + "   ");
                    ETFPriceLabel.setText("ETF price: " + euro + ETFPrice + "       ");
                    currentETFsValueLabel.setText("Current value: " + euro + currentETFsValue + "       ");

                    seconds = 0;
                    ETFChange++;
                    economicCycle++;
                }

                String roundedBonds = df.format(bondsRate);
                String roundedLoans = df.format(loansRate);
                String roundedEtf = dfd.format(dividend);
                bondRateLabel.setText("Bond dividends: " + euro + roundedBonds + "   ");
                loanRateLabel.setText("Loan interest: " + euro + roundedLoans + "   ");
                ETFRateLabel.setText("ETF dividends: " + euro + roundedEtf + "   ");

                buyLoansButton.setEnabled(!(money < 10));
                buyBondsButton.setEnabled(!(money < 1000));
                buyETFsButton.setEnabled(!(money < ETFPrice));
                buyLoansButton.setText("Buy max " + (int) money / 10 + " loans");
                buyBondsButton.setText("Buy max " + (int) money / 1000 + " bonds");
                buyETFsButton.setText("Buy max " + (int) money / ETFPrice + " ETFs");
                seconds++;

            }
        });

        // create panel to hold progress label and button
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout());
        JPanel panel5 = new JPanel();
        panel5.setLayout(new FlowLayout());

        panel1.add(assetsLabel);
        panel1.add(moneyLabel);
        panel1.add(earnButton);
        panel1.add(settingsButton);

        panel2.add(buyLoansButton);
        panel2.add(loanPriceLabel);
        panel2.add(loansLabel);
        panel2.add(loansNoLabel);
        panel2.add(loanRateLabel);


        panel3.add(buyBondsButton);
        panel3.add(bondPriceLabel);
        panel3.add(bondsLabel);
        panel3.add(bondsNoLabel);
        panel3.add(bondRateLabel);


        panel4.add(buyETFsButton);
        panel4.add(ETFPriceLabel);
        panel4.add(ETFsLabel);
        panel4.add(currentETFsValueLabel);
        panel4.add(ETFsNoLabel);
        panel4.add(ETFRateLabel);

        panel5.add(economicStatusLabel);

        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        panel.add(panel5);

        // add panel to frame
        frame.add(panel);
        frame.setVisible(true);


        // start timer
        timer.start();
        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame settingsPage = new JFrame("Settings Page");
                settingsPage.setLayout(new FlowLayout());
                settingsPage.setSize(frame.getSize());
                settingsPage.setLocationRelativeTo(null);
                settingsPage.setResizable(false);

                JPanel settingsPanel = new JPanel();
                settingsPanel.setLayout(new FlowLayout());
                settingsPage.add(settingsPanel);

                JButton returnBack = new JButton("Return");
                returnBack.setFocusable(false);
                JButton changeTheme = new JButton("Change Theme");
                changeTheme.setFocusable(false);
                settingsPanel.add(returnBack);
                settingsPanel.add(changeTheme);

                changeTheme.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(color == 0) {
                        panel.setBackground(Color.BLACK);
                        settingsPanel.setBackground(panel.getBackground());
                        settingsPage.setBackground(Color.BLACK);
                        JPanel[] panels = {panel1, panel2, panel3, panel4, panel5};
                        for (JPanel p : panels) {
                            p.setBackground(panel.getBackground());
                            Component[] components = p.getComponents();
                            for (Component component : components) {
                                // Check if the component is a JLabel
                                if (component instanceof JLabel) {
                                    // Cast the component to a JLabel and set the color
                                    JLabel label = (JLabel) component;
                                    label.setForeground(Color.WHITE);
                                }
                            }
                        }
                        color = 1;
                    }
                        else {
                            panel.setBackground(Color.WHITE);
                            settingsPanel.setBackground(panel.getBackground());
                            settingsPage.setBackground(Color.WHITE);
                            JPanel[] panels = {panel1, panel2, panel3, panel4, panel5};
                            for (JPanel p : panels) {
                                p.setBackground(panel.getBackground());
                                Component[] components = p.getComponents();
                                for (Component component : components) {
                                    // Check if the component is a JLabel
                                    if (component instanceof JLabel) {
                                        // Cast the component to a JLabel and set the color
                                        JLabel label = (JLabel) component;
                                        label.setForeground(Color.BLACK);
                                    }
                                }
                            }
                            color = 0;
                        }
                    }
                });
                returnBack.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        settingsPage.setVisible(false);
                        frame.setVisible(true);
                    }
                });
                settingsPage.add(settingsPanel);
                settingsPanel.add(returnBack);
                settingsPanel.add(changeTheme);
                settingsPage.setVisible(true);
                frame.setVisible(false);
            }
        });
    }
}
