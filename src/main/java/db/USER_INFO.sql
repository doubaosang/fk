CREATE TABLE USER_INFO ( PID VARCHAR(128), PRIMARY KEY(PID) ) ;
 ALTER TABLE USER_INFO ADD USERNAME  VARCHAR(128)  ;
 ALTER TABLE USER_INFO ADD PASSWORD  VARCHAR(128)  ;
 ALTER TABLE USER_INFO ADD CREATE_TIME  DATETIME  ;
 ALTER TABLE USER_INFO ADD CREATE_USER_ID  VARCHAR(128)  ;
 ALTER TABLE USER_INFO ADD LAST_UP_TIME  DATETIME  ;
 ALTER TABLE USER_INFO ADD STATUS  VARCHAR(128)  ;
 ALTER TABLE USER_INFO ADD DESCRIPTIONS  VARCHAR(128)  ;
 ALTER TABLE USER_INFO ADD ORDER_NUM  INT  ;
 ALTER TABLE USER_INFO ADD PCODE  VARCHAR(128)  ;
 ALTER TABLE USER_INFO ADD PNAME  VARCHAR(128)  ;