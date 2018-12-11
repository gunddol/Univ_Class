import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JList list;

    private String[] animals = {"쥐","소","호랑이","토끼","용","뱀","말","양","원숭이","닭","개","돼지"};

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 331, 237);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        table = new JTable();
        table.setBounds(5, 5, 0, 251);
        contentPane.add(table);

        JButton btnNewButton = new JButton("2\uBC88 \uD589\uB3D9");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                openSubFrame(list.getSelectedValue().toString(), 2);
            }
        });
        btnNewButton.setBounds(206, 53, 97, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("1\uBC88 \uD589\uB3D9");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                openSubFrame(list.getSelectedValue().toString(), 1);
            }
        });
        btnNewButton_1.setBounds(206, 20, 97, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("4\uBC88 \uD589\uB3D9");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                openSubFrame(list.getSelectedValue().toString(), 4);
            }
        });
        btnNewButton_2.setBounds(206, 119, 97, 23);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("3\uBC88 \uD589\uB3D9");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                openSubFrame(list.getSelectedValue().toString(), 3);
            }
        });
        btnNewButton_3.setBounds(206, 86, 97, 23);
        contentPane.add(btnNewButton_3);

        JPanel panel = new JPanel();
        panel.setBounds(17, 20, 177, 168);
        contentPane.add(panel);
        panel.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel = new JLabel("none");
        lblNewLabel.setBounds(206, 152, 57, 15);
        contentPane.add(lblNewLabel);

        list = new JList();
        list.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent arg0) {
                switch(arg0.getKeyCode()){
                    case 49: openSubFrame(list.getSelectedValue().toString(), 1); break;
                    case 50: openSubFrame(list.getSelectedValue().toString(), 2); break;
                    case 51: openSubFrame(list.getSelectedValue().toString(), 3); break;
                    case 52: openSubFrame(list.getSelectedValue().toString(), 4); break;
                }
            }
        });
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent arg0) {
                lblNewLabel.setText(list.getSelectedValue().toString());
            }
        });
        list.setListData(animals);
        panel.add(list, BorderLayout.CENTER);
        panel.add(new JScrollPane(list), BorderLayout.CENTER);
    }

    private void openSubFrame(String name, int num)
    {
        SubFrame sub = new SubFrame(name, num);
        sub.setVisible(true);
    }
}
