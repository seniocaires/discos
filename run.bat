@echo off
echo Iniciando Hypersonic SQL
java -cp hsqldb.jar org.hsqldb.Server -port 8090 -database.0 disco -dbname.0 disco
echo Pronto
