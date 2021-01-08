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

    public static Integer newId(){
        int id = idCount;
        idCount+=1;
        return id;

    };
    public static String brandName(){
        List<String> brands_names = Arrays.asList("Pepsi","CocaCola","Nestle","Apple","Samasung","Xiaomi",
                "Lipton","Madero","Tyskie","Lech","McDonalds","Pattex","Huawei","Neutrogena","Polski Banan","Microsoft",
                "CDP Red","Lenovo","Asus");
        return brands_names.get(genInteger(0,brands_names.size()));
    };

    public static String carName(){
      List<String> cars_brand = Arrays.asList("Mercedes","Porsche","Ford","Opel","Mazda","Audi","BMW","KIA","Toyota","Bugatti",
              "Ferrari","Lamborghini","Jaguar","Volkswagen","Nisan","Peugeot","Skoda");
        return cars_brand.get(genInteger(0,cars_brand.size()));
    };

    public static String firstName(){
        List<String> firstName = Arrays.asList("Bartek","Klaudia","Maciej","Janek","Marcin","Ola","Nicole","Hubert",
                "Michał","Darek","Ula","Lidia","Janusz");
        return firstName.get(genInteger(0,firstName.size()));
    }

    public static String lastName(){
        List<String> lastName = Arrays.asList("Kowalski","Maślanka","Duda","Andrzejwska","Musk","Lewansdowski",
                "Małysz","Stoch","Żyła","Tusk","Messi","Ronaldo");
        return lastName.get(genInteger(0,lastName.size()));
    }

    public static String genString(int range){
        int leftLimit = 48;
        int rightLimit = 122;

        String newString = random.ints(leftLimit,rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(range)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return newString;
    }

    public static int genInteger(int min, int max){
        return random.nextInt(max - min) + min;
    }

    public static float genFloat(int min, int max){

        return random.nextFloat() * (max - min) + min;
    }

    public static boolean genBool(){
        return random.nextBoolean();
    }
}
