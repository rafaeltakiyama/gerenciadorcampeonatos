CREATE TABLE IF NOT EXISTS tbcampeonato(
	codCampeonato integer primary key autoincrement,
	nomeCampeonato TEXT
	);
CREATE INDEX idx_tbcampeonato on tbcampeonato(codCampeonato);
