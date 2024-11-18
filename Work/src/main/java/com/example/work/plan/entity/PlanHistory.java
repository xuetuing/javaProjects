package com.example.work.plan.entity;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 
* @TableName plan_history
*/
public class PlanHistory implements Serializable {

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
    * 工效
    */
    private void setWorkEfficiency(Integer workEfficiency){
    this.workEfficiency = workEfficiency;
    }

    /**
    * 开始时间
    */
    private void setStartTime(LocalDateTime startTime){
    this.startTime = startTime;
    }

    /**
    * 结束时间
    */
    private void setEndTime(LocalDateTime endTime){
    this.endTime = endTime;
    }

    /**
    * 版本
    */
    private void setVersion(String version){
    this.version = version;
    }

    /**
    * 施工任务名称
    */
    private void setTaskName(String taskName){
    this.taskName = taskName;
    }

    /**
    * 施工逻辑
    */
    private void setConstructionLogic(String constructionLogic){
    this.constructionLogic = constructionLogic;
    }

    /**
    * 0-正常；1-超期；2-已完成；3-超期完成
    */
    private void setStatus(Integer status){
    this.status = status;
    }

    /**
    * 项目ID
    */
    private void setProjectId(Integer projectId){
    this.projectId = projectId;
    }

    /**
    * 是否提前展示
    */
    private void setPriorityDisplay(Integer priorityDisplay){
    this.priorityDisplay = priorityDisplay;
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
    * 工效
    */
    private Integer getWorkEfficiency(){
    return this.workEfficiency;
    }

    /**
    * 开始时间
    */
    private LocalDateTime getStartTime(){
    return this.startTime;
    }

    /**
    * 结束时间
    */
    private LocalDateTime getEndTime(){
    return this.endTime;
    }

    /**
    * 版本
    */
    private String getVersion(){
    return this.version;
    }

    /**
    * 施工任务名称
    */
    private String getTaskName(){
    return this.taskName;
    }

    /**
    * 施工逻辑
    */
    private String getConstructionLogic(){
    return this.constructionLogic;
    }

    /**
    * 0-正常；1-超期；2-已完成；3-超期完成
    */
    private Integer getStatus(){
    return this.status;
    }

    /**
    * 项目ID
    */
    private Integer getProjectId(){
    return this.projectId;
    }

    /**
    * 是否提前展示
    */
    private Integer getPriorityDisplay(){
    return this.priorityDisplay;
    }

}
