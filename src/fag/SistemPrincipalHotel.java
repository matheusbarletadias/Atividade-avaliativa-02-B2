package fag;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SistemPrincipalHotel {
	static Hotel hotel = new Hotel();
	static Scanner sc = new Scanner(System.in);
	public static void fluxoHotel() {
		int i;
		do {
			System.out.println("\n Digite o número da opção desejada: ");
	    	System.out.println("1- Gerenciamento do Hotel");
	    	System.out.println("2- Gerenciar Reservas");
	    	System.out.println("3- Histórico de Reservas");
	    	System.out.println("4- Sair");
	    	i = sc.nextInt();
	    	
	    	if(i==1) {
	    		limparConsole();
	    		int y = 0,j=0;
				do {
					System.out.println("\n Digite o número da opção desejada: ");
			    	System.out.println("1- Gerenciar Hospede");
			    	System.out.println("2- Gerenciar Quarto");
			    	System.out.println("3 <-- Voltar");
			    	j = sc.nextInt();
			    	
			    	if(j==1) {
			    		y=0;
			    		limparConsole();
			    		do {
							System.out.println("\n Digite o número da opção desejada: ");
					    	System.out.println("1- Listar Hospede");
					    	System.out.println("2- Adicionar Hospede");
					    	System.out.println("3- Editar Hospede");
					    	System.out.println("4- Remover Hospede");
					    	System.out.println("5 <-- Voltar");
					    	y = sc.nextInt();
					    	
					    	if(y==1) {
					    		limparConsole();
					    		Hotel.listarHospedes();
					    	}else if(y==2) {
					    		limparConsole();
					    		Hotel.cadastrarHospedes();
					    	}else if(y==3) {
					    		limparConsole();
					    		System.out.println("-> Digite o nome do hospede que deseja editar <-");
						    	String nome = sc.nextLine();
					    		Hotel.editarHospede(nome);
					    	}else if(y==4) {
					    		limparConsole();
					    		sc.nextLine();
					    		System.out.println("-> Digite o nome do hospede que deseja remover <-");
						    	String nome = sc.nextLine();
						    	Hotel.removerHospede(nome);
					    	}
					    	
			    		}while(y!=5);
			    		limparConsole();
			    	}else if(j==2) {
			    		y=0;
			    		limparConsole();
			    		do {
							System.out.println("\n Digite o número da opção desejada: ");
					    	System.out.println("1- Listar Quarto");
					    	System.out.println("2- Adicionar Quarto");
					    	System.out.println("3- Editar Quarto");
					    	System.out.println("4- Remover Quarto");
					    	System.out.println("5 <-- Voltar");
					    	y = sc.nextInt();
					    	
					    	if(y==1) {
					    		limparConsole();
					    		Hotel.listarQuartos();
					    	}else if(y==2) {
					    		limparConsole();
					    		Hotel.cadastrarQuarto();
					    	}else if(y==3) {
					    		limparConsole();
					    		System.out.println("-> Digite o numero do Quarto que deseja editar <-");
						    	int numero = sc.nextInt();
						    	Hotel.editarQuarto(numero);
					    	}else if(y==4) {
					    		limparConsole();
					    		sc.nextLine();
					    		System.out.println("-> Digite o numero do Quarto que deseja remover <-");
						    	int numero = sc.nextInt();
						    	Hotel.removerQuarto(numero);
					    	}
					    	
			    		}while(y!=5);
			    		limparConsole();
			    	}
	    		}while(j!=3);
				limparConsole();
	    	} else if(i==2) {
		    	int y = 0;
	    		limparConsole();
	    		do {
	    			System.out.println("1- Verificar Reservas");
	    			System.out.println("2- Realizar uma nova Reserva");
			    	System.out.println("3- Finalizar Reserva");
			    	System.out.println("4 <-- Voltar");
			    	y = sc.nextInt();
			    	
			    	if(y==1) {
			    		limparConsole();
			    		Hotel.listarReservas();					    		
			    	}else if(y==2) {
			    		limparConsole();
			    		System.out.println("Reserva Inciada");
			    		Hotel.gerarReserva();
			    	}else if(y==3) {
			    		limparConsole();
			    		Hotel.listarReservas();
			    		System.out.println("-> Qual hospede você deseja finalizar a reserva? <-");
				    	String nome = sc.next();
				    	Hotel.removerReserva(nome);				    	
			    	}
			    	
	    		}while(y!=4);
	    		limparConsole();
	    	}else if(i==3) {
	    		Hotel.listarReservasConcluidas();
	    	}
	    	
		}while(i!=4);    	
    	limparConsole();
    	System.out.println("SISTEMA ENCERRADO!");
    	sc.close();
	}
	
	
	
	public static void limparConsole() {
	    for (int i = 0; i < 50; i++) {
	        System.out.println();
	    }
	}
	
	public static void main(String[] args) {
		fluxoHotel();
	}
}
