package pklapp.ramadhanjournal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DailyStatisticActivity extends Activity{
	ProgressBar bar1,bar2,bar3,bar4,bar5,bar6,bar7,bar8,bar9,bar10,bar11,bar12,bar13,bar14,bar15,bar16,bar17;
	TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12,tv13,tv14,tv15,tv16,tv17;
	int a1 = 0,a2 = 0,a3 = 0,a4 = 0,a5 = 0,a6 = 0,a7 = 0,a8 = 0,a9 = 0,a10 = 0,a11 = 0,a12 = 0,a13 = 0,a14 = 0,a15 = 0,a16 = 0,a17 = 0;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailystatistic);
        bar1 = (ProgressBar)findViewById(R.id.dprogressBar10); bar9 = (ProgressBar)findViewById(R.id.dprogressBar1); bar17 = (ProgressBar)findViewById(R.id.dprogressBar9);
        bar2 = (ProgressBar)findViewById(R.id.dprogressBar17); bar10 = (ProgressBar)findViewById(R.id.dprogressBar2);
        bar3 = (ProgressBar)findViewById(R.id.dprogressBar11); bar11 = (ProgressBar)findViewById(R.id.dprogressBar3);
        bar4 = (ProgressBar)findViewById(R.id.dprogressBar12); bar12 = (ProgressBar)findViewById(R.id.dprogressBar4);
        bar5 = (ProgressBar)findViewById(R.id.dprogressBar14); bar13 = (ProgressBar)findViewById(R.id.dprogressBar5);
        bar6 = (ProgressBar)findViewById(R.id.dprogressBar15); bar14 = (ProgressBar)findViewById(R.id.dprogressBar6);
        bar7 = (ProgressBar)findViewById(R.id.dprogressBar16); bar15 = (ProgressBar)findViewById(R.id.dprogressBar7);
        bar8 = (ProgressBar)findViewById(R.id.dprogressBar13); bar16 = (ProgressBar)findViewById(R.id.dprogressBar8);  
        tv1 = (TextView)findViewById(R.id.dailystatistic10);tv9 = (TextView)findViewById(R.id.dailystatistic1);tv17 = (TextView)findViewById(R.id.dailystatistic9);
        tv2 = (TextView)findViewById(R.id.dailystatistic17);tv10 = (TextView)findViewById(R.id.dailystatistic2);
        tv3 = (TextView)findViewById(R.id.dailystatistic11);tv11 = (TextView)findViewById(R.id.dailystatistic3);
        tv4 = (TextView)findViewById(R.id.dailystatistic12);tv12 = (TextView)findViewById(R.id.dailystatistic4);
        tv5 = (TextView)findViewById(R.id.dailystatistic14);tv13 = (TextView)findViewById(R.id.dailystatistic5);
        tv6 = (TextView)findViewById(R.id.dailystatistic15);tv14 = (TextView)findViewById(R.id.dailystatistic6);
        tv7 = (TextView)findViewById(R.id.dailystatistic16);tv15 = (TextView)findViewById(R.id.dailystatistic7);
        tv8 = (TextView)findViewById(R.id.dailystatistic13);tv16 = (TextView)findViewById(R.id.dailystatistic8);
        GlobalDataClass gdc = new GlobalDataClass(this);
        int l = gdc.getSessionID();
        DailyPrayerSQL dps = new DailyPrayerSQL(this);
        dps.open();
        a9 = Integer.parseInt(dps.getFajr(l));
        a10 = Integer.parseInt(dps.getDzuhur(l));
        a11 = Integer.parseInt(dps.getAshr(l));
        a12 = Integer.parseInt(dps.getMagrib(l));
        a13 = Integer.parseInt(dps.getIsya(l));
        a14 = Integer.parseInt(dps.getDhuha(l));
        a15 = Integer.parseInt(dps.getTahajud(l));
        a16 = Integer.parseInt(dps.getTaraweh(l));
        a17 = Integer.parseInt(dps.getWitir(l));
        dps.close();
        GoodDeedSQL gds = new GoodDeedSQL(this);
        gds.open();
        a1 = Integer.parseInt(gds.getReciteAlquranData(l));
        a2 = Integer.parseInt(gds.getShalatFajrData(l));
        a3 = Integer.parseInt(gds.getShadaqahData(l));
        a4 = Integer.parseInt(gds.getItikaf(l));
        a5 = Integer.parseInt(gds.getIftar(l));
        a6 = Integer.parseInt(gds.getDzikir(l));
        a7 = Integer.parseInt(gds.getSTarawih(l));
        a8 = Integer.parseInt(gds.getUmrah(l));
        gds.close();
        bar1.setMax(100);bar3.setMax(100);bar5.setMax(100);bar7.setMax(100);
        bar2.setMax(100);bar4.setMax(100);bar6.setMax(100);bar8.setMax(100);
        bar9.setMax(100);bar10.setMax(100);bar11.setMax(100);bar12.setMax(100);
        bar16.setMax(100);bar15.setMax(100);bar14.setMax(100);bar13.setMax(100);
        bar17.setMax(100);
        if(a1!=0){
        	bar1.setProgress(100);
        	tv1.setText("100%");
        }
        if(a2!=0){
        	bar2.setProgress(100);
        	tv2.setText("100%");
        }
        if(a3!=0){
            bar3.setProgress(100);
            tv3.setText("100%");
            }
        if(a4!=0){
            bar4.setProgress(100);
            tv4.setText("100%");
            }
        if(a5!=0){
            bar5.setProgress(100);
            tv5.setText("100%");
            }
        if(a6!=0){
            bar6.setProgress(100);
            tv6.setText("100%");
            }
        if(a7!=0){
            bar7.setProgress(100);
            tv7.setText("100%");
            }
        if(a8!=0){
            bar8.setProgress(100);
            tv8.setText("100%");
            }
        if(a9!=0){
            bar9.setProgress(100);
            tv9.setText("100%");
            }
        if(a10!=0){
            bar10.setProgress(100);
            tv10.setText("100%");
            }
        if(a11!=0){
            bar11.setProgress(100);
            tv11.setText("100%");
            }
        if(a12!=0){
            bar12.setProgress(100);
            tv12.setText("100%");
            }
        if(a13!=0){
            bar13.setProgress(100);
            tv13.setText("100%");
            }
        if(a14!=0){
            bar14.setProgress(100);
            tv14.setText("100%");
            }
        if(a15!=0){
            bar15.setProgress(100);
            tv15.setText("100%");
            }
        if(a16!=0){
            bar16.setProgress(100);
            tv16.setText("100%");
            }
        if(a17!=0){
            bar17.setProgress(100);
            tv17.setText("100%");
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
