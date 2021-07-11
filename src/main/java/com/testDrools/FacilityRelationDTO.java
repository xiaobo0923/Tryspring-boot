package com.testDrools;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FacilityRelationDTO {

    private String provinceName;

    private String provinceId;

    private String cityName;

    private String cityId;

    private String countyName;

    private String countyId;

    private String streetName;

    private String streetId;

    private String storeId;

    private String facilityId;

    private String facilityName;

    private String address;

    private Integer isDefault;


}
