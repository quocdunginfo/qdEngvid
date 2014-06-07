package com.android.qdengvid.dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.android.qdengvid.entities.MyLesson;
import com.android.qdengvid.entities.MyLesson_MyLevel;
import com.android.qdengvid.entities.MyLevel;
import com.android.qdengvid.entities.MyTeacher;
import com.android.qdengvid.entities.MyTopic;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class MySQLiteHelper extends OrmLiteSqliteOpenHelper {
	private static final String DATABASE_NAME = "QDENGVID_DB";
	private static final int DATABASE_VERSION = 4;

	public MySQLiteHelper(Context ctx) {
		super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public void resetDB() {
		onUpgrade(getWritableDatabase(), getConnectionSource(),
				DATABASE_VERSION, DATABASE_VERSION + 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
		try {
			TableUtils.createTable(connectionSource, MyLevel.class);
			TableUtils.createTable(connectionSource, MyLesson.class);
			TableUtils.createTable(connectionSource, MyTopic.class);
			TableUtils.createTable(connectionSource, MyTeacher.class);
			TableUtils.createTable(connectionSource, MyLesson_MyLevel.class);
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		}
		// init new data...
	}

	@Override
	public void onUpgrade(SQLiteDatabase database,
			ConnectionSource connectionSource, int oldVersion, int newVersion) {
		// destroy whole db
		try {
			TableUtils.dropTable(connectionSource, MyLevel.class, true);
			TableUtils.dropTable(connectionSource, MyLesson.class, true);
			TableUtils.dropTable(connectionSource, MyTopic.class, true);
			TableUtils.dropTable(connectionSource, MyTeacher.class, true);
			TableUtils.dropTable(connectionSource, MyLesson_MyLevel.class, true);
		} catch (java.sql.SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// create new one
		onCreate(database, connectionSource);
		// init pre-data
		// ...
	}

	/**
	 * Nen dung RuntimeExceptionDAO vi neu dung Dao binh thuong Trong nhieu
	 * truong hop se bi quang SQLExeption, mac du du lieu van duoc thuc thi tot
	 * !!!!!!!!!
	 */
	private RuntimeExceptionDao<MyLevel, Integer> _myLevelDAO = null;

	public RuntimeExceptionDao<MyLevel, Integer> getMyLevelDAO() {
		if (_myLevelDAO == null) {
			_myLevelDAO = getRuntimeExceptionDao(MyLevel.class);// do not use
																// DaoManager.create(...);
		}
		return _myLevelDAO;
	}

	private RuntimeExceptionDao<MyTopic, Integer> _myTopicDAO = null;

	public RuntimeExceptionDao<MyTopic, Integer> getMyTopicDAO() {
		if (_myTopicDAO == null) {
			_myTopicDAO = getRuntimeExceptionDao(MyTopic.class);// do not use
																// DaoManager.create(...);
		}
		return _myTopicDAO;
	}

	

	private RuntimeExceptionDao<MyLesson, Integer> _myLessonDAO = null;

	public RuntimeExceptionDao<MyLesson, Integer> getMyLessonDAO() {
		if (_myLessonDAO == null) {
			_myLessonDAO = getRuntimeExceptionDao(MyLesson.class);// do not use
																// DaoManager.create(...);
		}
		return _myLessonDAO;
	}

	private RuntimeExceptionDao<MyTeacher, Integer> _myTeacherDAO = null;

	public RuntimeExceptionDao<MyTeacher, Integer> getMyTeacherDAO() {
		if (_myTeacherDAO == null) {
			_myTeacherDAO = getRuntimeExceptionDao(MyTeacher.class);
			// do not
			// DaoManager.create(...);
		}
		return _myTeacherDAO;
	}
	
	private RuntimeExceptionDao<MyLesson_MyLevel, Integer> _myLesson_MyLevelDAO = null;

	public RuntimeExceptionDao<MyLesson_MyLevel, Integer> getMyLesson_MyLevelDAO() {
		if (_myLesson_MyLevelDAO == null) {
			_myLesson_MyLevelDAO = getRuntimeExceptionDao(MyLesson_MyLevel.class);
			// do not
			// DaoManager.create(...);
		}
		return _myLesson_MyLevelDAO;
	}

	
	@Override
	public void close() {
		// very importance because àter close there are no way to get it open
		// again
		// not tested all yet but at current time, do not call super.close or
		// you
		// might be encountred illegalExcaption when reset DB via upgrade
		// super.close();
		_myLessonDAO = null;
		_myTopicDAO = null;
		_myLevelDAO = null;
		_myTeacherDAO = null;
		_myLesson_MyLevelDAO = null;
	}
}
