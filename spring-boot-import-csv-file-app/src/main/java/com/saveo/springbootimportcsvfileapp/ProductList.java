package com.saveo.springbootimportcsvfileapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_list")
public class ProductList {
	
	@Id
	
	@Column(name ="c_name")
	private String c_name;
	
	@Column(name ="c_batch_no")
	private String c_batch_no;
	
	@Column(name ="d_expiry_date")
	private String d_expiry_date;
	
	@Column(name ="n_balance_qty")
	private int n_balance_qty;
	
	@Column(name ="c_packaging")
	private String c_packaging;
	
	@Column(name ="c_unique_code")
	private String c_unique_code;
	
	@Column(name ="c_schemes")
	private String c_schemes;
	
	@Column(name ="n_mrp")
	private float n_mrp;
	
	@Column(name ="c_manufacturer")
	private String c_manufacturer;
	
	@Column(name ="hsn_code")
	private long hsn_code;

	public ProductList() {
		super();
	}

	public ProductList(String c_name, String c_batch_no, String d_expiry_date, int n_balance_qty, String c_packaging,
			String c_unique_code, String c_schemes, float n_mrp, String c_manufacturer, long hsn_code) {
		super();
		this.c_name = c_name;
		this.c_batch_no = c_batch_no;
		this.d_expiry_date = d_expiry_date;
		this.n_balance_qty = n_balance_qty;
		this.c_packaging = c_packaging;
		this.c_unique_code = c_unique_code;
		this.c_schemes = c_schemes;
		this.n_mrp = n_mrp;
		this.c_manufacturer = c_manufacturer;
		this.hsn_code = hsn_code;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_batch_no() {
		return c_batch_no;
	}

	public void setC_batch_no(String c_batch_no) {
		this.c_batch_no = c_batch_no;
	}

	public String getD_expiry_date() {
		return d_expiry_date;
	}

	public void setD_expiry_date(String d_expiry_date) {
		this.d_expiry_date = d_expiry_date;
	}

	public int getN_balance_qty() {
		return n_balance_qty;
	}

	public void setN_balance_qty(int n_balance_qty) {
		this.n_balance_qty = n_balance_qty;
	}

	public String getC_packaging() {
		return c_packaging;
	}

	public void setC_packaging(String c_packaging) {
		this.c_packaging = c_packaging;
	}

	public String getC_unique_code() {
		return c_unique_code;
	}

	public void setC_unique_code(String c_unique_code) {
		this.c_unique_code = c_unique_code;
	}

	public String getC_schemes() {
		return c_schemes;
	}

	public void setC_schemes(String c_schemes) {
		this.c_schemes = c_schemes;
	}

	public float getN_mrp() {
		return n_mrp;
	}

	public void setN_mrp(float n_mrp) {
		this.n_mrp = n_mrp;
	}

	public String getC_manufacturer() {
		return c_manufacturer;
	}

	public void setC_manufacturer(String c_manufacturer) {
		this.c_manufacturer = c_manufacturer;
	}

	public long getHsn_code() {
		return hsn_code;
	}

	public void setHsn_code(long hsn_code) {
		this.hsn_code = hsn_code;
	}

	@Override
	public String toString() {
		return "ProductList [c_name=" + c_name + ", c_batch_no=" + c_batch_no + ", d_expiry_date=" + d_expiry_date
				+ ", n_balance_qty=" + n_balance_qty + ", c_packaging=" + c_packaging + ", c_unique_code="
				+ c_unique_code + ", c_schemes=" + c_schemes + ", n_mrp=" + n_mrp + ", c_manufacturer=" + c_manufacturer
				+ ", hsn_code=" + hsn_code + "]";
	}

	public static Object showAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
