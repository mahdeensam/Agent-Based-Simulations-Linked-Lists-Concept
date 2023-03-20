/* 
	File: Simulation.java
	Author: Mahdeen Ahmed Khan Sameer
	Date: 02/26/2023
    Project: Agent-Based Simulations
    Course: CS231B
	initializes a new Landscape object with a width and height of 500 and creates a SocialAgent object with initial position (250, 250) and a radius of sensitivity of 10.
*/

public class Simulation {
    public static void main(String[] args) {
        Landscape scape = new Landscape(500, 500);
        SocialAgent agent = new SocialAgent(250, 250, 10);
        scape.addAgent(agent);

        LandscapeDisplay display = new LandscapeDisplay(scape);
        display.repaint();
    }
}