package fag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Hotel {
	static Scanner sc = new Scanner(System.in);
	private static List<Quarto> listadeQuartos = new ArrayList<>(); 
	private static List<Hospede> listadeHospedes = new ArrayList<>();
	private static List<Reserva> listadeReservas = new ArrayList<>(); 
	private static List<Reserva> listadeReservasConcluidas = new ArrayList<>(); 
	
	public static void adicionarQuarto(int numero, int tipo, double preco) {
		Quarto quarto = new Quarto(numero, tipo, preco);
		listadeQuartos.add(quarto);
	}
	
	public static void cadastrarQuarto() {
		System.out.print("Quantos quartos deseja cadastrar?");
		    int quantidade = sc.nextInt();
	        System.out.println("\n");
	        sc.nextLine();
	        
	        for (int i = 0; i < quantidade; i++) {
	        	System.out.println("=== Cadastro do Quarto " + (i+1) + " ===");
	        	System.out.print("Digite o numero do quarto: ");
		        int numero = sc.nextInt();
		        Quarto.numQuartoVerificacao(numero);
	        	
		        System.out.print("Escolha o tipo do quarto: \n1- Solteiro \n2-Casal \n3-Suite \n Digite apenas o numero da opção desejada: ");
		        int tipo = sc.nextInt();
		        
		        System.out.print("Digite o valor da diaria: ");
		        double preco = sc.nextDouble();
		        System.out.println("========================= \n");
		        
		        adicionarQuarto(numero, tipo, preco); 
	        }
	}
	
	public static void listarQuartos() {
		System.out.println("\n=== Lista de quartos cadastrados ===");
        int j = 1;
        for (Quarto quarto : listadeQuartos) {
        	System.out.println(j+"- "+quarto.toString()+"\n");
        	
        	j++;
        }
        System.out.println("\n");
	}
	
	public static List<Quarto> buscarQuartos(int numeroBusca){
		List<Quarto> QuartosEncontrados = listadeQuartos.stream()
                .filter(quarto -> quarto.getNumeroQuarto() == numeroBusca)
                .collect(Collectors.toList());	     
		return QuartosEncontrados; 
	} 
	
	public static void removerQuarto(int numeroBusca) {
        List<Quarto> QuartosEncontrados = buscarQuartos(numeroBusca);

        if (!QuartosEncontrados.isEmpty()) {
        	for(Quarto quartoSelecionado : QuartosEncontrados) {
        		int apaga = quartoSelecionado.getNumeroQuarto();
            	Quarto.removeQuartoExistente(apaga);
        	}
        	listadeQuartos.removeAll(QuartosEncontrados);
            System.out.println("Todos os quatos encontradas com o nome digitado foram removidos, seguintes quartos: \n"
            																						+ QuartosEncontrados.toString());
        } else {
            System.out.println("Nenhum quarto encontrado para remoção. \n");
        }
    }
	
	public static void editarQuarto(int numeroBusca) {
	    List<Quarto> QuartosEncontrados = buscarQuartos(numeroBusca);

	    if (!QuartosEncontrados.isEmpty()) {
	        System.out.println("Quartos encontrados: ");
	        for (int i = 0; i < QuartosEncontrados.size(); i++) {
	            System.out.println((i + 1) + ": " + QuartosEncontrados.get(i).toString());
	        }

	        System.out.print("Selecione o número do quarto que deseja editar: ");
	        int escolha = sc.nextInt();
	        sc.nextLine(); 

	        if (escolha > 0 && escolha <= QuartosEncontrados.size()) {
	            Quarto quartoSelecionado = QuartosEncontrados.get(escolha - 1);

	            System.out.print("Digite o novo numero do quarto (ou digite 0 para manter o atual): ");
	            int novoNumero = sc.nextInt();
	            if (novoNumero>0) {
	            	int apaga = quartoSelecionado.getNumeroQuarto();
	            	Quarto.removeQuartoExistente(apaga);
	            	novoNumero = Quarto.numQuartoVerificacao(novoNumero);
	            	quartoSelecionado.setNumeroQuarto(novoNumero);
	            }

	            System.out.print("Digite o novo tipo do quarto: \n1- Solteiro \n2-Casal \n3-Suite \n Digite apenas o numero da opção desejada: (ou digite 0 para manter o atual): ");
	            int novoTipo = sc.nextInt();
	            if (novoTipo>0) {
	            	quartoSelecionado.setTipo(novoTipo);
	            }
	            
	            System.out.print("Digite o preço do quarto: (ou digite 0 para manter o atual): ");
	            int novoPreco = sc.nextInt();
	            if (novoPreco>0) {
	            	quartoSelecionado.setPreco(novoPreco);
	            }
	            
	            System.out.println("Quarto atualizado com sucesso!\n");
	            
	            System.out.println("Novo estado do quarto: " + quartoSelecionado.toString());

	        } else {
	            System.out.println("Escolha inválida.\n");
	        }
	    } else {
	        System.out.println("Nenhum quarto encontrado com o numero "+ numeroBusca +" \n");
	    }
	}
	
	public static void adicionarHospedes(String nome, int cpf) {
		Hospede hospede = new Hospede(nome, cpf);
		listadeHospedes.add(hospede);
	}
	
	public static void cadastrarHospedes() {
		System.out.print("Quantos hospedes deseja cadastrar?");
		    int quantidade = sc.nextInt();
	        System.out.println("\n");
	        sc.nextLine();
	        
	        for (int i = 0; i < quantidade; i++) {
	        	System.out.println("=== Cadastro do Hospede " + (i+1) + " ===");
	        	System.out.print("Digite o nome do hospede: ");
		        String nome = sc.next();
	        	
		        System.out.print("Digite o CPF: ");
		        int cpf = sc.nextInt();
		        
		        System.out.println("========================= \n");
		        
		        adicionarHospedes(nome, cpf);
	        }
	}
	
	public static void listarHospedes() {
		System.out.println("\n=== Lista de Hospedes cadastrados ===");
        int j = 1;
        for (Hospede hospede : listadeHospedes) {
        	System.out.println(j+"- "+hospede.toString()+"\n");
        	
        	j++;
        }
        System.out.println("\n");
	}
	
	public static List<Hospede> buscarHospede(String tituloBusca){
		List<Hospede> hospedesEncontrados = listadeHospedes.stream()
                .filter(hospede -> hospede.getNome().contains(tituloBusca))
                .collect(Collectors.toList());	     
		return hospedesEncontrados; 
	} 
	
	public static void removerHospede(String tituloBusca) {
        List<Hospede> hospedesEncontrados = buscarHospede(tituloBusca);

        if (!hospedesEncontrados.isEmpty()) {
        	for(Hospede hospedeSelecionado : hospedesEncontrados) {
        		int apaga = hospedeSelecionado.getId();
            	Hospede.removeHospedeExistente(apaga);
        	}
        	listadeHospedes.removeAll(hospedesEncontrados);
            System.out.println("Todos os hospedes encontradas com o nome digitado foram removidos, seguintes hospedes: \n"
            																						+ hospedesEncontrados.toString());
        } else {
            System.out.println("Nenhum hospede encontrado para remoção. \n");
        }
    }
	
	public static void editarHospede(String tituloBusca) {
		List<Hospede> hospedesEncontrados = buscarHospede(tituloBusca);

	    if (!hospedesEncontrados.isEmpty()) {
	        System.out.println("Hospedes encontrados: ");
	        for (int i = 0; i < hospedesEncontrados.size(); i++) {
	            System.out.println((i + 1) + ": " + hospedesEncontrados.get(i).toString());
	        }

	        System.out.print("Selecione o número do hospede que deseja editar: ");
	        int escolha = sc.nextInt();
	        sc.nextLine(); 

	        if (escolha > 0 && escolha <= hospedesEncontrados.size()) {
	            Hospede hospedeSelecionado = hospedesEncontrados.get(escolha - 1);

	            System.out.print("Digite o novo nome do hospede (ou digite 0 para manter o atual): ");
	            String novoNome = sc.next();
	            if (!novoNome.contains("0")) {
	            	hospedeSelecionado.setNome(novoNome);
	            }

	            System.out.print("Digite o novo cpf: (ou 0 para manter o mesmo) ");
	            int novoCpf = sc.nextInt();
	            if (novoCpf>0) {
	            	hospedeSelecionado.setCpf(novoCpf);
	            }
	            
	            System.out.println("Hospede atualizado com sucesso!\n");
	            
	            System.out.println("Novo estado do hospede: " + hospedeSelecionado.toString());

	        } else {
	            System.out.println("Escolha inválida.\n");
	        }
	    } else {
	        System.out.println("Nenhum hospede encontrado com o nome "+ tituloBusca +" \n");
	    }
	}
	
	
	public static void gerarReserva(){
		List<Quarto> listaDeQuartosEscolhidos = new ArrayList<>();
		Quarto quartorioEscolhido = new Quarto(0,0,0);
		Hospede hospedeEscolhido = new Hospede(null, 0);
		limparConsole();
		if (!listadeHospedes.isEmpty()) {
			System.out.println("Iniciando uma nova reserva.\n Será feita no nome de qual hospede? \n");
	        System.out.println("Hospedes encontrados: ");
	        listarHospedes();
	        System.out.print("Selecione o número do hospede: ");
		    int escolha = sc.nextInt();
		    sc.nextLine();
		    if (escolha > 0 && escolha <= listadeHospedes.size()) {
		    	hospedeEscolhido = listadeHospedes.get(escolha - 1);
		    }else {
		    	System.out.println("Opção inválida");
		    }
		    limparConsole();
		    int escolhaSair;
		    do {
		    	System.out.println("Qual quarto você irá ficar? \n");
		        System.out.println("Quarto disponiveis: ");
		        System.out.println(toStringQuarto());
		        System.out.print("Selecione o número do quarto que você irá ocupar: ");
			    escolha = sc.nextInt();
			    sc.nextLine();
			    if (escolha > 0 && escolha <= listadeQuartos.size()) {
			    	if(listadeQuartos.get(escolha - 1).isStatus()==true) {
			    		Quarto quartoEscolhido = listadeQuartos.get(escolha - 1);
			    		quartoEscolhido.setStatus(false);
			    		listaDeQuartosEscolhidos.add(quartoEscolhido);			    		
			    	}
			    }else {
			    	System.out.println("Opção inválida");
			    }
			    System.out.println("Deseja adicionar mais um quarto a sua reserva? \n1- Não \n2- Sim");
		    	escolhaSair = sc.nextInt();
		    	
		    }while(escolhaSair==2);		    
		   
		    limparConsole();
		    
		    System.out.println("Qual será a data do seu Check-in? ");
		    System.out.println("Dia:");
		    int diaEntrada = sc.nextInt();
		    System.out.println("Mês:");
		    int mesEntrada = sc.nextInt();
		    System.out.println("Ano:");
		    int anoEntrada = sc.nextInt();
		    
		    System.out.println("Qual será a data do seu Check-out? ");
		    System.out.println("Dia:");
		    int diaSaida = sc.nextInt();
		    System.out.println("Mês:");
		    int mesSaida = sc.nextInt();
		    System.out.println("Ano:");
		    int anoSaida = sc.nextInt();
		    
		    Reserva novaReserva = new Reserva(hospedeEscolhido,LocalDate.of(anoEntrada,mesEntrada,diaEntrada),LocalDate.of(anoSaida,mesSaida,diaSaida));
		    novaReserva.getListaDeQuartos().addAll(listaDeQuartosEscolhidos);
		    
		    listadeReservas.add(novaReserva);
		}
	    		
	}
	public static void listarReservas() {
		System.out.println("\n=== Lista de Reservas cadastradas ===");
        int j = 1;
        for (Reserva reserva : listadeReservas) {
        	System.out.println(j+"- "+reserva.toString()+"\n");
        	
        	j++;
        }
        System.out.println("\n");
	}
	
	
	public static List<Reserva> buscarReserva(String tituloBusca){
		List<Reserva> reservasEncontradas = listadeReservas.stream()
                .filter(reserva -> reserva.getCliente().getNome().contains(tituloBusca))
                .collect(Collectors.toList());	     
		return reservasEncontradas; 
	} 
	
	public static void removerReserva(String tituloBusca) {
        List<Reserva> reservasEncontradas = buscarReserva(tituloBusca);

        if (!reservasEncontradas.isEmpty()) {
        	for(Reserva reservaSelecionada : reservasEncontradas) {
        		for(Quarto quartoSelecionado : reservaSelecionada.getListaDeQuartos()) {
        			quartoSelecionado.setStatus(true);
        		}
        		listadeReservasConcluidas.add(reservaSelecionada);
        	}
        	listadeReservas.removeAll(reservasEncontradas);
            System.out.println("Todos as reserva encontradas no nome de "+reservasEncontradas.get(0).getCliente().getNome()+" foram conclidas, seguinte reserva: \n"
            																						+ reservasEncontradas.toString());
        } else {
            System.out.println("Nenhuma reserva encontrada \n");
        }
    }
	
	public static void listarReservasConcluidas() {
		System.out.println("\n=== Lista de Reservas concluidas ===");
        int j = 1;
        for (Reserva reserva : listadeReservasConcluidas) {
        	System.out.println(j+"- "+reserva.toString()+"\n");
        	
        	j++;
        }
        System.out.println("\n");
	}
	
	
	public static String toStringQuarto() {
		 StringBuilder itensStr = new StringBuilder();
		    int i = 1;
		    for (Quarto quarto : listadeQuartos) {
		    	if(quarto.isStatus()==true) {
		    		itensStr.append("\n\n"+i+"-").append(quarto.toString1()).append("\n");
		    	}	
		        i++;
		    }
		    
		    return itensStr.toString();
		
	}
	
	
	
	
	public static void limparConsole() {
	    for (int i = 0; i < 50; i++) {
	        System.out.println();
	    }
	}
	public static void main(String[] args) {
		
		cadastrarHospedes();
		cadastrarQuarto();
		listarQuartos();
		gerarReserva();
		listarReservas();
		System.out.println("Digite o nome da pessoa que deseja remover a reserva: ");
		String nome = sc.next();
		removerReserva(nome);
		listarReservas();
	}
}
