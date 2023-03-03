package main.park;

import main.park.attraction.Attraction;
import main.park.attraction.AttractionType;
import main.park.client.Client;
import main.park.client.ClientType;
import main.park.monster.Beast;
import main.park.monster.BeastType;

import java.util.*;

public class Park {
    //TODO set this park to the Attractions, Clients,

    private String name;
    private String address;
    private double money = 0;
    private List<Attraction> attractions = new ArrayList<>();
    private List<Client> kidnappedClients = new ArrayList<>();
    private Set<Client> clients = new HashSet<>();
    private Map<String, Double> priceList = new TreeMap<>();
    private Map<BeastType,Map<Beast, Integer>> beastsByEarnedMoney = new TreeMap<>();
    private int kids;
    private int stolenSouls;
    private Set<Beast> beasts = new TreeSet<>();
    private Map<String, Integer> numVisitedAttractions = new TreeMap<>();

    public Park(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public void addAttraction(Attraction attraction){
        this.attractions.add(attraction);
    }
    public void addBeast(Beast beast){
        this.beasts.add(beast);
    }

    public void kidnapClient(Client client){
        this.kidnappedClients.add(client);
        for(Iterator<Client> it = this.clients.iterator(); it.hasNext();){
            Client c = it.next();
            if (c.equals(client)){
                it.remove();
            }
        }
    }
    public void receiveMoney(double money){
        this.money += money;
    }
    public void increaseKids(){
        this.kids++;
    }
    public void increaseStolenSouls(){
        this.stolenSouls++;
    }
    public void increaseVisitedAttraction(Attraction attraction){
        if (!numVisitedAttractions.containsKey(attraction.getName())){
            numVisitedAttractions.put(attraction.getName(),0);
        }
        numVisitedAttractions.put(attraction.getName(), +1);
    }
    public void addToPriceList(Attraction attraction){
        if (!this.priceList.containsKey(attraction.getName())){
            this.priceList.put(attraction.getName(),attraction.getPrice());
        }
    }

    public List<Attraction> getAttractions() {
        return Collections.unmodifiableList(attractions);
    }
    public void printStats(){
        stat1();
        stat2();
        stat3();
        stat4();
        stat5();
        stat6();
        stat8();
        stat9();
        stat10();
        stat11();
        stat12();
    }

    private void stat11() {

    }

    private void stat10() {
        int totalAge = 0;
        int numOfClients = 1;
        for (Beast b : beasts){
            if (b.getBeastType() == BeastType.MERMAID){
                for (int i = 0; i < b.getKidnappedClients().size(); i++) {
                    totalAge += b.getKidnappedClients().get(i).getAge();
                    numOfClients++;
                }
            }
        }
        System.out.println("Average age of the clients who were kidnapped from the mermaid: " + totalAge / numOfClients);
    }

    private void stat8() {
        System.out.println("Names of the pensioners who were fired from the dragon: ");
        for (Beast b : beasts){
            if (b.getBeastType() == BeastType.DRACON){
                for (int i = 0; i < b.getKidnappedClients().size(); i++) {
                    if (b.getKidnappedClients().get(i).getClientType() == ClientType.PENSIONER) {
                        System.out.println(b.getKidnappedClients().get(i).getName());
                    }
                }
            }
        }
    }

    private void stat12() {
        int visitors = 0;
        for (Attraction a : attractions){
            if (a.getAttractionType() == AttractionType.EXTREME) {
                visitors += a.getClientsVisitedTheAttraction().size();
            }
        }
        System.out.println("The ratio of risk is: " + ((double)kidnappedClients.size() / visitors * 100) +"%");
    }

    private void stat9() {
        this.beasts.stream()
                .filter(b -> b.getBeastType() == BeastType.DRACON)
                .sorted((o1, o2) -> o2.getKidnappedClients().size() - o1.getKidnappedClients().size())
                .limit(1)
                .forEach(b -> System.out.println("The most deadly gragon: " + b.getName()));
    }

//    private void stat8() {
//        List<Client> list = this.beasts.stream()
//                .filter(b -> b.getBeastType() == BeastType.MERMAID)
//                .map(b -> b.getKidnappedClients())
//                .collect(Collectors.toList());
//
//    }

    private void stat6() {
        //using stream will filter all of the clients above 65 who are fired from the dracon and the using collect
        //will collect them in a Collection and will print their names.

    }

    private void stat5() {
        //all of the Clients with stolen souls from the devil will be added in a List and then using stream
        //with filter will be filtered only clients with Gender Female and the with another filter will be
        //filtered clients with age above 65 and will print the number of persons with these criteries

        System.out.println("Number of grannys with stolen souls: " + stolenSouls);
    }

    private void stat4() {
        System.out.println("Number of kidnapped clients: " + kidnappedClients.size());// that show the number of clients who didn't come back from the attraction
    }

    private void stat3() {
        //From the Collection of all Attraction,(will use stream) the type of attraction will be filtered and the will sort them
        // in ascending order o2.getVisitors - o1.getVisitors(). Then will print the name of the most visited attraction from every type.
        attractions.stream()
                .filter(attraction -> attraction.getAttractionType() == AttractionType.EXTREME)
                .sorted((o1, o2) -> o2.getClientsVisitedTheAttraction().size() - o1.getClientsVisitedTheAttraction().size())
                .limit(1)
                .forEach(a -> System.out.println("The most visited extreme attraction: " + a.getName()));
        attractions.stream()
                .filter(a -> a.getAttractionType() == AttractionType.NORMAL)
                .sorted((o1, o2) -> o2.getClientsVisitedTheAttraction().size() - o1.getClientsVisitedTheAttraction().size())
                .limit(1)
                .forEach(a -> System.out.println("The most visited normal attraction: " + a.getName()));
    }

    private void stat2() {
        System.out.println("Total earned money: ");
        System.out.println(this.money);
    }

    private void stat1() {
        List<Client> kids = this.clients.stream()
                        .filter(k -> k.getClientType() == ClientType.CHILD).toList();
        System.out.println("Num of kids visited the park:" + kids.size());
    }
    public void addClient(Client client){
        this.clients.add(client);
    }

    public Set<Client> getClients() {
        return Collections.unmodifiableSet(clients);
    }
    public Attraction getAttraction(){
        return attractions.get(new Random().nextInt(attractions.size()));
    }
    public void distributeByAttraction(){
        ArrayList<Client> arrayList = new ArrayList<>(clients);
        for (int i = 0; i < arrayList.size(); i++) {
            Attraction attraction = getAttraction();
            attraction.visit(arrayList.get(i));
        }
    }
}
