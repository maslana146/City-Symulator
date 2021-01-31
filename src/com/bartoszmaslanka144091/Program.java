package com.bartoszmaslanka144091;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Iterator;


public class Program {
    private static Program instance;

    /**
     * @return get one instance of program class
     */
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
    boolean created = false;

    /**
     * list of wholsales
     */
    public ObservableList<Wholesale> listOfWholesales = FXCollections.observableArrayList();
    /**
     * list of retailshops
     */
    public ObservableList<RetailShop> listOfRetailShops = FXCollections.observableArrayList();
    /**
     * list of suppliers
     */
    public ObservableList<Supplier> listOfSuppliers = FXCollections.observableArrayList();
    /**
     * list of clinets
     */
    public ObservableList<Client> listOfClients = FXCollections.observableArrayList();


    /**
     * @param percentageSick set
     */
    public void setPercentageSick(int percentageSick) {
        PercentageSick = percentageSick;
    }

    /**
     * @param percentageVaccinated set
     */
    public void setPercentageVaccinated(int percentageVaccinated) {
        PercentageVaccinated = percentageVaccinated;
    }

    /**
     * @param getSickVaccinated setter
     */
    public void setGetSickVaccinated(int getSickVaccinated) {
        GetSickVaccinated = getSickVaccinated;
    }

    /**
     * @param getSickWithMask setter
     */
    public void setGetSickWithMask(int getSickWithMask) {
        GetSickWithMask = getSickWithMask;
    }

    /**
     * @param shopsToGetWell setter
     */
    public void setShopsToGetWell(int shopsToGetWell) {
        this.shopsToGetWell = shopsToGetWell;
    }

    /**
     * @param lockdown setter
     */
    public void setLockdown(boolean lockdown) {
        this.lockdown = lockdown;
    }

    /**
     * @return getter
     */
    public int getPercentageSick() {
        return PercentageSick;
    }

    /**
     * @return getter
     */
    public int getPercentageVaccinated() {
        return PercentageVaccinated;
    }

    /**
     * @return getter
     */
    public int getGetSickVaccinated() {
        return GetSickVaccinated;
    }

    /**
     * @return getter
     */
    public int getGetSickWithMask() {
        return GetSickWithMask;
    }

    /**
     * @return getter
     */
    public int getShopsToGetWell() {
        return shopsToGetWell;
    }

    /**
     * @return getter
     */
    public boolean isLockdown() {
        return lockdown;
    }

    /**
     * sets % population sick
     */
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

    /**
     * sets % population vaccinated
     */
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

    /**
     * checks new % population sick
     */
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

    /**
     * check new %vaccinated population
     */
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

    /**
     * setter
     */
    public void setShopsToGetWell(){
        for (Iterator<Client> iterator = listOfClients.iterator(); iterator.hasNext(); ) {
            iterator.next().setShopsToGetWell(shopsToGetWell);
        }
        for (Iterator<Supplier> iterator = listOfSuppliers.iterator(); iterator.hasNext(); ) {
            iterator.next().setShopsToGetWell(shopsToGetWell);
        }
    }

}
