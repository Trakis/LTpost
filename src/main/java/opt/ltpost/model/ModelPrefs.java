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
    public void setPostLabelLocation(String key) {
        OSRegister.setKey(OSRegister.keyNames.POST_LABEL_LOCATION, key);
    }

    /**
     * Get post label location (URL to file)
     *
     * @return URL
     */
    public String getPostLabelLocation() {
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

//        STAMP_WIDTH,
    public void setStampPointX(Long pointX) {
        OSRegister.setKey(OSRegister.keyNames.STAMP_POINT_X, pointX);
    }

    public Long getStampPointX() {
        Long pointX = null;

        try {
            pointX = Long.valueOf(OSRegister.getKey(OSRegister.keyNames.STAMP_POINT_X));
        } catch (NumberFormatException e) {

        }

        return pointX;
    }

    public void setStampPointY(Long pointY) {
        OSRegister.setKey(OSRegister.keyNames.STAMP_POINT_Y, pointY);
    }

    public Long getStampPointY() {
        Long pointY = null;

        try {
            pointY = Long.valueOf(OSRegister.getKey(OSRegister.keyNames.STAMP_POINT_Y));
        } catch (NumberFormatException e) {

        }

        return pointY;
    }

    public void setStampWidth(Long stampWidth) {
        OSRegister.setKey(OSRegister.keyNames.STAMP_WIDTH, stampWidth);

    }

    public Long getStampWidth() {
        Long stampWidth = null;
        try {
            stampWidth = Long.valueOf(OSRegister.getKey(OSRegister.keyNames.STAMP_WIDTH));
        } catch (NumberFormatException e) {

        }

        return stampWidth;
    }

    public void setStampDateFontSize(Long stampDateFontSize) {
        OSRegister.setKey(OSRegister.keyNames.STAMP_DATE_FONT_SIZE, stampDateFontSize);

    }

//        STAMP_DATE_FONT_SIZE,
//        STAMP_SIGNATURE_IMAGE_HEIGHT;
    public Long getStampDateFontSize() {
        Long stampDateFontSize = null;
        try {
            stampDateFontSize = Long.valueOf(OSRegister.getKey(OSRegister.keyNames.STAMP_DATE_FONT_SIZE));
        } catch (NumberFormatException e) {

        }

        return stampDateFontSize;
    }

    public void setStampSignatureImageHeight(Long stampSignatureImageHeight) {
        OSRegister.setKey(OSRegister.keyNames.STAMP_SIGNATURE_IMAGE_HEIGHT, stampSignatureImageHeight);

    }

    public Long getStampSignatureImageHeight() {
        Long stampSignatureImageHeight = null;
        try {
            stampSignatureImageHeight = Long.valueOf(OSRegister.getKey(OSRegister.keyNames.STAMP_SIGNATURE_IMAGE_HEIGHT));
        } catch (NumberFormatException e) {

        }

        return stampSignatureImageHeight;
    }

}
