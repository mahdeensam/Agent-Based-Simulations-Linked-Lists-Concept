/* 
	File: SocialAgent2.java
	Author: Mahdeen Ahmed Khan Sameer
	Date: 02/26/2023
    Project: Agent-Based Simulations
    Course: CS231B
	creates agents that move towards other agents or away from them
*/


import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;


public class SocialAgent2 extends Agent {
    private int radius;
    private boolean moved;
    
    public SocialAgent2(double x0, double y0, int radius) {
        super(x0, y0);
        this.radius = radius;
        this.moved = false;
    }
    
    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    public int getRadius() {
        return radius;
    }
    
    public void draw(Graphics g) {
        if(!moved) {
            g.setColor(new Color(0, 0, 255));
        } else {
            g.setColor(new Color(125, 125, 255));
        }
        
        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }
    
    public void updateState(Landscape scape) {
        LinkedList<Agent> neighbors = scape.getNeighbors(getX(), getY(), radius);
        
        if(neighbors.size() >= 2) {
            double avgX = 0.0;
            double avgY = 0.0;
            int count = 0;
            
            for(Agent neighbor : neighbors) {
                if(neighbor != this) {
                    avgX += neighbor.getX();
                    avgY += neighbor.getY();
                    count++;
                }
            }
            
            if(count > 0) {
                avgX /= count;
                avgY /= count;
                
                double dx = avgX - getX();
                double dy = avgY - getY();
                
                double distance = Math.sqrt(dx*dx + dy*dy);
                
                if(distance > 0) {
                    double speed = 2.0;
                    double moveX = dx/distance * speed;
                    double moveY = dy/distance * speed;
                    
                    double newX = getX() + moveX;
                    double newY = getY() + moveY;
                    
                    // Check if the new position is within the bounds of the landscape
                    if(newX >= 0 && newX < scape.getWidth() && newY >= 0 && newY < scape.getHeight()) {
                        setX(newX);
                        setY(newY);
                        moved = true;
                    } else {
                        moved = false;
                    }
                } else {
                    moved = false;
                }
            } else {
                moved = false;
            }
        } else {
            // Move randomly if there are less than 2 neighbors
            double moveX = (Math.random() * 20) - 10;
            double moveY = (Math.random() * 20) - 10;
            
            double newX = getX() + moveX;
            double newY = getY() + moveY;
            
            // Check if the new position is within the bounds of the landscape
            if(newX >= 0 && newX < scape.getWidth() && newY >= 0 && newY < scape.getHeight()) {
                setX(newX);
                setY(newY);
                moved = true;
            } else {
                moved = false;
            }
        }
    }
}
