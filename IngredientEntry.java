import java.io.Serializable;

enum IngredientTypes{
    WEIGHT,
    VOLUME,
    QUANTITY
}

public class IngredientEntry implements Serializable {
    static final long serialVersionUID = 42L;
    int id;
    String name;
    String imgPath;
    IngredientTypes type;
    float weight = 0;
    float volume = 0;
    float density = 0;

    IngredientEntry(int id, String name, String type, int weight, int volume, int density){
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.volume = volume;
        this.density = density;
    }

    public int getId() {
        return id;
    }
    public String getImgPath() {
        return imgPath;
    }
    public String getName() {
        return name;
    }
    public float getDensity() {
        return density;
    }
    public float getVolume() {
        return volume;
    }
    public float getWeight() {
        return weight;
    }
    public void calc(){
        if ((density == 0)&&(weight!=0)&&(volume!=0)){
            density = weight/volume;
            return;
        };
        if (density==0) return;
        switch (type){
            case WEIGHT: 
            volume = weight/density;
            break;
            case VOLUME:
            weight = density*volume;
            break;
            case QUANTITY:
            break;
        }

    }
}
