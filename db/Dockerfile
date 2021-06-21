FROM mysql:8.0.21

MAINTAINER wuph(1131960938@qq.com)

ENV TZ=Asia/Shanghai

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY magichand_sys.sql /docker-entrypoint-initdb.d

COPY ./nacos_config.sql /docker-entrypoint-initdb.d

