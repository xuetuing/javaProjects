package com.example.work.generator.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 工序任务完成表
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
    * 计划id
    */
    @ApiModelProperty("计划id")
    private Integer planId;
    /**
    * 工序id
    */
    @ApiModelProperty("工序id")
    private Integer processesId;
    /**
    * 完成时间
    */
    @ApiModelProperty("完成时间")
    private LocalDateTime compeledTime;
    /**
    * 报送人
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("报送人")
    @Length(max= 255,message="编码长度不能超过255")
    private String reportUser;

    /**
    * 
    */
    private void setId(Integer id){
    this.id = id;
    }

    /**
    * 计划id
    */
    private void setPlanId(Integer planId){
    this.planId = planId;
    }

    /**
    * 工序id
    */
    private void setProcessesId(Integer processesId){
    this.processesId = processesId;
    }

    /**
    * 完成时间
    */
    private void setCompeledTime(LocalDateTime compeledTime){
    this.compeledTime = compeledTime;
    }

    /**
    * 报送人
    */
    private void setReportUser(String reportUser){
    this.reportUser = reportUser;
    }


    /**
    * 
    */
    private Integer getId(){
    return this.id;
    }

    /**
    * 计划id
    */
    private Integer getPlanId(){
    return this.planId;
    }

    /**
    * 工序id
    */
    private Integer getProcessesId(){
    return this.processesId;
    }

    /**
    * 完成时间
    */
    private LocalDateTime getCompeledTime(){
    return this.compeledTime;
    }

    /**
    * 报送人
    */
    private String getReportUser(){
    return this.reportUser;
    }

}
