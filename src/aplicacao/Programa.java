package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAtual = new Date();
		
		System.out.print("N� Quarto: ");
		int numeroQuarto = sc.nextInt();
		System.out.print("Entre com a data de Check-In (DD/MM/AAAA): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Entre com a data de Check-Out (DD/MM/AAAA): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: Data de entrada deve ser antes da data de Saida");
			
		}else {
			Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
			System.out.println("Reserva " + reserva);
			
			System.out.println();
			System.out.println("Entre com a atualiza��o da Reserva: ");
			System.out.print("Entre com a data de Check-In (DD/MM/AAAA): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Entre com a data de Check-Out (DD/MM/AAAA): ");
			checkOut = sdf.parse(sc.next());
			if(checkIn.before(dataAtual) || checkOut.before(dataAtual)) {
				System.out.println("Erro na Reserva: As data n�o podem ser inferiores a hoje!");
			}else if(!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: Data de entrada deve ser antes da data de Saida");
			} else {
				reserva.atualizacaoData(checkIn, checkOut);
				System.out.println("Reserva " + reserva);
			}
		}
		
		
		
		sc.close();

	}

}
