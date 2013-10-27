CREATE TABLE IF NOT EXISTS tbcampenato(
	codCampeonato integer primary key autoincrement,
	nomeCampenato TEXT ,
	);
CREATE INDEX idx_tbcampenato on tbcampenato(codCampeonato);
