package PT2020.demo.Tema2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Random;


public class Queue implements Runnable {

	private List<Client> clients = new ArrayList<Client>();

	private int max_service_time;
	private int min_service_time;
	private int max_arrival_time;
	private int min_arrival_time;
	private int nrClienti;
	private int nrCozi;
	private int timpSimulare;

	public Queue() {

	}
	
	public List<Client> getList() {
		return this.clients;
	}

	public void addClients(Client c) {

		clients.add(c);
	}

	public Client getClient(int index) {

		return clients.get(index);
	}

	public int getSize() {
		return clients.size();
	}

	public void readFile(String fileName) {
		try {
			File file = new File(fileName);
			Scanner s = new Scanner(file);

			String data = s.nextLine();
			nrClienti = Integer.parseInt(data);

			String data1 = s.nextLine();
			nrCozi = Integer.parseInt(data1);

			String data2 = s.nextLine();
			timpSimulare = Integer.parseInt(data2);

			String data3 = s.nextLine();
			String[] arrival = data3.split(",");
			min_arrival_time = Integer.parseInt(arrival[0]);
			max_arrival_time = Integer.parseInt(arrival[1]);

			String data4 = s.nextLine();
			String[] service = data4.split(",");
			min_service_time = Integer.parseInt(service[0]);
			max_service_time = Integer.parseInt(service[0]);

			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
    }
	
	public Client generateClient(int id) {
		Random rand =new Random();
		int serviceTime=rand.nextInt(max_service_time-min_service_time)+min_service_time;
		int arrivalTime=rand.nextInt(max_arrival_time-min_arrival_time)+min_arrival_time;
		return new Client(id,arrivalTime,serviceTime);
	}
	
	public String toString() {
		
		return "Numarul de clienti:" +nrClienti+ " \nNumarul de cozi:" +nrCozi+ "\nTimp de simulare:" +timpSimulare
				+"\nTimp minim arrival:"+ min_arrival_time +"\nTimp maxim arrival:"+max_arrival_time 
			    +"\nTimp minim service:"+ min_service_time +"\nTimp maxim service:"+max_service_time;
	}

	

	public void run() {

	}

}
