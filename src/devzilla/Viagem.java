package devzilla;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Viagem {
	private int id;
	private String origem;
	private String destino;
	private Date data;
	private double preco;
	private Carro carro;
	private boolean status;
	
	String [] bairros = {"Butantã", "Pinheiros", "Sumaré", "Barra_Funda", "Jardins", "Bela_Vista", "Paraíso", 
			"Aclimação", "Vila_Mariana", "Itaim_Bibi", "Vila_Nova_Conceição", "Moema", "Campo_Belo", 
			"Brooklin", "Chácara_Santo_Antônio"};
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Viagem() {
		
	}

	public Viagem(int id, String origem, String destino, Date data, double preco, Carro carro, boolean status) {
		this.id = id;
		this.origem = origem;
		this.destino = destino;
		this.data = data;
		this.preco = preco;
		this.carro = carro;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean validarLocal(String local) {
		boolean valido = false;
		
		for(String bairro: bairros) {
			if(bairro.equals(local)) {
				valido = true;
				break;
			}
		}
		
		return valido;
	}
	
	public void imprimirLocais() {
		for(String bairro: bairros) {
			System.out.printf(bairro + " | ");
		}
	}
	
	public double calculoPreco(String origem, String destino) {
		
		this.preco = 0.00;
		
		if(validarLocal(this.origem) && validarLocal(this.destino)) {
			Random random = new Random();
			this.preco = random.nextDouble(101);
		}
		
		return Math.round(this.preco * 100.0)/100.0;
	}
	
	public boolean pagar(Double pagamento) {
		boolean pago = false;
		
		this.preco = Math.round(this.preco * 100.0)/100.0;
		
		if(pagamento > this.preco || pagamento == this.preco) {
			pago = true;
		}
		
		return pago;
	}
	
	public void imprimirViagem() {
		System.out.printf("\n------------------------------------------------------------\n\n");
		System.out.printf("ID: " + this.getId() + "\t\t\t\tData: " + sdf.format(this.getData())
				+ "\n\nOrigem: " + this.getOrigem()
				+ "\nDestino: " + this.getDestino()
				+ "\n\nPreço: " + this.getPreco()
				+ "\n\nCarro: \n"
				+ "Modelo: " + this.getCarro().getModelo() + "\t\tPlaca: " + this.getCarro().getPlaca());
		System.out.printf("\n------------------------------------------------------------\n\n");
	}
	
}


