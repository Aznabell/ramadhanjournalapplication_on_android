package pklapp.ramadhanjournal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DailyPrayerSQL {

	public static final String ID = "_id";
	public static final String FAJR = "Sfajr";
	public static final String DZUHUR = "Sdzuhur";
	public static final String ASHR= "Sashr";
	public static final String MAGRIB = "Smagrib";
	public static final String ISYA = "Sisya";
	public static final String DHUHA = "Sdhuha";
	public static final String TAHAJUD = "Stahajud";
	public static final String TARAWEH = "Staraweh";
	public static final String WITIR = "Switir";
	
	private static final String DATABASE_NAME = "le_sqldb";
	private static final String DATABASE_TABLE = "le_table";
	private static final int DATABASE_VERSION = 1;
	
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	
	private static class DbHelper extends SQLiteOpenHelper{

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
					ID + " INTEGER PRIMARY KEY, " +
					FAJR + " INTEGER NULL, " + 
					DZUHUR + " INTEGER NULL, " +
					ASHR + " INTEGER NULL," +
					MAGRIB + " INTEGER NULL, " +
					ISYA + " INTEGER NULL, " +
					DHUHA + " INTEGER NULL, " +
					TAHAJUD + " INTEGER NULL, " +
					TARAWEH + " INTEGER NULL, " +
					WITIR + " INTEGER NULL);"
					);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXIST "+DATABASE_TABLE);
			onCreate(db);
		}
		
	}
	public DailyPrayerSQL(Context c){
		ourContext = c;
	}
	
	public DailyPrayerSQL open() throws SQLException{
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
	
	public void close(){
		ourHelper.close();
	}

	public int setSQLDailyPrayerInit() {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 28", null, null, null, null);
		int iID = c.getColumnIndex(ID);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		if(b!=0){
		return 1;
		}else{
		return 0;}
	}

	public long setInitID(int i) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(ID, i);
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
	}

	public void inputSQLData(int id2, int a, int b, int c, int d, int e, int f,
			int g, int h, int i) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(FAJR, a);cv.put(MAGRIB, d);cv.put(TAHAJUD, g);
		cv.put(DZUHUR, b);cv.put(ISYA, e);cv.put(TARAWEH, h);
		cv.put(ASHR, c);cv.put(DHUHA, f);cv.put(WITIR, i);
		ourDatabase.update(DATABASE_TABLE, cv, ID + "=" + id2, null);
	}

	public String getFajr(long l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + "=" + l, null, null, null, null);
		if (c!=null){
			c.moveToFirst();
			int adata = c.getInt(1);
			return Integer.toString(adata);
		}
		return Integer.toString(0);
	}

	public String getDzuhur(long l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + "=" + l, null, null, null, null);
		if (c!=null){
			c.moveToFirst();
			int bdata = c.getInt(2);
			return Integer.toString(bdata);
		}
		return Integer.toString(0);
	}

	public String getAshr(long l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + "=" + l, null, null, null, null);
		if (c!=null){
			c.moveToFirst();
			int cdata = c.getInt(3);
			return Integer.toString(cdata);
		}
		return Integer.toString(0);
	}

	public String getMagrib(long l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + "=" + l, null, null, null, null);
		if (c!=null){
			c.moveToFirst();
			int ddata = c.getInt(4);
			return Integer.toString(ddata);
		}
		return Integer.toString(0);
	}

	public String getIsya(long l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + "=" + l, null, null, null, null);
		if (c!=null){
			c.moveToFirst();
			int edata = c.getInt(5);
			return Integer.toString(edata);
		}
		return Integer.toString(0);
	}

	public String getDhuha(long l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + "=" + l, null, null, null, null);
		if (c!=null){
			c.moveToFirst();
			int fdata = c.getInt(6);
			return Integer.toString(fdata);
		}
		return Integer.toString(0);
	}

	public String getTahajud(long l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + "=" + l, null, null, null, null);
		if (c!=null){
			c.moveToFirst();
			int gdata = c.getInt(7);
			return Integer.toString(gdata);
		}
		return Integer.toString(0);
	}

	public String getTaraweh(long l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + "=" + l, null, null, null, null);
		if (c!=null){
			c.moveToFirst();
			int hdata = c.getInt(8);
			return Integer.toString(hdata);
		}
		return Integer.toString(0);
	}

	public String getWitir(long l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + "=" + l, null, null, null, null);
		if (c!=null){
			c.moveToFirst();
			int idata = c.getInt(9);
			return Integer.toString(idata);
		}
		return Integer.toString(0);
	}

	public String getWeeklyFajr(int l) {
		// TODO Auto-generated method stub
		if (l<7){
		String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 6", null, null, null, null);
		int iID = c.getColumnIndex(FAJR);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		int result = (b*100)/7;
		return Integer.toString(result);
		}else if (l<14){
		String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 7 AND 13", null, null, null, null);
		int iID = c.getColumnIndex(FAJR);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		int result = (b*100)/7;
		return Integer.toString(result);
		}else if (l<21){
		String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 14 AND 20", null, null, null, null);
		int iID = c.getColumnIndex(FAJR);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		int result = (b*100)/7;
		return Integer.toString(result);
		}else if (l<29){
		String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 21 AND 28", null, null, null, null);
		int iID = c.getColumnIndex(FAJR);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		int result = (b*100)/7;
		return Integer.toString(result);
		}else{
		return Integer.toString(0);
		}
	}

	public String getWeeklyDzuhur(int l) {
		// TODO Auto-generated method stub
		if (l<7){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 6", null, null, null, null);
			int iID = c.getColumnIndex(DZUHUR);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else if (l<14){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 7 AND 13", null, null, null, null);
			int iID = c.getColumnIndex(DZUHUR);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else if (l<21){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 14 AND 20", null, null, null, null);
			int iID = c.getColumnIndex(DZUHUR);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else if (l<29){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 21 AND 28", null, null, null, null);
			int iID = c.getColumnIndex(DZUHUR);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else{
			return Integer.toString(0);
			}
	}

	public String getWeeklyAshr(int l) {
		// TODO Auto-generated method stub
		if (l<7){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 6", null, null, null, null);
			int iID = c.getColumnIndex(ASHR);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else if (l<14){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 7 AND 13", null, null, null, null);
			int iID = c.getColumnIndex(ASHR);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else if (l<21){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 14 AND 20", null, null, null, null);
			int iID = c.getColumnIndex(ASHR);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else if (l<29){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 21 AND 28", null, null, null, null);
			int iID = c.getColumnIndex(ASHR);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else{
			return Integer.toString(0);
			}
	}

	public String getWeeklyMagrib(int l) {
		// TODO Auto-generated method stub
		if (l<7){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 6", null, null, null, null);
			int iID = c.getColumnIndex(MAGRIB);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else if (l<14){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 7 AND 13", null, null, null, null);
			int iID = c.getColumnIndex(MAGRIB);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else if (l<21){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 14 AND 20", null, null, null, null);
			int iID = c.getColumnIndex(MAGRIB);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else if (l<29){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 21 AND 28", null, null, null, null);
			int iID = c.getColumnIndex(MAGRIB);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else{
			return Integer.toString(0);
			}
	}

	public String getWeeklyIsya(int l) {
		// TODO Auto-generated method stub
		if (l<7){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 6", null, null, null, null);
			int iID = c.getColumnIndex(ISYA);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else if (l<14){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 7 AND 13", null, null, null, null);
			int iID = c.getColumnIndex(ISYA);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else if (l<21){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 14 AND 20", null, null, null, null);
			int iID = c.getColumnIndex(ISYA);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else if (l<29){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 21 AND 28", null, null, null, null);
			int iID = c.getColumnIndex(ISYA);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else{
			return Integer.toString(0);
			}
	}

	public String getWeeklyDhuha(int l) {
		// TODO Auto-generated method stub
		if (l<7){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 6", null, null, null, null);
			int iID = c.getColumnIndex(DHUHA);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else if (l<14){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 7 AND 13", null, null, null, null);
			int iID = c.getColumnIndex(DHUHA);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else if (l<21){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 14 AND 20", null, null, null, null);
			int iID = c.getColumnIndex(DHUHA);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else if (l<29){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 21 AND 28", null, null, null, null);
			int iID = c.getColumnIndex(DHUHA);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else{
			return Integer.toString(0);
			}
	}

	public String getWeeklyTahajud(int l) {
		// TODO Auto-generated method stub
		if (l<7){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 6", null, null, null, null);
			int iID = c.getColumnIndex(TAHAJUD);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else if (l<14){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 7 AND 13", null, null, null, null);
			int iID = c.getColumnIndex(TAHAJUD);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else if (l<21){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 14 AND 20", null, null, null, null);
			int iID = c.getColumnIndex(TAHAJUD);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else if (l<29){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 21 AND 28", null, null, null, null);
			int iID = c.getColumnIndex(TAHAJUD);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else{
			return Integer.toString(0);
			}
	}

	public String getWeeklyTaraweh(int l) {
		// TODO Auto-generated method stub
		if (l<7){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 6", null, null, null, null);
			int iID = c.getColumnIndex(TARAWEH);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else if (l<14){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 7 AND 13", null, null, null, null);
			int iID = c.getColumnIndex(TARAWEH);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else if (l<21){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 14 AND 20", null, null, null, null);
			int iID = c.getColumnIndex(TARAWEH);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else if (l<29){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 21 AND 28", null, null, null, null);
			int iID = c.getColumnIndex(TARAWEH);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else{
			return Integer.toString(0);
			}
	}

	public String getWeeklyWitir(int l) {
		// TODO Auto-generated method stub
		if (l<7){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 6", null, null, null, null);
			int iID = c.getColumnIndex(WITIR);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else if (l<14){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 7 AND 13", null, null, null, null);
			int iID = c.getColumnIndex(WITIR);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else if (l<21){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 14 AND 20", null, null, null, null);
			int iID = c.getColumnIndex(WITIR);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else if (l<29){
			String[] columns = new String[]{ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 21 AND 28", null, null, null, null);
			int iID = c.getColumnIndex(WITIR);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int result = (b*100)/7;
			return Integer.toString(result);
			}else{
			return Integer.toString(0);
			}
	}

	public String getMonthlyFajr(int l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 28", null, null, null, null);
		int iID = c.getColumnIndex(FAJR);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		if(b!=0){
			int result = (b*100)/30;
			return Integer.toString(result);
			}else{
		return Integer.toString(0);
		}
	}

	public String getMonthlyDzuhur(int l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 28", null, null, null, null);
		int iID = c.getColumnIndex(DZUHUR);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		if(b!=0){
			int result = (b*100)/30;
			return Integer.toString(result);
			}else{
		return Integer.toString(0);
		}
	}

	public String getMonthlyAshr(int l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 28", null, null, null, null);
		int iID = c.getColumnIndex(ASHR);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		if(b!=0){
			int result = (b*100)/30;
			return Integer.toString(result);
			}else{
		return Integer.toString(0);
		}
	}

	public String getMonthlyMagrib(int l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 28", null, null, null, null);
		int iID = c.getColumnIndex(MAGRIB);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		if(b!=0){
			int result = (b*100)/30;
			return Integer.toString(result);
			}else{
		return Integer.toString(0);
		}
	}

	public String getMonthlyIsya(int l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 28", null, null, null, null);
		int iID = c.getColumnIndex(ISYA);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		if(b!=0){
			int result = (b*100)/30;
			return Integer.toString(result);
			}else{
		return Integer.toString(0);
		}
	}

	public String getMonthlyDhuha(int l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 28", null, null, null, null);
		int iID = c.getColumnIndex(DHUHA);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		if(b!=0){
			int result = (b*100)/30;
			return Integer.toString(result);
			}else{
		return Integer.toString(0);
		}
	}

	public String getMonthlyTahajud(int l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 28", null, null, null, null);
		int iID = c.getColumnIndex(TAHAJUD);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		if(b!=0){
			int result = (b*100)/30;
			return Integer.toString(result);
			}else{
		return Integer.toString(0);
		}
	}

	public String getMonthlyTaraweh(int l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 28", null, null, null, null);
		int iID = c.getColumnIndex(TARAWEH);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		if(b!=0){
			int result = (b*100)/30;
			return Integer.toString(result);
			}else{
		return Integer.toString(0);
		}
	}

	public String getMonthlyWitir(int l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,ID,FAJR,DZUHUR,ASHR,MAGRIB,ISYA,DHUHA,TAHAJUD,TARAWEH,WITIR};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 28", null, null, null, null);
		int iID = c.getColumnIndex(WITIR);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		if(b!=0){
			int result = (b*100)/30;
			return Integer.toString(result);
			}else{
		return Integer.toString(0);
		}
	}

	
}
