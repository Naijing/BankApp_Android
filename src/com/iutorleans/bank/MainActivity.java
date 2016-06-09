package com.iutorleans.bank;

import java.util.ArrayList;

import com.iutorleans.bank.adapter.ComptesAdapter;
import com.iutorleans.bank.bean.ComptesBean;
import com.iutorleans.bank.utils.ComptesUtils;

import android.app.Activity;
import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {

    private Context mContext;


	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mContext = this;
        
        ListView lv_comptes = (ListView) findViewById(R.id.lv_comptes);
        ArrayList<ComptesBean> allComptes= ComptesUtils.getAllComptes();
        
        ComptesAdapter comptesAdapter = new ComptesAdapter(mContext, allComptes);
        lv_comptes.setAdapter(comptesAdapter);
        //MySqliteOpenHelper mySqliteOpenHelper = new MySqliteOpenHelper(mContext);
       // SQLiteDatabase db = mySqliteOpenHelper.getReadableDatabase();
        
    }


    
    
}
