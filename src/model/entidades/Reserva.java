package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) {
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duracao() {
		long dif = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	
	public String atualizacaoData (Date checkIn, Date checkOut) {
		
		Date dataAtual = new Date();
		if(checkIn.before(dataAtual) || checkOut.before(dataAtual)) {
			return "Erro na Reserva: As data não podem ser inferiores a hoje!";
		}
		if(!checkOut.after(checkIn)) {
			return "Erro na reserva: Data de entrada deve ser antes da data de Saida";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	
	@Override
	public String toString() {
		return "Quarto nº " 
				+ numeroQuarto
				+ ", checkIn: "
				+ sdf.format(checkIn)
				+ ", checkOut: "
				+ sdf.format(checkOut)
				+ ", "
				+ duracao()
				+ " noites!";
				
	}
}
