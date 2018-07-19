package vintrace.test;

import vintrace.converter.DtoJsonConverter;
import vintrace.dto.WineDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to just generate sample Json
 */
public class ProductStateTest {

    public static void main(String[] args) {
        WineDetail wineDetail = new WineDetail();
        wineDetail.setLotCode("16AAPKPN");
        wineDetail.setVolume(14300L);
        wineDetail.setTank("T35-02");

        List<WineDetail> wineDetails = new ArrayList<>();
        wineDetails.add(wineDetail);

        wineDetail = new WineDetail();
        wineDetail.setLotCode("16BBOOPN");
        wineDetail.setVolume(8375L);
        wineDetail.setTank("T35-03");
        wineDetails.add(wineDetail);

        DtoJsonConverter.convertAndPrintObject(wineDetails);

    }
}
