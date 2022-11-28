package devzilla;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Date;

public class Usuario {
	private int id;
	private String nome;
	private String cpf;
	private Date dtNascimento;
	private String email;
	private String senha;
	private String numeroCnh;
	private Date validadeCnh;
	private String cnh;
	
	private ArrayList<Viagem> viagens = new ArrayList<>();
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Usuario() {
		
	}

	public Usuario(int id, String nome, String cpf, Date dtNascimento, String email, String senha, String numeroCnh,
			Date validadeCnh, String cnh) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
		this.email = email;
		this.senha = senha;
		this.numeroCnh = numeroCnh;
		this.validadeCnh = validadeCnh;
		this.cnh = cnh;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNumeroCnh() {
		return numeroCnh;
	}

	public void setNumeroCnh(String numeroCnh) {
		this.numeroCnh = numeroCnh;
	}

	public Date getValidadeCnh() {
		return validadeCnh;
	}

	public void setValidadeCnh(Date validadeCnh) {
		this.validadeCnh = validadeCnh;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public ArrayList<Viagem> getViagens() {
		return viagens;
	}

	public void addViagem(Viagem viagem) {
		this.viagens.add(viagem);
	}
	
	public void imprimirViagens() {
		System.out.printf("------------------------------ VIAGENS ------------------------------\n");
		for(Viagem viagem: this.viagens) {
			System.out.printf("\n------------------------------------------------------------\n\n");
			System.out.printf("ID: " + viagem.getId() + "\t\t\t\tData: " + sdf.format(viagem.getData())
					+ "\n\nOrigem: " + viagem.getOrigem()
					+ "\nDestino: " + viagem.getDestino()
					+ "\n\nPreço: " + viagem.getPreco()
					+ "\n\nCarro: \n"
					+ "Modelo: " + viagem.getCarro().getModelo() + "\t\tPlaca: " + viagem.getCarro().getPlaca());
			
		}
	}
	
	
	

}
