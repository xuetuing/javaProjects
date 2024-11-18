package com.example.work.plan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
* 
* @TableName plan
*/
@Data
public class Plan implements Serializable {

    /**
    * 
    */
    @TableId(type = IdType.AUTO)
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
    * 0-正常；1-超期；2-已完成；3-超期完成
    */
    @ApiModelProperty("0-正常；1-超期；2-已完成；3-超期完成")
    private Integer status;
    /**
    * 项目ID
    */
    @ApiModelProperty("项目ID")
    private Integer projectId;
    /**
    * 是否提前展示
    */
    @ApiModelProperty("是否提前展示")
    private Integer priorityDisplay;


}
