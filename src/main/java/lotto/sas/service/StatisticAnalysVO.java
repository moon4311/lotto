package lotto.sas.service;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StatisticAnalysVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String lRound;
	private int r1cnt,r2cnt,r3cnt,r4cnt,r5cnt;
	private long m1,m2,m3,m4,m5;
	private int no1,no2,no3,no4,no5,no6;
	private int bonusno;
	private String dt;
}
