package com.arda.excelbaskent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class WebController {

    @Autowired
    private ExcelServisi excelServisi;

    @GetMapping("/")
    public String anaSayfa() {
        return "index"; 
    }

    @PostMapping("/yukle")
    public ResponseEntity<byte[]> dosyaYukle(@RequestParam("dosya") MultipartFile dosya) {
        
        
        byte[] islenmisExcel = excelServisi.excelIsle(dosya);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Sirali_Netler_Raporu.xlsx")
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(islenmisExcel);
    }
}