package client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;


public interface InterfaceClient extends Remote{
    void retrieveMessage1571020150(String message) throws RemoteException;
    
    void retrieveMessage1571020150(String filename,ArrayList<Integer> inc) throws RemoteException;
    
    void sendMessage1571020150(List<String> list) throws RemoteException;
    
    String getName1571020150()throws RemoteException;
    
    void closeChat1571020150(String message) throws RemoteException;
    
    void openChat1571020150() throws RemoteException;
}
