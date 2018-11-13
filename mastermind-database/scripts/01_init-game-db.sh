#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE USER maldanam PASSWORD 'ThePassword';
    CREATE DATABASE games;
    GRANT ALL PRIVILEGES ON DATABASE games TO maldanam;
EOSQL
