variable "flavor" { default = "m1.large" }
variable "image" { default = "Rocky Linux 9 20220830" }

variable "name" { default = "JenkinsServer" }

variable "network" { default = "default" }   # you need to change this

variable "keypair" { default = "aw_keypair" } # you need to change this
variable "pool" { default = "cscloud_private_floating" }
variable "server_script" { default = "./serverJenkins.sh" }
variable "security_description" { default = "Terraform security group" }
variable "security_name" { default = "tmptf_security" }
