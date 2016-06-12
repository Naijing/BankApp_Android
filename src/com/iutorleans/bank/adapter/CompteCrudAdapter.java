package com.iutorleans.bank.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	private ArrayList<ComptesBean> listComptesChecked = new ArrayList<ComptesBean>() ;
	private Context context;
	Map<Integer, Boolean> isCheckMap = new HashMap<Integer, Boolean>();

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

			view = View.inflate(context, R.layout.item_comptes_checkbox_layout,
					null);

		}

		TextView item_tv_nom = (TextView) view
				.findViewById(R.id.item_tv_crud_nom);
		TextView item_tv_solde = (TextView) view
				.findViewById(R.id.item_tv_crud_solde);

		CheckBox item_tv_crud_checkBox = (CheckBox) view
				.findViewById(R.id.item_tv_crud_checkBox);

		ComptesBean comptesBean = list.get(position);

		item_tv_nom.setText(comptesBean.nom);
		item_tv_solde.setText(comptesBean.solde + "");
		item_tv_crud_checkBox.setTag(position);

		if (isCheckMap != null && isCheckMap.containsKey(position)) {
			item_tv_crud_checkBox.setChecked(isCheckMap.get(position));
		} else {
			item_tv_crud_checkBox.setChecked(false);
		}

		item_tv_crud_checkBox
				.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						int checkBoxId = Integer.parseInt(buttonView.getTag()
								.toString());						
						
						if (isChecked) {
							System.out.println(list.get(checkBoxId).nom);
							listComptesChecked.add(list.get(checkBoxId));
							isCheckMap.put(checkBoxId, isChecked);
							

							// System.out.println("on"+checkBoxId);
						} else {
							// System.out.println("off"+checkBoxId);
							listComptesChecked.remove(list.get(checkBoxId));
							isCheckMap.remove(checkBoxId);
							
						}
					}
				});

		return view;
	}

	public ArrayList<ComptesBean> getListComptesChecked() {
		return listComptesChecked;
	}

}
