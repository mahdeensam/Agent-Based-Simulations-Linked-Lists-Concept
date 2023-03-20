/* 
	File: Agent.java
	Author: Mahdeen Ahmed Khan Sameer
	Date: 02/25/2023
    Project: Agent-Based Simulations
    Course: CS231B
	creates the agents for our simulation
*/

import java.awt.Graphics;

public abstract class Agent {

    // Declare a private instance variable for the x and y coordinate
    public double x;
    public double y;

    public Agent(double x0, double y0) {
        // Initialize the x and y coordinate
        this.x = x0;
        this.y = y0;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double newX) {
        this.x = newX;
    }

    public void setY(double newY) {
        this.y = newY;
    }

    public String toString() {
        //convert Agent to a string representation
        return "(" + this.x + ", " + this.y + ")";
    }

    public abstract void updateState(Landscape scape);

    public abstract void draw(Graphics g);

}
