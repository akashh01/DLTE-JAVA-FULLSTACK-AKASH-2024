package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MyCardFunctions extends Remote {
    List<List> fetchOverLimit()throws RemoteException;
}