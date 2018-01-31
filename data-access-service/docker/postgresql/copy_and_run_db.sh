#!/usr/bin/env bash

echo "Start running"
ls -l
pwd

cp -rf /tmp/pgdata pgdata

chmod -R 700 pgdata

chown -R postgres pgdata

sudo -H -u postgres bash -c '/usr/lib/postgresql/9.3/bin/postgres -D pgdata'