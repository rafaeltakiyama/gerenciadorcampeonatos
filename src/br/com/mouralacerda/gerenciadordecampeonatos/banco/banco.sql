CREATE TABLE IF NOT EXISTS tbcampeonato(
	codCampeonato integer primary key autoincrement,
	nomeCampeonato TEXT
	);
CREATE INDEX idx_tbcampeonato on tbcampeonato(codCampeonato);

CREATE TABLE IF NOT EXISTS tbestadio(
	codEstadio integer primary key autoincrement,
	nomeEstadio TEXT
	);
CREATE INDEX idx_tbestadio on tbestadio(codEstadio);