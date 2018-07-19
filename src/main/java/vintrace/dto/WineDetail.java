package vintrace.dto;

import vintrace.Owner;
import vintrace.ProductState;

public class WineDetail {
    private String lotCode;
    private double volume;
    private String description;
    private String tank;
    private ProductState productState;
    private Owner owner;

    public String getLotCode() {
        return lotCode;
    }

    public void setLotCode(String lotCode) {
        this.lotCode = lotCode;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTank() {
        return tank;
    }

    public void setTank(String tank) {
        this.tank = tank;
    }

    public ProductState getProductState() {
        return productState;
    }

    public void setProductState(ProductState productState) {
        this.productState = productState;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}


