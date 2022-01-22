
/**
 * 功能说明: <br>
 * 系统版本: v1.0<br>
 * 开发人员: @author wangyang <br>
 * 开发时间: 2016年12月26日<br>
 */
public enum SettleStepEnum {
	BOPDATECHANGESTART("受理日切开始","受理系统日切","70050201","1","0"),
	BOPDATECHANGESUCCESS("受理系统日切成功","受理系统日切","70050201","1","1"),
	BOPDATECHANGEFAIL("受理系统日切失败","受理系统日切","70050201","1","3"),
	
	BOPTOHISSTART("受理数据归历史开始","受理数据归历史","70050202","2","0"),
	BOPTOHISSUCCESS("受理数据归历史成功","受理数据归历史","70050202","2","1"),
	BOPTOHISEFAIL("受理数据归历史失败","受理数据归历史","70050202","2","3"),
	
	BOPINITSTART("受理数据归历史开始","受理系统初始化","70050203","3","0"),
	BOPINITSUCCESS("受理数据归历史成功","受理系统初始化","70050203","3","1"),
	BOPINITFAIL("受理数据归历史失败","受理系统初始化","70050203","3","3");

	private final String menu_caption;//菜单名
	private final String menu_id;//菜单号
	private final String step_no;//步骤号
	private final String subctrl_flag;//操作标志 0：开始 1：成功 3：失败
	private final String remark;
	
	SettleStepEnum(String remark ,String menu_caption,String menu_id ,String step_no,String subctrl_flag){
		this.menu_caption = menu_caption;
		this.menu_id = menu_id;
		this.step_no = step_no;
		this.subctrl_flag = subctrl_flag;
		this.remark =remark;
	}
	
	
	public String getMenu_caption() {
		return menu_caption;
	}

	
	public String getMenu_id() {
		return menu_id;
	}

	
	public String getStep_no() {
		return step_no;
	}

	
	public String getSubctrl_flag() {
		return subctrl_flag;
	}

	
	public String getRemark() {
		return remark;
	}
	
	@Override
	public String toString(){
		return this.remark;
	}
	
}

