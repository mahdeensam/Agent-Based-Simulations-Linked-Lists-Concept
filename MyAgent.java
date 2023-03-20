/* 
	File: Agent.java
	Author: Mahdeen Ahmed Khan Sameer
	Date: 02/25/2023
    Project: Agent-Based Simulations
    Course: CS231B
	creates a child class MyAgent of the abstract class Agent in Java and add new fields and behaviors to it.
*/


import java.awt.Graphics;

public class MyAgent extends Agent {
    private boolean moved;
    private int radius;

    public MyAgent(double x0, double y0, boolean moved, int radius) {
        super(x0, y0);
        this.moved = moved;
        this.radius = radius;
    }

    public boolean hasMoved() {
        return moved;
    }

    public int getRadius() {
        return radius;
    }

    public void updateState(Landscape scape) {
        // update agent's state here
        // ...
        moved = true;
    }

    public void draw(Graphics g) {
        // draw the agent here
    }

    public static void main(String[] args) {
        MyAgent agent = new MyAgent(3.024, 4.245, true, 5);
        System.out.println(agent);
        System.out.println(" NOTE: This indicates that the agent is located at position (x, y) in the simulation landscape.");
    }  
}

