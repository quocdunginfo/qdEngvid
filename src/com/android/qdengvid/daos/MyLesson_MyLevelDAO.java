package com.android.qdengvid.daos;

import java.util.ArrayList;

import android.content.Context;

import com.android.qdengvid.entities.MyLesson_MyLevel;
import com.android.qdengvid.entities.MyLevel;
import com.j256.ormlite.dao.RuntimeExceptionDao;

public class MyLesson_MyLevelDAO extends _MyDAOAbstract<MyLesson_MyLevelDAO, MyLesson_MyLevel>
		implements _MyDAOInterface<MyLesson_MyLevelDAO, MyLesson_MyLevel> {

	public MyLesson_MyLevelDAO(Context ctx, GlobalDAO g) {
		super(ctx, g);
	}

	@Override
	public RuntimeExceptionDao<MyLesson_MyLevel, Integer> getDao() {
		if (getManager() != null && getHelper() != null) {
			return getHelper().getMyLesson_MyLevelDAO();
		}
		return null;
	}

	@Override
	public ArrayList<MyLesson_MyLevel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyLesson_MyLevel getById(Integer id) {
		MyLesson_MyLevel obj = getDao().queryForId(id);
		obj.setDao(this);
		obj.setLoaded(true);
		return obj;
	}

	@Override
	public Integer insert(MyLesson_MyLevel obj) {
		return 1;
	}
}
