package pklapp.ramadhanjournal;


import android.app.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class GoodDeedActivity extends Activity implements OnClickListener{
	
	CheckBox recitealquran, shalatfajr, shadaqah, itikaf, iftar, dzikir,shalattarawih, umrah;
	Button save,load;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gooddeed);
        
        save = (Button)findViewById(R.id.Button_gooddeed);
		load = (Button)findViewById(R.id.Button_gooddeedload);
        recitealquran = (CheckBox)findViewById(R.id.recita_alquran);
		shalatfajr = (CheckBox)findViewById(R.id.shalat_subuh);
		shadaqah = (CheckBox)findViewById(R.id.shadaqah);
		itikaf = (CheckBox)findViewById(R.id.itikaf);
		iftar = (CheckBox)findViewById(R.id.iftar);
		dzikir = (CheckBox)findViewById(R.id.dzikir);
		shalattarawih = (CheckBox)findViewById(R.id.tarawih_jamaah);
		umrah = (CheckBox)findViewById(R.id.umrah);
		save.setOnClickListener(this);
		load.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.Button_gooddeed:
			
		boolean didItWork = true;
		try{
		int a = 0,b = 0,c = 0,d = 0,e = 0,f = 0,g = 0,h = 0;
		  if (recitealquran.isChecked()){
			  a = 1;
		  }
		  if (shalatfajr.isChecked()){
			  b = 1;
		  }
		  if (shadaqah.isChecked()){
			  c = 1;
		  }
		  if (itikaf.isChecked()){
			  d = 1;
		  }
		  if (iftar.isChecked()){
			  
			  e = 1;
		  }
		  if (dzikir.isChecked()){
			  f = 1;
		  }
		  if (shalattarawih.isChecked()){
			  g = 1;
		  }
		  if (umrah.isChecked()){
			  h = 1;
		  }
		  GlobalDataClass gdc = new GlobalDataClass(this);
		  int id = gdc.getSessionID();
		  GoodDeedSQL input = new GoodDeedSQL(this);
		  input.open();
		  if(input.setGoodDeedSQLInit()==0){
			  input.setInitID(0);input.setInitID(5);input.setInitID(10);input.setInitID(15);input.setInitID(20);input.setInitID(25);
				input.setInitID(1);input.setInitID(6);input.setInitID(11);input.setInitID(16);input.setInitID(21);input.setInitID(26);
				input.setInitID(2);input.setInitID(7);input.setInitID(12);input.setInitID(17);input.setInitID(22);input.setInitID(27);
				input.setInitID(3);input.setInitID(8);input.setInitID(13);input.setInitID(18);input.setInitID(23);input.setInitID(28);
				input.setInitID(4);input.setInitID(9);input.setInitID(14);input.setInitID(19);input.setInitID(24);
		  }else{
		  input.inputData(id,a,b,c,d,e,f,g,h);
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
		case R.id.Button_gooddeedload:
			boolean adidItWork = true;
			String atext = null, btext = null, ctext = null, dtext = null, etext = null, ftext = null, gtext = null, htext = null;
			try{
				GlobalDataClass gdc = new GlobalDataClass(GoodDeedActivity.this);
				long l = gdc.getSessionID();
				GoodDeedSQL le = new GoodDeedSQL(GoodDeedActivity.this);
				le.open();
				 atext = le.getReciteAlquranData(l);
				 btext = le.getShalatFajrData(l);
				 ctext = le.getShadaqahData(l);
				 dtext = le.getItikaf(l);
				 etext = le.getIftar(l);
				 ftext = le.getDzikir(l);
				 gtext = le.getSTarawih(l);
				 htext = le.getUmrah(l);
				le.close();
			}catch(Exception a){
				adidItWork = false;
				String error = a.toString();
				Dialog d = new Dialog(this);
				d.setTitle("Database Eror!");
				TextView tv = new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
			}finally{
				if (adidItWork){
					Dialog d = new Dialog(this);
					d.setTitle("Load Data");
					TextView tv = new TextView(this);
					tv.setText(" Recite Alquran : "+atext+"\n Shalat Fajr and Isya at mosque : "+btext+"\n Shadaqah : "+ctext+
							"\n I'tikaf "+dtext+"\n Giving Iftar to other muslim : "+etext+"\n Dzkir : "+ftext+
							"\n Shalat Tarawih by Jamaah : "+gtext+"\n Umrah : "+htext);
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
