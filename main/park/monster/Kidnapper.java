package main.park.monster;

import main.park.client.Client;

import java.util.List;


public interface Kidnapper {

    void kidnapHim(Client client); // We can make the method actBeast default, so it's not necessary to override it
                                    // by every danger beast

}
