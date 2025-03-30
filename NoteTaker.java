import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class NoteTaker {
    private JFrame frame;
    private JTextArea textArea;

    public NoteTaker() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Note Taker");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter writer = new FileWriter("note.txt");
                    writer.write(textArea.getText());
                    writer.close();
                    JOptionPane.showMessageDialog(frame, "Note saved!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error saving note!");
                }
            }
        });

        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.add(saveButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new NoteTaker();
    }
}
