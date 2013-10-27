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

CREATE TABLE IF NOT EXISTS tbjogador(
	codJogador integer primary key autoincrement,
	nomeJogador TEXT
	);
CREATE INDEX idx_tbjogador on tbjogador(codJogador);