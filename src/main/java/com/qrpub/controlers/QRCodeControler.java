package com.qrpub.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.qrpub.entities.QRCode;
import com.qrpub.services.QRCodeService;

@RestController
@RequestMapping("qrcodes")
public class QRCodeControler {

  @Autowired
  private QRCodeService qrCodeService;

  @PostMapping
  public ResponseEntity<Void> qrcode(@RequestBody QRCode qrcode,  UriComponentsBuilder builder) {
    QRCode qrCode = qrCodeService.save(qrcode);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(builder.path("/qrcodes/{id}").buildAndExpand(qrCode.getId()).toUri());
    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }
}
