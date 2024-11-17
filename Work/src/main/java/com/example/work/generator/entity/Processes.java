package com.example.work.generator.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 工序
* @TableName processes
*/
public class Processes implements Serializable {

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
    * 工点id
    */
    @ApiModelProperty("工点id")
    private Integer pointId;
    /**
    * 构件id
    */
    @ApiModelProperty("构件id")
    private Integer compId;

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
    * 工点id
    */
    private void setPointId(Integer pointId){
    this.pointId = pointId;
    }

    /**
    * 构件id
    */
    private void setCompId(Integer compId){
    this.compId = compId;
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
    * 工点id
    */
    private Integer getPointId(){
    return this.pointId;
    }

    /**
    * 构件id
    */
    private Integer getCompId(){
    return this.compId;
    }

}
