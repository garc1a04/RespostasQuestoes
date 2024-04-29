import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        int repeticoes = input.nextInt();
        int i = 0;
        
        ListaNoel lista = new ListaNoel();
        input.nextLine();
        
        while(i < repeticoes) {
        	String[] Crianca = input.nextLine().split(" ");
        	
        	lista.addListaCriancas(new Criancas(Crianca[0],Crianca[1]));
        	i++;
        }
        lista.ordenarListaCriancas();
        lista.print();
    }
}

class Criancas implements Comparable<Criancas>{
	private String Comportamento;
	private String Nome;
	
	Criancas(String Comportamento, String Nome){
		setNome(Nome);
		setComportamento(Comportamento);
	}
	
	public String getComportamento() {
		return Comportamento;
	}

	public void setComportamento(String comportamento) {
		Comportamento = comportamento;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	@Override
	public int compareTo(Criancas o) {
		return this.getNome().compareTo(o.getNome());
	}
}
class ListaNoel{
	private List<Criancas> listaCriancas = new ArrayList<>();
	private int comportaram = 0;
	private int naoComportaram = 0;
	
	public void addListaCriancas(Criancas crianca) {
		if(crianca.getComportamento().equals("+")) {
			comportaram++;
			
		} else if(crianca.getComportamento().equals("-")) {
			naoComportaram++;
		}
		
		listaCriancas.add(crianca);
	}
	
	public void ordenarListaCriancas() {
		Collections.sort(listaCriancas);
	}
	
	public int getComportaram() {
		return comportaram;
	}

	public int getNaoComportaram() {
		return naoComportaram;
	}
	
	public void print() { 
		for(Criancas crianca: listaCriancas) {
			System.out.println(crianca.getNome());
		}
		
		System.out.printf("Se comportaram: %s | Nao se comportaram: %s\n",getComportaram(),getNaoComportaram());
	}
}