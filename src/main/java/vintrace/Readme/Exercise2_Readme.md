### Exercise 2

I have written a few additional classes to complete this exercise.
All classes includes description at the top about their role in the application/test

#### List of Endpoint Urls
######1.  Get Wine Details

__URL__: `http://vintrace/api/v1/wine/88`

```java
    @GetMapping("/{wineId}")
    public WineDetail getWideDetails(@PathVariable(value = "wineId") Long wineId) {
        ....
    }
```

######2.  Get Wines by Product State

__URL__: `http://vintrace/api/v1/wine/productstate/44`

```java
   @GetMapping("/productstate/{stateId}")
       public List<WineDetail> getWinesByState(@PathVariable(value = "stateId") Long stateId) {
           ....
    }
```

######3.  Get Wines by Owner

__URL__: `http://vintrace/api/v1/wine/owner/66`

```java
       @GetMapping("/owner/{ownerId}")
       public List<WineDetail> getWinesByOwner(@PathVariable(value = "ownerId") Long ownerId) {
           ...
       }
```
######4.  Get breakdown

__URL__: `http://vintrace/api/v1/wine/breakdown/year`

_Note:_ year in above url is a parameter that can be year/variety/region/year_variety

```java
   @GetMapping("/{wineId}/breakdown/{type}")
       public Result getBreakdown(@PathVariable(value = "wineId") Long wineId, 	@PathVariable(value = "type") String breakdownType) {
           return ...
       }
```

#### Data Transfer Objects (DTOs)
For the first three endpoint, `WineDetail` is the DTO.
Here, I am relying on JSON converter to exclude the null values in WineDetail object wherever applicable. 

```java
    public class WineDetail {
        private String lotCode;
        private double volume;
        private String description;
        private String tank;
        private ProductState productState;
        private Owner owner;
    }
```

For Fourth endpoint, I am using `Result` and `Property`

```java
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

public class Property {
    private String name;
    private String value;
}
```

#### Sample JSON data 
######1.  Get Wine Details

```json
{
  "lotCode" : "16ZFYVPN",
  "volume" : 10350.0,
  "description" : "2016 Yarra Valley Pinot Noir",
  "tank" : "T25-01",
  "productState" : {
    "id" : 44,
    "description" : "Ready to bottle"
  },
  "owner" : {
    "id" : 66,
    "name" : "Zane Francis",
    "emailAddress" : "zane@vintrace.com"
  }
}
```

######2.  Get Wines by Product State

```json
[ {
  "lotCode" : "16AAPKPN",
  "volume" : 14300.0,
  "tank" : "T35-02"
}, {
  "lotCode" : "16BBOOPN",
  "volume" : 8375.0,
  "tank" : "T35-03"
} ]
```

######3.  Get Wines by Owner

```json
[ {
  "lotCode" : "16AAPKPN",
  "volume" : 14300.0,
  "tank" : "T35-02"
}, {
  "lotCode" : "16ZFMNPN",
  "volume" : 11300.0,
  "tank" : "T25-02"
} ]
```
    
######4.  Get breakdown
__Example 1:__ Get Year Breakdown
    
```json
{
  "results" : [ [ {
    "name" : "Year",
    "value" : "2016"
  }, {
    "name" : "Percentage",
    "value" : "85.0"
  } ], [ {
    "name" : "Year",
    "value" : "2015"
  }, {
    "name" : "Percentage",
    "value" : "15.0"
  } ], [ {
    "name" : "Year",
    "value" : "2017"
  }, {
    "name" : "Percentage",
    "value" : "15.0"
  } ] ]
}
```

__Example 2:__ Get Variety Breakdown

```json
{
  "results" : [ [ {
    "name" : "Variety",
    "value" : "Pinot Noir"
  }, {
    "name" : "Percentage",
    "value" : "105.0"
  } ], [ {
    "name" : "Variety",
    "value" : "Chardonnay"
  }, {
    "name" : "Percentage",
    "value" : "10.0"
  } ] ]
}
```

__Example 3:__ Get Region Breakdown

```json
{
  "results" : [ [ {
    "name" : "Region",
    "value" : "Yarra Valley"
  }, {
    "name" : "Percentage",
    "value" : "90.0"
  } ], [ {
    "name" : "Region",
    "value" : "Macedon"
  }, {
    "name" : "Percentage",
    "value" : "20.0"
  } ], [ {
    "name" : "Region",
    "value" : "Mornington"
  }, {
    "name" : "Percentage",
    "value" : "5.0"
  } ] ]
}
```

__Example 4:__ Get Year Variety Breakdown

```json
{
  "results" : [ [ {
    "name" : "Year",
    "value" : "2016"
  }, {
    "name" : "Variety",
    "value" : "Pinot Noir"
  }, {
    "name" : "Percentage",
    "value" : "80.0"
  } ], [ {
    "name" : "Year",
    "value" : "2017"
  }, {
    "name" : "Variety",
    "value" : "Pinot Noir"
  }, {
    "name" : "Percentage",
    "value" : "15.0"
  } ], [ {
    "name" : "Year",
    "value" : "2015"
  }, {
    "name" : "Variety",
    "value" : "Pinot Noir"
  }, {
    "name" : "Percentage",
    "value" : "10.0"
  } ], [ {
    "name" : "Year",
    "value" : "2016"
  }, {
    "name" : "Variety",
    "value" : "Chardonnay"
  }, {
    "name" : "Percentage",
    "value" : "5.0"
  } ], [ {
    "name" : "Year",
    "value" : "2015"
  }, {
    "name" : "Variety",
    "value" : "Chardonnay"
  }, {
    "name" : "Percentage",
    "value" : "5.0"
  } ] ]
}
```

#### WineDetail DTO and Adapter 
_For the endpoint that shows the details for a specific wine, write an adaptor class that will adapt a Wine object to the appropriate DTO._

* DTO: `vintrace\dto\WineDetail.java`
* Adapter: `vintrace\adapter\WineDetailAdapter.java`