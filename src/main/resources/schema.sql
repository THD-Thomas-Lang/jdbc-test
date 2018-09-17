-- Table: public."infrastucture"

-- DROP TABLE public."infrastucture";

CREATE TABLE IF NOT EXISTS public."infrastucture" (orderid uuid NOT NULL DEFAULT uuid_generate_v4(),orderrecipient character varying COLLATE pg_catalog."default" NOT NULL,ordersender character varying COLLATE pg_catalog."default" NOT NULL,orderdate date NOT NULL DEFAULT ('now'::text)::date,orderstate integer NOT NULL,CONSTRAINT pk_orderid PRIMARY KEY (orderid)) WITH (OIDS = FALSE) TABLESPACE pg_default;
ALTER TABLE public."order" OWNER to postgres;