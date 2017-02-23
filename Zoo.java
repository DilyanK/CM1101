/*
 * Name: Dilyan Kamenov
 * Student number: C1642068
 */

import java.util.ArrayList;

/*
 * A class to represent a zoo.
 * A zoo can either have unlimited animal capacity or limited animal capacity.
 * For limited capacity zoos, animals on loan to other zoo collections still count towards the
 * capacity (there must be space reserved for when an animal is returned).
 */
public class Zoo {
    // Define fields here
    // to be completed
    private ArrayList<Animal> collection;
    private int capacity;
    private int capacityCheck;

    /*
     * Construct a Library with unlimited capacity.
     */
    public Zoo() {
        this.collection = new ArrayList<Animal>();
        this.capacity = Integer.MAX_VALUE;
        this.capacityCheck = Integer.MAX_VALUE;
    }

    /*
     * Construct a Library with limited capacity.
     */
    public Zoo(int inCapacity) {
        if (inCapacity <= 0) {
            throw new IllegalArgumentException("You cannot create a zoo with zero or less animals");
        } else {
            this.collection = new ArrayList<Animal>();
            this.capacity = inCapacity;
            this.capacityCheck = inCapacity;
        }
    }

    public void addAnimal(Animal newAnimal) {
        if (!(collection.size() >= capacity) && newAnimal.getAvailableAnimals() <= capacityCheck) {
            collection.add(newAnimal);
            capacityCheck -= newAnimal.getAvailableAnimals();
        } else throw new IllegalStateException("There isn't enough space for that animal");
    }

    public boolean hasAnimalWithName(String animalName) {
        for (Animal item : collection)
            if (animalName.toLowerCase().equals(item.getName().toLowerCase()))
                return true;
        return false;
    }

    public Animal getAnimalWithName(String animalName) {
        for (Animal item : collection)
            if (animalName.toLowerCase().equals(item.getName().toLowerCase()))
                return item;
        return null;
    }

    public int numberAvailableAnimals(){
        int availableAnimalsZoo = 0;
        for (Animal item : collection){
            availableAnimalsZoo += item.getAvailableAnimals();
        }
        return availableAnimalsZoo;
    }

/*  For testing purposes

    public void showAnimals() {
        for (Animal item : collection) {     
            System.out.println(item);
        }
    }
*/
}




