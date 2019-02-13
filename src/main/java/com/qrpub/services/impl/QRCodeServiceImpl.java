package com.qrpub.services.impl;

import java.io.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.qrpub.entities.QRCode;
import com.qrpub.repositories.QRCodeRepository;
import com.qrpub.services.QRCodeService;

@Service("qrCodeService")
public class QRCodeServiceImpl implements QRCodeService {

  @Autowired
  QRCodeRepository qrCodeRepository;
  
  @Override
  public byte[] createQRCodeImageFromUrl(String url) {
    try {
      QRCodeWriter qrCodeWriter = new QRCodeWriter();
      BitMatrix bitMatrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, 10, 10);
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream);
      return byteArrayOutputStream.toByteArray();
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public QRCode save(QRCode qrcode) {
    String url = qrcode.getUrl();
    byte[] qrImage = createQRCodeImageFromUrl(url);
    qrcode.setImage(qrImage);
    return qrCodeRepository.save(qrcode);
  }
  
}
