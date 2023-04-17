package ui;

import exceptions.FullGardenException;
import model.Garden;
import model.plants.Plant;
import model.plants.RoseBush;
import model.plants.VenusFlyTrap;

public class GardenViewer {
    private Garden garden;
    
    // EFFECTS: creates new empty gardenViewer with an empty garden
    private GardenViewer() {
        this.garden = new Garden();
    }
    
    // REQUIRES: empty garden
    // MODIFIES: this
    // EFFECTS: adds some default plants to the garden
    private void initialPlants() {
        assert(garden.getPlants().size() == 0);
        try {
            garden.addPlant(new VenusFlyTrap());
            garden.addPlant(new VenusFlyTrap());
            garden.addPlant(new RoseBush());
        } catch (FullGardenException e) {
            System.out.println(e); 
        }
    }
    
    // MODIFIES: this
    // EFFECTS: shows user plants, gives option to plant new plants
    private void viewPlantMenu() {
        System.out.println("Your garden :)");
        listPlants();
    }
    
    private void listPlants() {
        for (Plant plant : garden.getPlants()) {
            System.out.println(plant.getName() + " at growth stage "  + plant.getGrowthStage());
        }
    }
    
    // EFFECTS: starts garden at main menu and a plant or two
    public static void main(String[] args) {
        GardenViewer gv = new GardenViewer();
        gv.initialPlants();
        gv.viewPlantMenu();
    }
    
}
