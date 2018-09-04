package com.example.springbootdemo.commons.constants;

/**
 * @author wukn
 */

public enum CMSExceptionCode {

	SUCCESS("0", "操作成功"),
	FAIL("1", "操作失败"),

	
	NO_FINDWEB("1000","页面ID无效,或该活动页已经下线"),
    WHITE_EXCEPTION("1001","无法找到该页面 或 whiteCode 不存在"),
	PROMOTION_SPUID_NONULL("1002","请求活动详情信息spuId不能为空"),
    PROMOTION_LANTFORMID_NONULL("1003","请求活动详情信息PlatformId不能为空"),
    SERVICE_promotion_IS_NOT_AVAILABLE("1004","营销中心服务不可用"),
	SERVICE_GOODCENTER_NO_USER("1005","商品中心服务不可用,商品数据请求失败"),
	PROJECTID_NOT_NULL("1006","projectId不能为空"),
	PAGENAME_NOT_FIND("1007","页面名称重复，请重新输入"),
	LOGIN_PASSWORD_NO_TRUE("CMS1008","用户名或密码错误"),
	REQUEST_IllEGAL("1009","非法请求"),
	PARAMTER_IllEGAL("1010","非法参数请求"),
	USERNAME_EXIT("1011","用户名已存在"),
	PROJECT_NO_EXIT("1012","页面不存在"),
	REGISTER_SUCCESS("1013","注册成功"),
	REGISTER_FAIL("1014","注册失败，请重新尝试"),
	TOKEN_OVERTIME_AND_VALID("1015","token 失效 或 格式不对"),
	BUILD_CREATIVI_PAGE_FAIL("1016","创建活动页失败"),
	PAGENAME_NO_FOUND("1017","无法找到页面"),
	PAGETYPE_NO_KNOW("1018","页面类型没有指定"),
	ONLINE_PAGE_NO_DELETE("1019","上线页面不允许删除"),
	PAGENAME_NAME_NULL("1020","项目名称为空"),
	MINI_MINIPROGRAM_VERSION("1021","创建小程序活动页版本号不能为空"),
	ACTIVITY_PAGE_FAIL("1022","活动页创建失败"),
	MINI_PROGRAM_REQUEST_FAIL("1023","小程序接口请求失败,请确认请求是否正确"),
	COUPON_SERVER_NOT_BUILD("1024","优惠券服务不用,请稍后尝试"),
	COUPON_NOT_BETWON("1025","优惠券不可用,请重新输入"),
	COUPON_NOT_ADD("1026","优惠券id保存失败"),
	COUPON_ID_STAUS_IS_UP("1027","该优惠券已停用,请重新输入"),
	PAGE_ID_ID_NULL("1028","页面ID为空,无法查询优惠券信息"),
	COUPON_SERVER_CANY_NOT_USER("1029","优惠券服务不可用,获取优惠券信息失败"),
	FIND_COUPON_FIAL("1030","查询优惠券失败,请确认页面ID是否有效"),
	COUPONID_WRONGFUL("1031","优惠券ID不合法,请输入内容为数字的字符"),
	COUPON_ACTIVITY_REQUEST_PARAM("1032","请求参数不合法"),
	PLANTFORMID_FAIL_GET("1033","平台ID获取失败,请确平台名称是否有误"),
	HOME_PAHE_UPDATE_FAIL("1034","首页属性修改失败"),
	VERSION_NOT_NULL("1035","版本号不能为空"),
	ACTIVITY_LIST("1036","活动列表获取失败"),


	/**
	 * 跳转异常
	 */
	LINKHOST_ECHO("1040","HOST名重复，请重新输入"),
	LINKHOSTNAME_ECHO("1041","HOSTNAME名重复，请重新输入"),
	USER_NOY_FIND("1042","用户不合法"),
	LINK_NOT_NULL("1043","跳转对象为空"),
	ONLINE_LINK("1044","该跳转信息正在使用中，无法删除"),
    LING_EDIS_NOT("1045","参数不合法"),
	VERSION_MUST_SHUZI("1046","版本号必须是纯数字"),
	LINK_DETAIL_FAIL("1047","请确认查询条件和查询信息是否存在"),
	FIND_PRAM_FAIL("1048","获取信息失败"),
	CITY_ID_AND_SHOP_ID("1049","shopId和cityId不能同时存在"),
	CITY_ID_AND_SHOP_ID_not("1050","shopId和cityId不匹配")

	;

	private String code;
    private String message;

	CMSExceptionCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMsg(String msg) {
		this.message = msg;
	}
}
