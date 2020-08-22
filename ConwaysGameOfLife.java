import javax.swing.*;

public class ConwaysGameOfLife extends JFrame {
    public JLabel GenerationLabel = new JLabel();
    public JLabel AliveLabel = new JLabel();

    public ConwaysGameOfLife() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 610);
        setTitle("Conway's Game Of Life");
        add(GenerationLabel);
        add(AliveLabel);
        GenerationLabel.setName("GenerationLabel");
        AliveLabel.setName("AliveLabel");
        GenerationLabel.setText("Generation #0");
        AliveLabel.setText("Alive: 0");
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }

}
