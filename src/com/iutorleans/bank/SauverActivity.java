package com.iutorleans.bank;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.iutorleans.bank.bean.ComptesBean;
import com.iutorleans.bank.dao.ComptesDao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SauverActivity extends Activity implements OnClickListener{
	
	private ArrayList<ComptesBean> allComptes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sauver);
		
		ComptesDao comptesDao = new ComptesDao(this);
		allComptes = comptesDao.query();
		
		Button btn = (Button)findViewById(R.id.buttonExporter);
		btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		//code read the db query(), and write it to a file en sdcard
		
		try{
		String path=Environment.getExternalStorageDirectory().getPath();
		File file = new File(path,"bd1.txt");
		String compteinfo="";
		for(ComptesBean c:allComptes){
			compteinfo=compteinfo+c.id+"##"+c.nom+"##"+c.solde+"\n";
		}
		//String compteinfo=allComptes.get(1).id+"##"+allComptes.get(1).nom+"##"+allComptes.get(1).solde;                
		
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		fileOutputStream.write(compteinfo.getBytes());
		fileOutputStream.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		Toast.makeText(this, "Exporter", 1).show();
		
		Intent intent = new Intent(this,MainActivity.class);
		startActivity(intent);
		
	}
}
