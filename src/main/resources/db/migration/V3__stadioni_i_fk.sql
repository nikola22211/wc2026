CREATE TABLE IF NOT EXISTS public.stadioni_wc
(
    id bigint GENERATED ALWAYS AS IDENTITY,
    naziv character varying(50) NOT NULL,
    mesto character varying(50) NOT NULL,
    kapacitet integer NOT NULL,

    CONSTRAINT stadioni_wc_pkey PRIMARY KEY (id)
);

ALTER TABLE public.wc2026
ADD CONSTRAINT fk_wc2026_stadion
FOREIGN KEY (stadion)
REFERENCES public.stadioni_wc(id);
