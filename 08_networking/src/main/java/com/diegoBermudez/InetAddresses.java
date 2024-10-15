package com.diegoBermudez;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddresses {

    public static void main(String[] args) throws UnknownHostException {
        //InetAddresses can be used to establish the connections in both TCP or UDP, but also as DNS reslution
        //since we can obtain the IP from a URL


        String url = "www.linkedin.com";
        //we could use the InetAddress, but since we know it's a v4, we can directly call the method over that class
        InetAddress address = Inet4Address.getByName(url);

        System.out.println("Address: " + Arrays.toString(address.getAddress()));

        System.out.println("Host address: " + address.getHostAddress());

        System.out.println("Is any local address: " + address.isAnyLocalAddress()); //returns if it's a wildcard address or not
        //a wildcard address is basically an address which is a range, like 192.168.15.0/24, it listens to all the possible addresses
        //at that mask, or 0.0.0.0, which listens to all addresses assigned to the device, so a NON wildcard address is an unique address
        System.out.println("Is link local address: " + address.isLinkLocalAddress());
        //link local addresses are addresses that are only available inside a network, but not from outsie, for instance I'll do
        System.out.println("Is loopback address: " + Inet4Address.getByAddress(new byte[]{127,0,0,1}).isLoopbackAddress());

        System.out.println("is site local addresS: " + Inet4Address.getByAddress(new byte[]{-64, -88, 1, 108}).isSiteLocalAddress());
        //site local addresses are addresses intended to use only private in a network, they use private ranges like
        //10.0.0.0/8 or 172.16.0.0/16 or 192.168.0.0/16
        System.out.println("hashcode: " + address.hashCode());


    }
}
