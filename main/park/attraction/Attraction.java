package main.park.attraction;

import main.park.Park;
import main.park.client.Client;
import main.park.client.ClientType;
import main.park.monster.Beast;
import main.park.monster.Kidnapper;
import main.park.monster.NormalBeast;

import java.util.*;

public abstract class Attraction implements Comparable<Attraction>{

    public static Park park;
    private String name;
    private double price;
    private int visitors;
    private AttractionType attractionType;
    private Queue<Client> clientQueue = new LinkedList<>();
    private List<Client> clientsVisitedTheAttraction = new ArrayList<>();
    private List<ClientType> possibleTypeOfClients = new ArrayList<>(); // TODO i need to set that the different type
                                                                        //of attractions can be visited from different
                                                                        // type of clients. That will be done with
                                                                        //template method and an abstract, who will be overriden from the two types of attracrtions. Extreme will set that can be
                                                                        //used from Adults and Pensioners
    private Beast beast;
    //TODO
//    private NormalBeast normalBeast;
//    private Kidnapper kidnapper;
    private Map<Beast, Integer> priceList; // TODO BeastType - price for the attraction

    public Attraction(String name, int price, Beast beast, AttractionType attractionType) {
        this.name = name;
        this.price = price;
        if (validBeast(beast)){
            this.beast = beast;
            beast.setAttraction(this);
            park.addBeast(beast);
        }else{
            System.out.println("Invalid beast.");
        }
        this.attractionType = attractionType;
//        if (validClient(clientType)){
//            this.possibleTypeOfClients.add(clientType);
//        }
        park.addAttraction(this);
        park.addToPriceList(this);
        //TODO
    }
    public abstract boolean checkIfPossibleToVisit(Client client);

    protected abstract boolean validClient(ClientType clientType);

    protected abstract boolean validBeast(Beast beast);

    public static Park getPark() {
        return park;
    }

    @Override
    public int compareTo(Attraction o) {
        return this.name.compareTo(o.name);
    }

    public String getName() {
        return name;
    }
    public void visit(Client client){
        if (checkIfPossibleToVisit(client)) {
            this.clientQueue.offer(client);
            this.clientsVisitedTheAttraction.add(client);
            client.pay(this.getPrice());
            this.visitors++;
            beast.beastAct(client);
        }else {
            System.out.println("Sorry, but you cannot visit this attraction.");
        }
       // this.kidnapper.beastAct(client);
    }

    public double getPrice() {
        return price;
    }

    public int getVisitors() {
        return visitors;
    }

    public Beast getBeast() {
        return beast;
    }

    public AttractionType getAttractionType() {
        return attractionType;
    }
    public void goInQueue(Client client, Attraction attraction){
        this.clientQueue.offer(client);
    }

    public List<Client> getClientsVisitedTheAttraction() {
        return Collections.unmodifiableList(clientsVisitedTheAttraction);
    }
}
