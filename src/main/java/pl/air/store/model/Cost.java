package pl.air.store.model;

public class Cost extends Id{

	private Double CostValue;
 
    public Cost() {
    }
    
    public Cost(Double value) {
    	
    	this.CostValue = value;
    }

	public Double getCostValue() {
		return CostValue;
	}

	public void setCostValue(Double costValue) {
		CostValue = costValue;
	}

    
}
