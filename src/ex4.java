import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ex4 {
    private JPanel panel1;
    private JTextField ofield;
    private JTextField bfield;
    private JTextField kfield;
    private JLabel lab1;
    private JLabel lab2;
    private JLabel lab3;
    private JLabel lab4;
    private JTextArea textArea;
    private JButton button1;
    private JTextField xfield;

    protected double calc_y(double x, double b){
        double y = 0.0025 * b * (Math.pow(x, 3)) + Math.sqrt(x + Math.pow(Math.E, 0.82));
        return y;
    }

    protected String calc_tab(double x_o, double x_k, double dx, double b){
        String text = "";
        double x = x_o;
        while (x <= x_k){
            double y = calc_y(x , b);
            text = text + "x=" + x + "\t y=" + y + "\n";

            x = x + dx;

        }
        return text;
    }

    public ex4() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double x_o = Double.parseDouble(ofield.getText());
                double x_k = Double.parseDouble(kfield.getText());
                double dx = Double.parseDouble(xfield.getText());
                double b = Double.parseDouble(bfield.getText());

                String text = calc_tab(x_o, x_k, dx, b);
                textArea.setText(text);


            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ex4");
        frame.setContentPane(new ex4().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}
