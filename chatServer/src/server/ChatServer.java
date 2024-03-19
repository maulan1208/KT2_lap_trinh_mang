package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import client.InterfaceClient;
import java.util.List;
import java.util.Vector;


public class ChatServer extends UnicastRemoteObject implements InterfaceServer{
    private final ArrayList<InterfaceClient> clients; 
    private final ArrayList<InterfaceClient> blockedClients; 
    
    public ChatServer() throws RemoteException{
        super();
        this.clients = new ArrayList<>();
        blockedClients = new ArrayList<>();
    }
    
    @Override
    public synchronized void broadcastMessage1571020150(String message,List<String> list) throws RemoteException {
        if(list.isEmpty()){
            int i= 0;
            while (i < clients.size()){
                clients.get(i++).retrieveMessage1571020150(message);
            }
        }else{
            for (InterfaceClient client : clients) {
                for(int i=0;i<list.size();i++){
                    if(client.getName1571020150().equals(list.get(i))){
                        client.retrieveMessage1571020150(message);
                    }
                }
            }
        }
    }
    
    @Override
    public synchronized void broadcastMessage1571020150(ArrayList<Integer> inc, List<String> list,String filename) throws RemoteException {
        if(list.isEmpty()){
            int i= 0;
            while (i < clients.size()){
                clients.get(i++).retrieveMessage1571020150(filename,inc);
            }
        }else{
            for (InterfaceClient client : clients) {
                for(int i=0;i<list.size();i++){
                    if(client.getName1571020150().equals(list.get(i))){
                        client.retrieveMessage1571020150(filename,inc);
                    }
                }
            }
        }
    }
        
    @Override
    public synchronized void addClient1571020150(InterfaceClient client) throws RemoteException {
        this.clients.add(client);
    }
    
    @Override
    public synchronized Vector<String> getListClientByName1571020150(String name) throws RemoteException {
        Vector<String> list = new Vector<>();
        for (InterfaceClient client : clients) {
            if(!client.getName1571020150().equals(name)){
                list.add(client.getName1571020150());
            }
        }
        return list;
    }
    
    @Override
    public synchronized void blockClient1571020150(List<String> clients){
        for(int j=0;j<this.clients.size();j++){
            for(int i=0;i<clients.size();i++){
                try {
                    if(this.clients.get(j).getName1571020150().equals(clients.get(i))){
                        this.clients.get(j).closeChat(clients + " you are blocked by admin");
                        blockedClients.add(this.clients.get(j));
                    }
                } catch (RemoteException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        }
    }
    
    @Override
    public synchronized void removeClient1571020150(List<String> clients){
        for(int j=0;j<this.clients.size();j++){
            for(int i=0;i<clients.size();i++){
                try {
                    if(this.clients.get(j).getName1571020150().equals(clients.get(i))){
                        this.clients.get(j).closeChat(clients.get(i) + " you are removed from the chat");
                        this.clients.remove(j);
                    }
                } catch (RemoteException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        }
    }
    
    @Override
    public synchronized void removeClient1571020150(String clients){
        for(int j=0;j<this.clients.size();j++){
            try {
                if(this.clients.get(j).getName1571020150().equals(clients)){
                    this.clients.remove(j);
                }
            } catch (RemoteException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    @Override
    public synchronized void reactiveClient1571020150(List<String> clients) throws RemoteException {
        for(int j=0;j<this.blockedClients.size();j++){
            for(int i=0;i<clients.size();i++){
                try {
                    if(this.blockedClients.get(j).getName1571020150().equals(clients.get(i))){
                        this.blockedClients.get(j).openChat();
                        this.blockedClients.remove(j);
                    }
                } catch (RemoteException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        }
    }
    
    @Override
    public boolean checkUsername1571020150(String username) throws RemoteException {
        boolean exist = false;
        for(int i=0;i<clients.size();i++){
            if(clients.get(i).getName1571020150().equals(username)){
                exist = true;
            }
        }
        for(int i=0;i<blockedClients.size();i++){
            if(blockedClients.get(i).getName1571020150().equals(username)){
                exist = true;
            }
        }
        return exist;
    }
}