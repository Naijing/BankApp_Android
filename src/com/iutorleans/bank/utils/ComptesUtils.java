package com.iutorleans.bank.utils;

import java.util.ArrayList;

import com.iutorleans.bank.bean.ComptesBean;

public class ComptesUtils {
	
	public static ArrayList<ComptesBean> getAllComptes() {
		
		ArrayList<ComptesBean> arrayList=new ArrayList<ComptesBean>();
		
		for(int i=0; i<20; i++){
			
		ComptesBean comptesBean = new ComptesBean();
		comptesBean.nom="julien";
		comptesBean.solde=2000;
		arrayList.add(comptesBean);
		
		}
		
		
		
		return arrayList;
	}

}
