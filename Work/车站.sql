CREATE TABLE `work_area` (
	`id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`name` VARCHAR(255),
	PRIMARY KEY(`id`)
);


CREATE TABLE `work_point` (
	`id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`name` VARCHAR(255),
	`area_id` INTEGER,
	PRIMARY KEY(`id`)
);


CREATE TABLE `plan_version` (
	`id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`version` VARCHAR(32) NOT NULL COMMENT '版本',
	`deploy_date` DATETIME COMMENT '发布日期',
	`deploy_user` VARCHAR(255) COMMENT '发布人',
	`status` TINYINT COMMENT '状态 0已停用 1当前执行 2未发布',
	`area_id` INTEGER COMMENT '工区',
	`point_id` INTEGER COMMENT '工点',
	`project_id` INTEGER COMMENT '项目ID',
	PRIMARY KEY(`id`)
);


CREATE TABLE `plan_template` (
	`id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE COMMENT '模板id',
	`template_name` VARCHAR(255) COMMENT '模板名称',
	`impl_class` VARCHAR(255) COMMENT '实现类',
	`work_face` TINYINT COMMENT '工作面',
	PRIMARY KEY(`id`)
);


CREATE TABLE `processes` (
	`id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`plan_id` INTEGER COMMENT '计划ID',
	`name` VARCHAR(64) COMMENT '工序名称',
	`comp_id` INTEGER COMMENT '构件id',
	`point_id` INTEGER COMMENT '工点id',
	PRIMARY KEY(`id`)
) COMMENT='施工工序表';


CREATE TABLE `component` (
	`id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`name` VARCHAR(255) COMMENT '构件名',
	`profession` VARCHAR(255) COMMENT '专业级字段',
	`segment_id` INTEGER COMMENT '区段id',
	`work_efficiency` INTEGER COMMENT '工效',
	`plan_id` INTEGER COMMENT '计划ID',
	`parent_code` VARCHAR(255) COMMENT '上级编码',
	`code` VARCHAR(255) COMMENT '构件编码',
	`level` VARCHAR(255) COMMENT '层级',
	`project_id` VARCHAR(255) COMMENT '项目ID',
	`area_id` INTEGER COMMENT '工区ID',
	`point_id` INTEGER COMMENT '工点ID',
	PRIMARY KEY(`id`)
) COMMENT='构件表';


CREATE TABLE `comp_attr` (
	`id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`type` TINYINT COMMENT '类型：0-材料信息；1-工艺工序信息；2-结构信息；3-几何信息；4-机械信息；',
	`name` VARCHAR(255) COMMENT '属性名',
	`value` VARCHAR(255) COMMENT '属性值',
	`unit` VARCHAR(255) COMMENT '单位',
	`comp_id` INTEGER COMMENT '构件id',
	PRIMARY KEY(`id`)
) COMMENT='构件属性表';


CREATE TABLE `proc_complete` (
	`id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`proce_id` INTEGER COMMENT '工序id',
	`type` VARCHAR(255) COMMENT '类型 0-人员；1-材料；2-设备',
	`name` VARCHAR(255) COMMENT '属性名',
	`unit` VARCHAR(255) COMMENT '单位',
	`value` INTEGER COMMENT '数量',
	`report_user_id` INTEGER COMMENT '填报人',
	`report_user_name` VARCHAR(255) COMMENT '填报人姓名',
	`compeled_time` DATETIME COMMENT '完成时间',
	PRIMARY KEY(`id`)
) COMMENT='工序属性表（人材机）';


CREATE TABLE `segment` (
	`id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`area_id` INTEGER COMMENT '工区',
	`point_id` INTEGER COMMENT '工点',
	`name` VARCHAR(255) COMMENT '区段名',
	`project_id` INTEGER COMMENT '项目ID',
	PRIMARY KEY(`id`)
) COMMENT='区段';


CREATE TABLE `plan_history` (
	`id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`area_id` INTEGER COMMENT '工区',
	`point_id` INTEGER COMMENT '工点',
	`work_efficiency` INTEGER COMMENT '工效',
	`start_time` DATETIME COMMENT '开始时间',
	`end_time` DATETIME COMMENT '结束时间',
	`version` VARCHAR(255) COMMENT '版本',
	`task_name` VARCHAR(255) COMMENT '施工任务名称',
	`construction_logic` VARCHAR(255) COMMENT '施工逻辑',
	`status` TINYINT COMMENT '0-正常；1-超期；2-已完成；3-超期完成',
	`project_id` INTEGER COMMENT '项目ID',
	`priority_display ` TINYINT COMMENT '是否提前展示',
	PRIMARY KEY(`id`)
);


CREATE TABLE `plan` (
	`id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`area_id` INTEGER COMMENT '工区',
	`point_id` INTEGER COMMENT '工点',
	`work_efficiency` INTEGER COMMENT '工效',
	`start_time` DATETIME COMMENT '开始时间',
	`end_time` DATETIME COMMENT '结束时间',
	`version` VARCHAR(255) COMMENT '版本',
	`task_name` VARCHAR(255) COMMENT '施工任务名称',
	`construction_logic` VARCHAR(255) COMMENT '施工逻辑',
	`status` TINYINT COMMENT '0-正常；1-超期；2-已完成；3-超期完成',
	`project_id` INTEGER COMMENT '项目ID',
	`priority_display ` TINYINT COMMENT '是否提前展示',
	PRIMARY KEY(`id`)
);


