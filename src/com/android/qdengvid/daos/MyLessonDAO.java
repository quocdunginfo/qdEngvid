package com.android.qdengvid.daos;

import java.util.ArrayList;

import android.content.Context;

import com.android.qdengvid.entities.MyLesson;
import com.j256.ormlite.dao.RuntimeExceptionDao;

public class MyLessonDAO extends _MyDAOAbstract<MyLessonDAO, MyLesson>
		implements _MyDAOInterface<MyLessonDAO, MyLesson> {

	public MyLessonDAO(Context ctx, GlobalDAO g) {
		super(ctx, g);
	}

	@Override
	public RuntimeExceptionDao<MyLesson, Integer> getDao() {
		if (getManager() != null && getHelper() != null) {
			return getHelper().getMyLessonDAO();
		}
		return null;
	}

	@Override
	public ArrayList<MyLesson> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyLesson getById(Integer id) {
		MyLesson obj = getDao().queryForId(id);
		obj.setDao(this);
		obj.setLoaded(true);
		return obj;
	}

	@Override
	public Integer insert(MyLesson obj) {
		return 1;
	}
}
