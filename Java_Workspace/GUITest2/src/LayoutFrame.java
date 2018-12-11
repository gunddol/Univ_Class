import javax.swing.*;
import java.awt.*;

public class LayoutFrame extends JFrame {
    public LayoutFrame(){
        super();

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc;
        Insets insets = new Insets(1,1,1,1);


        gbc = new GridBagConstraints(0,0,5,1,1.0,1.0,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,insets,0,0);
        panel.add(new JTextField(),gbc);


        gbc = new GridBagConstraints(0,1,1,1,1.0,1.0,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,insets,0,0);
        panel.add(new JButton("7"),gbc);
        gbc = new GridBagConstraints(1,1,1,1,1.0,1.0,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,insets,0,0);
        panel.add(new JButton("8"),gbc);
        gbc = new GridBagConstraints(2,1,1,1,1.0,1.0,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,insets,0,0);
        panel.add(new JButton("9"),gbc);
        gbc = new GridBagConstraints(3,1,1,1,1.0,1.0,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,insets,0,0);
        panel.add(new JButton("+"),gbc);
        gbc = new GridBagConstraints(4,1,1,2,1.0,1.0,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,insets,0,0);
        panel.add(new JButton("="),gbc);


        gbc = new GridBagConstraints(0,2,1,1,1.0,1.0,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,insets,0,0);
        panel.add(new JButton("4"),gbc);
        gbc = new GridBagConstraints(1,2,1,1,1.0,1.0,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,insets,0,0);
        panel.add(new JButton("5"),gbc);
        gbc = new GridBagConstraints(2,2,1,1,1.0,1.0,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,insets,0,0);
        panel.add(new JButton("6"),gbc);
        gbc = new GridBagConstraints(3,2,1,1,1.0,1.0,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,insets,0,0);
        panel.add(new JButton("-"),gbc);


        gbc = new GridBagConstraints(0,3,1,1,1.0,1.0,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,insets,0,0);
        panel.add(new JButton("1"),gbc);
        gbc = new GridBagConstraints(1,3,1,1,1.0,1.0,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,insets,0,0);
        panel.add(new JButton("2"),gbc);
        gbc = new GridBagConstraints(2,3,1,1,1.0,1.0,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,insets,0,0);
        panel.add(new JButton("3"),gbc);
        gbc = new GridBagConstraints(3,3,1,1,1.0,1.0,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,insets,0,0);
        panel.add(new JButton("*"),gbc);
        gbc = new GridBagConstraints(4,3,1,2,1.0,1.0,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,insets,0,0);
        panel.add(new JButton("C"),gbc);


        gbc = new GridBagConstraints(0,4,2,1,1.0,1.0,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,insets,0,0);
        panel.add(new JButton("0"),gbc);
        gbc = new GridBagConstraints(2,4,1,1,1.0,1.0,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,insets,0,0);
        panel.add(new JButton("."),gbc);
        gbc = new GridBagConstraints(3,4,1,1,1.0,1.0,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,insets,0,0);
        panel.add(new JButton("/"),gbc);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Calculator");
        this.setBounds(1000,200,500,300);
        this.setVisible(true);
        this.setContentPane(panel);
    }
}
