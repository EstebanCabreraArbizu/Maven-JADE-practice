package com.upcino.godrexyprime;
/**
 *
 * @author MarceloGuerrero
 */
import jade.core.Agent;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

public class MainAgent extends Agent {
    @Override
    protected void setup() {
        ContainerController container = getContainerController();
        try {
            for (int i = 0; i < 1000; i++) {
                String agentName = "Creature" + i;
                AgentController agent = container.createNewAgent(agentName, "com.upcino.godrexyprime.CreatureAgent", null);
                agent.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
