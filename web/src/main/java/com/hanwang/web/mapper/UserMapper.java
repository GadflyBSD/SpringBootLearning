package com.hanwang.web.mapper;import com.baomidou.mybatisplus.core.mapper.BaseMapper;import com.hanwang.web.entity.User;import org.apache.ibatis.annotations.Mapper;import org.springframework.stereotype.Repository;/** * <p> * 用户信息表 Mapper 接口 * </p> * * @author gadfly * @since 2019-12-20 */@Mapper@Repositorypublic interface UserMapper extends BaseMapper<User> {}