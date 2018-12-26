import java.util.ArrayList;

/**
 * Created by Benjamin Ehlers on 12/26/2018.
 */
public class Main {

    public static void main(String[] args) {
        int maleRabbits = Integer.parseInt(args[0]);
        int femaleRabbits = Integer.parseInt(args[1]);
        int rabbitsNeededAlive = Integer.parseInt(args[2]);

        ArrayList<Rabbit> maleRabbitsArrayList = new ArrayList<>();
        ArrayList<Rabbit> femaleRabbitsArrayList = new ArrayList<>();
        for (int i = 0; i < maleRabbits; i++) {
            maleRabbitsArrayList.add(new Rabbit(true, false, false, 2));

        }
        for (int i = 0; i < femaleRabbits; i++) {
            femaleRabbitsArrayList.add(new Rabbit(false, true, false, 2));
        }

        int deadRabbits = 0;
        int months = 0;
        int arr[];
        while (maleRabbits + femaleRabbits < rabbitsNeededAlive) {
            arr = simulateMonth(maleRabbits, femaleRabbits, maleRabbitsArrayList, femaleRabbitsArrayList, deadRabbits);
            maleRabbits = arr[0];
            femaleRabbits = arr[1];
            months++;
        }

        System.out.println("Months: " + months);
        System.out.println("Dead rabbits: " + deadRabbits);

    }

    private static int[] simulateMonth(int maleRabbits, int femaleRabbits,
                                      ArrayList<Rabbit> maleRabbitsArrayList,
                                      ArrayList<Rabbit> femaleRabbitsArrayList,
                                      int deadRabbits) {

        int malesToGenerate = 0;
        int femalesToGenerate = 0;
        for(int i = 0; i < femaleRabbits; i++) {

            if(femaleRabbitsArrayList.get(i).isFertile()) {
                malesToGenerate+=5;
                femalesToGenerate+=9;
            }
        }

        for (int i = 0; i < maleRabbits; i++) {
            maleRabbitsArrayList.get(i).setAge(maleRabbitsArrayList.get(i).getAge() + 1);
            if (maleRabbitsArrayList.get(i).getAge() == 96) {
                maleRabbitsArrayList.remove(i);
                maleRabbits--;
                deadRabbits++;
            }
        }

        for (int i = 0; i < femaleRabbits; i++) {
            femaleRabbitsArrayList.get(i).setAge(femaleRabbitsArrayList.get(i).getAge() + 1);
            if (femaleRabbitsArrayList.get(i).getAge() == 96) {
                femaleRabbitsArrayList.remove(i);
                femaleRabbits--;
                deadRabbits++;
            }
            else if (femaleRabbitsArrayList.get(i).getAge() == 4) {
                femaleRabbitsArrayList.get(i).setFertile(true);
            }
        }
        for(int i = femaleRabbits; i < femalesToGenerate + femaleRabbits; i++) {
            femaleRabbitsArrayList.add(new Rabbit(false, true, false, 0));
        }
        femaleRabbits+=femalesToGenerate;
        for(int i = maleRabbits; i < malesToGenerate + maleRabbits; i++) {
            maleRabbitsArrayList.add(new Rabbit(true, false, false, 0));
        }
        maleRabbits+=malesToGenerate;
        return new int[] {maleRabbits, femaleRabbits};
    }
}
