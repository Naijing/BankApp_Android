package com.iutorleans.bank;

import java.util.ArrayList;

import com.iutorleans.bank.adapter.CompteCrudAdapter;
import com.iutorleans.bank.bean.ComptesBean;
import com.iutorleans.bank.dao.ComptesDao;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.Toast;

public class SupprimerActivity extends Activity implements OnClickListener, OnItemClickListener {

	private Context mContext;
	private Button buttonSupprimer;
	private Button buttonAnnuler;
	private ArrayList<ComptesBean> allComptes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_supprimer);
		mContext = this;

		ListView lv_comptes = (ListView) findViewById(R.id.lv_comptes_supprimer);
		ComptesDao comptesDao = new ComptesDao(mContext);
		allComptes = comptesDao.query();

		CompteCrudAdapter compteCrudAdapter = new CompteCrudAdapter(mContext,
				allComptes);
		lv_comptes.setAdapter(compteCrudAdapter);

		buttonSupprimer = (Button) findViewById(R.id.buttonSupprimer);
		buttonAnnuler = (Button) findViewById(R.id.buttonAnnulerSupprimer);

		buttonSupprimer.setOnClickListener(this);
		buttonAnnuler.setOnClickListener(this);
		
		lv_comptes.setOnItemClickListener(this);
		
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.buttonSupprimer:

			break;
		case R.id.buttonAnnulerSupprimer:

			break;
		default:
			break;
		}

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		
		ComptesBean bean = allComptes.get(position);
		//System.out.println("helo");
		Toast.makeText(this, bean.nom, 1).show();
		/*Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("http://www.baidu.com"));
		startActivity(intent);*/
	}


	
	

}