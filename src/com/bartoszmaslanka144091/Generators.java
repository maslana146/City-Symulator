package com.bartoszmaslanka144091;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Generators {
    private static int idCount = 0;

    private static Random random = new Random();

    public int getIdCount() {
        return idCount;
    }

    /**
     * Generates new ID
     * @return
     */
    public static Integer newId() {
        int id = idCount;
        idCount += 1;
        return id;

    }

    ;

    /**
     * generates street name
     * @return
     */
    public static String streetName(){
        List<String> brands_names = Arrays.asList("Złota","Jedlinowa","Matejki","WallST","Wiejska","Miastowa");
        return brands_names.get(genInteger(0, brands_names.size()));
    }

    /**
     * generates shop name
     * @return
     */
    public static String shopName(){
        List<String> brands_names = Arrays.asList("Biedronka","Lidl","IKEA","iStore","SATURN","Castorama");
        return brands_names.get(genInteger(0, brands_names.size()));
    }

    /**
     * generates product name
     * @return
     */
    public static String prodName(){
        List<String> brands_names = Arrays.asList("Phone","Tablet","Tomato","Computer","Juice","Sausage","Ham","Bread",
                "Whisky","Milk","Cheese","Game","Gum","Sweets");
        return brands_names.get(genInteger(0, brands_names.size()));
    }

    /**
     * generates product name
     * @return
     */
    public static String brandName() {
        List<String> brands_names = Arrays.asList("Pepsi", "CocaCola", "Nestle", "Apple", "Samasung", "Xiaomi",
                "Lipton", "Madero", "Tyskie", "Lech", "McDonalds", "Pattex", "Huawei", "Neutrogena", "Polski Banan", "Microsoft",
                "CDP Red", "Lenovo", "Asus");
        return brands_names.get(genInteger(0, brands_names.size()));
    }

    ;

    /**
     * generates car name
     * @return
     */
    public static String carName() {
        List<String> cars_brand = Arrays.asList("Mercedes", "Porsche", "Ford", "Opel", "Mazda", "Audi", "BMW", "KIA", "Toyota", "Bugatti",
                "Ferrari", "Lamborghini", "Jaguar", "Volkswagen", "Nisan", "Peugeot", "Skoda");
        return cars_brand.get(genInteger(0, cars_brand.size()));
    }

    ;

    /**
     * generates first name
     * @return
     */
    public static String firstName() {
        List<String> firstName = Arrays.asList("Bartek", "Klaudia", "Maciej", "Janek", "Marcin", "Ola", "Nicole", "Hubert",
                "Michał", "Darek", "Ula", "Lidia", "Janusz");
        return firstName.get(genInteger(0, firstName.size()));
    }

    /**
     * generates last name
     * @return
     */
    public static String lastName() {
        List<String> lastName = Arrays.asList("Kowalski", "Maślanka", "Duda", "Andrzejwska", "Musk", "Lewansdowski",
                "Małysz", "Stoch", "Żyła", "Tusk", "Messi", "Ronaldo");
        return lastName.get(genInteger(0, lastName.size()));
    }

    /**
     * generates string
     * @return
     */
    public static String genString(int range) {
        int leftLimit = 48;
        int rightLimit = 122;

        String newString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(range)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return newString;
    }

    /**
     * @param min min range
     * @param max max range
     *            generate inteager
     * @return
     */
    public static int genInteger(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    /**
     * @param min min range
     * @param max max range
     *            generates float
     * @return
     */
    public static float genFloat(int min, int max) {

        return random.nextFloat() * (max - min) + min;
    }

    /**
     * @return generates bool
     */
    public static boolean genBool() {
        return random.nextBoolean();
    }
}
