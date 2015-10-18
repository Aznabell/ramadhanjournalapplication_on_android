package pklapp.ramadhanjournal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MyActivityImageAdapter extends BaseAdapter {
	
	private Context mContext;
	
	public Integer[] mIconId = {
		R.drawable.grid1, R.drawable.grid2, R.drawable.grid3, R.drawable.grid4, R.drawable.grid5, R.drawable.grid6, R.drawable.grid7, R.drawable.grid8, R.drawable.grid9, 
		R.drawable.grid10, R.drawable.grid11, R.drawable.grid12, R.drawable.grid13, R.drawable.grid14, R.drawable.grid15, R.drawable.grid16, R.drawable.grid17, R.drawable.grid18, R.drawable.grid19,
		R.drawable.grid20, R.drawable.grid21, R.drawable.grid22, R.drawable.grid23, R.drawable.grid24, R.drawable.grid25, R.drawable.grid26, R.drawable.grid27, R.drawable.grid28, R.drawable.grid29
	};
	
	public MyActivityImageAdapter (Context c){
		mContext = c;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mIconId.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mIconId[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView imageview = new ImageView(mContext);
		imageview.setImageResource(mIconId[position]);
		imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
		imageview.setLayoutParams(new GridView.LayoutParams (60, 60));
		return imageview;
	}
	
	

}
