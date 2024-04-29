import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int repeticoes = input.nextInt();
        String[] frase;
        int i = 0;
        input.nextLine();
        
        while(i < repeticoes) {
        	Lista l1 = new Lista();
        	frase = input.nextLine().split(" ");
        	
        	for(int j = 0; j < frase.length;j++) {
        		l1.addFrase(new Palavras(frase[j]));
        	}
        	
        	l1.ordenarLista();
        	l1.print();
        	i++;
        }
        
    }
}
class Palavras implements Comparable<Palavras>{
	private String palavras;
	
	public Palavras(String palavra) {
		setPalavras(palavra);
	}
	
	public String getPalavras() {
		return palavras;
	}

	public void setPalavras(String palavras) {
		this.palavras = palavras;
	}

	@Override
	public int compareTo(Palavras o){
		int comparador = 0;
		
		if(!(this.getPalavras().length() == o.getPalavras().length())) {
			comparador = this.getPalavras().length() < o.getPalavras().length() ? 1: -1;			
		}
		
		return comparador;
	}
}

class Lista{
	private List<Palavras> frase = new ArrayList<>();
	
	public void addFrase(Palavras palavra) {
		frase.add(palavra);
	}
	
	public void ordenarLista() {
		Collections.sort(frase);
	}
	
	public void print() {
        String texto = "";
		for(Palavras palavra: frase) {
			texto += palavra.getPalavras()+" ";
        }
        System.out.print(texto.substring(0, texto.length()-1));
        System.out.println();
        
	}
	
}