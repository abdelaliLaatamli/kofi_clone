package com.springprj.kofi.responses;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
public class ProfileResponse {

    private Long id;
    private String nickname ;
    private String description;
    private String avatar;
    private int follows;

}
