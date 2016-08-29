import java.util.ArrayList;

public class Heroi {
	String nome;
	int idade;
	
	int pontos = 200;
	int pontosrestantes = 200;
	
	static int VITALIDADE = 0;
	static int FORCA = 1;
	static int AGILIDADE = 2;
	static int INTELIGENCIA = 3;
	
	static String nomeDoAtributo[] = {"Vitalidade","For�a","Agilidade","Inteligencia"};
	
	int atributos[];
//	int vitalidade = 0;//0
//	int forca = 0;//1
//	int agilidade = 0;//2
//	int inteligencia = 0;//3
	
	private ArrayList<Item> meusItens;
	
	public Heroi() {
		// TODO Auto-generated method stub
		atributos = new int[4];
		meusItens = new ArrayList<Item>();
	}
	
	public void mostraAtributos(){
		
		System.out.println("[Nome        : "+nome+"]");
		System.out.println("[Idade       : "+idade+"]");
		System.out.println("[Vitalidade  : "+atributos[VITALIDADE]+"]");
		System.out.println("[Forca       : "+atributos[FORCA]+"]");
		System.out.println("[Agilidade   : "+atributos[AGILIDADE]+"]");
		System.out.println("[Inteligencia: "+atributos[INTELIGENCIA]+"]");
		System.out.println("\n INVENT�RIO");
		for(int i = 0; i < meusItens.size();i++){
			Item it = meusItens.get(i);
			System.out.println(""+it.nome);
		}
		
	}
	
	public void addItem(Item item){
		switch (item.nome) {
		case "Espada":
			atributos[FORCA]+=10;
			System.out.println("Aumentou sua For�a em 10 \n Suas habilidades atuais s�o: \n For�a: " + atributos[FORCA] + "\n Vitalidade: " + atributos[VITALIDADE] + "\n Agilidade: " + atributos[AGILIDADE] + "\n Intelig�ncia: " + atributos[INTELIGENCIA] );
			break;
		case "Escudo":
			atributos[VITALIDADE]+=20;
			System.out.println("Aumentou sua Vitalidade em 20 \n Suas habilidades atuais s�o: \n For�a: " + atributos[FORCA] + "\n Vitalidade: " + atributos[VITALIDADE] + "\n Agilidade: " + atributos[AGILIDADE] + "\n Intelig�ncia: " + atributos[INTELIGENCIA] );
			break;
		case "Machado":
			atributos[FORCA]+=20;
			System.out.println("Aumentou sua For�a em 20 \n Suas habilidades atuais s�o: \n For�a: " + atributos[FORCA] + "\n Vitalidade: " + atributos[VITALIDADE] + "\n Agilidade: " + atributos[AGILIDADE] + "\n Intelig�ncia: " + atributos[INTELIGENCIA] );
			break;
		case "Adaga":
			atributos[AGILIDADE]+=20;
			System.out.println("Aumentou sua Agilidadea em 20 \n Suas habilidades atuais s�o: \n For�a: " + atributos[FORCA] + "\n Vitalidade: " + atributos[VITALIDADE] + "\n Agilidade: " + atributos[AGILIDADE] + "\n Intelig�ncia: " + atributos[INTELIGENCIA] );
			break;
		case "Arco e Flechas":
			atributos[INTELIGENCIA]+=10;
			System.out.println("Aumentou sua Intelig�ncia em 10 \n Suas habilidades atuais s�o: \n For�a: " + atributos[FORCA] + "\n Vitalidade: " + atributos[VITALIDADE] + "\n Agilidade: " + atributos[AGILIDADE] + "\n Intelig�ncia: " + atributos[INTELIGENCIA] );
			break;
		case "Cajado":
			atributos[INTELIGENCIA]+=20;
			System.out.println("Aumentou sua Intelig�ncia em 20 \n Suas habilidades atuais s�o: \n For�a: " + atributos[FORCA] + "\n Vitalidade: " + atributos[VITALIDADE] + "\n Agilidade: " + atributos[AGILIDADE] + "\n Intelig�ncia: " + atributos[INTELIGENCIA] );
			break;
		default:
			break;
		}	
	}
	
}
