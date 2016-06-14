package com.iutorleans.bank;

import java.util.ArrayList;

import com.iutorleans.bank.adapter.CompteCrudAdapter;
import com.iutorleans.bank.bean.ComptesBean;
import com.iutorleans.bank.dao.ComptesDao;

import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CrediterActivity extends Activity implements OnClickListener {

	private Context mContext;
	private ArrayList<ComptesBean> allComptes;
	private ArrayList<ComptesBean> listComptesChecked;
	private EditText et_somme;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crediter);
		mContext = this;

		ComptesDao comptesDao = new ComptesDao(mContext);
		allComptes = comptesDao.query();

		ListView lv_comptes_crediter = (ListView) findViewById(R.id.lv_comptes_crediter);
		CompteCrudAdapter compteCrudAdapter = new CompteCrudAdapter(mContext,
				allComptes);
		listComptesChecked = compteCrudAdapter.getListComptesChecked();
		lv_comptes_crediter.setAdapter(compteCrudAdapter);

		Button buttonCrediter = (Button) findViewById(R.id.buttonCrediter);
		Button buttonAnnulerCrediter = (Button) findViewById(R.id.buttonAnnulerCrediter);
		et_somme = (EditText) findViewById(R.id.et_crediter_somme);

		buttonCrediter.setOnClickListener(this);
		buttonAnnulerCrediter.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.buttonCrediter:

			if (listComptesChecked.isEmpty()) {
				Toast.makeText(this, "Cochez au moin 1 checkbox", 1).show();
			} else {
				ComptesDao comptesDao = new ComptesDao(mContext);
				int i = 0;
				float f = Float
						.parseFloat(et_somme.getText().toString().trim());
				for (ComptesBean c : listComptesChecked) {

					int res = comptesDao.update(Float.toString(f + c.solde),
							c.id);
					if (res != -1) {
						i++;
					}
				}
				System.out.println(i);
				Toast.makeText(this, "" + i + "comptes crédités" + f + "", 1)
						.show();

				Intent intent = new Intent(this, MainActivity.class);
				startActivity(intent);

			}

			break;

		case R.id.buttonAnnulerCrediter:

			Intent intent1 = new Intent(this, MainActivity.class);
			startActivity(intent1);

			break;

		default:
			break;
		}

	}

}
