package com.lab.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.text.DecimalFormat;

public class MainController {
    @FXML
    private TextField mainTextField;
    private double first_number, second_number;
    private String operation;
    public Label label_history;

    public void one_click() {
        String old_value = mainTextField.getText();
        String new_value = "1";
        mainTextField.setText(old_value + new_value);
    }
    public void two_click() {
        String old_value = mainTextField.getText();
        String new_value = "2";
        mainTextField.setText(old_value + new_value);
    }
    public void three_click() {
        String old_value = mainTextField.getText();
        String new_value = "3";
        mainTextField.setText(old_value + new_value);
    }
    public void four_click() {
        String old_value = mainTextField.getText();
        String new_value = "4";
        mainTextField.setText(old_value + new_value);
    }
    public void five_click() {
        String old_value = mainTextField.getText();
        String new_value = "5";
        mainTextField.setText(old_value + new_value);
    }
    public void six_click() {
        String old_value = mainTextField.getText();
        String new_value = "6";
        mainTextField.setText(old_value + new_value);
    }
    public void seven_click() {
        String old_value = mainTextField.getText();
        String new_value = "7";
        mainTextField.setText(old_value + new_value);
    }
    public void eight_click() {
        String old_value = mainTextField.getText();
        String new_value = "8";
        mainTextField.setText(old_value + new_value);
    }
    public void nine_click() {
        String old_value = mainTextField.getText();
        String new_value = "9";
        mainTextField.setText(old_value + new_value);
    }
    public void zero_click() {
        String old_value = mainTextField.getText();
        String new_value = "0";
        mainTextField.setText(old_value + new_value);
    }
    public void coma_click() {
        String old_value = mainTextField.getText();
        int tmp = old_value.indexOf(".");
        String new_value = ".";

        if (old_value.isEmpty())
            mainTextField.setText("");
        else if (tmp > 0)
            mainTextField.setText(old_value);
        else
            mainTextField.setText(old_value + new_value);
    }
    public void clear_click() {
        String tmp = mainTextField.getText();
        if(tmp.isEmpty())
            label_history.setText("");
        mainTextField.setText("");
    }

    public void minus_click() {
        String value = mainTextField.getText();
        double value_number = Double.parseDouble(value);
        this.first_number = value_number;
        mainTextField.setText("");
        label_history.setText(value + "-");
        operation = "-";
    }
    public void add_click() {
        String value = mainTextField.getText();
        double value_number = Double.parseDouble(value);
        this.first_number = value_number;
        mainTextField.setText("");
        label_history.setText(value + "+");
        operation = "+";
    }
    public void div_click() {
        String value = mainTextField.getText();
        double value_number = Double.parseDouble(value);
        this.first_number = value_number;
        mainTextField.setText("");
        label_history.setText(value + "/");
        operation = "/";
    }
    public void multi_click() {
        String value = mainTextField.getText();
        double value_number = Double.parseDouble(value);
        this.first_number = value_number;
        mainTextField.setText("");
        label_history.setText(value + "*");
        operation = "*";
    }

