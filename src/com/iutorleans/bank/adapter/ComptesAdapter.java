package com.iutorleans.bank.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.iutorleans.bank.R;
import com.iutorleans.bank.bean.ComptesBean;

public class ComptesAdapter extends BaseAdapter {
	
	private ArrayList<ComptesBean> list;
	private Context context;

	public ComptesAdapter(Context context, ArrayList<ComptesBean> list) {
		
		this.list=list;
		this.context=context;
		

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View view = null;
		
		if(convertView!=null){
			view = convertView;
			
		}else{
			
			view = View.inflate(context, R.layout.item_comptes_layout, null);
			
		}
		
		TextView item_tv_nom = (TextView)view.findViewById(R.id.item_tv_nom);
		TextView item_tv_solde = (TextView)view.findViewById(R.id.item_tv_solde);
		
		ComptesBean comptesBean = list.get(position);
		
		item_tv_nom.setText(comptesBean.nom);
		item_tv_solde.setText(comptesBean.solde+"");
		
		
		return view;
	}

}
