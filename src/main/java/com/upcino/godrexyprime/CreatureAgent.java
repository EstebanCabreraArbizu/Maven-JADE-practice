package com.upcino.godrexyprime;

/**
 *
 * @author MarceloGuerrero
 */
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class CreatureAgent extends Agent {
    private String currentRegion;

    @Override
    protected void setup() {
        System.out.println("Creature " + getLocalName() + " started.");
        addBehaviour(new TickerBehaviour(this, 1000) {
            @Override
            protected void onTick() {
                GodrexyPrime world = new GodrexyPrime();
                int randomRegion = (int) (Math.random() * world.getRegions().size());
                currentRegion = world.getRegions().get(randomRegion).getName();
                System.out.println(getLocalName() + " is now in " + currentRegion);
            }
        });
    }
}
