

public class GeradorByteCode {

	public GeradorByteCode() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String gerar(String linha) {		

		String[] token = linha.split(" ");
		String op = token[0];	
		switch(op){
			case "para":
				return "     for( " + token[1]+" = "+token[3]+"; "+token[1] +" "+token[4] +" "+token[5]+"; "+token[1]+"++){\n";
			
			case "finpara;":
				return "     }\n";
			
			case "leer":
				return "     "+token[1].replace(";","") + " = teclado.nextInt();\n";

			case "entero":
				return "     int " + token[1]+"\n";

			case "si":
				return "     if( "+token[1]+" "+token[2]+" "+token[3]+"){\n";
			
			case "finsi;":
				return "     }\n";

			case "devolver":
				return "  }\n}\n";
			
			case "escribir":
				return "      System.out.println("+token[1].replace(";", "")+");\n";
		}			
		return "     "+linha+"\n";
	}
}
