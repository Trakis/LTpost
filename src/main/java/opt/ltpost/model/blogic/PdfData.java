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
package opt.ltpost.model.blogic;

import java.time.LocalDate;
import java.util.Date;

/**
 * data object
 *
 * @author Trakis
 */
public class PdfData {

    String postLabelLocation;
    String signedPostLabelFolderLocation;
    String signatureImageLocation;

    Long stampPointX;
    Long stampPointY;
    Long stampWidth;
    Long stampSignatureHeight;
    Long stampDateFontSize;
    LocalDate signedDate;

    public String getPostLabelLocation() {
        return postLabelLocation;
    }

    public void setPostLabelLocation(String postLabelLocation) {
        this.postLabelLocation = postLabelLocation;
    }

    public String getSignedPostLabelFolderLocation() {
        return signedPostLabelFolderLocation;
    }

    public void setSignedPostLabelFolderLocation(String signedPostLabelFolderLocation) {
        this.signedPostLabelFolderLocation = signedPostLabelFolderLocation;
    }

    public String getSignatureImageLocation() {
        return signatureImageLocation;
    }

    public void setSignatureImageLocation(String signatureImageLocation) {
        this.signatureImageLocation = signatureImageLocation;
    }

    public Long getStampPointX() {
        return stampPointX;
    }

    public void setStampPointX(Long stampPointX) {
        this.stampPointX = stampPointX;
    }

    public Long getStampPointY() {
        return stampPointY;
    }

    public void setStampPointY(Long stampPointY) {
        this.stampPointY = stampPointY;
    }

    public Long getStampWidth() {
        return stampWidth;
    }

    public void setStampWidth(Long stampWidth) {
        this.stampWidth = stampWidth;
    }

    public Long getStampSignatureHeight() {
        return stampSignatureHeight;
    }

    public void setStampSignatureHeight(Long stampSignatureHeight) {
        this.stampSignatureHeight = stampSignatureHeight;
    }

    public Long getStampDateFontSize() {
        return stampDateFontSize;
    }

    public void setStampDateFontSize(Long stampDateFontSize) {
        this.stampDateFontSize = stampDateFontSize;
    }

    public LocalDate getSignedDate() {
        return signedDate;
    }

    public void setSignedDate(LocalDate signedDate) {
        this.signedDate = signedDate;
    }

}
