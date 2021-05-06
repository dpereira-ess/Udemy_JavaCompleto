package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment = new Date();
	
	public SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
	
	private OrderStatus status;
	
	private List<OrderItem> item = new ArrayList<>();
	
	public Order(OrderStatus status) {
		this.status = status;
	}
	
	public Order() {
		super();
	}

	public Date getMoment() {
		return moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public List<OrderItem> getItem() {
		return item;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public void setItem(List<OrderItem> item) {
		this.item = item;
	}

	public void addItem(OrderItem item) {
		this.item.add(item);
	}
	
	public void removeItem(OrderItem item) {
		this.item.remove(item);
	}
	
	public String toString0() {
		StringBuilder sb = new StringBuilder();
		String sts = status.toString();
		
		sb.append("Order moment: " + sdf2.format(moment) + "\n");
		sb.append("Order statud: " + sts.charAt(0) + sts.toLowerCase().substring(1)+ "\n");
		return sb.toString();
	}
		
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order items \n");
		
		Double sum = 0.0;
		
		for (OrderItem o : item) {
			sb.append(o.getProduct());
			sb.append(", Quantity: ");
			sb.append(o.getQuantity() + ", ");
			sb.append("Subtotal: $ " + String.format("%.2f", o.subTotal()) + "\n");
			sum +=o.subTotal();
		}
		sb.append("Total Price: $ " + String.format("%.2f", sum));
		return sb.toString();
	}
}
