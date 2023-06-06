create database db;
use db;

create table course
(
    cno          varchar(20)   not null
        primary key,
    cname        varchar(20)   not null,
    status       int           null,
    dept         varchar(20)   null,
    pcno         varchar(20)   null,
    introduction varchar(1000) null,
    settno       varchar(20)   null
);

create table course_runtime
(
    semester  varchar(20) not null,
    cno       varchar(20) not null,
    runday    int         not null,
    begintime int         not null,
    endtime   int         not null,
    primary key (cno, semester, runday, begintime, endtime)
);

create table course_semester
(
    cno       varchar(20)  not null,
    semester  varchar(20)  not null,
    tno       varchar(20)  not null,
    weekbegin int          null,
    weekend   int          null,
    capacity  int          null,
    location  varchar(255) null,
    status    int          null,
    primary key (cno, semester)
);

create table message
(
    id       int auto_increment
        primary key,
    sno      varchar(20)   null,
    content  varchar(1000) null,
    sendtime datetime      null,
    status   int           null,
    title    varchar(255)  null
);

create table notice
(
    id       int auto_increment
        primary key,
    sendtime datetime      null,
    content  varchar(3000) null,
    title    varchar(255)  null
);

create table select_list
(
    major    varchar(30)  not null,
    semester varchar(20)  not null,
    cno      varchar(500) not null,
    status   varchar(10)  not null,
    primary key (semester, major)
);

create table semester
(
    beginyear varchar(20) not null,
    endyear   int         not null,
    number    varchar(20) not null,
    primary key (beginyear, endyear, number)
);

create table student
(
    sno             varchar(20) not null
        primary key,
    sname           varchar(20) null,
    college         varchar(20) null,
    sex             varchar(10) null,
    major           varchar(20) null,
    klass           varchar(20) null,
    province        varchar(20) null,
    city            varchar(30) null,
    birthday        varchar(30) null,
    phone           varchar(20) null,
    qq              varchar(20) null,
    wechat          varchar(20) null,
    email           varchar(40) null,
    politicalstatus varchar(20) null,
    nation          varchar(20) null,
    highschool      varchar(20) null,
    foreignlanguage varchar(20) null,
    status          varchar(20) null
);

create table study_course
(
    sno      varchar(20) not null,
    semester varchar(20) not null,
    cno      varchar(20) not null,
    grade    int         null,
    primary key (sno, cno, semester)
);

create table teacher
(
    tno            varchar(20) not null
        primary key,
    tname          varchar(20) null,
    tdept          varchar(20) null,
    `rank`         varchar(20) null,
    phone          varchar(11) null,
    location       varchar(50) null,
    sex            varchar(20) null,
    province       varchar(30) null,
    city           varchar(30) null,
    comeyear       varchar(10) null,
    qq             varchar(20) null,
    wechat         varchar(20) null,
    email          varchar(40) null,
    graduateschool varchar(40) null,
    degree         varchar(20) null,
    direction      varchar(50) null
);

create table user
(
    account  varchar(20) not null,
    type     varchar(20) not null,
    password varchar(32) not null,
    primary key (account, type)
);


