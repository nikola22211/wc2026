CREATE TABLE IF NOT EXISTS public.stadioni_wc
(
    id bigint GENERATED ALWAYS AS IDENTITY,
    naziv character varying(50) NOT NULL,
    mesto character varying(50) NOT NULL,
    kapacitet integer NOT NULL,

    CONSTRAINT stadioni_wc_pkey PRIMARY KEY (id)
);

INSERT INTO stadioni_wc (naziv,mesto,kapacitet) VALUES ('Coca cola arena','Hjuston','45000');
INSERT INTO stadioni_wc (naziv,mesto,kapacitet) VALUES ('BC stadium','Atlanta','30000');
INSERT INTO stadioni_wc (naziv,mesto,kapacitet) VALUES ('Boston stadium','Boston','55000');
INSERT INTO stadioni_wc (naziv,mesto,kapacitet) VALUES ('Pens','Pensilvanija','51000');

ALTER TABLE public.wc2026
ADD CONSTRAINT fk_wc2026_stadion
FOREIGN KEY (stadion)
REFERENCES public.stadioni_wc(id);
