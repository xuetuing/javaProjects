package com.example.work.plan.entity;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 施工工序表
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
    * 计划ID
    */
    @ApiModelProperty("计划ID")
    private Integer planId;
    /**
    * 工序名称
    */
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("工序名称")
    @Length(max= 64,message="编码长度不能超过64")
    private String name;
    /**
    * 构件id
    */
    @ApiModelProperty("构件id")
    private Integer compId;
    /**
    * 工点id
    */
    @ApiModelProperty("工点id")
    private Integer pointId;

    /**
    * 
    */
    private void setId(Integer id){
    this.id = id;
    }

    /**
    * 计划ID
    */
    private void setPlanId(Integer planId){
    this.planId = planId;
    }

    /**
    * 工序名称
    */
    private void setName(String name){
    this.name = name;
    }

    /**
    * 构件id
    */
    private void setCompId(Integer compId){
    this.compId = compId;
    }

    /**
    * 工点id
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
    * 计划ID
    */
    private Integer getPlanId(){
    return this.planId;
    }

    /**
    * 工序名称
    */
    private String getName(){
    return this.name;
    }

    /**
    * 构件id
    */
    private Integer getCompId(){
    return this.compId;
    }

    /**
    * 工点id
    */
    private Integer getPointId(){
    return this.pointId;
    }

}
