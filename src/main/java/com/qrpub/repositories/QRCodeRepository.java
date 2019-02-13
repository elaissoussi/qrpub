package com.qrpub.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import com.qrpub.entities.QRCode;

@RepositoryRestResource
@Repository("qrCodeRepository")
public interface QRCodeRepository extends PagingAndSortingRepository<QRCode, Long> {

}
