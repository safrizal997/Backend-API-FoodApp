package com.safrizal.foodservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
public class CreateCategoryReq {

    @NotNull
    @NotEmpty(message = "please insert name")
    private String name;
    @NotNull
    @NotEmpty
    private String description;

}
