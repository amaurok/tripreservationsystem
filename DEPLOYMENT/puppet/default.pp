Exec { path => [ "/bin/", "/sbin/" , "/usr/bin/", "/usr/sbin/" ] }

class { '::mysql::server':
  root_password           => 'root'
}


mysql::db { 'customers':
  user     => 'root',
  password => 'root',
  host     => '192.168.33.10',
  sql     => '/scripts/script.sql'
}

class {'::mongodb::server':
  port    => 27017,
  verbose => true,
}