    public void equals_click() {
        switch (operation) {
            case "-":
                String minus_formatted_text;
                String minus_value = mainTextField.getText();
                this.second_number = Double.parseDouble(minus_value);
                double minus_result = first_number - second_number;

                if (minus_result%1 == 0) {
                    DecimalFormat format = new DecimalFormat("0");
                    minus_formatted_text = format.format(minus_result);
                }
                else {
                    minus_formatted_text = String.valueOf(minus_result);
                }

                mainTextField.setText(minus_formatted_text);
                String minus_old_label = label_history.getText();
                label_history.setText(minus_old_label+minus_value);
                break;

            case "+":
                String add_formatted_text;
                String add_value = mainTextField.getText();
                this.second_number = Double.parseDouble(add_value);
                double add_result = first_number + second_number;

                if (add_result%1 == 0) {
                    DecimalFormat format = new DecimalFormat("0");
                    add_formatted_text = format.format(add_result);
                }
                else {
                    add_formatted_text = String.valueOf(add_result);
                }

                mainTextField.setText(String.valueOf(add_formatted_text));
                String add_old_label = label_history.getText();
                label_history.setText(add_old_label+add_value);
                break;

            case "/":
                String div_formatted_text;
                String div_value = mainTextField.getText();
                this.second_number = Double.parseDouble(div_value);
                double div_result = first_number / second_number;


                if (div_result%1 == 0) {
                    DecimalFormat format = new DecimalFormat("0");
                    div_formatted_text = format.format(div_result);
                }
                else {
                    div_formatted_text = String.valueOf(div_result);
                }

                mainTextField.setText(String.valueOf(div_formatted_text));
                String div_old_label = label_history.getText();
                label_history.setText(div_old_label+div_value);
                break;

            case "*":
                String multi_formatted_text;
                String multi_value = mainTextField.getText();
                this.second_number = Double.parseDouble(multi_value);
                double multi_result = first_number * second_number;

                if (multi_result%1 == 0) {
                    DecimalFormat format = new DecimalFormat("0");
                    multi_formatted_text = format.format(multi_result);
                }
                else {
                    multi_formatted_text = String.valueOf(multi_result);
                }

                mainTextField.setText(String.valueOf(multi_formatted_text));
                String multi_old_label = label_history.getText();
                label_history.setText(multi_old_label+multi_value);
                break;
        }
    }
    public void frac_click() {
        String frac_old_label = label_history.getText();

        if (frac_old_label.isEmpty()) {
            String frac_formatted_text;
            String frac_value = mainTextField.getText();
            this.second_number = Double.parseDouble(frac_value);
            double frac_result = 1 / second_number;

            if (frac_result % 1 == 0) {
                DecimalFormat format = new DecimalFormat("0");
                frac_formatted_text = format.format(frac_result);
            } else {
                frac_formatted_text = String.valueOf(frac_result);
            }

            mainTextField.setText(String.valueOf(frac_formatted_text));
            label_history.setText(frac_old_label +"1/"+ second_number);
        }

        else {
            if (operation.equals("+")) {
                frac_old_label = frac_old_label.replace("+", "");
                double prom_value = Double.parseDouble(frac_old_label);
                String frac_value = mainTextField.getText();
                this.second_number = Double.parseDouble(frac_value);
                double frac_result = (1 / second_number) + prom_value;
                double frac_base_result = 1/second_number;
                mainTextField.setText(String.valueOf(frac_result));

                String frac_formatted_text;
                if (frac_result % 1 == 0) {
                    DecimalFormat format = new DecimalFormat("0");
                    frac_formatted_text = format.format(frac_result);
                } else {
                    frac_formatted_text = String.valueOf(frac_result);
                }

                mainTextField.setText(String.valueOf(frac_formatted_text));
                label_history.setText(frac_old_label+"+"+frac_base_result);
            }

            else if (operation.equals("-")) {
                frac_old_label = frac_old_label.replace("-", "");
                double prom_value = Double.parseDouble(frac_old_label);
                String frac_value = mainTextField.getText();
                this.second_number = Double.parseDouble(frac_value);
                double frac_result = (1 / second_number) - prom_value;
                double frac_base_result = 1/second_number;
                mainTextField.setText(String.valueOf(frac_result));

                String frac_formatted_text;
                if (frac_result % 1 == 0) {
                    DecimalFormat format = new DecimalFormat("0");
                    frac_formatted_text = format.format(frac_result);
                } else {
                    frac_formatted_text = String.valueOf(frac_result);
                }

                mainTextField.setText(String.valueOf(frac_formatted_text));
                label_history.setText(frac_old_label+"-"+frac_base_result);
            }

            else if (operation.equals("*")) {
                frac_old_label = frac_old_label.replace("*", "");
                double prom_value = Double.parseDouble(frac_old_label);
                String frac_value = mainTextField.getText();
                this.second_number = Double.parseDouble(frac_value);
                double frac_result = (1 / second_number) * prom_value;
                double frac_base_result = 1/second_number;
                mainTextField.setText(String.valueOf(frac_result));

                String frac_formatted_text;
                if (frac_result % 1 == 0) {
                    DecimalFormat format = new DecimalFormat("0");
                    frac_formatted_text = format.format(frac_result);
                } else {
                    frac_formatted_text = String.valueOf(frac_result);
                }

                mainTextField.setText(String.valueOf(frac_formatted_text));
                label_history.setText(frac_old_label+"*"+frac_base_result);
            }

            else if (operation.equals("/")) {
                frac_old_label = frac_old_label.replace("/", "");
                double prom_value = Double.parseDouble(frac_old_label);
                String frac_value = mainTextField.getText();
                this.second_number = Double.parseDouble(frac_value);
                double frac_result = (1 / second_number) / prom_value;
                double frac_base_result = 1/second_number;
                mainTextField.setText(String.valueOf(frac_result));

                String frac_formatted_text;
                if (frac_result % 1 == 0) {
                    DecimalFormat format = new DecimalFormat("0");
                    frac_formatted_text = format.format(frac_result);
                } else {
                    frac_formatted_text = String.valueOf(frac_result);
                }

                mainTextField.setText(String.valueOf(frac_formatted_text));
                label_history.setText(frac_old_label+"/"+frac_base_result);
            }
        }
    }
    public void perc_click() {
        String perc_old_label = label_history.getText();

        if (perc_old_label.isEmpty()) {
            String perc_formatted_text;
            String perc_value = mainTextField.getText();
            this.second_number = Double.parseDouble(perc_value);
            double perc_result = second_number/100;

            if (perc_result % 1 == 0) {
                DecimalFormat format = new DecimalFormat("0");
                perc_formatted_text = format.format(perc_result);
            } else {
                perc_formatted_text = String.valueOf(perc_result);
            }

            mainTextField.setText(String.valueOf(perc_formatted_text));
            label_history.setText(perc_old_label + second_number+"%");
        }

        else {
            if (operation.equals("+")) {
                perc_old_label = perc_old_label.replace("+", "");
                double prom_value = Double.parseDouble(perc_old_label);
                String perc_value = mainTextField.getText();
                this.second_number = Double.parseDouble(perc_value);
                double perc_result = (second_number/100) + prom_value;
                double perc_base_result = second_number/100;
                mainTextField.setText(String.valueOf(perc_result));

                String perc_formatted_text;
                if (perc_result % 1 == 0) {
                    DecimalFormat format = new DecimalFormat("0");
                    perc_formatted_text = format.format(perc_result);
                } else {
                    perc_formatted_text = String.valueOf(perc_result);
                }

                mainTextField.setText(String.valueOf(perc_formatted_text));
                label_history.setText(perc_old_label+"+"+perc_base_result);
            }

            else if (operation.equals("-")) {
                perc_old_label = perc_old_label.replace("-", "");
                double prom_value = Double.parseDouble(perc_old_label);
                String perc_value = mainTextField.getText();
                this.second_number = Double.parseDouble(perc_value);
                double perc_result = (second_number/100) - prom_value;
                double perc_base_result = second_number/100;
                mainTextField.setText(String.valueOf(perc_result));

                String perc_formatted_text;
                if (perc_result % 1 == 0) {
                    DecimalFormat format = new DecimalFormat("0");
                    perc_formatted_text = format.format(perc_result);
                } else {
                    perc_formatted_text = String.valueOf(perc_result);
                }

                mainTextField.setText(String.valueOf(perc_formatted_text));
                label_history.setText(perc_old_label+"-"+perc_base_result);
            }

            else if (operation.equals("*")) {
                perc_old_label = perc_old_label.replace("*", "");
                double prom_value = Double.parseDouble(perc_old_label);
                String perc_value = mainTextField.getText();
                this.second_number = Double.parseDouble(perc_value);
                double perc_result = (second_number/100) * prom_value;
                double perc_base_result = second_number/100;
                mainTextField.setText(String.valueOf(perc_result));

                String perc_formatted_text;
                if (perc_result % 1 == 0) {
                    DecimalFormat format = new DecimalFormat("0");
                    perc_formatted_text = format.format(perc_result);
                } else {
                    perc_formatted_text = String.valueOf(perc_result);
                }

                mainTextField.setText(String.valueOf(perc_formatted_text));
                label_history.setText(perc_old_label+"*"+perc_base_result);
            }

            else if (operation.equals("/")) {
                perc_old_label = perc_old_label.replace("/", "");
                double prom_value = Double.parseDouble(perc_old_label);
                String perc_value = mainTextField.getText();
                this.second_number = Double.parseDouble(perc_value);
                double perc_result = (second_number/100) / prom_value;
                double perc_base_result = second_number/100;
                mainTextField.setText(String.valueOf(perc_result));

                String perc_formatted_text;
                if (perc_result % 1 == 0) {
                    DecimalFormat format = new DecimalFormat("0");
                    perc_formatted_text = format.format(perc_result);
                } else {
                    perc_formatted_text = String.valueOf(perc_result);
                }

                mainTextField.setText(String.valueOf(perc_formatted_text));
                label_history.setText(perc_old_label+"/"+perc_base_result);
            }
        }
    }
    public void sqrt_click() {
        String sqrt_old_label = label_history.getText();

        if (sqrt_old_label.isEmpty()) {
            String sqrt_formatted_text;
            String sqrt_value = mainTextField.getText();
            this.second_number = Double.parseDouble(sqrt_value);
            double sqrt_result = Math.sqrt(second_number);

            if (sqrt_result % 1 == 0) {
                DecimalFormat format = new DecimalFormat("0");
                sqrt_formatted_text = format.format(sqrt_result);
            } else {
                sqrt_formatted_text = String.valueOf(sqrt_result);
            }

            mainTextField.setText(String.valueOf(sqrt_formatted_text));
            label_history.setText(sqrt_old_label +"√"+ second_number);
        }

        else {
            if (operation.equals("+")) {
                sqrt_old_label = sqrt_old_label.replace("+", "");
                double prom_value = Double.parseDouble(sqrt_old_label);
                String sqrt_value = mainTextField.getText();
                this.second_number = Double.parseDouble(sqrt_value);
                double sqrt_result = Math.sqrt(second_number)+ prom_value;
                double sqrt_base_result = Math.sqrt(second_number);
                mainTextField.setText(String.valueOf(sqrt_result));

                String sqrt_formatted_text;
                if (sqrt_result % 1 == 0) {
                    DecimalFormat format = new DecimalFormat("0");
                    sqrt_formatted_text = format.format(sqrt_result);
                } else {
                    sqrt_formatted_text = String.valueOf(sqrt_result);
                }

                mainTextField.setText(String.valueOf(sqrt_formatted_text));
                label_history.setText(sqrt_old_label+"+"+sqrt_base_result);
            }

            else if (operation.equals("-")) {
                sqrt_old_label = sqrt_old_label.replace("-", "");
                double prom_value = Double.parseDouble(sqrt_old_label);
                String sqrt_value = mainTextField.getText();
                this.second_number = Double.parseDouble(sqrt_value);
                double sqrt_result = Math.sqrt(second_number) - prom_value;
                double sqrt_base_result = Math.sqrt(second_number);
                mainTextField.setText(String.valueOf(sqrt_result));

                String sqrt_formatted_text;
                if (sqrt_result % 1 == 0) {
                    DecimalFormat format = new DecimalFormat("0");
                    sqrt_formatted_text = format.format(sqrt_result);
                } else {
                    sqrt_formatted_text = String.valueOf(sqrt_result);
                }

                mainTextField.setText(String.valueOf(sqrt_formatted_text));
                label_history.setText(sqrt_old_label+"-"+sqrt_base_result);
            }

            else if (operation.equals("*")) {
                sqrt_old_label = sqrt_old_label.replace("*", "");
                double prom_value = Double.parseDouble(sqrt_old_label);
                String sqrt_value = mainTextField.getText();
                this.second_number = Double.parseDouble(sqrt_value);
                double sqrt_result = Math.sqrt(second_number) * prom_value;
                double sqrt_base_result = Math.sqrt(second_number);
                mainTextField.setText(String.valueOf(sqrt_result));

                String sqrt_formatted_text;
                if (sqrt_result % 1 == 0) {
                    DecimalFormat format = new DecimalFormat("0");
                    sqrt_formatted_text = format.format(sqrt_result);
                } else {
                    sqrt_formatted_text = String.valueOf(sqrt_result);
                }

                mainTextField.setText(String.valueOf(sqrt_formatted_text));
                label_history.setText(sqrt_old_label+"*"+sqrt_base_result);
            }

            else if (operation.equals("/")) {
                sqrt_old_label = sqrt_old_label.replace("/", "");
                double prom_value = Double.parseDouble(sqrt_old_label);
                String sqrt_value = mainTextField.getText();
                this.second_number = Double.parseDouble(sqrt_value);
                double sqrt_result = Math.sqrt(second_number) / prom_value;
                double sqrt_base_result = Math.sqrt(second_number);
                mainTextField.setText(String.valueOf(sqrt_result));

                String sqrt_formatted_text;
                if (sqrt_result % 1 == 0) {
                    DecimalFormat format = new DecimalFormat("0");
                    sqrt_formatted_text = format.format(sqrt_result);
                } else {
                    sqrt_formatted_text = String.valueOf(sqrt_result);
                }

                mainTextField.setText(String.valueOf(sqrt_formatted_text));
                label_history.setText(sqrt_old_label+"/"+sqrt_base_result);
            }
        }
    }
    public void log_click() {
        String log_old_label = label_history.getText();

        if (log_old_label.isEmpty()) {
            String log_formatted_text;
            String log_value = mainTextField.getText();
            this.second_number = Double.parseDouble(log_value);
            double log_result = Math.log10(second_number);

            if (log_result % 1 == 0) {
                DecimalFormat format = new DecimalFormat("0");
                log_formatted_text = format.format(log_result);
            } else {
                log_formatted_text = String.valueOf(log_result);
            }

            mainTextField.setText(String.valueOf(log_formatted_text));
            label_history.setText(log_old_label +"log("+second_number+")");
        }

        else {
            if (operation.equals("+")) {
                log_old_label = log_old_label.replace("+", "");
                double label_value = Double.parseDouble(log_old_label);
                String log_value = mainTextField.getText();
                this.second_number = Double.parseDouble(log_value);
                double log_result = Math.log10(second_number)+ label_value;
                double log_base_result = Math.log10(second_number);
                mainTextField.setText(String.valueOf(log_result));

                String log_formatted_text;
                if (log_result % 1 == 0) {
                    DecimalFormat format = new DecimalFormat("0");
                    log_formatted_text = format.format(log_result);
                } else {
                    log_formatted_text = String.valueOf(log_result);
                }

                mainTextField.setText(String.valueOf(log_formatted_text));
                label_history.setText(log_old_label+"+"+log_base_result);
            }

            else if (operation.equals("-")) {
                log_old_label = log_old_label.replace("-", "");
                double prom_value = Double.parseDouble(log_old_label);
                String log_value = mainTextField.getText();
                this.second_number = Double.parseDouble(log_value);
                double log_result = Math.log10(second_number) - prom_value;
                double log_base_result = Math.log10(second_number);
                mainTextField.setText(String.valueOf(log_result));

                String log_formatted_text;
                if (log_result % 1 == 0) {
                    DecimalFormat format = new DecimalFormat("0");
                    log_formatted_text = format.format(log_result);
                } else {
                    log_formatted_text = String.valueOf(log_result);
                }

                mainTextField.setText(String.valueOf(log_formatted_text));
                label_history.setText(log_old_label+"-"+log_base_result);
            }

            else if (operation.equals("*")) {
                log_old_label = log_old_label.replace("*", "");
                double prom_value = Double.parseDouble(log_old_label);
                String log_value = mainTextField.getText();
                this.second_number = Double.parseDouble(log_value);
                double log_result = Math.log10(second_number) * prom_value;
                double log_base_result = Math.log10(second_number);
                mainTextField.setText(String.valueOf(log_result));

                String log_formatted_text;
                if (log_result % 1 == 0) {
                    DecimalFormat format = new DecimalFormat("0");
                    log_formatted_text = format.format(log_result);
                } else {
                    log_formatted_text = String.valueOf(log_result);
                }

                mainTextField.setText(String.valueOf(log_formatted_text));
                label_history.setText(log_old_label+"*"+log_base_result);
            }

            else if (operation.equals("/")) {
                log_old_label = log_old_label.replace("/", "");
                double prom_value = Double.parseDouble(log_old_label);
                String log_value = mainTextField.getText();
                this.second_number = Double.parseDouble(log_value);
                double log_result = Math.log10(second_number) / prom_value;
                double log_base_result = Math.log10(second_number);
                mainTextField.setText(String.valueOf(log_result));

                String log_formatted_text;
                if (log_result % 1 == 0) {
                    DecimalFormat format = new DecimalFormat("0");
                    log_formatted_text = format.format(log_result);
                } else {
                    log_formatted_text = String.valueOf(log_result);
                }

                mainTextField.setText(String.valueOf(log_formatted_text));
                label_history.setText(log_old_label+"/"+log_base_result);
            }
        }
    }
}