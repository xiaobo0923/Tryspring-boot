package com.testDrools;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author casstime
 */
@Data
@Accessors(chain = true)
public class PostalAddressDTO {

    private String provinceGeoId;

    private String cityGeoId;

    private String countyGeoId;

    private String villageGeoId;

    private String provinceGeoName;

    private String cityGeoName;

    private String countyGeoName;

    private String villageGeoName;

    private Double longitude;

    private Double latitude;

    private String receiverName;

    private String contactTel;

    private String contactNumber;

    private String address;

    private boolean complete;

}
