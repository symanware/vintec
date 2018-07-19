package vintrace.adapter;

import vintrace.Wine;
import vintrace.dto.WineDetail;

public class WineDetailAdapter {
    public static WineDetail from(Wine wine) {
        WineDetail wineDetail = new WineDetail();
        wineDetail.setLotCode(wine.getLotCode());
        wineDetail.setVolume(wine.getVolume());
        wineDetail.setDescription(wine.getDescription());
        wineDetail.setTank(wine.getTank().getCode());
        wineDetail.setProductState(wine.getProductState());
        wineDetail.setOwner(wine.getOwner());
        return wineDetail;
    }

}
