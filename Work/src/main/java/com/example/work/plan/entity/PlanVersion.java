package com.example.work.plan.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
* 
* @TableName plan_version
*/
@Data
@Builder
public class PlanVersion implements Serializable {

    /**
    * 
    */
    @TableId(type = IdType.AUTO)
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Integer id;
    /**
    * 版本
    */
    @NotBlank(message="[版本]不能为空")
    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("版本")
    @Length(max= 32,message="编码长度不能超过32")
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
    * 项目ID
    */
    @ApiModelProperty("项目ID")
    private Integer projectId;

}
