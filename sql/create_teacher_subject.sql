create table teacher_subject (
    id serial not null primary key,
    teacher_id int not null,
    subject_id int not null,
    foreign key (teacher_id) references teacher(id),
    foreign key (subject_id) references subject(id)
);