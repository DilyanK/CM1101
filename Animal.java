/*
 * Name: Dilyan Kamenov
 * Student number: C1642068
 */

/*
 * A class to represent a number of instances of a zoo animal.
 */
public class Animal {
    private String name;
    private int totalAnimals;
    private int availableAnimals;

    /*
     * Constructor method for creating an animal with a given name
     * and number of  animal instances.
     * This constructor checks that the total number of instances argument is
     * valid; i.e., the number of animals should be 1 or more.
     * If not valid, the constructor will throw an IllegalArgumentException with
     * an appropriate error message.
     */
    public Animal( String name, int totalAnimals ) {
        this.name = name;
        this.totalAnimals = totalAnimals;
        this.availableAnimals = totalAnimals;
        if (totalAnimals < 1) {
            throw new IllegalArgumentException("Number of animal instances is less than one");
        }
    }

    /*
     * An accessor method that returns the animals name.
     */
    public String getName() {
        return name;
    }

    /*
     * An accessor method that returns the total number of instances of this animal.
     * This should count both animal on loan to other collections and returned animals from other collections.
     */
    public int getTotalAnimals() {
        return totalAnimals;
    }

    /*
     * Returns the number of instances of the animal that are available
     * (i.e., not on loan to another collection).
     */
    public int getAvailableAnimals() {
        return availableAnimals;
    }

    /*
     * Mark one of the instances of this animal as on loan to another collection.
     * If there are no available instances to loan to another collection, then this method should
     * throw an IllegalStateException with an appropriate error message.
     */
    public void loanAnimal() {
        if (availableAnimals == 0) {
            throw new IllegalStateException("There are no animals available of this type");
        } else availableAnimals--;
    }

    /*
     * Mark one of the instances of this animal as returned from another collection.
     * If none of the instances of this animal are on loan to other collections, this method
     * should throw an IllegalStateException with an appropriate error message.
     */
    public void returnAnimal() {
        if (availableAnimals >= totalAnimals) {
            throw new IllegalStateException("There are no animals of this type on loan");
        } else availableAnimals++;
    }

    public boolean equals(Object object) {
        boolean isEqual= false;
        if (object != null && object instanceof Animal)
        {
            isEqual = (this.name == ((Animal) object).name);
        }
        return isEqual;
    }
}