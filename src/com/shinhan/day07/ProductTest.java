package com.shinhan.day07;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductVO[] productList = { new ProductVO("마이쭈", 25000, "Samsong"),
				new ProductVO("꿈틀이", 32000, "Samsong"),
				new ProductVO("짱구", 17050, "Samsong"),
				new ProductVO("새우깡", 24500, "Samsong"),
				new ProductVO("고소미", 75000, "Daehoo") };
		productList = selectProduct(productList, 25000);
		for (int i = 0; i < productList.length; i++) {
			System.out.println(productList[i].toString());
		}
	}
	private static ProductVO[] selectProduct(Object[] productList, int i) {
		// 구현하시오.
		int count=0;
		for(int j=0;j<productList.length;j++) {
			ProductVO p = (ProductVO)productList[j];
			if(p.getPrice()>=i)
				count++;
		}
		ProductVO[] list = new ProductVO[count];
		
		int index=0;
		for(int j=0;j<productList.length;j++) {
			ProductVO p = (ProductVO)productList[j];
			if(p.getPrice()>=i) {
				list[index] = p;
				index++;
			}
		}
		
		return list;
	}
}
