/*Para creación de agentes independientes */
package com.upcino.swarmintelligence;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;

import jade.wrapper.AgentController;
import jade.wrapper.PlatformController;

import java.util.ArrayList;


/**
 *
 * @author WillyUgarte
 */
public class HostAgent extends Agent {
    public static MainFrame frame = null; //public static == variable global
    public static int numero_peces = 200;
    public static ArrayList<FishAgent> lista_peces = new ArrayList<FishAgent>();
    public static boolean ENABLED = false;
    public static int x_center = 0;
    
    @Override
    public void setup() {
        try {
            //crear una descripción
            DFAgentDescription dfd = new DFAgentDescription();
            //ponerle como nombre su ID
            dfd.setName(getAID());
            //inicializar el frame
            frame = new MainFrame(this);
            frame.setVisible(true);
            //
            inicializar();

			// Comportamiento para redibujar
			addBehaviour(new CyclicBehaviour(this) {
                @Override
                public void action() { MainFrame.panel_principal.repaint(); }
            });

            /* Esto perjudica el comportamiento independiente
            addBehaviour(new TickerBehaviour(this, 100) {
                @Override
                protected void onTick() {
                    for (FishAgent pez : lista_peces) {
                        pez.definirStatus();
                        pez.nadar();
                    }
                }
            });
			*/
            addBehaviour(new TickerBehaviour(this, 1000) {
                @Override
                protected void onTick() { x_center += 5; }
            });
        }
        catch(Exception e) {
            System.err.println("exception " + e);
            e.printStackTrace();
        }
    }

    public void inicializar(){
        PlatformController container = getContainerController();
        try {
            for (int i = 0; i < numero_peces; i++) {
				lista_peces.add(new FishAgent()); //listaPeces|Crear una instancia 
                String localname = "pez_" + i;
                //crear un agente
                AgentController ac = container.createNewAgent(localname, "com.upcino.swarmintelligence.FishAgent", null);
                ac.start();
                //Dato: no tenemos acceso a estos agentes y están detenidos               
            }
            MainFrame.panel_principal.setEnabled(true);
            ENABLED = true;
        }
        catch(Exception e) {
            System.err.println("exception " + e);
            e.printStackTrace();
        }
    }
}