CREATE TABLE COMTECOPSEQ
(
	TABLE_NAME            VARCHAR(20) NULL,
	NEXT_ID               NUMERIC(30) NULL,
	 PRIMARY KEY (TABLE_NAME)
)
;

CREATE UNIQUE INDEX COMTECOPSEQ_PK ON COMTECOPSEQ
(
	TABLE_NAME
)
;



CREATE TABLE COMTCCMMNCLCODE
(
	CL_CODE               CHAR(3) NOT NULL,
	CL_CODE_NM            VARCHAR(60) NULL,
	CL_CODE_DC            VARCHAR(200) NULL,
	USE_AT                CHAR(1) NULL,
	FRST_REGIST_PNTTM     DATETIME NULL,
	FRST_REGISTER_ID      VARCHAR(20) NULL,
	LAST_UPDT_PNTTM       DATETIME NULL,
	LAST_UPDUSR_ID        VARCHAR(20) NULL,
	 PRIMARY KEY (CL_CODE)
)
;

CREATE UNIQUE INDEX COMTCCMMNCLCODE_PK ON COMTCCMMNCLCODE
(
	CL_CODE
)
;



CREATE TABLE COMTCCMMNCODE
(
	CODE_ID               VARCHAR(6) NOT NULL,
	CODE_ID_NM            VARCHAR(60) NULL,
	CODE_ID_DC            VARCHAR(200) NULL,
	USE_AT                CHAR(1) NULL,
	CL_CODE               CHAR(3) NULL,
	FRST_REGIST_PNTTM     DATETIME NULL,
	FRST_REGISTER_ID      VARCHAR(20) NULL,
	LAST_UPDT_PNTTM       DATETIME NULL,
	LAST_UPDUSR_ID        VARCHAR(20) NULL,
	 PRIMARY KEY (CODE_ID),
	FOREIGN KEY COMTCCMMNCODE_FK1 (CL_CODE) REFERENCES COMTCCMMNCLCODE(CL_CODE)
)
;

CREATE UNIQUE INDEX COMTCCMMNCODE_PK ON COMTCCMMNCODE
(
	CODE_ID
)
;
CREATE INDEX COMTCCMMNCODE_i01 ON COMTCCMMNCODE
(
	CL_CODE
)
;



CREATE TABLE COMTCCMMNDETAILCODE
(
	CODE_ID               VARCHAR(6) NOT NULL,
	CODE                  VARCHAR(15) NOT NULL,
	CODE_NM               VARCHAR(60) NULL,
	CODE_DC               VARCHAR(200) NULL,
	USE_AT                CHAR(1) NULL,
	FRST_REGIST_PNTTM     DATETIME NULL,
	FRST_REGISTER_ID      VARCHAR(20) NULL,
	LAST_UPDT_PNTTM       DATETIME NULL,
	LAST_UPDUSR_ID        VARCHAR(20) NULL,
	 PRIMARY KEY (CODE_ID,CODE),
	FOREIGN KEY COMTCCMMNDETAILCODE_FK1 (CODE_ID) REFERENCES COMTCCMMNCODE(CODE_ID)
)
;

CREATE UNIQUE INDEX COMTCCMMNDETAILCODE_PK ON COMTCCMMNDETAILCODE
(
	CODE_ID,
	CODE
)
;
CREATE INDEX COMTCCMMNDETAILCODE_i01 ON COMTCCMMNDETAILCODE
(
	CODE_ID
)
;



CREATE TABLE COMTNAUTHORGROUPINFO
(
	GROUP_ID              CHAR(20) NULL,
	GROUP_NM              VARCHAR(60) NOT NULL,
	GROUP_CREAT_DE        CHAR(20) NOT NULL,
	GROUP_DC              VARCHAR(100) NULL,
	 PRIMARY KEY (GROUP_ID)
)
;

CREATE UNIQUE INDEX COMTNAUTHORGROUPINFO_PK ON COMTNAUTHORGROUPINFO
(
	GROUP_ID
)
;



CREATE TABLE COMTNORGNZTINFO
(
	ORGNZT_ID             CHAR(20) NULL,
	ORGNZT_NM             VARCHAR(20) NOT NULL,
	ORGNZT_DC             VARCHAR(100) NULL,
	 PRIMARY KEY (ORGNZT_ID)
)
;

CREATE UNIQUE INDEX COMTNORGNZTINFO_PK ON COMTNORGNZTINFO
(
	ORGNZT_ID
)
;



CREATE TABLE COMTNFILE
(
	ATCH_FILE_ID          CHAR(20) NOT NULL,
	CREAT_DT              DATETIME NOT NULL,
	USE_AT                CHAR(1) NULL,
	 PRIMARY KEY (ATCH_FILE_ID)
)
;

CREATE UNIQUE INDEX COMTNFILE_PK ON COMTNFILE
(
	ATCH_FILE_ID
)
;



