import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
// 1766 - O Elfo das Trevas
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        
        int repeticoes = input.nextInt();
        int i = 0;
        
        while(i < repeticoes) {
        	OrganizacaoRenas orgRenas = new OrganizacaoRenas();
        	int renasEstabulo = input.nextInt();
        	int RenasNecessarias = input.nextInt();
        	
        	for(int j = 0;j < renasEstabulo;j++) {
        		orgRenas.addRenasPegas(new Rena(input.next(),input.nextInt(), input.nextInt(), input.nextDouble()));
        	}
        	
        	orgRenas.ordenarRenasPegas();
        	System.out.printf("CENARIO {%d}\n",i+1);
        	orgRenas.print(RenasNecessarias);
        	
        	i++;
        }        
    }
}

class Rena implements Comparable<Rena>{
	private String nome;
	private int Peso;
	private int Idade;
	private double Altura;
	
	public Rena(String nome, int Peso, int Idade, double Altura){
		setNome(nome);
		setPeso(Peso);
		setIdade(Idade);
		setAltura(Altura);
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPeso() {
		return Peso;
	}
	public void setPeso(int peso) {
		Peso = peso;
	}
	public int getIdade() {
		return Idade;
	}
	public void setIdade(int idade) {
		Idade = idade;
	}
	public double getAltura() {
		return Altura;
	}
	public void setAltura(double altura) {
		Altura = altura;
	}
	
	@Override
	public int compareTo(Rena o) {
		int comparador = o.getPeso()- this.getPeso();
		
		if(comparador == 0) {
			comparador = this.getIdade() - o.getIdade();
			
		} if(comparador == 0) {
			comparador = (int) ((this.getAltura() - o.getAltura())*100);
			
		} if(comparador == 0) {
			comparador = this.getNome().compareTo(o.getNome());
		}
		
		return comparador;
	}

}
class OrganizacaoRenas{ 
	private List<Rena> renasPegas = new ArrayList<>();
	
	public void addRenasPegas(Rena rena) {
		renasPegas.add(rena);
	}
	
	public void ordenarRenasPegas() {
		Collections.sort(renasPegas);
	}
	
	public void print(int renasNecessarias) {
		for(int i = 0; i < renasNecessarias; i++) {
			//System.out.println(renasPegas.get(i).getNome()+" "+ renasPegas.get(i).getPeso()+" " +renasPegas.get(i).getIdade()+" "+renasPegas.get(i).getAltura());
			
			System.out.printf("%d - %s\n",i+1,renasPegas.get(i).getNome());
		}
	}
}