# spring-cloud-shop
    spring cloud 版分布式电商项目，全力打造顶级多模块，高可用，高扩展电商项目。
    目前项目使用分库设计方案，不同的模块依赖不同的数据库实例
    营销模块: pager_activity 
    数据中心: pager_goods 
    订单中心: pager_order 
    数据中心: pager_shop 
    风控中心: pager-risk 
    授权中心: pager-auth
    分布式文件系统采用apollo方式实现
    分布式定时任务采用xxl-job方式实现
    后台登陆采用oauth2.0密码模式登陆或者授权码模式登陆
# 设计初衷
    设计此项目是为了进一步学习Spring Cloud 技术栈。从项目实战深入Spring Cloud 各个微服务的解决方案。因此采用最常见的电商业务作为
    练手项目。
# 项目部署
## 部署<code>apollo</code>分布式配置系统
1. 在mysql中导入<code>ApolloConfigDB.sql</code>与<code>ApolloPortalDB.sql</code>
2. 修改apollo-*模块中的<code>config</code>文件夹中的数据配置信息
3. 修改apollo-*模块中<code>script</code> start.sh 的<code>SERVER_URL=eurakeUrl</code>地址

## 部署consul注册中心，consul 为项目的注册中心（eureka 在2.0以后不维护了）
   [consul下载](https://www.consul.io/downloads.html) <br />
   <code>consul agent -dev -client ip地址</code> 开发模式启动服务

## 部署redis 分布式缓存中间件
   [redis 下载](https://redis.io/download)

## 部署RabbitMq，异步扩展高可用消息中间件
   [RabbitMq 下载](https://www.rabbitmq.com/)

## 部署alibaba 分布式事务管理fescar-server
   将fescar-server部署在服务器中，启动服务 <code>sh fescar-server.sh 8091 file</code>
   
## 部署shop-*模块
   1. 修改shop-*各个模块存在的apollo-env.properties 指定分布式配置系统路径Url 
   2. 修改对应的环境连接consul 的负载均衡的host url 地址   
   
#### 注意：启动各个项目时请加上 例如<code>env=DEV</code> VM Options，根据环境修改不同的配置

## 部署平台管理系统
   前往[系统管理平台](https://github.com/SiGuiyang/vue-shop-admin.git)下载，下载之前请先安装node工具


## 前端模块
##### APP面向消费者 暂定（之前写过一个vue版本的，自我感觉不佳，已抛弃，目前想用flutter设计一套app）<br/>
##### 商家APP 暂未设计 待定 <br />
##### [系统管理平台](https://github.com/SiGuiyang/vue-shop-admin.git)
## 项目结构图
![Pager分布式电商项目](https://github.com/SiGuiyang/spring-cloud-shop/blob/master/images/pager_shop.jpg "Pager分布式电商项目")

#### 如有疑问，欢迎参与，如有更好的方案，可以邮件联系我本人**siguiyang1992@outlook.com**，谢谢！
