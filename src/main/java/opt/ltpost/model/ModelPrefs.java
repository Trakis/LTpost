/*
 * Copyright (C) 2023 Trakis
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package opt.ltpost.model;

import opt.ltpost.model.register.OSRegister;

/**
 *
 * @author Trakis
 */
public class ModelPrefs {

    /**
     * Set Post label location (URL to file)
     *
     * @param key - URL
     */
    public void setPostLabelLocationKey(String key) {
        OSRegister.setKey(OSRegister.keyNames.POST_LABEL_LOCATION, key);
    }

    /**
     * Get post label location (URL to file)
     *
     * @return URL
     */
    public String getPostLabelLocationKey() {
        return OSRegister.getKey(OSRegister.keyNames.POST_LABEL_LOCATION);
    }

    public void setSignedPostLabelFolderLocation(String key) {
        OSRegister.setKey(OSRegister.keyNames.SIGNED_POST_LABEL_FOLDER, key);
    }

    public String getSignedPostLabelFolderLocation() {
        return OSRegister.getKey(OSRegister.keyNames.SIGNED_POST_LABEL_FOLDER);
    }

    public void setSignatureImageLocation(String key) {
        OSRegister.setKey(OSRegister.keyNames.SIGNATURE_IMAGE_LOCATION, key);
    }

    public String getSignatureImageLocation() {
        return OSRegister.getKey(OSRegister.keyNames.SIGNATURE_IMAGE_LOCATION);
    }

}
