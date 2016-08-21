
public class Pagina {
	int numero;
	String texto = "";
	int op1 = -1;
	int op2 = -1;
	int op3 = -1;
	int att1 = -1;
	int att2 = -1;
	int att3 = -1;
	int val1 = -1;
	int val2 = -1;
	int val3 = -1;
	int item = -1;
	
	public Pagina() {
		// TODO Auto-generated constructor stub
	}
	public void decode(String linha){
		String colunas[] = linha.split(";");
		numero = Integer.parseInt(colunas[0]);
		texto = colunas[1];
		op1 = Integer.parseInt(colunas[2]);
		op2 = Integer.parseInt(colunas[3]);
		op3 = Integer.parseInt(colunas[4]);
		att1 = Integer.parseInt(colunas[5]);
		att2 = Integer.parseInt(colunas[6]);
		att3 = Integer.parseInt(colunas[7]);
		val1 = Integer.parseInt(colunas[8]);
		val2 = Integer.parseInt(colunas[9]);
		val3 = Integer.parseInt(colunas[10]);
		item = Integer.parseInt(colunas[11]);
	}
}
