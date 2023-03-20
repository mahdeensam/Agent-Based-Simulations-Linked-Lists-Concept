/* 
	File: Landscape.java
	Author: Mahdeen Ahmed Khan Sameer
	Date: 02/26/2023
    Project: Agent-Based Simulations
    Course: CS231B
	creates a 2D representation of the agents
*/



import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;


public class Landscape {

    private int width;
    private int height;
    private LinkedList<Agent> agents;

    public Landscape(int w, int h) {
        width = w;
        height = h;
        agents = new LinkedList<Agent>();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void addAgent(Agent a) {
        agents.addFirst(a);
    }

    public String toString() {
        return "Landscape with " + agents.size() + " agents.";
    }

    public LinkedList<Agent> getNeighbors(double x0, double y0, double radius) {
        LinkedList<Agent> neighbors = new LinkedList<Agent>();
        for (Agent agent : agents) {
            double dx = agent.getX() - x0;
            double dy = agent.getY() - y0;
            double distance = Math.sqrt(dx*dx + dy*dy);
            if (distance <= radius) {
                neighbors.add(agent);
            }
        }
        return neighbors;
    }

    public void draw(Graphics g) {
        for (Agent agent : agents) {
            agent.draw(g);
        }
    }

    // this calls the Agent
    public void updateAgents() {
        for (Agent a : agents) {
            a.updateState(this);
        }
    } 

public static void main(String[] args) throws InterruptedException {
    Landscape scape = new Landscape(500, 500);
    Random gen = new Random();

    // Creates 100 SocialAgents and 100 AntiSocialAgents
    for (int i = 0; i < 100; i++) {
        scape.addAgent(new SocialAgent(gen.nextDouble() * scape.getWidth(),
                gen.nextDouble() * scape.getHeight(),
                25));
        scape.addAgent(new AntiSocialAgent(gen.nextDouble() * scape.getWidth(),
                gen.nextDouble() * scape.getHeight(),
                50));
    }

    LandscapeDisplay display = new LandscapeDisplay(scape);

    while(true){
        Thread.sleep(10);
        scape.updateAgents();
        display.repaint();
    }
}
}

