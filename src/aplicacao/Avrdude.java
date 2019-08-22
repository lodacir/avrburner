package aplicacao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Avrdude {

	private ArrayList<String> listaDeGravadores;
	private ArrayList<String> listaDeUc;
	private ArrayList<String> listaDePortas;
	
	private String gravador;
	private String microcontrolador;
	private String arquivo;
	private String porta;
	
	
	
	public Avrdude() {
		this.listaDeGravadores = new ArrayList<String>();
		this.listaDeUc = new ArrayList<String>();
		this.listaDePortas = new ArrayList<String>();
		this.listaDePortas.add("/dev/ttyUSB0");
		this.listaDePortas.add("/dev/ttyUSB1");
		this.listaDePortas.add("/dev/ttyUSB2");
		this.listaDePortas.add("/dev/ttyUSB3");
		this.listaDePortas.add("/dev/ttyUSB4");
		this.listaDePortas.add("/dev/ttyUSB5");
		
	}

	public ArrayList<String> getListaDePortas() {
		return listaDePortas;
	}



	public void setListaDePortas(ArrayList<String> listaDePortas) {
		this.listaDePortas = listaDePortas;
	}



	public String getGravador() {
		return gravador;
	}



	public void setGravador(String gravador) {
		this.gravador = gravador;
	}



	public String getMicrocontrolador() {
		return microcontrolador;
	}



	public void setMicrocontrolador(String microcontrolador) {
		this.microcontrolador = microcontrolador;
	}



	public String getArquivo() {
		return arquivo;
	}



	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}



	public String getPorta() {
		return porta;
	}



	public void setPorta(String porta) {
		this.porta = porta;
	}



	public ArrayList<String> getListaDeGravadores() {
		return listaDeGravadores;
	}



	public void setListaDeGravadores(ArrayList<String> listaDeGravadores) {
		this.listaDeGravadores = listaDeGravadores;
	}



	public ArrayList<String> getListaDeUc() {
		return listaDeUc;
	}



	public void setListaDeUc(ArrayList<String> listaDeUc) {
		this.listaDeUc = listaDeUc;
	}



	/**
	 * Lista todos os gravadores disponíveis pelo AVRDUDE
	 */
	public void listarGravadores() {

		ArrayList<String> listaDeGravadores = new ArrayList<String>();
		Runtime run = Runtime.getRuntime();

		try {

			String command = "avrdude -c asdf";

			Process p = run.exec(command);

			Scanner scanner = new Scanner(p.getErrorStream()).useDelimiter("\n");
			while (scanner.hasNext()) {
				// System.out.println("Resposta");
				// System.out.println(scanner.useDelimiter("$$").next());
				listaDeGravadores.add(scanner.useDelimiter("\n").next());
			}
			// System.out.print("\n##Processo Finalizado.");
			for (int i = 0; i < listaDeGravadores.size(); i++) {
				// System.out.println(listaDeGravadores.get(i));
				this.listaDeGravadores.add(this.filtraStringGravador(listaDeGravadores.get(i)));

			}
			// System.out.println(this.listaDeGravadores.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param frase
	 */
	private String filtraStringGravador(String frase) {
		int posFinal = frase.indexOf("=");
		int posInicial = 0;
		String tempstring = "";
		if (posFinal != -1) {
			tempstring = frase.substring(posInicial, posFinal);
			tempstring = tempstring.replaceAll(" ", "");
			// System.out.println("String cortada= "+tempstring);

		}
		return tempstring;

	}

	/**
	 * Lista todos os microcontroladores disponíveis pelo AVRDUDE
	 */
	public void listarUc() {

		ArrayList<String> listaDeUc = new ArrayList<String>();
		Runtime run = Runtime.getRuntime();
		
		try {

			String command = "avrdude -c avrisp";
			
			Process p = run.exec(command);

			Scanner scanner = new Scanner(p.getErrorStream()).useDelimiter("\n");
			while (scanner.hasNext()) {
				// System.out.println("Resposta");
				// System.out.println(scanner.useDelimiter("$$").next());
				listaDeUc.add(scanner.useDelimiter("\n").next());
			}
			// System.out.print("\n##Processo Finalizado.");
			for (int i = 0; i < listaDeUc.size(); i++) {
				// System.out.println(listaDeUc.get(i));
				this.listaDeUc.add(this.filtraStringUc(listaDeUc.get(i)));

			}
			// System.out.println(this.listaDeUc.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param frase
	 */
	private String filtraStringUc(String frase) {

		int posInicial = frase.indexOf("=") + 1;
		String tempstring = "";
		if (posInicial != -1) {
			tempstring = frase.substring(posInicial);
			tempstring = tempstring.replaceAll(" ", "");
			// System.out.println("String cortada= "+tempstring);

		}
		return tempstring;

	}
	
	/**
	 * 
	 * @param tipo 1 paraflash e 2 para eeprom
	 * @return
	 */
	public String gravarArquivo(int tipo) {
		Runtime run = Runtime.getRuntime();
		String command = "";
		
		switch (tipo) {
		case 1:
		{
			command = "avrdude -c "+this.gravador+" -p "+this.microcontrolador+" -P "+this.porta+" -e -U flash:w:"+this.arquivo;
			break;	
		}
		case 2:
		{
			command = "avrdude -c "+this.gravador+" -p "+this.microcontrolador+" -P "+this.porta+" -e -U eeprom:w:"+this.arquivo;
			break;	
		}
			
		}
		//System.out.println(command);
		String output = "";
		try {


			Process p = run.exec(command);

			Scanner scanner = new Scanner(p.getErrorStream()).useDelimiter("$$");
			if (scanner.hasNext()) {
				// System.out.println("Resposta");
				output = scanner.useDelimiter("$$").next();
				//System.out.println(output);
				
			}
			
			// System.out.println(this.listaDeUc.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;
		
	}
	
	public boolean exists() {
		
		Runtime run = Runtime.getRuntime();
		String command = "";
		command = "avrdude -v";

		//System.out.println(command);
		String output = "";
		try {


			Process p = run.exec(command);

			Scanner scanner = new Scanner(p.getErrorStream()).useDelimiter("$$");
			if (scanner.hasNext()) {
				// System.out.println("Resposta");
				output = scanner.useDelimiter("\n").next();
				//System.out.println(output);
				
			}
			
			if(output.contains("avrdude: Version")) {
				return true;
			}
			System.out.println(output);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
