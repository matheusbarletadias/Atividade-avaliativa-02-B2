package fag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Hospede {
	private String nome;
	private int cpf;
	private int id;
	private static Set<Integer> idsExistentes = new HashSet<>();
	
	public Hospede(String nome, int cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.id = gerarId();
	}
	
	private int gerarId() {
		Random random = new Random();
		int novoId;
		do {
			novoId = random.nextInt(1000);
		}while (idsExistentes.contains(novoId));		
		idsExistentes.add(novoId);
		return novoId;		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static Set<Integer> getIdsExistentes() {
		return idsExistentes;
	}

	public static void setIdsExistentes(Set<Integer> idsExistentes) {
		Hospede.idsExistentes = idsExistentes;
	}
	
	public static void removeHospedeExistente(int apaga) {
		Hospede.idsExistentes.remove(apaga);
	}

	public String toString() {
		return "Hospede \n nome: " + nome + "\n cpf: " + cpf;
	}
	
	
	
	
}
