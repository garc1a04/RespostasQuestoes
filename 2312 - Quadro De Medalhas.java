import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        ListaDeNacionalidade Lista = new ListaDeNacionalidade();
        
        int repeticoes = input.nextInt();
        int i = 0;
        
        while(i < repeticoes) {
        	Lista.addListaNacionalidades(new Nacionalidade(input.next(), input.nextInt(),input.nextInt(),input.nextInt()));
        	i++;
        }
        
        Lista.ordenarListaNacionalidades();
        Lista.print();
        
        input.close();
    }
}
class Nacionalidade implements Comparable<Nacionalidade>{
	private String nome;
	private int medalhaOuro;
	private int medalhaPrata;
	private int medalhaBronze;
	
	
	Nacionalidade(String nome, int medalhaOuro, int medalhaPrata, int MedalhaBronze) {
		setNome(nome);
		setMedalhaOuro(medalhaOuro);
		setMedalhaPrata(medalhaPrata);
		setMedalhaBronze(MedalhaBronze);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getMedalhaOuro() {
		return medalhaOuro;
	}
	public void setMedalhaOuro(int medalhaOuro) {
		this.medalhaOuro = medalhaOuro;
	}
	public int getMedalhaPrata() {
		return medalhaPrata;
	}
	public void setMedalhaPrata(int medalhaPrata) {
		this.medalhaPrata = medalhaPrata;
	}
	public int getMedalhaBronze() {
		return medalhaBronze;
	}
	public void setMedalhaBronze(int medalhaBronze) {
		this.medalhaBronze = medalhaBronze;
	}

	@Override
	/*
	 número de medalhas de ouro. Se há empate em medalhas de ouro, 
	 a nação que tiver mais medalhas de prata fica a frente. Havendo 
	 empate em medalhas de ouro e prata, fica mais bem colocado o país 
	 com mais medalhas de bronze. Se dois ou mais países empatarem nos 
	 três tipos de medalhas, seu programa deve mostrá-los em ordem 
	 alfabética.
	 */
	
	public int compareTo(Nacionalidade o) {
		int comparador = o.getMedalhaOuro() - this.getMedalhaOuro();
		
		if(comparador == 0) {
			comparador = o.getMedalhaPrata() - this.getMedalhaPrata();
			
		} if(comparador == 0) {
			comparador = o.getMedalhaBronze() - this.getMedalhaBronze();
			
		} if(comparador == 0) {
			comparador = this.getNome().compareTo(o.getNome());
		}
		
		return comparador;
	}
	
	
}
class ListaDeNacionalidade{
	private ArrayList<Nacionalidade> ListaNacionalidades = new ArrayList<>();
	
	public void addListaNacionalidades(Nacionalidade NA) {
		ListaNacionalidades.add(NA);
	}
	
	public void ordenarListaNacionalidades() {
		Collections.sort(ListaNacionalidades);
	}
	
	public void print() {
		for(Nacionalidade Nacio : ListaNacionalidades) {
			System.out.printf("%s %d %d %d\n",Nacio.getNome(),Nacio.getMedalhaOuro(),Nacio.getMedalhaPrata(),Nacio.getMedalhaBronze());
		}
		
	}
}
