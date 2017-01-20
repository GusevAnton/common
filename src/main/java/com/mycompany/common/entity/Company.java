package com.mycompany.common.entity;

import lombok.Data;

/**
 * Created by antongusev on 16.10.16.
 */
@Data
public class Company {

    private Long companyId;

    private String name;

    private Country country;

    private String logoImage;

}
