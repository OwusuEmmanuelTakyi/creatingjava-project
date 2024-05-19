import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreationWeekGUI {
    private static final String[] activities = {
            "Created light and separated light from darkness.",
            "Created the sky and separated the waters.",
            "Gathered waters, created dry land and vegetation.",
            "Created celestial bodies to mark time and separate light from darkness.",
            "Created sea creatures and birds.",
            "Created land animals and humans.",
            "God rested, blessing the day as holy and sanctified."
    };

    private static final String[] verses = {
            "Genesis 1:3-5",
            "Genesis 1:6-8",
            "Genesis 1:9-13",
            "Genesis 1:14-19",
            "Genesis 1:20-23",
            "Genesis 1:24-31",
            "Genesis 2:1-3"
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CreationWeekGUI::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Creation Week Explorer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 350);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel label = new JLabel("Select a day:");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        JComboBox<String> dayComboBox = new JComboBox<>(new String[] { "1", "2", "3", "4", "5", "6", "7" });
        dayComboBox.setBounds(100, 20, 50, 25);
        panel.add(dayComboBox);

        JTextArea resultArea = new JTextArea();
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBounds(10, 110, 520, 200);
        panel.add(scrollPane);

        JButton showEventButton = new JButton("Show Event");
        showEventButton.setBounds(160, 20, 120, 25);
        panel.add(showEventButton);

        JButton showVerseButton = new JButton("Show Verse");
        showVerseButton.setBounds(290, 20, 120, 25);
        panel.add(showVerseButton);

        JButton showBothButton = new JButton("Show Both");
        showBothButton.setBounds(160, 60, 250, 25);
        panel.add(showBothButton);

        showEventButton.addActionListener(e -> {
            int day = dayComboBox.getSelectedIndex();
            resultArea.setText("Day " + (day + 1) + ": " + activities[day]);
        });

        showVerseButton.addActionListener(e -> {
            int day = dayComboBox.getSelectedIndex();
            resultArea.setText("Day " + (day + 1) + " verse: " + verses[day]);
        });

        showBothButton.addActionListener(e -> {
            int day = dayComboBox.getSelectedIndex();
            resultArea.setText("Day " + (day + 1) + ": " + activities[day] + "\nVerse: " + verses[day]);
        });

        // Tooltip for better guidance
        showEventButton.setToolTipText("Click to display the events of the selected day.");
        showVerseButton.setToolTipText("Click to display the Bible verse for the selected day.");
        showBothButton.setToolTipText("Click to display both the events and the Bible verse for the selected day.");
    }
}
