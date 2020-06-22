
DELETE FROM model_file;

INSERT INTO model_file (id, filename, model, start_time, variable_name, path, file_info) VALUES
(1, 'daily_bcccsm_2020040600_PRECT.nc', 'S2S_T226', '20200406', 'PRECT', '/Operational_Prediction/S2S_T226/PRECT/20200406','file_info1'),
(2, 'daily_bcccsm_2020040600p01_PRECT.nc', 'S2S_T226', '20200406', 'PRECT', '/Operational_Prediction/S2S_T226/PRECT/20200406','file_info2'),
(3, 'daily_bcccsm_2020040600_T.nc', 'S2S_T226', '20200406', 'T', '/Operational_Prediction/S2S_T226/T/20200406','file_info3'),
(4, 'daily_bcccsm_2020040700_T.nc', 'S2S_T226', '20200407', 'T', '/Operational_Prediction/S2S_T226/PRECT/20200407','file_info4'),
(5, '20200101.atm.T.202001-202101_prs0010_member.nc', 'Seasonal_T106', '20200101', 'T', '/Operational_Prediction/Seasonal_T106/T/20200101','file_info5')