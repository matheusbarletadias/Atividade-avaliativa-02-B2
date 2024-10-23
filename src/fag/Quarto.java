package fag;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

@SuppressWarnings("unused")
public class Quarto {
	private int numeroQuarto;
	private int tipo;
	private double preco;
	private boolean status;
	private static Set<Integer> quartoExistente = new HashSet<>();	
	
	static Scanner sc = new Scanner(System.in);
	
	public Quarto(int numero, int tipo, double preco) {
		this.numeroQuarto = numero;
		this.tipo = tipo;
		this.preco = preco;
		this.status = true;
	}

	static int numQuartoVerificacao(int numero) {
		int numeroVerificado = numero;
		boolean passou = false;
		while(passou==false) {
			if (!quartoExistente.contains(numeroVerificado)) {
				quartoExistente.add(numeroVerificado);
				passou = true;
			}else {
				System.out.println("\n\n\n\nEsse quarto já existe! \n Digite outro numero: ");
				numeroVerificado = sc.nextInt();
			}			
		}
		return numeroVerificado;
	}

	@Override
	public String toString() {
		String tipoQuarto = null;
		String disponibilidade = null;
		if(tipo==1) {
			tipoQuarto = "Solteiro";
		}else if(tipo==2) {
			tipoQuarto = "Casal";
		}else if(tipo>2) {
			tipoQuarto = "Suite";
		}
		
		if(status == true) {
			disponibilidade = "Disponivel";
		}else {
			disponibilidade = "Indisponivel";
		}
		return "Quarto\n\n Numero: " + numeroQuarto + "\n Tipo: " + tipoQuarto + "\n Diaria: " + preco + "\n Status: " + disponibilidade;
	}
	
	public String toString1() {
		String tipoQuarto = null;
		if(tipo==1) {
			tipoQuarto = "Solteiro";
		}else if(tipo==2) {
			tipoQuarto = "Casal";
		}else if(tipo>2) {
			tipoQuarto = "Suite";
		}
		return "Quarto\n\n Numero: " + numeroQuarto + "\n Tipo: " + tipoQuarto;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public static Set<Integer> getQuartoExistente() {
		return quartoExistente;
	}

	public static void setQuartoExistente(Set<Integer> quartoExistente) {
		Quarto.quartoExistente = quartoExistente;
	}
	
	public static void removeQuartoExistente(int numero) {
		quartoExistente.remove(numero);
	}
		
}
