package com.iutorleans.bank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.iutorleans.bank.bean.ComptesBean;
import com.iutorleans.bank.dao.ComptesDao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SauverActivity extends Activity implements OnClickListener {

	private ArrayList<ComptesBean> allComptes;
	private EditText et_nom_fichier;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sauver);

		ComptesDao comptesDao = new ComptesDao(this);
		allComptes = comptesDao.query();

		et_nom_fichier = (EditText) findViewById(R.id.et_nom_fichier);
		Button btn = (Button) findViewById(R.id.buttonExporter);
		btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		if (et_nom_fichier.getText().toString().length() > 0) {

			try {
				saveCompteInfo();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Toast.makeText(this, "Exporter la base de donnée en ", 1).show();

			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);

		} else {

			Toast.makeText(this, "Veuillez saisir un nom de fichier", 1).show();
		}

	}

	private void saveCompteInfo() throws FileNotFoundException, IOException {
		String path = Environment.getExternalStorageDirectory().getPath();
		File file = new File(path, et_nom_fichier.getText().toString().trim());
		String compteinfo = "";
		for (ComptesBean c : allComptes) {
			compteinfo = compteinfo + c.id + "##" + c.nom + "##" + c.solde
					+ "\n";
		}

		FileOutputStream fileOutputStream = new FileOutputStream(file);
		fileOutputStream.write(compteinfo.getBytes());
		fileOutputStream.close();
	}
}
