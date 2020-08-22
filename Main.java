import javax.swing.*;
import java.io.IOException;
import java.util.Random;
import java.lang.Thread;
import java.awt.*;
import java.util.Scanner;

public class Main {
    public static class Ground extends JPanel {
        public Ground(int d) {
            setPreferredSize(new Dimension(500, 500));
            setSize(500, 500);
            setLocation(10, 60);
            GridLayout layout = new GridLayout(d, d);
            setLayout(layout);
            for (int i = 0; i < d * d; i++) {
            }
        }

        public Ground(Generation s, int d) {
            setPreferredSize(new Dimension(500, 500));
            setSize(500, 500);
            setLocation(10, 60);
            GridLayout layout = new GridLayout(d, d);
            setLayout(layout);
            for (int i = 0; i < d; i++) {
                for (int j = 0; j < d; j++) {
                    JButton cell = new JButton();
                    cell.setBackground(s.c[i][j].equals("O") ? Color.BLACK : Color.WHITE);
                    add(cell);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the size of Generation Matrix: ");
        int n = kb.nextInt();
        System.out.println("Enter the delay in consecutive generations(In Milli-seconds)");
        long d = kb.nextLong();
        Random r = new Random();
        String[][] a = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (r.nextBoolean()) {
                    a[i][j] = "O";
                } else {
                    a[i][j] = " ";
                }
        }
        System.out.println("Press 1 for console Output and 2 for GUI Output:");
        int m = kb.nextInt();
        switch (m) {
            case 1: {
                for (int k = 1; k <= 500; k++) {
                    Generation game = new Generation();
                    UniverseState ob = new UniverseState();
                    System.out.println("Generation #" + k);
                    System.out.println("Alive: " + Generation.Alive(a, n));
                    ob.Universe(a, n);
                    Thread.sleep(d);
                    try {
                        if (System.getProperty("os.name").contains("Windows"))
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        else
                            Runtime.getRuntime().exec("clear");
                    } catch (InterruptedException | IOException e) {
                    }
                    a = game.generation(a, n);
                }
            }
            case 2: {
                ConwaysGameOfLife newLife = new ConwaysGameOfLife();
                newLife.getContentPane().setLayout(null);
                newLife.GenerationLabel.setLocation(5, 3);
                newLife.GenerationLabel.setSize(100, 20);

                newLife.AliveLabel.setLocation(5, 20);
                newLife.AliveLabel.setSize(100, 20);

                Ground ground = new Ground(n);
                newLife.add(ground);
                newLife.setVisible(true);

                for (int k = 1; k <= 500; k++) {
                    Generation game = new Generation();
                    newLife.GenerationLabel.setText("Generation #" + k);
                    newLife.AliveLabel.setText(("Alive: " + Generation.Alive(a, n)));
                    Thread.sleep(d);
                    newLife.remove(ground);
                    a = game.generation(a, n);
                    ground = new Ground(game, n);
                    newLife.add(ground);
                    newLife.revalidate();
                    newLife.repaint();
                }
            }
            default: {
                System.out.println("Please enter the correct Number.");
                break;
            }
        }
    }
}