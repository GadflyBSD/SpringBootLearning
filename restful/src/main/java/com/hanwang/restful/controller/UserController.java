package com.hanwang.restful.controller;import org.springframework.web.bind.annotation.*;import org.springframework.beans.factory.annotation.Autowired;import com.baomidou.mybatisplus.core.metadata.IPage;import com.baomidou.mybatisplus.extension.plugins.pagination.Page;import io.swagger.annotations.*;import com.hanwang.restful.service.UserService;import com.hanwang.restful.entity.User;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import pub.gadfly.sdk.Utils.ResponseHandler;import pub.gadfly.sdk.Utils.StringUtils;import java.sql.*;import java.util.List;import java.time.LocalTime;import java.time.LocalDate;import java.time.LocalDateTime;import java.math.BigInteger;import java.math.BigDecimal;import java.util.UUID;import com.alibaba.fastjson.JSON;/** *   @description : 用户信息表 控制器 AUTO *   @author gadfly *   @since 2019-12-20 */@Api(tags = "用户信息表 接口", description = "关于 用户信息表 的API接口")@RestController@RequestMapping("/user")public class UserController {	private final Logger logger=LoggerFactory.getLogger(UserController.class);	@Autowired	public UserService userService;	/**	 * @description : 用户信息表 获取分页列表	 * ---------------------------------	 * @author : gadfly	 * @since : Create in 2019-12-20	 */	@ApiOperation(value = "用户信息表 获取分页列表", notes = "")	@RequestMapping(value = "/getUserPage", method = RequestMethod.GET)	@ApiImplicitParams({			@ApiImplicitParam(dataType = "int", name = "pageNo", value = "起始页", example = "1", required = true),			@ApiImplicitParam(dataType = "int", name = "pageSize", value = "每页记录数", example = "20", required = true)	})	public ResponseHandler<User> getUserPage(			@RequestParam int pageNo,			@RequestParam int pageSize,			@RequestBody @ApiParam(name="用户信息表 对象",value="传入json格式") User params){		try{			Page<User> page = new Page(pageNo, pageSize);			IPage<User> pageList = userService.selectPage(page, params);			return ResponseHandler.resultList(pageList.getRecords(), page, "成功获取 用户信息表 获取分页列表");		}catch(Exception e){			logger.warn("异常信息:{}" + e.getMessage());			return  ResponseHandler.resultError("异常信息:{"+e.getClass().getName()+"}");		}	}	/**	 * @description : 用户信息表 获取列表	 * ---------------------------------	 * @author : gadfly	 * @since : Create in 2019-12-20	 */	@ApiOperation(value = "用户信息表 获取列表", notes = "")	@RequestMapping(value = "/getUserSelect", method = RequestMethod.GET)	public ResponseHandler<User> getUserSelect(@RequestBody @ApiParam(name="用户信息表 对象",value="传入json格式") User params){		try{			List<User> selectList = userService.selectList(params);			return ResponseHandler.resultBody(selectList, "成功获取 用户信息表 获取分页列表");		}catch(Exception e){			logger.warn("异常信息:{}" + e.getMessage());			return  ResponseHandler.resultError("异常信息:{"+e.getClass().getName()+"}");		}	}	/**	 * @description : 通过id获取用户信息表	 * ---------------------------------	 * @author : gadfly	 * @since : Create in 2019-12-20	 */	@ApiOperation(value = "通过id获取用户信息表", notes = "")	@RequestMapping(value = "/getUserById", method = RequestMethod.GET)	@ApiImplicitParam(dataType="int", name = "id", value = "用户ID", example = "1", required = true)	public ResponseHandler<User> getUserById(			@RequestParam Integer id	){		try{			User param= userService.getById(id);			return ResponseHandler.resultBody(param, "成功通过id获取用户信息表");		}catch(Exception e){			logger.warn("异常信息:{}" + e.getMessage());			return  ResponseHandler.resultError("异常信息:{"+e.getClass().getName()+"}");		}	}	/**	 * @description : 通过id删除用户信息表	 * ---------------------------------	 * @author : gadfly	 * @since : Create in 2019-12-20	 */	@ApiOperation(value = "通过id删除用户信息表", notes = "")	@RequestMapping(value = "/deleteUserById", method = RequestMethod.GET)	@ApiImplicitParam(dataType="int", name = "id", value = "用户ID", example = "1", required = true)	public ResponseHandler<User> deleteUserById(			@RequestParam Integer id	){		try{			return ResponseHandler.resultBody(id, "成功通过id删除用户信息表");		}catch(Exception e){			logger.warn("异常信息:{}" + e.getMessage());			return  ResponseHandler.resultError("异常信息:{"+e.getClass().getName()+"}");		}	}	/**	 * @description : 通过id更新UserList	 * ---------------------------------	 * @author : gadfly	 * @since : Create in 2019-12-16	 */	@ApiOperation(value = "通过id更新用户信息表", notes = "Beta 测试")	@RequestMapping(value = "/updateUserById", method = RequestMethod.POST)	@ApiImplicitParams({			@ApiImplicitParam(name = "id", value = "记录主键（系统自动生成ID）", defaultValue = ""),			@ApiImplicitParam(name = "realname", value = "真实姓名", defaultValue = ""),			@ApiImplicitParam(name = "mobile", value = "联系电话", defaultValue = ""),			@ApiImplicitParam(name = "email", value = "电子邮件", defaultValue = ""),			@ApiImplicitParam(name = "public_key", value = "用户公钥", defaultValue = ""),			@ApiImplicitParam(name = "private_key", value = "用户私钥", defaultValue = ""),			@ApiImplicitParam(name = "insert_time", value = "创建时间", defaultValue = ""),			@ApiImplicitParam(name = "modify_time", value = "变更时间", defaultValue = "")	})	public ResponseHandler<User> updateUserListById(			String id,			String realname,			String mobile,			String email,			String public_key,			String private_key,			String insert_time,			String modify_time	){		try{			User params = new User();			params.setId(StringUtils.typeCase(Integer.class, id));			params.setRealname(realname);			params.setMobile(mobile);			params.setEmail(email);			params.setPublicKey(public_key);			params.setPrivateKey(private_key);			params.setInsertTime(StringUtils.typeCase(LocalDateTime.class, insert_time));			params.setModifyTime(StringUtils.typeCase(LocalDateTime.class, modify_time));			return ResponseHandler.resultBody(userService.saveById(params), "成功通过id更新用户信息表");		}catch(Exception e){			logger.warn("异常信息:{}" + e.getMessage());			return ResponseHandler.resultError("异常信息:{"+e.getClass().getName()+"}");		}	}	/**	 * @description : 通过id更新用户信息表	 * ---------------------------------	 * @author : gadfly	 * @since : Create in 2019-12-20	 */	@ApiOperation(value = "通过id更新用户信息表数据", notes = "")	@RequestMapping(value = "/updateUserByIdUseJson", method = RequestMethod.POST)	public ResponseHandler<User> updateUserById(@RequestBody @ApiParam(name="用户信息表 对象",value="传入json格式",required=true) User params){		try{			return ResponseHandler.resultBody(userService.saveById(params), "成功通过id更新用户信息表");		}catch(Exception e){			logger.warn("异常信息:{}" + e.getMessage());			return  ResponseHandler.resultError("异常信息:{"+e.getClass().getName()+"}");		}	}	/**	 * @description : 添加用户信息表	 * ---------------------------------	 * @author : gadfly	 * @since : Create in 2019-12-20	 */	@ApiOperation(value = "添加用户信息表数据", notes = "Beta 测试")	@RequestMapping(value = "/addUser", method = RequestMethod.POST)	@ApiImplicitParams({			@ApiImplicitParam(name = "realname", value = "真实姓名", defaultValue = ""),			@ApiImplicitParam(name = "mobile", value = "联系电话", defaultValue = ""),			@ApiImplicitParam(name = "email", value = "电子邮件", defaultValue = ""),			@ApiImplicitParam(name = "public_key", value = "用户公钥", defaultValue = ""),			@ApiImplicitParam(name = "private_key", value = "用户私钥", defaultValue = ""),			@ApiImplicitParam(name = "insert_time", value = "创建时间", defaultValue = ""),			@ApiImplicitParam(name = "modify_time", value = "变更时间", defaultValue = "")	})	public ResponseHandler<User> addUser(			String realname,			String mobile,			String email,			String public_key,			String private_key,			String insert_time,			String modify_time	){		try{			User params = new User();			params.setRealname(realname);			params.setMobile(mobile);			params.setEmail(email);			params.setPublicKey(public_key);			params.setPrivateKey(private_key);			params.setInsertTime(StringUtils.typeCase(LocalDateTime.class, insert_time));			params.setModifyTime(StringUtils.typeCase(LocalDateTime.class, modify_time));			return ResponseHandler.resultBody(userService.add(params), "成功添加用户信息表");		}catch(Exception e){			logger.warn("异常信息:{}" + e.getMessage());			return  ResponseHandler.resultError("异常信息:{"+e.getClass().getName()+"}");		}	}	/**	 * @description : 传入JSON格式数据添加用户信息表数据	 * ---------------------------------	 * @author : gadfly	 * @since : Create in 2019-12-16	 */	@ApiOperation(value = "添加用户信息表数据（传入JSON格式数据）", notes = "")	@RequestMapping(value = "/addUserUseJson", method = RequestMethod.POST)	public ResponseHandler<User> addUserList(@RequestBody @ApiParam(name="用户信息表 对象",value="传入json格式",required=true) User params){		try{			return  ResponseHandler.resultBody(userService.add(params), "成功添加用户信息表");		}catch(Exception e){			logger.warn("异常信息:{}" + e.getMessage());			return ResponseHandler.resultError("异常信息:{"+e.getClass().getName()+"}");		}	}}