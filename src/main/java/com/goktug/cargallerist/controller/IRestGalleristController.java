package com.goktug.cargallerist.controller;

import com.goktug.cargallerist.dto.DtoGallerist;
import com.goktug.cargallerist.dto.DtoGalleristIU;
import jakarta.persistence.criteria.Root;

public interface IRestGalleristController {
    RootEntity<DtoGallerist> saveGallerist(DtoGalleristIU dtoGalleristIU);
}
