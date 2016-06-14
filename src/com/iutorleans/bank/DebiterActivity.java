package com.iutorleans.bank;

import java.util.ArrayList;

import com.iutorleans.bank.adapter.CompteCrudAdapter;
import com.iutorleans.bank.bean.ComptesBean;
import com.iutorleans.bank.dao.ComptesDao;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class DebiterActivity extends Activity implements OnClickListener {

	private Context mContext;
	private ArrayList<ComptesBean> allComptes;
	private ArrayList<ComptesBean> listComptesChecked;
	private EditText et_somme;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_debiter);

		mContext = this;

		ComptesDao comptesDao = new ComptesDao(mContext);
		allComptes = comptesDao.query();

		ListView lv_comptes_debiter = (ListView) findViewById(R.id.lv_comptes_debiter);
		CompteCrudAdapter compteCrudAdapter = new CompteCrudAdapter(mContext,
				allComptes);
		listComptesChecked = compteCrudAdapter.getListComptesChecked();
		lv_comptes_debiter.setAdapter(compteCrudAdapter);

		Button buttonDebiter = (Button) findViewById(R.id.buttonDebiter);
		Button buttonAnnulerDebiter = (Button) findViewById(R.id.buttonAnnulerDebiter);
		et_somme = (EditText) findViewById(R.id.et_debiter_somme);

		buttonDebiter.setOnClickListener(this);
		buttonAnnulerDebiter.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.buttonDebiter:

			if (listComptesChecked.isEmpty()) {
				Toast.makeText(this, "Cochez au moin 1 checkbox", 1).show();
			} else {
				ComptesDao comptesDao = new ComptesDao(mContext);
				int i = 0;
				float f = Float
						.parseFloat(et_somme.getText().toString().trim());
				for (ComptesBean c : listComptesChecked) {

					int res = comptesDao.update(Float.toString(c.solde - f),
							c.id);
					if (res != -1) {
						i++;
					}
				}

				Toast.makeText(this, "" + i + "comptes débités" + f + "", 1)
						.show();

				Intent intent = new Intent(this, MainActivity.class);
				startActivity(intent);
			}

			break;

		case R.id.buttonAnnulerDebiter:

			Intent intent1 = new Intent(this, MainActivity.class);
			startActivity(intent1);

			break;

		default:
			break;
		}

	}
}
