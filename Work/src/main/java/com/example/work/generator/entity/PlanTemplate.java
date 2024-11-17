package com.example.work.generator.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 计划模板
* @TableName plan_template
*/
public class PlanTemplate implements Serializable {

    /**
    * 模板id
    */
    @NotNull(message="[模板id]不能为空")
    @ApiModelProperty("模板id")
    private Integer templateId;
    /**
    * 模板名
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("模板名")
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
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    /**
    * 模板id
    */
    private void setTemplateId(Integer templateId){
    this.templateId = templateId;
    }

    /**
    * 模板名
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
    * 创建时间
    */
    private void setCreateTime(LocalDateTime createTime){
    this.createTime = createTime;
    }


    /**
    * 模板id
    */
    private Integer getTemplateId(){
    return this.templateId;
    }

    /**
    * 模板名
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
    * 创建时间
    */
    private LocalDateTime getCreateTime(){
    return this.createTime;
    }

}
