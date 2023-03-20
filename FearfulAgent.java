/* 
	File: FearfulAgent.java
	Author: Mahdeen Ahmed Khan Sameer
	Date: 02/26/2023
    Project: Agent-Based Simulations
    Course: CS231B
	creates agents that move away from any other agent within its radius of sensitivity, 
    regardless of whether it is a social or anti-social agent.
*/


import java.awt.Graphics;
import java.awt.Color;
import java.util.LinkedList;

public class FearfulAgent extends Agent {

    private int radius;
    private boolean moved;

    public FearfulAgent(double x0, double y0, int radius) {
        super(x0, y0);
        this.radius = radius;
        this.moved = false;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    public void draw(Graphics g) {
        if (!moved) {
            g.setColor(new Color(255, 0, 0));
        } else {
            g.setColor(new Color(255, 125, 125));
        }

        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }

    public void updateState(Landscape scape) {
        LinkedList<Agent> neighbors = scape.getNeighbors(getX(), getY(), radius);

        // Move away from all neighbors
        for (Agent neighbor : neighbors) {
            double dx = getX() - neighbor.getX();
            double dy = getY() - neighbor.getY();
            double dist = Math.sqrt(dx * dx + dy * dy);

            if (dist <= radius) {
                double newX = getX() + dx / dist * 10;
                double newY = getY() + dy / dist * 10;

                // Check if new position is within landscape bounds
                if (newX >= 0 && newX < scape.getWidth() && newY >= 0 && newY < scape.getHeight()) {
                    setX(newX);
                    setY(newY);
                    moved = true;
                }
            }
        }
    }
}
