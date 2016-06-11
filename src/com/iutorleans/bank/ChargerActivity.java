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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import android.widget.ListView;

public class ChargerActivity extends Activity implements OnItemClickListener{
	
	private Context mContext1;
	private ListView fileListView;
	ArrayList<String> arrayList;

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
		
		
		arrayList = new ArrayList<String>();
		for(File f : listFiles){
		
			arrayList.add(f.getName());
		}
		
		fileListView = (ListView)findViewById(R.id.lv_files);
		
		FilesAdapter filesAdapter = new FilesAdapter(arrayList, mContext1);
		fileListView.setAdapter(filesAdapter);
		
		fileListView.setOnItemClickListener(this);
		
		
		
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		String fileName = arrayList.get(position);
		System.out.println(fileName);
		Toast.makeText(this, fileName, 1).show();
	}
	
	

}
