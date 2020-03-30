package PT2020.demo.Tema2;

public class MainClass {

	public static void main(String[] args) {
		Queue q = new Queue();
		String fileName ="in-test-1.txt";
		q.readFile(fileName);
		
		q.generateClient(1);
		System.out.println(q);
		//System.out.println("Numarul de clienti este: "+q.readFile(fileName));
		//System.out.println("Numarul de cozi este: "+q.readFile(fileName));
		//System.out.println("Timpul de simulare este: "+q.readFile(fileName));
		
		

	}
}
