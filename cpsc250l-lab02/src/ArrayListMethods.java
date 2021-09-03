import java.util.ArrayList;

public class ArrayListMethods {
    public static void doReverse(ArrayList<Integer> list) {

        if (list.size() == 0) {
            return;
        }

        ArrayList<Integer> array = new ArrayList<>(list.size());

        for(int i = list.size() - 1; i >= 0; i--) {
            array.add(list.get(i));
        }

        list.clear();
        for (Integer i : array) {
            list.add(i);
        }
    }
    public static ArrayList<Integer> getUnion(
            ArrayList<Integer> one, ArrayList<Integer> two){

        ArrayList<Integer> array = new ArrayList<>();

        for (int i = one.size() - 1; i >= 0; i--) {
            for(int j = i - 1; j >=0; j--) {
                if (one.get(i) == one.get(j)) {
                    one.remove(i);
                }
            }
        }

        for (int i = two.size() - 1; i >= 0; i--) {
            for(int j = i - 1; j >=0; j--) {
                if (two.get(i) == two.get(j)) {
                    two.remove(i);
                }
            }
        }

        if(one.size() == 0 && two.size() == 0) {
            return array;
        }
        if(one.size() == 0 && two.size() != 0) {
            return two;
        }
        if(one.size() != 0 && two.size() == 0) {
            return one;
        }

        for (Integer i : one) {
            array.add(i);
        }
        for (int i = 0; i < two.size(); i++) {
            if(!(array.contains(two.get(i)))) {
                array.add(two.get(i));
            }
        }
        return array;
    }

    public static ArrayList<Double> getIntersection(
            ArrayList<Double> one, ArrayList<Double> two){

        ArrayList<Double> array = new ArrayList<>();

        for (int i = one.size() - 1; i >= 0; i--) {
            for(int j = i - 1; j >=0; j--) {
                if (one.get(i) == one.get(j)) {
                    one.remove(i);
                }
            }
        }

        for (int i = two.size() - 1; i >= 0; i--) {
            for(int j = i - 1; j >=0; j--) {
                if (two.get(i) == two.get(j)) {
                    two.remove(i);
                }
            }
        }

        if(one.size() == 0 && two.size() == 0) {
            return array;
        }
        for(int i = 0; i < one.size(); i++) {
            if(two.contains(one.get(i))) {
                array.add(one.get(i));
            }
        }
        return array;
    }

    public static ArrayList<String> getDifference(
            ArrayList<String> one, ArrayList<String> two){

        ArrayList<String> array = new ArrayList<>();

        for (int i = two.size() - 1; i >= 0; i--) {
            for(int j = i - 1; j >=0; j--) {
                if (two.get(i).equals(two.get(j))) {
                    two.remove(i);
                }
            }
        }

        for (int i = one.size() - 1; i >= 0; i--) {
            for(int j = i - 1; j >=0; j--) {
                if (one.get(i).equals(one.get(j))) {
                    one.remove(i);
                }
            }
        }

        if(one.size() == 0 && two.size() != 0) {
            return two;
        }
        
        if(two.size() == 0 && one.size() != 0) {
            return one;
        }
        
        for (int i = 0; i < one.size(); i++) {
            if (!(two.contains(one.get(i)))) {
                array.add(one.get(i));
            }
        }
        for (int i = 0; i < two.size(); i++) {
            if (!(one.contains(two.get(i)))) {
                array.add(two.get(i));
            }
        }

        return array;
    }
} 
