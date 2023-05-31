
import java.io.IOException;

import java.util.List;

public class Compilador {

	public List<String> alfabeto;
	public List<String> exemplo;
	public List<String> expressoes;
	public List<String> dicionario;
	public Compilador() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<String> Iniciar() throws IOException {
		String linha;
		System.out.println("Iniciando o compilador...");
		
		LerArquivo leitor = new LerArquivo();
		alfabeto = leitor.ler("C:\\Users\\w3llHcK2\\Downloads\\cbr-main\\N1\\alfabeto.txt");
		exemplo = leitor.ler("C:\\Users\\w3llHcK2\\Downloads\\cbr-main\\N1\\exemplo.txt");
		expressoes = leitor.ler("C:\\Users\\w3llHcK2\\Downloads\\cbr-main\\N1\\expressoes.txt");
		dicionario = leitor.ler("C:\\Users\\w3llHcK2\\Downloads\\cbr-main\\N1\\dicionario.txt");
		for( int i =0; i < alfabeto.size();i++) {
			System.out.println(alfabeto.get(i));
		}
		System.out.println("--------------");
		AnalisadorLexico lexico = new AnalisadorLexico();
		for( int i =0; i < exemplo.size();i++) {
			linha = exemplo.get(i);
			lexico.analisar(linha, alfabeto);
		}
		AnalisadorSintatico sintatico = new AnalisadorSintatico();
		for( int i =0; i < exemplo.size();i++) 
		{
			linha = exemplo.get(i);
			sintatico.analisar(linha, expressoes);
		}		
		
		System.out.println("Analisando semanticamente");
		AnalisadorSemantico semantico = new AnalisadorSemantico();
		for( int i =0; i < exemplo.size();i++) 
		{
			linha = exemplo.get(i);
			semantico.Analisar(linha, dicionario);
		}
		System.out.println("Fim da analise semantica");

		String byteCode = "";
		GeradorByteCode gerador = new GeradorByteCode();
		byteCode += "\n\n\nimport java.util.Scanner\n\n";
		byteCode += " public class Exemplo {\n";
		byteCode += "  public static void main(String[] args){\n";
		byteCode += "    Scanner teclado = new Scanner(System.in);\n";

		for( int i =0; i < exemplo.size();i++) 
		{
			linha = exemplo.get(i);			 
			byteCode += gerador.gerar(linha);
			
		}		
		System.out.print(byteCode);
		return exemplo;
    }
	
}