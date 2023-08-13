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

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.parser.PdfCanvasProcessor;
import com.itextpdf.kernel.pdf.canvas.parser.listener.FilteredEventListener;
import com.itextpdf.kernel.pdf.canvas.parser.listener.IPdfTextLocation;
import com.itextpdf.kernel.pdf.canvas.parser.listener.RegexBasedLocationExtractionStrategy;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

/**
 *
 * @author Trakis
 */
public class PdfSign {

    private final String expectedText = "Date and sender's signature";

    public void create(PdfData data) throws IOException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY/MM/dd");
        String dateString = formatter.format(data.getSignedDate());

        File filePdf = new File(data.getPostLabelLocation());

        String fileNameWithoutExt = filePdf.getName().substring(0, filePdf.getName().lastIndexOf("."));

        PdfReader reader = new PdfReader(filePdf.getPath());

        PdfWriter writer = new PdfWriter(data.getSignedPostLabelFolderLocation() + "\\" + fileNameWithoutExt + "_SIGNED.pdf");
        PdfDocument pdfDocument = new PdfDocument(reader, writer);

        //get number of pages in PDF file
        int numberOfPages = pdfDocument.getNumberOfPages();

        Document document = new Document(pdfDocument);

        ImageData imageSignature = ImageDataFactory.create(data.getSignatureImageLocation());
        Image imageModelSignature = new Image(imageSignature);
        imageModelSignature.setHeight(data.stampSignatureHeight);

        FilteredEventListener listener = new FilteredEventListener();

        for (int i = 1; i <= numberOfPages; i++) {

            PdfPage currentPage = pdfDocument.getPage(i);

            RegexBasedLocationExtractionStrategy extractionStrategy = new RegexBasedLocationExtractionStrategy(expectedText);
            new PdfCanvasProcessor(extractionStrategy).processPageContent(currentPage);

            Collection<IPdfTextLocation> eL = extractionStrategy.getResultantLocations();
            for (IPdfTextLocation location : eL) {

                Text txtA = new Text(dateString)
                        .setFontSize(data.stampDateFontSize);

                Paragraph paragrafoA = new Paragraph()
                        .add(txtA)
                        .add(imageModelSignature)
                        //   .add(imageModel)
                        // .setBackgroundColor(ColorConstants.BLACK)
                        .setRotationAngle(Math.toRadians(90));
                paragrafoA.setFixedPosition(i, location.getRectangle().getX() + data.stampPointX, location.getRectangle().getY() + data.stampPointY, data.stampWidth);

                document.add(paragrafoA);
            }

        }

        pdfDocument.close();
        reader.close();
        writer.close();

    }

}
