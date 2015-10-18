package pklapp.ramadhanjournal;

import pklapp.ramadhanjournal.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;


public class MyActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_myactivity);
		GridView gridview = (GridView)findViewById(R.id.grid_view);
		gridview.setAdapter(new MyActivityImageAdapter(this));
		gridview.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id){
				Intent i = new Intent(getApplicationContext(),MyActivityGridResponse.class);
				i.putExtra("id", position);
				startActivity(i);
				
			}
		});
			
		
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
