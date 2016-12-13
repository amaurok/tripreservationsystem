# -*- mode: ruby -*-
# vi: set ft=ruby :

# All Vagrant configuration is done below. The "2" in Vagrant.configure
# configures the configuration version (we support older styles for
# backwards compatibility). Please don't change it unless you know what
# you're doing.
Vagrant.configure(2) do |config|

  config.vm.box = "bento/ubuntu-14.04"

  #Configure the amount of vcpus and memory for the virtualbox machine.
  config.vm.provider "virtualbox" do |vb|
  
     # Customize the amount of memory on the VM:
     vb.memory = "1024"

     vb.cpus = 2

  end
  
  # Configure the private network.
  config.vm.network "private_network", ip: "192.168.33.10"

  # Forward port, and correct a possible port collision
  config.vm.network "forwarded_port", guest: 80, host: 8081, auto_correct: true

  # Configure synced folder
  config.vm.synced_folder "CODE/", "/tripSystem"
  config.vm.synced_folder "SQL/", "/scripts"

 
  config.vm.provision "shell", path: "DEPLOYMENT/provision.sh"

  config.vm.provision "puppet" do |puppet|
    puppet.manifests_path = "DEPLOYMENT/puppet"
    puppet.manifest_file = "default.pp"
    puppet.hiera_config_path = "DEPLOYMENT/hiera.yaml"
    puppet.module_path = "DEPLOYMENT/puppet/modules"
  end

  config.vm.provision "shell", path: "DEPLOYMENT/deploy.sh"

end
