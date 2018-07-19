package vintrace;

import com.fasterxml.jackson.core.JsonProcessingException;
import vintrace.adapter.WineDetailAdapter;
import vintrace.converter.DtoJsonConverter;
import vintrace.dto.WineDetail;
import vintrace.helper.ValueComparator;

import java.util.*;

public class WineTest {

    public static void main(String[] args) {

        // test data
        Tank t = new Tank();
        t.setId(22);
        t.setCode("T25-01");
        t.setCapacity(25000D);

        ProductState ps = new ProductState();
        ps.setId(44);
        ps.setDescription("Ready to bottle");

        Owner o = new Owner();
        o.setId(66);
        o.setName("Zane Francis");
        o.setEmailAddress("zane@vintrace.com");

        Wine w = new Wine("16ZFYVPN", 10350D);
        w.setId(88);
        w.setDescription("2016 Yarra Valley Pinot Noir");
        w.setTank(t);
        w.setProductState(ps);
        w.setOwner(o);

        t.setContents(w);

        w.getComponents().add(new GrapeComponent(80D, 2016, "Pinot Noir", "Yarra Valley"));
        w.getComponents().add(new GrapeComponent(10D, 2015, "Pinot Noir", "Macedon"));
        w.getComponents().add(new GrapeComponent(5D, 2016, "Chardonnay", "Mornington"));
        w.getComponents().add(new GrapeComponent(5D, 2015, "Chardonnay", "Macedon"));
        // addition test data
        w.getComponents().add(new GrapeComponent(10D, 2017, "Pinot Noir", "Yarra Valley"));
        w.getComponents().add(new GrapeComponent(5D, 2017, "Pinot Noir", "Macedon"));

        printYearBreakdown(w);
        printVarietyBreakdown(w);
        printRegionBreakdown(w);
        printYearAndVarietyBreakdown(w);

        printWineDetailsJson(w);
    }

    private static void printWineDetailsJson(Wine w) {
        //transform to DTO
        WineDetail wineDetail = WineDetailAdapter.from(w);
        DtoJsonConverter.convertAndPrintObject(wineDetail);
    }

    private static void printVarietyBreakdown(Wine w) {
        //Calculate sum of percentage for each variety
        Map<String, Double> varietyWisePercentage = new HashMap<>();
        Iterator<GrapeComponent> itr = w.getComponents().iterator();
        while (itr.hasNext()) {
            GrapeComponent component = itr.next();
            if (!varietyWisePercentage.containsKey(component.getVariety())) {
                varietyWisePercentage.put(component.getVariety(), component.getPercentage());
            } else {
                varietyWisePercentage.put(component.getVariety(), varietyWisePercentage.get(component.getVariety()) + component.getPercentage());
            }
        }
        //Sort the result map in the descending order of percentage
        Comparator<String> comparator = new ValueComparator<String, Double>(varietyWisePercentage);
        TreeMap<String, Double> sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(varietyWisePercentage);
        printResult("Variety Breakdown", sortedMap);
        DtoJsonConverter.convertVarietyBreakdownToJson(sortedMap);
    }

    private static void printYearBreakdown(Wine w) {
        //Calculate sum of percentage for each year
        Map<Integer, Double> yearWisePercentage = new HashMap<>();
        Iterator<GrapeComponent> itr = w.getComponents().iterator();
        while (itr.hasNext()) {
            GrapeComponent component = itr.next();
            if (!yearWisePercentage.containsKey(component.getYear())) {
                yearWisePercentage.put(component.getYear(), component.getPercentage());
            } else {
                yearWisePercentage.put(component.getYear(), yearWisePercentage.get(component.getYear()) + component.getPercentage());
            }
        }
        //Sort the result map in the descending order of percentage
        Comparator<Integer> comparator = new ValueComparator<Integer, Double>(yearWisePercentage);
        TreeMap<Integer, Double> sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(yearWisePercentage);
        printResult("Year Breakdown", sortedMap);

        //convert to Json and print json
        DtoJsonConverter.convertYearBreakdownToJson(sortedMap);
    }

    private static void printRegionBreakdown(Wine w) {
        //Calculate sum of percentage for each region
        Map<String, Double> regionWisePercentage = new HashMap<>();
        Iterator<GrapeComponent> itr = w.getComponents().iterator();
        while (itr.hasNext()) {
            GrapeComponent component = itr.next();
            if (!regionWisePercentage.containsKey(component.getRegion())) {
                regionWisePercentage.put(component.getRegion(), component.getPercentage());
            } else {
                regionWisePercentage.put(component.getRegion(), regionWisePercentage.get(component.getRegion()) + component.getPercentage());
            }
        }
        //Sort the result map in the descending order of percentage
        Comparator<String> comparator = new ValueComparator<String, Double>(regionWisePercentage);
        TreeMap<String, Double> sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(regionWisePercentage);
        printResult("Region Breakdown", sortedMap);
        DtoJsonConverter.convertRegionBreakdownToJson(sortedMap);
    }

    private static void printYearAndVarietyBreakdown(Wine w) {
        //Calculate sum of percentage for each year+variety
        Map<GrapeComponentYearVariety, Double> yearAndVarietyWisePercentage = new HashMap<>();
        Iterator<GrapeComponent> itr = w.getComponents().iterator();
        while (itr.hasNext()) {
            GrapeComponent component = itr.next();
            GrapeComponentYearVariety grapeComponentYearVariety = new GrapeComponentYearVariety(component.getYear(), component.getVariety());
            if (!yearAndVarietyWisePercentage.containsKey(grapeComponentYearVariety)) {
                yearAndVarietyWisePercentage.put(grapeComponentYearVariety, component.getPercentage());
            } else {
                yearAndVarietyWisePercentage.put(grapeComponentYearVariety, yearAndVarietyWisePercentage.get(grapeComponentYearVariety) + component.getPercentage());
            }
        }
        //Sort the result map in the descending order of percentage
        Comparator<GrapeComponentYearVariety> comparator = new ValueComparator<>(yearAndVarietyWisePercentage);
        TreeMap<GrapeComponentYearVariety, Double> sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(yearAndVarietyWisePercentage);
        printResult("Year and Variety Breakdown", sortedMap);
        DtoJsonConverter.convertYearAndVarietyBreakdownToJson(sortedMap);
    }

    private static <K, V> void printResult(String title, Map<K, V> map) {
        System.out.println("------------- " + title + " --------------");
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("" + entry.getValue() + "% - " + entry.getKey());
        }
    }
}
