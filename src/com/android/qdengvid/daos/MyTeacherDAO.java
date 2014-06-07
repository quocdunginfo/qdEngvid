package com.android.qdengvid.daos;

import java.util.ArrayList;

import android.content.Context;

import com.android.qdengvid.entities.MyTeacher;
import com.j256.ormlite.dao.RuntimeExceptionDao;

public class MyTeacherDAO extends _MyDAOAbstract<MyTeacherDAO, MyTeacher>
		implements _MyDAOInterface<MyTeacherDAO, MyTeacher> {

	public MyTeacherDAO(Context ctx, GlobalDAO g) {
		super(ctx, g);
	}

	@Override
	public RuntimeExceptionDao<MyTeacher, Integer> getDao() {
		if (getManager() != null && getHelper() != null) {
			return getHelper().getMyTeacherDAO();
		}
		return null;
	}

	@Override
	public ArrayList<MyTeacher> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyTeacher getById(Integer id) {
		MyTeacher obj = getDao().queryForId(id);
		obj.setDao(this);
		obj.setLoaded(true);
		return obj;
	}

	@Override
	public Integer insert(MyTeacher obj) {
		return 1;
	}
}
