package homework8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcButtonActionListener implements ActionListener {
    private final JTextField textField;

    public CalcButtonActionListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (textField.getText().equals("") || textField.getText().endsWith("+") || textField.getText().endsWith("-") || textField.getText().endsWith("*") || textField.getText().endsWith("/"))
            return;
        evaluateByMyLogic();
//        evaluateByScriptEngine();

    }

    public void evaluateByScriptEngine() {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn");
        try {
            Object result = scriptEngine.eval(textField.getText());
            textField.setText(String.valueOf(result));
        } catch (ScriptException scriptException) {
            scriptException.printStackTrace();
        }
    }

    public void evaluateByMyLogic() {
        textField.setText(String.valueOf(doCalculation(textField.getText())));
    }

    private double doCalculation(String s) {
        double result = 0;
        String[] arrPlus = s.split("\\+");
        for (int i = 0; i < arrPlus.length; i++) {
            if (arrPlus[i].contains("*") || arrPlus[i].contains("/") || arrPlus[i].contains("-")) {
                result = result + checkMinusAndCalc(arrPlus[i]);
            } else {
                result = result + Double.parseDouble(arrPlus[i]);
            }
        }
        return result;
    }

    private double checkMinusAndCalc(String s) {
        double result = 0;
        String[] arrMinus = s.split("-");
        if (arrMinus[0].length() == 0) {
            for (int i = 1; i < arrMinus.length; i++) {
                if (arrMinus[i].contains("*") || arrMinus[i].contains("/")) {
                    result = result - checkMultipleAndCalc(arrMinus[i]);
                } else {
                    result = result - Double.parseDouble(arrMinus[i]);
                }
            }
        } else {
            result = result + checkMultipleAndCalc(arrMinus[0]);
            for (int i = 1; i < arrMinus.length; i++) {
                if (arrMinus[i].contains("*") || arrMinus[i].contains("/")) {
                    result = result - checkMultipleAndCalc(arrMinus[i]);
                } else {
                    result = result - Double.parseDouble(arrMinus[i]);
                }
            }
        }
        return result;
    }

    private double checkMultipleAndCalc(String s) {
        double result = 1;
        String[] arrMultiple = s.split("\\*");
        for (int i = 0; i < arrMultiple.length; i++) {
            if (arrMultiple[i].contains("/")) {
                result = result * checkDivisionAndCalc(arrMultiple[i]);
            } else {
                result = result * Double.parseDouble(arrMultiple[i]);
            }
        }
        return result;
    }

    private double checkDivisionAndCalc(String s) {
        String[] arrDivision = s.split("/");
        double result = Double.parseDouble(arrDivision[0]);

        for (int i = 1; i < arrDivision.length; i++) {
            result = result / Double.parseDouble(arrDivision[i]);

        }
        return result;
    }
}
