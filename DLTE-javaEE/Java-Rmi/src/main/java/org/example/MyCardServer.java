package org.example;

import application.db.Middlewares.DatabaseTarget;
import application.db.Remotes.StorageTarget;
import application.db.Services.UserInfoServices;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class MyCardServer extends UnicastRemoteObject implements MyCardFunctions, Serializable {

    private static Context context;
    private Registry registry;

    private UserInfoServices services;


    @Override
    public List<List> fetchOverLimit() throws RemoteException {
       // List<CreditCard> cards = services.callFindAll().stream().filter(each->each.getCardUsage()>=each.getCardLimit()*0.800).collect(Collectors.toList());;
        List<List> transactionArrayList=new ArrayList<>();
        transactionArrayList= (ArrayList<List>) services.callFindAll();
        List<String> returned=new ArrayList<>();
//        for(CreditCard creditCard:cards){
//            returned.add(creditCard.getCardHolder());
//        }
        return transactionArrayList;
    }

    public MyCardServer() throws RemoteException {
        super();
      //  services=new CreditCardServices(new DatabaseTarget());
        StorageTarget storageTarget = new DatabaseTarget();
         services = new UserInfoServices(storageTarget);
        try {
            registry= LocateRegistry.createRegistry(3030);
            Hashtable properties=new Hashtable();
            properties.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.rmi.registry.RegistryContextFactory");
            properties.put(Context.PROVIDER_URL,"rmi://localhost:3030");
            context=new InitialContext(properties);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws NamingException, RemoteException {
        MyCardServer myCardServer=new MyCardServer();
        context.bind("java:/card-filter",myCardServer);
    }
}