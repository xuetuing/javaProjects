package com.example.work.generator.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
* 
* @TableName plan
*/
@Data
public class Plan implements Serializable {


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
    * 工效
    */
    @ApiModelProperty("工效")
    private Integer workEfficiency;
    /**
    * 开始时间
    */
    @ApiModelProperty("开始时间")
    private LocalDateTime startTime;
    /**
    * 结束时间
    */
    @ApiModelProperty("结束时间")
    private LocalDateTime endTime;
    /**
    * 版本
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("版本")
    @Length(max= 255,message="编码长度不能超过255")
    private String version;
    /**
    * 施工任务名称
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("施工任务名称")
    @Length(max= 255,message="编码长度不能超过255")
    private String taskName;
    /**
    * 施工逻辑
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("施工逻辑")
    @Length(max= 255,message="编码长度不能超过255")
    private String constructionLogic;
    /**
    * 状态  计划中0  正常1 超期2 提前完成3
    */
    @ApiModelProperty("状态  计划中0  正常1 超期2 提前完成3")
    private Integer status;

}
