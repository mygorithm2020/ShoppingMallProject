package com.ezen.market.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.market.dao.ProdDao;
import com.ezen.market.dto.LocationVo;
import com.ezen.market.dto.ProductVo;
import com.ezen.market.dto.RentVo;

@Service
public class ProductSer {
	
	@Autowired
	ProdDao pd;
	
	public ArrayList<ProductVo> productSearchList(String pname,String gu){
		ArrayList<ProductVo> list = pd.productSearchList(pname,gu);		
		return list;
	}
	
	public void updateProduct(ProductVo pvo) {
		pd.updateProduct(pvo);
	}
	
	public ProductVo getProduct(String pseq) {
		ProductVo pvo = pd.getProduct(pseq);
		return pvo;
	}
	
	public ProductVo subListProduct(int num){
		ProductVo pvo = pd.subListProduct(num);
		return pvo;
	}
	
	public void deleteRent(int k){
		pd.deleteRent(k);
	}
	
	public ArrayList<RentVo> rentList(String id){
		ArrayList<RentVo> list = pd.rentList(id);
		return list;
	}
	
	public ArrayList<ProductVo> listProduct(String id){
		ArrayList<ProductVo> list = pd.listProduct(id); 
		return list;
	}
	
	public void insertProduct(ProductVo pvo){
		pd.insertProduct(pvo);
	}
	
	public ArrayList<LocationVo> locationList(){
		ArrayList<LocationVo> list = pd.locationList();
		return list;
	}
	
	public ArrayList<ProductVo> listNewProduct(){
		ArrayList<ProductVo> list = pd.listNewProduct();
		return list;
	}
	public ArrayList<ProductVo> listBestProduct(){
		ArrayList<ProductVo> list = pd.listBestProduct();
		return list;
	}
	
	

}
