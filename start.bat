@echo off
set path=.;C:\Program Files\Java\jdk1.7.0_67\bin
set cp=
for %%i in ("lib\*.jar") do call setenv.bat %%i
set classpath=%cp%;.;.\bin;;
title ¼à¿Ø³ÌÐò
java -XX:MaxDirectMemorySize=1024m ty.cloud.mq.consumer.Start
puase