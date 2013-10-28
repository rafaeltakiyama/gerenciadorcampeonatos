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

CREATE TABLE IF NOT EXISTS tbjuiz(
	codJuiz integer primary key autoincrement,
	nomeJuiz TEXT
	);
CREATE INDEX idx_tbjuiz on tbjuiz(codJuiz);

CREATE TABLE IF NOT EXISTS tbtime(
	codTime integer primary key autoincrement,
	nomeTime TEXT
	);
CREATE INDEX idx_tbtime on tbtime(codTime);