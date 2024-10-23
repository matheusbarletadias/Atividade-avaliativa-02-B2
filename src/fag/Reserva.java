package fag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Reserva {
	private Hospede cliente;
	private LocalDate checkIn;
    private LocalDate checkOut;
    private List<Quarto> listaDeQuartos;
	
	static Scanner sc = new Scanner(System.in);
	
	 public Reserva(Hospede cliente, LocalDate checkIn, LocalDate checkOut) {
		 this.cliente = cliente;
		 this.checkIn = checkIn;
	     this.checkOut = checkOut;
	     this.listaDeQuartos = new ArrayList<>();
	 }
	 public long calcularDuracao() {
	     return ChronoUnit.DAYS.between(checkIn, checkOut);
	 }

	 public void detalhesReserva() {
	     System.out.println("Check-in: " + checkIn);
	     System.out.println("Check-out: " + checkOut);
	     System.out.println("Duração da estadia: " + calcularDuracao() + " dias");
	}
	
	
	 
	@Override
	public String toString() {
		int cont = 1;
		StringBuilder listaQuartos = new StringBuilder();
	    for (Quarto quarto : listaDeQuartos) {
	    	listaQuartos.append(cont+"° ").append(quarto.toString1()).append("\n\n"); 
	    	cont++;
	    }
		return "Reserva\n\n\n Cliente: " + cliente.getNome() + "\n Check-In: " + checkIn + "\n Check-Out: " + checkOut + "\n Duração da estadia: " + calcularDuracao() + " dias \n Lista de Quartos: \n\n" + listaQuartos;
	}
	
	public Hospede getCliente() {
		return cliente;
	}
	public void setCliente(Hospede cliente) {
		this.cliente = cliente;
	}
	public LocalDate getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}
	public LocalDate getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}
	public List<Quarto> getListaDeQuartos() {
		return listaDeQuartos;
	}
	public void setListaDeQuartos(List<Quarto> listaDeQuartos) {
		this.listaDeQuartos = listaDeQuartos;
	}
	
}
