 CREATE TABLE CODE_INFO ( PID VARCHAR(128), PRIMARY KEY(PID) ) ;
 ALTER TABLE CODE_INFO ADD CODE  VARCHAR(128)  ;
 ALTER TABLE CODE_INFO ADD CREATE_TIME  DATETIME  ;
 ALTER TABLE CODE_INFO ADD CREATE_USER_ID  VARCHAR(128)  ;
 ALTER TABLE CODE_INFO ADD LAST_UP_TIME  DATETIME  ;
 ALTER TABLE CODE_INFO ADD STATUS  VARCHAR(128)  ;
 ALTER TABLE CODE_INFO ADD DESCRIPTIONS  VARCHAR(128)  ;
 ALTER TABLE CODE_INFO ADD ORDER_NUM  INT  ;
 ALTER TABLE CODE_INFO ADD PCODE  VARCHAR(128)  ;
 ALTER TABLE CODE_INFO ADD PNAME  VARCHAR(128)  ;
INSERT INTO `code_info` VALUES ('4028b88169c262860169c26438ec0000', 'COLOR', null, null, null, '1', '红色', '1', null, null);
INSERT INTO `code_info` VALUES ('4028b88169c262860169c2698e1a0001', 'COLOR', null, null, null, '1', '黄色', '2', null, null);
INSERT INTO `code_info` VALUES ('4028b88169c262860169c26ab98d0002', 'COLOR', null, null, null, '1', '蓝色', '3', null, null);
INSERT INTO `code_info` VALUES ('4028b88169c262860169c26ac6a10003', 'SCREEN', null, null, null, '1', '17寸', '1', null, null);
INSERT INTO `code_info` VALUES ('4028b88169c262860169c26ad3810004', 'SCREEN', null, null, null, '1', '15寸', '2', null, null);
INSERT INTO `code_info` VALUES ('4028b88169c262860169c26e6c260005', 'CPU', null, null, null, '1', 'I3', '1', null, null);
INSERT INTO `code_info` VALUES ('4028b88169c262860169c26e71630006', 'CPU', null, null, null, '1', 'I5', '2', null, null);
INSERT INTO `code_info` VALUES ('4028b88169c262860169c26e76250007', 'CPU', null, null, null, '1', 'I7', '3', null, null);
INSERT INTO `code_info` VALUES ('4028b88169c6efd80169c6f418370000', 'COLOR', null, null, null, '1', '绿色', '4', null, null);
INSERT INTO `code_info` VALUES ('4028b88169c6efd80169c6f698300001', 'COLOR', null, null, null, '1', '金色', '5', null, null);
INSERT INTO `code_info` VALUES ('4028b88169c6fb170169c6fb9e170000', 'SCREEN', null, null, null, '1', '13寸', '3', null, null);
INSERT INTO `code_info` VALUES ('4028b88169c6fb170169c6fbcdf70001', 'COLOR', null, null, null, '1', '银色', '6', null, null);

