package com.hanwang.web.PO;import lombok.Data;import pub.gadfly.sdk.Utils.StreamUtil;@Datapublic class UserPO{	private Integer id;	private String realname;	private String email;	private String mobile;	private String headPic;	public void setHeadPic(byte[] headPic){		try {			this.headPic = StreamUtil.bytes2Base64Pic(headPic);		} catch (Exception e) {			e.printStackTrace();		}	}}