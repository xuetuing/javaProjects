package com.example.work.generator.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 
* @TableName plan_version
*/
public class PlanVersion implements Serializable {

    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Integer id;
    /**
    * 版本
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("版本")
    @Length(max= 255,message="编码长度不能超过255")
    private String version;
    /**
    * 发布日期
    */
    @ApiModelProperty("发布日期")
    private LocalDateTime deployDate;
    /**
    * 发布人
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("发布人")
    @Length(max= 255,message="编码长度不能超过255")
    private String deployUser;
    /**
    * 状态 0已停用 1当前执行 2未发布
    */
    @ApiModelProperty("状态 0已停用 1当前执行 2未发布")
    private Integer status;
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
    * 
    */
    private void setId(Integer id){
    this.id = id;
    }

    /**
    * 版本
    */
    private void setVersion(String version){
    this.version = version;
    }

    /**
    * 发布日期
    */
    private void setDeployDate(LocalDateTime deployDate){
    this.deployDate = deployDate;
    }

    /**
    * 发布人
    */
    private void setDeployUser(String deployUser){
    this.deployUser = deployUser;
    }

    /**
    * 状态 0已停用 1当前执行 2未发布
    */
    private void setStatus(Integer status){
    this.status = status;
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
    * 
    */
    private Integer getId(){
    return this.id;
    }

    /**
    * 版本
    */
    private String getVersion(){
    return this.version;
    }

    /**
    * 发布日期
    */
    private LocalDateTime getDeployDate(){
    return this.deployDate;
    }

    /**
    * 发布人
    */
    private String getDeployUser(){
    return this.deployUser;
    }

    /**
    * 状态 0已停用 1当前执行 2未发布
    */
    private Integer getStatus(){
    return this.status;
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

}
