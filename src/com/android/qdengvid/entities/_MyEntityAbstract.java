package com.android.qdengvid.entities;

import com.android.qdengvid.daos.GlobalDAO;
import com.android.qdengvid.daos._GlobalDAOInterface;
import com.android.qdengvid.daos._MyDAOAbstract;
import com.android.qdengvid.daos._MyDAOInterface;
import com.j256.ormlite.field.DatabaseField;

public abstract class _MyEntityAbstract<T, K> implements
		_MyEntityInterface<T, K>, _GlobalDAOInterface {
	public static final String ID_F = "id";
	/**
	 * work directly with its own custom My...DAO, nothing else
	 */
	private T dao = null;
	/**
	 * Table always has _id field for PK
	 */
	@DatabaseField(generatedId = true)
	private Integer id = null;
	/**
	 * Chi dinh obj da duoc cap nhat du lieu
	 */
	private Boolean loaded = false;
	/**
	 * Must be declare to make sure ORMLite can reference to
	 */

	protected static final String UNKNOWN_VALUE = "unknown";

	public _MyEntityAbstract() {
	}

	@Override
	public Boolean delete() {
		return ((_MyDAOAbstract<T, K>) getDao()).delete((K) this);
	}

	@Override
	public T getDao() {
		return dao;
	}

	@Override
	public GlobalDAO getGlobalDAO() {
		if (getDao() != null) {
			return ((_GlobalDAOInterface) getDao()).getGlobalDAO();
		}
		return null;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

	/**
	 * support DISK SOURCE and DB SOURCE
	 */
	@Override
	public Integer insert() {
		// clear id first => force insert
		setId(null);
		return ((_MyDAOAbstract<T, K>) getDao()).insert((K) this);
	}

	/**
	 * Neu da load roi thi khi goi ham nay se khong co tac dung toi chung nao
	 * reset Khong ho tro pass DAO cho cac FK
	 */
	@Override
	public void load() {
		if (loaded == false) {
			((_MyDAOInterface<T, K>) getDao()).load((K) this);
			loaded = true;
		}
	}

	/**
	 * set loaded = false, and members in devired class Becareful when use with
	 * DISK_SOURCE Because some Entity doesn't support load from DISK SOURCE
	 * Such as MyAlbum, MyFormat
	 */
	@Override
	public void reset() {
		loaded = false;
		// do not reset Id
	}

	@Override
	public void setDao(T dao_) {
		dao = dao_;
	}

	@Override
	public void setId(Integer id_) {
		// TODO Auto-generated method stub
		id = id_;
	}

	/**
	 * Becarefully when use, may be unsync
	 */
	@Override
	public void setLoaded(Boolean loaded) {
		this.loaded = loaded;
	}

	@Override
	public Boolean update() {
		return ((_MyDAOAbstract<T, K>) getDao()).update((K) this);
	}

	@Override
	public Boolean isLoaded() {
		return loaded;
	}
}
