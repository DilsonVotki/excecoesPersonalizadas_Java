package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;
import model.excecoes.DominioException;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Nº Quarto: ");
			int numeroQuarto = sc.nextInt();
			System.out.print("Entre com a data de Check-In (DD/MM/AAAA): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Entre com a data de Check-Out (DD/MM/AAAA): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
			System.out.println("Reserva " + reserva);
			
			System.out.println();
			System.out.println("Entre com a atualização da Reserva: ");
			System.out.print("Entre com a data de Check-In (DD/MM/AAAA): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Entre com a data de Check-Out (DD/MM/AAAA): ");
			checkOut = sdf.parse(sc.next());
			
			reserva.atualizacaoData(checkIn, checkOut);
			System.out.println("Reserva " + reserva);
		}
		catch(ParseException e) {
			System.out.println("Formato da data invalido!");
		}
		catch(DominioException e) {
			System.out.println("Erro na reverva " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inexperado!");
		}
		
		
		sc.close();

	}

}
