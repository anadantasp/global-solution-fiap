package devzilla;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) throws IOException, ParseException {
		Scanner scn = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		
		Carro carro01 = new Carro(1, "1234A-10", "Jeep", "Butantã");
		Carro carro02 = new Carro(2, "1234A-10", "Jeep", "Pinheiros");
		Carro carro03 = new Carro(3, "1234A-10", "Jeep", "Sumaré");
		Carro carro04 = new Carro(4, "1234A-10", "Jeep", "Barra_Funda");
		Carro carro05 = new Carro(5, "1234A-10", "Jeep", "Jardins");
		Carro carro06 = new Carro(6, "1234A-10", "Jeep", "Bela_Vista");
		Carro carro07 = new Carro(7, "1234A-10", "Jeep", "Paraíso");
		Carro carro08 = new Carro(8, "1234A-10", "Jeep", "Aclimação");
		Carro carro09 = new Carro(9, "1234A-10", "Jeep", "Vila_Mariana");
		Carro carro10 = new Carro(10, "1234A-10", "Jeep", "Itaim_Bibi");
		Carro carro11 = new Carro(11, "1234A-10", "Jeep", "Vila_Nova_Conceição");
		Carro carro12 = new Carro(12, "1234A-10", "Jeep", "Moema");
		Carro carro13 = new Carro(13, "1234A-10", "Jeep", "Campo_Belo");
		Carro carro14 = new Carro(14, "1234A-10", "Jeep", "Brooklin");
		Carro carro15 = new Carro(15, "1234A-10", "Jeep", "Chácara_Santo_Antônio");
		Carro carro16 = new Carro(16, "1234A-10", "Jeep", "Butantã");
		Carro carro17 = new Carro(17, "1234A-10", "Jeep", "Pinheiros");
		Carro carro18 = new Carro(18, "1234A-10", "Jeep", "Paraíso");
		Carro carro19 = new Carro(19, "1234A-10", "Jeep", "Aclimação");
		Carro carro20 = new Carro(20, "1234A-10", "Jeep", "Moema");
		
		ArrayList<Carro> carros = new ArrayList<>();
		
		carros.add(carro01);
		carros.add(carro02);
		carros.add(carro03);
		carros.add(carro04);
		carros.add(carro05);
		carros.add(carro06);
		carros.add(carro07);
		carros.add(carro08);
		carros.add(carro09);
		carros.add(carro10);
		carros.add(carro11);
		carros.add(carro12);
		carros.add(carro13);
		carros.add(carro14);
		carros.add(carro15);
		carros.add(carro16);
		carros.add(carro17);
		carros.add(carro18);
		carros.add(carro19);
		carros.add(carro20);
		
		int opcao;
		String email, senha;
		int indexUsuarioLogado;
		Usuario usuarioLogado;
		int indexViagemAtiva;
		char resposta;
		String origem, destino;
		int quant=0;
		int id;
		int indexCarro;
		Carro carro;
		double pagamento;
		int validadeCarteira;
		Viagem viagemAtiva;
		int indexUsuarioExistente;
		
		
		
		do {
			System.out.printf("---------- BEM-VINDO AO SOLAR ----------\n\n");
			System.out.printf("1 - Login\n"
					+ "2 - Cadastro\n"
					+ "3 - Sair do sistema\n");
			System.out.printf("Informe a opção desejada: ");
			opcao = scn.nextInt();
			
			while(opcao != 1 && opcao != 2 && opcao != 3) {
				System.out.printf("Opção inválida! Digite novamente: ");
				opcao = scn.nextInt();
			}
			
			if(opcao == 1) { //LOGIN
				System.out.printf("\n---------- LOGIN ----------\n\n");
				System.out.printf("E-mail: ");
				email = scn.next();
				System.out.printf("Senha: ");
				senha = scn.next();
				
				indexUsuarioLogado = -1;
				for (Usuario u : usuarios) {
					if ((u.getEmail().equals(email)) && (u.getSenha().equals(senha))) {
						System.out.printf("\nUsuário logado com sucesso!\n\n");
						indexUsuarioLogado = usuarios.indexOf(u);
						break;
					}
				}
				
				if(indexUsuarioLogado != -1) {//USUÁRIO VÁLIDO
					usuarioLogado = usuarios.get(indexUsuarioLogado);
					
					do {
						System.out.printf("\n---------- MENU ----------\n\n");
						System.out.printf("1 - Iniciar uma viagem\n"
								+ "2 - Encerrar viagem\n"
								+ "3 - Consultar histórico de viagens\n"
								+ "4 - Sair\n");
						System.out.printf("Informe a opção desejada: ");
						opcao = scn.nextInt();
						
						while(opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4) {
							System.out.printf("Opção inválida! Digite novamente: ");
							opcao = scn.nextInt();
						}
						
						if(opcao == 1) {
							
							indexViagemAtiva = -1;
							for(Viagem v: usuarioLogado.getViagens()) {
								if(v.getStatus()) {
									indexViagemAtiva = usuarioLogado.getViagens().indexOf(v);
									break;
								}
							}
							
							
							
							if(indexViagemAtiva == -1) {
								Date hoje = new Date();
								validadeCarteira = hoje.compareTo(usuarioLogado.getValidadeCnh());
								
								System.out.println(sdf.format(hoje));
								System.out.println(sdf.format(usuarioLogado.getValidadeCnh()));
								System.out.println(validadeCarteira);
								
								if(validadeCarteira == 0 || validadeCarteira == -1) {
									
									Viagem viagem = new Viagem();
									
									if(usuarioLogado.getViagens().size() > 0) {
										viagem.setId(usuarioLogado.getViagens().get(usuarioLogado.getViagens().size() - 1).getId() + 1);
									}else {
										viagem.setId(1);
									}
									
									do {
										resposta = 'N';
										System.out.println("Digite o bairro do local de origem: ");
										origem = scn.next();
										
										if(viagem.validarLocal(origem)) {
											viagem.setOrigem(origem);
										}else {
											System.out.printf("Infelizmente ainda não chegamos nessa região!\n");
											System.out.printf("Confira as região disponíveis: ");
											viagem.imprimirLocais();
											System.out.printf("\n\nGostaria de selecionar uma nova região?(S/N)");
											resposta = scn.next().toUpperCase().charAt(0);

											while (resposta != 'S' && resposta != 'N') {
												System.out.printf("Utilizar padrão S/N!\n");
												System.out.printf("Digite novamente: ");
												resposta = scn.next().toUpperCase().charAt(0);
											}
										}
									}while(resposta == 'S');
									
									if(viagem.getOrigem() == null) {
										break;
									}
									
									
									do {
										resposta = 'N';
										System.out.println("Digite o bairro do local de destino: ");
										destino = scn.next();
										
										if(viagem.validarLocal(destino)) {
											viagem.setDestino(destino);
										}else {
											System.out.printf("Infelizmente ainda não chegamos nessa região!\n");
											System.out.printf("Confira as região disponíveis: ");
											viagem.imprimirLocais();
											System.out.printf("\n\nGostaria de selecionar uma nova região?(S/N)");
											resposta = scn.next().toUpperCase().charAt(0);

											while (resposta != 'S' && resposta != 'N') {
												System.out.printf("Utilizar padrão S/N!\n");
												System.out.printf("Digite novamente: ");
												resposta = scn.next().toUpperCase().charAt(0);
											}
										}
									}while(resposta == 'S');
									
									if(viagem.getDestino() == null) {
										break;
									}
									
									for(Carro c: carros) {
										if(c.getLocal().equals(origem) && c.getDisponibilidade() == true) {
											quant++;
										}
									}
									
									if(quant > 0) {
										for(Carro c: carros) {
											if(c.getLocal().equals(origem) && c.getDisponibilidade() == true) {
												c.imprimirCarro();
											}
										}
										
										System.out.printf("\nInforme o ID da carro que deseja utilizar: ");
										id = scn.nextInt();

										indexCarro = -1;
										for (Carro c : carros) {
											if (c.getId() == id && c.getLocal().equals(origem)) {
												indexCarro = carros.indexOf(c);
											}
										}
										
										if(indexCarro != -1) {
											carro = carros.get(indexCarro);
											
											
											viagem.setCarro(carro);
											
											System.out.printf("Carro reservado com sucesso! Finalize o pagamento!\n\n");
										}else {
											System.out.printf("Carro não encontrado\n\n");
											break;
										}
									}else {
										System.out.printf("Não existe carros disponíveis na região!\n\n");
										break;
									}
									
									viagem.setData(new Date());
									
									viagem.calculoPreco(origem, destino);
									
									System.out.printf("O valor da viagem ficou R$ %.2f\nGostaria de continuar?", viagem.getPreco());
									resposta = scn.next().toUpperCase().charAt(0);

									while (resposta != 'S' && resposta != 'N') {
										System.out.printf("Utilizar padrão S/N!\n");
										System.out.printf("Digite novamente: ");
										resposta = scn.next().toUpperCase().charAt(0);
									}
									
									if(resposta == 'S') {
										System.out.print("Digite o valor do pagamento: ");
										pagamento = scn.nextDouble();
										
										if(viagem.pagar(pagamento)) {
											System.out.println("Pagamento realizado com sucesso! Boa viagem!");
											carro.setDisponibilidade(false);
											viagem.setStatus(true);
											
											usuarioLogado.addViagem(viagem);
										}
										else {
											System.out.println("Pagamento não autorizado! Tente novamente mais tarde!");
										}
									}else {
										break;
									}
								}else {
									System.out.println("Sua carteira está vencida :( Regularize a sua situação"
											+ " para continuar fazendo viagens conosco! Te vemos em breve!");
								}
							}else {
								System.out.printf("Você possui uma viagem ativa no momento. Encerra para iniciar uma nova!\n\n");
							}
							
							
							System.in.read();
						}else if(opcao == 2) {
							indexViagemAtiva = -1;
							for(Viagem v: usuarioLogado.getViagens()) {
								if(v.getStatus()) {
									indexViagemAtiva = usuarioLogado.getViagens().indexOf(v);
								}
							}
							
							if(indexViagemAtiva != -1) {
								viagemAtiva = usuarioLogado.getViagens().get(indexViagemAtiva);
								
								System.out.printf("Você possui a seguinte viagem ativa: \n");
								viagemAtiva.imprimirViagem();
								
								System.out.printf("\nGostaria de encerrar a viagem(S/N)?");
								resposta = scn.next().toUpperCase().charAt(0);

								while (resposta != 'S' && resposta != 'N') {
									System.out.printf("Utilizar padrão S/N!\n");
									System.out.printf("Digite novamente: ");
									resposta = scn.next().toUpperCase().charAt(0);
								}
								
								if(resposta == 'S') {
									viagemAtiva.getCarro().setLocal(viagemAtiva.getDestino());
									viagemAtiva.getCarro().setDisponibilidade(true);
									viagemAtiva.setStatus(false);
									
									System.out.printf("Viagem encerrada com sucesso!\n\n");
								}
							}else {
								System.out.printf("Você não possui viagem ativas! Que tal fazer uma agora? ;)\n\n");
							}
							
							System.in.read();
						}else if(opcao == 3) {
							if(usuarioLogado.getViagens().size() > 0) {
								usuarioLogado.imprimirViagens();
							}else {
								System.out.println("Você ainda não realizou uma viagem! Que tal agora? ;)");
							}
						}
						
					}while(opcao <= 3);
					opcao = 0;
				}else {
					System.out.printf("\nUsuário inválido!\n\n");
				}
				
				System.in.read();
			}else if(opcao == 2) { //CADASTRO USUÁRIO
				Usuario usuario = new Usuario();
				
				if(usuarios.size() > 0) {
					usuario.setId(usuarios.get(usuarios.size() - 1).getId() + 1);
				}else {
					usuario.setId(1);
				}
				
				System.out.printf("\n---------- CADASTRO ----------\n\n");
				System.out.printf("Digite seu nome: ");
				usuario.setNome(scn.next());
				System.out.printf("Digite seu CPF: ");
				usuario.setCpf(scn.next());
				System.out.printf("Digite sua data de nascimento(DD/MM/YYYY): ");
				usuario.setDtNascimento(sdf.parse(scn.next()));
				System.out.printf("Digite o seu e-mail: ");
				email = scn.next();
				
				indexUsuarioExistente = -1;
				for(Usuario u: usuarios) {
					if(u.getEmail().equals(email)) {
						indexUsuarioExistente = usuarios.indexOf(u);
					}
				}
				
				if(indexUsuarioExistente != -1) {
					System.out.println("E-mail já cadastrado no sistema!\n\n");
				}else {
					usuario.setEmail(email);
					System.out.printf("Digite o sua senha: ");
					usuario.setSenha(scn.next());
					System.out.printf("Digite o número da sua CNH: ");
					usuario.setNumeroCnh(scn.next());
					System.out.printf("Digite a validade da sua CNH: ");
					usuario.setValidadeCnh(sdf.parse(scn.next()));
					System.out.printf("Anexo da sua CNH: ");
					usuario.setCnh(scn.next());
					
					usuarios.add(usuario);
					
					System.out.println("\nUsuário cadastrado com sucesso!\n\n");
					
					System.out.println(sdf.format(usuario.getDtNascimento()));
					System.out.println(sdf.format(usuario.getValidadeCnh()));
				}
				
				System.in.read();
			}
			
		}while(opcao<=2);

	}

}
