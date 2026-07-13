CREATE TABLE IF NOT EXISTS public.stadioni_wc
(
    id bigint GENERATED ALWAYS AS IDENTITY,
    naziv character varying(50) NOT NULL,
    mesto character varying(50) NOT NULL,
    kapacitet integer NOT NULL,
);

INSERT INTO stadioni_wc (id,naziv,mesto,kapacitet) VALUES (1,'Coca cola arena','Hjuston','45000');

ALTER TABLE public.wc2026
ADD CONSTRAINT fk_wc2026_stadion
FOREIGN KEY (stadion)
REFERENCES public.stadioni_wc(id);
