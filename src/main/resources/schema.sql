create table course
(
    id         bigint generated by default as identity,
    title      varchar(255) not null,
    creator_id bigint       not null,
    created_at timestamp    not null,
    updated_at timestamp,
    primary key (id)
);

create table session
(
    id                     bigint generated by default as identity,
    session_name           varchar(255) not null,
    registration_count     bigint       not null,
    max_registration_count bigint,
    tuition_fee            bigint       not null,
    course_id              bigint       not null,
    progress_state         varchar(255) not null,
    recruitment_state      varchar(255) not null,
    fee_type               varchar(255) not null,
    start_date             timestamp    not null,
    end_date               timestamp    not null,
    created_at             timestamp    not null,
    updated_at             timestamp,
    primary key (id)
);

create table image
(
    id         bigint generated by default as identity,
    size       bigint      not null,
    type       varchar(10) not null,
    width      bigint      not null,
    height     bigint      not null,
    session_id bigint      not null,
    created_at timestamp   not null,
    updated_at timestamp,
    primary key (id)
);

create table student
(
    id             bigint generated by default as identity,
    name           varchar(20) not null,
    email          varchar(20) not null,
    approval_state varchar(20)  not null,
    student_type   varchar(50) not null,
    created_at     timestamp   not null,
    updated_at     timestamp,
    primary key (id)
);

create table ns_user
(
    id           bigint generated by default as identity,
    user_id      varchar(20) not null,
    password     varchar(20) not null,
    name         varchar(20) not null,
    email        varchar(50),
    money        varchar(50),
    student_type varchar(50),
    created_at   timestamp   not null,
    updated_at   timestamp,
    primary key (id)
);

create table question
(
    id         bigint generated by default as identity,
    created_at timestamp    not null,
    updated_at timestamp,
    contents   clob,
    deleted    boolean      not null,
    title      varchar(100) not null,
    writer_id  bigint,
    primary key (id)
);

create table answer
(
    id          bigint generated by default as identity,
    created_at  timestamp not null,
    updated_at  timestamp,
    contents    clob,
    deleted     boolean   not null,
    question_id bigint,
    writer_id   bigint,
    primary key (id)
);

create table delete_history
(
    id            bigint not null,
    content_id    bigint,
    content_type  varchar(255),
    created_date  timestamp,
    deleted_by_id bigint,
    primary key (id)
);
