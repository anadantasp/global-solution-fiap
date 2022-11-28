package devzilla;

public class Carro {
	private int id;
	private String placa;
	private String modelo;
	private String local;
	private boolean disponibilidade;
	
	public Carro() {
		
	}
	
	public Carro(int id, String placa, String modelo, String local) {
		this.id = id;
		this.placa = placa;
		this.modelo = modelo;
		this.local = local;
		this.disponibilidade = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public boolean getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	public void imprimirCarro() {
		System.out.printf("\nID: " + this.id + "\tModelo: " + this.modelo + "\tPlaca: " + this.placa + "\tDisponível: "+ this.disponibilidade);
	}
	
	

}
