package com.lucassales.rpc.banco;

import java.net.MalformedURLException;
import java.nio.channels.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AppBanco {
	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {

        // Cria uma inst�ncia do servi�o com.gugawag.rpc.banco.BancoServiceServer...
        BancoServiceIF bancoService = new BancoServiceServer();

        // instanciando o registro
        Registry registry = LocateRegistry.createRegistry(1099);

        // liga (bind) o servi�o ao RMI Registry
        registry.rebind("BancoService", bancoService);

        System.out.println("Service de banco registrado ....");
    }
}
