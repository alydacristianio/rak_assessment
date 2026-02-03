-- Test file for sql queries

INSERT INTO receipts (student_id, student_name, grade, school_name, fee_amount, payment_mode, payment_date, receipt_number) VALUES
(1, 'Ali Motiwala', '10', 'Manchester', 5000, 'CASH', CURRENT_DATE, 'RCP-001'),
(2, 'Ronaldo', '9', 'Madrid', 4500, 'CARD', CURRENT_DATE, 'RCP-002'),
(3, 'Zidane', '11', 'France', 5500, 'ONLINE', CURRENT_DATE, 'RCP-003');