/* 
	File: AntiSocialAgent.java
	Author: Mahdeen Ahmed Khan Sameer
	Date: 02/26/2023
    Project: Agent-Based Simulations
    Course: CS231B
	creates AntiSocialAgents that try to move away from Agents 
*/


import java.awt.*;
import java.util.LinkedList;

public class AntiSocialAgent extends Agent {
    private int radius;
    private boolean moved;

    public AntiSocialAgent(double x0, double y0, int radius) {
        super(x0, y0);
        this.radius = radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    public void draw(Graphics g) {
        if (!moved)
            g.setColor(new Color(255, 0, 0)); // darker shade of red
        else
            g.setColor(new Color(255, 125, 125)); // lighter shade of red

        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }

    public void updateState(Landscape scape) {
        double oldX = getX();
        double oldY = getY();
        LinkedList<Agent> neighbors = scape.getNeighbors(oldX, oldY, getRadius());

        if (neighbors.size() > 1){
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

