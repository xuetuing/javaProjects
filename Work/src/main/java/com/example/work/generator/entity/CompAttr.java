package com.example.work.generator.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 构件属性表
* @TableName comp_attr
*/
public class CompAttr implements Serializable {

    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Integer id;
    /**
    * 类型：0-材料信息；1-工艺工序信息；2-结构信息；3-几何信息；4-机械信息；
    */
    @ApiModelProperty("类型：0-材料信息；1-工艺工序信息；2-结构信息；3-几何信息；4-机械信息；")
    private Integer type;
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
    * 构件id
    */
    @ApiModelProperty("构件id")
    private Integer compId;

    /**
    * 
    */
    private void setId(Integer id){
    this.id = id;
    }

    /**
    * 类型：0-材料信息；1-工艺工序信息；2-结构信息；3-几何信息；4-机械信息；
    */
    private void setType(Integer type){
    this.type = type;
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
    * 构件id
    */
    private void setCompId(Integer compId){
    this.compId = compId;
    }


    /**
    * 
    */
    private Integer getId(){
    return this.id;
    }

    /**
    * 类型：0-材料信息；1-工艺工序信息；2-结构信息；3-几何信息；4-机械信息；
    */
    private Integer getType(){
    return this.type;
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
    * 构件id
    */
    private Integer getCompId(){
    return this.compId;
    }

}
