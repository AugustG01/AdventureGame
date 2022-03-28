public class Food extends Item{

    private int healthPoints;

    Food(String description, int healthPoints){
        super(description);
        setHealthPoints(healthPoints);
    }
    public void setHealthPoints(int healthPoints){
        this.healthPoints = healthPoints;
    }
    public int getHealthPoints(){
        return healthPoints;
    }
}
