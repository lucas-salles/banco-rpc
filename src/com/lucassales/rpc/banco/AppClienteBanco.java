package com.lucassales.rpc.banco;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class AppClienteBanco {
	public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        // procura o servi�o no RMI Registry local. Perceba que o cliente n�o connhece a implementa��o do servidor,
        // apenas a interface
        Registry registry = LocateRegistry.getRegistry();
        BancoServiceIF banco = (BancoServiceIF) registry.lookup("BancoService");

        menu();
        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();

        while(opcao != 9) {
            switch (opcao) {
                case 1: {
                    System.out.println("Digite o n�mero da conta:");
                    String conta = entrada.next();
                    //chamada ao m�todo remoto, como se fosse executar localmente
                    System.out.println(banco.saldo(conta));
                    break;
                }
                case 2: {
                    //chamada ao m�todo remoto, como se fosse executar localmente
                    System.out.println(banco.quantidadeContas());
                    break;
                }
                case 3: {
                	System.out.println("Digite o n�mero da conta:");
                	String numero = entrada.next();
                	System.out.println("Digite o saldo da conta:");
                	Double saldo = entrada.nextDouble();
                	banco.adicionarConta(numero, saldo);
                	System.out.println("Conta adicionada com sucesso");
                	break;
                }
            }
            menu();
            opcao = entrada.nextInt();
        }
    }

    public static void menu() {
        System.out.println("\n=== LUCAS SILVA - BANCO RMI (ou FMI?!) ===");
        System.out.println("1 - Saldo da conta");
        System.out.println("2 - Quantidade de contas");
        System.out.println("3 - Adicionar conta");
        System.out.println("9 - Sair");
    }
}
