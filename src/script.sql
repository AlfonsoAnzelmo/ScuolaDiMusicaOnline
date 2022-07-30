use scuoladimusicavirtuale;
create table brano
(
    Titolo           varchar(20) not null
        primary key,
    Minuti           int         null,
    Secondi          int         null,
    DataComposizione int         null
);

create table categoriacorso
(
    nome varchar(30) not null,
    id   int auto_increment
        primary key
);

create table categoriastrumentimusicali
(
    immagine varchar(200) null,
    nome     varchar(30)  not null,
    id       int auto_increment
        primary key
);

create table corso
(
    Codice         int auto_increment
        primary key,
    NumeroLezioni  decimal     default 0  null,
    NumeroIscritti decimal     default 0  null,
    CostoTot       double      default 0  null,
    Insegnante     int                    null,
    Nome           varchar(30) default '' null,
    Durata         decimal     default 0  null,
    Categoria      int                    null
);

create table esame
(
    Corso       int                  not null,
    Studente    int                  not null,
    DataEsame   date                 not null,
    Nome        varchar(30)          not null,
    Voto        decimal(2)           not null,
    Difficolta  varchar(20)          not null,
    NumeroBrani decimal(1) default 1 null,
    primary key (Corso, Studente, DataEsame)
);

create table frequentarebystudente
(
    Studente int not null,
    Corso    int not null,
    primary key (Studente, Corso)
);

create table impararebyinsegnante
(
    Studente           int  not null,
    StrumentiMusicali  int  not null,
    DataInizioUtilizzo date null,
    primary key (Studente, StrumentiMusicali)
);

create table insegnante
(
    UtenteID     int default 0 not null
        primary key,
    Timbro       varchar(10)   null,
    AnniDiLavoro int           null,
    VocalCoach   tinyint(1)    null,
    Tipo         varchar(20)   null
);

create table lezione
(
    Corso       int          not null,
    DataLezione date         not null,
    Ora         decimal      not null,
    descrizione varchar(100) null,
    Aula        varchar(2)   null,
    Durata      decimal(3)   null,
    Prezzo      double       null,
    primary key (Corso, DataLezione, Ora)
);

create table riprodurre
(
    Corso     int         not null,
    Studente  int         not null,
    DataEsame date        not null,
    Brano     varchar(20) not null,
    primary key (Corso, Studente, DataEsame, Brano),
    constraint riprodurre_ibfk_1
        foreign key (Corso, Studente, DataEsame) references esame (Corso, Studente, DataEsame)
);

create table strumentimusicali
(
    Codice             int auto_increment
        primary key,
    CategoriaId        int          null,
    modello            varchar(30)  not null,
    quantita           int          not null,
    prezzo             double       not null,
    immaginePrincipale varchar(200) null
);

create table strumentimusicaliimmagini
(
    immagini varchar(200) null,
    Codice   int          null,
    id       int auto_increment
        primary key,
    constraint strumentimusicaliimmagini_ibfk_1
        foreign key (Codice) references strumentimusicali (Codice)
);

create index Codice
    on strumentimusicaliimmagini (Codice);

create table studente
(
    UtenteID        int         null,
    ScuolaSuperiore varchar(30) not null
);

create table suonare
(
    Insegnante        int not null,
    StrumentiMusicali int not null,
    primary key (Insegnante, StrumentiMusicali)
);

create table telefono
(
    Numero varchar(30) not null
        primary key,
    Utente varchar(4)  null
);

create table utente
(
    ID             int auto_increment
        primary key,
    Nome           varchar(20) not null,
    Cognome        varchar(20) not null,
    DataNascita    varchar(20) not null,
    Email          varchar(30) not null,
    Password       varchar(30) not null,
    Via            varchar(30) null,
    Citta          varchar(30) null,
    Cap            varchar(30) null,
    NumeroTelefono varchar(30) null
);

create table carrello
(
    UtenteID                int not null,
    Corso                   int not null,
    CodiceStrumentoMusicale int not null,
    primary key (UtenteID, CodiceStrumentoMusicale, Corso),
    constraint carrello_ibfk_1
        foreign key (CodiceStrumentoMusicale) references strumentimusicali (Codice),
    constraint carrello_ibfk_2
        foreign key (Corso) references corso (Codice),
    constraint carrello_ibfk_3
        foreign key (UtenteID) references utente (ID)
);


