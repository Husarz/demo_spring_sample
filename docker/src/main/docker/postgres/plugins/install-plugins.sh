#!/usr/bin/env bash

#cd /docker-entrypoint-initdb.d/
#wget https://github.com/omniti-labs/pg_amqp/archive/v0.4.1.tar.gz -O pg_amqp-0.4.1.tar.gz
#tar -zxvf pg_amqp-0.4.1.tar.gz #pg_amqp-0.4.1 /docker-entrypoint-initdb.d/pg_amqp-0.4.1
#pwd
#tar -zxvf /docker-entrypoint-initdb.d/pg_amqp-0.4.1.tar.gz pg_amqp-0.4.1 /docker-entrypoint-initdb.d/pg_amqp-0.4.1
cd /var/plugins/pg_amqp-0.4.1
##ls
make
make install
echo "shared_preload_libraries = 'pg_amqp.so'" >> /var/lib/postgresql/data/postgresql.conf


