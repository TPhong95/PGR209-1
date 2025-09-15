package DungeonCrawlerTomcat.DamageTakenPackage;

public class DamageTaken {

    public String calculateDamage(int health, int damage){
        return String.valueOf(health - damage);
    }

}
