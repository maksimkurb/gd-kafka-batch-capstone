create table report (
    date date not null,
    serial_number varchar(50) not null,
    model varchar(100) not null,
    capacity_bytes BIGINT,
    failure BIGINT,
    processed BOOLEAN not null default false,
    smart_1 int,
    smart_2 int,
    smart_3 int,
    smart_4 int,
    smart_5 int,
    smart_7 int,
    smart_8 int,
    smart_9 int,
    smart_10 int,
    smart_11 int,
    smart_12 int,
    smart_13 int,
    smart_15 int,
    smart_16 int,
    smart_17 int,
    smart_22 int,
    smart_23 int,
    smart_24 int,
    smart_168 int,
    smart_170 int,
    smart_173 int,
    smart_174 int,
    smart_177 int,
    smart_179 int,
    smart_181 int,
    smart_182 int,
    smart_183 int,
    smart_184 int,
    smart_187 int,
    smart_188 int,
    smart_189 int,
    smart_190 int,
    smart_191 int,
    smart_192 int,
    smart_193 int,
    smart_194 int,
    smart_195 int,
    smart_196 int,
    smart_197 int,
    smart_198 int,
    smart_199 int,
    smart_200 int,
    smart_201 int,
    smart_218 int,
    smart_220 int,
    smart_222 int,
    smart_223 int,
    smart_224 int,
    smart_225 int,
    smart_226 int,
    smart_231 int,
    smart_232 int,
    smart_233 int,
    smart_235 int,
    smart_240 int,
    smart_241 int,
    smart_242 int,
    smart_250 int,
    smart_251 int,
    smart_252 int,
    smart_254 int,
    smart_255 int,
    PRIMARY KEY(model, serial_number, date)
);

CREATE INDEX report_date_idx ON report (date asc);
CREATE INDEX report_processed_idx ON report (processed asc);
