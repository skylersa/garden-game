package exceptions;

public class FullGardenException extends Exception {
    private int gardenCapacity;
    private int numPlants;
    
    public FullGardenException(int gardenCapacity, int numPlants) {
        super("Garden is already full, its capacity is " + gardenCapacity
                + " and there are already has "
                + numPlants + " plants");
    }
}
