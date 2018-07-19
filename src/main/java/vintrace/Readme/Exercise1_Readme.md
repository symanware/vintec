### Exercise 1

I have completed the four methods in class WineTest.
If you run `WineTest.main()`, these methods would print following output along with its Json representation for the end point.

1. `printYearBreakdown(...)`

    ```
    85.0% - 2016
    15.0% - 2015
    15.0% - 2017
    ```
2. `printVarietyBreakdown(...)`

    ```
    105.0% - Pinot Noir
    10.0% - Chardonnay
    ```

3. `printRegionBreakdown(...)`
   
   ```
    90.0% - Yarra Valley
    20.0% - Macedon
    5.0% - Mornington
   ```
   
4. `printYearAndVarietyBreakdown(...)`
   
      ```
       80.0% - 2016,'Pinot Noir'
       15.0% - 2017,'Pinot Noir'
       10.0% - 2015,'Pinot Noir'
       5.0% - 2016,'Chardonnay'
       5.0% - 2015,'Chardonnay'
      ```   
      
__Note:__ I added few more components as below, so here are all components
   
      w.getComponents().add(new GrapeComponent(80D, 2016, "Pinot Noir", "Yarra Valley"));
      w.getComponents().add(new GrapeComponent(10D, 2015, "Pinot Noir", "Macedon"));
      w.getComponents().add(new GrapeComponent(5D, 2016, "Chardonnay", "Mornington"));
      w.getComponents().add(new GrapeComponent(5D, 2015, "Chardonnay", "Macedon"));
      w.getComponents().add(new GrapeComponent(10D, 2017, "Pinot Noir", "Yarra Valley"));
      w.getComponents().add(new GrapeComponent(5D, 2017, "Pinot Noir", "Macedon"));
