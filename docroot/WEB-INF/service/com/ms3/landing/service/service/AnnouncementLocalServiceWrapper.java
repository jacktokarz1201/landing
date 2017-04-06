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

package com.ms3.landing.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AnnouncementLocalService}.
 *
 * @author John
 * @see AnnouncementLocalService
 * @generated
 */
public class AnnouncementLocalServiceWrapper implements AnnouncementLocalService,
	ServiceWrapper<AnnouncementLocalService> {
	public AnnouncementLocalServiceWrapper(
		AnnouncementLocalService announcementLocalService) {
		_announcementLocalService = announcementLocalService;
	}

	/**
	* Adds the announcement to the database. Also notifies the appropriate model listeners.
	*
	* @param announcement the announcement
	* @return the announcement that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ms3.landing.service.model.Announcement addAnnouncement(
		com.ms3.landing.service.model.Announcement announcement)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.addAnnouncement(announcement);
	}

	/**
	* Creates a new announcement with the primary key. Does not add the announcement to the database.
	*
	* @param ID the primary key for the new announcement
	* @return the new announcement
	*/
	@Override
	public com.ms3.landing.service.model.Announcement createAnnouncement(
		long ID) {
		return _announcementLocalService.createAnnouncement(ID);
	}

	/**
	* Deletes the announcement with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the announcement
	* @return the announcement that was removed
	* @throws PortalException if a announcement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ms3.landing.service.model.Announcement deleteAnnouncement(
		long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.deleteAnnouncement(ID);
	}

	/**
	* Deletes the announcement from the database. Also notifies the appropriate model listeners.
	*
	* @param announcement the announcement
	* @return the announcement that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ms3.landing.service.model.Announcement deleteAnnouncement(
		com.ms3.landing.service.model.Announcement announcement)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.deleteAnnouncement(announcement);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _announcementLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.landing.service.model.impl.AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ms3.landing.service.model.impl.AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ms3.landing.service.model.Announcement fetchAnnouncement(long ID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.fetchAnnouncement(ID);
	}

	/**
	* Returns the announcement with the primary key.
	*
	* @param ID the primary key of the announcement
	* @return the announcement
	* @throws PortalException if a announcement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ms3.landing.service.model.Announcement getAnnouncement(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.getAnnouncement(ID);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.ms3.landing.service.model.Announcement> getAnnouncements(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.getAnnouncements(start, end);
	}

	/**
	* Returns the number of announcements.
	*
	* @return the number of announcements
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAnnouncementsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.getAnnouncementsCount();
	}

	/**
	* Updates the announcement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param announcement the announcement
	* @return the announcement that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ms3.landing.service.model.Announcement updateAnnouncement(
		com.ms3.landing.service.model.Announcement announcement)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.updateAnnouncement(announcement);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _announcementLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_announcementLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _announcementLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AnnouncementLocalService getWrappedAnnouncementLocalService() {
		return _announcementLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAnnouncementLocalService(
		AnnouncementLocalService announcementLocalService) {
		_announcementLocalService = announcementLocalService;
	}

	@Override
	public AnnouncementLocalService getWrappedService() {
		return _announcementLocalService;
	}

	@Override
	public void setWrappedService(
		AnnouncementLocalService announcementLocalService) {
		_announcementLocalService = announcementLocalService;
	}

	private AnnouncementLocalService _announcementLocalService;
}