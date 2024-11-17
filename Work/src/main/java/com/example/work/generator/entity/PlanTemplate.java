package com.example.work.generator.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 
* @TableName plan_template
*/
public class PlanTemplate implements Serializable {

    /**
    * 模板id
    */
    @NotNull(message="[模板id]不能为空")
    @ApiModelProperty("模板id")
    private Integer id;
    /**
    * 模板名称
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("模板名称")
    @Length(max= 255,message="编码长度不能超过255")
    private String templateName;
    /**
    * 实现类
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("实现类")
    @Length(max= 255,message="编码长度不能超过255")
    private String implClass;
    /**
    * 工作面
    */
    @ApiModelProperty("工作面")
    private Integer workFace;

    /**
    * 模板id
    */
    private void setId(Integer id){
    this.id = id;
    }

    /**
    * 模板名称
    */
    private void setTemplateName(String templateName){
    this.templateName = templateName;
    }

    /**
    * 实现类
    */
    private void setImplClass(String implClass){
    this.implClass = implClass;
    }

    /**
    * 工作面
    */
    private void setWorkFace(Integer workFace){
    this.workFace = workFace;
    }


    /**
    * 模板id
    */
    private Integer getId(){
    return this.id;
    }

    /**
    * 模板名称
    */
    private String getTemplateName(){
    return this.templateName;
    }

    /**
    * 实现类
    */
    private String getImplClass(){
    return this.implClass;
    }

    /**
    * 工作面
    */
    private Integer getWorkFace(){
    return this.workFace;
    }

}
