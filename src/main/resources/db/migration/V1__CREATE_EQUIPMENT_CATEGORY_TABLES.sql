CREATE TABLE equipment_category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255)
);

CREATE TABLE wanted_energy_usage (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     total_energy DECIMAL(19, 2) NOT NULL,
                                     total_cost DECIMAL(19, 2) NOT NULL,
                                     start_date DATE NOT NULL,
                                     end_date DATE NOT NULL,
                                     average_daily_consumption DECIMAL(19, 2)
);

CREATE TABLE equipment (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           power DECIMAL(19, 2) NOT NULL,
                           average_usage_per_day INT NOT NULL,
                           equipment_category_id BIGINT NOT NULL,
                           wanted_energy_usage_id BIGINT NOT NULL,
                           personal_note VARCHAR(255),
                           status BOOLEAN NOT NULL DEFAULT TRUE,
                           CONSTRAINT fk_equipment_category
                               FOREIGN KEY (equipment_category_id)
                                   REFERENCES equipment_category(id),
                           CONSTRAINT fk_wanted_energy_usage
                               FOREIGN KEY (wanted_energy_usage_id)
                                   REFERENCES wanted_energy_usage(id)
);

