package core.item;

public class Item {
	private int itemId;
	private String name;
	private int priceByHour;

	public Item() {
		
	}
	
	public Item(String name, int priceByHour) {
		this.name = name;
		this.priceByHour = priceByHour;
	}
	
	public Item(int itemId, String name, int priceByHour) {
		this.itemId = itemId;
		this.name = name;
		this.priceByHour = priceByHour;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriceByHour() {
		return priceByHour;
	}

	public void setPriceByHour(int priceByHour) {
		this.priceByHour = priceByHour;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + priceByHour;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemId != other.itemId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (priceByHour != other.priceByHour)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [Id=" + itemId + ", name=" + name + ", priceByHour=" + priceByHour + "]";
	}	
}
