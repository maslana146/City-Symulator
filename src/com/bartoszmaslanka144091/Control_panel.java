package com.bartoszmaslanka144091;

import java.util.ArrayList;
import java.util.List;

public class Control_panel {

    List<Wholesale> listOfWholesales = new ArrayList<Wholesale>();
    List<RetailShop> listOfRetailShops = new ArrayList<RetailShop>();
    List<Supplier> listOfSuppliers = new ArrayList<Supplier>();
    List<Client> listOfClients = new ArrayList<Client>();

    public List<Wholesale> getListOfWholesales() {
        return listOfWholesales;
    }

    public List<RetailShop> getListOfRetailShops() {
        return listOfRetailShops;
    }

    public List<Supplier> getListOfSuppliers() {
        return listOfSuppliers;
    }

    public List<Client> getListOfClients() {
        return listOfClients;
    }

    public void setPercentageSick(float per) {
        int population = listOfClients.size() + listOfSuppliers.size();
        int sickPopulation = (int) per * population;
        int sickClients = Generators.genInteger(0,sickPopulation);
        int sickSuppliers = sickPopulation - sickClients;
        for (Client client: listOfClients){
            if (sickClients > 0){
                client.isSick = true;
                sickClients -= 1;

            }
            else {
                client.isSick = false;
            }
        }

        for (Supplier supplier: listOfSuppliers){
            if (sickSuppliers > 0){
                supplier.isSick = true;
                sickSuppliers -= 1;

            }
            else {
                supplier.isSick = false;
            }
        }
    }

    ;

    public void createSuppliers() {
        int id = Generators.genInteger(0,100);
        boolean isSick = Generators.genBool();
        boolean wearsMask = Generators.genBool();
        boolean vac = Generators.genBool();
        float chanceToGetSick = Generators.genFloat(0,1);
        int shopsToGetWell = Generators.genInteger(0,5);


    }

    ;

    void createClient() {
    }

    ;

    void setPercentageVaccinated() {
    }

    ;

    void setGetSickVaccinated() {
    }

    ;

    void setGetSickWithMask() {
    }

    ;

    void setGetSick() {
    }

    ;

    void shopsToGetWell() {
    }

    ;

    void lockdown() {
    }

    ;
}