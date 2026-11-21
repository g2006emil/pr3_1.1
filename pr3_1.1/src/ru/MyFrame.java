
package ru;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyFrame extends JFrame {
    private int milanScore = 0;
    private int madridScore = 0;

    private final JLabel result = new JLabel("Result: 0 X 0");
    private final JLabel lastScorer = new JLabel("Last Scorer: N/A");
    private final JLabel winner = new JLabel("Winner: DRAW");

    public MyFrame() {
        setTitle("AC Milan - Real Madrid");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));
        setLocationRelativeTo(null);

        JButton milanButton = new JButton("AC Milan");
        JButton madridButton = new JButton("Real Madrid");

        milanButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                milanScore++;
                updateScore("AC Milan");
            }
        });

        madridButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                madridScore++;
                updateScore("Real Madrid");
            }
        });

        add(milanButton);
        add(madridButton);
        add(result);
        add(lastScorer);
        add(winner);
    }

    private void updateScore(String team) {
        result.setText("Result: " + milanScore + " X " + madridScore);
        lastScorer.setText("Last Scorer: " + team);

        if (milanScore > madridScore) {
            winner.setText("Winner: AC Milan");
        } else if (madridScore > milanScore) {
            winner.setText("Winner: Real Madrid");
        } else {
            winner.setText("Winner: DRAW");
        }
    }
}
