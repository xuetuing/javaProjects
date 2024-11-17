package com.example.work.generator.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 构件表
* @TableName component
*/
public class Component implements Serializable {

    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Integer id;
    /**
    * 构件名
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("构件名")
    @Length(max= 255,message="编码长度不能超过255")
    private String name;
    /**
    * 专业级字段
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("专业级字段")
    @Length(max= 255,message="编码长度不能超过255")
    private String profession;
    /**
    * 区段id
    */
    @ApiModelProperty("区段id")
    private Integer segmentId;
    /**
    * 工效
    */
    @ApiModelProperty("工效")
    private Integer workEfficiency;

    /**
    * 
    */
    private void setId(Integer id){
    this.id = id;
    }

    /**
    * 构件名
    */
    private void setName(String name){
    this.name = name;
    }

    /**
    * 专业级字段
    */
    private void setProfession(String profession){
    this.profession = profession;
    }

    /**
    * 区段id
    */
    private void setSegmentId(Integer segmentId){
    this.segmentId = segmentId;
    }

    /**
    * 工效
    */
    private void setWorkEfficiency(Integer workEfficiency){
    this.workEfficiency = workEfficiency;
    }


    /**
    * 
    */
    private Integer getId(){
    return this.id;
    }

    /**
    * 构件名
    */
    private String getName(){
    return this.name;
    }

    /**
    * 专业级字段
    */
    private String getProfession(){
    return this.profession;
    }

    /**
    * 区段id
    */
    private Integer getSegmentId(){
    return this.segmentId;
    }

    /**
    * 工效
    */
    private Integer getWorkEfficiency(){
    return this.workEfficiency;
    }

}
