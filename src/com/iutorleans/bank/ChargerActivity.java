package com.iutorleans.bank;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.iutorleans.bank.adapter.FilesAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import android.widget.ListView;

public class ChargerActivity extends Activity implements OnItemClickListener {

	private Context mContext1;
	private ListView fileListView;
	ArrayList<String> arrayList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_charger);

		mContext1 = this;
		if (!Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			Toast.makeText(mContext1, "unmounted", Toast.LENGTH_SHORT).show();
			return;
		}
		File dir = new File(Environment.getExternalStorageDirectory()
				.getAbsolutePath());
		File[] listFiles = dir.listFiles();

		/*
		 * for(File f : listFiles){ System.out.println(f.getName()); }
		 */

		arrayList = new ArrayList<String>();
		for (File f : listFiles) {

			arrayList.add(f.getName());
		}

		fileListView = (ListView) findViewById(R.id.lv_files);

		FilesAdapter filesAdapter = new FilesAdapter(arrayList, mContext1);
		fileListView.setAdapter(filesAdapter);

		fileListView.setOnItemClickListener(this);

		registerForContextMenu(fileListView);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		String fileName = arrayList.get(position);
		System.out.println(fileName);
		Toast.makeText(this, fileName, 1).show();
		
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.fileslist, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.affiche:
			Toast.makeText(this, "show the file", 1).show();
			
			break;
		case R.id.savetodb:
			Toast.makeText(this, "save to the bd", 1).show();
			break;
		default:
			break;
		}

		return super.onContextItemSelected(item);
	}

}
