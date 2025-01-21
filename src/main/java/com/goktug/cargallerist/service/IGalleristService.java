package com.goktug.cargallerist.service;

import com.goktug.cargallerist.dto.DtoGallerist;
import com.goktug.cargallerist.dto.DtoGalleristIU;

public interface IGalleristService {

    public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU);
}
