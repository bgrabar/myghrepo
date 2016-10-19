/*
 * Created by bob on 2016 /10/17.
 */

import java.util.*;

public class Cat extends Animal{

    public Cat(){
    }

    public String makeSound(){
        return "Meow";
    }

    public static void main(String[] args){
        Animal fido = new Dog();
        Animal fluffy = new Cat();

        System.out.println("Fido says " + fido.makeSound());
        System.out.println("Fluffy says " + fluffy.makeSound());

        speakAnimal(fluffy);



    }

}
