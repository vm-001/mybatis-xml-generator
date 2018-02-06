# mybatis-xml-generator

## 简介
mybatis-xml-generator是一款利用反射与velocity模板引擎生成MybatisXML的工具，你可以很轻易的修改模板里的内容，如果需要，可以在`src/main/resources`里新建模板。

## 如何使用

```java
public class MybatisXmlGenerator {

    // ...

    public static void main(String[] args) {
        String xml = null;
        // generateXml(模板名称，表名，DAO类，实体类);
        xml = generateXml("mybatis-xml.vm", "user", UserDao.class, User.class);

        System.out.println(xml);
    }
}
```

生成如下内容：

```xml
<?xml version="1.0" encoding="UTF-8" ?>  
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="top.leeys.codegenerator.UserDao">

    <select id="getById" resultType="top.leeys.codegenerator.User">
        select * from user where id = #{id} and status = 0;
    </select>

    <delete id="deleteById">
        delete from user where id = #{id};
    </delete>

    <insert id="insert" parameterType="top.leeys.codegenerator.User" useGeneratedKeys="true" keyProperty="id">
        insert into user
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <if test="username != null">username,</if>
            <if test="password != null">password,</if>
            <if test="loginCount != null">login_count,</if>
            <if test="loginTime != null">login_time,</if>
            <if test="countryCode != null">country_code,</if>
            <if test="phone != null">phone,</if>
            create_time,
            update_time,
            status
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
            <if test="username != null">#{username},</if>
            <if test="password != null">#{password},</if>
            <if test="loginCount != null">#{loginCount},</if>
            <if test="loginTime != null">#{loginTime},</if>
            <if test="countryCode != null">#{countryCode},</if>
            <if test="phone != null">#{phone},</if>
            now(),
            now(),
            0
        </trim>
    </insert>

    <update id="update" parameterType="top.leeys.codegenerator.User">
        update user
        <set>
            <if test="username != null">username = #{username},</if>
            <if test="password != null">password = #{password},</if>
            <if test="loginCount != null">login_count = #{loginCount},</if>
            <if test="loginTime != null">login_time = #{loginTime},</if>
            <if test="countryCode != null">country_code = #{countryCode},</if>
            <if test="phone != null">phone = #{phone},</if>
             update_time = now()
        </set>
        where id = #{id} and status = 0;
    </update>

    <select id="listByIds" resultType="top.leeys.codegenerator.User">
        <if test="ids != null and !ids.isEmpty()">
            select * from user where id in
            <foreach collection="ids" item="item" open="(" separator="," close=")">
                #{item}
            </foreach>
            and status = 0
        </if>
    </select>

    <sql id="query_filter">
        <if test="model.id != null">and id = #{model.id}</if>
        <if test="model.username != null">and username = #{model.username}</if>
        <if test="model.password != null">and password = #{model.password}</if>
        <if test="model.loginCount != null">and login_count = #{model.loginCount}</if>
        <if test="model.loginTime != null">and login_time = #{model.loginTime}</if>
        <if test="model.countryCode != null">and country_code = #{model.countryCode}</if>
        <if test="model.phone != null">and phone = #{model.phone}</if>
        and status = 0
    </sql>

    <sql id="count_filter">
        <if test="id != null">and id = #{id}</if>
        <if test="username != null">and username = #{username}</if>
        <if test="password != null">and password = #{password}</if>
        <if test="loginCount != null">and login_count = #{loginCount}</if>
        <if test="loginTime != null">and login_time = #{loginTime}</if>
        <if test="countryCode != null">and country_code = #{countryCode}</if>
        <if test="phone != null">and phone = #{phone}</if>
        and status = 0
    </sql>

    <select id="list" resultType="top.leeys.codegenerator.User" >
        select * from user
        <where>
            <include refid="query_filter"/>
        </where>
        <foreach item="sort" index="col" collection="orderBy"
                 open="ORDER BY" separator="," close="">
            ${col} ${sort}
        </foreach>
        limit #{startRow}, #{pageSize};
    </select>

    <select id="count" resultType="int">
        select count(*) from user
        <where>
            <include refid="count_filter"/>
        </where>
    </select>

</mapper>
```
## 如何自定义模板

在`src/main/resources`目录修改`mybatis-xml.vm`或直接新建模板文件

## 最后
Do whatever you want.
