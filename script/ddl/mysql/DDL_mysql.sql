	/* 당첨 내역 */
 	CREATE TABLE LOTTO_HIST 
   (	L_ROUND int(10), 
	R1CNT VARCHAR(26), 
	M1 VARCHAR(26), 
	R2CNT VARCHAR(26), 
	M2 VARCHAR(26), 
	R3CNT VARCHAR(26), 
	M3 VARCHAR(26), 
	R4CNT VARCHAR(26), 
	M4 VARCHAR(26), 
	RANK5CNT VARCHAR(26), 
	MONEY5 VARCHAR(26), 
	NO1 int(2),
	NO2 int(2),
	NO3 int(2),
	NO4 int(2),
	NO5 int(2),
	NO6 int(2),
	BONUSNO int(2),
	DT DATE
   );
   
   /* 번호 정보 */
   CREATE TABLE LOTTO_BALL_NO
   ( BALL_NO int(2), 
	CNT int(3)
   );
   
   