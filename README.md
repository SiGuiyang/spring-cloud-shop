# spring-cloud-shop
    spring cloud 版分布式电商项目，全力打造顶级多模块，高可用，高扩展电商项目。
    目前项目使用分库设计方案，不同的模块依赖不同的数据库实例
    营销中心: pager_activity
    授权中心: pager-auth
    商品中心: pager_goods 
    订单中心: pager_order 
    数据中心: pager_shop 
    风控中心: pager-risk 
    后台登陆采用oauth2.0授权，支持密码登陆，授权码登陆，短信验证码登陆
    注册中心与配置中心已使用alibaba nacos
# 最近在深度学习ELK，项目更新会迟缓，月底将会集成ELK相关功能，尽情期待！    
# 在线demo地址 [Spring Cloud Shop](http://106.54.251.32) 服务器到期，暂不提供
# 脚本升级
```
    自2020年02月07日起，spring-cloud-shop项目提供脚本升级方案，基础脚本存放在doc/base目录中，升级脚本存放在doc/upgrade中。
```
# 目前开发小结
    1. spring cloud alibaba 版本已经升级到最新版本2.2.1，nacos 1.3.2，seata 1.3.0， Spring boot 2.2.9，Spring cloud 2.2.2。
    2. spring-cloud-shop 即将迎来最终的版块（完结），将于2020年底全部开源（只用常见的商品->购物->下单->优惠->结算）流程，
       其它扩展辅助流程将不再研发（小伙伴们可以自行扩展）。
    3. 技术栈即将毕业，唯一的缺陷就是MQ的选择，开发过程中选择了rabbitMq以及Kafka，现在已经将MQ代码全部移除（移除原因暂时不公开）。
    4. 后期主要是将各个模块串联一起，项目更新就会比较延缓，最终版将会包含目前所有主流的技术栈以及相关的解决方案。
    

# 设计初衷
    设计此项目是为了进一步学习Spring Cloud 技术栈。从项目实战深入Spring Cloud 各个微服务的解决方案。因此采用最常见的电商业务作为
    练手项目。
# 项目部署简介
    1. 搭建各个服务的数据库服务，sql在doc文件中，请使用base里的全量脚本
    2. 搭建nacos 注册中心服务，可集群部署
    3. 搭建seata 分布式事务管理服务
    4. 搭建redis 中间件缓存服务，可集群部署
    5. 搭建rabbitMq 中间件队列服务（暂放，消息队列已经全部移除了）
    7. 搭建shop-* 项目，可多实例部署
    8. 安装node工具，将vue-shop-admin后台管理服务打包部署，并使用nginx做反向代理，转发到服务网关层  
## 详细部署文档请移步Wiki 项目部署模块

## 部署平台管理系统
   前往[系统管理平台](https://github.com/SiGuiyang/vue-shop-admin.git)下载，下载之前请先安装node工具


## 前端模块
##### APP面向消费者 暂定（之前写过一个vue版本的，自我感觉不佳，已抛弃，目前想用flutter设计一套app）<br/>
##### 商家APP 暂未设计 待定 <br />
##### [系统管理平台](https://github.com/SiGuiyang/vue-shop-admin.git)
## 项目结构图
![Pager分布式电商项目](https://github.com/SiGuiyang/spring-cloud-shop/blob/master/images/pager_shop.jpg "Pager分布式电商项目")

## 项目截图
![登陆](https://github.com/SiGuiyang/spring-cloud-shop/blob/master/images/login.png "Pager分布式电商项目")
![首页](https://github.com/SiGuiyang/spring-cloud-shop/blob/master/images/home.png "Pager分布式电商项目")
![优惠券](https://github.com/SiGuiyang/spring-cloud-shop/blob/master/images/coupon.png "Pager分布式电商项目")
![用户](https://github.com/SiGuiyang/spring-cloud-shop/blob/master/images/user.png "Pager分布式电商项目")
![角色](https://github.com/SiGuiyang/spring-cloud-shop/blob/master/images/role.png "Pager分布式电商项目")
![菜单](https://github.com/SiGuiyang/spring-cloud-shop/blob/master/images/menu.png "Pager分布式电商项目")
![菜单](https://github.com/SiGuiyang/spring-cloud-shop/blob/master/images/nacos-1.png "Pager分布式电商项目")
![菜单](https://github.com/SiGuiyang/spring-cloud-shop/blob/master/images/nacos-2.png "Pager分布式电商项目")

#### 如有疑问，欢迎参与，如有更好的方案，可以邮件联系我本人**siguiyang1992@outlook.com**，谢谢！
