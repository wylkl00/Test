
public class PRDtest {

	static double PFromC(double C)//不断试验当前C对应的实际概率，用1/当前的数学期望值 得到当前概率
	{
	    double dCurP = 0.0;
	    double dPreSuccessP = 0.0;
	    double dPE = 0;
	    int nMaxFail = (int)Math.ceil(1.0 / C);
	    for (int i = 1; i <= nMaxFail; ++i)
	    {
	        dCurP = Math.min(1.0, i * C) * (1 - dPreSuccessP);
	        dPreSuccessP += dCurP;
	        dPE += i * dCurP;
	    }
	    return 1.0 / dPE;
	}

	static double CFromP(double P)
	{
	    double dUp = P;
	    double dLow = 0.0;
	    double dMid = P;
	    double dPLast = 1.0;
	    while (true)
	    {
	        dMid = (dUp + dLow) / 2.0;
	        double dPtested = PFromC(dMid);//使用二分法，不断试验当前C对应的实际概率
	        if (Math.abs(dPtested - dPLast) <= 0.0)//前后两次计算结果相同，说明到了逼近极限，不与P比较是因为有误差，可能永远无法再逼近
	            break;
	        if (dPtested > P)
	            dUp = dMid;
	        else
	            dLow = dMid;
	        dPLast = dPtested;
	        
	    }
	    return dMid;
	}



	 public static void main(String[] args){
	    for (int i = 1; i <= 100; ++i)
	    {
	        double p = i / 100.0;
	        double C = CFromP(p);
	        System.out.printf("PE=%f  C=%f\n", p, C);
	    }
	}
}
