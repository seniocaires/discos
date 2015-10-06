@echo off
cmd/c start javaw -cp hsqldb.jar org.hsqldb.util.DatabaseManagerSwing -driver org.hsqldb.jdbcDriver -url jdbc:hsqldb:hsql://localhost:8090/disco
