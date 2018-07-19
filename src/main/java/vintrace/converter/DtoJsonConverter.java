package vintrace.converter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import vintrace.GrapeComponentYearVariety;
import vintrace.dto.Property;
import vintrace.dto.Result;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DtoJsonConverter {

    public static ObjectMapper objectMapper = new ObjectMapper();
    static
    {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static String convertYearBreakdownToJson(Map<Integer, Double> yearBreakdown) {
        Result result = new Result();
        for (Map.Entry<Integer, Double> entry : yearBreakdown.entrySet()) {
            List<Property> row = result.createRow();
            Property property = new Property("Year", entry.getKey().toString());
            row.add(property);
            property = new Property("Percentage", entry.getValue().toString());
            row.add(property);
        }
        return convertAndPrintObject(result);
    }

    public static String convertVarietyBreakdownToJson(Map<String, Double> varietyBreakdown) {
        Result result = new Result();
        for (Map.Entry<String, Double> entry : varietyBreakdown.entrySet()) {
            List<Property> row = result.createRow();
            Property property = new Property("Variety", entry.getKey().toString());
            row.add(property);
            property = new Property("Percentage", entry.getValue().toString());
            row.add(property);
        }
        return convertAndPrintObject(result);
    }

    public static String convertRegionBreakdownToJson(Map<String, Double> regionBreakdown) {
        Result result = new Result();
        for (Map.Entry<String, Double> entry : regionBreakdown.entrySet()) {
            List<Property> row = result.createRow();
            Property property = new Property("Region", entry.getKey().toString());
            row.add(property);
            property = new Property("Percentage", entry.getValue().toString());
            row.add(property);
        }
        return convertAndPrintObject(result);
    }

    public static String convertYearAndVarietyBreakdownToJson(TreeMap<GrapeComponentYearVariety, Double> yearAndVarietyBreakdown) {
        Result result = new Result();
        for (Map.Entry<GrapeComponentYearVariety, Double> entry : yearAndVarietyBreakdown.entrySet()) {
            List<Property> row = result.createRow();
            Property property = new Property("Year", entry.getKey().getYear());
            row.add(property);
            property = new Property("Variety", entry.getKey().getVariety());
            row.add(property);
            property = new Property("Percentage", entry.getValue().toString());
            row.add(property);
        }
        return convertAndPrintObject(result);
    }
    public static String convertAndPrintObject(Object result) {
        String resultStr = null;
        try {
            resultStr = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
            //resultStr = objectMapper.writeValueAsString(result); // prod
            System.out.println("-----JSON---------");
            System.out.println(resultStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resultStr;
    }

}
