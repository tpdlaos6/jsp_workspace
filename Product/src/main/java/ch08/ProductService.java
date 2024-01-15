package ch08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
	Map<String,Product> products=new HashMap<>();
	
	public ProductService() {
		//model 생성. model에 값 저장
		Product p=new Product("101","아이폰 12","애플",1200000,"2020.12.12");
		products.put("101",p);
		p=new Product("102","갤럭시S24","삼성전자",1300000,"20201.2.2");
		products.put("102",p);
		p=new Product("103","듀얼폰","LG전자",1500000,"2021.3.2");
		products.put("103",p);
	}
	
	//목록
	public List<Product> findAll(){
		return new ArrayList<>(products.values());
		
	}
	
	//상세보기
	public Product find(String id) {
		return products.get(id);
	}
}
