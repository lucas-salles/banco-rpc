package com.lucassales.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {
	List<Conta> contas = new ArrayList<>();

    public BancoServiceServer() throws RemoteException {
        contas.add(new Conta("1", 100.0));
        contas.add(new Conta("2", 156.0));
        contas.add(new Conta("3", 950.0));
    }

    @Override
    public double saldo(String numero) throws RemoteException {
        return contas.stream()
        		.filter(conta -> conta.getNumero().equals(numero))
        		.findFirst()
        		.orElse(null)
        		.getSaldo();
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }

	@Override
	public void adicionarConta(String numero, Double saldo) throws RemoteException {
		contas.add(new Conta(numero, saldo));
	}
	
	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
}
