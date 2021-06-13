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
        if (textField.getText().equals("") || textField.getText().endsWith("+") || textField.getText().endsWith("-") || textField.getText().endsWith("*") || textField.getText().endsWith("/")) return;
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn");
        try {
            Object result = scriptEngine.eval(textField.getText());
            textField.setText(String.valueOf(result));
        } catch (ScriptException scriptException) {
            scriptException.printStackTrace();
        }
    }
}
