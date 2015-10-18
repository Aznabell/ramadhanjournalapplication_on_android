package pklapp.ramadhanjournal;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class MyActivityGridResponse extends TabActivity {
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_myactivity_gridresponse);
		TextView tv = (TextView)findViewById(R.id.TextViewDate);
		TabHost tabHost = getTabHost();
		
		// Tab for daily prayer
        TabSpec dailyprayerspec = tabHost.newTabSpec("Daily Prayer");
        // setting Title and Icon for the Tab
        dailyprayerspec.setIndicator("Daily Prayer", getResources().getDrawable(R.drawable.icon_dailyprayer));
        Intent dailyprayerIntent = new Intent(this, DailyPrayerActivity.class);
        dailyprayerspec.setContent(dailyprayerIntent);
		
     // Tab for good deed
        TabSpec gooddeedspec = tabHost.newTabSpec("Good Deed");
        // setting Title and Icon for the Tab
        gooddeedspec.setIndicator("Good Deed", getResources().getDrawable(R.drawable.icon_gooddeed));
        Intent gooddeedIntent = new Intent(this, GoodDeedActivity.class);
        gooddeedspec.setContent(gooddeedIntent);
        
        
        tabHost.addTab(gooddeedspec);
        tabHost.addTab(dailyprayerspec);
        
		// get intent data
        Intent i = getIntent();
        //test value of i
        int position = i.getExtras().getInt("id");
        GlobalDataClass gdc = new GlobalDataClass(this);
        gdc.createIDSession(position);
        tv.setText((gdc.getSessionID()+1)+" Ramadhan");
        //String textposition = Integer.toString(a.getID());
        //TextView textview = (TextView)findViewById(R.id.textView1);
        //textview.setText(textposition);
       
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