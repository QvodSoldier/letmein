#!/bin/bash
IP="192.168.10.11 192.168.10.12 192.168.10.21 192.168.10.22 192.168.10.23 192.168.10.24 192.168.10.25 192.168.10.31 192.168.10.32 192.168.10.33 192.168.10.34 192.168.10.41 192.168.10.42 192.168.10.51 192.168.10.52"
function sshkeygen {
	expect -c "
	spawn ssh-keygen;
	expect {
	"\):" { send "\\r"; exp_continue; }
	"\):" { send "\\r"; exp_continue; }
	"again:" { send "\\r"; exp_continue; }
	};
	expect eof;
	"
}
function sshcopyid {
	expect -c "
	spawn ssh-copy-id $1;
	expect {
	"yes/no" { send "yes\\r"; exp_continue; }
	"password:" { send "3\\r"; exp_continue; }	
	};
	expect eof;
	"
}
#/etc/hosts
echo -e "192.168.10.11 a1\n 192.168.10.12 a2\n 192.168.10.21 b1\n 192.168.10.22 b2\n 192.168.10.23 b3\n 192.168.10.24 b4\n 192.168.10.25 b5\n 192.168.10.31 c1\n 192.168.10.32 c2\n 192.168.10.33 c3\n 192.168.10.34 c4\n 192.168.10.41 d1\n 192.168.10.42 d2\n 192.168.10.51 e1\n 192.168.10.52 e2\n 192.168.10.60 f1" >> /etc/hosts
#/etc/chrony.conf
cp /etc/chrony.conf /etc/chrony-1.conf
sed -i -e 's/^#local/local/' -e 's/^#allow/allow/' -e 's/^server/#server/' /etc/chrony.conf
sed -i -e '4,6d' -e 's/0.centos.pool.ntp.org/192.168.10.60/' /etc/chrony-1.conf
systemctl restart chronyd
#-----------------------------------------
sshkeygen
for ip in $IP
do
	sshcopyid $ip
        scp /etc/hosts $ip:/etc/hosts
	scp /etc/chrony-1.conf $ip:/etc/chrony.conf
	ssh $ip systemctl restart chronyd
done
