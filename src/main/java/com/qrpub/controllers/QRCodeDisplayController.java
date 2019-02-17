package com.qrpub.controllers;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qrpub.entities.QRCode;
import com.qrpub.repositories.QRCodeRepository;

@Controller
@RequestMapping("/qrcodes/display")
public class QRCodeDisplayController {
  
  @Autowired
  QRCodeRepository qrCodeRepository;
  
  @GetMapping
  public void displayQRCodes(HttpServletResponse response,HttpServletRequest request) throws IOException {
    
    QRCode findOne = qrCodeRepository.findOne(1L);
    response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
    response.getOutputStream().write(findOne.getImage());
    response.getOutputStream().close();
    
  }
  
}
