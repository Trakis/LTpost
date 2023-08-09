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
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

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
        
        
   
        PdfWriter writer = new PdfWriter(data.getSignedPostLabelFolderLocation() +"\\"+ fileNameWithoutExt + "_SIGNED.pdf");
        PdfDocument pdfDocument = new PdfDocument(reader, writer);
        
      //      System.out.println("Info: " + pdfDocument.getDefaultPageSize().toString());

        //get number of pages in PDF file
        int numberOfPages = pdfDocument.getNumberOfPages();
        System.out.println("numberOfPages:" + numberOfPages);

        Document document = new Document(pdfDocument);
//        ImageData image = ImageDataFactory.create("C:\\Users\\gbruz\\Desktop\\EtsyDev\\apuokelio_logo.png");
//        Image imageModel = new Image(image);
//        imageModel.setHeight(20);

        ImageData imageSignature = ImageDataFactory.create(data.getSignatureImageLocation());
        Image imageModelSignature = new Image(imageSignature);
        imageModelSignature.setHeight(data.stampSignatureHeight);

        for (int i = 1; i <= numberOfPages; i++) {
            System.out.println("current page: " + i);
            PdfPage page = pdfDocument.getPage(i);
            String pdfPageText = PdfTextExtractor.getTextFromPage(page);
            if (pdfPageText.contains(expectedText)) {

                System.out.println("Found signature text");

                Text txtA = new Text(dateString)
                        .setFontSize(data.stampDateFontSize);

                Paragraph paragrafoA = new Paragraph()
                        .add(txtA)
                        .add(imageModelSignature)
                        //   .add(imageModel)
                        //   .setBackgroundColor(ColorConstants.BLACK)
                        .setRotationAngle(Math.toRadians(90));

                //     paragrafoA.setRotationAngle(Math.toRadians(90));
                //  document.showTextAligned(paragrafoA, 200, 100, TextAlignment.LEFT);
                float x = pdfDocument.getDefaultPageSize().getWidth() / 2;
                float y = pdfDocument.getDefaultPageSize().getHeight() / 2;

                paragrafoA.setFixedPosition(i, x + data.stampPointX, data.stampPointY, data.stampWidth);
                document.add(paragrafoA);

                System.out.println("x: " + x + " y: " + y);
            }

        }

        pdfDocument.close();
        reader.close();
        writer.close();
    }

}
