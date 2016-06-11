package com.iutorleans.bank.adapter;

import java.util.ArrayList;

import com.iutorleans.bank.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FilesAdapter extends BaseAdapter {
	
	private ArrayList<String> list;
	private Context context;
	
	public FilesAdapter(ArrayList<String> list, Context context){
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
		TextView view=null;
		
		if(convertView!=null){
			
			view= (TextView)convertView;
		}else{
			view=new TextView(context);
		}	
		
		view.setText(list.get(position));
		
		return view;
		
	}

}
