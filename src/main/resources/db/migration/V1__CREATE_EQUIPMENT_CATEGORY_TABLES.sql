CREATE TABLE equipment_category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255)
);

CREATE TABLE equipment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    power DECIMAL(19, 2),
    average_usage_per_day INT,
    equipment_category_id BIGINT,
    personal_note VARCHAR(255),
    status BOOLEAN,
    CONSTRAINT fk_equipment_category
        FOREIGN KEY (equipment_category_id)
            REFERENCES equipment_category(id)
);

INSERT INTO equipment_category (name, description) VALUES ('Electronics', 'Electronic devices and gadgets');
INSERT INTO equipment_category (name, description) VALUES ('Appliances', 'Household appliances');
INSERT INTO equipment_category (name, description) VALUES ('Industrial', 'Heavy industrial equipment');

INSERT INTO equipment (name, power, average_usage_per_day, equipment_category_id, personal_note, status)
VALUES ('Laptop', 65.00, 8, 1, 'For office work', true);

INSERT INTO equipment (name, power, average_usage_per_day, equipment_category_id, personal_note, status)
VALUES ('Smartphone', 5.00, 12, 1, 'Personal use', true);

INSERT INTO equipment (name, power, average_usage_per_day, equipment_category_id, personal_note, status)
VALUES ('Refrigerator', 150.00, 24, 2, 'Kitchen appliance', true);

INSERT INTO equipment (name, power, average_usage_per_day, equipment_category_id, personal_note, status)
VALUES ('Microwave', 1200.00, 1, 2, 'Quick heating', false);

INSERT INTO equipment (name, power, average_usage_per_day, equipment_category_id, personal_note, status)
VALUES ('Drill Press', 500.00, 5, 3, 'For manufacturing', true);

INSERT INTO equipment (name, power, average_usage_per_day, equipment_category_id, personal_note, status)
VALUES ('Welding Machine', 2500.00, 3, 3, 'For metal works', true);
