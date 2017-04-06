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

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.ms3.landing.service.model.Announcement;
import com.ms3.landing.service.service.AnnouncementLocalServiceUtil;

/**
 * @author John
 * @generated
 */
public abstract class AnnouncementActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public AnnouncementActionableDynamicQuery() throws SystemException {
		setBaseLocalService(AnnouncementLocalServiceUtil.getService());
		setClass(Announcement.class);

		setClassLoader(com.ms3.landing.service.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("ID");
	}
}