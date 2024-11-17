package com.example.work.generator.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 工序属性表（人材机）
* @TableName proc_complete
*/
public class ProcComplete implements Serializable {

    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Integer id;
    /**
    * 工序id
    */
    @ApiModelProperty("工序id")
    private Integer proceId;
    /**
    * 类型 0-人员；1-材料；2-设备
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("类型 0-人员；1-材料；2-设备")
    @Length(max= 255,message="编码长度不能超过255")
    private String type;
    /**
    * 属性名
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("属性名")
    @Length(max= 255,message="编码长度不能超过255")
    private String name;
    /**
    * 单位
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("单位")
    @Length(max= 255,message="编码长度不能超过255")
    private String unit;
    /**
    * 数量
    */
    @ApiModelProperty("数量")
    private Integer value;
    /**
    * 填报人
    */
    @ApiModelProperty("填报人")
    private Integer reportUserId;
    /**
    * 填报人姓名
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("填报人姓名")
    @Length(max= 255,message="编码长度不能超过255")
    private String reportUserName;
    /**
    * 完成时间
    */
    @ApiModelProperty("完成时间")
    private LocalDateTime compeledTime;

    /**
    * 
    */
    private void setId(Integer id){
    this.id = id;
    }

    /**
    * 工序id
    */
    private void setProceId(Integer proceId){
    this.proceId = proceId;
    }

    /**
    * 类型 0-人员；1-材料；2-设备
    */
    private void setType(String type){
    this.type = type;
    }

    /**
    * 属性名
    */
    private void setName(String name){
    this.name = name;
    }

    /**
    * 单位
    */
    private void setUnit(String unit){
    this.unit = unit;
    }

    /**
    * 数量
    */
    private void setValue(Integer value){
    this.value = value;
    }

    /**
    * 填报人
    */
    private void setReportUserId(Integer reportUserId){
    this.reportUserId = reportUserId;
    }

    /**
    * 填报人姓名
    */
    private void setReportUserName(String reportUserName){
    this.reportUserName = reportUserName;
    }

    /**
    * 完成时间
    */
    private void setCompeledTime(LocalDateTime compeledTime){
    this.compeledTime = compeledTime;
    }


    /**
    * 
    */
    private Integer getId(){
    return this.id;
    }

    /**
    * 工序id
    */
    private Integer getProceId(){
    return this.proceId;
    }

    /**
    * 类型 0-人员；1-材料；2-设备
    */
    private String getType(){
    return this.type;
    }

    /**
    * 属性名
    */
    private String getName(){
    return this.name;
    }

    /**
    * 单位
    */
    private String getUnit(){
    return this.unit;
    }

    /**
    * 数量
    */
    private Integer getValue(){
    return this.value;
    }

    /**
    * 填报人
    */
    private Integer getReportUserId(){
    return this.reportUserId;
    }

    /**
    * 填报人姓名
    */
    private String getReportUserName(){
    return this.reportUserName;
    }

    /**
    * 完成时间
    */
    private LocalDateTime getCompeledTime(){
    return this.compeledTime;
    }

}
