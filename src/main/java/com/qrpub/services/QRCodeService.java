package com.qrpub.services;

import com.qrpub.entities.QRCode;

public interface QRCodeService {
  
  QRCode save(QRCode qrcode);
  
  byte[] createQRCodeImageFromUrl(String url);
  
}
