package pklapp.ramadhanjournal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MonthlyStatisticActivity extends Activity{
	ProgressBar bar1,bar2,bar3,bar4,bar5,bar6,bar7,bar8,bar9,bar10,bar11,bar12,bar13,bar14,bar15,bar16,bar17;
	TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12,tv13,tv14,tv15,tv16,tv17;
	int a1 = 0,a2 = 0,a3 = 0,a4 = 0,a5 = 0,a6 = 0,a7 = 0,a8 = 0,a9 = 0,a10 = 0,a11 = 0,a12 = 0,a13 = 0,a14 = 0,a15 = 0,a16 = 0,a17 = 0;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthlystatistic);
        bar1 = (ProgressBar)findViewById(R.id.monthlytatisticprogressBar10); bar9 = (ProgressBar)findViewById(R.id.monthlytatisticprogressBar1); bar17 = (ProgressBar)findViewById(R.id.monthlytatisticprogressBar9);
        bar2 = (ProgressBar)findViewById(R.id.monthlytatisticprogressBar17); bar10 = (ProgressBar)findViewById(R.id.monthlytatisticprogressBar2);
        bar3 = (ProgressBar)findViewById(R.id.monthlytatisticprogressBar11); bar11 = (ProgressBar)findViewById(R.id.monthlytatisticprogressBar3);
        bar4 = (ProgressBar)findViewById(R.id.monthlytatisticprogressBar12); bar12 = (ProgressBar)findViewById(R.id.monthlytatisticprogressBar4);
        bar5 = (ProgressBar)findViewById(R.id.monthlytatisticprogressBar14); bar13 = (ProgressBar)findViewById(R.id.monthlytatisticprogressBar5);
        bar6 = (ProgressBar)findViewById(R.id.monthlytatisticprogressBar15); bar14 = (ProgressBar)findViewById(R.id.monthlytatisticprogressBar6);
        bar7 = (ProgressBar)findViewById(R.id.monthlytatisticprogressBar16); bar15 = (ProgressBar)findViewById(R.id.monthlytatisticprogressBar7);
        bar8 = (ProgressBar)findViewById(R.id.monthlytatisticprogressBar13); bar16 = (ProgressBar)findViewById(R.id.monthlytatisticprogressBar8);  
        tv1 = (TextView)findViewById(R.id.monthlytatistic10);tv9 = (TextView)findViewById(R.id.monthlytatistic1);tv17 = (TextView)findViewById(R.id.monthlytatistic9);
        tv2 = (TextView)findViewById(R.id.monthlytatistic17);tv10 = (TextView)findViewById(R.id.monthlytatistic2);
        tv3 = (TextView)findViewById(R.id.monthlytatistic11);tv11 = (TextView)findViewById(R.id.monthlytatistic3);
        tv4 = (TextView)findViewById(R.id.monthlytatistic12);tv12 = (TextView)findViewById(R.id.monthlytatistic4);
        tv5 = (TextView)findViewById(R.id.monthlytatistic14);tv13 = (TextView)findViewById(R.id.monthlytatistic5);
        tv6 = (TextView)findViewById(R.id.monthlytatistic15);tv14 = (TextView)findViewById(R.id.monthlytatistic6);
        tv7 = (TextView)findViewById(R.id.monthlytatistic16);tv15 = (TextView)findViewById(R.id.monthlytatistic7);
        tv8 = (TextView)findViewById(R.id.monthlytatistic13);tv16 = (TextView)findViewById(R.id.monthlytatistic8);
        GlobalDataClass gdc = new GlobalDataClass(this);
        int l = gdc.getSessionID();
        DailyPrayerSQL dps = new DailyPrayerSQL(this);
        dps.open();
        a9 = Integer.parseInt(dps.getMonthlyFajr(l));
        a10 = Integer.parseInt(dps.getMonthlyDzuhur(l));
        a11 = Integer.parseInt(dps.getMonthlyAshr(l));
        a12 = Integer.parseInt(dps.getMonthlyMagrib(l));
        a13 = Integer.parseInt(dps.getMonthlyIsya(l));
        a14 = Integer.parseInt(dps.getMonthlyDhuha(l));
        a15 = Integer.parseInt(dps.getMonthlyTahajud(l));
        a16 = Integer.parseInt(dps.getMonthlyTaraweh(l));
        a17 = Integer.parseInt(dps.getMonthlyWitir(l));
        dps.close();
        GoodDeedSQL gds = new GoodDeedSQL(this);
        gds.open();
        a1 = Integer.parseInt(gds.getMonthlyReciteAlquran(l));
        a2 = Integer.parseInt(gds.getMonthlyShalatFajr(l));
        a3 = Integer.parseInt(gds.getMonthlyShadaqah(l));
        a4 = Integer.parseInt(gds.getMonthlyItikaf(l));
        a5 = Integer.parseInt(gds.getMonthlyIftar(l));
        a6 = Integer.parseInt(gds.getMonthlyDzikir(l));
        a7 = Integer.parseInt(gds.getMonthlySTarawih(l));
        a8 = Integer.parseInt(gds.getMonthlyUmrah(l));
        gds.close();
        bar1.setMax(100);bar3.setMax(100);bar5.setMax(100);bar7.setMax(100);
        bar2.setMax(100);bar4.setMax(100);bar6.setMax(100);bar8.setMax(100);
        bar9.setMax(100);bar10.setMax(100);bar11.setMax(100);bar12.setMax(100);
        bar16.setMax(100);bar15.setMax(100);bar14.setMax(100);bar13.setMax(100);
        bar17.setMax(100);
        if(a1!=0){
        	bar1.setProgress(a1);
        	tv1.setText(Integer.toString(a1)+"%");
        }
        if(a2!=0){
        	bar2.setProgress(a2);
        	tv2.setText(Integer.toString(a2)+"%");
        }
        if(a3!=0){
        	bar3.setProgress(a3);
        	tv3.setText(Integer.toString(a3)+"%");
        }
        if(a4!=0){
        	bar4.setProgress(a4);
        	tv4.setText(Integer.toString(a4)+"%");
        }
        if(a5!=0){
        	bar5.setProgress(a5);
        	tv5.setText(Integer.toString(a5)+"%");
        }
        if(a6!=0){
        	bar6.setProgress(a6);
        	tv6.setText(Integer.toString(a6)+"%");
        }
        if(a7!=0){
        	bar7.setProgress(a7);
        	tv7.setText(Integer.toString(a7)+"%");
        }
        if(a8!=0){
        	bar8.setProgress(a8);
        	tv8.setText(Integer.toString(a8)+"%");
        }
        if(a9!=0){
        	bar9.setProgress(a9);
        	tv9.setText(Integer.toString(a9)+"%");
        }
        if(a10!=0){
        	bar10.setProgress(a10);
        	tv10.setText(Integer.toString(a10)+"%");
        }
        if(a11!=0){
        	bar11.setProgress(a11);
        	tv11.setText(Integer.toString(a11)+"%");
        }
        if(a12!=0){
        	bar12.setProgress(a12);
        	tv12.setText(Integer.toString(a12)+"%");
        }
        if(a13!=0){
        	bar13.setProgress(a13);
        	tv13.setText(Integer.toString(a13)+"%");
        }
        if(a14!=0){
        	bar14.setProgress(a14);
        	tv14.setText(Integer.toString(a14)+"%");
        }
        if(a15!=0){
        	bar15.setProgress(a15);
        	tv15.setText(Integer.toString(a15)+"%");
        }
        if(a16!=0){
        	bar16.setProgress(a16);
        	tv16.setText(Integer.toString(a16)+"%");
        }
        if(a17!=0){
        	bar17.setProgress(a17);
        	tv17.setText(Integer.toString(a17)+"%");
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
