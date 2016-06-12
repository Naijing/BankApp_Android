package com.iutorleans.bank.adapter;

import java.util.ArrayList;

import com.iutorleans.bank.R;
import com.iutorleans.bank.bean.ComptesBean;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import android.widget.TextView;

public class CompteCrudAdapter extends BaseAdapter {

	private ArrayList<ComptesBean> list;
	private Context context;

	public CompteCrudAdapter(Context context, ArrayList<ComptesBean> list) {

		this.list = list;
		this.context = context;

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

		if (convertView != null) {
			view = convertView;

		} else {

			view = View.inflate(context, R.layout.item_comptes_checkbox_layout, null);

		}

		TextView item_tv_nom = (TextView) view.findViewById(R.id.item_tv_crud_nom);
		TextView item_tv_solde = (TextView) view
				.findViewById(R.id.item_tv_crud_solde);
		
		CheckBox item_tv_crud_checkBox = (CheckBox)view.findViewById(R.id.item_tv_crud_checkBox);

		ComptesBean comptesBean = list.get(position);

		item_tv_nom.setText(comptesBean.nom);
		item_tv_solde.setText(comptesBean.solde + "");
		item_tv_crud_checkBox.setTag(position);
		
		item_tv_crud_checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				int radiaoId = Integer.parseInt(buttonView.getTag().toString());
				if(isChecked)
				{
					
					System.out.println("on"+radiaoId);
				}
				else
				{
					System.out.println("off"+radiaoId);
					
				}
			}
		});

		return view;
	}
	
	

}
