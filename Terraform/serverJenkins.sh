#!/usr/bin/bash

echo "update logging configuration..."
sudo sh -c "echo '*.info;mail.none;authpriv.none;cron.none /dev/ttyS0' >> /etc/rsyslog.conf"
sudo systemctl restart rsyslog


cd /home/rocky
echo in directory $PWD

echo "installing MariaDB..."
# sudo yum install mysql -y
sudo dnf install mariadb-server -y
sudo systemctl start mariadb
sudo systemctl status mariadb
sudo systemctl enable mariadb


echo "creating mysql_secure_installation.txt..."
touch mysql_secure_installation.txt
cat << `EOF` >> mysql_secure_installation.txt

n
Y
comsc
comsc
Y
Y
Y
Y
Y
`EOF`

echo "running mysql_secure_installation..."
sudo mysql_secure_installation < mysql_secure_installation.txt

sudo yum install wget -y
sudo yum install unzip -y
sudo yum install git -y

echo "Installing Java 17..."
sudo yum install java-17-openjdk-devel -y
echo java --version

echo "needs to be in root account"
cd root

touch .ssh/known_hosts
ssh-keyscan git.cardiff.ac.uk >> .ssh/known_hosts
chmod 644 .ssh/known_hosts

echo "now needs to be in rocky user directory"
cd /home/rocky
cat << `EOF` >> vm_test.key
-----BEGIN OPENSSH PRIVATE KEY-----
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
-----END OPENSSH PRIVATE KEY-----
`EOF`
chmod 400 vm_test.key
ssh-agent bash -c 'ssh-add vm_test.key; git clone git@git.cardiff.ac.uk:c23087264/clientproject.git'

echo "install Jenkins"
# https://pkg.jenkins.io/redhat-stable/
curl --silent --location http://pkg.jenkins-ci.org/redhat-stable/jenkins.repo | sudo tee /etc/yum.repos.d/jenkins.repo
sudo rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io.key
sudo rpm --import https://pkg.jenkins.io/redhat/jenkins.io-2023.key
sudo dnf install https://dl.fedoraproject.org/pub/epel/epel-release-latest-8.noarch.rpm -y
sudo yum install jenkins -y

echo "installing gitlab server key... has to be added to the jenkins user home (~) dir "
mkdir /var/lib/jenkins/.ssh
sudo touch /var/lib/jenkins/.ssh/known_hosts
sudo ssh-keyscan git.cardiff.ac.uk >> /var/lib/jenkins/.ssh/known_hosts
sudo chmod 644 /var/lib/jenkins/.ssh/known_hosts


# If you want jenkins on port 8081 so you can run your app on 8080 then change the default jenkins port.
#(look up linux sed - it is really cool)
# sudo sed -i 's/JENKINS_PORT="8080"/JENKINS_PORT="8081"/g' /etc/sysconfig/jenkins
sudo systemctl start jenkins
systemctl status jenkins
sudo systemctl enable jenkins


echo "Installing gradle..."
# wget https://services.gradle.org/distributions/gradle-6.7.1-bin.zip
wget https://services.gradle.org/distributions/gradle-7.6-bin.zip
sudo mkdir /opt/gradle
# sudo unzip -d /opt/gradle gradle-6.7.1-bin.zip
# export PATH=$PATH:/opt/gradle/gradle-6.7.1/bin
sudo unzip -d /opt/gradle gradle-7.6-bin.zip
export PATH=$PATH:/opt/gradle/gradle-7.6/bin
echo gradle -v

echo "Installing terraform..."
cd /home/rocky
wget https://releases.hashicorp.com/terraform/1.1.5/terraform_1.1.5_linux_amd64.zip
unzip terraform_1.1.5_linux_amd64.zip
sudo mv terraform /usr/local/bin/
