## 需求说明

- 需求标题：高并发情况下简单秒杀系统设计

- 需求内容：
  - 在高并发场景下，单一热点消息需求极具上升，此时若要保证服务器数据正常以及系统负载的稳定性，需采取Redis缓存将单一热点信息缓存出来。
  - 借助Lua脚本的原子性执行，保证Redis操作不会被其他线程抢占。
  - 当Redis完成商品数量削减后，及时同步更新Mysql的库存信息以及订单记录信息。
  - 模拟不采用Redis的情况下，仅靠CAS操作是否能保证服务的高响应。

## 代码位置

- 代码在：\src\main\java\com\gildata\xiza\demo下

  <img src="C:\Users\XIZA\AppData\Roaming\Typora\typora-user-images\image-20210310085209337.png" alt="image-20210310085209337" style="zoom: 80%;" />

## 程序主入口

- 入口位置为：\src\main\java\com\gildata\xiza\demo\main\DemoApplication.java

  ![image-20210310085258026](C:\Users\XIZA\AppData\Roaming\Typora\typora-user-images\image-20210310085258026.png)