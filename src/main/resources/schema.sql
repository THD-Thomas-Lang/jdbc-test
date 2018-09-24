-- Table: public."infrastucture"

-- DROP TABLE public."infrastucture";

CREATE TABLE IF NOT EXISTS public.order_entity (order_id SERIAL PRIMARY KEY, order_recipient character varying NOT NULL, order_sender character varying NOT NULL,order_date date NOT NULL DEFAULT ('now'::text)::date, order_state character varying);
