package com.android.qdengvid.daos;

import java.util.ArrayList;

import android.content.Context;

import com.android.qdengvid.entities.MyLevel;
import com.j256.ormlite.dao.RuntimeExceptionDao;

public class MyLevelDAO extends _MyDAOAbstract<MyLevelDAO, MyLevel>
		implements _MyDAOInterface<MyLevelDAO, MyLevel> {

	public MyLevelDAO(Context ctx, GlobalDAO g) {
		super(ctx, g);
	}

	@Override
	public RuntimeExceptionDao<MyLevel, Integer> getDao() {
		if (getManager() != null && getHelper() != null) {
			return getHelper().getMyLevelDAO();
		}
		return null;
	}

	@Override
	public ArrayList<MyLevel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyLevel getById(Integer id) {
		MyLevel obj = getDao().queryForId(id);
		obj.setDao(this);
		obj.setLoaded(true);
		return obj;
	}

	@Override
	public Integer insert(MyLevel obj) {
		return 1;
	}
}
