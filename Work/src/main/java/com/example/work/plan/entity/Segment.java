package com.example.work.plan.entity;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 区段
* @TableName segment
*/
public class Segment implements Serializable {

    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Integer id;
    /**
    * 工区
    */
    @ApiModelProperty("工区")
    private Integer areaId;
    /**
    * 工点
    */
    @ApiModelProperty("工点")
    private Integer pointId;
    /**
    * 区段名
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("区段名")
    @Length(max= 255,message="编码长度不能超过255")
    private String name;
    /**
    * 项目ID
    */
    @ApiModelProperty("项目ID")
    private Integer projectId;

    /**
    * 
    */
    private void setId(Integer id){
    this.id = id;
    }

    /**
    * 工区
    */
    private void setAreaId(Integer areaId){
    this.areaId = areaId;
    }

    /**
    * 工点
    */
    private void setPointId(Integer pointId){
    this.pointId = pointId;
    }

    /**
    * 区段名
    */
    private void setName(String name){
    this.name = name;
    }

    /**
    * 项目ID
    */
    private void setProjectId(Integer projectId){
    this.projectId = projectId;
    }


    /**
    * 
    */
    private Integer getId(){
    return this.id;
    }

    /**
    * 工区
    */
    private Integer getAreaId(){
    return this.areaId;
    }

    /**
    * 工点
    */
    private Integer getPointId(){
    return this.pointId;
    }

    /**
    * 区段名
    */
    private String getName(){
    return this.name;
    }

    /**
    * 项目ID
    */
    private Integer getProjectId(){
    return this.projectId;
    }

}
