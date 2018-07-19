package vintrace.dto;

import java.util.LinkedList;
import java.util.List;

public class Result {
    private List<List<Property>> results;

    public Result() {
        results = new LinkedList<>();
    }

    public List<List<Property>> getResults() {
        return results;
    }

    public List<Property> createRow() {
        List<Property> row = new LinkedList<>();
        this.results.add(row);
        return row;
    }
}
