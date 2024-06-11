# Docker镜像构建
# @author <a href="https://gitee.com/wen-jun-zhuYU/liushui_-blog">liushui_-blog</a>
# @from <a href="https://gitee.com/wen-jun-zhuYU/liushui_-blog">liushui_-blog</a>
# 选择基础镜像
FROM maven:3.6.3-jdk-8-slim AS build

#解决容器时期与宿主机时间不一致问题 相差8小时
RUN ln -snf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo Asia/Shanghai > /etc/timezone

#复制代码到容器内
WORKDIR /app
COPY liushui-common/pom.xml .
COPY liushui-common/src ./src

# 打包进度
RUN mvn package -DskipTests=true

# 容器启动时运行jar包
CMD["java","-jar","./target/liushui-blog.jar","--spring.profiles.active=prod"]