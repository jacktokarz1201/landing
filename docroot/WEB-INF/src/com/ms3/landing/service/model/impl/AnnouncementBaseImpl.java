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

package com.ms3.landing.service.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.ms3.landing.service.model.Announcement;
import com.ms3.landing.service.service.AnnouncementLocalServiceUtil;

/**
 * The extended model base implementation for the Announcement service. Represents a row in the &quot;landing_Announcement&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AnnouncementImpl}.
 * </p>
 *
 * @author John
 * @see AnnouncementImpl
 * @see com.ms3.landing.service.model.Announcement
 * @generated
 */
public abstract class AnnouncementBaseImpl extends AnnouncementModelImpl
	implements Announcement {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a announcement model instance should use the {@link Announcement} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AnnouncementLocalServiceUtil.addAnnouncement(this);
		}
		else {
			AnnouncementLocalServiceUtil.updateAnnouncement(this);
		}
	}
}