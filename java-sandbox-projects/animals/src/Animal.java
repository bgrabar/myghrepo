/*
 * Created by bob on 2016 /10/17.
 */

import java.util.*;

public class Animal {

    public static final double FAVNUMBER = 1.6180;

    private String name;
    private int weight;
    private boolean hasOwner = false;
    private byte age;
    private long uniqueID;
    private char favoriteChar;
    private double speed;
    private float height;

    protected static int numberOfAnimals = 0;

    static Scanner userInput = new Scanner(System.in);

    public Animal() {
        numberOfAnimals++;

        int sumOfNumbers = 5 + 1;
        System.out.println("5 + 1 = " + sumOfNumbers);

        int diffOfNumbers = 5 - 1;
        System.out.println("5 - 1 = " + diffOfNumbers);

        int multOfNumbers = 5 * 1;
        System.out.println("5 * 1 = " + multOfNumbers);

        int divOfNumbers = 5 / 1;
        System.out.println("5 / 1 = " + divOfNumbers);

        int modOfNumbers = 5 % 3;
        System.out.println("5 % 3 = " + modOfNumbers);

        System.out.print("Enter the name: \n");

        // hasNextInt, hasNextFloat, hasNextDouble
        // hasNextByte
        // nextInt, nextFloat, nextDouble, nextByte

        if (userInput.hasNextLine()) {

            this.setName(userInput.nextLine());
        }

        this.setFavoriteChar();
        this.setUniqueID();


    }

    public char getFavoriteChar() {
        return favoriteChar;
    }

    public void setFavoriteChar(final char pFavoriteChar) {
        favoriteChar = pFavoriteChar;
    }

    public void setFavoriteChar() {
        int randomNumber = (int)(Math.random() * 126 ) + 1;
        this.favoriteChar = (char) randomNumber;

        if (randomNumber == 32) {
            System.out.println("Favorite character is space.");
        }
        else if(randomNumber == 10) {
            System.out.println("Favorite character is newline.");
        }
        else {
            System.out.println("Favorite character is " + this.favoriteChar + ".");
        }

        if ((randomNumber > 97) &&  (randomNumber < 122)) {
            System.out.println("Favorite character is a lowercase number.");
        }

        if (((randomNumber > 97) &&  (randomNumber < 122)) || ((randomNumber > 64) &&  (randomNumber < 91)) ) {
            System.out.println("Favorite character is a letter.");
        }

        int whichIsBigger = (50 > randomNumber) ? 50 : randomNumber;

        switch (randomNumber) {
            case 8:
                System.out.println("Favorite character is set to backspace.");
                break;

            case 10:
            case 11:
            case 12:
                System.out.println("10, 11, 12.");
                break;

            default:
                System.out.println();


        }
    }

    public byte getAge() {
        return age;
    }

    public void setAge(final byte pAge) {
        age = pAge;
    }

    public boolean isHasOwner() {
        return hasOwner;
    }

    public void setHasOwner(final boolean pHasOwner) {
        hasOwner = pHasOwner;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(final float pHeight) {
        height = pHeight;
    }

    public String getName() {
        return name;
    }

    public void setName(final String pName) {
        name = pName;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(final double pSpeed) {
        speed = pSpeed;
    }

    public long getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(final long pUniqueID) {
        uniqueID = pUniqueID;
        System.out.println("Unique ID set to: " + this.uniqueID);

    }

    public void setUniqueID() {
        long minNumber = 1;
        long maxNumber = 1000000;

        this.uniqueID = minNumber + (long) (StrictMath.random() * ((maxNumber - minNumber) + 1));
        System.out.println("Unique ID set to: " + this.uniqueID);

    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(final int pWeight) {
        weight = pWeight;
    }

    protected static void countTo(int startingNumber){
        for (int i = startingNumber; i <= 100; i++){
            if ( i == 90) continue;
            System.out.println(i);
        }
    }

    protected static String printNumbers(int maxNumbers){
        int i = 1;
        while ( i < (maxNumbers / 2) ){
            System.out.println(i);
            i++;

            if ( i == (maxNumbers/2)) break;

        }

        Animal.countTo(maxNumbers/2);

        return "End of printNumbers";

    }

    protected static void guessMyNumber(){
        int number;
        do {
            System.out.println("Guess Number up to 100.");

            while(!userInput.hasNextInt()){
                String numberEntered = userInput.next();
                System.out.printf("%s is not a number.\n", numberEntered);
            }

            number = userInput.nextInt();

        } while (number != 50);
    }

    public String makeSound(){
        return "Grrr";
    }

    public static void speakAnimal(Animal randAnimal){
        System.out.println("Animal says " + randAnimal.makeSound());
    }



    public static void main(String[] args) {
        Animal theAnimal = new Animal();
    }


}
