import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 1259 - Pares e Ímpares
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Valores valores = new Valores();
        
        int repeticoes = input.nextInt();
        int i = 0;
        while(i < repeticoes) {
        	valores.addValores(input.nextInt());
        	
        	i++;
        }
        
        valores.ordenarValores();
        valores.print();
    }
}

class Valores{
	private List<Integer> pares = new ArrayList<>();
	private List<Integer> impares = new ArrayList<>();
	
	public void addValores(int valor) {
		if(valor%2==0) {
			pares.add(valor);
		} else if(valor%2 !=0){
			impares.add(valor);
		}
		
	}
	
	public void ordenarValores() {
		Collections.sort(pares);
		Collections.sort(impares, Collections.reverseOrder());
	}
	
	public void print() {
		for(int valor: pares) {
			System.out.println(valor);
		}
		
		for(int valor: impares) {
			System.out.println(valor);
		}
		
	}
	
}