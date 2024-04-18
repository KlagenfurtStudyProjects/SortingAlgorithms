import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

class MyArrayList{
    private ArrayList<Integer> myArrayList;

    public MyArrayList(int size){
        this.myArrayList = CreateArrayList(size);
    }

    public ArrayList<Integer> GetMyArrayList(){
        // Collections.sort(myArrayList, Collections.reverseOrder());
        return myArrayList;
    }

    public ArrayList<Integer> CreateArrayList(int size){
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int randomNumber = random.nextInt(100);
            arrayList.add(randomNumber);
        }

        return arrayList;
    }
}