import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.stream.FileImageInputStream;

public class GameMain {
	Heroi heroi1;
	Heroi heroi2;
	Scanner scanner;
	
	boolean rodandoojogo = true;
	
	ArrayList<Pagina> listaDePaginas; 
	Pagina paginaAtual;
	ArrayList<Item> listadeitens;
	
	public static void main(String[] args) {
		GameMain game = new GameMain();
	}
	
	public GameMain(){
		listadeitens = new ArrayList<Item>();
		listadeitens.add(new Item("Espada"));//0
		listadeitens.add(new Item("Escudo"));//1
		listadeitens.add(new Item("Machado"));//2
		listadeitens.add(new Item("Adaga"));//3
		listadeitens.add(new Item("Arco e Flechas"));//4
		listadeitens.add(new Item("Cajado"));//5
		
		listaDePaginas = new ArrayList<Pagina>();
		
		File f = new File("jogo.csv");
		try {
			InputStream in = new FileInputStream(f);
			BufferedReader bfr = new BufferedReader(new InputStreamReader(in));
			
			String line = "";
			int cout = 0;
			while((line = bfr.readLine())!=null){
				if(!(line.charAt(0)=='#')){
					cout++;
					
					Pagina p = new Pagina();
					char eol = 10;
					line = line.replace(""+'\\'+'n', ""+eol);
					//System.out.println(cout+" - "+line);
					p.decode(line);
					listaDePaginas.add(p);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		char cc = '\\';
//		System.out.println("cc "+(int)cc);
		
		paginaAtual = listaDePaginas.get(0);
		
		
		heroi1 = new Heroi();
		heroi2 = new Heroi();
		
		scanner = new Scanner(System.in);

		System.out.println("Criando Primeiro Heroi");
		PedeAtributos(heroi1);
		
		System.out.println("\nCriando Segundo Heroi");
		PedeAtributos(heroi2);
		
		System.out.println();
		heroi1.mostraAtributos();
		System.out.println();
		heroi2.mostraAtributos();
		
		for(int i = 0; i < listaDePaginas.size();i++){
			Pagina p = listaDePaginas.get(i);
			p.texto = p.texto.replace("@1", heroi1.nome);
			p.texto = p.texto.replace("@2", heroi2.nome);
		}
		
		while(rodandoojogo){
			System.out.println(paginaAtual.texto);
			int op = scanner.nextInt();
			if(op==1&&paginaAtual.op1>=0){
				if(paginaAtual.att1==-1||heroi1.atributos[paginaAtual.att1]>=paginaAtual.val1){
					paginaAtual = listaDePaginas.get(paginaAtual.op1);
					if(paginaAtual.item!=-1){
						heroi1.addItem(listadeitens.get(paginaAtual.item));
					}
				}else{
					System.out.println("Atributo "+Heroi.nomeDoAtributo[paginaAtual.att1]+" insuficiente");
				}
			}else if(op==2&&paginaAtual.op2>=0){
				if(paginaAtual.att2==-1||heroi1.atributos[paginaAtual.att2]>=paginaAtual.val2){
					paginaAtual = listaDePaginas.get(paginaAtual.op2);	
					if(paginaAtual.item!=-1){
						heroi1.addItem(listadeitens.get(paginaAtual.item));
					}
				}else{
					System.out.println("Atributo "+Heroi.nomeDoAtributo[paginaAtual.att2]+" insuficiente");
				}
			}else if(op==3&&paginaAtual.op3>=0){
				if(paginaAtual.att3==-1||heroi1.atributos[paginaAtual.att3]>=paginaAtual.val3){
					paginaAtual = listaDePaginas.get(paginaAtual.op3);	
					if(paginaAtual.item!=-1){
						heroi1.addItem(listadeitens.get(paginaAtual.item));
					}
				}else{
					System.out.println("Atributo "+Heroi.nomeDoAtributo[paginaAtual.att3]+" insuficiente");
				}
			}else if(paginaAtual.op1==-1&&paginaAtual.op2==-1&&paginaAtual.op3==-1){
				rodandoojogo = false;
			}else if(op==0){
				heroi1.mostraAtributos();
			}else{
				System.out.println("Comando Invalido");
			}
		}
	}

	private void PedeAtributos(Heroi heroi) {
		
		System.out.print("Digite o nome de seu Heroi: ");
		heroi.nome = scanner.next();
		System.out.print("Qual a idade dele: ");
		heroi.idade = scanner.nextInt();

		boolean ok = true;
		
		do{
			System.out.print("Qual a vitalidade de ("+heroi.nome+")["+heroi.pontosrestantes+"]: ");
			int vit = scanner.nextInt();
			if(vit <= heroi.pontosrestantes && vit>=0){
				heroi.atributos[Heroi.VITALIDADE] = vit;
				heroi.pontosrestantes-=vit;
				ok = true;
			}else{
				System.out.println("Quantidade de Pontos Insuficiente");
				ok = false;
			}
		}while(!ok);

		
		do{
			System.out.print("Qual a forca de ("+heroi.nome+")["+heroi.pontosrestantes+"]: ");
			int forc = scanner.nextInt();
			if(forc <= heroi.pontosrestantes && forc>=0){
				heroi.atributos[Heroi.FORCA] = forc;
				heroi.pontosrestantes-=forc;
				ok = true;
			}else{
				System.out.println("Quantidade de Pontos Insuficiente");
				ok = false;
			}
		}while(!ok);
		
		do{
			System.out.print("Qual a agilidade de ("+heroi.nome+")["+heroi.pontosrestantes+"]: ");
			int agg = scanner.nextInt();
			if(agg <= heroi.pontosrestantes && agg>=0){
				heroi.atributos[Heroi.AGILIDADE] = agg;
				heroi.pontosrestantes-=agg;
				ok = true;
			}else{
				System.out.println("Quantidade de Pontos Insuficiente");
				ok = false;
			}
		}while(!ok);
		
		do{
			System.out.print("Qual a inteligencia de ("+heroi.nome+")["+heroi.pontosrestantes+"]: ");
			int inte = scanner.nextInt();
			if(inte <= heroi.pontosrestantes && inte>=0){
				heroi.atributos[Heroi.INTELIGENCIA] = inte;
				heroi.pontosrestantes-=inte;
				ok = true;
			}else{
				System.out.println("Quantidade de Pontos Insuficiente");
				ok = false;
			}
		}while(!ok);
	}
}
