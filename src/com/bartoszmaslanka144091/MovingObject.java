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

    public StaticObject getVisitingShop() {
        return visitingShop;
    }

    public void setVisitingShop(Cell cell) {
        for (StaticObject staticObject : WorldScreen.staticObjects) {
            if (staticObject.getGoToCell().getX() == cell.getX() && staticObject.getGoToCell().getY() == cell.getY()) {
                this.visitingShop = staticObject;

            }
        }
    }

    public void swapItems() {
        if (this.client == null) {

        } else if (this.supplier == null) {
            visitingShop.getRetailShop().setPeopleCapacity(visitingShop.getRetailShop().getPeopleCapacity()+1);
            List<Product> deleteList = new ArrayList<>();
            for (Product product: visitingShop.getRetailShop().getAvailableProducts()){
                if (this.client.currentCapacity < this.client.maxCapacity) {
                    float p = Generators.genFloat(0, 1);
                    System.out.println();
                    if (p <= product.chance_to_take) {
                        deleteList.add(product);
//                        System.out.println(deleteList);
//                        visitingShop.getRetailShop().getAvailableProducts().remove();
//                        System.out.println("Dodano"+product);
                        this.client.getBag().add(product);
                        this.client.currentCapacity += 1;
                    }
                }else break;
            }
            for (Product product: deleteList){
                visitingShop.getRetailShop().availableProducts.remove(product);
            }

        }
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public MovingObject(double centerX, double centerY, double radius, Paint fill) {
        super(centerX, centerY, radius, fill);

    }

    public void setCurrentCell() {
        Cell[][] grid = Map.getGrid();
        int x = (int) ((getTranslateX()) - 12) / 25;
        int y = (int) ((getTranslateY()) - 12) / 25;
        this.currentCell = grid[x][y];
    }


    public Cell getCurrentCell() {
        return currentCell;
    }

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
                PathCreator.moveObject(Map.getGrid(), this, this.getCurrentCell(), this.getSupplier().getNewNextShop().getGoToCell(), time);
            }
            try {
                Thread.sleep((time * 2000) + (Generators.genInteger(1, 3) * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(this.getCurrentCell());
//            System.out.println(getVisitingShop().getWholesale());
//
//            System.out.println(getVisitingShop().getRetailShop());
//            System.out.println("Koniec " + Thread.currentThread());

            if (this.getVisitingShop().getRetailShop() == null){
                this.getVisitingShop().getWholesale().setPeopleCapacity(getVisitingShop().getWholesale().getPeopleCapacity()-1);
            }else if(this.getVisitingShop().getWholesale() == null){
                this.visitingShop.getRetailShop().setPeopleCapacity(getVisitingShop().getRetailShop().getPeopleCapacity()-1);
            }
        }
    }

    public void stop() {
        this.running = false;

    }
}
