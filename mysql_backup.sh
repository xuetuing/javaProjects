#!/bin/sh
#set -x
#NOW_PATH=`pwd`
NOW_PATH="/D/JavaProject/OnlineInfo/sqlBackup"
echo "......start backup......"
typeset BACKUP_PATH=${NOW_PATH}"/sql"
typeset DATABASE="online_info_sys"
#typeset DATABASE1="online_info_sys1"
typeset MYSQL_PATH="/C/Program Files/MySQL/MySQL Server 5.6/bin"
typeset DB_HOST="127.0.0.1"
#typeset DB_USERNAME="root"
#typeset DB_PWD="root"
#备份的最大数目+1
typeset max_backup_num="16" 
typeset date=`date +%Y-%m-%d`

mkdir -p "${BACKUP_PATH}/${date}"

#cd "${MYSQL_PATH}"
#解决mysql在命令行输出的警告的问题，在mysql的配置文件my.ini中添加下面几行，就可以免密码使用mysqldump
#[mysqldump] 
#user=XXX
#password=XXX

#$( "${MYSQL_PATH}/mysqldump" --add-drop-table -h${DB_HOST} -u${DB_USERNAME} -p${DB_PWD} ${DATABASE} > "${BACKUP_PATH}/${date}/${DATABASE}.sql" )
$( "${MYSQL_PATH}/mysqldump" --add-drop-table -h${DB_HOST} ${DATABASE} > "${BACKUP_PATH}/${date}/${DATABASE}.sql" )
flag=`echo $?`
#$( "${MYSQL_PATH}/mysqldump" --add-drop-table -h${DB_HOST} ${DATABASE}1 > "${BACKUP_PATH}/${date}/${DATABASE}1.sql" )
#flag1=`echo $?`

#if [ ${flag} -eq 0 -a ${flag1} -eq 0 ]; then
if [ ${flag} -eq 0 ]; then
    echo "----备份数据库成功----"
    #real_num=`ls -l ${BACKUP_PATH} | wc -l`
    while [ `ls -l ${BACKUP_PATH} | wc -l` -gt ${max_backup_num} ]
    do
        delFile=`ls ${BACKUP_PATH} | awk '{print $1}'`
        echo "删除备份目录：${BACKUP_PATH}/${delFile}"
        rm -fr ${BACKUP_PATH}/${delFile}
        #real_num=`ls -l ${BACKUP_PATH} | wc -l`
    done
    
    #read -p "备份成功，按回车退出...."
    read -p "备份成功，按回车退出...." -t 3
else
    read -p "备份失败，请检查...."
fi
#rm -fr ${BACKUP_PATH}/temp



