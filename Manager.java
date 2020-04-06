package PT2020.demo.Tema2;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

public class Manager extends Thread {

	private int count = 0;
	private int simulationTime;
	private ArrayList<Shop> shops;
	private Queue q;
	private ExecutorService executor;
	private int nrClientiActuali = 0;

	public Manager(int simulationTime, ArrayList<Shop> shops, Queue q, ExecutorService executor) {
		this.simulationTime = simulationTime;
		this.shops = shops;
		this.q = q;
		this.executor = executor;
	}

	public Shop GetAvailableShop() {
		for (Shop s : shops) {
			if (s.isOpen()) {
				return s;
			}
		}
		return null;
	}

	public void run() {

		for (int time = 0; time < simulationTime; time++) {
			System.out.println("timpul este  " + time);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (Shop s : shops) {
				if (s.isReady(time)) {
					s.closeShop();
				}
				System.out.println(s);
			}

			for (Client c : q.getClients()) {
				// System.out.println("testeaza clientul" +c.toString()+ "la timpul"+time);
				if (c.getStartTime() == 0) {
					if (c.getTarrival() <= time) {
						Shop shop1 = GetAvailableShop();
						if (shop1 != null) {
							shop1.openShop(c, time);

							System.out.println("este randul clientului " + c);

						}

					}
				}

			}

			for (Client c : q.getClients()) {

				if (c.getStartTime() == 0) {
					if (c.getTarrival() <= time) {
						count++;
						System.out.println("Sunt " + count + " clienti la timpul " + time);
					}
					System.out.println("\n");

				}

				if (c.getStartTime() != 0) {
					if (c.getTservice() >= 0) {
						c.subTservice1();
					}
				}
			}
			count = 0;
		}
	}
}
