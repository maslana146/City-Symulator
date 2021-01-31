package com.bartoszmaslanka144091;

import com.bartoszmaslanka144091.Controllers.WorldScreen;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class MovingObject extends Circle implements Runnable {
    private volatile boolean running = true;
    Client client = null;
    Supplier supplier = null;
    Cell currentCell = Map.grid[8][9];
    StaticObject visitingShop;
    boolean enter = false;

    /**
     * constuctor
     * @param centerX
     * @param centerY
     * @param radius
     * @param fill
     */
    public MovingObject(double centerX, double centerY, double radius, Paint fill) {
        super(centerX, centerY, radius, fill);

    }

    /**
     * @return visiting shop
     */
    public StaticObject getVisitingShop() {
        return visitingShop;
    }

    /**
     * @return get supplier
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * @param supplier set
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    /**
     * @return get client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     *  transorm pixels to current cell
     */
    public void setCurrentCell() {
        Cell[][] grid = Map.getGrid();
        int x = (int) ((getTranslateX()) - 12) / 25;
        int y = (int) ((getTranslateY()) - 12) / 25;
        this.currentCell = grid[x][y];
    }


    /**
     * @return get current cell
     */
    public Cell getCurrentCell() {
        return currentCell;
    }

    /**
     * Get sick function
     */
    public void coronaVirus() {
        Program program = Program.getInstance();
        float prob = 1;
        List<MovingObject> objectsInShop = WorldScreen.movingObjects.filtered(object -> object.getCurrentCell() == this.getCurrentCell() && object != this);
        for (MovingObject movingObject : objectsInShop) {
            if (movingObject.getSupplier() == null) {
                if (movingObject.getClient().isSick) {
                    if (movingObject.getClient().wearsMask) {
                        prob = 1;
                    } else prob = 2;
                }
            } else if (movingObject.getClient() == null) {
                if (movingObject.getSupplier().isSick) {
                    if (movingObject.getSupplier().wearsMask) {
                        prob = 1;
                    } else prob = 2;
                }
            }
            if (this.getSupplier() == null) {
                if (this.getClient().wearsMask) prob *= program.GetSickWithMask;
                else prob *= (2 * program.getGetSickWithMask());
                if (this.getClient().vaccinated) prob *= program.GetSickVaccinated;
                else prob *= (2 * program.GetSickVaccinated);

                if (Generators.genInteger(0, 100) < prob/100) {
                    this.getClient().setIsSick(true);
                    this.getClient().setShopsToGetWell(program.shopsToGetWell);
//                    System.out.println("CHOOOOOOOOOOOOOORYYYY "+this.getClient().getFirstName()+this.currentCell);
                    return;
                }

            } else if (this.getClient() == null) {
                if (this.getSupplier().wearsMask) prob *= program.GetSickWithMask;
                else prob *= (2 * program.getGetSickWithMask());
                if (this.getSupplier().vaccinated) prob *= program.GetSickVaccinated;
                else prob *= (2 * program.GetSickVaccinated);

                if (Generators.genInteger(0, 100) < prob/100) {
                    this.getSupplier().setIsSick(true);
                    this.getSupplier().setShopsToGetWell(program.shopsToGetWell);
                    return;
                }

            }
        }
    }

    /**
     * do action after enter or not to the shop
     */
    public void action(){
        if (this.getSupplier() == null){
            this.getClient().getWell();
        }else if (this.getClient()==null){
            this.getSupplier().setCurrentFuel(1);
            this.getSupplier().getWell();
        }
        if (visitingShop.getRetailShop() == null){
            if (visitingShop.getWholesale().getPeopleCapacity() < visitingShop.getWholesale().getMaxClientCapacity()){
                this.setVisible(false);
                this.enter = true;
                visitingShop.getWholesale().enterPerson();
                swapItems();
            }
        }else if(visitingShop.getWholesale() == null){
            if (visitingShop.getRetailShop().getPeopleCapacity() < visitingShop.getRetailShop().getMaxClientCapacity()){
                this.setVisible(false);
                this.enter = true;
                visitingShop.getRetailShop().enterPerson();
                swapItems();

            }

        }
    }

    /**
     *  take or leave products from/to shop
     */
    public void swapItems() {

        List<Product> deleteList = new ArrayList<>();
        if (this.client == null) {

            if (visitingShop.getWholesale() == null) {

                for (Product product : this.supplier.bag) {
                    if (visitingShop.getRetailShop().getStorageCapacity() < visitingShop.getRetailShop().getMaxStorageCapacity()) {
                        visitingShop.getRetailShop().getAvailableProducts().add(product);
                        visitingShop.getRetailShop().setStorageCapacity((visitingShop.getRetailShop().getStorageCapacity()));
                        deleteList.add(product);
                        this.supplier.currentCapacity -= 1;

                    }
                }
                this.supplier.bag.removeAll(deleteList);
            } else if (visitingShop.getRetailShop() == null) {

                for (Product product : visitingShop.wholesale.availableProducts) {
                    if (this.supplier.currentCapacity < this.supplier.maxCapacity) {
                        deleteList.add(product);
                        this.supplier.getBag().add(product);
                        this.supplier.currentCapacity += 1;
                    }
                }
                visitingShop.getWholesale().getStorageCapacity();
                visitingShop.getWholesale().availableProducts.removeAll(deleteList);
            }


        } else if (this.supplier == null) {

            for (Product product : visitingShop.getRetailShop().getAvailableProducts()) {
                if (this.client.currentCapacity < this.client.maxCapacity) {
                    float p = Generators.genFloat(0, 1);
//                    System.out.println();
                    if (p <= product.chance_to_take) {
                        deleteList.add(product);
//                        System.out.println(deleteList);
//                        visitingShop.getRetailShop().getAvailableProducts().remove();
//                        System.out.println("Dodano"+product);
                        this.client.getBag().add(product);
                        this.client.currentCapacity += 1;
                    }
                } else break;
            }
            visitingShop.getRetailShop().availableProducts.removeAll(deleteList);

            this.getClient().consume();
        }


    }

    /**
     * @param cell set visiteed shop
     */
    public void setVisitingShop(Cell cell) {
        for (StaticObject staticObject : WorldScreen.staticObjects) {
            if (staticObject.getGoToCell().getX() == cell.getX() && staticObject.getGoToCell().getY() == cell.getY()) {
                this.visitingShop = staticObject;

            }
        }
    }

    /**
     *  thread run function
     */
    @Override
    public void run() {
        while (running) {
            this.setVisible(true);
            int time = Generators.genInteger(6, 10);
            if (supplier == null) {
                this.getClient().setNextshop();
                PathCreator.moveObject(Map.getGrid(), this, this.getCurrentCell(), this.getClient().getNextshop().getGoToCell(), time);

            } else if (client == null) {
                this.getSupplier().addNextShop();
                this.getSupplier().getNewNextShop();
                PathCreator.moveObject(Map.getGrid(), this, this.getCurrentCell(), this.getSupplier().getNextShop().getGoToCell(), time);
            }
            try {
                //(Generators.genInteger(1, 2) * 1000)
                Thread.sleep((time * 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (this.enter){
                if (this.getVisitingShop().getRetailShop() == null) {
                    this.getVisitingShop().getWholesale().outPerson();
                } else if (this.getVisitingShop().getWholesale() == null) {
                    this.getVisitingShop().getRetailShop().outPerson();
                }
                this.enter = false;
            }
        }
    }

    /**
     * stop thread
     */
    public void stop() {
        this.running = false;

    }
}
