package homework8;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {

    private JTextField inputArea;

    public CalculatorFrame() {
        setTitle("Calculator v 1.0");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setBounds(100, 100, 500, 500);

        setJMenuBar(createMenuBar());

        setLayout(new BorderLayout());

        add(createTopPanel(), BorderLayout.NORTH);

        add(createBottomPanel(), BorderLayout.CENTER);

        setVisible(true);

    }

    private JPanel createTopPanel() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        inputArea = new JTextField();
        inputArea.setEditable(false);
        top.add(inputArea, BorderLayout.CENTER);
        return top;
    }

    private JPanel createBottomPanel() {
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(4, 5));

        DigitButtonActionListener digitButtonActionListener = new DigitButtonActionListener(inputArea);

        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(digitButtonActionListener);
            bottom.add(btn);
        }
        JButton plus = new JButton("+");
        plus.addActionListener(e -> addCalcSymbol(plus.getText()));
        bottom.add(plus);
        JButton minus = new JButton("-");
        minus.addActionListener(e -> addCalcSymbol(minus.getText()));
        bottom.add(minus);
        JButton multiple = new JButton("*");
        multiple.addActionListener(e -> addCalcSymbol(multiple.getText()));
        bottom.add(multiple);
        JButton division = new JButton("/");
        division.addActionListener(e -> addCalcSymbol(division.getText()));
        bottom.add(division);
        JButton squareRoot = new JButton("sqrt");
        squareRoot.addActionListener(e -> doSqrt());
        bottom.add(squareRoot);
        JButton clear = new JButton("C");
        clear.addActionListener(e -> inputArea.setText(""));
        bottom.add(clear);
        JButton calc = new JButton("=");
        calc.addActionListener(new CalcButtonActionListener(inputArea));
        bottom.add(calc);

        return bottom;
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenu("Open");
        fileMenu.add(openItem);
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);
        exitItem.addActionListener(e -> System.exit(0));
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        return menuBar;
    }

    private void addCalcSymbol(String calcSym) {
        if ((!inputArea.getText().endsWith("+") && !inputArea.getText().endsWith("-") && !inputArea.getText().endsWith("*") && !inputArea.getText().endsWith("/") && !inputArea.getText().equals(""))
                || (inputArea.getText().equals("") && calcSym.equals("-"))) {
            inputArea.setText(inputArea.getText() + calcSym);
        }
    }

    private void doSqrt() {
        if (inputArea.getText().contains("+") || inputArea.getText().contains("-") || inputArea.getText().contains("*") || inputArea.getText().contains("/") || inputArea.getText().equals(""))
            return;
        inputArea.setText(String.valueOf(Math.sqrt(Double.parseDouble(inputArea.getText()))));
    }
}
