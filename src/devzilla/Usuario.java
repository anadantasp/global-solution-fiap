package devzilla;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;

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
	private String fotoPerfil;
	
	private ArrayList<Viagem> viagens = new ArrayList<>();
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Usuario() {
		
	}

	public Usuario(int id, String nome, String cpf, Date dtNascimento, String email, String senha, String numeroCnh,
			Date validadeCnh, String cnh, String fotoPerfil) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
		this.email = email;
		this.senha = senha;
		this.numeroCnh = numeroCnh;
		this.validadeCnh = validadeCnh;
		this.cnh = cnh;
		this.fotoPerfil = fotoPerfil;
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
	
	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
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
			System.out.printf("\n\n------------------------------------------------------------\n\n");
			System.out.printf("ID: " + viagem.getId() + "\t\t\t\tData: " + sdf.format(viagem.getData())
					+ "\n\nOrigem: " + viagem.getOrigem()
					+ "\nDestino: " + viagem.getDestino()
					+ "\n\nPreço: " + viagem.getPreco()
					+ "\n\nCarro: \n"
					+ "Modelo: " + viagem.getCarro().getModelo() + "\t\tPlaca: " + viagem.getCarro().getPlaca());
		}
	}
	
	public void imprimirUsuario() {
		System.out.println("\nNome: " + this.nome + "\nCPF: " + imprimiCPF(this.cpf) + "\nData de nascimento: " + sdf.format(this.dtNascimento)
		+ "\nEmail: " + this.email + "\nSenha: " + this.senha + "\nNúmero CNH: " + this.numeroCnh + "\nValidade CNH: " + sdf.format(validadeCnh)
		+ "\nArquivo CNH: " + this.cnh + "\nFoto de perfil: " + this.fotoPerfil);
	}
	
	//VERIFICAÇÕES
	public boolean validaCPF(String cpf) {
		
        if (cpf.equals("00000000000") ||
            cpf.equals("11111111111") ||
            cpf.equals("22222222222") || cpf.equals("33333333333") ||
            cpf.equals("44444444444") || cpf.equals("55555555555") ||
            cpf.equals("66666666666") || cpf.equals("77777777777") ||
            cpf.equals("88888888888") || cpf.equals("99999999999") ||
            (cpf.length() != 11))
            return(false);
        
        char dig10, dig11;
        int soma, i, resto, numero, peso;
        
        try {
            // Calculo do 1º Digito Verificador
                soma = 0;
                peso = 10;
                for (i=0; i<9; i++) {
           
                numero = (int)(cpf.charAt(i) - 48);
                soma = soma + (numero * peso);
                peso = peso - 1;
                }

                resto = 11 - (soma % 11);
                if ((resto == 10) || (resto == 11))
                    dig10 = '0';
                else dig10 = (char)(resto + 48);

            // Calculo do 2º Digito Verificador
                soma = 0;
                peso = 11;
                for(i=0; i<10; i++) {
                numero = (int)(cpf.charAt(i) - 48);
                soma = soma + (numero * peso);
                peso = peso - 1;
                }

                resto = 11 - (soma % 11);
                if ((resto == 10) || (resto == 11))
                     dig11 = '0';
                else dig11 = (char)(resto + 48);

            
                if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
                     return(true);
                else return(false);
                    } catch (InputMismatchException erro) {
                    return(false);
                }
	}
	
	public String imprimiCPF(String cpf) {
		return(cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." +
	            cpf.substring(6, 9) + "-" + cpf.substring(9, 11));
	}
	
	public boolean validaData(String data) {
        try {
            sdf.setLenient(false);
            
            sdf.parse(data);
            
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
	
	public boolean verificaIdade(Date dtNascimento) {
		boolean maiorIdade = false;
		
		Calendar nascimento = Calendar.getInstance();
		Calendar hoje = Calendar.getInstance();
		
		nascimento.setTime(dtNascimento);
		hoje.setTime(new Date());
		
		int nasc_ano = nascimento.get(Calendar.YEAR);
		int ano_atual = hoje.get(Calendar.YEAR);
		
		if((ano_atual - nasc_ano) < 18) {
			maiorIdade = false;
		}else if((ano_atual - nasc_ano) > 18 ) {
			maiorIdade = true;
		}else {
			int nasc_mes = nascimento.get(Calendar.MONTH);
			int mes_atual = hoje.get(Calendar.MONTH);
			
			if(nasc_mes < mes_atual) {
				maiorIdade = true;
			}else if (nasc_mes > mes_atual) {
				maiorIdade = false;
			}else {
				int nasc_dia = nascimento.get(Calendar.DATE);
				int hoje_dia = hoje.get(Calendar.DATE);
				
				if(nasc_dia < hoje_dia || nasc_dia == hoje_dia) {
					maiorIdade = true;
				}else {
					maiorIdade = false;
				}
			}
		}
		
		return maiorIdade;
	}
	
	public boolean dtValidadeCNH(Date dtCNH) {
		boolean validade = false;
		
		Calendar cnhValidade = Calendar.getInstance();
		Calendar hoje = Calendar.getInstance();
		
		cnhValidade.setTime(dtCNH);
		hoje.setTime(new Date());
		
		int cnh_ano = cnhValidade.get(Calendar.YEAR);
		int ano_atual = hoje.get(Calendar.YEAR);
		
		if(ano_atual < cnh_ano) {
			validade = true;
		}else if(ano_atual > cnh_ano) {
			validade = false;
		}else {
			int cnh_mes = cnhValidade.get(Calendar.MONTH);
			int mes_atual = hoje.get(Calendar.MONTH);
			
			if(cnh_mes < mes_atual){
				validade = false;
			}else if(cnh_mes > mes_atual){
				validade = true;
			}else {
				int cnh_dia = cnhValidade.get(Calendar.DATE);
				int hoje_dia = hoje.get(Calendar.DATE);
				
				if(cnh_dia > hoje_dia || cnh_dia == hoje_dia) {
					validade = true;
				}else {
					validade = false;
				}
			}
		}
		
		return validade;
	}
	
	

}
