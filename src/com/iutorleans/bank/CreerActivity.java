package com.iutorleans.bank;

import com.iutorleans.bank.bean.ComptesBean;
import com.iutorleans.bank.dao.ComptesDao;

import android.app.Activity;
import android.content.Context;
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
	private Context mContext ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_creer);
		mContext = this;
		Button buttoncreer = (Button) findViewById(R.id.buttoncreer);
		nomCreer = (EditText) findViewById(R.id.nomCreer);
		soldeCreer = (EditText) findViewById(R.id.soldeCreer);
		
		buttoncreer.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		
		ComptesDao comptesDao = new ComptesDao(mContext);
		
		String solde=soldeCreer.getText().toString().trim();
		String nom=nomCreer.getText().toString().trim();
		float soldeF = Float.parseFloat(solde);
		
		ComptesBean comptesBean=new ComptesBean();
		comptesBean.nom = nom;
		comptesBean.solde = soldeF;
		boolean res = comptesDao.create(comptesBean);
		
		if(res){
			Toast.makeText(this, "création réussite", LENGTH_LONG).show();
		}else{
			Toast.makeText(this, "création échouée", LENGTH_LONG).show();
		}
		
	}

}
