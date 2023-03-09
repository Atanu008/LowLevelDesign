package org.proxy.internet;

import java.util.HashSet;
import java.util.Set;

public class ProxyInternet implements Internet{

    private static final Set<String> bannedSites;
    private final Internet internet = new RealInternet();

    static {
        bannedSites = new HashSet<>();
        bannedSites.add("banned.com");
    }
    @Override
    public void connectTo(String host) {
        if(bannedSites.contains(host)){
            System.out.println("Access Denied to " + host);
            return;
        }
        internet.connectTo(host);
    }
}
