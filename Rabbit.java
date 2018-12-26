/**
 * Created by Benjamin Ehlers on 12/26/2018.
 */
public class Rabbit {
    private boolean male;
    private boolean female;
    private boolean fertile;
    private int age;

    public Rabbit(boolean male, boolean female, boolean fertile, int age) {
        this.male = male;
        this.female = female;
        this.fertile = fertile;
        this.age = age;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public boolean isFemale() {
        return female;
    }

    public void setFemale(boolean female) {
        this.female = female;
    }

    public boolean isFertile() {
        return fertile;
    }

    public void setFertile(boolean fertile) {
        this.fertile = fertile;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
