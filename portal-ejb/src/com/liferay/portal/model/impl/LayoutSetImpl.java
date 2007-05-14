/**
 * Copyright (c) 2000-2007 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portal.model.impl;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.model.ColorScheme;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.Theme;
import com.liferay.portal.service.impl.ThemeLocalUtil;

/**
 * <a href="LayoutSetImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LayoutSetImpl extends LayoutSetModelImpl implements LayoutSet {

	public LayoutSetImpl() {
	}

	public String getOwnerId() {
		if (isPrivateLayout()) {
			return "PRI." + getGroupId();
		}
		else {
			return "PUB." + getGroupId();
		}
	}

	public String getLogoImageId() {
		return getCompanyId() + ".layout_set." + getOwnerId();
	}

	public String getPngLogoImageId() {
		return getCompanyId() + ".layout_set." + getOwnerId() + ".png";
	}

	public String getWbmpLogoImageId() {
		return getCompanyId() + ".layout_set." + getOwnerId() + ".wbmp";
	}

	public Theme getTheme() throws PortalException, SystemException {
		return ThemeLocalUtil.getTheme(getCompanyId(), getThemeId(), false);
	}

	public ColorScheme getColorScheme()
		throws PortalException, SystemException {

		return ThemeLocalUtil.getColorScheme(
			getCompanyId(), getTheme().getThemeId(), getColorSchemeId(), false);
	}

	public Theme getWapTheme() throws PortalException, SystemException {
		return ThemeLocalUtil.getTheme(getCompanyId(), getWapThemeId(), true);
	}

	public ColorScheme getWapColorScheme()
		throws PortalException, SystemException {

		return ThemeLocalUtil.getColorScheme(
			getCompanyId(), getWapTheme().getThemeId(), getWapColorSchemeId(),
			true);
	}

}