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

import com.liferay.portal.service.persistence.BasePersistence;

import com.ms3.landing.service.model.Announcement;

/**
 * The persistence interface for the announcement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author John
 * @see AnnouncementPersistenceImpl
 * @see AnnouncementUtil
 * @generated
 */
public interface AnnouncementPersistence extends BasePersistence<Announcement> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnnouncementUtil} to access the announcement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the announcement in the entity cache if it is enabled.
	*
	* @param announcement the announcement
	*/
	public void cacheResult(
		com.ms3.landing.service.model.Announcement announcement);

	/**
	* Caches the announcements in the entity cache if it is enabled.
	*
	* @param announcements the announcements
	*/
	public void cacheResult(
		java.util.List<com.ms3.landing.service.model.Announcement> announcements);

	/**
	* Creates a new announcement with the primary key. Does not add the announcement to the database.
	*
	* @param ID the primary key for the new announcement
	* @return the new announcement
	*/
	public com.ms3.landing.service.model.Announcement create(long ID);

	/**
	* Removes the announcement with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the announcement
	* @return the announcement that was removed
	* @throws com.ms3.landing.service.NoSuchAnnouncementException if a announcement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ms3.landing.service.model.Announcement remove(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.landing.service.NoSuchAnnouncementException;

	public com.ms3.landing.service.model.Announcement updateImpl(
		com.ms3.landing.service.model.Announcement announcement)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the announcement with the primary key or throws a {@link com.ms3.landing.service.NoSuchAnnouncementException} if it could not be found.
	*
	* @param ID the primary key of the announcement
	* @return the announcement
	* @throws com.ms3.landing.service.NoSuchAnnouncementException if a announcement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ms3.landing.service.model.Announcement findByPrimaryKey(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ms3.landing.service.NoSuchAnnouncementException;

	/**
	* Returns the announcement with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the announcement
	* @return the announcement, or <code>null</code> if a announcement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ms3.landing.service.model.Announcement fetchByPrimaryKey(long ID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the announcements.
	*
	* @return the announcements
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ms3.landing.service.model.Announcement> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ms3.landing.service.model.Announcement> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ms3.landing.service.model.Announcement> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the announcements from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of announcements.
	*
	* @return the number of announcements
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}