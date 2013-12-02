
CREATE TABLE IF NOT EXISTS tbrodada(
	codRodada integer primary key autoincrement,
  numeroRodada integer not null,
	codCampeonatoRodada integer,
	FOREIGN KEY(codCampeonatoRodada) REFERENCES tbcampeonato(codCampeonato)
	);
CREATE UNIQUE INDEX idx_tbrodada on tbrodada(codRodada);


CREATE TABLE IF NOT EXISTS tbpartida(               
	codPartida integer primary key autoincrement,            
    codRodadaPartida integer,                         
    codJuizPartida integer,                      
  	codEstadioPartida integer,                   
  	codTime1Partida integer,                     
  	codTime2Partida integer,                     
  FOREIGN KEY(codRodadaPartida) REFERENCES [tbrodada]([codRodada]),
	FOREIGN KEY(codJuizPartida) REFERENCES [tbjuiz]([codJuiz]),
	FOREIGN KEY(codEstadioPartida) REFERENCES [tbestadio]([codEstadio]),
	FOREIGN KEY(codTime1Partida) REFERENCES [tbtime]([codTime]),
	FOREIGN KEY(codTime2Partida) REFERENCES [tbtime]([codTime])
	);                                                
CREATE INDEX idx_tbpartida on tbpartida(codPartida);

CREATE TABLE IF NOT EXISTS tbtime(
	codTime integer primary key autoincrement,
	nomeTime TEXT
	);
CREATE UNIQUE INDEX idx_tbtime on tbtime(codTime);

CREATE TABLE IF NOT EXISTS tbcampeonato(
	codCampeonato integer primary key autoincrement,
	nomeCampeonato TEXT
	);
CREATE UNIQUE INDEX idx_tbcampeonato on tbcampeonato(codCampeonato);

CREATE TABLE IF NOT EXISTS tbestadio(
	codEstadio integer primary key autoincrement,
	nomeEstadio TEXT
	);
CREATE UNIQUE INDEX idx_tbestadio on tbestadio(codEstadio);

CREATE TABLE IF NOT EXISTS tbjogador(
	codJogador integer primary key autoincrement,
	nomeJogador TEXT
	);
CREATE UNIQUE INDEX idx_tbjogador on tbjogador(codJogador);

CREATE TABLE IF NOT EXISTS tbjuiz(
	codJuiz integer primary key autoincrement,
	nomeJuiz TEXT
	);
CREATE UNIQUE INDEX idx_tbjuiz on tbjuiz(codJuiz);

CREATE TABLE IF NOT EXISTS tb_jogador_time_campeonato(
  codJogadorTimeCampeonato integer primary key autoincrement,
	campeonato integer,
	times integer,
	jogador integer,
	FOREIGN KEY(campeonato) REFERENCES tbcampeonato(codCampeonato)
	FOREIGN KEY(times) REFERENCES [tbtime]([codTime])
	FOREIGN KEY(jogador) REFERENCES [tbjogador]([codJogador])
	);
CREATE UNIQUE INDEX idx_tb_jogador_time_campeonato on tb_jogador_time_campeonato(codJogadorTimeCampeonato);