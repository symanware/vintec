package vintrace.test;


import vintrace.*;
import vintrace.adapter.WineDetailAdapter;
import vintrace.converter.DtoJsonConverter;
import vintrace.dto.WineDetail;

public class WineDetailTest {

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

        printWineDetailsJson(w);
    }

    private static void printWineDetailsJson(Wine w) {
        //transform to DTO
        WineDetail wineDetail = WineDetailAdapter.from(w);
        DtoJsonConverter.convertAndPrintObject(wineDetail);
    }
}


