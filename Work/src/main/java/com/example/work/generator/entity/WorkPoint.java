package com.example.work.generator.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 工点
* @TableName work_point
*/
public class WorkPoint implements Serializable {

    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Integer id;
    /**
    * 
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("")
    @Length(max= 255,message="编码长度不能超过255")
    private String name;
    /**
    * 
    */
    @ApiModelProperty("")
    private Integer areaId;

    /**
    * 
    */
    private void setId(Integer id){
    this.id = id;
    }

    /**
    * 
    */
    private void setName(String name){
    this.name = name;
    }

    /**
    * 
    */
    private void setAreaId(Integer areaId){
    this.areaId = areaId;
    }


    /**
    * 
    */
    private Integer getId(){
    return this.id;
    }

    /**
    * 
    */
    private String getName(){
    return this.name;
    }

    /**
    * 
    */
    private Integer getAreaId(){
    return this.areaId;
    }

}
