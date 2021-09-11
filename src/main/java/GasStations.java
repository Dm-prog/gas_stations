import java.util.*;

public class GasStations {

    private List<Integer> gasCoord;
    private int maxDistance;

    public GasStations(List<Integer> gasCoord) {
        this.gasCoord = gasCoord;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public int findMinDiff(List<Integer> gasCoord, int n) {
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (Math.abs((gasCoord.get(i) - gasCoord.get(j))) < diff)
                    diff = Math.abs((gasCoord.get(i) - gasCoord.get(j)));
        return diff;
    }

    public List<Integer> del(int n, int k) {
        List<Integer> numOfGas = new ArrayList<>();
        List<Integer> origSizeOfGAs = new ArrayList<>(gasCoord);
        List<Integer> copy = new ArrayList<>(gasCoord);

        int count = 0;

        if (n < 3 || n > 100000) {
            throw new RuntimeException("Некорректное число станций");
        } else if (k < 1 || k > n - 2) {
            throw new RuntimeException("Некорректное число число удаляемых станций");
        }

        while (k > 0) {
            Collections.sort(copy);
            int min = findMinDiff(gasCoord, n);

            for (int i = 0; i < copy.size() - 1; i++) {
                if (copy.get(i + 1) - copy.get(i) == min && copy.get(i) != copy.get(copy.size() - 2)) {
                    count = copy.get(i + 1);
                    for (int j = 0; j < gasCoord.size() - 1; j++) {
                        if (gasCoord.get(0) == count) {
                            maxDistance = Math.abs(gasCoord.get(i + 2) - gasCoord.get(i + 1));
                            break;
                        } else if (gasCoord.get(gasCoord.size() - 1) == count) {
                            maxDistance = Math.abs(gasCoord.get(gasCoord.size() - 3)
                                    - gasCoord.get(gasCoord.size() - 2));
                            break;
                        } else if (gasCoord.get(j) == count) {
                            maxDistance = Math.abs(gasCoord.get(j + 1) - gasCoord.get(j - 1));
                            break;
                        }
                    }
                    break;
                } else {
                    count = copy.get(i);
                }
            }

            for (int i = 0; i < origSizeOfGAs.size(); i++) {
                if (origSizeOfGAs.get(i) == count) {
                    numOfGas.add(i + 1);
                    if (min == 0) {
                        break;
                    }
                    Collections.sort(numOfGas);
                }
            }

            Iterator<Integer> iterator = copy.iterator();
            while (iterator.hasNext()) {
                Integer e = iterator.next();
                if (e == count) {
                    iterator.remove();
                }
            }
            k--;
            n--;
        }
        System.out.println(maxDistance);
        System.out.println(numOfGas);
        return numOfGas;
    }
}
