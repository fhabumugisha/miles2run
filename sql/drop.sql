alter table Activity drop foreign key FK_qycl77kjdrp0he46kb3b5s11r
alter table Activity drop foreign key FK_gvmlodlf4nppv8rv72uv30c0x
alter table Activity drop foreign key FK_f7apr5s9xrv25p4tq2tyevhqw
alter table Goal drop foreign key FK_1yn5gab01pm9j0ecdpo7if45h
alter table SocialConnection drop foreign key FK_shlweto6or6fd0fuasapasmnn
drop table if exists Activity
drop table if exists Goal
drop table if exists Profile
drop table if exists Share
drop table if exists SocialConnection
drop table if exists hibernate_sequence
