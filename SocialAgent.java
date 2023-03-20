/* 
	File: SocialAgent.java
	Author: Mahdeen Ahmed Khan Sameer
	Date: 02/26/2023
    Project: Agent-Based Simulations
    Course: CS231B
	creates the agents that can interact with their neighbors
*/


import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class SocialAgent extends Agent {

    private boolean moved;
    private int radius;

    public SocialAgent(double x0, double y0, int radius) {
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
            g.setColor(new Color(0, 0, 255));
        } else {
            g.setColor(new Color(125, 125, 255));
        }
        g.fillOval((int) getX() - 2, (int) getY() - 2, 5, 5);
    }

    public void updateState(Landscape scape) {
        double oldX = getX();
        double oldY = getY();
        LinkedList<Agent> neighbors = scape.getNeighbors(oldX, oldY, getRadius());

        if (neighbors.size() < 4){
            double newX = oldX + Math.random() * 20 - 10;
            double newY = oldY + Math.random() * 20 - 10;
            setX(Math.max(Math.min(newX, scape.getWidth()), 0));
            setY(Math.max(Math.min(newY, scape.getHeight()), 0));

            if (getX() != oldX || getY() != oldY){
                moved = true;
            } else {
                moved = false;
            }
        } else {
            moved = false;
        }
    }
}