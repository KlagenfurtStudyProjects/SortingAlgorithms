import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.File;

class Main{
    public static void main(String[] args){
        StringBuilder sizes = new StringBuilder();
        StringBuilder timeReguralSort = new StringBuilder();
        StringBuilder timeMedianSort = new StringBuilder();
        TimeMeasure tm = new TimeMeasure();

        for (int i = 10; i < 100000000; i *= 10){
            sizes.append(i + ", ");

            MyArrayList myList = new MyArrayList(i);

            var copyforSortArrayList = new ArrayList<>(myList.GetMyArrayList());
            tm.Start();
            regularSort(copyforSortArrayList);
            tm.End();
            timeReguralSort.append(tm.GetElapsedTime() + ", ");

            var copyForMedianArrayList = new ArrayList<>(myList.GetMyArrayList());
            tm.Start();
            medianSort(copyForMedianArrayList);
            tm.End();
            timeMedianSort.append(tm.GetElapsedTime() + ", ");

        }
        
        System.out.println(sizes);
        System.out.println(timeReguralSort);
        System.out.println(timeMedianSort);

        sizes.append('\n');
        sizes.append(timeReguralSort);
        sizes.append('\n');
        sizes.append(timeMedianSort);

        String filePath = "...\\measurement.txt";
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath)));
            writer.write(sizes.toString());
            writer.close();
        }
        catch (Exception ex){}
    }

    public static <E extends Comparable<E>> void regularSort(ArrayList<E> data) {
        regularQsort(data, 0, data.size()-1);
    }
      
    public static <E extends Comparable<E>> void regularQsort(ArrayList<E> data, int lo, int hi) {
        if (lo < hi){
            E pivot = data.get(hi);
            int i = lo - 1, j = hi;
            while(true){
                do i++; while(data.get(i).compareTo(pivot) < 0);
                do j--; while(j >= 0 && data.get(j).compareTo(pivot) > 0);
                if (i >= j)
                    break;
                swap(data, i, j);
            }
            swap(data, i, hi);
            regularQsort(data, lo, i-1);
            regularQsort(data, i+1, hi);
        }
    }

    public static <E extends Comparable<E>> void medianSort(ArrayList<E> data) {
        medianQsort(data, 0, data.size()-1);
    }
      
    public static <E extends Comparable<E>> void medianQsort(ArrayList<E> data, int lo, int hi) {
        if (lo < hi) {
                int pivotIndex = choosePivot(data, lo, hi);
                E pivot = data.get(pivotIndex);

                // move pivot elem to end of the list
                swap(data, pivotIndex, hi);

                int i = lo - 1, j = hi;
                while (true) {
                    do i++; while (data.get(i).compareTo(pivot) < 0);
                    do j--; while (j >= lo && data.get(j).compareTo(pivot) > 0);
                    if (i >= j)
                        break;
                    swap(data, i, j);
                }
                swap(data, i, hi);
                medianQsort(data, lo, i-1);
                medianQsort(data, i+1, hi);
            }
    }
      
    public static <E extends Comparable<E>> int choosePivot(ArrayList<E> data, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        E a = data.get(lo);
        E b = data.get(mid);
        E c = data.get(hi);

        if (a.compareTo(b) > 0) {
            if (b.compareTo(c) > 0) {
                return mid; // b is mid
            } else if (a.compareTo(c) > 0) {
                return hi; // c is mid
            } else {
                return lo; // a is mid
            }
        } else {
            if (a.compareTo(c) > 0) {
                return lo; // a is mid
            } else if (b.compareTo(c) > 0) {
                return hi; // c is mid
            } else {
                return mid; // b mid
            }
        }
    }
      
    public static <E extends Comparable<E>> void swap(ArrayList<E> data, int i, int j){
          E tmp = data.get(i);
          data.set(i, data.get(j));
          data.set(j, tmp);
    } 
}