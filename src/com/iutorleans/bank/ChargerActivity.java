package com.iutorleans.bank;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.iutorleans.bank.adapter.FilesAdapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ChargerActivity extends Activity {
	
	private Context mContext1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_charger);
		
		mContext1=this;
		
		File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
		File[] listFiles = dir.listFiles();
		
		/*for(File f : listFiles){
			System.out.println(f.getName());
		}*/
		
		
		ArrayList<String> arrayList = new ArrayList<String>();
		for(File f : listFiles){
		
			arrayList.add(f.getName());
		}
		
		ListView fileListView = (ListView)findViewById(R.id.lv_files);
		
		FilesAdapter filesAdapter = new FilesAdapter(arrayList, mContext1);
		fileListView.setAdapter(filesAdapter);
		/*ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
		fileListView.setAdapter(arrayAdapter);*/
		
	}
	
	

}
