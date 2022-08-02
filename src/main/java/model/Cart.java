package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<ProductOrders> items;
	
	public Cart() {
		items = new ArrayList<ProductOrders>();
	}

	public Cart(List<ProductOrders> items) {
		
		this.items = items;
	}
	// lay 1 san pham trong cart
	private ProductOrders getItemsById(int id) {
		for (ProductOrders i : items) {
			if(i.getProduct().getId()==id) {
				return i;
			}
		}
		return null;
	}
	// tra ve so luong khi biet id
	public int getQuantityByid(int id) {
		
		return getItemsById(id).getAmountProduct();
	}
	// them mot san pham vao cart
	public void add(ProductOrders ci) {
		for (ProductOrders p : items) {
			if(getItemsById(ci.getProduct().getId())!= null) {
				p = getItemsById(ci.getProduct().getId());
				p.setAmountProduct(p.getAmountProduct() + ci.getAmountProduct());
				return;
			}
		}
		items.add(ci);
		
	}
	// xoa mot san pham ra khoi cart
	public void remmoveItems (int id) {
		for (ProductOrders p : items) {
			if(getItemsById(id)!= null) {
				p = getItemsById(id);
				items.remove(p);
				return;
			}
		}
		
	}
	// ham tra ve tong tien cua card
	public double getAmount () {
		double s = 0;
		for (ProductOrders x : items) {
			s += x.getPrice() * x.getAmountProduct();
		}
		return Math.round(s*100.0) / 100.0;
	}

	public List<ProductOrders> getItems() {
		return items;
	}

	
	
}
