package dk.grell.EnergyAPI;

import java.util.Date;

public class MeteringPoint {
	
	private Date startDate;

	private int   position;

	private float quantity;



	public int getPosition() {return position;}
	public void setPosition(int position) {this.position = position;}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	

}
