package com.iutorleans.bank;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

    private Context mContext;


	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mContext = this;
        
        MySqliteOpenHelper mySqliteOpenHelper = new MySqliteOpenHelper(mContext);
        SQLiteDatabase db = mySqliteOpenHelper.getReadableDatabase();
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
