package main.park.attraction;

import main.park.client.Client;
import main.park.client.ClientType;
import main.park.monster.Beast;
import main.park.monster.BeastType;

public class ExtremeAttraction extends Attraction{

    // TODO
    public ExtremeAttraction(String name, int price, Beast beast) {
        super(name, price, beast,AttractionType.EXTREME);
    }

    @Override
    public boolean checkIfPossibleToVisit(Client client) {
        return client.getClientType() == ClientType.ADULT || client.getClientType() == ClientType.PENSIONER;
    }

    @Override
    protected boolean validClient(ClientType clientType) {
        return clientType == ClientType.ADULT || clientType == ClientType.PENSIONER;
    }

    @Override
    protected boolean validBeast(Beast beast) {
        return beast.getBeastType() == BeastType.MERMAID || beast.getBeastType() == BeastType.DRACON ||
                beast.getBeastType() == BeastType.DEVIL;
    }
}
