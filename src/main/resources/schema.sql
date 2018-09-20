-- Table: public."infrastucture"

-- DROP TABLE public."infrastucture";

CREATE TABLE IF NOT EXISTS public.order_entity (order_id bigint NOT NULL, order_recipient character varying COLLATE pg_catalog."default" NOT NULL, order_sender character varying COLLATE pg_catalog."default" NOT NULL,order_date date NOT NULL DEFAULT ('now'::text)::date, order_state integer NOT NULL,CONSTRAINT pk_orderid PRIMARY KEY (order_id)) WITH (OIDS = FALSE) TABLESPACE pg_default;
