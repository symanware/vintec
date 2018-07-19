package vintrace;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Wine implements Serializable {

	private static final long serialVersionUID = -6892434771833441384L;
	
	// this is a simplified model for demonstration purposes

	private Set<GrapeComponent> components = new HashSet<>();
	
	private int id;
	private String lotCode;
	private double volume;
	private String description;
	private Tank tank;
	private ProductState productState;
	private Owner owner;
	
	public Wine(String lotCode, double volume) {
		this.lotCode = lotCode;
		this.volume = volume;
	}
	
	public Set<GrapeComponent> getComponents() {
		return components;
	}

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

	public void setComponents(Set<GrapeComponent> components) {
		this.components = components;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tank getTank() {
		return tank;
	}

	public void setTank(Tank tank) {
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
