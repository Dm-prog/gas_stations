import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GasStationsTest {

    @org.junit.Test(expected = RuntimeException.class)
    public void whenDifferenceBetweenNAndKIsLessThan2() {
        List<Integer> gasCoord = Arrays.asList(40, 80, 50, 60);
        GasStations stations = new GasStations(gasCoord);
        stations.del(4, 3);
    }

    @org.junit.Test(expected = RuntimeException.class)
    public void whenKLessThen1() {
        List<Integer> gasCoord = Arrays.asList(12, 96, 6, 34, 73);
        GasStations stations = new GasStations(gasCoord);
        stations.del(4, 0);
    }

    @org.junit.Test
    public void whenFourGasStationsAndOneDel() {
        List<Integer> gasCoord = Arrays.asList(40, 80, 50, 60);
        GasStations stations = new GasStations(gasCoord);
        List<Integer> expected = Arrays.asList(3);
        List<Integer> result = stations.del(4, 1);
        int expDist = 20;
        int resDist = stations.getMaxDistance();
        assertEquals(expected, result);
        assertEquals(expDist, resDist);

    }

    @org.junit.Test
    public void whenFiveGasStationsAndThreeDel() {
        List<Integer> gasCoord = Arrays.asList(12, 96, 6, 34, 73);
        GasStations stations = new GasStations(gasCoord);
        List<Integer> expected = Arrays.asList(1, 4, 5);
        List<Integer> result = stations.del(5, 3);
        int expDist = 90;
        int resDist = stations.getMaxDistance();
        assertEquals(expected, result);
        assertEquals(expDist, resDist);
    }

    @org.junit.Test
    public void whenThreeGasStationsWithSameCoordinatesAndOneDel() {
        List<Integer> gasCoord = Arrays.asList(2, 2, 2);
        GasStations stations = new GasStations(gasCoord);
        List<Integer> expected = Arrays.asList(1);
        List<Integer> result = stations.del(3, 1);
        int expDist = 0;
        int resDist = stations.getMaxDistance();
        assertEquals(expected, result);
        assertEquals(expDist, resDist);
    }

}