package pklapp.ramadhanjournal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class GoodDeedSQL {

	public static final String ID = "_id";
	public static final String RECITE_ALQURAN = "_recite_alquran";
	public static final String SHALATFAJR = "_shalat_fajr_mosque";
	public static final String SHADAQAH= "_shadaqah";
	public static final String ITIKAF = "_itikaf";
	public static final String IFTAR = "_iftar";
	public static final String DZIKIR = "_dzikir";
	public static final String SHALATTARAWIH = "_shalat_tarawih_mosque";
	public static final String UMRAH = "_umrah";
	
	private static final String DATABASE_NAME = "lemay_sqldb";
	private static final String DATABASE_TABLE = "lemay_table";
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
					RECITE_ALQURAN + " INTEGER NULL, " + 
					SHALATFAJR + " INTEGER NULL, " +
					SHADAQAH + " INTEGER NULL," +
					ITIKAF + " INTEGER NULL, " +
					IFTAR + " INTEGER NULL, " +
					DZIKIR + " INTEGER NULL, " +
					SHALATTARAWIH + " INTEGER NULL, " +
					UMRAH + " INTEGER NULL);"
					);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXIST "+DATABASE_TABLE);
			onCreate(db);
		}
		
	}
	
	public GoodDeedSQL(Context c){
		ourContext = c;
	}
	
	public GoodDeedSQL open() throws SQLException{
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
	
	public void close(){
		ourHelper.close();
	}

	public void inputData(int id2, int a, int b, int c, int d, int e, int f,
			int g, int h) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(RECITE_ALQURAN, a);
		cv.put(SHALATFAJR, b);
		cv.put(SHADAQAH, c);
		cv.put(ITIKAF, d);
		cv.put(IFTAR, e);
		cv.put(DZIKIR, f);
		cv.put(SHALATTARAWIH, g);
		cv.put(UMRAH, h);
		ourDatabase.update(DATABASE_TABLE, cv, ID + "=" + id2, null);
	}

	public String getReciteAlquranData(long l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + "=" + l, null, null, null, null);
		if (c!=null){
			c.moveToFirst();
			int adata = c.getInt(1);
			return Integer.toString(adata);
		}
		return Integer.toString(0);
	}

	public String getShalatFajrData(long l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + "=" + l, null, null, null, null);
		if (c!=null){
			c.moveToFirst();
			int bdata = c.getInt(2);
			return Integer.toString(bdata);
		}
		return Integer.toString(0);
	}

	public String getShadaqahData(long l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + "=" + l, null, null, null, null);
		if (c!=null){
			c.moveToFirst();
			int cdata = c.getInt(3);
			return Integer.toString(cdata);
		}
		return Integer.toString(0);
	}

	public String getItikaf(long l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + "=" + l, null, null, null, null);
		if (c!=null){
			c.moveToFirst();
			int ddata = c.getInt(4);
			return Integer.toString(ddata);
		}
		return Integer.toString(0);
	}

	public String getIftar(long l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + "=" + l, null, null, null, null);
		if (c!=null){
			c.moveToFirst();
			int edata = c.getInt(5);
			return Integer.toString(edata);
		}
		return Integer.toString(0);
	}

	public String getDzikir(long l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + "=" + l, null, null, null, null);
		if (c!=null){
			c.moveToFirst();
			int fdata = c.getInt(6);
			return Integer.toString(fdata);
		}
		return Integer.toString(0);
	}

	public String getSTarawih(long l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + "=" + l, null, null, null, null);
		if (c!=null){
			c.moveToFirst();
			int gdata = c.getInt(7);
			return Integer.toString(gdata);
		}
		return Integer.toString(0);
	}

	public String getUmrah(long l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + "=" + l, null, null, null, null);
		if (c!=null){
			c.moveToFirst();
			int hdata = c.getInt(8);
			return Integer.toString(hdata);
		}
		return Integer.toString(0);
	}

	public String getWeeklyReciteAlquran(int l) {
		// TODO Auto-generated method stub
		if (l<7){
		String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 6", null, null, null, null);
		int iID = c.getColumnIndex(RECITE_ALQURAN);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		int result = (b*100)/7;
		return Integer.toString(result);
		}else if (l<14){
		String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 7 AND 13", null, null, null, null);
		int iID = c.getColumnIndex(RECITE_ALQURAN);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		int result = (b*100)/7;
		return Integer.toString(result);
		}else if (l<21){
		String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 14 AND 20", null, null, null, null);
		int iID = c.getColumnIndex(RECITE_ALQURAN);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		int result = (b*100)/7;
		return Integer.toString(result);
		}else if (l<29){
		String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 21 AND 28", null, null, null, null);
		int iID = c.getColumnIndex(RECITE_ALQURAN);
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

	public String getWeeklyShalatFajr(int l) {
		// TODO Auto-generated method stub
		if (l<7){
			String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 6", null, null, null, null);
			int iID = c.getColumnIndex(SHALATFAJR);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int resultb = (b*100)/7;
			return Integer.toString(resultb);
			}else if (l<14){
			String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 7 AND 13", null, null, null, null);
			int iID = c.getColumnIndex(SHALATFAJR);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int resultb = (b*100)/7;
			return Integer.toString(resultb);
			}else if (l<21){
			String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 14 AND 20", null, null, null, null);
			int iID = c.getColumnIndex(SHALATFAJR);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int resultb = (b*100)/7;
			return Integer.toString(resultb);
			}else if (l<29){
			String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 21 AND 28", null, null, null, null);
			int iID = c.getColumnIndex(SHALATFAJR);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int resultb = (b*100)/7;
			return Integer.toString(resultb);
			}
		return Integer.toString(0);
	}

	public String getWeeklyShadaqah(int l) {
		// TODO Auto-generated method stub
		if (l<7){
			String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 6", null, null, null, null);
			int iID = c.getColumnIndex(SHADAQAH);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int resultc = (b*100)/7;
			return Integer.toString(resultc);
			}else if (l<14){
			String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 7 AND 13", null, null, null, null);
			int iID = c.getColumnIndex(SHADAQAH);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int resultc = (b*100)/7;
			return Integer.toString(resultc);
			}else if (l<21){
			String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 14 AND 20", null, null, null, null);
			int iID = c.getColumnIndex(SHADAQAH);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int resultc = (b*100)/7;
			return Integer.toString(resultc);
			}else if (l<29){
			String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 21 AND 28", null, null, null, null);
			int iID = c.getColumnIndex(SHADAQAH);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int resultc = (b*100)/7;
			return Integer.toString(resultc);
			}
		return Integer.toString(0);
	}

	public String getWeeklyItikaf(int l) {
		// TODO Auto-generated method stub
		if (l<7){
			String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 6", null, null, null, null);
			int iID = c.getColumnIndex(ITIKAF);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int resultd = (b*100)/7;
			return Integer.toString(resultd);
			}else if (l<14){
			String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 7 AND 13", null, null, null, null);
			int iID = c.getColumnIndex(ITIKAF);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int resultd = (b*100)/7;
			return Integer.toString(resultd);
			}else if (l<21){
			String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 14 AND 20", null, null, null, null);
			int iID = c.getColumnIndex(ITIKAF);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int resultd = (b*100)/7;
			return Integer.toString(resultd);
			}else if (l<29){
			String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 21 AND 28", null, null, null, null);
			int iID = c.getColumnIndex(ITIKAF);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int resultd = (b*100)/7;
			return Integer.toString(resultd);
			}
		return Integer.toString(0);
	}

	public String getWeeklyIftar(int l) {
		// TODO Auto-generated method stub
		if (l<7){
			String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 6", null, null, null, null);
			int iID = c.getColumnIndex(IFTAR);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int resulte = (b*100)/7;
			return Integer.toString(resulte);
			}else if (l<14){
			String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 7 AND 13", null, null, null, null);
			int iID = c.getColumnIndex(IFTAR);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int resulte = (b*100)/7;
			return Integer.toString(resulte);
			}else if (l<21){
			String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 14 AND 20", null, null, null, null);
			int iID = c.getColumnIndex(IFTAR);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int resulte = (b*100)/7;
			return Integer.toString(resulte);
			}else if (l<29){
			String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 21 AND 28", null, null, null, null);
			int iID = c.getColumnIndex(IFTAR);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int resulte = (b*100)/7;
			return Integer.toString(resulte);
			}
		return Integer.toString(0);
	}

	public String getWeeklyDzikir(int l) {
		// TODO Auto-generated method stub
		if (l<7){
			String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 6", null, null, null, null);
			int iID = c.getColumnIndex(DZIKIR);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int resultf = (b*100)/7;
			return Integer.toString(resultf);
			}else if (l<14){
			String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 7 AND 13", null, null, null, null);
			int iID = c.getColumnIndex(DZIKIR);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int resultf = (b*100)/7;
			return Integer.toString(resultf);
			}else if (l<21){
			String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 14 AND 20", null, null, null, null);
			int iID = c.getColumnIndex(DZIKIR);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int resultf = (b*100)/7;
			return Integer.toString(resultf);
			}else if (l<29){
			String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 21 AND 28", null, null, null, null);
			int iID = c.getColumnIndex(DZIKIR);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int resultf = (b*100)/7;
			return Integer.toString(resultf);
			}
		return Integer.toString(0);
	}

	public String getWeeklySTarawih(int l) {
		// TODO Auto-generated method stub
		if (l<7){
			String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 6", null, null, null, null);
			int iID = c.getColumnIndex(SHALATTARAWIH);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int resultg = (b*100)/7;
			return Integer.toString(resultg);
			}else if (l<14){
			String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 7 AND 13", null, null, null, null);
			int iID = c.getColumnIndex(SHALATTARAWIH);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int resultg = (b*100)/7;
			return Integer.toString(resultg);
			}else if (l<21){
			String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 14 AND 20", null, null, null, null);
			int iID = c.getColumnIndex(SHALATTARAWIH);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int resultg = (b*100)/7;
			return Integer.toString(resultg);
			}else if (l<29){
			String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 21 AND 28", null, null, null, null);
			int iID = c.getColumnIndex(SHALATTARAWIH);
			int a = 0;
			int b = 0;
			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				a = c.getInt(iID);
				b = b+a;
			}
			int resultg = (b*100)/7;
			return Integer.toString(resultg);
			}
		return Integer.toString(0);
	}

	public String getWeekyUmrah(int l) {
		// TODO Auto-generated method stub
		
		String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 28", null, null, null, null);
		int iID = c.getColumnIndex(UMRAH);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		if(b!=0){
		int resultg = 100;
		return Integer.toString(resultg);
		}
		return Integer.toString(0);
	}

	public String getMonthlyReciteAlquran(int l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 28", null, null, null, null);
		int iID = c.getColumnIndex(RECITE_ALQURAN);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		if(b!=0){
		int result = (b*100)/30;
		return Integer.toString(result);
		}
		return Integer.toString(0);
	}

	public String getMonthlyShalatFajr(int l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 28", null, null, null, null);
		int iID = c.getColumnIndex(SHALATFAJR);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		if(b!=0){
		int resultb = (b*100)/30;
		return Integer.toString(resultb);
		}
		return Integer.toString(0);
	}

	public String getMonthlyShadaqah(int l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 28", null, null, null, null);
		int iID = c.getColumnIndex(SHADAQAH);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		if(b!=0){
		int resultc = (b*100)/30;
		return Integer.toString(resultc);
		}
		return Integer.toString(0);
	}

	public String getMonthlyItikaf(int l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 28", null, null, null, null);
		int iID = c.getColumnIndex(ITIKAF);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		if(b!=0){
		int resultd = (b*100)/30;
		return Integer.toString(resultd);
		}
		return Integer.toString(0);
	}

	public String getMonthlyIftar(int l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 28", null, null, null, null);
		int iID = c.getColumnIndex(IFTAR);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		if(b!=0){
		int resulte = (b*100)/30;
		return Integer.toString(resulte);
		}
		return Integer.toString(0);
	}

	public String getMonthlyDzikir(int l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 28", null, null, null, null);
		int iID = c.getColumnIndex(DZIKIR);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		if(b!=0){
		int resultf = (b*100)/30;
		return Integer.toString(resultf);
		}
		return Integer.toString(0);
	}

	public String getMonthlySTarawih(int l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 28", null, null, null, null);
		int iID = c.getColumnIndex(SHALATTARAWIH);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		if(b!=0){
		int resultg = (b*100)/30;
		return Integer.toString(resultg);
		}
		return Integer.toString(0);
	}

	public String getMonthlyUmrah(int l) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, ID + " BETWEEN 0 AND 28", null, null, null, null);
		int iID = c.getColumnIndex(UMRAH);
		int a = 0;
		int b = 0;
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			a = c.getInt(iID);
			b = b+a;
		}
		if(b!=0){
		int resultg = 100;
		return Integer.toString(resultg);
		}
		return Integer.toString(0);
	}

	public int setGoodDeedSQLInit() {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ID,RECITE_ALQURAN,SHALATFAJR,SHADAQAH,ITIKAF,IFTAR,DZIKIR,SHALATTARAWIH,UMRAH};
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
}