CREATE TABLE COMTNFILEDETAIL
(
	ATCH_FILE_ID          CHAR(20) NOT NULL,
	FILE_SN               NUMERIC(10) NOT NULL,
	FILE_STRE_COURS       VARCHAR(2000) NOT NULL,
	STRE_FILE_NM          VARCHAR(255) NOT NULL,
	ORIGNL_FILE_NM        VARCHAR(255) NULL,
	FILE_EXTSN            VARCHAR(20) NOT NULL,
	FILE_CN               MEDIUMTEXT NULL,
	FILE_SIZE             NUMERIC(8) NULL,
	 PRIMARY KEY (ATCH_FILE_ID,FILE_SN),
	FOREIGN KEY COMTNFILEDETAIL_FK1 (ATCH_FILE_ID) REFERENCES COMTNFILE(ATCH_FILE_ID)
)
;

CREATE UNIQUE INDEX COMTNFILEDETAIL_PK ON COMTNFILEDETAIL
(
	ATCH_FILE_ID,
	FILE_SN
)
;
CREATE INDEX COMTNFILEDETAIL_i01 ON COMTNFILEDETAIL
(
	ATCH_FILE_ID
)
;



CREATE TABLE COMTNPHOTOALBUM
(
	SN                    INT(20) NOT NULL,
	MBER_ID               VARCHAR(20) NOT NULL,
	PHOTO_SJ              VARCHAR(256) NULL,
	ATCH_FILE_ID          CHAR(20) NULL,
	CREAT_DT             DATE NULL,
	UPDT_DT               DATE NULL,
	CONSTRAINT  COMTNPHOTOALBUM_PK PRIMARY KEY (SN)
);


create table EMPLOYEE(
emp_id numeric(10,0),
emp_pwd varchar(20),
emp_nm varchar(15) not null,
dept_id numeric(9,0),
registrant varchar(10),
regis_date timestamp not null default current_timestamp,
amender varchar(10),
amend_date timestamp not null default current_timestamp on update current_timestamp,
use_yn varchar(1) default 'Y',
primary key(emp_id)
);

create table NIGHT_WORKER(
date1 date,
emp_id numeric(10,0),
emp_nm varchar(15),
registrant varchar(10),
regis_date timestamp not null default current_timestamp,
amender varchar(10),
amend_date timestamp not null default current_timestamp on update current_timestamp,
use_yn varchar(1) default 'Y'
);

create table INSPECTOR(
sector_id varchar(9),
emp_id numeric(10,0),
emp_nm varchar(15),
registrant varchar(10),
regis_date timestamp not null default current_timestamp,
amender varchar(10),
amend_date timestamp not null default current_timestamp on update current_timestamp,
use_yn varchar(1) default 'Y',
primary key(sector_id,emp_id)
);

create table GENERAL_INSPECTOR(
emp_id numeric(10,0),
emp_nm varchar(15),
registrant varchar(10),
regis_date timestamp not null default current_timestamp,
amender varchar(10),
amend_date timestamp not null default current_timestamp on update current_timestamp,
use_yn varchar(1) default 'Y',
primary key(emp_id)
);

create table SECURITY_CHECKLIST_NIGHT(
date1 date,
sector_id varchar(9),
emp_id numeric(10,0),
doc_strg tinyint(1),
cln_stat tinyint(1),
light_stat tinyint(1),
fireext_stat tinyint(1),
door_stat tinyint(1),
inspect_time varchar(50),
appendpic varchar(40),
pic_sn numeric(10,0),
cmnt varchar(100),
chk tinyint(1),
registrant varchar(10),
regis_date timestamp not null default current_timestamp,
amender varchar(10),
amend_date timestamp not null default current_timestamp on update current_timestamp,
use_yn varchar(1) default 'Y'
);

create table SECURITY_CHECKLIST_FINAL(
date1 date,
sector_id varchar(9),
dept_id numeric(9,0),
emp_id numeric(10,0),
doc_strg tinyint(1),
cln_stat tinyint(1),
light_stat tinyint(1),
fireext_stat tinyint(1),
door_stat tinyint(1),
inspect_time varchar(50),
appendpic varchar(40),
pic_sn numeric(10,0),
cmnt varchar(100),
chk tinyint(1),
registrant varchar(10),
regis_date timestamp not null default current_timestamp,
amender varchar(10),
amend_date timestamp not null default current_timestamp on update current_timestamp,
use_yn varchar(1) default 'Y'
);

create table INSPECTOR_CHECKLIST(
date1 date,
sector_id varchar(9),
emp_id numeric(10,0),
cmnt varchar(100),
issue tinyint(1),
registrant varchar(10),
regis_date timestamp not null default current_timestamp,
amender varchar(10),
amend_date timestamp not null default current_timestamp on update current_timestamp,
use_yn varchar(1) default 'Y'
);

create table SECTOR_DEPT_INFO(
dept_id numeric(9,0),
dept_nm varchar(15),
sector_id varchar(9),
sector_nm varchar(15),
registrant varchar(10),
regis_date timestamp not null default current_timestamp,
amender varchar(10),
amend_date timestamp not null default current_timestamp on update current_timestamp,
use_yn varchar(1) default 'Y',
primary key(dept_id)
);

create table GEN_LIST_CHKLIST(
date1 date,
emp_id numeric(10,0),
chk tinyint(1),
registrant varchar(10),
regis_date timestamp not null default current_timestamp,
amender varchar(10),
amend_date timestamp not null default current_timestamp on update current_timestamp,
use_yn varchar(1) default 'Y'
);