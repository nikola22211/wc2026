CREATE TABLE IF NOT EXISTS public.wc2026
(
    id bigint NOT NULL DEFAULT nextval('wc2026_id_seq'::regclass),
    tim1 character varying(50) COLLATE pg_catalog."default" NOT NULL,
    tim2 character varying(50) COLLATE pg_catalog."default" NOT NULL,
    rez character varying(10) COLLATE pg_catalog."default" NOT NULL,
    faza character varying(20) COLLATE pg_catalog."default" NOT NULL DEFAULT 'Grupna'::character varying,
    datum date,
    stadion integer NOT NULL,
    CONSTRAINT wc2026_pkey PRIMARY KEY (id)
)