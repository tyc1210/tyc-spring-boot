# springboot 项目开发脚手架

## 模块介绍
| 模块名称                 | 描述                                 |
|-------------------------|--------------------------------------|
| tyc-dependencies      | 使用Maven BOM管理依赖版本    |
| tyc-framework         | Java 框架拓展                         |
| tyc-module-demo         | 模块测试（具体业务模块）          |
| tyc-server     |      启动（空壳，负责引起其它模块）          |

关于依赖管理相关资料
- [企业级依赖管理: 深入解读 Maven BOM](https://zhuanlan.zhihu.com/p/678450026)
- [aliyun-spring-boot](https://github.com/alibaba/aliyun-spring-boot)

tyc-framework
- 封装通用工具：异常、通用类、工具类等
- 封装各种 starter
注意封装 starter 时合理划分，避免 starter 过多启动较慢

module-xxx
每个 module 模块推荐拆分为 API 与业务模块，好处如下：
- 方便向微服务拆分
- 有效防止 maven 循环引用 

## 一键改包
 在 tyc-server 项目下找到 ProjectReactor 修改配置即可

