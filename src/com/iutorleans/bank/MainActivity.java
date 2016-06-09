package com.iutorleans.bank;

import java.util.ArrayList;

import com.iutorleans.bank.adapter.ComptesAdapter;
import com.iutorleans.bank.bean.ComptesBean;
import com.iutorleans.bank.dao.ComptesDao;
import com.iutorleans.bank.utils.ComptesUtils;

import android.app.Activity;
import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener {

    private Context mContext;


	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mContext = this;
        
        //ListView lv_comptes = (ListView) findViewById(R.id.lv_comptes);
        //ArrayList<ComptesBean> allComptes= ComptesUtils.getAllComptes();
        
        //ComptesAdapter comptesAdapter = new ComptesAdapter(mContext, allComptes);
        //lv_comptes.setAdapter(comptesAdapter);
        //MySqliteOpenHelper mySqliteOpenHelper = new MySqliteOpenHelper(mContext);
       // SQLiteDatabase db = mySqliteOpenHelper.getReadableDatabase();
        
        findViewById(R.id.bt_add).setOnClickListener(this);
        findViewById(R.id.bt_query).setOnClickListener(this);
        
    }


	@Override
	public void onClick(View v) {
		
		ComptesDao comptesDao = new ComptesDao(mContext);
		
		switch(v.getId()){
		
		case R.id.bt_add:
			
			ComptesBean comptesBean = new ComptesBean();
			comptesBean.nom="kiki";
			comptesBean.solde=7200;
			
			comptesDao.add(comptesBean);
			
			ComptesBean comptesBean1 = new ComptesBean();
			comptesBean1.nom="wowo";
			comptesBean1.solde=120000;
			
			comptesDao.add(comptesBean1);
			
			
			
			
			break;
			
		case R.id.bt_query:
			
			
			ListView lv_comptes = (ListView) findViewById(R.id.lv_comptes);
	        ArrayList<ComptesBean> allComptes= comptesDao.query();
	        
	        ComptesAdapter comptesAdapter = new ComptesAdapter(mContext, allComptes);
	        lv_comptes.setAdapter(comptesAdapter);
			
			break;
			
			default:
				break;
			
		
		}
		
	}


    
    
}
