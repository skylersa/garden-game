package model;

import exceptions.AlreadyGrownException;

public enum GrowthStage {
    SEED,
    SPROUT,
    SEEDLING,
    VEGETATIVE,
    BUDDING,
    FLOWERING,
    RIPENING,
    GROWN;
    
    public static GrowthStage nextStage(GrowthStage initStage) throws AlreadyGrownException {
        switch (initStage) {
            case SEED:
                return SPROUT;
            case SPROUT:
                return SEEDLING;
            case SEEDLING:
                return VEGETATIVE;
            case VEGETATIVE:
                return BUDDING;
            case BUDDING:
                return FLOWERING;
            case FLOWERING:
                return RIPENING;
            case RIPENING:
                return GROWN;
            case GROWN:
                throw new AlreadyGrownException();
        }
        throw new NullPointerException();
    }
}
