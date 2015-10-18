package pklapp.ramadhanjournal;

import android.app.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class DailyPrayerActivity extends Activity implements OnClickListener{
	
	CheckBox fajr, dzuhur, ashr, magrib, isya, dhuha, tahajud, taraweh, witir;
	Button save,load;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailyprayer);
        save = (Button)findViewById(R.id.Button_dailyprayer);
        load = (Button)findViewById(R.id.Button_dailyprayerload);
        fajr = (CheckBox)findViewById(R.id.fajr);
        dzuhur = (CheckBox)findViewById(R.id.dzuhur);
        ashr = (CheckBox)findViewById(R.id.ashar);
        magrib = (CheckBox)findViewById(R.id.maghrib);
        isya = (CheckBox)findViewById(R.id.isya);
        dhuha =(CheckBox)findViewById(R.id.dhuha);
        tahajud = (CheckBox)findViewById(R.id.tahajud);
        taraweh = (CheckBox)findViewById(R.id.taraweh);
        witir = (CheckBox)findViewById(R.id.witir);
        save.setOnClickListener(this);
		load.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.Button_dailyprayer:
			boolean didItWork = true;
			try{
				int a = 0,b = 0,c = 0,d = 0,e = 0,f = 0,g = 0,h = 0,i = 0;
				if (fajr.isChecked()){
					  a = 1;
				  }
				if (dzuhur.isChecked()){
					  b = 1;
				  }
				if (ashr.isChecked()){
					  c = 1;
				  }
				if (magrib.isChecked()){
					  d = 1;
				  }
				if (isya.isChecked()){
					  e = 1;
				  }
				if (dhuha.isChecked()){
					  f = 1;
				  }
				if (tahajud.isChecked()){
					  g = 1;
				  }
				if (taraweh.isChecked()){
					  h = 1;
				  }
				if (witir.isChecked()){
					  i = 1;
				  }
				GlobalDataClass gdc = new GlobalDataClass(this);
				int id = gdc.getSessionID();
				DailyPrayerSQL input = new DailyPrayerSQL(this);
				input.open();
				if(input.setSQLDailyPrayerInit()==0){
					input.setInitID(0);input.setInitID(5);input.setInitID(10);input.setInitID(15);input.setInitID(20);input.setInitID(25);
					input.setInitID(1);input.setInitID(6);input.setInitID(11);input.setInitID(16);input.setInitID(21);input.setInitID(26);
					input.setInitID(2);input.setInitID(7);input.setInitID(12);input.setInitID(17);input.setInitID(22);input.setInitID(27);
					input.setInitID(3);input.setInitID(8);input.setInitID(13);input.setInitID(18);input.setInitID(23);input.setInitID(28);
					input.setInitID(4);input.setInitID(9);input.setInitID(14);input.setInitID(19);input.setInitID(24);
				}else{
					input.inputSQLData(id,a,b,c,d,e,f,g,h,i);
				}
				input.close();
			}catch(Exception e){
				didItWork = false;
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("Database Error!");
				TextView tv = new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
			}finally{
				if (didItWork){
					Dialog d = new Dialog(this);
					d.setTitle("Saved");
					TextView tv = new TextView(this);
					tv.setText("Input Data Success");
					d.setContentView(tv);
					d.show();
				}
			}
		break;
		case R.id.Button_dailyprayerload:
			String atext = null, btext = null, ctext = null, dtext = null, etext = null, ftext = null, gtext = null, htext = null, itext = null;
			boolean adidItWork = true;
			try{
				GlobalDataClass gdc = new GlobalDataClass(DailyPrayerActivity.this);
				long l = gdc.getSessionID();
				DailyPrayerSQL tes = new DailyPrayerSQL(DailyPrayerActivity.this);
				tes.open();
				atext = tes.getFajr(l);
				btext = tes.getDzuhur(l);
				ctext = tes.getAshr(l);
				dtext = tes.getMagrib(l);
				etext = tes.getIsya(l);
				ftext = tes.getDhuha(l);
				gtext = tes.getTahajud(l);
				htext = tes.getTaraweh(l);
				itext = tes.getWitir(l);
				tes.close();
			}catch(Exception a){
				adidItWork = false;
				String error = a.toString();
				Dialog d = new Dialog(this);
				d.setTitle("Database Error!");
				TextView tv = new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
			}finally{
				if (adidItWork){
					Dialog d = new Dialog(this);
					d.setTitle("Load Data");
					TextView tv = new TextView(this);
					tv.setText(" Shalat Fajr : "+atext+"\n Shalat Dzuhur : "+btext+"\n Shalat Ashr : "+ctext+
							"\n Shalat Magrib "+dtext+"\n Shalat Isya : "+etext+"\n Shalat Dhuha : "+ftext+
							"\n Shalat Tahajud : "+gtext+"\n Shalat Taraweh : "+htext+"\n Shalat Witir : "+itext);
					d.setContentView(tv);
					d.show();
				}
			}
		break;
		}
	}

	public void oneClick (View v){
		Intent i = new Intent(getApplicationContext(),MainActivity.class);
		startActivity(i);
	}
	
	public void twoClick(View v){
		Intent j = new Intent(getApplicationContext(),MyActivity.class);
		startActivity(j);
	}
	
	public void threeClick(View v){
		Intent k = new Intent(getApplicationContext(),MyStatistic.class);
		startActivity(k);
	}
	
	public void fourClick(View v){
		finish();
        System.exit(0);
	}
}
