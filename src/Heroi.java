import java.util.ArrayList;

public class Heroi {
	String nome;
	int idade;
	
	int pontos = 80;
	int pontosrestantes = 80;
	
	static int VITALIDADE = 0;
	static int FORCA = 1;
	static int AGILIDADE = 0;
	static int INTELIGENCIA = 0;
	
	static String nomeDoAtributo[] = {"Vitalidade","Força","Agilidade","Inteligencia"};
	
	int atributos[];
//	int vitalidade = 0;//0
//	int forca = 0;//1
//	int agilidade = 0;//2
//	int inteligencia = 0;//3
	
	ArrayList<Item> meusItens;
	
	public Heroi() {
		// TODO Auto-generated method stub
		atributos = new int[4];
		meusItens = new ArrayList<Item>();
	}
	
	public void mostraAtributos(){
		
		System.out.println("[Nome  : "+nome+" - "+idade+"]");
		System.out.println("[Vitalidade  : "+atributos[VITALIDADE]+"]");
		System.out.println("[Forca       : "+atributos[FORCA]+"]");
		System.out.println("[Agilidade   : "+atributos[AGILIDADE]+"]");
		System.out.println("[Inteligencia: "+atributos[INTELIGENCIA]+"]");
		System.out.println("\n INVETARIO");
		for(int i = 0; i < meusItens.size();i++){
			Item it = meusItens.get(i);
			System.out.println(""+it.nome);
		}
		
	}
}
