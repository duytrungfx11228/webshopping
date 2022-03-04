package model;

public class ProductOrders {
	private Product product;
	private int amountProduct;
	private float price;
	public ProductOrders() {
		
	}
	public ProductOrders(Product product, int amountProduct, float price) {
		super();
		this.product = product;
		this.amountProduct = amountProduct;
		this.price = price;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getAmountProduct() {
		return amountProduct;
	}
	public void setAmountProduct(int amountProduct) {
		this.amountProduct = amountProduct;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductOrders [product=" + product + ", amountProduct=" + amountProduct + ", price=" + price + "]";
	}
	
	
}
