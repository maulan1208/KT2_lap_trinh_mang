package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import client.InterfaceClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public interface InterfaceServer extends Remote{    
    //gửi tin nhắn
    void broadcastMessage1571020150(String message,List<String> list) throws RemoteException;
    
    //chia sẻ file
    void broadcastMessage1571020150(ArrayList<Integer> inc,List<String> list,String filename) throws RemoteException;
    
    Vector<String> getListClientByName1571020150(String name) throws RemoteException;
    
    void addClient1571020150(InterfaceClient client) throws RemoteException;
    
    void blockClient1571020150(List<String> clients) throws RemoteException;
    
    void removeClient1571020150(List<String> clients) throws RemoteException;
    
    void removeClient1571020150(String clients) throws RemoteException;
    
    void reactiveClient1571020150(List<String> clients) throws RemoteException;
    
    boolean checkUsername1571020150(String username) throws RemoteException;
}