package com.iutorleans.bank.dao;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.iutorleans.bank.MySqliteOpenHelper;
import com.iutorleans.bank.bean.ComptesBean;

public class ComptesDao {

	private MySqliteOpenHelper mySqliteOpenHelper;

	public ComptesDao(Context context) {

		mySqliteOpenHelper = new MySqliteOpenHelper(context);

	}

	public void add(ComptesBean bean) {

		SQLiteDatabase db = mySqliteOpenHelper.getReadableDatabase();

		db.execSQL("insert into bank(nom, solde) values(?,?);", new Object[] {
				bean.nom, bean.solde });
		db.close();

	}

	public int del(ComptesBean bean) {

		SQLiteDatabase db = mySqliteOpenHelper.getReadableDatabase();
		int result = db.delete("bank", "_id=?",
				new String[] { String.valueOf(bean.id) });
		db.close();
		return result;

	}

	public boolean create(ComptesBean bean) {

		SQLiteDatabase db = mySqliteOpenHelper.getReadableDatabase();
		ContentValues values = new ContentValues();

		values.put("nom", bean.nom);
		values.put("solde", bean.solde);

		long result = db.insert("bank", null, values);

		db.close();

		if (result != -1) {
			return true;
		} else {
			return false;
		}

	}

	public ArrayList<ComptesBean> query() {

		ArrayList<ComptesBean> arrayList = new ArrayList<ComptesBean>();

		SQLiteDatabase db = mySqliteOpenHelper.getReadableDatabase();

		Cursor cursor = db.query("bank",
				new String[] { "_id", "nom", "solde" }, null, null, null, null,
				"_id desc");

		if (cursor != null && cursor.getCount() > 0) {

			while (cursor.moveToNext()) {
				int id = cursor.getInt(0);
				String name = cursor.getString(1);
				Float solde = cursor.getFloat(2);
				// System.out.println("id:"+id+";name:"+name+";solde:"+solde);
				ComptesBean comptesBean = new ComptesBean();
				comptesBean.id = id;
				comptesBean.nom = name;
				comptesBean.solde = solde;
				arrayList.add(comptesBean);
			}
			cursor.close();

		}
		db.close();
		return arrayList;

	}

}
