package com.iutorleans.bank;

import java.util.ArrayList;

import com.iutorleans.bank.adapter.ComptesAdapter;
import com.iutorleans.bank.bean.ComptesBean;
import com.iutorleans.bank.dao.ComptesDao;
import com.iutorleans.bank.utils.ComptesUtils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
//import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mContext = this;

		// ListView lv_comptes = (ListView) findViewById(R.id.lv_comptes);
		// ArrayList<ComptesBean> allComptes= ComptesUtils.getAllComptes();

		// ComptesAdapter comptesAdapter = new ComptesAdapter(mContext,
		// allComptes);
		// lv_comptes.setAdapter(comptesAdapter);
		// MySqliteOpenHelper mySqliteOpenHelper = new
		// MySqliteOpenHelper(mContext);
		// SQLiteDatabase db = mySqliteOpenHelper.getReadableDatabase();

		ComptesDao comptesDao = new ComptesDao(mContext);
		ListView lv_comptes = (ListView) findViewById(R.id.lv_comptes);
		ArrayList<ComptesBean> allComptes = comptesDao.query();

		ComptesAdapter comptesAdapter = new ComptesAdapter(mContext, allComptes);
		lv_comptes.setAdapter(comptesAdapter);

	}

	/*
	 * @Override public void onClick(View v) {
	 * 
	 * ComptesDao comptesDao = new ComptesDao(mContext);
	 * 
	 * switch (v.getId()) {
	 * 
	 * case R.id.bt_add:
	 * 
	 * ComptesBean comptesBean = new ComptesBean(); comptesBean.nom = "kiki";
	 * comptesBean.solde = 7200;
	 * 
	 * comptesDao.add(comptesBean);
	 * 
	 * ComptesBean comptesBean1 = new ComptesBean(); comptesBean1.nom = "wowo";
	 * comptesBean1.solde = 120000;
	 * 
	 * comptesDao.add(comptesBean1);
	 * 
	 * break;
	 * 
	 * case R.id.bt_query:
	 * 
	 * ListView lv_comptes = (ListView) findViewById(R.id.lv_comptes);
	 * ArrayList<ComptesBean> allComptes = comptesDao.query();
	 * 
	 * ComptesAdapter comptesAdapter = new ComptesAdapter(mContext, allComptes);
	 * lv_comptes.setAdapter(comptesAdapter);
	 * 
	 * break;
	 * 
	 * default: break;
	 * 
	 * }
	 * 
	 * }
	 */

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.main, menu);

		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.sauver:
			Intent intentSauver = new Intent(this, SauverActivity.class);
			startActivity(intentSauver);

			break;

		case R.id.charger:

			// Toast.makeText(this, "charger", 1).show();

			Intent intentCharger = new Intent(this, ChargerActivity.class);
			startActivity(intentCharger);

			break;

		case R.id.quitter:

			Intent intent = new Intent(Intent.ACTION_MAIN);
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent.addCategory(Intent.CATEGORY_HOME);
			startActivity(intent);

			break;
		case R.id.creer:

			Intent intentCreer = new Intent(this, CreerActivity.class);
			startActivity(intentCreer);

			break;

		case R.id.supprimer:

			Intent intentSupprimer = new Intent(this, SupprimerActivity.class);
			startActivity(intentSupprimer);

			break;

		case R.id.crediter:

			Intent intentCrediter = new Intent(this, CrediterActivity.class);
			startActivity(intentCrediter);

			break;
			
		case R.id.debiter:

			Intent intentDebiter = new Intent(this, DebiterActivity.class);
			startActivity(intentDebiter);

			break;
		

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}
