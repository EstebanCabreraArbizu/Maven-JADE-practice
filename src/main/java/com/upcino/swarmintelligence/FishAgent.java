package com.upcino.swarmintelligence;

import jade.core.Agent;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;

import java.awt.Color;

/**
 *
 * @author WillyUgarte
 */
public class FishAgent extends Agent {
	public int x;
	public int y;
	public int status; // 1:vigilar,2:comer,3:subir,4:bajar
	public Color color;
	public int size;
	public int speed;

	public FishAgent() {
		x = (int) (1300 * Math.random());
		y = (int) (500 * Math.random());
		color = new Color((int) (Math.random()) * 0x10000000);
		size = (int) (25 * Math.random() + 5);
		speed = 10 * 25 / size;
		HostAgent.lista_peces.add(this);
	}
	// Para crear agentes independientes con un comportamiento
	// @Override
	// protected void setup() {
	// Object[] args = getArguments();
	// if (args != null && args.length > 0) {
	// myKey = (String) args[0];
	// FishAgent visualPez = HostAgent.lista_peces.get(myKey);
	// if (visualPez != null) {
	// this.x = visualPez.x;
	// this.y = visualPez.y;
	// this.color = visualPez.color;
	// this.size = visualPez.size;
	// this.speed = visualPez.speed;
	// }
	// }
	// //Comportamiento inicial
	// addBehaviour(new TickerBehaviour(this, 100) {
	// @Override
	// protected void onTick() {
	// definirStatus();
	// nadar();
	// actualizarEstadoVisual();
	// }
	// });
	// }

	@Override
   public void setup(){
	   try{
		   DFAgentDescription dfd = new DFAgentDescription();
		   dfd.setName(getAID());
		   DFService.register(this, dfd);

		   ParallelBehaviour parallel = new ParallelBehaviour();
		   parallel.addSubBehaviour(new TickerBehaviour(this, 5000) {
			   @Override
			   protected void onTick() {
				   System.out.println("(" + getLocalName() + ") en x: " + x + " y: " + y);
			   }
		   });
		   parallel.addSubBehaviour(new TickerBehaviour(this, 100) {
			   @Override
			   protected void onTick() {
			      definirStatus();
			      nadar();
			   }
		   });

		   addBehaviour(parallel);
	   }
	   catch(Exception e){
		   e.printStackTrace();
	   }
   }

	public void definirStatus() {
		if (y < 500) {
			status = 1;
			if (x > 100 + HostAgent.x_center)
				status = 4;
		} else if (y > 900) {
			status = 2;
			if (x < 30 + HostAgent.x_center)
				status = 3;
		} else {
			if (x < 30 + HostAgent.x_center)
				status = 3;
			else
				status = 4;
		}
	}

	public void nadar() {
		switch (status) {
			case 1:
				x += speed;
				break;
			case 2:
				x -= speed;
				break;
			case 3:
				y -= speed;
				break;
			case 4:
				y += speed;
				break;
		}
	}
}