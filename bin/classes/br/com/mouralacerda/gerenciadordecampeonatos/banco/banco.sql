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

CREATE TABLE IF NOT EXISTS tbrodada(
	codRodada integer primary key autoincrement,
	codCampeonatoRodada integer,
	FOREIGN KEY(codCampeonatoRodada) REFERENCES tbcampeonato(codCampeonato)
	);
CREATE INDEX idx_tbrodada on tbrodada(codRodada);

CREATE TABLE IF NOT EXISTS tbpartida(
	codPartida integer primary key autoincrement,
	codRodadaPartida integer,
	codCampeonatoPartida integer,
  codJuizPartida integer,  
  codEstadioPartida integer,  
  codTimePartida integer,
	FOREIGN KEY(codRodadaPartida) REFERENCES [tbrodada]([codRodada])
	FOREIGN KEY(codCampeonatoPartida) REFERENCES [tbcampeonato]([codCampeonato])
	FOREIGN KEY(codJuizPartida) REFERENCES [tbjuiz]([codJuiz])
	FOREIGN KEY(codEstadioPartida) REFERENCES [tbestadio]([codEstadio])
	FOREIGN KEY(codTimePartida) REFERENCES [tbtime]([codTime])
	);
CREATE INDEX idx_tbpartida on tbpartida(codPartida);


CREATE TABLE IF NOT EXISTS tb_jogador_time_campeonato(
	codCampeonato integer,
	codTime integer,
	codJogador integer,
	FOREIGN KEY(codCampeonato) REFERENCES tbcampeonato(codCampeonato)
	FOREIGN KEY(codTime) REFERENCES [tbtime]([codTime])
	FOREIGN KEY(codJogador) REFERENCES [tbjogador]([codJogador])
	);