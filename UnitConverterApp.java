import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UnitConverterApp extends JFrame {
    public UnitConverterApp() {
        setTitle("Unit Converter");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Background panel
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new GridLayout(3, 1, 10, 10));
        backgroundPanel.setBackground(new Color(255, 204, 229));

        // Add converter sections
        backgroundPanel.add(createTemperaturePanel());
        backgroundPanel.add(createLengthPanel());
        backgroundPanel.add(createWeightPanel());

        add(backgroundPanel, BorderLayout.CENTER);

        // Footer
        JLabel footer = new JLabel("UNIT CONVERTER, created by CHANDAN ", JLabel.CENTER);
        footer.setForeground(Color.WHITE);
        footer.setOpaque(true);
        footer.setBackground(new Color(102, 0, 102));
        footer.setFont(new Font("Arial", Font.BOLD, 14));
        add(footer, BorderLayout.SOUTH);
    }

    private JPanel createTemperaturePanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 153, 153));
        panel.setBorder(BorderFactory.createTitledBorder("Temperature Converter"));

        JTextField input = new JTextField(10);
        JComboBox<String> from = new JComboBox<>(new String[] { "Celsius", "Fahrenheit" });
        JComboBox<String> to = new JComboBox<>(new String[] { "Fahrenheit", "Celsius" });
        JButton convert = new JButton("Convert");
        JLabel result = new JLabel("Result");

        convert.addActionListener(e -> {
            try {
                double val = Double.parseDouble(input.getText());
                double converted = 0;
                if (from.getSelectedItem().equals("Celsius") && to.getSelectedItem().equals("Fahrenheit")) {
                    converted = val * 9 / 5 + 32;
                } else if (from.getSelectedItem().equals("Fahrenheit") && to.getSelectedItem().equals("Celsius")) {
                    converted = (val - 32) * 5 / 9;
                } else {
                    converted = val;
                }
                result.setText(String.format("Result: %.2f", converted));
            } catch (Exception ex) {
                result.setText("Invalid Input");
            }
        });

        panel.add(input);
        panel.add(from);
        panel.add(to);
        panel.add(convert);
        panel.add(result);

        return panel;
    }

    private JPanel createLengthPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(153, 204, 255));
        panel.setBorder(BorderFactory.createTitledBorder("Length Converter"));

        JTextField input = new JTextField(10);
        JComboBox<String> from = new JComboBox<>(new String[] { "Meter", "Kilometer" });
        JComboBox<String> to = new JComboBox<>(new String[] { "Kilometer", "Meter" });
        JButton convert = new JButton("Convert");
        JLabel result = new JLabel("Result");

        convert.addActionListener(e -> {
            try {
                double val = Double.parseDouble(input.getText());
                double converted = 0;
                if (from.getSelectedItem().equals("Meter") && to.getSelectedItem().equals("Kilometer")) {
                    converted = val / 1000;
                } else if (from.getSelectedItem().equals("Kilometer") && to.getSelectedItem().equals("Meter")) {
                    converted = val * 1000;
                } else {
                    converted = val;
                }
                result.setText(String.format("Result: %.2f", converted));
            } catch (Exception ex) {
                result.setText("Invalid Input");
            }
        });

        panel.add(input);
        panel.add(from);
        panel.add(to);
        panel.add(convert);
        panel.add(result);

        return panel;
    }

    private JPanel createWeightPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(204, 255, 204));
        panel.setBorder(BorderFactory.createTitledBorder("Weight Converter"));

        JTextField input = new JTextField(10);
        JComboBox<String> from = new JComboBox<>(new String[] { "Gram", "Kilogram" });
        JComboBox<String> to = new JComboBox<>(new String[] { "Kilogram", "Gram" });
        JButton convert = new JButton("Convert");
        JLabel result = new JLabel("Result");

        convert.addActionListener(e -> {
            try {
                double val = Double.parseDouble(input.getText());
                double converted = 0;
                if (from.getSelectedItem().equals("Gram") && to.getSelectedItem().equals("Kilogram")) {
                    converted = val / 1000;
                } else if (from.getSelectedItem().equals("Kilogram") && to.getSelectedItem().equals("Gram")) {
                    converted = val * 1000;
                } else {
                    converted = val;
                }
                result.setText(String.format("Result: %.2f", converted));
            } catch (Exception ex) {
                result.setText("Invalid Input");
            }
        });

        panel.add(input);
        panel.add(from);
        panel.add(to);
        panel.add(convert);
        panel.add(result);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UnitConverterApp().setVisible(true));
    }
}
