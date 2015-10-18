package pklapp.ramadhanjournal;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;


public class MyStatistic extends TabActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mystatistic);
		
		TabHost tabHost = getTabHost();
		
		// Tab for daily statistic
        TabSpec dailystatisticspec = tabHost.newTabSpec("Daily Statistic");
        // setting Title and Icon for the Tab
        dailystatisticspec.setIndicator("Daily Statistic", getResources().getDrawable(R.drawable.icon_dailystatistic));
        Intent dailystatisticIntent = new Intent(this, DailyStatisticActivity.class);
        dailystatisticspec.setContent(dailystatisticIntent);
		
        // Tab for weekly statistic
        TabSpec weeklystatisticspec = tabHost.newTabSpec("Weekly Statistic");
        // setting Title and Icon for the Tab
        weeklystatisticspec.setIndicator("Weekly Statistic", getResources().getDrawable(R.drawable.icon_weeklystatistic));
        Intent weeklystatisticIntent = new Intent(this, WeeklyStatisticActivity.class);
        weeklystatisticspec.setContent(weeklystatisticIntent);
        
        // Tab for monthly statistic
        TabSpec monthlystatisticspec = tabHost.newTabSpec("Monthly Statistic");
        // setting Title and Icon for the Tab
        monthlystatisticspec.setIndicator("Monthly Statistic", getResources().getDrawable(R.drawable.icon_monthlystatistic));
        Intent monthlystatisticIntent = new Intent(this, MonthlyStatisticActivity.class);
        monthlystatisticspec.setContent(monthlystatisticIntent);
        
        tabHost.addTab(dailystatisticspec);
        tabHost.addTab(weeklystatisticspec);
        tabHost.addTab(monthlystatisticspec);
        GlobalDataClass gdc = new GlobalDataClass(this);
        TextView tv = (TextView)findViewById(R.id.TextViewDate);
        tv.setText((gdc.getSessionID()+1)+" Ramadhan");
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
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
}
}