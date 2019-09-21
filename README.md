# spring-cloud-shop
    spring cloud 版分布式电商项目，全力打造顶级多模块，高可用，高扩展电商项目。
    目前项目使用分库设计方案，不同的模块依赖不同的数据库实例
    营销模块: pager_activity 
    商品中心: pager_goods 
    订单中心: pager_order 
    数据中心: pager_shop 
    风控中心: pager-risk 
    授权中心: pager-auth
    分布式文件系统采用apollo方式实现
    分布式定时任务采用xxl-job方式实现
    后台登陆采用oauth2.0密码模式登陆或者授权码模式登陆
# 项目版本分支
 1. master分支 注册中心与配置中心已使用alibaba nacos
 2. consul分支 注册中心使用consul，配置中心使用 [apollo](https://github.com/Siguiyang/spring-cloud-shop/blob/master/README-apollo.md)。

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
