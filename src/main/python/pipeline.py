#!/usr/bin/python
from subprocess import *
import time
import requests
import json

def trigger_update(count, timestamp):
    print(count,timestamp)
    response = requests.post(url="http://192.168.0.10:8080/person-stat/update",
    data=json.dumps({"eid":"RaspPi001","count":count,"time":timestamp}),
    headers={"content-type": "application/json"})

# Subprocess management,可以做很多子进程的文件，我们要引入这个文件
p = Popen(["tail", "-f", "/tmp/output.txt"], bufsize=1024,stdin=PIPE, stdout=PIPE, close_fds=False)
# 打开程序第一个参数是一个列表（程序名称，参数)
# 第二个参数是缓冲区大小
# stdin,stdout是设置是否打开这些管道，如果他的值是subprocess.PIPE的话，
# 就会打开,同stdin一样的还有stderr
# close_fds设置为true(unix-only)所有的文件描述符除了（0，1，2）在子程序执行前都会关闭
(fin, fout) = (p.stdin, p.stdout)
count = 0
last_update_time = 0
while(1):
  now = int(round(time.time())*1000)
  str_line = bytes.decode(fout.readline())
  if str_line.startswith("detection") and str_line.find("detect object: person:")!=-1:
    count = count+1
  if str_line.startswith("iter"):
    if now-last_update_time >= 5000:
        trigger_update(count,now)
        last_update_time = now
    count = 0
  if now - last_update_time >= 10000 and count == 0:
    trigger_update(count,now)
    last_update_time = now