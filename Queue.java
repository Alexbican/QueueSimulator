package PT2020.demo.Tema2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Queue implements Runnable {
	
	private int max_service_time;
	private int min_service_time;
	private int max_arrival_time;
	private int min_arrival_time;
	private int nrClienti;
	private int simulationTime;

	private List<Client> clients = new ArrayList<Client>();

	public Queue() {

	}
	
	public Queue(int nrClienti,int simulationTime,int min_arrival_time,int max_arrival_time,int min_service_time,int max_service_time) {
        this.nrClienti=nrClienti;
        this.simulationTime=simulationTime;
        this.min_arrival_time=min_arrival_time;
        this.max_arrival_time=max_arrival_time;
        this.min_service_time=min_service_time;
        this.max_service_time=max_service_time;
	}

	public List<Client> getList() {
		return this.clients;
	}

	public Client getClient(int index) {

		return clients.get(index);
	}
	
	// metoda de generare a timpiilor
	public Client generateClient(int id) {
		Random rand = new Random();
		int serviceTime = rand.nextInt(max_service_time - min_service_time) + min_service_time;
		int arrivalTime = rand.nextInt(max_arrival_time - min_arrival_time) + min_arrival_time;
		return new Client(id, arrivalTime, serviceTime);

	}

	// metoda de adaugare in coada a clientilor
	public void generateClients() {
		for (int i = 0; i < nrClienti; i++) {
			Client client = generateClient(i);
			clients.add(client);
		}
	}

	// sorteaza clienti
	public void SortClients() {
		Collections.sort(clients);
	}
	
	public List<Client> getClients() {
		return clients;
	}
	
	
	public int getSize() {
		return clients.size();
	}

	// stergerea unui client din program
	public void removeClient(Client c) {
		clients.remove(c);
	}

	// verificam daca coada este goala
	public boolean emptyQueue() {
		if (this.clients.isEmpty()) {
			return true;
		}
		return false;
	}
	
	


	// aflam lunfimea cozii
	public int getQueueSize() {
		return nrClienti;
	}

	// metoda de afisare
	public String toString() {

		String message = new String();
		for (Client c : clients) {
			message = message + c.toString() + "\n";
		}

		return message + "\nNumarul de clienti:" + nrClienti  + "\nTimp de simulare:"
				+ simulationTime + "\nTimp minim arrival:" + min_arrival_time + "\nTimp maxim arrival:" + max_arrival_time
				+ "\nTimp minim service:" + min_service_time + "\nTimp maxim service:" + max_service_time
				+ "\nlungimea listei:" + clients.size();
	}

	public void run() {

	}

}
