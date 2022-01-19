package hms.revenuesharing;

import java.util.Date;

public interface IRevenueSharing {

    float getTotMnths(Date fromDt, Date toDt);

    float getTotAmnt(Date fromDt, Date toDt);

    boolean updDocIncentive(float eachmnthrevenue, Date fromDt, Date toDt);



}

