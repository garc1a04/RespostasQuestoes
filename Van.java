import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
// 2693 - Van
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  
        
        while(input.hasNext()) {
        	int repeticoes = input.nextInt();
        	int i = 0;
        	Van van = new Van();
        	
        	input.nextLine();
        	while(i < repeticoes) {
        		
        		van.addAlunosPresentes(new Aluno(input.next(),input.next(),input.nextInt()));
        		input.nextLine();
        		
        		i++;
        	}
        	van.ordenarAlunosPresentes();
        	van.print();
        	
        }   	
    }
}

class Aluno implements Comparable<Aluno>{
	private String nome;
	private String direcao;
	private int distancia;
	
	public Aluno(String nome,String direcao, int distancia) {
		setNome(nome);
		setDirecao(direcao);
		setDistancia(distancia);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDirecao() {
		return direcao;
	}
	
	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}
	
	public int getDistancia() {
		return distancia;
	}
	
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	@Override
	// ele pediu sua ajuda para desenvolver essa rota ordenando 
	//os alunos pela distância(da menor para a maior), pela região 
	//(em ordem alfabética) e por último pelo nome. 
	public int compareTo(Aluno o) {
		int comparador = 0;
		
		if(!(getDistancia() == o.getDistancia())) {
			comparador = getDistancia() < o.getDistancia() ?-1:1;	
			
		} if(comparador == 0) {
			comparador = this.getDirecao().compareTo(o.getDirecao());	
			
		} if(comparador == 0) {
			comparador = this.getNome().compareTo(o.getNome());
			
		}
		
		return comparador;
	}
	
	
	
}
class Van{
	private List<Aluno> alunosPresentes = new ArrayList<>();
	
	public void addAlunosPresentes(Aluno aluno) {
		alunosPresentes.add(aluno);
	}
	
	public void ordenarAlunosPresentes() {
		Collections.sort(alunosPresentes);
	}
	
	public void print() {
		for(Aluno aluno: alunosPresentes) {
			System.out.println(aluno.getNome());
		}
		
	}
}