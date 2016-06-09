package com.iutorleans.bank.utils;

import java.util.ArrayList;

import com.iutorleans.bank.bean.ComptesBean;

public class ComptesUtils {
	
	public static ArrayList<ComptesBean> getAllComptes() {
		
		ArrayList<ComptesBean> arrayList=new ArrayList<ComptesBean>();
		
		for(int i=0; i<20; i++){
			
		ComptesBean comptesBean = new ComptesBean();
		comptesBean.nom="Julien";
		comptesBean.solde=2000;
		arrayList.add(comptesBean);
		
		ComptesBean comptesBean1 = new ComptesBean();
		comptesBean1.nom="Lili";
		comptesBean1.solde=800;
		arrayList.add(comptesBean1);
		
		}
		
		
		
		return arrayList;
	}

}
