#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    \connect games;

    create table game (
        id int4 not null,
        max_turns int4 not null,
        status varchar(255) not null,
        pattern_id int4,

        primary key (id)
    );
    grant select, insert, update, delete on game to maldanam;

    create table pattern (
        id int4 not null,
        color1 varchar(255) not null,
        color2 varchar(255) not null,
        color3 varchar(255) not null,
        color4 varchar(255) not null,
        game_id int4,

        primary key (id)
    );
    grant select, insert, update, delete on pattern to maldanam;

    ALTER TABLE game
      ADD CONSTRAINT game_pattern_fk foreign key (pattern_id) references pattern(id);
    ALTER TABLE pattern
      ADD CONSTRAINT pattern_game_fk foreign key (game_id) references game(id);

    create table turn (
        id int4 not null,
        game_id int4,
        guess_id int4,
        result_id int4,

        primary key (id),
        foreign key (game_id) references game(id)
    );
    grant select, insert, update, delete on turn to maldanam;

    create table guess (
        id int4 not null,
        color1 varchar(255) not null,
        color2 varchar(255) not null,
        color3 varchar(255) not null,
        color4 varchar(255) not null,
        turn_id int4,

        primary key (id)
    );
    grant select, insert, update, delete on guess to maldanam;

    ALTER TABLE guess
      ADD CONSTRAINT guess_turn_fk foreign key (turn_id) references turn(id);

    create table guess_result (
        id int4 not null,
        num_blacks int4 not null,
        num_whites int4 not null,
        turn_id int4,

        primary key (id)
    );
    grant select, insert, update, delete on guess_result to maldanam;

    ALTER TABLE guess_result
      ADD CONSTRAINT guess_result_turn_fk foreign key (turn_id) references turn(id);

    ALTER TABLE turn
      ADD CONSTRAINT turn_guess_fk foreign key (guess_id) references guess(id);
    ALTER TABLE turn
      ADD CONSTRAINT turn_guess_result_fk foreign key (result_id) references guess_result(id);

EOSQL
