create table if not exists Restaurant(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    address VARCHAR(255),
    cuisinetype VARCHAR(255),
    rating INT
);

create table if not exists CHEF(
    id INT PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    expertise VARCHAR(255),
    experienceYears INT,
    restaurantId INT,
    FOREIGN KEY(restaurantId) REFERENCES Restaurant(id)
);