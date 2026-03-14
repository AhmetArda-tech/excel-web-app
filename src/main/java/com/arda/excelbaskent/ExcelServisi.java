package com.arda.excelbaskent;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

@Service 
public class ExcelServisi {

    
    public byte[] excelIsle(MultipartFile yuklenenDosya) {
        
        List<Ogrenci> ogrencilistesi = new ArrayList<>();
      
        try (Workbook workbook = WorkbookFactory.create(yuklenenDosya.getInputStream())) {
            
            Sheet sheet = workbook.getSheetAt(0);

                    for(int i = 6; i<= sheet.getLastRowNum(); i++ ){

                    Row row = sheet.getRow(i);
                    if (row == null) continue; 

                    String isim = row.getCell(4).getStringCellValue().trim();
                    String isimKucuk = isim.toLowerCase();
                // Eğer isim bu kelimeleri içeriyorsa veya 3 harften kısaysa (örn: 5A, 5-A) listeye ekleme
                if ( 
                    isimKucuk.contains("tüm") ||  
                    isim.length() <= 3) {
                    
                    continue; 
                }
        
                    double toplamNet = row.getCell(63).getNumericCellValue();
                    double matNet = row.getCell(9).getNumericCellValue();
                    double fenNet = row.getCell(18).getNumericCellValue();
                    double turkceNet = row.getCell(27).getNumericCellValue();
                    double sosyalNet = row.getCell(36).getNumericCellValue();
                    double dnNet = row.getCell(45).getNumericCellValue();
                    double ingilizceNet = row.getCell(54).getNumericCellValue();
                    ogrencilistesi.add(new Ogrenci(isim,toplamNet,matNet,fenNet,turkceNet,sosyalNet,dnNet,ingilizceNet));

                    //cell numaraları netlerin olduğu indeksler!;
               }
               ogrencilistesi.sort((o1,o2)->Double.compare(o2.getNet(), o1.getNet()));       

               Workbook yeniSira = new XSSFWorkbook();
               Sheet yeniSayfa = yeniSira.createSheet("Sıralı Netler");
               Row Baslik = yeniSayfa.createRow(0);
               Baslik.createCell(0).setCellValue("Öğrenci İsmi");
               Baslik.createCell(1).setCellValue("Toplam Net");
               Baslik.createCell(2).setCellValue("Matematik Neti");
               Baslik.createCell(3).setCellValue("Fen Bilimleri Neti");
               Baslik.createCell(4).setCellValue("Türkçe Neti");
               Baslik.createCell(5).setCellValue("Sosyal Bilimleri Neti");
               Baslik.createCell(6).setCellValue("DKAB Neti");
               Baslik.createCell(7).setCellValue("İngilizce Neti");
               int ogrenciSayisi = ogrencilistesi.size();

               for(int j = 0; j<ogrenciSayisi; j++){
                    Row sıralılar = yeniSayfa.createRow(j+1);
                    sıralılar.createCell(0).setCellValue(ogrencilistesi.get(j).getIsim());
                    sıralılar.createCell(1).setCellValue(ogrencilistesi.get(j).getNet());
                    sıralılar.createCell(2).setCellValue(ogrencilistesi.get(j).getmatNet());
                    sıralılar.createCell(3).setCellValue(ogrencilistesi.get(j).getfenNet());
                    sıralılar.createCell(4).setCellValue(ogrencilistesi.get(j).getturkNet());
                    sıralılar.createCell(5).setCellValue(ogrencilistesi.get(j).getsosyalNet());
                    sıralılar.createCell(6).setCellValue(ogrencilistesi.get(j).getdnNet());
                    sıralılar.createCell(7).setCellValue(ogrencilistesi.get(j).getingilizceNet());           
                }     



            
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            yeniSira.write(out); 
            yeniSira.close();
            
            return out.toByteArray(); // Dosyayı kullanıcıya indirtmek üzere byte olarak döndürüldü.

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Excel işlenirken hata oluştu: " + e.getMessage());
        }
    }
}
