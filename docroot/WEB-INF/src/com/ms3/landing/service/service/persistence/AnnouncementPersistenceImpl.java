/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ms3.landing.service.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.ms3.landing.service.NoSuchAnnouncementException;
import com.ms3.landing.service.model.Announcement;
import com.ms3.landing.service.model.impl.AnnouncementImpl;
import com.ms3.landing.service.model.impl.AnnouncementModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the announcement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author John
 * @see AnnouncementPersistence
 * @see AnnouncementUtil
 * @generated
 */
public class AnnouncementPersistenceImpl extends BasePersistenceImpl<Announcement>
	implements AnnouncementPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AnnouncementUtil} to access the announcement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AnnouncementImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AnnouncementModelImpl.ENTITY_CACHE_ENABLED,
			AnnouncementModelImpl.FINDER_CACHE_ENABLED, AnnouncementImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AnnouncementModelImpl.ENTITY_CACHE_ENABLED,
			AnnouncementModelImpl.FINDER_CACHE_ENABLED, AnnouncementImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AnnouncementModelImpl.ENTITY_CACHE_ENABLED,
			AnnouncementModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public AnnouncementPersistenceImpl() {
		setModelClass(Announcement.class);
	}

	/**
	 * Caches the announcement in the entity cache if it is enabled.
	 *
	 * @param announcement the announcement
	 */
	@Override
	public void cacheResult(Announcement announcement) {
		EntityCacheUtil.putResult(AnnouncementModelImpl.ENTITY_CACHE_ENABLED,
			AnnouncementImpl.class, announcement.getPrimaryKey(), announcement);

		announcement.resetOriginalValues();
	}

	/**
	 * Caches the announcements in the entity cache if it is enabled.
	 *
	 * @param announcements the announcements
	 */
	@Override
	public void cacheResult(List<Announcement> announcements) {
		for (Announcement announcement : announcements) {
			if (EntityCacheUtil.getResult(
						AnnouncementModelImpl.ENTITY_CACHE_ENABLED,
						AnnouncementImpl.class, announcement.getPrimaryKey()) == null) {
				cacheResult(announcement);
			}
			else {
				announcement.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all announcements.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AnnouncementImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AnnouncementImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the announcement.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Announcement announcement) {
		EntityCacheUtil.removeResult(AnnouncementModelImpl.ENTITY_CACHE_ENABLED,
			AnnouncementImpl.class, announcement.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Announcement> announcements) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Announcement announcement : announcements) {
			EntityCacheUtil.removeResult(AnnouncementModelImpl.ENTITY_CACHE_ENABLED,
				AnnouncementImpl.class, announcement.getPrimaryKey());
		}
	}

	/**
	 * Creates a new announcement with the primary key. Does not add the announcement to the database.
	 *
	 * @param ID the primary key for the new announcement
	 * @return the new announcement
	 */
	@Override
	public Announcement create(long ID) {
		Announcement announcement = new AnnouncementImpl();

		announcement.setNew(true);
		announcement.setPrimaryKey(ID);

		return announcement;
	}

	/**
	 * Removes the announcement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the announcement
	 * @return the announcement that was removed
	 * @throws com.ms3.landing.service.NoSuchAnnouncementException if a announcement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Announcement remove(long ID)
		throws NoSuchAnnouncementException, SystemException {
		return remove((Serializable)ID);
	}

	/**
	 * Removes the announcement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the announcement
	 * @return the announcement that was removed
	 * @throws com.ms3.landing.service.NoSuchAnnouncementException if a announcement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Announcement remove(Serializable primaryKey)
		throws NoSuchAnnouncementException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Announcement announcement = (Announcement)session.get(AnnouncementImpl.class,
					primaryKey);

			if (announcement == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnnouncementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(announcement);
		}
		catch (NoSuchAnnouncementException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Announcement removeImpl(Announcement announcement)
		throws SystemException {
		announcement = toUnwrappedModel(announcement);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(announcement)) {
				announcement = (Announcement)session.get(AnnouncementImpl.class,
						announcement.getPrimaryKeyObj());
			}

			if (announcement != null) {
				session.delete(announcement);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (announcement != null) {
			clearCache(announcement);
		}

		return announcement;
	}

	@Override
	public Announcement updateImpl(
		com.ms3.landing.service.model.Announcement announcement)
		throws SystemException {
		announcement = toUnwrappedModel(announcement);

		boolean isNew = announcement.isNew();

		Session session = null;

		try {
			session = openSession();

			if (announcement.isNew()) {
				session.save(announcement);

				announcement.setNew(false);
			}
			else {
				session.merge(announcement);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(AnnouncementModelImpl.ENTITY_CACHE_ENABLED,
			AnnouncementImpl.class, announcement.getPrimaryKey(), announcement);

		return announcement;
	}

	protected Announcement toUnwrappedModel(Announcement announcement) {
		if (announcement instanceof AnnouncementImpl) {
			return announcement;
		}

		AnnouncementImpl announcementImpl = new AnnouncementImpl();

		announcementImpl.setNew(announcement.isNew());
		announcementImpl.setPrimaryKey(announcement.getPrimaryKey());

		announcementImpl.setID(announcement.getID());
		announcementImpl.setTitle(announcement.getTitle());
		announcementImpl.setContent(announcement.getContent());
		announcementImpl.setSetDate(announcement.getSetDate());
		announcementImpl.setAuthor(announcement.getAuthor());

		return announcementImpl;
	}

	/**
	 * Returns the announcement with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the announcement
	 * @return the announcement
	 * @throws com.ms3.landing.service.NoSuchAnnouncementException if a announcement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Announcement findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAnnouncementException, SystemException {
		Announcement announcement = fetchByPrimaryKey(primaryKey);

		if (announcement == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAnnouncementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return announcement;
	}

	/**
	 * Returns the announcement with the primary key or throws a {@link com.ms3.landing.service.NoSuchAnnouncementException} if it could not be found.
	 *
	 * @param ID the primary key of the announcement
	 * @return the announcement
	 * @throws com.ms3.landing.service.NoSuchAnnouncementException if a announcement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Announcement findByPrimaryKey(long ID)
		throws NoSuchAnnouncementException, SystemException {
		return findByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns the announcement with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the announcement
	 * @return the announcement, or <code>null</code> if a announcement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Announcement fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Announcement announcement = (Announcement)EntityCacheUtil.getResult(AnnouncementModelImpl.ENTITY_CACHE_ENABLED,
				AnnouncementImpl.class, primaryKey);

		if (announcement == _nullAnnouncement) {
			return null;
		}

		if (announcement == null) {
			Session session = null;

			try {
				session = openSession();

				announcement = (Announcement)session.get(AnnouncementImpl.class,
						primaryKey);

				if (announcement != null) {
					cacheResult(announcement);
				}
				else {
					EntityCacheUtil.putResult(AnnouncementModelImpl.ENTITY_CACHE_ENABLED,
						AnnouncementImpl.class, primaryKey, _nullAnnouncement);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AnnouncementModelImpl.ENTITY_CACHE_ENABLED,
					AnnouncementImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return announcement;
	}

	/**
	 * Returns the announcement with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the announcement
	 * @return the announcement, or <code>null</code> if a announcement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Announcement fetchByPrimaryKey(long ID) throws SystemException {
		return fetchByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns all the announcements.
	 *
	 * @return the announcements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Announcement> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the announcements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.landing.service.model.impl.AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of announcements
	 * @param end the upper bound of the range of announcements (not inclusive)
	 * @return the range of announcements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Announcement> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the announcements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.landing.service.model.impl.AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of announcements
	 * @param end the upper bound of the range of announcements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of announcements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Announcement> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Announcement> list = (List<Announcement>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ANNOUNCEMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ANNOUNCEMENT;

				if (pagination) {
					sql = sql.concat(AnnouncementModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Announcement>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Announcement>(list);
				}
				else {
					list = (List<Announcement>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the announcements from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Announcement announcement : findAll()) {
			remove(announcement);
		}
	}

	/**
	 * Returns the number of announcements.
	 *
	 * @return the number of announcements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ANNOUNCEMENT);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the announcement persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ms3.landing.service.model.Announcement")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Announcement>> listenersList = new ArrayList<ModelListener<Announcement>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Announcement>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(AnnouncementImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ANNOUNCEMENT = "SELECT announcement FROM Announcement announcement";
	private static final String _SQL_COUNT_ANNOUNCEMENT = "SELECT COUNT(announcement) FROM Announcement announcement";
	private static final String _ORDER_BY_ENTITY_ALIAS = "announcement.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Announcement exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AnnouncementPersistenceImpl.class);
	private static Announcement _nullAnnouncement = new AnnouncementImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Announcement> toCacheModel() {
				return _nullAnnouncementCacheModel;
			}
		};

	private static CacheModel<Announcement> _nullAnnouncementCacheModel = new CacheModel<Announcement>() {
			@Override
			public Announcement toEntityModel() {
				return _nullAnnouncement;
			}
		};
}