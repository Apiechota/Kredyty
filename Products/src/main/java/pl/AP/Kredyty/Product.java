package pl.AP.Kredyty;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Product {
	@Id
private int creditid;
private String productname;
private int value;
public Product(int creditid, String productname, int value) {
	super();
	this.creditid = creditid;
	this.productname = productname;
	this.value = value;
}
public Product() {
	super();
	// TODO Auto-generated constructor stub
}
public int getCreditid() {
	return creditid;
}
public void setCreditid(int creditid) {
	this.creditid = creditid;
}
public String getProductName() {
	return productname;
}
public void setProductName(String productname) {
	this.productname = productname;
}
public int getValue() {
	return value;
}
public void setValue(int value) {
	this.value = value;
}


@Override
public String toString() {
	return "Product [creditid=" + creditid + ", productname=" + productname + ", value=" + value + "]";
}

}
