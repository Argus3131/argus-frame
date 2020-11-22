==================================old 1:
#!/bin/bash
echo "stop chrome start"

project=$1
echo $project
PID=$( ps -ef|grep chrome |grep ${project}  |awk '{print $2}')
echo $PID

if [ "$PID" == "" ];then
   echo "process id empty"
else
   echo "process is:$PID"
   kill ${PID}
   PIDNEW=$( ps -ef|grep chrome | grep ${project}  |awk '{print $2}')
   if [ "$PIDNEW" == "" ];then
        echo "kill chrome successed"
   fi
fi

==================================old 2:
#!/bin/bash
echo "stop chrome start"

project=$1
echo $project
PID=$( ps -ef|grep chrome|grep -E  `ps -ef|grep chrome |grep $project |grep -v 'grep' |awk '{printf("%d|", $2)}' |awk '{print(substr($1,0,length-1))}'`|grep -v 'grep' |awk '{print $2}')
echo $PID

if [ "$PID" == "" ];then
   echo "process id empty"
else
   echo "process is:$PID"
   kill ${PID}
   PIDNEW=$( ps -ef|grep chrome | grep ${project} |awk '{print $2}')
   if [ "$PIDNEW" == "" ];then
        echo "kill chrome successed"
   fi
fi




==================================最新：
#!/bin/bash
echo "stop chrome start"

project=$1
echo $project
PID=$( ps -ef|grep chrome |grep $project |grep -v 'grep' |awk '{printf("%d|", $2)}' |awk '{print(substr($1,0,length))}')
echo $PID

if [ "$PID" == "" ];then
    echo "process id empty"
else
    PID2=$( ps -ef|grep chrome|grep -E  `ps -ef|grep chrome |grep $project |grep -v 'grep' |awk '{printf("%d|", $2)}' |awk '{print(substr($1,0,length-1))}'`|grep -v 'grep' |awk '{print $2}')
    echo $PID2
    if [ "$PID2" == "" ];then
       echo "Level2pid id empty"
    else
       echo "Level2pid is:$PID2"
       kill ${PID2}
       PID2NEW=$( ps -ef|grep chrome | grep ${project} |awk '{print $2}')
       if [ "$PID2NEW" == "" ];then
            echo "kill Level2pid successed"
       fi
    fi


fi




=======================================================

