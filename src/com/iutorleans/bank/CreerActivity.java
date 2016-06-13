package com.iutorleans.bank;

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
import android.widget.Toast;

public class CreerActivity extends Activity implements OnClickListener {

	private static final int LENGTH_LONG = 1;
	private EditText nomCreer;
	private EditText soldeCreer;
	private Context mContext;
	private Button buttoncreer;
	private Button btn_creer_annuler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_creer);
		mContext = this;
		buttoncreer = (Button) findViewById(R.id.buttoncreer);
		nomCreer = (EditText) findViewById(R.id.nomCreer);
		soldeCreer = (EditText) findViewById(R.id.soldeCreer);
		btn_creer_annuler = (Button) findViewById(R.id.btn_creer_annuler);

		buttoncreer.setOnClickListener(this);
		btn_creer_annuler.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.buttoncreer:
			ComptesDao comptesDao = new ComptesDao(mContext);

			String solde = soldeCreer.getText().toString().trim();
			String nom = nomCreer.getText().toString().trim();
			float soldeF = Float.parseFloat(solde);

			ComptesBean comptesBean = new ComptesBean();
			comptesBean.nom = nom;
			comptesBean.solde = soldeF;
			boolean res = comptesDao.create(comptesBean);

			if (res) {
				Toast.makeText(this, "création réussite", LENGTH_LONG).show();
			} else {
				Toast.makeText(this, "création échouée", LENGTH_LONG).show();
			}
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
			break;

		case R.id.btn_creer_annuler:
			Intent intent1 = new Intent(this, MainActivity.class);
			startActivity(intent1);
			break;

		default:
			break;
		}

	}

}
