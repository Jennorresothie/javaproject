package com.shinhan.day12;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;

public class Prob4 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Product[] prodList = { new Product("NT450R5E-K24S", 500000, "삼성전자"),
				new Product("15UD340-LX2CK", 400000, "LG전자"), new Product("G2-K3T32AV", 600000, "HP") };

		HashSet<Product> product_hs = makeHashSet(prodList, 500000);
		makeFile(product_hs);
		readFile();

	}

	private static HashSet<Product> makeHashSet(Product[] prodList, int price) {
		HashSet<Product> temp = new HashSet<>();
		System.out.println("*특정 금액 이상의 상품 결과입니다.**************");
		for (Product p : prodList) {
			if (price <= p.getPrice()) {
				temp.add(p);
				System.out.println(p);
			}
		}
		System.out.println();
		return temp;
	}

	private static void makeFile(HashSet<Product> resultList) {
		try (FileOutputStream fw = new FileOutputStream("data.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fw);) {
			for (Product p : resultList)
				oos.writeObject(p);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void readFile() {
		try (FileInputStream fs = new FileInputStream("data.txt"); ObjectInputStream ois = new ObjectInputStream(fs);) {

			while (true) {
				Object obj = ois.readObject();
				if (obj instanceof Product pro)
					System.out.println(pro);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String model_name;
	private int price;
	private String company;

	public Product(String model_name, int price, String company) {
		super();
		this.model_name = model_name;
		this.price = price;
		this.company = company;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Product [model_name=" + model_name + ", price=" + price + ", company=" + company + "]";
	}

}