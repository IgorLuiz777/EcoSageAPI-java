CREATE TABLE energy_usage (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    total_consumed_energy DECIMAL(19, 2),
    total_cost DECIMAL(19, 2),
    start_date DATE,
    end_date DATE,
    average_daily_consumption DECIMAL(19, 2)
);

INSERT INTO energy_usage (total_consumed_energy, total_cost, start_date, end_date, average_daily_consumption)
VALUES (120.50, 45.75, '2024-10-01', '2024-10-31', 3.89);

INSERT INTO energy_usage (total_consumed_energy, total_cost, start_date, end_date, average_daily_consumption)
VALUES (95.30, 35.60, '2024-09-01', '2024-09-30', 3.18);

INSERT INTO energy_usage (total_consumed_energy, total_cost, start_date, end_date, average_daily_consumption)
VALUES (110.00, 42.20, '2024-08-01', '2024-08-31', 3.55);

INSERT INTO energy_usage (total_consumed_energy, total_cost, start_date, end_date, average_daily_consumption)
VALUES (130.75, 50.90, '2024-07-01', '2024-07-31', 4.21);

INSERT INTO energy_usage (total_consumed_energy, total_cost, start_date, end_date, average_daily_consumption)
VALUES (150.00, 60.00, '2024-06-01', '2024-06-30', 5.00);
