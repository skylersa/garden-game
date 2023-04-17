package model;

import exceptions.FullGardenException;
import exceptions.MaxGrowthRateExcpetion;
import model.plants.Plant;

import java.util.ArrayList;
import java.util.List;

public class Garden implements Writable {
    private int INIT_CAPACITY = 4;
    private int maxCapacity;
    
    private List<Plant> plants;
    
    // EFFECTS: creates new empty with max INIT_CAPACITY capacity
    public Garden() {
        this.plants = new ArrayList<>();
        this.maxCapacity = INIT_CAPACITY;
    }
    
    // MODIFIES: this
    // EFFECTS: adds given plant to the garden
    // if garden is full, throws FullGardenException
    public void addPlant(Plant plant) throws FullGardenException {
        assert(plants.size() <= this.maxCapacity);
        if (plants.size() + 1 >= maxCapacity) {
            throw new FullGardenException(maxCapacity, plants.size());
        } else {
            plants.add(plant);
        }
    }
    
    // MODIFIES: this
    // EFFECTS: attempts to fertilise plant at given index
    // if index is not in plants, throws IndexOutOfBoundsException
    // if plant at index is already at max growth rate, throw MaxGrowthRateException
    public void fertiliseIndex(int index) throws MaxGrowthRateExcpetion{
            plants.get(index).fertilise();
    }
    
    // MODIFIES: this
    // EFFECTS: gives each plant a chance to grow
    public void growCycle() {
    
    }
    
    // EFFECTS: returns copy of plants list
    public List<Plant> getPlants() {
        return List.copyOf(plants);
    }
}
