# spring-cloud-shop
    spring cloud 版分布式电商项目，全力打造顶级多模块，高可用，高扩展电商项目。
    目前项目使用分库设计方案，不同的模块依赖不同的数据库实例
    营销模块: pager_activity 
    商品中心: pager_goods 
    订单中心: pager_order 
    数据中心: pager_shop 
    风控中心: pager-risk 
    授权中心: pager-auth
    分布式定时任务采用xxl-job方式实现
    后台登陆采用oauth2.0授权，支持密码登陆，授权码登陆，短信验证码登陆
    注册中心与配置中心已使用alibaba nacos
# 在线demo地址 [Spring Cloud Shop](http://106.54.251.32) 每周休息日停止在线服务，周一恢复
    1. 仅提供访问，预览
    2. 不提供新增编辑功能
# 脚本升级
```
    自2020年02月07日起，spring-cloud-shop项目提供脚本升级方案，基础脚本存放在doc/base目录中，升级脚本存放在doc/upgrade中。
```
# 目前开发计划
    1. 为了提高前端的开发效率，目前正在开发自定义表单系统，大约会在12月中旬开发完成
    2. 2019年初提供在线体验Demo
    3. 2019年春节过后将会把商品体系与订单体系完成
    4. 商品体系与订单体系完成后，将会与营销活动集成，打通整体电商平台
    5. docker 版本将会在2019年初集成
    6. Spring Cloud 分布式定时任务调度项目（正在开发中）

# 设计初衷
    设计此项目是为了进一步学习Spring Cloud 技术栈。从项目实战深入Spring Cloud 各个微服务的解决方案。因此采用最常见的电商业务作为
    练手项目。
# 项目部署
    1. 搭建各个服务的数据库服务，sql在doc文件中
    2. 搭建nacos 注册中心服务，可集群部署
    3. 搭建redis 中间件缓存服务，可集群部署
    4. 搭建rabbitMq 中间件队列服务
    5. 搭建seata 分布式事务管理服务
    6. 搭建xxl-job-admin 分布式定时任务管理平台，可集群搭建
    7. 搭建shop-* 项目，可多实例部署
    8. 安装node工具，将vue-shop-admin后台管理服务打包部署，并使用nginx做反向代理，转发到服务网关层
   
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

#### 如有疑问，欢迎参与，如有更好的方案，可以邮件联系我本人**siguiyang1992@outlook.com**，谢谢！
