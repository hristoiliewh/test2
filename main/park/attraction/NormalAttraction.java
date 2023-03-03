package main.park.attraction;

import main.park.client.Client;
import main.park.client.ClientType;
import main.park.monster.Beast;
import main.park.monster.BeastType;

public class NormalAttraction extends Attraction{


    public NormalAttraction(String name, int price, Beast beast) {
        super(name, price, beast,AttractionType.NORMAL);
    }

    @Override
    public boolean checkIfPossibleToVisit(Client client) {
        return client.getClientType() == ClientType.ADULT || client.getClientType() == ClientType.PENSIONER || client.getClientType() == ClientType.CHILD;
    }

    @Override
    protected boolean validClient(ClientType clientType) {
        return true;
    }

    @Override
    protected boolean validBeast(Beast beast) {
        return beast.getBeastType() == BeastType.DWARF || beast.getBeastType() == BeastType.GRIFON ||
               beast.getBeastType() == BeastType.KRACKEN;
    }
}
