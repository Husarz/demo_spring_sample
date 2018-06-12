#!/usr/bin/env bash
# vim:set ft=dockerfile:
FROM postgres:10
ENV PG_VERSION 10

#ARG PG_AMQP_BRIDGE_VERSION="0.0.6"

#ENV POSTGRESQL_URI="postgres://postgres@postgresql"
#ENV AMQP_URI="amqp://rabbitmq//"
#ENV BRIDGE_CHANNELS="events:amq.topic"

RUN  apt-get -qq update && \
     -qq install -y --no-install-recommends build-essential \
     $BUILD_DEPS \
     libxslt1-dev \
     libxml2-dev \
     python-dev \
     python-pip \
     postgresql-server-dev-$PG_VERSION \
     libpq-dev postgresql-server-dev-10 && \
    apt-get clean && \
    pip install pgxnclient && \
    pgxn install multicorn==$MULTICORN_VERSION && \
    pip install lxml
     apt-get -qq purge --auto-remove -y $BUILD_DEPS && \
     apt-get -qq clean && \
     rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

#RUN mkdir -p /var/plugins \
#       && cd /var/plugins \
#       && wget https://github.com/omniti-labs/pg_amqp/archive/v0.4.1.tar.gz -O pg_amqp-0.4.1.tar.gz \
#       && tar -zxvf pg_amqp-0.4.1.tar.gz \
#       && cd /var/plugins/pg_amqp-0.4.1 \
#       && make \
#       && make install \
#       && echo "shared_preload_libraries = 'pg_amqp.so'" >> /var/lib/postgresql/data/postgresql.conf

RUN mkdir -p /docker-entrypoint-initdb.d
COPY initdb /docker-entrypoint-initdb.d

CMD exec pg-amqp-bridg
