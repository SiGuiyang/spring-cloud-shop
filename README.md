# spring-cloud-shop
    spring cloud 版分布式电商项目，全力打造顶级多模块，高可用，高扩展电商项目。
    项目使用分库设计方案，不同的模块依赖不同的数据库实例pager_activity，pager_goods，pager_order，pager_shop。
# 设计初衷
    设计此项目是为了进一步学习Spring Cloud 技术栈。从项目实战深入Spring Cloud 各个微服务的解决方案，
    第一版本设计比较单一，并没有太多Spring Cloud 的精髓，只是简单的使用了eureka，zuul，feign，config，hystrix几个解决方案。
    本人计划将在第二个版本深入到Spring Cloud 的各个微服务阶段。 
## 项目启动部署
1. 启动 shop-config 模块，分布式文件配置中心（可选）
2. 启动 shop-server 模块，注册中心，集群部署
3. 启动 shop-zuul 模块，服务网关，集群部署
4. 启动 shop-user 模块，用户与商户中心服务 
5. 启动 shop-goods 模块，商品中心服务
6. 启动 shop-activity 模块，活动中心服务
7. 启动 shop-order 模块，订单中心服务
8. 启动 shop-settlement 模块，清结算服务
9. 启动 shop-manage 模块，[系统管理平台](https://github.com/SiGuiyang/vue-shop-admin.git)

#### 注意：shop-manage 依赖于各个模块，每一个功能可能会依赖多个模块，如果项体验更好，最后将所有服务都启动
## 前端模块
[APP面向消费者](https://github.com/SiGuiyang/vue-cloud-shop.git) 已完成基本功能，但未对接服务接口<br />
商家APP 暂未设计 待定 <br />
[系统管理平台](https://github.com/SiGuiyang/vue-shop-admin.git)
## 项目功能点介绍
![Pager分布式电商项目](http://pk6b0a7n8.bkt.clouddn.com/Pager_Shop.png "Pager分布式电商项目")

#### 注意：第二个阶段将加入分布式事务解决方案采用 [tx-lcn spring cloud 版本](https://github.com/codingapi/tx-lcn.git)
#### 如有疑问，欢迎参与，如有更好的方案，可以邮件联系我本人**siguiyang1992@outlook.com**，谢谢！