package com.example.work.plan.entity;

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
    * 计划ID
    */
    @ApiModelProperty("计划ID")
    private Integer planId;
    /**
    * 上级编码
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("上级编码")
    @Length(max= 255,message="编码长度不能超过255")
    private String parentCode;
    /**
    * 构件编码
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("构件编码")
    @Length(max= 255,message="编码长度不能超过255")
    private String code;
    /**
    * 层级
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("层级")
    @Length(max= 255,message="编码长度不能超过255")
    private String level;
    /**
    * 项目ID
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("项目ID")
    @Length(max= 255,message="编码长度不能超过255")
    private String projectId;
    /**
    * 工区ID
    */
    @ApiModelProperty("工区ID")
    private Integer areaId;
    /**
    * 工点ID
    */
    @ApiModelProperty("工点ID")
    private Integer pointId;

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
    * 计划ID
    */
    private void setPlanId(Integer planId){
    this.planId = planId;
    }

    /**
    * 上级编码
    */
    private void setParentCode(String parentCode){
    this.parentCode = parentCode;
    }

    /**
    * 构件编码
    */
    private void setCode(String code){
    this.code = code;
    }

    /**
    * 层级
    */
    private void setLevel(String level){
    this.level = level;
    }

    /**
    * 项目ID
    */
    private void setProjectId(String projectId){
    this.projectId = projectId;
    }

    /**
    * 工区ID
    */
    private void setAreaId(Integer areaId){
    this.areaId = areaId;
    }

    /**
    * 工点ID
    */
    private void setPointId(Integer pointId){
    this.pointId = pointId;
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

    /**
    * 计划ID
    */
    private Integer getPlanId(){
    return this.planId;
    }

    /**
    * 上级编码
    */
    private String getParentCode(){
    return this.parentCode;
    }

    /**
    * 构件编码
    */
    private String getCode(){
    return this.code;
    }

    /**
    * 层级
    */
    private String getLevel(){
    return this.level;
    }

    /**
    * 项目ID
    */
    private String getProjectId(){
    return this.projectId;
    }

    /**
    * 工区ID
    */
    private Integer getAreaId(){
    return this.areaId;
    }

    /**
    * 工点ID
    */
    private Integer getPointId(){
    return this.pointId;
    }

}
