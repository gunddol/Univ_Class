import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame(){
            super();

            JPanel panel = new JPanel();
            panel.setLayout(null);

            JLabel label = new JLabel();
            label.setText("ID:");
            label.setBounds(20,18,40,20);
            panel.add(label);

            JTextField textField = new JTextField();
            textField.setBounds(60,18,154,20);
            panel.add(textField);

            JLabel label1 = new JLabel();
            label1.setText("PW:");
            label1.setBounds(20,53,40,20);
            panel.add(label1);

            JTextField textField1 = new JTextField();
            textField1.setBounds(60,53,154,20);
            panel.add(textField1);

            JLabel label2 = new JLabel();
            label2.setText("학년:");
            label2.setBounds(20,88,40,20);
            panel.add(label2);

            JComboBox<String> combo = new JComboBox<String>();
            combo.setBounds(60,88,154,20);
            combo.addItem("1학년");
            combo.addItem("2학년");
            combo.addItem("3학년");
            combo.addItem("4학년");
            panel.add(combo);

            JLabel label3 = new JLabel();
            label3.setText("자기소개");
            label3.setBounds(20,133,60,20);
            panel.add(label3);

            JTextArea textArea = new JTextArea();
            textArea.setBounds(20,158,194,80);
            panel.add(textArea);

            JButton button1 = new JButton();
            JButton button2 = new JButton();
            button1.setText("확인");
            button2.setText("취소");
            button1.setBounds(20,253,194,20);
            button2.setBounds(20, 278,194,20);
            panel.add(button1);
            panel.add(button2);

    //        JFrame frame = new JFrame();
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("Sign up");
            this.setBounds(1000,200,250,350);
            this.setVisible(true);
            this.setContentPane(panel);
    }
}
