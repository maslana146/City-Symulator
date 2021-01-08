package com.bartoszmaslanka144091;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Iterator;


public class Program {
    private static Program instance;

    public static Program getInstance() {
        if (instance == null) {
            synchronized (Program.class) {
                if (instance == null) {
                    instance = new Program();
                }
            }
        }
        return instance;
    }

    int PercentageSick = 0;
    int PercentageVaccinated = 0;
    int GetSickVaccinated = 20;
    int GetSickWithMask = 20;
    int shopsToGetWell = 4;
    boolean lockdown = false;

    public ObservableList<Wholesale> listOfWholesales = FXCollections.observableArrayList();
    public ObservableList<RetailShop> listOfRetailShops = FXCollections.observableArrayList();
    public ObservableList<Supplier> listOfSuppliers = FXCollections.observableArrayList();
    public ObservableList<Client> listOfClients = FXCollections.observableArrayList();

    public void setPercentageSick(int percentageSick) {
        PercentageSick = percentageSick;
    }

    public void setPercentageVaccinated(int percentageVaccinated) {
        PercentageVaccinated = percentageVaccinated;
    }

    public void setGetSickVaccinated(int getSickVaccinated) {
        GetSickVaccinated = getSickVaccinated;
    }

    public void setGetSickWithMask(int getSickWithMask) {
        GetSickWithMask = getSickWithMask;
    }

    public void setShopsToGetWell(int shopsToGetWell) {
        this.shopsToGetWell = shopsToGetWell;
    }

    public void setLockdown(boolean lockdown) {
        this.lockdown = lockdown;
    }

    public int getPercentageSick() {
        return PercentageSick;
    }

    public int getPercentageVaccinated() {
        return PercentageVaccinated;
    }

    public int getGetSickVaccinated() {
        return GetSickVaccinated;
    }

    public int getGetSickWithMask() {
        return GetSickWithMask;
    }

    public int getShopsToGetWell() {
        return shopsToGetWell;
    }

    public boolean isLockdown() {
        return lockdown;
    }

    public void setPerSick() {
        int population = listOfClients.size() + listOfSuppliers.size();
        double max = (double) PercentageSick / 100 * population;
        int result = (int) max;
        if (result == 0) {
            for (Iterator<Client> iterator = listOfClients.iterator(); iterator.hasNext(); ) {
                iterator.next().setIsSick(false);
            }
            for (Iterator<Supplier> iterator = listOfSuppliers.iterator(); iterator.hasNext(); ) {
                iterator.next().setIsSick(false);

            }
            return;
        } else {
            for (Iterator<Client> iterator = listOfClients.iterator(); iterator.hasNext(); ) {
                if (result > 0) {
                    iterator.next().setIsSick(true);
                    result -= 1;
                } else
                    iterator.next().setIsSick(false);
            }
            for (Iterator<Supplier> iterator = listOfSuppliers.iterator(); iterator.hasNext(); ) {
                if (result > 0) {
                    iterator.next().setIsSick(true);
                    result -= 1;
                } else
                    iterator.next().setIsSick(false);
            }
        }
    }

    public void setVacSick() {
        int population = listOfClients.size() + listOfSuppliers.size();
        double max = (double) PercentageVaccinated / 100 * population;
        int result = (int) max;
        if (result == 0) {
            for (Iterator<Client> iterator = listOfClients.iterator(); iterator.hasNext(); ) {
                iterator.next().setVaccinated(false);
            }
            for (Iterator<Supplier> iterator = listOfSuppliers.iterator(); iterator.hasNext(); ) {
                iterator.next().setVaccinated(false);

            }
            return;
        } else {
            for (Iterator<Client> iterator = listOfClients.iterator(); iterator.hasNext(); ) {
                if (result > 0) {
                    iterator.next().setVaccinated(true);
                    result -= 1;
                } else
                    iterator.next().setVaccinated(false);
            }
            for (Iterator<Supplier> iterator = listOfSuppliers.iterator(); iterator.hasNext(); ) {
                if (result > 0) {
                    iterator.next().setVaccinated(true);
                    result -= 1;
                } else
                    iterator.next().setVaccinated(false);
            }
        }
    }

    public void checkPerSick() {
        int population = listOfClients.size() + listOfSuppliers.size();
        int number = 0;
        for (Iterator<Client> iterator = listOfClients.iterator(); iterator.hasNext(); ) {
            if (iterator.next().getIsSick() == true) {
                number += 1;
            }
        }
        for (Iterator<Supplier> iterator = listOfSuppliers.iterator(); iterator.hasNext(); ) {
            if (iterator.next().getIsSick() == true) {
                number += 1;
            }
        }
        double x = (double) number / population * 100;
        setPercentageSick((int) x);

    }

    public void checkVacSick() {
        int population = listOfClients.size() + listOfSuppliers.size();
        int number = 0;
        for (Iterator<Client> iterator = listOfClients.iterator(); iterator.hasNext(); ) {
            if (iterator.next().getVaccinated() == true) {
                number += 1;
            }
        }
        for (Iterator<Supplier> iterator = listOfSuppliers.iterator(); iterator.hasNext(); ) {
            if (iterator.next().getVaccinated() == true) {
                number += 1;
            }
        }
        double x = (double) number / population * 100;
        setPercentageVaccinated((int) x);

    }
    public void setShopsToGetWell(){
        for (Iterator<Client> iterator = listOfClients.iterator(); iterator.hasNext(); ) {
            iterator.next().setShopsToGetWell(shopsToGetWell);
        }
        for (Iterator<Supplier> iterator = listOfSuppliers.iterator(); iterator.hasNext(); ) {
            iterator.next().setShopsToGetWell(shopsToGetWell);
        }
    }

}
