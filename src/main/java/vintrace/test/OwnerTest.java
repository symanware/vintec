package vintrace.test;

import vintrace.converter.DtoJsonConverter;
import vintrace.dto.WineDetail;

import java.util.ArrayList;
import java.util.List;

public class OwnerTest {

    public static void main(String[] args) {
        WineDetail wineDetail = new WineDetail();
        wineDetail.setLotCode("16AAPKPN");
        wineDetail.setVolume(14300L);
        wineDetail.setTank("T35-02");

        List<WineDetail> wineDetails = new ArrayList<>();
        wineDetails.add(wineDetail);

        wineDetail = new WineDetail();
        wineDetail.setLotCode("16ZFMNPN");
        wineDetail.setVolume(11300L);
        wineDetail.setTank("T25-02");
        wineDetails.add(wineDetail);
        DtoJsonConverter.convertAndPrintObject(wineDetails);
    }
}
