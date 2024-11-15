-- Inserindo categorias de equipamentos
INSERT INTO equipment_category (name, description) VALUES
                                                       ('Ar Condicionado', 'Equipamentos de ar condicionado para resfriamento e aquecimento de ambientes'),
                                                       ('Iluminação', 'Equipamentos de iluminação, como lâmpadas LED e lâmpadas fluorescentes'),
                                                       ('Eletrodomésticos', 'Equipamentos diversos para uso doméstico, como fogões e geladeiras');

-- Inserindo dados de consumo de energia desejado
INSERT INTO wanted_energy_usage (total_energy, total_cost, start_date, end_date, average_daily_consumption) VALUES
                                                                                                                (750.25, 300.50, '2024-05-01', '2024-05-31', 24.5),
                                                                                                                (950.00, 380.00, '2024-06-01', '2024-06-30', 30.0),
                                                                                                                (620.75, 250.00, '2024-07-01', '2024-07-31', 20.0);

-- Inserindo equipamentos com suas respectivas categorias e uso de energia
-- Supondo que os IDs gerados para equipment_category sejam 1, 2, 3 e para wanted_energy_usage sejam 1, 2, 3
INSERT INTO equipment (name, power, average_usage_per_day, equipment_category_id, wanted_energy_usage_id, personal_note, status) VALUES
                                                                                                                                     ('Ar Condicionado Split', 1800.00, 8, 1, 1, 'Ar condicionado de 18000 BTUs, ideal para ambientes de até 30m²', TRUE),
                                                                                                                                     ('Lâmpada LED', 15.00, 12, 2, 2, 'Lâmpada LED de 15W com alta eficiência energética', TRUE),
                                                                                                                                     ('Geladeira', 200.00, 10, 3, 3, 'Geladeira de 300 litros, com congelador embutido', FALSE);
