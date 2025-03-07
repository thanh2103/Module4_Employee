use employee_manager;

CREATE TABLE department
(
    department_id   INT          NOT NULL,
    department_name VARCHAR(255) NULL,
    CONSTRAINT pk_department PRIMARY KEY (department_id)
);

CREATE TABLE employee
(
    id                       INT  auto_increment        NOT NULL,
    name                     VARCHAR(255) NULL,
    birthday                 date         NULL,
    gender                   VARCHAR(20)  NULL,
    salary                   DECIMAL      NULL,
    department_department_id INT          NULL,
    CONSTRAINT pk_employee PRIMARY KEY (id),
    foreign key (department_department_id) references department (department_id)
);


# SELECT e.* FROM employee e
#                     LEFT JOIN department d ON e.department_department_id= d.department_id
# WHERE (:name IS NULL OR e.name LIKE CONCAT('%',:name,'%'))
#   AND (:dob)




