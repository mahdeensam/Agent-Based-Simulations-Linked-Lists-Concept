/**
	File: AgentSimulation.java
	Author: Mahdeen Ahmed Khan Sameer
	Date: 02/26/2023
	Project: Agent-Based Simulations
    Course: CS231B
    creates a landscape with a size of 500 x 500, and randomly places 200 SocialAgents on it with a radius of 20. It then starts an infinite loop that calls the updateAgents method of the landscape and repaints the display every 10 milliseconds.a landscape with a size of 500 x 500, and randomly places 200 SocialAgents on it with a radius of 20. It then starts an infinite loop that calls the updateAgents method of the landscape and repaints the display every 10 milliseconds.
*/

import java.awt.*;
import javax.swing.*;

public class AgentSimulation extends JPanel {

    private Landscape scape;
    private int width, height;
    private int numAgents = 200;
    private int radius = 20;
    private int delay = 50;

    public AgentSimulation(int w, int h) {
        width = w;
        height = h;
        scape = new Landscape(width, height);
        init();
    }

    private void init() {
        for (int i = 0; i < numAgents; i++) {
            double x = Math.random() * width;
            double y = Math.random() * height;
            SocialAgent agent = new SocialAgent(x, y, radius);
            scape.addAgent(agent);
        }
    }

    public void run() throws InterruptedException {
        JFrame frame = new JFrame("Agent Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);

        while (true) {
            scape.updateAgents();
            repaint();
            Thread.sleep(delay);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        scape.draw(g);
    }

    public static void main(String[] args) throws InterruptedException {
        AgentSimulation sim = new AgentSimulation(800, 600);
        sim.run();
    }
}


//Extension2: SocialAgent2
// import java.awt.Dimension;
// import java.awt.Graphics;
// import java.util.Random;
// import javax.swing.JFrame;
// import javax.swing.JPanel;

// public class AgentSimulation extends JPanel {

//     private Landscape scape;
//     private int width, height;
//     private int numAgents = 200;

//     public AgentSimulation(int w, int h) {
//         width = w;
//         height = h;
//         scape = new Landscape(width, height);
//         Random gen = new Random();
//         for (int i = 0; i < numAgents; i++) {
//             double x = gen.nextDouble() * width;
//             double y = gen.nextDouble() * height;
//             SocialAgent2 a = new SocialAgent2(x, y, 20);
//             scape.addAgent(a);
//         }
//     }

//     public void run() throws InterruptedException {
//         JFrame frame = new JFrame("Agent Simulation");
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setPreferredSize(new Dimension(width, height));
//         frame.getContentPane().add(this);
//         frame.pack();
//         frame.setVisible(true);

//         while (true) {
//             scape.updateAgents();
//             repaint();
//             Thread.sleep(100);
//         }
//     }

//     public void paintComponent(Graphics g) {
//         super.paintComponent(g);
//         scape.draw(g);
//     }

//     public static void main(String[] args) throws InterruptedException {
//         AgentSimulation sim = new AgentSimulation(500, 500);
//         sim.run();
//     }
// }
