package com.iutorleans.bank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;



import com.iutorleans.bank.adapter.FilesAdapter;
import com.iutorleans.bank.bean.ComptesBean;
import com.iutorleans.bank.dao.ComptesDao;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import android.widget.ListView;

public class ChargerActivity extends Activity implements OnItemClickListener, OnClickListener {

	private Context mContext1;
	private ListView fileListView;
	private ArrayList<String> arrayList;
	private ComptesDao comptesDao;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_charger);

		mContext1 = this;
		
		Button btn_charger_annuler = (Button)findViewById(R.id.btn_charger_annuler);
		
		btn_charger_annuler.setOnClickListener(this);
		
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

		//registerForContextMenu(fileListView);
		comptesDao = new ComptesDao(this);
		

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		
		
		try {
			String fileName = arrayList.get(position);
			
			String path=Environment.getExternalStorageDirectory().getPath();
			
			File file = new File(path,fileName);
			FileInputStream fileInputStream = new FileInputStream(file);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
			
			while (bufferedReader.ready()) {  
				String readLine = bufferedReader.readLine();
				String[] split = readLine.split("#");
				ComptesBean bean = new ComptesBean();
				bean.nom=split[1];
				bean.solde=Float.parseFloat(split[2]);
				comptesDao.create(bean);				
	          }  						
			System.out.println("lalallalal");
			bufferedReader.close();
			fileInputStream.close();
			Toast.makeText(this, "Charger"+fileName+"réussi", 1).show();
			Intent intent = new Intent(this,MainActivity.class);
			startActivity(intent);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		
	}

	/*@Override
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
	}*/

}
