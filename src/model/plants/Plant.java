package model.plants;

import exceptions.AlreadyGrownException;
import exceptions.MaxGrowthRateExcpetion;
import model.GrowthStage;

public abstract class Plant {
    private final String title;
    private String name;
    
    private GrowthStage growthStage;
    private int growthChance1In; // lower is faster
    
    protected Plant(String title, int growthChance1In) {
        this.title = title;
        this.name = title;
        this.growthStage = GrowthStage.SEED;
        this.growthChance1In = growthChance1In;
    }
    
    // MODIFIES: this
    // EFFECTS: if fully grown, throws AlreadyGrownException
    //     otherwise, has a change to grow this by a stage
    public void growMaybe() throws AlreadyGrownException {
        boolean growthSuccess = Math.random() * growthChance1In + 1 == 1;
        if (growthSuccess) {
            this.growthStage = GrowthStage.nextStage(growthStage);
        }
    }
    
    // MODIFIES: this
    // EFFECTS: improves plant's growth rate slightly
    //     if growth rate is already the best it could be, throw MaxGrowthRateException
    public void fertilise() throws MaxGrowthRateExcpetion {
        if (growthChance1In <= 1) {
            throw new MaxGrowthRateExcpetion();
        } else {
            growthChance1In -= 1;
        }
    }
    
    public void giveName(String newName) {
        this.name = newName;
    }
    
    public GrowthStage getGrowthStage() {
        return growthStage;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getName() {
        return name;
    }
}
