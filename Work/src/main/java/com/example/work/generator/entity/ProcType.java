package com.example.work.generator.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 工序规格表
* @TableName proc_type
*/
public class ProcType implements Serializable {

    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Integer id;
    /**
    * 属性名
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("属性名")
    @Length(max= 255,message="编码长度不能超过255")
    private String name;
    /**
    * 属性值
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("属性值")
    @Length(max= 255,message="编码长度不能超过255")
    private String value;
    /**
    * 单位
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("单位")
    @Length(max= 255,message="编码长度不能超过255")
    private String unit;
    /**
    * 分类名称
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("分类名称")
    @Length(max= 255,message="编码长度不能超过255")
    private String className;
    /**
    * 工序id
    */
    @ApiModelProperty("工序id")
    private Integer proceId;

    /**
    * 
    */
    private void setId(Integer id){
    this.id = id;
    }

    /**
    * 属性名
    */
    private void setName(String name){
    this.name = name;
    }

    /**
    * 属性值
    */
    private void setValue(String value){
    this.value = value;
    }

    /**
    * 单位
    */
    private void setUnit(String unit){
    this.unit = unit;
    }

    /**
    * 分类名称
    */
    private void setClassName(String className){
    this.className = className;
    }

    /**
    * 工序id
    */
    private void setProceId(Integer proceId){
    this.proceId = proceId;
    }


    /**
    * 
    */
    private Integer getId(){
    return this.id;
    }

    /**
    * 属性名
    */
    private String getName(){
    return this.name;
    }

    /**
    * 属性值
    */
    private String getValue(){
    return this.value;
    }

    /**
    * 单位
    */
    private String getUnit(){
    return this.unit;
    }

    /**
    * 分类名称
    */
    private String getClassName(){
    return this.className;
    }

    /**
    * 工序id
    */
    private Integer getProceId(){
    return this.proceId;
    }

}
